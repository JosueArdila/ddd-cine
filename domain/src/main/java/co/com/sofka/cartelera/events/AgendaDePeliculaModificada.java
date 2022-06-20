package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.Map;
import java.util.Set;

public class AgendaDePeliculaModificada extends DomainEvent {
    private final PeliculaId peliculaId;
    private final Map<Dia, Set<Hora>> horario;

    public AgendaDePeliculaModificada(PeliculaId peliculaId, Map<Dia, Set<Hora>> horario) {
        super("sofka.cartelera.AgendaDePeliculaModificada");
        this.peliculaId = peliculaId;
        this.horario = horario;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Map<Dia, Set<Hora>> getHorario() {
        return horario;
    }
}
