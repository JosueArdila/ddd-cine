package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.commands.AsignarAcomodadorCommand;
import co.com.sofka.funcion.events.AcomodadorAsignado;
import co.com.sofka.funcion.events.FuncionCreada;
import co.com.sofka.funcion.identities.AcomodadorId;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.generic.values.*;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.generic.values.Genero.Generos.MASCULINO;
import static co.com.sofka.generic.values.Identificacion.TipoDocumento.CC;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsignarAcomodadorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AsignarAcomodadorUseCase useCase;


    @Test
    public void asignarAcomodador() {

        // arrange
        FuncionId id = new FuncionId();
        AcomodadorId acomodadorId = AcomodadorId.of("3210");
        Nombre nombre = new Nombre("Felipe Rosales");
        Identificacion identificacion = new Identificacion(CC, 123456);
        Genero genero = new Genero(MASCULINO);

        var command = new AsignarAcomodadorCommand(id, acomodadorId, nombre, identificacion, genero);
        when(repository.getEventsBy(id.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (AcomodadorAsignado) events.get(0);
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals("3210", event.getEntityId().value());
        Assertions.assertEquals("Felipe Rosales", event.getNombre().value());
        Assertions.assertEquals("CC123456", event.getIdentificacion().value());
        Assertions.assertEquals(MASCULINO, event.getGenero().value());

    }

    private List<DomainEvent> obtenerHistorial() {
        PeliculaId peliculaId = PeliculaId.of("xxx");
        Hora hora = new Hora(12, 45);
        Fecha fecha = new Fecha(19, 06, 2022);
        return List.of(
                new FuncionCreada(peliculaId, hora, fecha)
        );
    }
}
