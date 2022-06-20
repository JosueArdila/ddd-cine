package co.com.sofka.pelicula.factories;

import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.entities.Actor;
import co.com.sofka.pelicula.identities.ActorId;
import co.com.sofka.pelicula.values.Rol;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ActorFactory {

    private final Set<Actor> actores;
    private static ActorFactory instance;

    private ActorFactory() {
        actores = new HashSet<>();
    }

    public static ActorFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new ActorFactory();
            return instance;
        }
        return instance;
    }

    public ActorFactory add(ActorId entityId, Rol rol, Nombre nombre, Genero genero){
        actores.add(new Actor(entityId, rol, nombre, genero));
        return this;
    }

    public Set<Actor> actores() {
        return actores;
    }
}
