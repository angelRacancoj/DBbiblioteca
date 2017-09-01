package backend.leturaArchivo;

import backend.libros.Libro;
import backend.personas.Estudiante;
import backend.prestamos.Prestamo;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import biblioteca.BackEnd.Excepciones.ValidacionExcepcion;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import run.ValoresPredeterminados;

/**
 *
 * @author angelrg
 */
public class LectorDeDatos {

    public LectorDeDatos() {
    }

    public ArrayList<Estudiante> leerEstudiantes(File archivo) throws IOException, ValidacionExcepcion, InputsVaciosException {

        ArrayList<Estudiante> lista = new ArrayList();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String primerBucle = entrada.readLine();
        while (primerBucle != null) {
            boolean segundoBucle = true;
            if (primerBucle.equalsIgnoreCase("estudiante")) {
                Estudiante estudiante = new Estudiante();
                while (segundoBucle) {
                    try {
                        String[] linea = primerBucle.split(":");
                        try {
                            if (linea[0].equalsIgnoreCase("carnet")) {
                                if (linea[1].length() == ValoresPredeterminados.LONGITUD_CARNET) {
                                    estudiante.setCarnet(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            estudiante.setCarnet(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("nombre")) {
                                estudiante.setNombre(linea[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            estudiante.setNombre(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("carrera")) {
                                if (linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_1)) || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_2))
                                        || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_3)) || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_4))
                                        || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_5))) {
                                    estudiante.setCodigoCarrera(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            estudiante.setCodigoCarrera(null);
                        }
                    } catch (NullPointerException e) {
                    }
                    primerBucle = entrada.readLine();
                    try {
                        if (primerBucle.equalsIgnoreCase("estudiante") || primerBucle.equalsIgnoreCase("prestamo") || primerBucle.equalsIgnoreCase("libro")) {
                            if (estudiante.getCarnet() != null && estudiante.getNombre() != null && estudiante.getCodigoCarrera() != null) {
                                lista.add(estudiante);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (estudiante.getCarnet() != null && estudiante.getNombre() != null && estudiante.getCodigoCarrera() != null) {
                            lista.add(estudiante);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (!segundoBucle) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();
        return lista;
    }

    public ArrayList<Libro> leerLibros(File archivo) throws IOException {
        ArrayList<Libro> lista = new ArrayList<>();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String primerBucle = entrada.readLine();
        while (primerBucle != null) {
            boolean segundoBucle = true;
            if (primerBucle.equalsIgnoreCase("libro")) {
                Libro libro = new Libro();
                while (segundoBucle) {
                    try {
                        String[] linea = primerBucle.split(":");
                        try {
                            if (linea[0].equalsIgnoreCase("titulo")) {
                                libro.setTitulo(linea[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setTitulo(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("autor")) {
                                libro.setAutor(linea[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setAutor(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("codigo")) {
                                String[] cara = linea[1].split("-");
                                if (cara[0].length() == 3 && cara[1].length() == 3) {
                                    libro.setCodigo(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setCodigo(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("cantidad")) {
                                libro.setCantidadLibros(Integer.valueOf(linea[1]));
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setCantidadLibros(0);
                        }
                    } catch (NullPointerException e) {
                    }
                    primerBucle = entrada.readLine();
                    try {
                        if (primerBucle.equalsIgnoreCase("estudiante") || primerBucle.equalsIgnoreCase("prestamo") || primerBucle.equalsIgnoreCase("libro")) {
                            if (libro.getCantidadLibros() != 0 && libro.getCodigo() != null && libro.getTitulo() != null && libro.getAutor() != null) {
                                lista.add(libro);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (libro.getCantidadLibros() != 0 && libro.getCodigo() != null && libro.getTitulo() != null && libro.getAutor() != null) {
                            lista.add(libro);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (!segundoBucle) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();

        return lista;
    }

    public ArrayList<Prestamo> leerPrestamos(File archivo) throws IOException {
        ArrayList<Prestamo> lista = new ArrayList();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String primerBucle = entrada.readLine();
        while (primerBucle != null) {
            boolean segundoBucle = true;
            if (primerBucle.equalsIgnoreCase("Prestamo")) {
                Prestamo prestamo = new Prestamo();
                while (segundoBucle) {
                    try {
                        String[] linea = primerBucle.split(":");
                        try {
                            if (linea[0].equalsIgnoreCase("carnet")) {
                                if (linea[1].length() == ValoresPredeterminados.LONGITUD_CARNET) {
                                    prestamo.setCarnetEstudiante(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setCarnetEstudiante(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("codigolibro")) {
                                String[] cara = linea[1].split("-");
                                if (cara[0].length() == 3 && cara[1].length() == 3) {
                                    prestamo.setCodigoLibro(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setCodigoLibro(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("fecha")) {
                                prestamo.setFechaPrestamo(Date.valueOf(LocalDate.parse(linea[1], DateTimeFormatter.ISO_DATE)));
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setFechaPrestamo(null);
                        }
                    } catch (NullPointerException e) {
                    }
                    primerBucle = entrada.readLine();
                    try {
                        if (primerBucle.equalsIgnoreCase("estudiante") || primerBucle.equalsIgnoreCase("prestamo") || primerBucle.equalsIgnoreCase("libro")) {
                            if (prestamo.getCarnetEstudiante() != null && prestamo.getCodigoLibro() != null && prestamo.getFechaPrestamo() != null) {
                                lista.add(prestamo);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (prestamo.getCarnetEstudiante() != null && prestamo.getCodigoLibro() != null && prestamo.getFechaPrestamo() != null) {
                            lista.add(prestamo);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (!segundoBucle) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();
        return lista;
    }

    public ArrayList<Estudiante> leerEstudianteConError(File archivo) throws IOException {
        ArrayList<Estudiante> lista = new ArrayList();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String primerBucle = entrada.readLine();
        while (primerBucle != null) {
            boolean segundoBucle = true;
            if (primerBucle.equalsIgnoreCase("estudiante")) {
                Estudiante estudiante = new Estudiante();
                while (segundoBucle) {
                    try {
                        String[] linea = primerBucle.split(":");
                        try {
                            if (linea[0].equalsIgnoreCase("carnet")) {
                                if (linea[1].length() == ValoresPredeterminados.LONGITUD_CARNET) {
                                    estudiante.setCarnet(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            estudiante.setCarnet(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("nombre")) {
                                estudiante.setNombre(linea[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            estudiante.setNombre(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("carrera")) {
                                if (linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_1)) || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_2))
                                        || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_3)) || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_4))
                                        || linea[1].equals(String.valueOf(ValoresPredeterminados.CODIGO_CARRERA_5))) {
                                    estudiante.setCodigoCarrera(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            estudiante.setCodigoCarrera(null);
                        }
                    } catch (NullPointerException e) {
                    }
                    primerBucle = entrada.readLine();
                    try {
                        if (primerBucle.equalsIgnoreCase("estudiante") || primerBucle.equalsIgnoreCase("prestamo") || primerBucle.equalsIgnoreCase("libro")) {
                            if (estudiante.getCarnet() == null || estudiante.getNombre() == null || estudiante.getCodigoCarrera() == null) {
                                lista.add(estudiante);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (estudiante.getCarnet() == null || estudiante.getNombre() == null || estudiante.getCodigoCarrera() == null) {
                            lista.add(estudiante);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (!segundoBucle) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();
        return lista;
    }

    public ArrayList<Libro> leerLibrosConError(File archivo) throws IOException {
        ArrayList<Libro> lista = new ArrayList<>();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String primerBucle = entrada.readLine();
        while (primerBucle != null) {
            boolean segundoBucle = true;
            if (primerBucle.equalsIgnoreCase("libro")) {
                Libro libro = new Libro();
                while (segundoBucle) {
                    try {
                        String[] linea = primerBucle.split(":");
                        try {
                            if (linea[0].equalsIgnoreCase("titulo")) {
                                libro.setTitulo(linea[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setTitulo(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("autor")) {
                                libro.setAutor(linea[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setAutor(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("codigo")) {
                                String[] cara = linea[1].split("-");
                                if (cara[0].length() == 3 && cara[1].length() == 3) {
                                    libro.setCodigo(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setCodigo(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("cantidad")) {
                                libro.setCantidadLibros(Integer.valueOf(linea[1]));
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            libro.setCantidadLibros(0);
                        }
                    } catch (NullPointerException e) {
                    }
                    primerBucle = entrada.readLine();
                    try {
                        if (primerBucle.equalsIgnoreCase("estudiante") || primerBucle.equalsIgnoreCase("prestamo") || primerBucle.equalsIgnoreCase("libro")) {
                            if (libro.getCantidadLibros() == 0 || libro.getCodigo() == null || libro.getTitulo() == null || libro.getAutor() == null) {
                                lista.add(libro);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (libro.getCantidadLibros() == 0 || libro.getCodigo() == null || libro.getTitulo() == null || libro.getAutor() == null) {
                            lista.add(libro);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (!segundoBucle) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();

        return lista;
    }

    public ArrayList<Prestamo> leerPrestamosConError(File archivo) throws IOException {
        ArrayList<Prestamo> lista = new ArrayList();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String primerBucle = entrada.readLine();
        while (primerBucle != null) {
            boolean segundoBucle = true;
            if (primerBucle.equalsIgnoreCase("Prestamo")) {
                Prestamo prestamo = new Prestamo();
                while (segundoBucle) {
                    try {
                        String[] linea = primerBucle.split(":");
                        try {
                            if (linea[0].equalsIgnoreCase("carnet")) {
                                if (linea[1].length() == ValoresPredeterminados.LONGITUD_CARNET) {
                                    prestamo.setCarnetEstudiante(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setCarnetEstudiante(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("codigolibro")) {
                                String[] cara = linea[1].split("-");
                                if (cara[0].length() == 3 && cara[1].length() == 3) {
                                    prestamo.setCodigoLibro(linea[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setCodigoLibro(null);
                        }
                        try {
                            if (linea[0].equalsIgnoreCase("fecha")) {
                                prestamo.setFechaPrestamo(Date.valueOf(LocalDate.parse(linea[1], DateTimeFormatter.ISO_DATE)));
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setFechaPrestamo(null);
                        }
                    } catch (NullPointerException e) {
                    }
                    primerBucle = entrada.readLine();
                    try {
                        if (primerBucle.equalsIgnoreCase("estudiante") || primerBucle.equalsIgnoreCase("prestamo") || primerBucle.equalsIgnoreCase("libro")) {
                            if (prestamo.getCarnetEstudiante() == null || prestamo.getCodigoLibro() == null || prestamo.getFechaPrestamo() == null) {
                                lista.add(prestamo);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (prestamo.getCarnetEstudiante() == null || prestamo.getCodigoLibro() == null || prestamo.getFechaPrestamo() == null) {
                            lista.add(prestamo);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (!segundoBucle) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();
        return lista;
    }
}
