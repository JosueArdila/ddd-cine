package co.com.sofka.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Resolucion implements ValueObject<Resolucion.Formato> {

    private final Formato formato;

    public Resolucion(Formato formato) {
        this.formato = Objects.requireNonNull(formato);
    }

    @Override
    public Formato value() {
        return formato;
    }

    public enum Formato {
        FULLHD, FULL2K, FULL4K
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resolucion that = (Resolucion) o;
        return formato == that.formato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}
