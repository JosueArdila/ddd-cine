package co.com.sofka.funcion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.funcion.entities.Acomodador;
import co.com.sofka.funcion.entities.Persona;
import co.com.sofka.funcion.entities.Sala;
import co.com.sofka.funcion.events.*;

import java.util.HashSet;

public class FuncionChange extends EventChange {
    public FuncionChange(Funcion funcion) {

        apply((FuncionCreada event) -> {
            funcion.peliculaId = event.getPeliculaId();
            funcion.hora = event.getHora();
            funcion.fecha = event.getFecha();
            funcion.personas = new HashSet<>();
        });

        apply((SalaAsignada event) -> {
            funcion.sala = new Sala(event.getEntityId(), event.getEstadoSala(), event.getTipo(), event.getUbicacion());
        });

        apply((AcomodadorAsignado event) -> {
            funcion.acomodador = new Acomodador(event.getEntityId(), event.getNombre(), event.getIdentificacion(), event.getGenero());
        });

        apply((PersonaIngresada event) -> {
            funcion.personas.add(new Persona(event.getIdentity(), event.getNombre(), event.getIdentificacion(), event.getGenero()));
        });

        apply((FechaModificada event) -> {
            funcion.fecha = event.getFecha();
        });

        apply((HoraModificada event) -> {
            funcion.hora = event.getHora();
        });


    }
}
