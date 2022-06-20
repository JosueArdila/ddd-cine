package co.com.sofka.funcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.funcion.identities.AcomodadorId;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

import java.util.Objects;

public class Acomodador extends Entity<AcomodadorId> {

    private Nombre nombre;
    private Identificacion identificacion;
    private Genero genero;

    public Acomodador(AcomodadorId entityId, Nombre nombre, Identificacion identificacion, Genero genero) {
        super(entityId);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Identificacion identificacion() {
        return identificacion;
    }

    public Genero genero() {
        return genero;
    }

    public void editarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void editarGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }
}
