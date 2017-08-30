/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelrg
 */
public class LectorDeDatos {

    List<Estudiante> listaEst;
    List<Estudiante> listaEstConErrores;
    List<Libro> listaLibros;
    List<Libro> listaLibrosConErrores;
    List<Prestamo> listaPrestamos;
    List<Prestamo> listaPrestamosConErrores;

    FileInputStream entradadatos;

    public LectorDeDatos(File archivo) throws FileNotFoundException {
        entradadatos = new FileInputStream(archivo);
        listaEst = new ArrayList<>();
        listaEstConErrores = new ArrayList<>();
        listaLibros = new ArrayList<>();
        listaLibrosConErrores = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
        listaPrestamosConErrores = new ArrayList<>();
    }

    public ArrayList<Estudiante> LeerEstudiantes(File archivo) throws IOException, ValidacionExcepcion, InputsVaciosException {

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
                                estudiante.setCarnet(linea[1]);
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
                                estudiante.setCodigoCarrera(linea[1]);
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
                                listaEst.add(estudiante);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (estudiante.getCarnet() != null && estudiante.getNombre() != null && estudiante.getCodigoCarrera() != null) {
                            listaEst.add(estudiante);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (segundoBucle == false) {
            } else {
                primerBucle = entrada.readLine();
            }

        }
        return (ArrayList<Estudiante>) listaEst;
    }

    public ArrayList<Libro> importarLibros(File archivo) throws IOException {
        
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
                                String[] cod = linea[1].split("-");
                                if (cod[0].length() == 3 && cod[1].length() == 3) {
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
                                listaLibros.add(libro);
                            }
                            segundoBucle = false;
                        }
                    } catch (NullPointerException e) {
                        if (libro.getCantidadLibros() != 0 && libro.getCodigo() != null && libro.getTitulo() != null && libro.getAutor() != null) {
                            listaLibros.add(libro);
                        }
                        segundoBucle = false;
                    }
                }
            }
            if (segundoBucle == false) {
            } else {
                primerBucle = entrada.readLine();
            }
        }
        entrada.close();

        return (ArrayList<Libro>) listaLibros;
    }
    
    public ArrayList<Prestamo> importarPrestamos(File archivo) throws IOException {
        ArrayList<Prestamo> lista = new ArrayList();
        FileInputStream entradadatos = new FileInputStream(archivo);
        DataInputStream entrada = new DataInputStream(entradadatos);
        String info = entrada.readLine();
        while (info != null) {
            boolean activo = true;
            if (info.equalsIgnoreCase("Prestamo")) {
                Prestamo prestamo = new Prestamo();
                while (activo) {
                    try {
                        String[] caracter = info.split(":");
                        try {
                            if (caracter[0].equalsIgnoreCase("carnet")) {
                                prestamo.setCarnetEstudiante(caracter[1]);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setCarnetEstudiante(null);
                        }
                        try {
                            if (caracter[0].equalsIgnoreCase("codigolibro")) {
                                String[] cara = caracter[1].split("-");
                                if (cara[0].length() == 3 && cara[1].length() == 3) {
                                    prestamo.setCodigoLibro(caracter[1]);
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setCodigoLibro(null);
                        }
                        try {
                            if (caracter[0].equalsIgnoreCase("fecha")) {
//                                prestamo.setFechaPrestamo(LocalDate.parse(caracter[1], DateTimeFormatter.ISO_DATE));
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            prestamo.setFechaPrestamo(null);
                        }
                    } catch (NullPointerException e) {
                    }
                    info = entrada.readLine();
                    try {
                        if (info.equalsIgnoreCase("estudiante:") || info.equalsIgnoreCase("prestamo:") || info.equalsIgnoreCase("libro:")) {
                            if (prestamo.getCarnetEstudiante()!= null && prestamo.getCodigoLibro()!= null && prestamo.getFechaPrestamo() != null) {
                                lista.add(prestamo);
                            }
                            activo = false;
                        }
                    } catch (NullPointerException e) {
                        if (prestamo.getCarnetEstudiante()!= null && prestamo.getCodigoLibro()!= null && prestamo.getFechaPrestamo() != null) {
                            lista.add(prestamo);
                        }
                        activo = false;
                    }
                }
            }
            if (activo == false) {
            } else {
                info = entrada.readLine();
            }
        }
        entrada.close();
        return lista;
    }
}
