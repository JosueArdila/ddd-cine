package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.Resolucion;

public class CambiarResolucionCommand extends Command {

    private final PeliculaId peliculaId;
    private final Resolucion resolucion;

    public CambiarResolucionCommand(PeliculaId peliculaId, Resolucion resolucion) {
        this.peliculaId = peliculaId;
        this.resolucion = resolucion;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }
}
