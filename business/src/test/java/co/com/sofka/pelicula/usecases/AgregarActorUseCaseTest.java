package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.commands.AgregarActorCommand;
import co.com.sofka.pelicula.events.ActorAgregado;
import co.com.sofka.pelicula.events.PeliculaCreada;
import co.com.sofka.pelicula.factories.ActorFactory;
import co.com.sofka.pelicula.identities.ActorId;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.generic.values.Genero.Generos.FEMENINO;
import static co.com.sofka.generic.values.Genero.Generos.MASCULINO;
import static co.com.sofka.pelicula.values.GeneroPelicula.Genero.CIENCIA_FICCION;
import static co.com.sofka.pelicula.values.Resolucion.Formato.FULLHD;
import static co.com.sofka.pelicula.values.Rol.Roles.PROTAGONISTA;
import static co.com.sofka.pelicula.values.Rol.Roles.SECUNDARIO;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarActorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarActorUseCase useCase;

    @Test
    public void agregarActores() {

        // arrange
        ActorFactory factory = ActorFactory.getInstance()
                .add(ActorId.of("XXX"), new Rol(PROTAGONISTA), new Nombre("Keanu Reeves"), new Genero(MASCULINO))
                .add(ActorId.of("YYY"), new Rol(PROTAGONISTA), new Nombre("Carrie-Anne Moss"), new Genero(FEMENINO))
                .add(ActorId.of("ZZZ"), new Rol(SECUNDARIO), new Nombre("Marcus Chong"), new Genero(MASCULINO));

        PeliculaId id = new PeliculaId();
        var command = new AgregarActorCommand(id, factory);
        when(repository.getEventsBy(id.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(3, events.size());
    }

    private List<DomainEvent> obtenerHistorial() {
        Descripcion descripcion = new Descripcion("Matrix");
        Duracion duracion = new Duracion(120);
        Resolucion resolucion = new Resolucion(FULLHD);
        GeneroPelicula generoPelicula = new GeneroPelicula(CIENCIA_FICCION);
        return List.of(
                new PeliculaCreada(descripcion, duracion, resolucion, generoPelicula),
                new ActorAgregado(ActorId.of("AAA"),
                        new Rol(PROTAGONISTA),
                        new Nombre("Laurence Fishburne"),
                        new Genero(MASCULINO)

                ));
    }
}
