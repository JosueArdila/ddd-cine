package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.identities.ActorId;
import co.com.sofka.pelicula.values.Rol;

public class ActorAgregado extends DomainEvent {

    private final ActorId identity;
    private final Rol rol;
    private final Nombre nombre;
    private final Genero genero;

    public ActorAgregado(ActorId identity, Rol rol, Nombre nombre, Genero genero) {
        super("sofka.pelicula.ActorAgregado");
        this.identity = identity;
        this.rol = rol;
        this.nombre = nombre;
        this.genero = genero;
    }

    public ActorId getIdentity() {
        return identity;
    }

    public Rol getRol() {
        return rol;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }
}
