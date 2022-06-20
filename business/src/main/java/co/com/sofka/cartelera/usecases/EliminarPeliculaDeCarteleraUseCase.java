package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cartelera.Cartelera;
import co.com.sofka.cartelera.commands.EliminarPeliculaDeCarteleraCommand;

public class EliminarPeliculaDeCarteleraUseCase extends UseCase<RequestCommand<EliminarPeliculaDeCarteleraCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarPeliculaDeCarteleraCommand> input) {
        var command = input.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), repository().getEventsBy(command.getCarteleraId().value()));

        cartelera.eliminarPeliculaDeCartelera(command.getPeliculaId());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
