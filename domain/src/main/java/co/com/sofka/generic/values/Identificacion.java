package co.com.sofka.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identificacion implements ValueObject<String> {

    private final TipoDocumento tipoDocumento;
    private final int numero;
    private final String formato;

    public Identificacion(TipoDocumento tipoDocumento, int numero) {
        this.tipoDocumento = Objects.requireNonNull(tipoDocumento);

        if (numero < 0) {
            throw new IllegalArgumentException("El número de identificacion no puede ser negativo");
        }
        this.numero = numero;

        this.formato = darIdentificacion();
    }

    private String darIdentificacion() {
        return this.tipoDocumento.toString() + this.numero;
    }

    @Override
    public String value() {
        return formato;
    }

    public enum TipoDocumento {
        CC, CE, TI, P
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identificacion that = (Identificacion) o;
        return formato.equals(that.formato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}
