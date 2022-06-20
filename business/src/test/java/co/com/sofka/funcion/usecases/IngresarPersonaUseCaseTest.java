package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.commands.IngresarPersonaCommand;
import co.com.sofka.funcion.events.AcomodadorAsignado;
import co.com.sofka.funcion.events.FuncionCreada;
import co.com.sofka.funcion.events.PersonaIngresada;
import co.com.sofka.funcion.events.SalaAsignada;
import co.com.sofka.funcion.fatories.PersonaFactory;
import co.com.sofka.funcion.identities.AcomodadorId;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.funcion.identities.PersonaId;
import co.com.sofka.funcion.identities.SalaId;
import co.com.sofka.funcion.values.EstadoSala;
import co.com.sofka.funcion.values.Tipo;
import co.com.sofka.funcion.values.Ubicacion;
import co.com.sofka.generic.values.*;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.funcion.values.EstadoSala.Estados.ACTIVA;
import static co.com.sofka.funcion.values.Tipo.Tipos.SALA2D;
import static co.com.sofka.generic.values.Genero.Generos.FEMENINO;
import static co.com.sofka.generic.values.Genero.Generos.MASCULINO;
import static co.com.sofka.generic.values.Identificacion.TipoDocumento.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IngresarPersonaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    IngresarPersonaUseCase useCase;

    @Test
    public void ingresarPersonas() {
        // arrange

        PersonaFactory personaFactory = PersonaFactory.getInstance()
                .add(PersonaId.of("AA"), new Nombre("Andres Torres"), new Identificacion(CC, 789456), new Genero(MASCULINO))
                .add(PersonaId.of("BB"), new Nombre("Teofilo Guitierres"), new Identificacion(CC, 954687), new Genero(MASCULINO))
                .add(PersonaId.of("CC"), new Nombre("Camila Torres"), new Identificacion(CE, 22564), new Genero(FEMENINO))
                .add(PersonaId.of("DD"), new Nombre("Maria Lopez"), new Identificacion(TI, 0234560), new Genero(FEMENINO));

        FuncionId id = new FuncionId();
        var command = new IngresarPersonaCommand(id, personaFactory);
        when(repository.getEventsBy(id.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        Assertions.assertEquals(4, events.size());
    }

    private List<DomainEvent> obtenerHistorial() {
        PeliculaId peliculaId = PeliculaId.of("xxx");
        Hora hora = new Hora(12, 45);
        Fecha fecha = new Fecha(19, 06, 2022);
        return List.of(
                new FuncionCreada(peliculaId, hora, fecha),
                new AcomodadorAsignado(AcomodadorId.of("12"), new Nombre("Felipe Arenas"), new Identificacion(CE, 998877), new Genero(MASCULINO)),
                new SalaAsignada(SalaId.of("201"), new EstadoSala(ACTIVA), new Tipo(SALA2D), new Ubicacion("P01", "A01")),
                new PersonaIngresada(PersonaId.of("XS"), new Nombre("Laura Pausini"), new Identificacion(CC, 987654), new Genero(FEMENINO))
        );
    }
}
