package co.com.sofka.funcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Hora;

public class HoraModificada extends DomainEvent {
    private final Hora hora;

    public HoraModificada(Hora hora) {
        super("sofka.funcion.HoraModificada");
        this.hora = hora;
    }

    public Hora getHora() {
        return hora;
    }
}
