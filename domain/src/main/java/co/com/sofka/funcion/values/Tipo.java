package co.com.sofka.funcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<Tipo.Tipos> {

    private final Tipos tipo;

    public Tipo(Tipos tipo) {
        this.tipo = Objects.requireNonNull(tipo);
    }

    @Override
    public Tipos value() {
        return tipo;
    }

    public enum Tipos {
        SALA2D, SALA3D, ULTRA2D, ULTRAMAX
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo1 = (Tipo) o;
        return tipo == tipo1.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }
}
