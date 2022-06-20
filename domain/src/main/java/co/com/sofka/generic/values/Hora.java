package co.com.sofka.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Hora implements ValueObject<String> {

    private final LocalTime hora;
    private final String formato;

    public Hora(int hora, int minutos) {
        try {
            this.hora = LocalTime.of(hora, minutos);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("La hora ingresada es incorrecta");
        }
        this.formato = generarFormato();
    }

    private String generarFormato() {
        return hora.format(DateTimeFormatter.ISO_TIME);
    }

    @Override
    public String value() {
        return formato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hora hora = (Hora) o;
        return formato.equals(hora.formato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}
