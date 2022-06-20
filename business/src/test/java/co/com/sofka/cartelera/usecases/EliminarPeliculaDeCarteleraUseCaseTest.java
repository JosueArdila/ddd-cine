package co.com.sofka.cartelera.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cartelera.commands.EliminarPeliculaDeCarteleraCommand;
import co.com.sofka.cartelera.events.CarteleraCreada;
import co.com.sofka.cartelera.events.EstrenoProximoAgregado;
import co.com.sofka.cartelera.events.PeliculaAgregada;
import co.com.sofka.cartelera.events.PeliculaDeCarteleraEliminada;
import co.com.sofka.cartelera.identities.AgendaId;
import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.identities.EstrenoProximoId;
import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static co.com.sofka.cartelera.values.Dia.Dias.LUNES;
import static co.com.sofka.cartelera.values.Estado.Estados.ACTIVA;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EliminarPeliculaDeCarteleraUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    EliminarPeliculaDeCarteleraUseCase useCase;

    @Test
    public void eliminarPeliculaDeCartelera() {

        // arrange
        CarteleraId carteleraId = new CarteleraId();
        var command = new EliminarPeliculaDeCarteleraCommand(carteleraId, PeliculaId.of("YYY"));
        when(repository.getEventsBy(command.getCarteleraId().value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        var event = (PeliculaDeCarteleraEliminada) events.get(0);
        Assertions.assertEquals(1, events.size());
        Assertions.assertEquals("YYY", event.getPeliculaId().value());

    }

    private List<DomainEvent> obtenerHistorial() {
        Map<Dia, Set<Hora>> horario = new HashMap<>();
        horario.put(new Dia(LUNES), Set.of(
                new Hora(8, 00),
                new Hora(10, 20))
        );

        return List.of(
                new CarteleraCreada(new Estado(ACTIVA)),
                new EstrenoProximoAgregado(EstrenoProximoId.of("xxx"), new Fecha(20, 3, 2022), PeliculaId.of("P01")),
                new PeliculaAgregada(PeliculaId.of("YYY"), AgendaId.of("A002"), horario),
                new PeliculaAgregada(PeliculaId.of("MMM"), AgendaId.of("A332"), horario)
        );
    }
}
