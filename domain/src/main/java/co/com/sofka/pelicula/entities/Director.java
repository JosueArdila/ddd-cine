package co.com.sofka.pelicula.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.identities.DirectorId;

import java.util.Objects;

public class Director extends Entity<DirectorId> {

    private Nombre nombre;
    private Genero genero;

    public Director(DirectorId entityId, Nombre nombre, Genero genero) {
        super(entityId);
        this.nombre = nombre;
        this.genero = genero;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Genero genero() {
        return genero;
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void cambiarGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }
}
