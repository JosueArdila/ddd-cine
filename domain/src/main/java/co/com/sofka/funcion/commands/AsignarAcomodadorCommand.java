package co.com.sofka.funcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.funcion.identities.AcomodadorId;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

public class AsignarAcomodadorCommand extends Command {

    private final FuncionId funcionId;
    private final AcomodadorId entityId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Genero genero;

    public AsignarAcomodadorCommand(FuncionId funcionId, AcomodadorId entityId, Nombre nombre, Identificacion identificacion, Genero genero) {
        this.funcionId = funcionId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public FuncionId getFuncionId() {
        return funcionId;
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
