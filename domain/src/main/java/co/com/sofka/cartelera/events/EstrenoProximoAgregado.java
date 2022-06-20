package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.identities.EstrenoProximoId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.pelicula.identities.PeliculaId;

public class EstrenoProximoAgregado extends DomainEvent {
    private final EstrenoProximoId identity;
    private final Fecha fecha;
    private final PeliculaId peliculaId;

    public EstrenoProximoAgregado(EstrenoProximoId identity, Fecha fecha, PeliculaId peliculaId) {
        super("sofka.cartelera.EstrenoProximoAgregado");
        this.identity = identity;
        this.fecha = fecha;
        this.peliculaId = peliculaId;
    }

    public EstrenoProximoId getIdentity() {
        return identity;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
