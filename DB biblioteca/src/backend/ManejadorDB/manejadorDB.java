package backend.ManejadorDB;

import backend.personas.Estudiante;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author angel
 */
public class manejadorDB {

    private Connection coneccion;

    public manejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }

//    public void añadirEstudiante(String carnet, String codigoCarrera, String nombre, LocalDate fechaDeNacimiento) throws SQLException {
//        Statement estudiante = coneccion.createStatement();
//        String est= "INSERT INTO ESTUDIANTE("carnet","nombre","codigoCarrera",)";
//        estudiante.executeUpdate(est);
//    }
}
