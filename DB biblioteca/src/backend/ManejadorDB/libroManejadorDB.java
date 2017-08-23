package backend.ManejadorDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class libroManejadorDB {

    private Connection coneccion;

    public libroManejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }

    public void agregarLibro(String codigo, String autor, String titulo, int cantLibros, Date fechaPublicacion, String editorial, int cantLibrosDisponibles) throws SQLException {
        Statement declaracion = null;
        try {
            declaracion = coneccion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet objeto = declaracion.executeQuery("SELECT * FROM DB_BIBLIOTECA.LIBRO");

            objeto.updateString("Codigo", codigo);
            objeto.updateString("Autor", autor);
            objeto.updateString("Titulo", titulo);
            objeto.updateInt("Cantidad_libros", cantLibros);
            objeto.updateDate("Fecha_Publicacion", fechaPublicacion);
            objeto.updateString("Editorial", editorial);
            objeto.updateInt("Cant_Libros_Disponibles", cantLibrosDisponibles);

            objeto.insertRow();
            objeto.beforeFirst();

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
