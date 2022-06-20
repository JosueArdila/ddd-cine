package co.com.sofka.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<Genero.Generos> {

    private final Generos genero;

    public Genero(Generos genero) {
        this.genero = Objects.requireNonNull(genero);
    }

    @Override
    public Generos value() {
        return genero;
    }

    public enum Generos {
        MASCULINO, FEMENINO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero1 = (Genero) o;
        return genero == genero1.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero);
    }
}
