package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;

public class CarteleraCreada extends DomainEvent {

    private final Estado estado;

    public CarteleraCreada(Estado estado) {
        super("sofka.cartelera.CarteleraCreada");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
