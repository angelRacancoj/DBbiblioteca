package biblioteca.BackEnd.Excepciones;


public class ValidacionExcepcion extends Exception {

	//Maneja los errores de ingreso de informacion
	public ValidacionExcepcion() {
	}


	public ValidacionExcepcion(String msg) {
		super(msg);
	}
}
