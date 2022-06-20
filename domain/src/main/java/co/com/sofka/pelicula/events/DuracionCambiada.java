package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.values.Duracion;

public class DuracionCambiada extends DomainEvent {
    private final Duracion duracion;

    public DuracionCambiada(Duracion duracion) {
        super("sofka.pelicula.DuracionCambiada");
        this.duracion = duracion;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
