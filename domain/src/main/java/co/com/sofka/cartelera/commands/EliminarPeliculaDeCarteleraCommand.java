package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.identities.PeliculaId;

public class EliminarPeliculaDeCarteleraCommand extends Command {

    private final CarteleraId carteleraId;
    private final PeliculaId peliculaId;

    public EliminarPeliculaDeCarteleraCommand(CarteleraId carteleraId, PeliculaId peliculaId) {
        this.carteleraId = carteleraId;
        this.peliculaId = peliculaId;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }
}
