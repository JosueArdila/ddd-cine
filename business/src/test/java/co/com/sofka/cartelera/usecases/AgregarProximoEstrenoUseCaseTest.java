package co.com.sofka.cartelera.usecases;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.cartelera.commands.AgregarProximosEstrenosCommand;
import co.com.sofka.cartelera.events.CarteleraCreada;
import co.com.sofka.cartelera.factories.EstrenoProximoFactory;
import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.identities.EstrenoProximoId;
import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.pelicula.identities.PeliculaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static co.com.sofka.cartelera.values.Estado.Estados.ACTIVA;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarProximoEstrenoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @InjectMocks
    AgregarProximoEstrenoUseCase useCase;

    @Test
    public void agregarProximosEstrenos() {


        // arrange
        EstrenoProximoFactory factory = EstrenoProximoFactory.getInstance()
                .add(EstrenoProximoId.of("E12"), new Fecha(20, 07, 2022), PeliculaId.of("XXX"))
                .add(EstrenoProximoId.of("E13"), new Fecha(25, 03, 2022), PeliculaId.of("YYY"))
                .add(EstrenoProximoId.of("E14"), new Fecha(25, 12, 2022), PeliculaId.of("ZZZ"))
                .add(EstrenoProximoId.of("E15"), new Fecha(26, 05, 2022), PeliculaId.of("AAA"));

        CarteleraId carteleraId = new CarteleraId();
        var command = new AgregarProximosEstrenosCommand(carteleraId, factory);
        when(repository.getEventsBy(carteleraId.value())).thenReturn(obtenerHistorial());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // assert
        Assertions.assertEquals(4, events.size());

    }

    private List<DomainEvent> obtenerHistorial() {
        return List.of(new CarteleraCreada(new Estado(ACTIVA)));
    }
}
