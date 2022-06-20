package co.com.sofka.pelicula.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.pelicula.identities.CalificacionId;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Puntaje;

import java.util.Objects;

public class Calificacion extends Entity<CalificacionId> {

    private Descripcion descripcion;
    private Puntaje puntaje;

    public Calificacion(CalificacionId entityId, Descripcion descripcion, Puntaje puntaje) {
        super(entityId);
        this.descripcion = descripcion;
        this.puntaje = puntaje;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Puntaje puntaje() {
        return puntaje;
    }

    public void cambiarDescripcion(Descripcion descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public void cambiarPuntaje(Puntaje puntaje) {
        this.puntaje = Objects.requireNonNull(puntaje);
    }
}
