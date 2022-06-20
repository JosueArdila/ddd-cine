package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pelicula.Pelicula;
import co.com.sofka.pelicula.commands.AgregarActorCommand;

public class AgregarActorUseCase extends UseCase<RequestCommand<AgregarActorCommand>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarActorCommand> input) {
        var command = input.getCommand();
        var pelicula = Pelicula.from(command.getPeliculaId(), repository().getEventsBy(command.getPeliculaId().value()));

        pelicula.agregarActores(command.getActorFactory());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
