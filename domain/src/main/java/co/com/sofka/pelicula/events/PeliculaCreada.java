package co.com.sofka.pelicula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Duracion;
import co.com.sofka.pelicula.values.GeneroPelicula;
import co.com.sofka.pelicula.values.Resolucion;

public class PeliculaCreada extends DomainEvent {
    private final Descripcion descripcion;
    private final Duracion duracion;
    private final Resolucion resolucion;
    private final GeneroPelicula generoPelicula;

    public PeliculaCreada(Descripcion descripcion, Duracion duracion, Resolucion resolucion, GeneroPelicula generoPelicula) {
        super("sofka.pelicula.PeliculaCreada");
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.resolucion = resolucion;
        this.generoPelicula = generoPelicula;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Duracion getDuracion() {
        return duracion;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public GeneroPelicula getGeneroPelicula() {
        return generoPelicula;
    }
}
