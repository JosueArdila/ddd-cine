package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.funcion.Funcion;
import co.com.sofka.funcion.commands.IngresarPersonaCommand;

public class IngresarPersonaUseCase extends UseCase<RequestCommand<IngresarPersonaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<IngresarPersonaCommand> input) {
        var command = input.getCommand();
        var funcion = Funcion.from(command.getFuncionId(), repository().getEventsBy(command.getFuncionId().value()));

        funcion.ingresarPersonas(command.getPersonaFactory());
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
