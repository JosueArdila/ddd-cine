package co.com.sofka.funcion.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.commands.CrearFuncionCommand;
import co.com.sofka.funcion.events.FuncionCreada;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearFuncionUseCaseTest {

    @Test
    public void crearFuncion() {

        // arrange
        PeliculaId peliculaId = PeliculaId.of("xxx");
        Hora hora = new Hora(12, 45);
        Fecha fecha = new Fecha(19, 06, 2022);
        var command = new CrearFuncionCommand(peliculaId, hora, fecha);

        CrearFuncionUseCase useCase = new CrearFuncionUseCase();

        // act
        List<DomainEvent> events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        // assert
        FuncionCreada event = (FuncionCreada) events.get(0);
        Assertions.assertEquals("xxx", event.getPeliculaId().value());
        Assertions.assertEquals("12:45:00", event.getHora().value());
        Assertions.assertEquals("19-06-2022", event.getFecha().value());
    }
}
