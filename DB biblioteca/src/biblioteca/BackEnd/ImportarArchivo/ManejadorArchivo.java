package biblioteca.BackEnd.ImportarArchivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author angel
 */
public class ManejadorArchivo {

    public String lecturaDelArchivo(String path) {
        String infoArchivo = "";
        FileReader lector = null;
        BufferedReader buffer = null;
        try {
            lector = new FileReader(new File(path));
            buffer = new BufferedReader(lector);
            String data = buffer.readLine();
            String dataTemp = "";
            while (data != null) {
                dataTemp += data;
            }
            infoArchivo = dataTemp;
        } catch (Exception e) {
        }
        return infoArchivo;
    }
}
