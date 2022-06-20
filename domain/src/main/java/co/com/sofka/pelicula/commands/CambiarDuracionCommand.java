package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.identities.PeliculaId;
import co.com.sofka.pelicula.values.Duracion;

public class CambiarDuracionCommand extends Command {

    private final PeliculaId peliculaId;
    private final Duracion duracion;

    public CambiarDuracionCommand(PeliculaId peliculaId, Duracion duracion) {
        this.peliculaId = peliculaId;
        this.duracion = duracion;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Duracion getDuracion() {
        return duracion;
    }
}
