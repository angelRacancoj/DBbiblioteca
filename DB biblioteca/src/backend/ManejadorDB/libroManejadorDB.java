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

    /**
     * Mediante el ingreso de los datos nos permite guardar un libro nuevo
     * dentro de nuestra base de datos
     *
     * @param codigo
     * @param autor
     * @param titulo
     * @param cantLibros
     * @param fechaPublicacion
     * @param editorial
     * @param cantLibrosDisponibles
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public void agregarLibro(String codigo, String autor, String titulo, String cantLibros, String fechaPublicacion, String editorial, String cantLibrosDisponibles) throws SQLException, InputsVaciosException {
        Libro libro = obtenerLibroPorCodigo(codigo);
        if (libro == null) {
            try {

                String query = ("INSERT INTO LIBRO(Codigo,Autor, Titulo,Cantidad_libros, Fecha_Publicacion, Editorial, Cant_Libros_Disponibles, Veces_prestado) VALUES (?,?,?,?,?,?,?,?)");

                PreparedStatement objeto = conexion.prepareStatement(query);
                objeto.setString(1, codigo);
                objeto.setString(2, autor);
                objeto.setString(3, titulo);
                objeto.setString(4, cantLibros);
                objeto.setString(5, fechaPublicacion);
                objeto.setString(6, editorial);
                objeto.setString(7, cantLibrosDisponibles);
                objeto.setString(8, "0");

                objeto.execute();
            } catch (SQLException e) {
                Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            throw new InputsVaciosException("Ya existe un libro registrado con ese codigo");
        }

    }

    /**
     * Nos permite modificar los atributos ya dados a nuestro libro tomando en
     * cuenta la posible duplicidad de codigo de libros
     *
     * @param codigoAntiguo
     * @param codigoNuevo
     * @param autor
     * @param titulo
     * @param cantLibros
     * @param fechaPublicacion
     * @param editorial
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public boolean modificarLibroDisponibles(String codigoAntiguo, String codigoNuevo, String autor, String titulo, String cantLibros, String fechaPublicacion, String editorial) throws SQLException, InputsVaciosException {
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
            } catch (SQLException e) {
                Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            throw new InputsVaciosException("No existe el Libro");
        }
        return exito;
    }

    /**
     * Agrega o disminuye el numero de libros disponibles respecto ya se un
     * prestamo o una devolucion se presto= TRUE disminuye en uno la cantidad de
     * libros disponibles se presto= FALSE aumenta en uno la cantidad de libros
     * disponibles
     *
     * @param codigo
     * @param sePresto
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public void modificarCantidadLibroDisponibles(String codigo, boolean sePresto) throws SQLException, InputsVaciosException {
        Libro libro = obtenerLibroPorCodigo(codigo);

        try {

            String query = ("UPDATE LIBRO SET Cant_Libros_Disponibles=? WHERE Codigo = ?");

            PreparedStatement objeto = conexion.prepareStatement(query);
            if (sePresto) {
                objeto.setInt(1, libro.getCantidadLibrosDisponibles() - 1);
            } else {
                objeto.setInt(1, libro.getCantidadLibrosDisponibles() + 1);
            }
            objeto.setString(2, codigo);

            objeto.execute();

        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     *Aumenta en la casilla Veces_prestado al ser ejecutado
     * @param codigo
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public void modificarVecesPrestado(String codigo) throws SQLException, InputsVaciosException {
        Libro libro = obtenerLibroPorCodigo(codigo);

        try {
            String query = ("UPDATE LIBRO SET Veces_prestado = Veces_prestado + 1 WHERE Codigo = ?");
            PreparedStatement objeto = conexion.prepareStatement(query);
            objeto.setString(1,codigo);
            objeto.execute();

        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Verifica que nos se asignen codigos ya existentes
     *
     * @param codigoNuevo
     * @param codigoAntiguo
     * @return
     */
    public boolean existeLibroPorCodigo(String codigoNuevo, String codigoAntiguo) {
        int noRegistro = 0;
        try {
            String query = ("SELECT COUNT(*) FROM LIBRO WHERE Codigo =? AND Codigo <> ?");
            PreparedStatement objeto = conexion.prepareStatement(query);
            objeto.setString(1, codigoNuevo);
            objeto.setString(2, codigoAntiguo);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                noRegistro = resultado.getInt("COUNT(*)");
            }
            if (noRegistro >= 1) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
//String codigo, String autor, String titulo, int cantidadLibros, Date fechaPublicacion, String editorial, int cantidadLibrosDisponibles
//    Codigo CHAR, Autor CHAR, Titulo CHAR, Cantidad_libros INT, Fecha_Publicacion DATE, Editorial CHAR, Cant_Libros_Disponibles INTEGER

    /**
     * Se encarga de generar los listados de libros al recibir los
     * PreparedStaments
     *
     * @param sentencia
     * @return
     * @throws SQLException
     */
    public List<Libro> consultaLibroPS(PreparedStatement sentencia) throws SQLException {
        busquedaLibro.clear();
        try {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("Codigo");
                String autor = resultado.getString("Autor");
                String titulo = resultado.getString("Titulo");
                int cantidadLibros = resultado.getInt("Cantidad_libros");
                Date fechaPublicacion = resultado.getDate("Fecha_Publicacion");
                String editorial = resultado.getString("Editorial");
                int cantLibrosDisponibles = resultado.getInt("Cant_Libros_Disponibles");
                Libro libro = new Libro(codigo, autor, titulo, cantidadLibros, fechaPublicacion, editorial, cantLibrosDisponibles);
                System.out.println("Datos: " + codigo + ", " + autor + ", " + titulo + ", " + cantidadLibros + ", " + fechaPublicacion + ", " + editorial + ", " + cantLibrosDisponibles);
                busquedaLibro.add(libro);
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            resultado.close();
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return busquedaLibro;
    }

    /**
     * obtiene los libros actualmente agotados o sin existencias
     *
     * @return
     */
    public List<Libro> librosAgotados() {
        busquedaLibro.clear();
        try {
            PreparedStatement objeto = conexion.prepareStatement("SELECT *FROM LIBRO WHERE Cant_Libros_Disponibles < 1");
            List libros = consultaLibroPS(objeto);
            objeto.close();
            return libros;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Se encarga de crear los Statements para luego ser enviados a
     * ConsultaLibroPS() para generar los listados
     *
     * @param Codigo
     * @param Nombre
     * @param Autor
     * @return
     * @throws SQLException
     * @throws InputsVaciosException
     */
    public List<Libro> ConsultarLibrosFiltros(String Codigo, String Nombre, String Autor) throws SQLException, InputsVaciosException {
        boolean codLibro = Codigo.replace(" ", "").replace("-", "").isEmpty();
        boolean nomLibro = Nombre.replace(" ", "").isEmpty();
        boolean autorLibro = Autor.replace(" ", "").isEmpty();

        try {
            if (codLibro && nomLibro && autorLibro) {
                String query = ("SELECT *FROM LIBRO ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else if (nomLibro && autorLibro) {
                String query = ("SELECT *FROM LIBRO WHERE Codigo LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Codigo);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else if (codLibro && autorLibro) {
                String query = ("SELECT *FROM LIBRO WHERE Titulo LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Nombre);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else if (codLibro && nomLibro) {
                String query = ("SELECT *FROM LIBRO WHERE Autor LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Autor);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else if (autorLibro) {
                String query = ("SELECT *FROM LIBRO WHERE Codigo LIKE CONCAT('%',?,'%') AND Titulo LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Codigo);
                sentencia.setString(2, Nombre);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else if (nomLibro) {
                String query = ("SELECT *FROM LIBRO WHERE Codigo LIKE CONCAT('%',?,'%') AND Autor LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Codigo);
                sentencia.setString(2, Autor);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else if (codLibro) {
                String query = ("SELECT *FROM LIBRO WHERE Titulo LIKE CONCAT('%',?,'%') AND Autor LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Nombre);
                sentencia.setString(2, Autor);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            } else {
                String query = ("SELECT *FROM LIBRO WHERE Codigo LIKE CONCAT('%',?,'%') AND Titulo LIKE CONCAT('%',?,'%') AND Autor LIKE CONCAT('%',?,'%') ORDER BY Codigo ASC");
                PreparedStatement sentencia = conexion.prepareStatement(query);
                sentencia.setString(1, Codigo);
                sentencia.setString(2, Nombre);
                sentencia.setString(3, Autor);
                List libros = consultaLibroPS(sentencia);
                sentencia.close();
                return libros;
            }
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * Extrae el libro a utilizar para la edicion
     *
     * @param codigo
     * @return
     * @throws SQLException
     */
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
                int cantLibrosDisponibles = resultado.getInt("Cant_Libros_Disponibles");
                Libro libro = new Libro(codigoLib, autor, titulo, cantLibros, fechaPubli, editorial, cantLibrosDisponibles);
                return libro;
            }
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * devuelve TRUE cuando aun existen libros devuelve FALSE cuando ya no hay
     * libros disponibles
     *
     * @param codigo
     * @return
     */
    public boolean aunExistenLibros(String codigo) {
        boolean exito = false;
        int cantidadDeLibros = 0;
        try {
            PreparedStatement objeto = conexion.prepareStatement("SELECT Cant_Libros_Disponibles FROM LIBRO WHERE Codigo=?");
            objeto.setString(1, codigo);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                cantidadDeLibros = resultado.getInt("Cant_Libros_Disponibles");
            }
            return (cantidadDeLibros > 0);
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return exito;
    }

    /**
     * vefifica la existencia de un libro devuelve TRUE si exite y FALSE si no
     * se encuentra el libro
     *
     * @param Codigo
     * @return
     */
    public boolean existeLibro(String Codigo) {
        int noRegistro = 0;
        try {
            PreparedStatement objeto = conexion.prepareStatement("SELECT COUNT(*) FROM LIBRO WHERE Codigo=?");
            objeto.setString(1, Codigo);
            ResultSet resultado = objeto.executeQuery();
            while (resultado.next()) {
                noRegistro = resultado.getInt("COUNT(*)");
            }
            return (noRegistro == 1);
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public List<Libro> librosEnPrestamoAUnEstudiante(String Carnet) {
        busquedaLibro.clear();
        try {
            PreparedStatement objeto = conexion.prepareStatement("SELECT Codigo, Autor, Titulo, Cantidad_Libros, Fecha_Publicacion, Editorial, Cant_Libros_Disponibles FROM LIBRO, PRESTAMO "
                    + "WHERE Codigo = Codigo_Libro AND Carnet_Estudiante=? AND Libro_Devuelto <> 1 ORDER BY Codigo DESC ");
            objeto.setString(1, Carnet);
            List libros = consultaLibroPS(objeto);
            objeto.close();
            return libros;
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public List<Libro> librosSinPrestar() {
        busquedaLibro.clear();
        try {
            PreparedStatement objeto = conexion.prepareStatement("SELECT *FROM LIBRO WHERE Veces_prestado = 0");
            List libros = consultaLibroPS(objeto);
            objeto.close();
            return libros;
        } catch (SQLException e) {
            Logger.getLogger(libroManejadorDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
