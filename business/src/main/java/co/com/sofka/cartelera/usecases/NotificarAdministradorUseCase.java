package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cartelera.events.PeliculaDeCarteleraEliminada;

import java.util.List;

public class NotificarAdministradorUseCase extends UseCase<TriggeredEvent<PeliculaDeCarteleraEliminada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PeliculaDeCarteleraEliminada> input) {
        var event = input.getDomainEvent();
        var service = getService(EnviarMensajeTextoService.class).orElseThrow();

        service.enviarMensajeTexto(event.getPeliculaId(), "Se elimino la pelicula de la cartelera");
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
