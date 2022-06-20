package co.com.sofka.funcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.generic.values.Hora;

public class ModificarHoraCommand extends Command {

    private final FuncionId funcionId;
    private final Hora hora;

    public ModificarHoraCommand(FuncionId funcionId, Hora hora) {
        this.funcionId = funcionId;
        this.hora = hora;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public Hora getHora() {
        return hora;
    }
}
