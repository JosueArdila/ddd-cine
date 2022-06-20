package co.com.sofka.funcion.identities;

import co.com.sofka.domain.generic.Identity;

public class PersonaId extends Identity {

    public PersonaId() {}

    private PersonaId(String id) {
        super(id);
    }

    public static PersonaId of(String id) {
        return new PersonaId(id);
    }
}
