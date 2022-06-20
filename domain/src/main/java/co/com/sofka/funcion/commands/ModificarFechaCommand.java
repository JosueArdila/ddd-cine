package co.com.sofka.funcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.generic.values.Fecha;

public class ModificarFechaCommand extends Command {

    private final FuncionId funcionId;
    private final Fecha fecha;

    public ModificarFechaCommand(FuncionId funcionId, Fecha fecha) {
        this.funcionId = funcionId;
        this.fecha = fecha;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
