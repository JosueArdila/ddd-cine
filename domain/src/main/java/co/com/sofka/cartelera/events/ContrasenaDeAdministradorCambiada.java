package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.values.Contrasena;
import co.com.sofka.cartelera.values.Correo;
import co.com.sofka.domain.generic.DomainEvent;

public class ContrasenaDeAdministradorCambiada extends DomainEvent {
    private final Correo correo;
    private final Contrasena contrasena;

    public ContrasenaDeAdministradorCambiada(Correo correo, Contrasena contrasena) {
        super("sofka.cartelera.ContrasenaDeAdministradorCambiada");
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Correo getCorreo() {
        return correo;
    }

    public Contrasena getContrasena() {
        return contrasena;
    }
}
