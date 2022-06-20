package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cartelera.events.PeliculaDeCarteleraEliminada;
import co.com.sofka.cartelera.usecases.services.EnviarMensajeTextoService;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class NotificarAdministradorUseCaseTest {

    @Mock
    EnviarMensajeTextoService mensajeTextoService;

    @InjectMocks
    NotificarAdministradorUseCase useCase;

    @Test
    void enviarMensaje(){
        var event = new PeliculaDeCarteleraEliminada(PeliculaId.of("XXX"));

        doNothing().when(mensajeTextoService).enviarMensajeTexto(any(), any());
        useCase.addServiceBuilder(new ServiceBuilder().addService(mensajeTextoService));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        Mockito.verify(mensajeTextoService).enviarMensajeTexto(any(), any());
        Assertions.assertEquals(0, events.size());
    }
}
