package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.cartelera.Cartelera;
import co.com.sofka.cartelera.commands.AgregarProximosEstrenosCommand;

public class AgregarProximoEstrenoUseCase extends UseCase<RequestCommand<AgregarProximosEstrenosCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarProximosEstrenosCommand> input) {
        var command = input.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), repository().getEventsBy(command.getCarteleraId().value()));

        cartelera.agregarProximosEstrenos(command.getFactory());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
