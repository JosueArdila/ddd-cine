package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.values.Resolucion;

public class ResolucionCambiada extends DomainEvent {
    private final Resolucion resolucion;

    public ResolucionCambiada(Resolucion resolucion) {
        super("sofka.pelicula.ResolucionCambiada");
        this.resolucion = resolucion;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }
}
