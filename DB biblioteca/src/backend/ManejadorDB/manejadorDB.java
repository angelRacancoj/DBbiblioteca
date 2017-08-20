package backend.ManejadorDB;

import java.sql.Connection;

/**
 *
 * @author angel
 */
public class manejadorDB {
    
    private Connection coneccion;

    public manejadorDB(Connection coneccion) {
        this.coneccion = coneccion;
    }
}
