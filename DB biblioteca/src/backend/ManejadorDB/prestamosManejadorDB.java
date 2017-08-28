package backend.ManejadorDB;

import backend.prestamos.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class prestamosManejadorDB {

    ValoresPredeterminados valoresPre;
    private Connection coneccion;

    List<Prestamo> busquedaPrestamo = new ArrayList<>();

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
            objeto.setString(4, "1");
            objeto.setString(5, Devolucion.getCarnetEstudiante());
            objeto.setString(6, Devolucion.getCodigoLibro());
            objeto.setString(7, String.valueOf(Devolucion.getFechaPrestamo()));

            exito = objeto.execute();
            return exito;
        } catch (SQLException e) {
        }
        return exito;
    }

    public List<Prestamo> consultasPrestamos(int opciones, String fechaInicial, String fechaFinal, String carnetEst) throws SQLException {
        PreparedStatement sentencia;
        String codigo;
        List prestamos;
        try {
            switch (opciones) {
                case ValoresPredeterminados.TodoPrestamoYDevolucion:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO");
                    prestamos = consultaPrestamoPS(sentencia);
                    sentencia.close();
                    return prestamos;
                case ValoresPredeterminados.TodoPrestamoPendientes:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Divuelto <> 1");
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
                case ValoresPredeterminados.LibrosPorEntregarHoy:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Divuelto <> '1' AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, restarDias(valoresPre.fecha(), ValoresPredeterminados.LIMITE_DIAS_SIN_MORA));
                    sentencia.setString(2, valoresPre.fecha());
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
                case ValoresPredeterminados.LibrosPrestadosConMora:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Divuelto <> '1' AND Fecha_Prestamo > ?");
                    sentencia.setString(1, restarDias(valoresPre.fecha(), ValoresPredeterminados.LIMITE_DIAS_SIN_MORA));
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
                case ValoresPredeterminados.GananciasIntervaloTiempo:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Divuelto = '1' AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, fechaInicial);
                    sentencia.setString(2, fechaFinal);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
                case ValoresPredeterminados.CarreraMasPrestamos:
                    sentencia = coneccion.prepareStatement("SELECT Carnet_Estudiante, Codigo_Libro, Fecha_Prestamo, Fecha_Devolucion, Pago_Total, Pago_Moroso, Libro_Devuelto"
                            + "FROM PRESTAMO,ESTUDIANTE WHERE Carnet=Carnet_Estudiante AND Codigo_Carrera=? AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, obtenerCarreraConMasRegistros());
                    sentencia.setString(2, fechaInicial);
                    sentencia.setString(3, fechaFinal);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
            }
        } catch (Exception e) {
        }
//        SELECT Codigo_Carrera, COUNT(*) FROM ESTUDIANTE, PRESTAMO WHERE Carnet=Carnet_Estudiante GROUP BY Codigo_Carrera ORDER BY COUNT(*) ASC LIMIT 1
    }
//    String carnetEstudiante, String codigoLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, double pagoTotal, boolean pagoMoroso, boolean libroDevuelto
    //    Carnet_Estudiante CHAR, Codigo_Libro CHAR, Fecha_Prestamo DATE, Fecha_Devolucion DATE, Pago_Total DOUBLE, Pago_Moroso INT, Libro_Devuelto INT

    public List<Prestamo> consultaPrestamoPS(PreparedStatement sentencia) throws SQLException {
        busquedaPrestamo.clear();
        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String carnetEst = resultado.getString("Carnet_Estudiante");
                String codLibro = resultado.getString("Codigo_Libro");
                Date fechaPrestamo = resultado.getDate("Fecha_Prestamo");
                Date fechaDevolucion = resultado.getDate("Fecha_Devolucion");
                Double Pago_Total = resultado.getDouble("Pago_Total");
                boolean pagoMoroso = resultado.getBoolean("Pago_Moroso");
                boolean libroDevuelto = resultado.getBoolean("Libro_Devuelto");
                Prestamo prestamo = new Prestamo(carnetEst, codLibro, fechaPrestamo, fechaDevolucion, Pago_Total, pagoMoroso, libroDevuelto);
                System.out.println("Prestamo: " + carnetEst + ", " + codLibro + ", " + fechaPrestamo + ", " + fechaDevolucion + ", " + Pago_Total + ", " + pagoMoroso + ", " + libroDevuelto);
                busquedaPrestamo.add(prestamo);
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            resultado.close();
        } catch (SQLException e) {
        }
        return busquedaPrestamo;
    }

    public String totalPrestamoIntTiempo(String fechaInicial, String fechaFinal) throws SQLException {
        String total = null;
        int Pago_Total = 0;
        try {
            PreparedStatement sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Divuelto = '1' AND Fecha_Prestamo BETWEEN ? AND ?");
            sentencia.setString(1, fechaInicial);
            sentencia.setString(2, fechaFinal);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Pago_Total += (resultado.getInt("Pago_Total"));
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            return String.valueOf(Pago_Total);
        } catch (SQLException e) {
        }
        return "0";
    }

    public String pagoMorosoONormal(String fechaInicial, String fechaFinal) throws SQLException {
        int dias = cantidadDelDias(fechaInicial, fechaFinal);
        if (dias <= ValoresPredeterminados.LIMITE_DIAS_SIN_MORA) {
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

    public String restarDias(String fecha, int diasDeDiferencia) throws SQLException {
        try {
            String fechaRestada = null;
            PreparedStatement objeto = coneccion.prepareStatement("SELECT date_sub(?, INTERVAL ? DAY) FECHA");
            objeto.setString(1, fecha);
            objeto.setInt(2, diasDeDiferencia);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                fechaRestada = resultado.getString("FECHA");
            }
            return fechaRestada;
        } catch (SQLException e) {
        }
        return null;
    }

    public String obtenerCarreraConMasRegistros() {
        String codigoCarrera = null;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT Codigo_Carrera, COUNT(*) FROM ESTUDIANTE, PRESTAMO WHERE Carnet=Carnet_Estudiante GROUP BY Codigo_Carrera ORDER BY COUNT(*) ASC LIMIT 1");
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                codigoCarrera = resultado.getString("Codigo_Carrera");
            }
            return codigoCarrera;
        } catch (Exception e) {
        }
        return null;
    }
}
