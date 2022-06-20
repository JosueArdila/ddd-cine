package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.Command;

public class CambiarEstadoCommand extends Command {

    private final CarteleraId carteleraId;
    private final Estado estado;

    public CambiarEstadoCommand(CarteleraId carteleraId, Estado estado) {
        this.carteleraId = carteleraId;
        this.estado = estado;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public Estado getEstado() {
        return estado;
    }
}
