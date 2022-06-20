package co.com.sofka.cartelera.commands;

import co.com.sofka.cartelera.identities.AdministradorId;
import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

public class AsignarAdministradorCommand extends Command {

    private final CarteleraId carteleraId;
    private final AdministradorId administradorId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Genero genero;

    public AsignarAdministradorCommand(CarteleraId carteleraId, AdministradorId administradorId, Nombre nombre,
                                       Identificacion identificacion, Genero genero) {
        this.carteleraId = carteleraId;
        this.administradorId = administradorId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public AdministradorId getAdministradorId() {
        return administradorId;
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
