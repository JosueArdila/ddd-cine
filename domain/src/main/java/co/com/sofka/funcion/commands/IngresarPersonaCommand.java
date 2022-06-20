package co.com.sofka.funcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.funcion.fatories.PersonaFactory;
import co.com.sofka.funcion.identities.FuncionId;

public class IngresarPersonaCommand extends Command {

    private final FuncionId funcionId;
    private final PersonaFactory personaFactory;

    public IngresarPersonaCommand(FuncionId funcionId, PersonaFactory personaFactory) {
        this.funcionId = funcionId;
        this.personaFactory = personaFactory;
    }

    public FuncionId getFuncionId() {
        return funcionId;
    }

    public PersonaFactory getPersonaFactory() {
        return personaFactory;
    }
}
