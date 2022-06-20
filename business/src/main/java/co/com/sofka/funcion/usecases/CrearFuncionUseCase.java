package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.funcion.Funcion;
import co.com.sofka.funcion.commands.CrearFuncionCommand;
import co.com.sofka.funcion.identities.FuncionId;

public class CrearFuncionUseCase extends UseCase<RequestCommand<CrearFuncionCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFuncionCommand> input) {
        var command = input.getCommand();
        var funcion = new Funcion(new FuncionId(), command.getPeliculaId(), command.getHora(), command.getFecha());
        emit().onResponse(new ResponseEvents(funcion.getUncommittedChanges()));
    }
}
