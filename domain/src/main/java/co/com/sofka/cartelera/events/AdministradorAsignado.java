package co.com.sofka.cartelera.events;

import co.com.sofka.cartelera.identities.AdministradorId;
import co.com.sofka.cartelera.values.Contrasena;
import co.com.sofka.cartelera.values.Correo;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

public class AdministradorAsignado extends DomainEvent {
    private final AdministradorId administradorId;
    private final Nombre nombre;
    private final Identificacion identificacion;
    private final Genero genero;
    private final Correo correo;
    private final Contrasena contrasena;

    public AdministradorAsignado(AdministradorId administradorId, Nombre nombre, Identificacion identificacion, Genero genero, Correo correo, Contrasena contrasena) {
        super("sofka.cartelera.AdministradorAsignado");
        this.administradorId = administradorId;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.correo = correo;
        this.contrasena = contrasena;
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

    public Correo getCorreo() {
        return correo;
    }

    public Contrasena getContrasena() {
        return contrasena;
    }
}
