package backend.ManejadorDB;

import backend.libros.Libro;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class libroManejadorDB {

    private Connection conexion;
    ValoresPredeterminados valoresPre;

    List<Libro> busquedaLibro = new ArrayList<>();

    public libroManejadorDB(Connection coneccion) {
        this.conexion = coneccion;
    }

    public void agregarLibro(String codigo, String autor, String titulo, String cantLibros, String fechaPublicacion, String editorial, String cantLibrosDisponibles) throws SQLException, InputsVaciosException {
        Libro libro = obtenerLibroPorCodigo(codigo);
        if (libro == null) {
            Statement declaracion = null;
            try {

                String query = ("INSERT INTO LIBRO(Codigo,Autor, Titulo,Cantidad_libros, Fecha_Publicacion, Editorial, Cant_Libros_Disponibles) VALUES (?,?,?,?,?,?,?)");

                PreparedStatement objeto = conexion.prepareStatement(query);
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
        } else {
            throw new InputsVaciosException("Ya existe un libro registrado con ese codigo");
        }

    }

    public boolean modificarLibroDisponibles(String codigoAntiguo, String codigoNuevo, String autor, String titulo, String cantLibros, String fechaPublicacion, String editorial, int prestaOdev) throws SQLException, InputsVaciosException {
        boolean exito = false;
        Libro libro = obtenerLibroPorCodigo(codigoAntiguo);
        if (libro != null) {
            int cantLib = Integer.parseInt(cantLibros);
            try {

                String query = ("UPDATE LIBRO SET Codigo=?, Autor=?, Titulo=?, Cantidad_Libros=?, Fecha_Publicacion=?, Editorial=?, Cant_Libros_Disponibles=? WHERE Codigo = ?");

                PreparedStatement objeto = conexion.prepareStatement(query);
                objeto.setString(1, codigoNuevo);
                objeto.setString(2, autor);
                objeto.setString(3, titulo);
                objeto.setString(4, cantLibros);
                objeto.setString(5, fechaPublicacion);
                objeto.setString(6, editorial);
                objeto.setString(7, String.valueOf(cantLib - (libro.getCantidadLibros() - libro.getCantidadLibrosDisponibles())));
                objeto.setString(8, codigoAntiguo);

                exito = objeto.execute();
                return exito;
            } catch (Exception e) {
            }
        } else {
            throw new InputsVaciosException("No existe el Libro");
        }
        return exito;
    }
//    Codigo CHAR, Autor CHAR, Titulo CHAR, Cantidad_libros INT, Fecha_Publicacion DATE, Editorial CHAR, Cant_Libros_Disponibles INTEGER
public List<Libro> consultaLibroPS(PreparedStatement sentencia)throws SQLException{
    busquedaLibro.clear();
    try {
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            String codigo = resultado.getString("Codigo");
            
        }
    } catch (Exception e) {
    }
}
    
    public List<Libro> ConsultarEstudiantesFiltros(String Codigo, String Nombre, String Autor) {

    }

    public Libro obtenerLibroPorCodigo(String codigo) throws SQLException {
        busquedaLibro.clear();
        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT *FROM LIBRO WHERE Codigo = '" + codigo + "'");

            while (resultado.next()) {
                String codigoLib = resultado.getString("Codigo");
                String autor = resultado.getString("Autor");
                String titulo = resultado.getString("Titulo");
                int cantLibros = resultado.getInt("Cantidad_libros");
                Date fechaPubli = resultado.getDate("Fecha_Publicacion");
                String editorial = resultado.getString("Editorial");
                int cantLibrosDisponibles = resultado.getInt("Cantidad_libros_Disponibles");
                Libro libro = new Libro(codigoLib, autor, titulo, cantLibros, fechaPubli, editorial, cantLibrosDisponibles);
                return libro;
            }
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
