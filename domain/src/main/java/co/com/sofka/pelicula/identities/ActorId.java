package co.com.sofka.pelicula.identities;

import co.com.sofka.domain.generic.Identity;

public class ActorId extends Identity {

    public ActorId() {}

    private ActorId(String id) {
        super(id);
    }

    public static ActorId of(String id) {
        return new ActorId(id);
    }
}
