package backend.ManejadorDB;

import backend.personas.Estudiante;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class estudiantesManejadorDB {
//    Carnet CHAR, Codigo_Carrera CHAR, Nombre CHAR, Fecha_Nacimiento DATE 

    ValoresPredeterminados valoresPre;
    private Connection conexion;
    Estudiante estudiante;

    List<Estudiante> busquedaEstudiante = new ArrayList<>();

    public estudiantesManejadorDB(Connection coneccion) {
        this.conexion = coneccion;
    }

    public void agregarEstudiante(String carnet, String codigoCarrera, String nombre, String fechaNacimiento) throws SQLException {
        try {

            String query = ("INSERT INTO ESTUDIANTE (Carnet, Codigo_Carrera, Nombre, Fecha_Nacimiento) VALUES (?,?,?,?)");

            PreparedStatement objeto = conexion.prepareStatement(query);
            objeto.setString(1, carnet);
            objeto.setString(2, codigoCarrera);
            objeto.setString(3, nombre);
            objeto.setString(4, fechaNacimiento);

            objeto.execute();

        } catch (SQLException e) {
            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void modificarEstudiante(String carnet) {

    }

    public List<Estudiante> consultaEstudiantesFiltros(String carnetEst, String CodCarrera, String nombreEst) throws SQLException {
        boolean carnet = carnetEst.replace(" ", "").isEmpty();
        boolean codigoCarrera = CodCarrera.replace(" ", "").isEmpty();
        boolean nombre = nombreEst.replace(" ", "").isEmpty();
        try {
            if (codigoCarrera && carnet && nombre) {
                String query = ("SELECT *FROM ESTUDIANTE ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;

            } else if (carnet && codigoCarrera) {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Nombre LIKE ? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, nombreEst + '%');
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;

            } else if (codigoCarrera && nombre) {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Carnet=? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, carnetEst);
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;

            } else if (nombre && carnet) {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Codigo_Carrera=? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, CodCarrera);
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;

            } else if (carnet) {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Codigo_Carrera=? AND Nombre LIKE ? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, CodCarrera);
                sentencia.setString(2, nombreEst + '%');
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;

            } else if (codigoCarrera) {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Carnet=? AND Nombre LIKE ? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, carnetEst);
                sentencia.setString(2, nombreEst + '%');
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;

            } else if (nombre) {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Carnet=? AND Codigo_Carrera=? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, carnetEst);
                sentencia.setString(2, CodCarrera);
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;
            } else {
                String query = ("SELECT *FROM ESTUDIANTE WHERE Carnet=? AND Codigo_Carrera=? AND Nombre LIKE ? ORDER BY Carnet ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, carnetEst);
                sentencia.setString(2, CodCarrera);
                sentencia.setString(3, nombreEst + '%');
                List est = consutlaEstudiantesPS(sentencia);
                sentencia.close();
                return est;
            }
        } catch (SQLException e) {
            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Estudiante> consutlaEstudiantesPS(PreparedStatement sentencia) throws SQLException {

        busquedaEstudiante.clear();

        try {
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String carnet = resultado.getString("Carnet");
                String codigoCarr = resultado.getString("Codigo_Carrera");
                String nombre = resultado.getString("Nombre");
                Date cumple = resultado.getDate("Fecha_Nacimiento");
                Estudiante estudiante = new Estudiante(carnet, codigoCarr, nombre, cumple);
                System.out.println("datos: " + carnet + "," + codigoCarr + "," + nombre + "," + cumple);
                busquedaEstudiante.add(estudiante);

            }
            System.out.println("----------------------------------------------");
            resultado.close();
        } catch (SQLException e) {
            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return busquedaEstudiante;
    }

//    public List<Estudiante> buscarEstudiantePorCarnet(String carnet) throws SQLException {
//
//        busquedaEstudiante.clear();
//        Statement sentencia = null;
//        String query = ("SELECT *FROM ESTUDIANTE WHERE CARNET = '" + carnet + "'");
//        try {
//            sentencia = conexion.createStatement();
//            ResultSet resultado = sentencia.executeQuery(query);
//
//            while (resultado.next()) {
//                String carne = resultado.getString("Carnet");
//                String codigoCarr = resultado.getString("Codigo_Carrera");
//                String nombre = resultado.getString("Nombre");
//                Date cumple = resultado.getDate("Fecha_Nacimiento");
//                Estudiante estudiante = new Estudiante(carne, codigoCarr, nombre, cumple);
//                System.out.println("datos: " + carne + "," + codigoCarr + "," + nombre + "," + cumple);
//                busquedaEstudiante.add(estudiante);
//            }
//            System.out.println("+++++++++++++++++++++++++++++++++++++");
//        } catch (SQLException e) {
//            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return busquedaEstudiante;
//    }
    public boolean existeEstiantePorCarnet(String carnet) throws SQLException {
        int noRegistros = 0;
        try {

            String query = ("SELECT COUNT(*) FROM ESTUDIANTE WHERE CARNET = ?");

            PreparedStatement objeto = conexion.prepareStatement(query);
            objeto.setString(1, carnet);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                noRegistros = resultado.getInt("COUNT(*)");
            }
            if (noRegistros >= 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    //    public List<Estudiante> consutlaEstudiantes() throws SQLException {
//
//        busquedaEstudiante.clear();
//        PreparedStatement sentencia = null;
////        String query = ("SELECT *FROM ESTUDIANTE");
//        String query = ("SELECT *FROM ESTUDIANTE ORDER BY Carnet ASC");
//        try {
//            sentencia = conexion.prepareStatement(query);
//            ResultSet resultado = sentencia.executeQuery();
//
//            while (resultado.next()) {
//                String carnet = resultado.getString("Carnet");
//                String codigoCarr = resultado.getString("Codigo_Carrera");
//                String nombre = resultado.getString("Nombre");
//                Date cumple = resultado.getDate("Fecha_Nacimiento");
//                Estudiante estudiante = new Estudiante(carnet, codigoCarr, nombre, cumple);
//                System.out.println("datos: " + carnet + "," + codigoCarr + "," + nombre + "," + cumple);
//                busquedaEstudiante.add(estudiante);
//
//            }
//            System.out.println("----------------------------------------------");
//            resultado.close();
//            sentencia.close();
//        } catch (SQLException e) {
//            Logger.getLogger(estudiantesManejadorDB.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return busquedaEstudiante;
//    }
}
