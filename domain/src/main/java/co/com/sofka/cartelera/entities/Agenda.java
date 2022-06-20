package co.com.sofka.cartelera.entities;

import co.com.sofka.cartelera.identities.AgendaId;
import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Hora;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Agenda extends Entity<AgendaId> {

    private Map<Dia, Set<Hora>> horario;

    public Agenda(AgendaId entityId, Map<Dia, Set<Hora>> horario) {
        super(entityId);
        this.horario = horario;
    }

    public Map<Dia, Set<Hora>> horario() {
        return horario;
    }

    public void modificarHorario(Map<Dia, Set<Hora>> horario) {
        this.horario = Objects.requireNonNull(horario);
    }
}
