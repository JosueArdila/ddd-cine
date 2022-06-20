package co.com.sofka.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dia implements ValueObject<Dia.Dias> {

    private final Dias dia;

    public Dia(Dias dia) {
        this.dia = Objects.requireNonNull(dia);
    }

    @Override
    public Dias value() {
        return dia;
    }

    public enum Dias {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dia dia1 = (Dia) o;
        return dia == dia1.dia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia);
    }
}
