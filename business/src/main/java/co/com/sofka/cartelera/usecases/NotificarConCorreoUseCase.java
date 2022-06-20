package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cartelera.events.ContrasenaDeAdministradorCambiada;
import co.com.sofka.cartelera.usecases.services.EnviarCorreoService;

import java.util.List;

public class NotificarConCorreoUseCase extends UseCase<TriggeredEvent<ContrasenaDeAdministradorCambiada>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<ContrasenaDeAdministradorCambiada> input) {
        var event = input.getDomainEvent();
        var service = getService(EnviarCorreoService.class).orElseThrow();

        service.enviarCorreo(event.getCorreo(), "Se cambió la contraseña de su cuenta");

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
