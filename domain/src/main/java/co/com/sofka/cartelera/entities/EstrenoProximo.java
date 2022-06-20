package co.com.sofka.cartelera.entities;

import co.com.sofka.cartelera.identities.EstrenoProximoId;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.Objects;

public class EstrenoProximo extends Entity<EstrenoProximoId> {

    private Fecha fecha;
    private PeliculaId peliculaId;

    public EstrenoProximo(EstrenoProximoId entityId, Fecha fecha, PeliculaId peliculaId) {
        super(entityId);
        this.fecha = fecha;
        this.peliculaId = peliculaId;
    }

    public Fecha fecha() {
        return fecha;
    }

    public PeliculaId peliculaId() {
        return peliculaId;
    }

    public void cambiarFecha(Fecha fecha) {
        this.fecha = Objects.requireNonNull(fecha);
    }
}
