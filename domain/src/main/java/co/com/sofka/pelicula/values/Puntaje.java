package co.com.sofka.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Puntaje implements ValueObject<Integer> {

    private final Integer valor;

    public Puntaje(int valor) {
        if(valor <0) {
            throw new IllegalArgumentException("el valor no puede ser menor a cero");
        }
        if(valor > 10) {
            throw new IllegalArgumentException("el valor no puede ser mayor a diez");
        }
        this.valor = valor;
    }

    @Override
    public Integer value() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntaje puntaje = (Puntaje) o;
        return valor.intValue() == puntaje.valor.intValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
