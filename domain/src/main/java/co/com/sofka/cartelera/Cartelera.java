package co.com.sofka.cartelera;

import co.com.sofka.cartelera.entities.Administrador;
import co.com.sofka.cartelera.entities.Agenda;
import co.com.sofka.cartelera.entities.EstrenoProximo;
import co.com.sofka.cartelera.events.*;
import co.com.sofka.cartelera.factories.EstrenoProximoFactory;
import co.com.sofka.cartelera.identities.AdministradorId;
import co.com.sofka.cartelera.identities.AgendaId;
import co.com.sofka.cartelera.identities.CarteleraId;
import co.com.sofka.cartelera.values.Contrasena;
import co.com.sofka.cartelera.values.Correo;
import co.com.sofka.cartelera.values.Dia;
import co.com.sofka.cartelera.values.Estado;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.values.Genero;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.generic.values.Identificacion;
import co.com.sofka.generic.values.Nombre;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cartelera extends AggregateEvent<CarteleraId> {

    protected Map<PeliculaId, Agenda> peliculasCartelera;
    protected Administrador administrador;
    protected Set<EstrenoProximo> estrenoProximos;
    protected Estado estado;

    public Cartelera(CarteleraId entityId, Estado estado) {
        super(entityId);
        subscribe(new CarteleraChange(this));
        appendChange(new CarteleraCreada(estado)).apply();
    }

    private Cartelera(CarteleraId carteleraId) {
        super(carteleraId);
        subscribe(new CarteleraChange(this));
    }

    public static Cartelera from(CarteleraId carteleraId, List<DomainEvent> events) {
        var cartelera = new Cartelera(carteleraId);
        events.forEach(cartelera::applyEvent);
        return cartelera;
    }

    public void agregarProximosEstrenos(EstrenoProximoFactory factory) {
        factory.estrenosProximos()
                .forEach(estrenoProximo -> {
                    appendChange(
                            new EstrenoProximoAgregado(estrenoProximo.identity(), estrenoProximo.fecha(), estrenoProximo.peliculaId())
                    ).apply();
                });
    }

    public void agregarPelicula(PeliculaId peliculaId, AgendaId agendaId, Map<Dia, Set<Hora>> horario) {
        appendChange(new PeliculaAgregada(peliculaId, agendaId, horario)).apply();
    }

    public void eliminarPeliculaDeCartelera(PeliculaId peliculaId) {
        appendChange(new PeliculaDeCarteleraEliminada(peliculaId)).apply();
    }

    public void cambiarEstado(Estado estado) {
        appendChange(new EstadoCambiado(estado)).apply();
    }

    public void asignarAdministrador(AdministradorId administradorId, Nombre nombre, Identificacion identificacion, Genero genero, Correo correo, Contrasena contrasena) {
        appendChange(new AdministradorAsignado(administradorId, nombre, identificacion, genero, correo, contrasena)).apply();
    }

    public void modificarAgendaDePelicula(PeliculaId peliculaId, Map<Dia, Set<Hora>> horario) {
        appendChange(new AgendaDePeliculaModificada(peliculaId, horario)).apply();
    }

    public void cambiarContrasenaDeAdministrador(Correo correo, Contrasena contrasena) {
        appendChange(new ContrasenaDeAdministradorCambiada(correo, contrasena)).apply();
    }





}
