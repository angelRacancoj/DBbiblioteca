package run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author angel
 */
public class ValoresPredeterminados {
    //Es la cantidad maxima de libros que pueden ser prestados por un estudiante
    public static final int CANT_MAX_LIBROS_A_PRESTAR = 3;

    //los costos por 
    public static final double PRECIO_PRESTAMO_NORMAL = 5;
    public static final double PRECIO_PRESTAMO_MOROSO = 10;
    public static final int LIMITE_DIAS_HABILES_PRESTAMO = 3;
    public static final int LIMITE_DIAS_SIN_MORA = 5;
    public static final int DIAS_HABILES_SIN_COSTO = 2;

    //Se asigna un numer ode carrera para reducir el espacio utilizado
    //Tambien se ha colocado los nombre de la carreras en este lugar para relizar una modificacion futura
    public static final String CODIGO_CARRERA_1 = "1";
    public static final String CODIGO_CARRERA_2 = "2";
    public static final String CODIGO_CARRERA_3 = "3";
    public static final String CODIGO_CARRERA_4 = "4";
    public static final String CODIGO_CARRERA_5 = "5";
    
    public static final String CARRERA_1 = "Ingenieria";
    public static final String CARRERA_2 = "Medicina";
    public static final String CARRERA_3 = "Derecho";
    public static final String CARRERA_4 = "Arquitectura";
    public static final String CARRERA_5 = "Administracion";

    public static final String FORMATO_FECHA = "yyyy/mm/dd";
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    
        public Date fecha(String dateToParse) {
        try {

            Date date = formatter.parse(dateToParse);
            System.out.println(date);
            System.out.println(formatter.format(date));

            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
      return null;
    }
 
}
