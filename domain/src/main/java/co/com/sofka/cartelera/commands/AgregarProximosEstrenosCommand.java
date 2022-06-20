package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.factories.EstrenoProximoFactory;
import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.domain.generic.Command;

public class AgregarProximosEstrenosCommand extends Command {

    private final CarteleraId carteleraId;
    private final EstrenoProximoFactory factory;

    public AgregarProximosEstrenosCommand(CarteleraId carteleraId, EstrenoProximoFactory factory) {
        this.carteleraId = carteleraId;
        this.factory = factory;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public EstrenoProximoFactory getFactory() {
        return factory;
    }
}
