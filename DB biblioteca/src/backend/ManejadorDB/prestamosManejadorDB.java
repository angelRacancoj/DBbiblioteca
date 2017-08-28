package backend.ManejadorDB;

import backend.prestamos.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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

    public void nuevoPrestamo(String Carnet, String codigoLibro, String fechaPrestamo) throws SQLException {
        try {
            String query = ("INSERT INTO PRESTAMO(Carnet_Estudiante, Codigo_Libro, Fecha_Prestamo) VALUES (?,?,?);");

            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, Carnet);
            objeto.setString(2, codigoLibro);
            objeto.setString(3, fechaPrestamo);

            objeto.execute();
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int cantidadDelDias(String fechaInicial, String fechaFinal) throws SQLException {
        int dias = 0;
        try {
            String query = ("SELECT DATEDIFF(?,?) AS CantDias");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, fechaFinal);
            objeto.setString(2, fechaInicial);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                dias = resultado.getInt("CantDias");
            }
            return dias;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return dias;
    }
//    Carnet_Estudiante CHAR, Codigo_Libro CHAR, Fecha_Prestamo DATE, Fecha_Devolucion DATE, Pago_Total DOUBLE, Pago_Moroso INT, Libro_Devuelto INT

    public boolean devolverLibro(Prestamo Devolucion) {
        boolean exito = false;
        try {
            String query = ("UPDATE PRESTAMO SET Fecha_Devolucion =?, Pago_Total=?, Pago_Moroso=?, Libro_Divuelto=? WHERE Carnet_Estudiante=? AND Codigo_Libro=? AND Fecha_Prestamo=?");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, valoresPre.fecha());
            objeto.setString(2, Costo(String.valueOf(Devolucion.getFechaPrestamo()), valoresPre.fecha()));
            objeto.setString(3, pagoMorosoONormal(String.valueOf(Devolucion.getFechaPrestamo()), valoresPre.fecha()));
            objeto.setString(4,"1");
            objeto.setString(5,Devolucion.getCarnetEstudiante());
            objeto.setString(6,Devolucion.getCodigoLibro());
            objeto.setString(7,String.valueOf(Devolucion.getFechaPrestamo()));

            exito = objeto.execute();
            return exito;
        } catch (SQLException e) {
        }
        return exito;
    }
    
    public String pagoMorosoONormal(String fechaInicial, String fechaFinal) throws SQLException{
        int dias = cantidadDelDias(fechaInicial, fechaFinal);
        if (dias<=ValoresPredeterminados.LIMITE_DIAS_SIN_MORA) {
            return "0";
        }
        return "1";
    }

    public String Costo(String fechaInicial, String fechaFinal) throws SQLException {
        int total = 0;
        int dias = cantidadDelDias(fechaInicial, fechaFinal);

        if (dias <= ValoresPredeterminados.LIMITE_DIAS_SIN_MORA) {
            String query = ("SELECT (?-?)*? TOTAL");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setInt(1, dias);
            objeto.setInt(2, ValoresPredeterminados.DIAS_HABILES_SIN_COSTO);
            objeto.setInt(3, ValoresPredeterminados.PRECIO_PRESTAMO_NORMAL);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                total = resultado.getInt("TOTAL");
            }
            return String.valueOf(total);

        }
        if (dias > ValoresPredeterminados.LIMITE_DIAS_SIN_MORA) {
            String query = ("SELECT ?*? + (?-?)*? TOTAL");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setInt(1, ValoresPredeterminados.LIMITE_DIAS_HABILES_PRESTAMO);
            objeto.setInt(2, ValoresPredeterminados.PRECIO_PRESTAMO_NORMAL);
            objeto.setInt(3, dias);
            objeto.setInt(4, ValoresPredeterminados.LIMITE_DIAS_SIN_MORA);
            objeto.setInt(5, ValoresPredeterminados.PRECIO_PRESTAMO_MOROSO);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                total = resultado.getInt("TOTAL");
            }
            return String.valueOf(total);
        }
        return ("0");
    }
}
