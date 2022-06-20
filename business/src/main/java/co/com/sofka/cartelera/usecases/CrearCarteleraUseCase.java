package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cartelera.Cartelera;
import co.com.sofka.cartelera.commands.CrearCarteleraCommand;
import co.com.sofka.cartelera.identities.CarteleraId;

public class CrearCarteleraUseCase extends UseCase<RequestCommand<CrearCarteleraCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCarteleraCommand> input) {
        var command = input.getCommand();
        var cartelera = new Cartelera(new CarteleraId(), command.getEstado());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
