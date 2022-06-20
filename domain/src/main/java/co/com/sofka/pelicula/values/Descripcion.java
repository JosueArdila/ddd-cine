package co.com.sofka.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion);

        if(descripcion.isBlank()) {
            throw new IllegalArgumentException("la descripcion no debe estar vacia");
        }
    }

    @Override
    public String value() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return descripcion.equals(that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }
}
