package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.commands.AgregarCalificacionCommand;
import co.com.sofka.pelicula.events.CalificacionAgregada;
import co.com.sofka.pelicula.events.PeliculaCreada;
import co.com.sofka.pelicula.factories.CalificacionFactory;
import co.com.sofka.pelicula.identities.CalificacionId;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.pelicula.values.GeneroPelicula.Genero.CIENCIA_FICCION;
import static co.com.sofka.pelicula.values.Resolucion.Formato.FULLHD;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarCalificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarCalificacionUseCase useCase;


    @Test
    public void agregarCalificaciones() {

        // arrange
        CalificacionFactory factory = CalificacionFactory.getInstance()
                .add(CalificacionId.of("10"), new Descripcion("extredamente buena"), new Puntaje(10))
                .add(CalificacionId.of("11"), new Descripcion("En ocasiones no fue clara la trama"), new Puntaje(8))
                .add(CalificacionId.of("12"), new Descripcion("Me encanta el papel de neo y trinity"), new Puntaje(10))
                .add(CalificacionId.of("13"), new Descripcion("Genial peli en familia"), new Puntaje(9));


        PeliculaId peliculaId = new PeliculaId();
        AgregarCalificacionCommand command = new AgregarCalificacionCommand(peliculaId, factory);
        when(repository.getEventsBy(peliculaId.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(4, events.size());

    }

    private List<DomainEvent> obtenerHistorial() {
        Descripcion descripcion = new Descripcion("Matrix");
        Duracion duracion = new Duracion(120);
        Resolucion resolucion = new Resolucion(FULLHD);
        GeneroPelicula generoPelicula = new GeneroPelicula(CIENCIA_FICCION);
        return List.of(
                new PeliculaCreada(descripcion, duracion, resolucion, generoPelicula),
                new CalificacionAgregada(CalificacionId.of("9"),
                        new Descripcion("me dormi en una parte de la pelicula"),
                        new Puntaje(6)
                ));
    }

}
