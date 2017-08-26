package backend.personas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class Estudiante extends Persona implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String carnet;
    private String codigoCarrera;

    public static final String PROP_CARNET = "carnet";
    public static final String PROP_COD_CARRERA = " codigoCarrera";

    public Estudiante(String carnet, String codigoCarrera, String nombre, Date fechaDeNacimiento) {
        super(nombre, fechaDeNacimiento);
        this.carnet = carnet;
        this.codigoCarrera = codigoCarrera;
    }

    public Estudiante() {
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        String carnetAntiguo = this.carnet;
        this.carnet = carnet;
        propertySupport.firePropertyChange(PROP_CARNET, carnetAntiguo, carnet);
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        String codCarreaAntiguo = this.codigoCarrera;
        this.codigoCarrera = codigoCarrera;
        propertySupport.firePropertyChange(PROP_COD_CARRERA, codCarreaAntiguo, codigoCarrera);
    }

    public String getCodigoCarreraNombre() {
        switch (codigoCarrera) {
            case ValoresPredeterminados.CODIGO_CARRERA_1:
                return ValoresPredeterminados.CARRERA_1;
            case ValoresPredeterminados.CODIGO_CARRERA_2:
                return ValoresPredeterminados.CARRERA_2;
            case ValoresPredeterminados.CODIGO_CARRERA_3:
                return ValoresPredeterminados.CARRERA_3;
            case ValoresPredeterminados.CODIGO_CARRERA_4:
                return ValoresPredeterminados.CARRERA_4;
            case ValoresPredeterminados.CODIGO_CARRERA_5:
                return ValoresPredeterminados.CARRERA_5;
        }
        return null;
    }

    @Override
    public Estudiante clone() {
        return new Estudiante(this.carnet, this.codigoCarrera, this.nombre, this.fechaDeNacimiento);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
