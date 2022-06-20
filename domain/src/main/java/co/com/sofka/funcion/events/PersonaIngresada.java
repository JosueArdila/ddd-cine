package co.com.sofka.funcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.identities.PersonaId;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

public class PersonaIngresada extends DomainEvent {
    private final PersonaId identity;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Genero genero;

    public PersonaIngresada(PersonaId identity, Nombre nombre, Identificacion identificacion, Genero genero) {
        super("sofka.funcion.PersonaIngresada");
        this.identity = identity;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public PersonaId getIdentity() {
        return identity;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Genero getGenero() {
        return genero;
    }
}
