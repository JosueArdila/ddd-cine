package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pelicula.Pelicula;
import co.com.sofka.pelicula.commands.AsignarDirectorCommand;

public class AsignarDirectorUseCase extends UseCase<RequestCommand<AsignarDirectorCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarDirectorCommand> input) {
        var command = input.getCommand();
        var pelicula = Pelicula.from(command.getPeliculaId(), repository().getEventsBy(command.getPeliculaId().value()));

        pelicula.asignarDirector(command.getDirectorId(), command.getNombre(), command.getGenero());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
