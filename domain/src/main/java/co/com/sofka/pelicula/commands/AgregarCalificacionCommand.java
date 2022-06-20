package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.factories.CalificacionFactory;
import co.com.sofka.pelicula.identities.PeliculaId;

public class AgregarCalificacionCommand extends Command {

    private final PeliculaId peliculaId;
    private final CalificacionFactory calificacionFactory;

    public AgregarCalificacionCommand(PeliculaId peliculaId, CalificacionFactory calificacionFactory) {
        this.peliculaId = peliculaId;
        this.calificacionFactory = calificacionFactory;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public CalificacionFactory getCalificacionFactory() {
        return calificacionFactory;
    }
}
