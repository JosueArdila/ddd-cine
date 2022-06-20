package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.values.Contrasena;
import co.com.sofka.cartelera.values.Correo;
import co.com.sofka.domain.generic.Command;

public class CambiarContrasenaDeAdministradorCommand extends Command {

    private final CarteleraId carteleraId;
    private final Correo correo;
    private final Contrasena contrasena;

    public CambiarContrasenaDeAdministradorCommand(CarteleraId carteleraId, Correo correo, Contrasena contrasena) {
        this.carteleraId = carteleraId;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public Correo getCorreo() {
        return correo;
    }

    public Contrasena getContrasena() {
        return contrasena;
    }
}
