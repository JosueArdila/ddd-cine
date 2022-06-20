package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.funcion.Funcion;
import co.com.sofka.funcion.commands.AsignarAcomodadorCommand;

public class AsignarAcomodadorUseCase extends UseCase<RequestCommand<AsignarAcomodadorCommand>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AsignarAcomodadorCommand> input) {
        var command = input.getCommand();
        var funcion = Funcion.from(command.getFuncionId(), repository().getEventsBy(command.getFuncionId().value()));

        funcion.asignarAcomodador(command.getEntityId(), command.getNombre(), command.getIdentificacion(), command.getGenero());
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
