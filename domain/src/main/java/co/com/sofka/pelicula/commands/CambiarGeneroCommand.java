package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.GeneroPelicula;

public class CambiarGeneroCommand extends Command {

    private final PeliculaId peliculaId;
    private final GeneroPelicula generoPelicula;

    public CambiarGeneroCommand(PeliculaId peliculaId, GeneroPelicula generoPelicula) {
        this.peliculaId = peliculaId;
        this.generoPelicula = generoPelicula;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public GeneroPelicula getGeneroPelicula() {
        return generoPelicula;
    }
}
