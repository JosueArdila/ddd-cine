package co.com.sofka.pelicula.identities;

import co.com.sofka.domain.generic.Identity;

public class DirectorId extends Identity {

    public DirectorId() {}

    private DirectorId(String id) {
        super(id);
    }

    public static DirectorId of(String id) {
        return new DirectorId(id);
    }
}
