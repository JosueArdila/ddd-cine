package co.com.sofka.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fecha implements ValueObject<String> {

    private final LocalDate fecha;
    private final String formato;

    public Fecha(int dia, int mes, int ano) {
        try {
            fecha = LocalDate.of(ano, mes, dia);
        } catch (DateTimeException e){
            throw new IllegalArgumentException("La fecha no es valida");
        }
        formato = generateFormato();
    }

    private String generateFormato(){
        return fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return formato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return formato.equals(fecha.formato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}
