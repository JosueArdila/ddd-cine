package co.com.sofka.cartelera.entities;

import co.com.sofka.cartelera.identities.AdministradorId;
import co.com.sofka.cartelera.values.Contrasena;
import co.com.sofka.cartelera.values.Correo;
import co.com.sofka.domain.generic.Entity;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;

import java.util.Objects;

public class Administrador extends Entity<AdministradorId> {

    private Nombre nombre;
    private Identificacion identificacion;
    private Genero genero;
    private Correo correo;
    private Contrasena contrasena;

    public Administrador(AdministradorId entityId, Nombre nombre, Identificacion identificacion, Genero genero, Correo correo, Contrasena contrasena) {
        super(entityId);
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Identificacion identificacion() {
        return identificacion;
    }

    public Genero genero() {
        return genero;
    }

    public Correo correo() {
        return correo;
    }

    public Contrasena contrasena() {
        return contrasena;
    }

    public void editarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void editarGenero(Genero genero) {
        this.genero = Objects.requireNonNull(genero);
    }

    public void cambiarContrasena(Contrasena contrasena) {
        this.contrasena = Objects.requireNonNull(contrasena);
    }
}
