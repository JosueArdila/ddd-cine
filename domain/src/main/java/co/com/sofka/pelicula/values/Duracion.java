package co.com.sofka.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Duracion implements ValueObject<Integer> {

    private final int minutos;

    public Duracion(int minutos) {
        if(minutos < 0) {
            throw new IllegalArgumentException("La duracion no debe ser menor a cero");
        }
        this.minutos = minutos;
    }

    @Override
    public Integer value() {
        return minutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duracion duracion1 = (Duracion) o;
        return minutos == duracion1.minutos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutos);
    }
}
