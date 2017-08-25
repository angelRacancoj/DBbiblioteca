package backend.personas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Persona implements Serializable{
    
    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    
    protected String nombre;
    protected Date fechaDeNacimiento;
    
    public static final String PROP_NOMBRE= "nombre";

    public Persona(String nombre, Date fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String nombreAnterior= this.nombre;
        this.nombre = nombre;
        propertySupport.firePropertyChange(PROP_NOMBRE, nombreAnterior, nombre);
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public Persona clone(){
        return new Persona(this.nombre,this.fechaDeNacimiento);
    }
    
        public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
