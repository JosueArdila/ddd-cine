package co.com.sofka.pelicula.identities;

import co.com.sofka.domain.generic.Identity;

public class CalificacionId extends Identity {

    public CalificacionId() {}

    private CalificacionId(String id) {
        super(id);
    }

    public static CalificacionId of(String id) {
        return new CalificacionId(id);
    }
}
