package backend.leturaArchivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author angel
 */
public class LectorDeArchivo {

    public static void LeerArchivo(String rutaArchivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader archivo = new FileReader(rutaArchivo);
        BufferedReader linea = new BufferedReader(archivo);
        while ((cadena = linea.readLine()) != null) {
            System.out.println(cadena);
        }
        linea.close();
    }
}
