package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.Descripcion;

public class CambiarDescripcionCommand extends Command {

    private final PeliculaId peliculaId;
    private final Descripcion descripcion;

    public CambiarDescripcionCommand(PeliculaId peliculaId, Descripcion descripcion) {
        this.peliculaId = peliculaId;
        this.descripcion = descripcion;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
