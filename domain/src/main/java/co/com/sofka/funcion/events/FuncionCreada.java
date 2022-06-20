package co.com.sofka.funcion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;

public class FuncionCreada extends DomainEvent {
    private final PeliculaId peliculaId;
    private final Hora hora;
    private final Fecha fecha;

    public FuncionCreada(PeliculaId peliculaId, Hora hora, Fecha fecha) {
        super("sofka.funcion.FuncionCreada");
        this.peliculaId = peliculaId;
        this.hora = hora;
        this.fecha = fecha;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Hora getHora() {
        return hora;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
