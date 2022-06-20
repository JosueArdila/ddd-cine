package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.Map;
import java.util.Set;

public class ModificarAgendaDePeliculaCommand extends Command {

    private final CarteleraId carteleraId;
    private final PeliculaId peliculaId;
    private final Map<Dia, Set<Hora>> horario;

    public ModificarAgendaDePeliculaCommand(CarteleraId carteleraId, PeliculaId peliculaId,
                                            Map<Dia, Set<Hora>> horario) {
        this.carteleraId = carteleraId;
        this.peliculaId = peliculaId;
        this.horario = horario;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Map<Dia, Set<Hora>> getHorario() {
        return horario;
    }
}
