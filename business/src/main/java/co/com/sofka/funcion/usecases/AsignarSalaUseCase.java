package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.funcion.Funcion;
import co.com.sofka.funcion.commands.AsignarSalaCommand;

public class AsignarSalaUseCase extends UseCase<RequestCommand<AsignarSalaCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AsignarSalaCommand> input) {
        var command = input.getCommand();
        var funcion = Funcion.from(command.getFuncionId(), repository().getEventsBy(command.getFuncionId().value()));

        funcion.asignarSala(command.getEntityId(), command.getEstadoSala(), command.getTipo(), command.getUbicacion());
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));

    }
}
