package co.com.sofka.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rol implements ValueObject<Rol.Roles> {

    private final Roles rol;

    public Rol(Roles rol) {
        this.rol = Objects.requireNonNull(rol);
    }

    @Override
    public Roles value() {
        return rol;
    }

    public enum Roles {
        PROTAGONISTA, SECUNDARIO, RELLENO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol1 = (Rol) o;
        return rol == rol1.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol);
    }
}
