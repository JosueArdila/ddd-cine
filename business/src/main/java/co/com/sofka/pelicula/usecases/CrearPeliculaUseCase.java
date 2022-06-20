package co.com.sofka.pelicula.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.pelicula.Pelicula;
import co.com.sofka.pelicula.commands.CrearPeliculaCommand;
import co.com.sofka.pelicula.identities.PeliculaId;

public class CrearPeliculaUseCase extends UseCase<RequestCommand<CrearPeliculaCommand>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearPeliculaCommand> input) {
        var command = input.getCommand();
        var pelicula = new Pelicula(new PeliculaId(), command.getDescripcion(), command.getDuracion(),
                command.getResolucion(), command.getGeneroPelicula());
        emit().onResponse(new ResponseEvents(pelicula.getUncommittedChanges()));
    }
}
