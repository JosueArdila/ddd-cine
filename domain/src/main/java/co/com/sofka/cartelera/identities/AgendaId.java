package co.com.sofka.cartelera.identities;

import co.com.sofka.domain.generic.Identity;

public class AgendaId extends Identity {

    public AgendaId() {}

    private AgendaId(String id) {
        super(id);
    }

    public static AgendaId of(String id) {
        return new AgendaId(id);
    }
}
