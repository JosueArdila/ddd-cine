package co.com.sofka.funcion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Ubicacion implements ValueObject<String> {

    private final String planta;
    private final String auditorio;
    private final String ubicacion;

    public Ubicacion(String planta, String auditorio) {
        this.planta = Objects.requireNonNull(planta);
        this.auditorio = Objects.requireNonNull(auditorio);

        if(planta.isBlank()) {
            throw new IllegalArgumentException("El campo planta no debe estar vacío");
        }
        if(auditorio.isBlank()) {
            throw new IllegalArgumentException("El campo auditorio no debe estar vacío");
        }
        this.ubicacion = darUbicacion();
    }

    private String darUbicacion() {
        return this.planta.concat(this.auditorio);
    }

    @Override
    public String value() {
        return ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion1 = (Ubicacion) o;
        return ubicacion.equals(ubicacion1.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ubicacion);
    }
}
