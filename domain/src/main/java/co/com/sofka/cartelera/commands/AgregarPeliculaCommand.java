package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.identities.AgendaId;
import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.Map;
import java.util.Set;

public class AgregarPeliculaCommand extends Command {

    private final CarteleraId carteleraId;
    private final PeliculaId peliculaId;
    private final AgendaId agendaId;
    private final Map<Dia, Set<Hora>> horario;

    public AgregarPeliculaCommand(CarteleraId carteleraId, PeliculaId peliculaId, AgendaId agendaId, Map<Dia, Set<Hora>> horario){
        this.carteleraId = carteleraId;
        this.peliculaId = peliculaId;
        this.agendaId = agendaId;
        this.horario = horario;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public AgendaId getAgendaId() {
        return agendaId;
    }

    public Map<Dia, Set<Hora>> getHorario() {
        return horario;
    }
}
