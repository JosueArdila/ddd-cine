package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cartelera.Cartelera;
import co.com.sofka.cartelera.commands.AgregarPeliculaCommand;

public class AgregarPeliculaUseCase extends UseCase<RequestCommand<AgregarPeliculaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarPeliculaCommand> input) {
        var command = input.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), repository().getEventsBy(command.getCarteleraId().value()));

        cartelera.agregarPelicula(command.getPeliculaId(), command.getAgendaId(), command.getHorario());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
