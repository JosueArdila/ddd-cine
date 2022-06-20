package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.values.Descripcion;

public class DescripcionCambiada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionCambiada(Descripcion descripcion) {
        super("sofka.pelicula.DescripcionCambiada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
