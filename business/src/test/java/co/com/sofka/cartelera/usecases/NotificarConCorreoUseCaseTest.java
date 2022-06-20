package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.cartelera.events.ContrasenaDeAdministradorCambiada;
import co.com.sofka.cartelera.usecases.services.EnviarCorreoService;
import co.com.sofka.cartelera.values.Contrasena;
import co.com.sofka.cartelera.values.Correo;
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
public class NotificarConCorreoUseCaseTest {

    @Mock
    EnviarCorreoService senderEmailService;

    @InjectMocks
    NotificarConCorreoUseCase useCase;

    @Test
    void enviarCorreo(){
        var event = new ContrasenaDeAdministradorCambiada(new Correo("test@mail.com"), new Contrasena("#$%&sd"));

        doNothing().when(senderEmailService).enviarCorreo(any(), any());
        useCase.addServiceBuilder(new ServiceBuilder().addService(senderEmailService));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();


        Mockito.verify(senderEmailService).enviarCorreo(any(), any());
        Assertions.assertEquals(0, events.size());
    }
}
