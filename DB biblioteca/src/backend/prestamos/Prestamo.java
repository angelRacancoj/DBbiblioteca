package backend.prestamos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Prestamo implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String carnetEstudiante;
    private String codigoLibro;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private double pagoTotal;
    private boolean pagoMoroso;
    private boolean libroDevuelto;
    private int No_ID;

    public Prestamo(int No_ID, String carnetEstudiante, String codigoLibro, Date fechaPrestamo, Date fechaDevolucion, double pagoTotal, boolean pagoMoroso, boolean libroDevuelto) {
        this.carnetEstudiante = carnetEstudiante;
        this.codigoLibro = codigoLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.pagoTotal = pagoTotal;
        this.pagoMoroso = pagoMoroso;
        this.libroDevuelto = libroDevuelto;
        this.No_ID = No_ID;
    }

    public Prestamo() {
    }

    public int getNo_ID() {
        return No_ID;
    }

    public void setNo_ID(int No_ID) {
        int noIDAnt = this.No_ID;
        this.No_ID = No_ID;
        propertySupport.firePropertyChange("No_ID", noIDAnt, this.No_ID);
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        String carnetAnt = this.carnetEstudiante;
        this.carnetEstudiante = carnetEstudiante;
        propertySupport.firePropertyChange("CarnetEstudiante", carnetAnt, this.carnetEstudiante);
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        String codigo = this.codigoLibro;
        this.codigoLibro = codigoLibro;
        propertySupport.firePropertyChange("CodigoLibro", codigo, this.codigoLibro);
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        Date fechaAnterior = this.fechaPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        propertySupport.firePropertyChange("FechaPrestamo", fechaAnterior, this.fechaPrestamo);
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        Date fechaDev = this.fechaDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        propertySupport.firePropertyChange("FechaDeovolucion", fechaDev, this.fechaDevolucion);
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        double totalAnt = this.pagoTotal;
        this.pagoTotal = pagoTotal;
        propertySupport.firePropertyChange("PagoTotal", totalAnt, this.pagoTotal);
    }

    public boolean isPagoMoroso() {
        return pagoMoroso;
    }

    public void setPagoMoroso(boolean pagoMoroso) {
        boolean pagoMora = this.pagoMoroso;
        this.pagoMoroso = pagoMoroso;
        propertySupport.firePropertyChange("PagoMoroso", pagoMora, this.pagoMoroso);
    }

    public boolean isLibroDevuelto() {
        return libroDevuelto;
    }

    public void setLibroDevuelto(boolean libroDevuelto) {
        boolean libroDev = this.libroDevuelto;
        this.libroDevuelto = libroDevuelto;
        propertySupport.firePropertyChange("LibroDevuelto", libroDev, this.libroDevuelto);
    }

    @Override
    public Prestamo clone() {
        return new Prestamo(this.No_ID, this.carnetEstudiante, this.codigoLibro, this.fechaPrestamo, this.fechaDevolucion, this.pagoTotal, this.pagoMoroso, this.libroDevuelto);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
