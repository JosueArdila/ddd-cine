package co.com.sofka.cartelera.usecases.services;

import co.com.sofka.cartelera.values.Correo;

public interface EnviarCorreoService {
    void enviarCorreo(Correo correo, String s);
}
