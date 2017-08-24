package backend.ManejadorDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class libroManejadorDB {

    private Connection coneccion;
    ValoresPredeterminados valoresPre;

    public libroManejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }

    public void agregarLibro(String codigo, String autor, String titulo, String cantLibros, String fechaPublicacion, String editorial, String cantLibrosDisponibles) throws SQLException {
        Statement declaracion = null;
        try {
            
            String query = ("INSERT INTO LIBRO(Codigo,Autor, Titulo,Cantidad_libros, Fecha_Publicacion, Editorial, Cant_Libros_Disponibles) VALUES (?,?,?,?,?,?,?)");
                        
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, codigo);
            objeto.setString(2, autor);
            objeto.setString(3, titulo);
            objeto.setString(4, cantLibros);
            objeto.setString(5, fechaPublicacion);
            objeto.setString(6, editorial);
            objeto.setString(7, cantLibrosDisponibles);
            
            objeto.execute();
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void modificarLibro(String codigo){
        
    }
    
    public boolean buscarLibroPorCodigo(String codigo){
        
        return false;
    }
}
