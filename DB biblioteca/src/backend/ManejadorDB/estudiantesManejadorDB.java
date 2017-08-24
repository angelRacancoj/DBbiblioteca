package backend.ManejadorDB;

import backend.personas.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class estudiantesManejadorDB {

    ValoresPredeterminados valoresPre;
    private Connection coneccion;
    Estudiante estudiante;

    public estudiantesManejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }

    public void agregarEstudiante(String carnet, String codigoCarrera, String nombre, String fechaNacimiento) throws SQLException {
        try {
            
            String query = ("INSERT INTO ESTUDIANTE (Carnet, Codigo_Carrera, Nombre, Fecha_Nacimiento) VALUES (?,?,?,?)");
            
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, carnet);
            objeto.setString(2, codigoCarrera);
            objeto.setString(3, nombre);
            objeto.setString(4, fechaNacimiento);

            objeto.execute();

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
