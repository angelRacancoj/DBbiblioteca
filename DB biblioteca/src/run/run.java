package run;

import biblioteca.BackEnd.ImportarArchivo.ManejadorArchivo;
import biblioteca.FrontIn.Biblioteca.BibliotecaGIU;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ManejadorArchivo manejadorArch = new ManejadorArchivo();
        
        Connection connection = null;
        try {
            //Indicamos cual driver usar
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection("jdbc:mysql://localhost?user=root&password=ex=d/dx=ex");
            System.out.println("conectado:" + connection.getCatalog());
            Statement seleccionarDB = connection.createStatement();
            seleccionarDB.executeUpdate("USE DB_BIBLIOTECA");
            BibliotecaGIU bibliotecaGUI = new BibliotecaGIU(connection);
            bibliotecaGUI.setVisible(true);
            manejadorArch.lecturaDelArchivo();
            Date fechaActual = null;
             PreparedStatement objeto = connection.prepareStatement("SELECT CURDATE() FECHA_ACTUAL");
            ResultSet resultado = objeto.executeQuery();
            while(resultado.next()){
                fechaActual = resultado.getDate("FECHA_ACTUAL");
            }
            System.out.println(String.valueOf(fechaActual));
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("error");
            e.printStackTrace(System.out);
        } finally {
            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(run.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }
    }

}
