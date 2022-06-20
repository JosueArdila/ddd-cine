package co.com.sofka.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Correo implements ValueObject<String> {

    private final String correo;

    public Correo(String correo) {
        Objects.requireNonNull(correo);
        if (correo.isBlank()) {
            throw new IllegalArgumentException("El correo no debe estar vacio");
        }
        if (!validarCorreoValido(correo)) {
            throw new IllegalArgumentException("El correo no es valido");
        }
        this.correo = correo;
    }

    @Override
    public String value() {
        return correo;
    }

    private boolean validarCorreoValido(String correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.find();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo1 = (Correo) o;
        return correo.equals(correo1.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }
}
