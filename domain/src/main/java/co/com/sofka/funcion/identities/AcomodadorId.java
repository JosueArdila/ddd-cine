package co.com.sofka.funcion.identities;

import co.com.sofka.domain.generic.Identity;

public class AcomodadorId extends Identity {

    public AcomodadorId() {}

    private AcomodadorId(String id) {
        super(id);
    }

    public static AcomodadorId of(String id) {
        return new AcomodadorId(id);
    }
}
