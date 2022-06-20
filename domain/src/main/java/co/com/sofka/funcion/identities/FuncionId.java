package co.com.sofka.funcion.identities;

import co.com.sofka.domain.generic.Identity;

public class FuncionId extends Identity {

    public FuncionId() {}

    private FuncionId(String id) {
        super(id);
    }

    public static FuncionId of(String id) {
        return new FuncionId(id);
    }
}
