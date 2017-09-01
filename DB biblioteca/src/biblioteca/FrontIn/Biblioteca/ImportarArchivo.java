/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.FrontIn.Biblioteca;

import backend.leturaArchivo.LectorDeArchivo;
import backend.leturaArchivo.LectorDeDatos;
import backend.libros.Libro;
import backend.personas.Estudiante;
import backend.prestamos.Prestamo;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import biblioteca.BackEnd.Excepciones.ValidacionExcepcion;
import biblioteca.BackEnd.ImportarArchivo.ManejadorArchivo;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import swing.libro.editarLibro;
import swing.persona.editarEstudiante;

/**
 *
 * @author angel
 */
public class ImportarArchivo extends javax.swing.JInternalFrame {

    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Estudiante> listaEstudiantesConError;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Libro> listaLibrosConError;
    private ArrayList<Prestamo> listaPrestamos;
    private ArrayList<Prestamo> listaPrestamosConError;

    private ObservableList<Estudiante> listaEstudiantesObservable;
    private ObservableList<Estudiante> listaEstudiantesConErrorObservable;
    private ObservableList<Libro> listaLibrosObservable;
    private ObservableList<Libro> listaLibrosConErrorObservable;
    private ObservableList<Prestamo> listaPrestamosObservable;
    private ObservableList<Prestamo> listaPrestamosConErrorObservable;

    private editarEstudiante editarEstudiante;
    private editarLibro editarLibro;

    private LectorDeArchivo lectura;

    public ImportarArchivo(Connection conexion) {
        lectura = new LectorDeArchivo(conexion);
        listaEstudiantes = new ArrayList<>();
        listaEstudiantesObservable = ObservableCollections.observableList(listaEstudiantes);
        listaEstudiantesConError = new ArrayList<>();
        listaEstudiantesConErrorObservable = ObservableCollections.observableList(listaEstudiantesConError);
        listaLibros = new ArrayList<>();
        listaLibrosObservable = ObservableCollections.observableList(listaLibros);
        listaLibrosConError = new ArrayList<>();
        listaLibrosConErrorObservable = ObservableCollections.observableList(listaLibrosConError);
        listaPrestamos = new ArrayList<>();
        listaPrestamosObservable = ObservableCollections.observableList(listaPrestamos);
        listaPrestamosConError = new ArrayList<>();
        listaPrestamosConErrorObservable = ObservableCollections.observableList(listaPrestamosConError);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        abrirButton = new javax.swing.JButton();
        pathTextField = new javax.swing.JTextField();
        salirButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();

        setTitle("Cargar Archivo");

        jLabel1.setText("Lectura Completa del Archivo");

        jLabel2.setText("Errores el la Lectura del Archivo");

        abrirButton.setText("Seleccionar y cargar Archivo");
        abrirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirButtonActionPerformed(evt);
            }
        });

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEstudiantesObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${carnet}"));
        columnBinding.setColumnName("Carnet");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoCarrera}"));
        columnBinding.setColumnName("Codigo Carrera");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jTable1);

        jLabel3.setText("Estudiantes");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEstudiantesConErrorObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${carnet}"));
        columnBinding.setColumnName("Carnet");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoCarrera}"));
        columnBinding.setColumnName("Codigo Carrera");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane4.setViewportView(jTable2);

        jLabel4.setText("Estudiantes con Errores");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaLibrosObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${titulo}"));
        columnBinding.setColumnName("Titulo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autor}"));
        columnBinding.setColumnName("Autor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadLibros}"));
        columnBinding.setColumnName("Cantidad Libros");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane5.setViewportView(jTable3);

        jLabel5.setText("Libros");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaLibrosConErrorObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autor}"));
        columnBinding.setColumnName("Autor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadLibros}"));
        columnBinding.setColumnName("Cantidad Libros");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${titulo}"));
        columnBinding.setColumnName("Titulo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane6.setViewportView(jTable4);

        jLabel6.setText("Libros con Errores");

        jLabel7.setText("Prestamos con Errores");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaPrestamosObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable5);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoLibro}"));
        columnBinding.setColumnName("Codigo Libro");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${carnetEstudiante}"));
        columnBinding.setColumnName("Carnet Estudiante");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPrestamo}"));
        columnBinding.setColumnName("Fecha Prestamo");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane7.setViewportView(jTable5);

        jLabel8.setText("Prestamos");

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaPrestamosConErrorObservable}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable6);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${carnetEstudiante}"));
        columnBinding.setColumnName("Carnet Estudiante");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoLibro}"));
        columnBinding.setColumnName("Codigo Libro");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPrestamo}"));
        columnBinding.setColumnName("Fecha Prestamo");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane8.setViewportView(jTable6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(180, 180, 180))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(168, 168, 168))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(166, 166, 166))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(145, 145, 145))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(abrirButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pathTextField)
                                .addGap(97, 97, 97)
                                .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirButton)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirButtonActionPerformed
        JFileChooser dialogo = new JFileChooser();
        dialogo.setDialogTitle("Abrir");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("EntradaProyecto", "txt");
        dialogo.setFileFilter(filtro);
        if (dialogo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = dialogo.getSelectedFile().getAbsolutePath();
            pathTextField.setText(path);
            try {
                lectura.Importar(path);
            } catch (IOException | ValidacionExcepcion | InputsVaciosException ex) {
                Logger.getLogger(ImportarArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        actualizarBusquedaObservableEstudiantes(lectura.getEstudiante());
        actualizarBusquedaObservableEstudiantesConError(lectura.getEstudianteConError());
        actualizarBusquedaObservableLibros(lectura.getLibro());
        actualizarBusquedaObservableLibrosConError(lectura.getLibroConError());
        actualizarBusquedaObservablePrestamo(lectura.getPrestamos());
        actualizarBusquedaObservablePrestamoConError(lectura.getPrestamosConError());
        
    }//GEN-LAST:event_abrirButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_salirButtonActionPerformed

    public void actualizarBusquedaObservableEstudiantes(ArrayList<Estudiante> lista) {
        this.listaEstudiantesObservable.clear();
        this.listaEstudiantesObservable.addAll(lista);
    }

    public void actualizarBusquedaObservableEstudiantesConError(ArrayList<Estudiante> lista) {
        this.listaEstudiantesConErrorObservable.clear();
        this.listaEstudiantesConErrorObservable.addAll(lista);
    }

    public void actualizarBusquedaObservableLibros(ArrayList<Libro> lista) {
        this.listaLibrosObservable.clear();
        this.listaLibrosObservable.addAll(lista);
    }

    public void actualizarBusquedaObservableLibrosConError(ArrayList<Libro> lista) {
        this.listaLibrosConErrorObservable.clear();
        this.listaLibrosConErrorObservable.addAll(lista);
    }

    public void actualizarBusquedaObservablePrestamo(ArrayList<Prestamo> lista) {
        this.listaPrestamosObservable.clear();
        this.listaPrestamosObservable.addAll(lista);
    }

    public void actualizarBusquedaObservablePrestamoConError(ArrayList<Prestamo> lista) {
        this.listaPrestamosConErrorObservable.clear();
        this.listaPrestamosConErrorObservable.addAll(lista);
    }

    public ObservableList<Estudiante> getListaEstudiantesObservable() {
        return listaEstudiantesObservable;
    }

    public void setListaEstudiantesObservable(ObservableList<Estudiante> listaEstudiantesObservable) {
        this.listaEstudiantesObservable = listaEstudiantesObservable;
    }

    public ObservableList<Estudiante> getListaEstudiantesConErrorObservable() {
        return listaEstudiantesConErrorObservable;
    }

    public void setListaEstudiantesConErrorObservable(ObservableList<Estudiante> listaEstudiantesConErrorObservable) {
        this.listaEstudiantesConErrorObservable = listaEstudiantesConErrorObservable;
    }

    public ObservableList<Libro> getListaLibrosObservable() {
        return listaLibrosObservable;
    }

    public void setListaLibrosObservable(ObservableList<Libro> listaLibrosObservable) {
        this.listaLibrosObservable = listaLibrosObservable;
    }

    public ObservableList<Libro> getListaLibrosConErrorObservable() {
        return listaLibrosConErrorObservable;
    }

    public void setListaLibrosConErrorObservable(ObservableList<Libro> listaLibrosConErrorObservable) {
        this.listaLibrosConErrorObservable = listaLibrosConErrorObservable;
    }

    public ObservableList<Prestamo> getListaPrestamosObservable() {
        return listaPrestamosObservable;
    }

    public void setListaPrestamosObservable(ObservableList<Prestamo> listaPrestamosObservable) {
        this.listaPrestamosObservable = listaPrestamosObservable;
    }

    public ObservableList<Prestamo> getListaPrestamosConErrorObservable() {
        return listaPrestamosConErrorObservable;
    }

    public void setListaPrestamosConErrorObservable(ObservableList<Prestamo> listaPrestamosConErrorObservable) {
        this.listaPrestamosConErrorObservable = listaPrestamosConErrorObservable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JButton salirButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
