package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.commands.AsignarSalaCommand;
import co.com.sofka.funcion.events.FuncionCreada;
import co.com.sofka.funcion.events.SalaAsignada;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.funcion.identities.SalaId;
import co.com.sofka.funcion.values.EstadoSala;
import co.com.sofka.funcion.values.Tipo;
import co.com.sofka.funcion.values.Ubicacion;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.funcion.values.EstadoSala.Estados.ACTIVA;
import static co.com.sofka.funcion.values.Tipo.Tipos.ULTRA2D;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsignarSalaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AsignarSalaUseCase useCase;


    @Test
    public void asignarSala() {

        // arrange
        FuncionId id = new FuncionId();
        SalaId salaId = SalaId.of("XXX");
        EstadoSala estadoSala = new EstadoSala(ACTIVA);
        Tipo tipo = new Tipo(ULTRA2D);
        Ubicacion ubicacion = new Ubicacion("P01", "A3");

        var command = new AsignarSalaCommand(id, salaId, estadoSala, tipo, ubicacion);
        when(repository.getEventsBy(id.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SalaAsignada) events.get(0);
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals("XXX", event.getEntityId().value());
        Assertions.assertEquals(ACTIVA, event.getEstadoSala().value());
        Assertions.assertEquals(ULTRA2D, event.getTipo().value());
        Assertions.assertEquals("P01A3", event.getUbicacion().value());

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
