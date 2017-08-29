package backend.leturaArchivo;

import backend.libros.Libro;
import backend.personas.Estudiante;
import backend.prestamos.Prestamo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author angel
 */
public class LectorDeArchivo {
    List<Libro> listalibrosCorrectos;
    List<Libro> listalibrosConErrores;
    List<Estudiante> listaEstudiantesCorrectos;
    List<Estudiante> listaEstudiantesConError;
    List<Prestamo>listaprestamosCorrectos;
    List<Prestamo>listaprestamosConError;

    public static void LeerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader archivo = new FileReader(rutaArchivo);
        BufferedReader linea = new BufferedReader(archivo);
        while ((cadena = linea.readLine()) != null) {
            if (cadena =="LIBRO") {
                
            }else if (cadena=="ESTUDIANTE") {
                
            }else if (cadena == "PRESTAMO") {
                
            }
        }
        linea.close();
    }
}
