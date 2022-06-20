package co.com.sofka.pelicula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class GeneroPelicula implements ValueObject<GeneroPelicula.Genero> {

    private final Genero genero;

    public GeneroPelicula(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }

    @Override
    public Genero value() {
        return genero;
    }

    public enum Genero {
        ACCION, AVENTURA, CIENCIA_FICCION, COMEDIA, DRAMA, FANTASIA, MUSICA, SUSPENSO, TERROR, BIOGRAFICO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneroPelicula that = (GeneroPelicula) o;
        return genero == that.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genero);
    }
}
