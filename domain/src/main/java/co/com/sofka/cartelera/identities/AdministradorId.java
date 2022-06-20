package co.com.sofka.cartelera.identities;

import co.com.sofka.domain.generic.Identity;

public class AdministradorId extends Identity {

    public AdministradorId() {}

    private AdministradorId(String id) {
        super(id);
    }

    public static AdministradorId of(String id) {
        return new AdministradorId(id);
    }
}
