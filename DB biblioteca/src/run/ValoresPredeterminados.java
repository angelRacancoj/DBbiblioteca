package run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author angel
 */
public class ValoresPredeterminados {

    //Estos valores indican la operacion se se realizara al modificar la cantidad de libros disponibles, 
    //por un prestamo o por una devolucion
    public static final int prestar = 1;
    public static final int devolver = 2;
    //Es la cantidad maxima de libros que pueden ser prestados por un estudiante
    public static final int CANT_MAX_LIBROS_A_PRESTAR = 3;

    //los costos por 
    public static final int PRECIO_PRESTAMO_NORMAL = 5;
    public static final int PRECIO_PRESTAMO_MOROSO = 10;
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

    //opciones enlazadas a la tabla donde se muestran los prestamos
    //cada uno de los siguientes valores representan la posicion en "Filtros Combo Box" en el listadoPrestamosConFiltros
    public static final int TodoPrestamoYDevolucion = 0;
    public static final int TodoPrestamoPendientes = 1;
    public static final int LibrosPorEntregarHoy = 2;
    public static final int LibrosPrestadosConMora = 3;
    public static final int GananciasIntervaloTiempo = 4;
    public static final int CarreraMasPrestamos = 5;
    public static final int ListadoMorasEstudiante = 6;
    public static final int ListadoEstudianteMasPrestamos = 7;

    public String fecha() {
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fechaActual = (anio + "-" + mes + "-" + dia);
        System.out.println(fechaActual);
        return fechaActual;
    }
}
