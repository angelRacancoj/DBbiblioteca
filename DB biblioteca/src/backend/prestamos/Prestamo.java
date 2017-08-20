package backend.prestamos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author angel
 */
public class Prestamo implements Serializable {
    
    private String carnetEstudiante;
    private String codigoLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private double pagoTotal;
    private boolean pagoMoroso;
    private boolean libroDevuelto;

    public Prestamo(String carnetEstudiante, String codigoLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, double pagoTotal, boolean pagoMoroso, boolean libroDevuelto) {
        this.carnetEstudiante = carnetEstudiante;
        this.codigoLibro = codigoLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.pagoTotal = pagoTotal;
        this.pagoMoroso = pagoMoroso;
        this.libroDevuelto = libroDevuelto;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public boolean isPagoMoroso() {
        return pagoMoroso;
    }

    public void setPagoMoroso(boolean pagoMoroso) {
        this.pagoMoroso = pagoMoroso;
    }

    public boolean isLibroDevuelto() {
        return libroDevuelto;
    }

    public void setLibroDevuelto(boolean libroDevuelto) {
        this.libroDevuelto = libroDevuelto;
    }
    
    
}
