package run;


/**
 *
 * @author angel
 */
public class ValoresPredeterminados {

    //Estos valores indican la operacion se se realizara al modificar la cantidad de libros disponibles, 
    //por un prestamo o por una devolucion
    public static final String prestar = "0";
    public static final String devolver = "1";
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
    //cada uno de los siguientes valores representan la posicion en "Filtros Combo Box" en el listadoPrestamosConFiltros del 1->7
    // del 8 en adelante son filtros extras
    public static final int TodoPrestamoYDevolucion = 0;
    public static final int TodoPrestamoPendientes = 1;
    public static final int LibrosPorEntregarHoy = 2;
    public static final int LibrosPrestadosConMora = 3;
    public static final int GananciasIntervaloTiempo = 4;
    public static final int CarreraMasPrestamos = 5;
    public static final int ListadoMorasEstudiante = 6;
    public static final int ListadoEstudianteMasPrestamos = 7;
    public static final int librosPrestadosAUnEstudiante = 8;
    public static final int GananciasTotales = 9;
    public static final int CarreraMasPrestamosGeneral = 10;
    public static final int ListadoMorasEstudianteGeneral = 11;
    public static final int ListadoEstudianteMasPrestamosGeneral = 12;

    //Estos nos sirven para generar la busqueda de libros con filtros o los agotados
    public static final int FILTROS_PARA_BUSQUEDA_LIBROS = 0;
    public static final int LIBROS_AGOTADOS = 1;
    public static final int LIBROS_PRESTADOS_A_UN_ESTUDIANTE = 2;
    public static final int LIBROS_SIN_PRESTAR = 3;
    
}
