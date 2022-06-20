package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cartelera.commands.CrearCarteleraCommand;
import co.com.sofka.cartelera.events.CarteleraCreada;
import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static co.com.sofka.cartelera.values.Estado.Estados.ACTIVA;

public class CrearCarteleraUseCaseTest {

    @Test
    public void crearCartelera() {

        // arrange
        Estado estado = new Estado(ACTIVA);
        var command = new CrearCarteleraCommand(estado);
        CrearCarteleraUseCase useCase = new CrearCarteleraUseCase();

        // act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        // assert
        var event = (CarteleraCreada) events.get(0);
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals(ACTIVA, event.getEstado().value());
    }
}
