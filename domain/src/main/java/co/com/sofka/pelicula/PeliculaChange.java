package co.com.sofka.pelicula;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.pelicula.entities.Actor;
import co.com.sofka.pelicula.entities.Calificacion;
import co.com.sofka.pelicula.entities.Director;
import co.com.sofka.pelicula.events.*;

import java.util.HashSet;

public class PeliculaChange extends EventChange {
    public PeliculaChange(Pelicula pelicula) {
        apply((PeliculaCreada event)-> {
            pelicula.descripcion = event.getDescripcion();
            pelicula.duracion = event.getDuracion();
            pelicula.resolucion = event.getResolucion();
            pelicula.generoPelicula = event.getGeneroPelicula();
            pelicula.calificaciones = new HashSet<>();
            pelicula.actores = new HashSet<>();
        });

        apply((DirectorAsignado event) -> {
            pelicula.director = new Director(event.getDirectorId(), event.getNombre(), event.getGenero());
        });

        apply((ActorAgregado event)-> {
            pelicula.actores.add(new Actor(event.getIdentity(), event.getRol(), event.getNombre(), event.getGenero()));
        });

        apply((CalificacionAgregada event) -> {
            pelicula.calificaciones.add(new Calificacion(event.getIdentity(), event.getDescripcion(), event.getPuntaje()));
        });

        apply((DescripcionCambiada event) -> {
            pelicula.descripcion = event.getDescripcion();
        });

        apply((DuracionCambiada event) -> {
            pelicula.duracion = event.getDuracion();
        });

        apply((ResolucionCambiada event)-> {
            pelicula.resolucion = event.getResolucion();
        });

        apply((GeneroCambiado event) -> {
            pelicula.generoPelicula = event.getGeneroPelicula();
        });
    }
}
