package co.com.sofka.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Contrasena implements ValueObject<String> {

    private final String contrasena;

    public Contrasena(String contrasena) {
        this.contrasena = Objects.requireNonNull(contrasena);
        if(contrasena.isBlank()) {
            throw new IllegalArgumentException("el campo contraseña no debe estar vacio");
        }
    }

    @Override
    public String value() {
        return contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrasena that = (Contrasena) o;
        return contrasena.equals(that.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contrasena);
    }
}
