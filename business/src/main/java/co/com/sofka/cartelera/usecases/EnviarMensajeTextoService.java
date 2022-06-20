package co.com.sofka.cartelera.usecases;

import co.com.sofka.pelicula.identities.PeliculaId;

public interface EnviarMensajeTextoService {
    void enviarMensajeTexto(PeliculaId peliculaId, String s);
}
