package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.identities.AgendaId;
import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.Map;
import java.util.Set;

public class PeliculaAgregada extends DomainEvent {
    private final PeliculaId peliculaId;
    private final AgendaId agendaId;
    private final Map<Dia, Set<Hora>> horario;

    public PeliculaAgregada(PeliculaId peliculaId, AgendaId agendaId, Map<Dia, Set<Hora>> horario) {
        super("sofka.cartelera.PeliculaAgregada");
        this.peliculaId = peliculaId;
        this.agendaId = agendaId;
        this.horario = horario;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Map<Dia, Set<Hora>> getHorario() {
        return horario;
    }

    public AgendaId getAgendaId() {
        return agendaId;
    }
}
