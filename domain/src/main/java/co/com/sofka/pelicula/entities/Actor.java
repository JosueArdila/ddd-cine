package co.com.sofka.pelicula.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.identities.ActorId;
import co.com.sofka.pelicula.values.Rol;

import java.util.Objects;

public class Actor extends Entity<ActorId> {

    private Rol rol;
    private Nombre nombre;
    private Genero genero;

    public Actor(ActorId entityId, Rol rol, Nombre nombre, Genero genero) {
        super(entityId);
        this.rol = rol;
        this.nombre = nombre;
        this.genero = genero;
    }

    public Rol rol() {
        return rol;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Genero genero() {
        return genero;
    }

    public void cambiarRol(Rol rol) {
        this.rol = Objects.requireNonNull(rol);
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void cambiarGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }
}
