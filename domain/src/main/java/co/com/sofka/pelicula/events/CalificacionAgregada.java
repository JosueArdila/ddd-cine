package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.identities.CalificacionId;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Puntaje;

public class CalificacionAgregada extends DomainEvent {

    private final CalificacionId identity;
    private final Descripcion descripcion;
    private final Puntaje puntaje;

    public CalificacionAgregada(CalificacionId identity, Descripcion descripcion, Puntaje puntaje) {
        super("sofka.pelicula.CalificacionAgregada");
        this.identity = identity;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
    }

    public CalificacionId getIdentity() {
        return identity;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }
}
