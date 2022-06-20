package co.com.sofka.pelicula.factories;

import co.com.sofka.pelicula.entities.Calificacion;
import co.com.sofka.pelicula.identities.CalificacionId;
import co.com.sofka.pelicula.values.Descripcion;
import co.com.sofka.pelicula.values.Puntaje;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CalificacionFactory {

    private final Set<Calificacion> Calificaciones;

    private static CalificacionFactory instance;

    private CalificacionFactory() {
        Calificaciones = new HashSet<>();
    }

    public static CalificacionFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new CalificacionFactory();
            return instance;
        }
        return instance;
    }

    public CalificacionFactory add(CalificacionId entityId, Descripcion descripcion, Puntaje puntaje){
        Calificaciones.add(new Calificacion(entityId, descripcion, puntaje));
        return this;
    }

    public Set<Calificacion> calificaciones() {
        return Calificaciones;
    }
}
