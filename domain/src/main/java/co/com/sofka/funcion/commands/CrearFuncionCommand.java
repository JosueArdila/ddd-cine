package co.com.sofka.funcion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.generic.values.Hora;
import co.com.sofka.pelicula.identities.PeliculaId;

public class CrearFuncionCommand extends Command {

    private final PeliculaId peliculaId;
    private final Hora hora;
    private final Fecha fecha;

    public CrearFuncionCommand(PeliculaId peliculaId, Hora hora, Fecha fecha) {
        this.peliculaId = peliculaId;
        this.hora = hora;
        this.fecha = fecha;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Hora getHora() {
        return hora;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
