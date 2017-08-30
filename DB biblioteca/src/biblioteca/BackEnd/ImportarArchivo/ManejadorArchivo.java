package biblioteca.BackEnd.ImportarArchivo;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author angel
 */
public class ManejadorArchivo {
    BufferedReader lectura;

    public void lecturaDelArchivo() throws FileNotFoundException, IOException {
        String datos = "";
        String dato1 = "";
        lectura = new BufferedReader(new FileReader("/home/angel/archivo_prueba.txt"));
         while((datos = lectura.readLine())!=null){
            dato1= dato1 + datos+"\n";
        }
        System.out.println(dato1);
    }
}
