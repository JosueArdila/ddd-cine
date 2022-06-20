package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoCambiado extends DomainEvent {
    private final Estado estado;

    public EstadoCambiado(Estado estado) {
        super("sofka.cartelera.EstadoCambiado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
