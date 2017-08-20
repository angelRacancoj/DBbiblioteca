package backend.libros;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author angel
 */
public class Libro implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    private String codigo;
    private String autor;
    private String titulo;
    private int cantidadLibros;
    private LocalDate fechaPublicacion;
    private String editorial;
    private int cantidadLibrosDisponibles;
    
    public static final String PROP_COD_LIBRO = "codigoLibro";
    public static final String PROP_AUTOR = "Autor";
    public static final String PROP_TITULO = "Titulo";
    public static final String PROP_CANT_LIBROS = "cantidadLibros";
    public static final String PROP_CANT_LIBROS_DISPONIBLES = "cantidadLibrosDisponibles";
    public static final String PROP_EDITORIAL = "editorial";

    public Libro(String codigo, String autor, String titulo, int cantidadLibros, LocalDate fechaPublicacion, String editorial, int cantidadLibrosDisponibles) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.cantidadLibros = cantidadLibros;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.cantidadLibrosDisponibles = cantidadLibrosDisponibles;
    }

    public Libro() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String codigoAntiguo = this.codigo;
        this.codigo = codigo;
        propertySupport.firePropertyChange(PROP_COD_LIBRO, codigoAntiguo,codigo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String Autor) {
        String autorAnterior = this.autor;
        this.autor = Autor;
        propertySupport.firePropertyChange(PROP_AUTOR, autorAnterior, Autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String tituloAnterio = this.titulo;
        this.titulo = titulo;
        propertySupport.firePropertyChange(PROP_TITULO, tituloAnterio, titulo);
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        int cantidadAnterior = this.cantidadLibros;
        this.cantidadLibros = cantidadLibros;
        propertySupport.firePropertyChange(PROP_CANT_LIBROS, cantidadAnterior, cantidadLibros);
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        String editorialAnterior = this.editorial;
        this.editorial = editorial;
        propertySupport.firePropertyChange(PROP_EDITORIAL, editorialAnterior,editorial);
    }

    public int getCantidadLibrosDisponibles() {
        return cantidadLibrosDisponibles;
    }

    public void setCantidadLibrosDisponibles(int cantidadLibrosDisponibles) {
        int cantidadLibrosDisponiblesAnterior = this.cantidadLibrosDisponibles;
        this.cantidadLibrosDisponibles = cantidadLibrosDisponibles;
        propertySupport.firePropertyChange(PROP_CANT_LIBROS_DISPONIBLES, cantidadLibrosDisponiblesAnterior,cantidadLibrosDisponibles);
    }
    
    public Libro clone(){
        return new Libro(this.codigo,this.autor, this.titulo,this.cantidadLibros,this.fechaPublicacion,this.editorial,this.cantidadLibrosDisponibles);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
