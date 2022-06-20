package co.com.sofka.cartelera.identities;

import co.com.sofka.domain.generic.Identity;

public class EstrenoProximoId extends Identity {

    public EstrenoProximoId() {}

    private EstrenoProximoId(String id) {
        super(id);
    }

    public static EstrenoProximoId of(String id) {
        return new EstrenoProximoId(id);
    }
}
