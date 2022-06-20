package co.com.sofka.cartelera;

import co.com.sofka.cartelera.entities.Administrador;
import co.com.sofka.cartelera.entities.Agenda;
import co.com.sofka.cartelera.entities.EstrenoProximo;
import co.com.sofka.cartelera.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;
import java.util.HashSet;

public class CarteleraChange extends EventChange {
    public CarteleraChange(Cartelera cartelera) {
        apply((CarteleraCreada event) -> {
            cartelera.estado = event.getEstado();
            cartelera.peliculasCartelera = new HashMap<>();
            cartelera.estrenoProximos = new HashSet<>();
        });

        apply((EstrenoProximoAgregado event) -> {
            cartelera.estrenoProximos.add(new EstrenoProximo(event.getIdentity(), event.getFecha(), event.getPeliculaId()));
        });

        apply((PeliculaAgregada event) -> {
            cartelera.peliculasCartelera.putIfAbsent(event.getPeliculaId(), new Agenda(event.getAgendaId(), event.getHorario()));
        });

        apply((PeliculaDeCarteleraEliminada event) -> {
            if (!cartelera.peliculasCartelera.containsKey(event.getPeliculaId()))
                throw new IllegalArgumentException("No se encontro pelicula con ese identificador");

            cartelera.peliculasCartelera.remove(event.getPeliculaId());
        });

        apply((EstadoCambiado event) -> {
            cartelera.estado = event.getEstado();
        });

        apply((AdministradorAsignado event) -> {
            cartelera.administrador = new Administrador(event.getAdministradorId(), event.getNombre(), event.getIdentificacion(),
                    event.getGenero(), event.getCorreo(), event.getContrasena());
        });

        apply((AgendaDePeliculaModificada event) -> {
            if (!cartelera.peliculasCartelera.containsKey(event.getPeliculaId())) {
                throw new IllegalArgumentException("No se encontro pelicula con ese identificador");
            }
            cartelera.peliculasCartelera.get(event.getPeliculaId()).modificarHorario(event.getHorario());
        });

        apply((ContrasenaDeAdministradorCambiada event) -> {
            cartelera.administrador.cambiarContrasena(event.getContrasena());
        });
    }
}
