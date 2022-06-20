package co.com.sofka.funcion.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.funcion.identities.SalaId;
import co.com.sofka.funcion.values.EstadoSala;
import co.com.sofka.funcion.values.Tipo;
import co.com.sofka.funcion.values.Ubicacion;

import java.util.Objects;

public class Sala extends Entity<SalaId> {

    private EstadoSala estadoSala;
    private Tipo tipo;
    private Ubicacion ubicacion;

    public Sala(SalaId entityId, EstadoSala estadoSala, Tipo tipo, Ubicacion ubicacion) {
        super(entityId);
        this.estadoSala = estadoSala;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public EstadoSala estadoSala() {
        return estadoSala;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Ubicacion ubicacion() {
        return ubicacion;
    }

    public void cambiarEstado(EstadoSala estadoSala) {
        this.estadoSala = Objects.requireNonNull(estadoSala);
    }

    public void editarTipo(Tipo tipo) {
        this.tipo = Objects.requireNonNull(tipo);
    }
}
