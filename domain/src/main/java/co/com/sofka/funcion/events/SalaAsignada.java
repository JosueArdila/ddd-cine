package co.com.sofka.funcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.identities.SalaId;
import co.com.sofka.funcion.values.EstadoSala;
import co.com.sofka.funcion.values.Tipo;
import co.com.sofka.funcion.values.Ubicacion;

public class SalaAsignada extends DomainEvent {
    private final SalaId entityId;
    private final EstadoSala estadoSala;
    private final Tipo tipo;
    private final Ubicacion ubicacion;

    public SalaAsignada(SalaId entityId, EstadoSala estadoSala, Tipo tipo, Ubicacion ubicacion) {
        super("sofka.funcion.SalaAsignada");
        this.entityId = entityId;
        this.estadoSala = estadoSala;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public SalaId getEntityId() {
        return entityId;
    }

    public EstadoSala getEstadoSala() {
        return estadoSala;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
