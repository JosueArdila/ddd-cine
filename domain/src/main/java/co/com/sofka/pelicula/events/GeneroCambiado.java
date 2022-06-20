package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.values.GeneroPelicula;

public class GeneroCambiado extends DomainEvent {
    private final GeneroPelicula generoPelicula;

    public GeneroCambiado(GeneroPelicula generoPelicula) {
        super("sofka.pelicula.GeneroCambiado");
        this.generoPelicula = generoPelicula;
    }

    public GeneroPelicula getGeneroPelicula() {
        return generoPelicula;
    }
}
