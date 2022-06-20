package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.identities.DirectorId;

public class DirectorAsignado extends DomainEvent {
    private final DirectorId directorId;
    private final Nombre nombre;
    private final Genero genero;

    public DirectorAsignado(DirectorId directorId, Nombre nombre, Genero genero) {
        super("sofka.pelicula.DirectorAsignado");
        this.directorId = directorId;
        this.nombre = nombre;
        this.genero = genero;
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
