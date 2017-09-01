package backend.leturaArchivo;

import backend.ManejadorDB.estudiantesManejadorDB;
import backend.ManejadorDB.libroManejadorDB;
import backend.ManejadorDB.prestamosManejadorDB;
import backend.libros.Libro;
import backend.personas.Estudiante;
import backend.prestamos.Prestamo;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import biblioteca.BackEnd.Excepciones.ValidacionExcepcion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author angel
 */
public class LectorDeArchivo {

    ArrayList<Estudiante> estudiante;
    ArrayList<Estudiante> estudianteConError;
    ArrayList<Libro> libro;
    ArrayList<Libro> libroConError;
    ArrayList<Prestamo> prestamos;
    ArrayList<Prestamo> prestamosConError;
    LectorDeDatos leerDatos;
    
    estudiantesManejadorDB manejadorEst;
    libroManejadorDB manejadorLibros;
    prestamosManejadorDB manejadorPrestamos;

    public LectorDeArchivo() {
        estudiante = new ArrayList<>();
        estudianteConError = new ArrayList<>();
        libro = new ArrayList<>();
        libroConError = new ArrayList<>();
        prestamos = new ArrayList<>();
        prestamosConError = new ArrayList<>();
        leerDatos = new LectorDeDatos();
    }

    public void Importar(String path) throws IOException, ValidacionExcepcion, InputsVaciosException {

        File lectura = new File(path);

        estudiante.clear();
        estudiante = leerDatos.leerEstudiantes(lectura);
        System.out.println("Estudiantes: " + estudiante.size());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        estudianteConError.clear();
        estudianteConError = leerDatos.leerEstudianteConError(lectura);
        System.out.println("Estudiantes con error: " + estudianteConError.size());
        System.out.println("======================================");

        libro.clear();
        libro = leerDatos.leerLibros(lectura);
        System.out.println("Libros: " + libro.size());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        libroConError.clear();
        libroConError = leerDatos.leerLibrosConError(lectura);
        System.out.println("Libros con Error: " + libroConError.size());
        System.out.println("########################################");

        prestamos.clear();
        prestamos = leerDatos.leerPrestamos(lectura);
        System.out.println("Prestamos: " + prestamos.size());
        System.out.println("-----------------------------------------");

        prestamosConError.clear();
        prestamosConError = leerDatos.leerPrestamosConError(lectura);
        System.out.println("Prestamos con Error: " + prestamosConError.size());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public ArrayList<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(ArrayList<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Estudiante> getEstudianteConError() {
        return estudianteConError;
    }

    public void setEstudianteConError(ArrayList<Estudiante> estudianteConError) {
        this.estudianteConError = estudianteConError;
    }

    public ArrayList<Libro> getLibro() {
        return libro;
    }

    public void setLibro(ArrayList<Libro> libro) {
        this.libro = libro;
    }

    public ArrayList<Libro> getLibroConError() {
        return libroConError;
    }

    public void setLibroConError(ArrayList<Libro> libroConError) {
        this.libroConError = libroConError;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public ArrayList<Prestamo> getPrestamosConError() {
        return prestamosConError;
    }

    public void setPrestamosConError(ArrayList<Prestamo> prestamosConError) {
        this.prestamosConError = prestamosConError;
    }
    
}
