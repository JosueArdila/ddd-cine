package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.Command;

public class CrearCarteleraCommand extends Command {

    private final Estado estado;

    public CrearCarteleraCommand(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
