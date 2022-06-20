package co.com.sofka.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.identities.PeliculaId;

public class PeliculaDeCarteleraEliminada extends DomainEvent {
    private final PeliculaId peliculaId;

    public PeliculaDeCarteleraEliminada(PeliculaId peliculaId) {
        super("sofka.cartelera.PeliculaDeCarteleraEliminada");
        this.peliculaId = peliculaId;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
