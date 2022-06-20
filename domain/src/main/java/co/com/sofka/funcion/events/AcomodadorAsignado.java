package co.com.sofka.funcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.identities.AcomodadorId;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

public class AcomodadorAsignado extends DomainEvent {
    private final AcomodadorId entityId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Genero genero;

    public AcomodadorAsignado(AcomodadorId entityId, Nombre nombre, Identificacion identificacion, Genero genero) {
        super("sofka.funcion.AcomodadorAsignado");
        this.entityId = entityId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public AcomodadorId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Genero getGenero() {
        return genero;
    }
}
