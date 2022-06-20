package co.com.sofka.funcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.funcion.identities.SalaId;
import co.com.sofka.funcion.values.EstadoSala;
import co.com.sofka.funcion.values.Tipo;
import co.com.sofka.funcion.values.Ubicacion;

public class AsignarSalaCommand extends Command {

    private final FuncionId funcionId;
    private final SalaId entityId;
    private final EstadoSala estadoSala;
    private final Tipo tipo;
    private final Ubicacion ubicacion;

    public AsignarSalaCommand(FuncionId funcionId, SalaId entityId, EstadoSala estadoSala, Tipo tipo, Ubicacion ubicacion) {
        this.funcionId = funcionId;
        this.entityId = entityId;
        this.estadoSala = estadoSala;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public SalaId getEntityId() {
        return entityId;
    }

    public EstadoSala getEstadoSala() {
        return estadoSala;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
