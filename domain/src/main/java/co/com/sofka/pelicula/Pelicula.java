package co.com.sofka.pelicula;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.entities.Actor;
import co.com.sofka.pelicula.entities.Calificacion;
import co.com.sofka.pelicula.entities.Director;
import co.com.sofka.pelicula.events.*;
import co.com.sofka.pelicula.factories.ActorFactory;
import co.com.sofka.pelicula.factories.CalificacionFactory;
import co.com.sofka.pelicula.identities.DirectorId;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Duracion;
import co.com.sofka.pelicula.values.GeneroPelicula;
import co.com.sofka.pelicula.values.Resolucion;

import java.util.List;
import java.util.Set;

public class Pelicula extends AggregateEvent<PeliculaId> {

    protected Set<Calificacion> calificaciones;
    protected Set<Actor> actores;
    protected Director director;
    protected Descripcion descripcion;
    protected Duracion duracion;
    protected Resolucion resolucion;
    protected GeneroPelicula generoPelicula;

    public Pelicula(PeliculaId entityId, Descripcion descripcion, Duracion duracion, Resolucion resolucion, GeneroPelicula generoPelicula) {
        super(entityId);
        subscribe(new PeliculaChange(this));
        appendChange(new PeliculaCreada(descripcion, duracion, resolucion, generoPelicula)).apply();
    }

    private Pelicula(PeliculaId peliculaId) {
        super(peliculaId);
        subscribe(new PeliculaChange(this));
    }

    public static Pelicula from(PeliculaId peliculaId, List<DomainEvent> events) {
        var pelicula = new Pelicula(peliculaId);
        events.forEach(pelicula::applyEvent);
        return pelicula;
    }

    public void asignarDirector(DirectorId directorId, Nombre nombre, Genero genero) {
        appendChange(new DirectorAsignado(directorId, nombre, genero)).apply();
    }

    public void agregarActores(ActorFactory actorFactory) {
        actorFactory.actores()
                .forEach(actor -> {
                    appendChange(
                            new ActorAgregado(actor.identity(), actor.rol(), actor.nombre(), actor.genero())
                    ).apply();
                });
    }

    public void agregarCalificaciones(CalificacionFactory calificacionFactory) {
        calificacionFactory.calificaciones()
                .forEach(calificacion -> {
                    appendChange(
                            new CalificacionAgregada(calificacion.identity(), calificacion.descripcion(), calificacion.puntaje())
                    ).apply();
                });
    }

    public void cambiarDescripcion(Descripcion descripcion) {
        appendChange(new DescripcionCambiada(descripcion)).apply();
    }

    public void cambiarDuracion(Duracion duracion) {
        appendChange(new DuracionCambiada(duracion)).apply();
    }

    public void cambiarResolucion(Resolucion resolucion) {
        appendChange(new ResolucionCambiada(resolucion)).apply();
    }

    public void cambiarDescripcion(GeneroPelicula generoPelicula) {
        appendChange(new GeneroCambiado(generoPelicula)).apply();
    }




}
