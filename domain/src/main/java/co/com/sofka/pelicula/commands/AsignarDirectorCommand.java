package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.identities.DirectorId;
import co.com.sofka.pelicula.identities.PeliculaId;

public class AsignarDirectorCommand extends Command {

    private final PeliculaId peliculaId;
    private final DirectorId directorId;
    private final Nombre nombre;
    private final Genero genero;

    public AsignarDirectorCommand(PeliculaId peliculaId, DirectorId directorId, Nombre nombre, Genero genero) {
        this.peliculaId = peliculaId;
        this.directorId = directorId;
        this.nombre = nombre;
        this.genero = genero;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public DirectorId getDirectorId() {
        return directorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }
}
