package co.com.sofka.pelicula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.pelicula.factories.ActorFactory;
import co.com.sofka.pelicula.identities.PeliculaId;

public class AgregarActorCommand extends Command {

    private final PeliculaId peliculaId;
    private final ActorFactory actorFactory;

    public AgregarActorCommand(PeliculaId peliculaId, ActorFactory actorFactory) {
        this.peliculaId = peliculaId;
        this.actorFactory = actorFactory;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public ActorFactory getActorFactory() {
        return actorFactory;
    }
}
