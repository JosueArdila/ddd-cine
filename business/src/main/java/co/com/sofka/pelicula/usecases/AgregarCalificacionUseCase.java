package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pelicula.Pelicula;
import co.com.sofka.pelicula.commands.AgregarCalificacionCommand;

public class AgregarCalificacionUseCase extends UseCase<RequestCommand<AgregarCalificacionCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCalificacionCommand> input) {
        var command = input.getCommand();
        var pelicula = Pelicula.from(command.getPeliculaId(), repository().getEventsBy(command.getPeliculaId().value()));

        pelicula.agregarCalificaciones(command.getCalificacionFactory());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));

    }
}
