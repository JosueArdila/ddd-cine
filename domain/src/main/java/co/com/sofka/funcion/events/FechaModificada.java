package co.com.sofka.funcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Fecha;

public class FechaModificada extends DomainEvent {
    private final Fecha fecha;

    public FechaModificada(Fecha fecha) {
        super("sofka.funcion.FechaModificada");
        this.fecha = fecha;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
