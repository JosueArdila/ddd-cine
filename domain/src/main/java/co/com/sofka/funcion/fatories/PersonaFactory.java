package co.com.sofka.funcion.fatories;

import co.com.sofka.funcion.entities.Persona;
import co.com.sofka.funcion.identities.PersonaId;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PersonaFactory {

    private final Set<Persona> personas;
    private static PersonaFactory instance;

    private PersonaFactory() {
        personas = new HashSet<>();
    }

    public static PersonaFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new PersonaFactory();
            return instance;
        }
        return instance;
    }

    public PersonaFactory add(PersonaId entityId, Nombre nombre, Identificacion identificacion, Genero genero){
        personas.add(new Persona(entityId, nombre, identificacion, genero));
        return this;
    }

    public Set<Persona> personas() {
        return personas;
    }

}
