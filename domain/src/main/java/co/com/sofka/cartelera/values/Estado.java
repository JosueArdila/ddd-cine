package co.com.sofka.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<Estado.Estados> {

    private final Estados estado;

    public Estado(Estados estado) {
        this.estado = Objects.requireNonNull(estado);
    }

    @Override
    public Estados value() {
        return estado;
    }

    public enum Estados {
        ACTIVA, INACTIVA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado1 = (Estado) o;
        return estado == estado1.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado);
    }
}
