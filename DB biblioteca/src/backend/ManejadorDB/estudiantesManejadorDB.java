package backend.ManejadorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class estudiantesManejadorDB {

    private Connection coneccion;

    public estudiantesManejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }

    public void agregarEstudiante(String carnet, String codigoCarrera, String nombre, Date fechaNacimiento) throws SQLException {
        Statement declaracion = null;
        try {
            declaracion = coneccion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet objeto = declaracion.executeQuery("SELECT * FROM DB_BIBLIOTECA.ESTUDIANTE");
            objeto.moveToInsertRow();
            objeto.updateString("Carnet", carnet);
            objeto.updateString("CodigoCarrera", codigoCarrera);
            objeto.updateString("Nombre", nombre);
            objeto.updateDate("Fecha_Nacimiento", (java.sql.Date) fechaNacimiento);

            objeto.insertRow();
            objeto.beforeFirst();

        } catch (SQLException e) {
            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void modificarEstudiante(String carnet){
        
    }
    
    public String buscarEstudiantePorCarnet(String carnet){
        
        return null;
    }
}
