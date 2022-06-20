package co.com.sofka.funcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoSala implements ValueObject<EstadoSala.Estados> {

    private final Estados estado;

    public EstadoSala(Estados estado) {
        this.estado = Objects.requireNonNull(estado);
    }

    @Override
    public Estados value() {
        return estado;
    }

    public enum Estados {
        ACTIVA, EN_MANTENIMIENTO, INACTIVA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoSala that = (EstadoSala) o;
        return estado == that.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado);
    }
}
