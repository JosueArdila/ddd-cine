package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.commands.CrearPeliculaCommand;
import co.com.sofka.pelicula.events.PeliculaCreada;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Duracion;
import co.com.sofka.pelicula.values.GeneroPelicula;
import co.com.sofka.pelicula.values.Resolucion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static co.com.sofka.pelicula.values.GeneroPelicula.Genero.CIENCIA_FICCION;
import static co.com.sofka.pelicula.values.Resolucion.Formato.FULLHD;

public class CrearPeliculaUseCaseTest {

    @Test
    public void crearUbicacion() {

        // arrange
        Descripcion descripcion = new Descripcion("Matrix");
        Duracion duracion = new Duracion(120);
        Resolucion resolucion = new Resolucion(FULLHD);
        GeneroPelicula generoPelicula = new GeneroPelicula(CIENCIA_FICCION);

        CrearPeliculaCommand command = new CrearPeliculaCommand(descripcion, duracion, resolucion, generoPelicula);

        CrearPeliculaUseCase useCase = new CrearPeliculaUseCase();

        // act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        // assert
        PeliculaCreada event = (PeliculaCreada) events.get(0);
        Assertions.assertEquals("Matrix", event.getDescripcion().value());
        Assertions.assertEquals(120, event.getDuracion().value());
        Assertions.assertEquals(FULLHD, event.getResolucion().value());
        Assertions.assertEquals(CIENCIA_FICCION, event.getGeneroPelicula().value());
    }
}
