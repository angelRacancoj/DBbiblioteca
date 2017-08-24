package run;

import biblioteca.FrontIn.Biblioteca.BibliotecaGIU;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    public static void main(String[] args) {
        
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
