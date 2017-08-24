package backend.ManejadorDB;

import backend.prestamos.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class prestamosManejadorDB {

    ValoresPredeterminados valoresPre;
    private Connection coneccion;
    Prestamo prestamo;

    public prestamosManejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }
//    String Carnet_Estudiante, String Codigo_Libro, String Fecha_Prestamo, String Fecha_Devolucion,String Pago_Total, String Pago_Moroso, String Libro_Devuelto

    public void nuevoPrestamo(String Carnet, String codigoLibro, String fechaPrestamo)throws SQLException{
        try {
            String query = ("INSERT INTO PRESTAMO(Carnet_Estudiante, Codigo_Libro, Fecha_Prestamo) VALUES (?,?,?);");
            
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, Carnet);
            objeto.setString(2, codigoLibro);
            objeto.setString(3, fechaPrestamo);
        } catch (SQLException e) {
             Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
