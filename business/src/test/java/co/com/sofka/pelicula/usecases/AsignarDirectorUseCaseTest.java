package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.commands.AsignarDirectorCommand;
import co.com.sofka.pelicula.events.DirectorAsignado;
import co.com.sofka.pelicula.events.PeliculaCreada;
import co.com.sofka.pelicula.identities.DirectorId;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Duracion;
import co.com.sofka.pelicula.values.GeneroPelicula;
import co.com.sofka.pelicula.values.Resolucion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.generic.values.Genero.Generos.FEMENINO;
import static co.com.sofka.pelicula.values.GeneroPelicula.Genero.CIENCIA_FICCION;
import static co.com.sofka.pelicula.values.Resolucion.Formato.FULLHD;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AsignarDirectorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AsignarDirectorUseCase useCase;

    @Test
    public void asignarDirector() {

        // arrange
        Nombre nombre = new Nombre("Lana Wachowski");
        Genero genero = new Genero(FEMENINO);

        var peliculaId = new PeliculaId();
        var command = new AsignarDirectorCommand(peliculaId, DirectorId.of("123"), nombre, genero);
        when(repository.getEventsBy(peliculaId.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (DirectorAsignado) events.get(0);
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals("Lana Wachowski", event.getNombre().value());
        Assertions.assertEquals(FEMENINO, event.getGenero().value());
    }

    private List<DomainEvent> obtenerHistorial() {
        Descripcion descripcion = new Descripcion("Matrix");
        Duracion duracion = new Duracion(120);
        Resolucion resolucion = new Resolucion(FULLHD);
        GeneroPelicula generoPelicula = new GeneroPelicula(CIENCIA_FICCION);
        return List.of(
                new PeliculaCreada(descripcion, duracion, resolucion, generoPelicula));
    }
}
