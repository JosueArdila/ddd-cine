package co.com.sofka.cartelera.factories;

import co.com.sofka.cartelera.entities.EstrenoProximo;
import co.com.sofka.cartelera.identities.EstrenoProximoId;
import co.com.sofka.generic.values.Fecha;
import co.com.sofka.pelicula.identities.PeliculaId;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EstrenoProximoFactory {

    private final Set<EstrenoProximo> estrenosProximos;
    private static EstrenoProximoFactory instance;

    private EstrenoProximoFactory() {
        estrenosProximos = new HashSet<>();
    }

    public static EstrenoProximoFactory getInstance() {
        if(Objects.isNull(instance)) {
            instance = new EstrenoProximoFactory();
            return instance;
        }
        return instance;
    }

    public EstrenoProximoFactory add(EstrenoProximoId entityId, Fecha fecha, PeliculaId peliculaId){
        estrenosProximos.add(new EstrenoProximo(entityId, fecha, peliculaId));
        return this;
    }

    public Set<EstrenoProximo> estrenosProximos() {
        return estrenosProximos;
    }
}
