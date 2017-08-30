package backend.ManejadorDB;

import backend.prestamos.Prestamo;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    libroManejadorDB manejadorLibro;

    List<Prestamo> busquedaPrestamo = new ArrayList<>();

    public prestamosManejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
        manejadorLibro = new libroManejadorDB(coneccion);
    }
//    String Carnet_Estudiante, String Codigo_Libro, String Fecha_Prestamo, String Fecha_Devolucion,String Pago_Total, String Pago_Moroso, String Libro_Devuelto

    /**
     * Recibe los datos del prestamo y los almacena en la base de datos
     *
     * @param Carnet
     * @param codigoLibro
     * @param fechaPrestamo
     * @throws SQLException
     */
    public void nuevoPrestamo(String Carnet, String codigoLibro, String fechaPrestamo) throws SQLException, InputsVaciosException {
        try {
            String query = ("INSERT INTO PRESTAMO(Carnet_Estudiante, Codigo_Libro, Fecha_Prestamo, Libro_Devuelto) VALUES (?,?,?,?);");

            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, Carnet);
            objeto.setString(2, codigoLibro);
            objeto.setString(3, fechaPrestamo);
            objeto.setString(4, ValoresPredeterminados.prestar);
            objeto.execute();
            manejadorLibro.modificarCantidadLibroDisponibles(codigoLibro, true);
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Se tiene dos fechas y se puedo obtener la diferencia entre estas si la
     * diferncia es negativa lanzara un error de ingreso de datos
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws biblioteca.BackEnd.Excepciones.InputsVaciosException
     */
    public int cantidadDelDias(String fechaInicial, String fechaFinal) throws SQLException, InputsVaciosException {
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
//    throw new InputsVaciosException("Ya existe el estudiante con el carnet: " + carnet);
//    Carnet_Estudiante CHAR, Codigo_Libro CHAR, Fecha_Prestamo DATE, Fecha_Devolucion DATE, Pago_Total DOUBLE, Pago_Moroso INT, Libro_Devuelto INT

    /**
     * Recibe el objeto prestamo del FronEnd para tratas los datos, creando una
     * devolucion llenado los campos que se no se llenaron ya que son propios de
     * la devolucion TRUE = operacion realizado con exito FALSE = operacion
     * fallida
     *
     * @param Devolucion
     * @return
     * @throws InputsVaciosException
     */
    public boolean devolverLibro(Prestamo Devolucion) throws InputsVaciosException {
        boolean exito = false;
        try {
            String query = ("UPDATE PRESTAMO SET Fecha_Devolucion =?, Pago_Total=?, Pago_Moroso=?, Libro_Devuelto=? WHERE No_ID=?, Carnet_Estudiante=? AND Codigo_Libro=? AND Fecha_Prestamo=?");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, String.valueOf(fecha()));
            objeto.setString(2, Costo(String.valueOf(Devolucion.getFechaPrestamo()), String.valueOf(Devolucion.getFechaDevolucion())));
            objeto.setString(3, pagoMorosoONormal(String.valueOf(Devolucion.getFechaPrestamo()), String.valueOf(Devolucion.getFechaDevolucion())));
            objeto.setString(4, "1");
            objeto.setString(5, String.valueOf(Devolucion.getNo_ID()));
            objeto.setString(6, Devolucion.getCarnetEstudiante());
            objeto.setString(7, Devolucion.getCodigoLibro());
            objeto.setString(8, String.valueOf(Devolucion.getFechaPrestamo()));
            exito = objeto.execute();
            manejadorLibro.modificarCantidadLibroDisponibles(Devolucion.getCodigoLibro(), false);
            return exito;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }

    public boolean devolverLibroDatos(int No_ID, String carnetEst, String codigoLibro, String fechaPrestamo, String fechaDevolucion) throws SQLException, InputsVaciosException {
        boolean exito = false;
        try {
            String query = ("UPDATE PRESTAMO SET Fecha_Devolucion =?, Pago_Total=?, Pago_Moroso=?, Libro_Devuelto=? WHERE No_ID=? AND Carnet_Estudiante=? AND Codigo_Libro=? AND Fecha_Prestamo=?");
            PreparedStatement objeto = coneccion.prepareStatement(query);
            objeto.setString(1, fechaDevolucion);
            objeto.setString(2, Costo(fechaPrestamo, fechaDevolucion));
            objeto.setString(3, pagoMorosoONormal(fechaPrestamo, fechaDevolucion));
            objeto.setString(4, ValoresPredeterminados.devolver);
            objeto.setString(5, String.valueOf(No_ID));
            objeto.setString(6, carnetEst);
            objeto.setString(7, codigoLibro);
            objeto.setString(8, fechaPrestamo);

            exito = objeto.execute();
            return exito;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }

    /**
     * Reliza todas la comparaciones necesarias para obtener los listados con
     * los prestamos requeridos Este metodo se apoya de consultasPrestamoPS()
     * para la reutilizacion de codigo al enviar el PreparedStamente para solo
     * ser tratado y devolver las tablas para ser almacenadas en arrayList
     *
     * @param opciones
     * @param fechaInicial
     * @param fechaFinal
     * @param carnetEst
     * @return
     * @throws SQLException
     */
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
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Devuelto <> 1");
                    prestamos = consultaPrestamoPS(sentencia);
                    sentencia.close();
                    return prestamos;

                case ValoresPredeterminados.LibrosPorEntregarHoy:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Devuelto <> 1 AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, restarDias(String.valueOf(fecha()), ValoresPredeterminados.LIMITE_DIAS_SIN_MORA));
                    sentencia.setString(2, String.valueOf(fecha()));
                    prestamos = consultaPrestamoPS(sentencia);
                    sentencia.close();
                    return prestamos;

                case ValoresPredeterminados.LibrosPrestadosConMora:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Devuelto <> 1 AND Fecha_Prestamo < ?");
                    sentencia.setString(1, restarDias(String.valueOf(fecha()), ValoresPredeterminados.LIMITE_DIAS_SIN_MORA));
                    prestamos = consultaPrestamoPS(sentencia);
                    sentencia.close();
                    return prestamos;

                case ValoresPredeterminados.GananciasIntervaloTiempo:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Devuelto = 1 AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, fechaInicial);
                    sentencia.setString(2, fechaFinal);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;

                case ValoresPredeterminados.GananciasTotales:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Devuelto = 1");
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;

                case ValoresPredeterminados.CarreraMasPrestamos:
                    sentencia = coneccion.prepareStatement("SELECT No_ID, Carnet_Estudiante, Codigo_Libro, Fecha_Prestamo, Fecha_Devolucion, Pago_Total,"
                            + " Pago_Moroso, Libro_Devuelto FROM PRESTAMO,ESTUDIANTE WHERE Carnet=Carnet_Estudiante AND"
                            + " Codigo_Carrera=? AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, obtenerCarreraConMasRegistros());
                    sentencia.setString(2, fechaInicial);
                    sentencia.setString(3, fechaFinal);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;

                case ValoresPredeterminados.CarreraMasPrestamosGeneral:
                    sentencia = coneccion.prepareStatement("SELECT No_ID, Carnet_Estudiante, Codigo_Libro, Fecha_Prestamo, Fecha_Devolucion, Pago_Total,"
                            + " Pago_Moroso, Libro_Devuelto FROM PRESTAMO,ESTUDIANTE WHERE Carnet=Carnet_Estudiante AND Codigo_Carrera=?");
                    sentencia.setString(1, obtenerCarreraConMasRegistros());
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;

                case ValoresPredeterminados.ListadoMorasEstudiante:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Carnet_Estudiante=? AND Pago_Moroso= 1 "
                            + "AND Libro_Devuelto='1' AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, carnetEst);
                    sentencia.setString(2, fechaInicial);
                    sentencia.setString(3, fechaFinal);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;

                case ValoresPredeterminados.ListadoMorasEstudianteGeneral:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Carnet_Estudiante=? AND Pago_Moroso= 1 "
                            + "AND Libro_Devuelto='1'");
                    sentencia.setString(1, carnetEst);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;

                case ValoresPredeterminados.ListadoEstudianteMasPrestamos:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Carnet_Estudiante=? AND Fecha_Prestamo BETWEEN ? AND ?");
                    sentencia.setString(1, obtenerEstudianteConMasRegistros());
                    sentencia.setString(2, fechaInicial);
                    sentencia.setString(3, fechaFinal);
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
                case ValoresPredeterminados.ListadoEstudianteMasPrestamosGeneral:
                    sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Carnet_Estudiante=? ");
                    sentencia.setString(1, obtenerEstudianteConMasRegistros());
                    prestamos = consultaPrestamoPS(sentencia);
                    return prestamos;
            }
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
//    String carnetEstudiante, String codigoLibro, LocalDate fechaPrestamo, LocalDate fechaDevolucion, double pagoTotal, boolean pagoMoroso, boolean libroDevuelto
    //    Carnet_Estudiante CHAR, Codigo_Libro CHAR, Fecha_Prestamo DATE, Fecha_Devolucion DATE, Pago_Total DOUBLE, Pago_Moroso INT, Libro_Devuelto INT

    /**
     * Recibe los PreparedStatemens de la ConsultaPrestamos() para gnerar los
     * listados las listas y almacenarlos en un listado
     *
     * @param sentencia
     * @return
     * @throws SQLException
     */
    public List<Prestamo> consultaPrestamoPS(PreparedStatement sentencia) throws SQLException {
        busquedaPrestamo.clear();
        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int No_ID = resultado.getInt("No_ID");
                String carnetEst = resultado.getString("Carnet_Estudiante");
                String codLibro = resultado.getString("Codigo_Libro");
                Date fechaPrestamo = resultado.getDate("Fecha_Prestamo");
                Date fechaDevolucion = resultado.getDate("Fecha_Devolucion");
                Double Pago_Total = resultado.getDouble("Pago_Total");
                boolean pagoMoroso = resultado.getBoolean("Pago_Moroso");
                boolean libroDevuelto = resultado.getBoolean("Libro_Devuelto");
                Prestamo prestamo = new Prestamo(No_ID, carnetEst, codLibro, fechaPrestamo, fechaDevolucion, Pago_Total, pagoMoroso, libroDevuelto);
                System.out.println("Prestamo: " + carnetEst + ", " + codLibro + ", " + fechaPrestamo + ", " + fechaDevolucion + ", " + Pago_Total + ", " + pagoMoroso + ", " + libroDevuelto);
                busquedaPrestamo.add(prestamo);
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            resultado.close();
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return busquedaPrestamo;
    }

    /**
     * Este metodo se encarga de sumar todos los pagos en un intervalo de tiempo
     * estipulado por el usuario
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     */
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
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return "0";
    }
    
    public String totalPrestamo() throws SQLException {
        String total = null;
        int Pago_Total = 0;
        try {
            PreparedStatement sentencia = coneccion.prepareStatement("SELECT *FROM PRESTAMO WHERE Libro_Divuelto = '1'");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Pago_Total += (resultado.getInt("Pago_Total"));
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            return String.valueOf(Pago_Total);
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return "0";
    }

    /**
     * Este metodo es sencillo ya que se apoya en cantidadDeDias() para
     * considerar si el estudiante debe pagar mora
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public String pagoMorosoONormal(String fechaInicial, String fechaFinal) throws SQLException, InputsVaciosException {
        int dias = cantidadDelDias(fechaInicial, fechaFinal);
        if (dias <= ValoresPredeterminados.LIMITE_DIAS_SIN_MORA) {
            return "0";
        }
        return "1";
    }

    /**
     * Esta operacion de encarga de tratar los datos para guardar el total a
     * pagar por el estudiante, mostrando el monto final
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public String Costo(String fechaInicial, String fechaFinal) throws SQLException, InputsVaciosException {
        int total = 0;
        int dias = cantidadDelDias(fechaInicial, fechaFinal);

        try {
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
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return ("0");
    }

    /**
     * Este metodo nos es util para hallar la fecha de X dias antes de Hoy
     *
     * @param fecha
     * @param diasDeDiferencia
     * @return
     * @throws SQLException
     */
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
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Nos devuelve el codigo de la carrera que mas libros ha prestado
     *
     * @return
     */
    public String obtenerCarreraConMasRegistros() {
        String codigoCarrera = null;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT Codigo_Carrera, COUNT(*) FROM ESTUDIANTE, PRESTAMO WHERE Carnet=Carnet_Estudiante GROUP BY Codigo_Carrera ORDER BY COUNT(*) DESC LIMIT 1");
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                codigoCarrera = resultado.getString("Codigo_Carrera");
            }
            return codigoCarrera;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * nos devuelve el carnet del estudiante que mas registro tiene
     *
     * @return
     */
    public String obtenerEstudianteConMasRegistros() {
        String carnet = null;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT Carnet_Estudiante, COUNT(*) FROM PRESTAMO GROUP BY Carnet_Estudiante ORDER BY COUNT(*) DESC LIMIT 1");
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                carnet = resultado.getString("Carnet_Estudiante");
            }
            return carnet;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *Extrae el nombre del estudiante con mayor cantidad de registros
     * @return
     */
    public String obtenerNombreEstudiante() {
        String nombre = null;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT Nombre, COUNT(*) FROM  ESTUDIANTE, PRESTAMO WHERE Carnet=Carnet_Estudiante GROUP BY Carnet_Estudiante ORDER BY COUNT(*) DESC LIMIT 1");
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                nombre = resultado.getString("Carnet_Estudiante");
            }
            return nombre;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Nos devuelve un TRUE si el libro ya fue prestado y FALSE si el no se
     * tiene un registro de prestamo abierto aun
     *
     * @param Carnet
     * @param codigoLibro
     * @param fechaPrestamo
     * @return
     */
    public boolean libroYaPrestado(String Carnet, String codigoLibro, String fechaPrestamo) throws SQLException {
        boolean exito = false;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT COUNT(*) FROM PRESTAMO WHERE Carnet_Estudiante=? "
                    + "AND Codigo_Libro=? AND Fecha_Prestamo=? AND Libro_Devuelto <> '1'");
            objeto.setString(1, Carnet);
            objeto.setString(2, codigoLibro);
            objeto.setString(3, fechaPrestamo);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                exito = resultado.getBoolean("COUNT(*)");
            }
            return exito;
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }

    /**
     * Devuelve TRUE si ya esta sobre el limite de libros q puede prestar y
     * FALSE si aun existe espacion para realizar otro prestamo
     *
     * @param Carnet
     * @return
     */
    public boolean limiteDePrestamosAbiertos(String Carnet) {
        boolean exito = false;
        int cantidadDeLibros = 0;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT COUNT(*) FROM PRESTAMO WHERE Carnet_Estudiante=? AND Libro_Devuelto <> '1'");
            objeto.setString(1, Carnet);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                cantidadDeLibros = resultado.getInt("COUNT(*)");
            }
            return (cantidadDeLibros >= ValoresPredeterminados.CANT_MAX_LIBROS_A_PRESTAR);
        } catch (SQLException e) {
            Logger.getLogger(prestamosManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }
    
    public Date fecha() {
       Date fechaActual = null;
        try {
            PreparedStatement objeto = coneccion.prepareStatement("SELECT CURDATE() FECHA_ACTUAL");
            ResultSet resultado = objeto.executeQuery();
            while(resultado.next()){
                fechaActual = resultado.getDate("FECHA_ACTUAL");
            }
            return fechaActual;
        } catch (SQLException e) {
        }
        return null;
    }
}
