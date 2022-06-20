package co.com.sofka.funcion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.funcion.entities.Acomodador;
import co.com.sofka.funcion.entities.Persona;
import co.com.sofka.funcion.entities.Sala;
import co.com.sofka.funcion.events.*;
import co.com.sofka.funcion.fatories.PersonaFactory;
import co.com.sofka.funcion.identities.AcomodadorId;
import co.com.sofka.funcion.identities.FuncionId;
import co.com.sofka.funcion.identities.SalaId;
import co.com.sofka.funcion.values.EstadoSala;
import co.com.sofka.funcion.values.Tipo;
import co.com.sofka.funcion.values.Ubicacion;
import co.com.sofka.generic.values.*;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.List;
import java.util.Set;

public class Funcion extends AggregateEvent<FuncionId> {

    protected PeliculaId peliculaId;
    protected Sala sala;
    protected Set<Persona> personas;
    protected Acomodador acomodador;
    protected Hora hora;
    protected Fecha fecha;


    public Funcion(FuncionId entityId, PeliculaId peliculaId, Hora hora, Fecha fecha) {
        super(entityId);
        subscribe(new FuncionChange(this));
        appendChange(new FuncionCreada(peliculaId, hora, fecha)).apply();
    }

    private Funcion(FuncionId funcionId) {
        super(funcionId);
        subscribe(new FuncionChange(this));
    }

    public static Funcion from(FuncionId funcionId, List<DomainEvent> events) {
        var funcion = new Funcion(funcionId);
        events.forEach(funcion::applyEvent);
        return funcion;
    }

    public void asignarSala(SalaId entityId, EstadoSala estadoSala, Tipo tipo, Ubicacion ubicacion) {
        appendChange(new SalaAsignada(entityId, estadoSala, tipo, ubicacion)).apply();
    }

    public void asignarAcomodador(AcomodadorId entityId, Nombre nombre, Identificacion identificacion, Genero genero) {
        appendChange(new AcomodadorAsignado(entityId, nombre, identificacion, genero)).apply();
    }

    public void ingresarPersonas(PersonaFactory personaFactory) {
        personaFactory.personas()
                .forEach(persona -> {
                    appendChange(
                            new PersonaIngresada(persona.identity(), persona.nombre(), persona.identificacion(), persona.genero())
                    ).apply();
                });
    }

    public void modificarHora(Hora hora) {
        appendChange(new HoraModificada(hora)).apply();
    }

    public void modificarFecha(Fecha fecha) {
        appendChange(new FechaModificada(fecha)).apply();
    }

}
