package swing.libro;

import backend.ManejadorDB.estudiantesManejadorDB;
import backend.ManejadorDB.libroManejadorDB;
import backend.libros.Libro;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import run.ValoresPredeterminados;

/**
 *
 * @author angel
 */
public class ListadoLibrosFrame extends javax.swing.JInternalFrame {

    private libroManejadorDB manejador;
    private estudiantesManejadorDB manejadorEst;
    private List<Libro> listalibros;
    private ObservableList<Libro> listaLibrosOb;
    private Libro libroSeleccionado;
    private editarLibro editarLib;

    public ListadoLibrosFrame(libroManejadorDB manejador) {
        this.manejador = manejador;
        listalibros = new LinkedList<>();
        listaLibrosOb = ObservableCollections.observableList(listalibros);
        editarLib = new editarLibro(true, manejador);
        libroSeleccionado = new Libro();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buscarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        codigoLibroFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tituloTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        autorTextField = new javax.swing.JTextField();
        editarLibroButton = new javax.swing.JButton();
        opcionesComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        carnetFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();

        setResizable(true);
        setTitle("Listado de Libros");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaLibrosOb}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${titulo}"));
        columnBinding.setColumnName("Titulo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autor}"));
        columnBinding.setColumnName("Autor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${editorial}"));
        columnBinding.setColumnName("Editorial");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPublicacion}"));
        columnBinding.setColumnName("Fecha Publicacion");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadLibros}"));
        columnBinding.setColumnName("Cantidad Libros");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadLibrosDisponibles}"));
        columnBinding.setColumnName("Cantidad Libros Disponibles");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${libroSeleccionado}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        try {
            codigoLibroFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-AAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Codigo:");

        jLabel3.setText("Autor: ");

        jLabel4.setText("Titulo:");

        editarLibroButton.setText("Editar Libro");
        editarLibroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarLibroButtonActionPerformed(evt);
            }
        });

        opcionesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda con Filtros", "Libros agotados", "Libros prestados actualmente a un estudiante", "Libros que no han sido prestados" }));
        opcionesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Carnet:");

        try {
            carnetFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Estudiante:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opcionesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editarLibroButton)
                        .addGap(18, 18, 18)
                        .addComponent(regresarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(codigoLibroFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carnetFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLibroFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(autorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(carnetFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opcionesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editarLibroButton)
                            .addComponent(buscarButton)
                            .addComponent(regresarButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        try {
            switch (opcionesComboBox.getSelectedIndex()) {
                case ValoresPredeterminados.FILTROS_PARA_BUSQUEDA_LIBROS:
                    actualizarBusquedaObservable(manejador.ConsultarLibrosFiltros(codigoLibroFormattedTextField.getText(), tituloTextField.getText(), autorTextField.getText()));
                    limpiar();
                    break;
                case ValoresPredeterminados.LIBROS_AGOTADOS:
                    actualizarBusquedaObservable(manejador.librosAgotados());
                    limpiar();
                    break;
                case ValoresPredeterminados.LIBROS_PRESTADOS_A_UN_ESTUDIANTE:
                    if (carnetFormattedTextField.getText().replace(" ","").isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Debe especificarse un numero de carnet", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        actualizarBusquedaObservable(manejador.librosEnPrestamoAUnEstudiante(carnetFormattedTextField.getText()));
                    nombreTextField.setText(carnetFormattedTextField.getText());
                    limpiar();
                    }
                    break;
                case ValoresPredeterminados.LIBROS_SIN_PRESTAR:
                    actualizarBusquedaObservable(manejador.librosSinPrestar());
                    limpiar();
                    break;
            }
        } catch (SQLException | InputsVaciosException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buscarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void editarLibroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarLibroButtonActionPerformed
        editarLib.editar(libroSeleccionado);
    }//GEN-LAST:event_editarLibroButtonActionPerformed

    private void opcionesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesComboBoxActionPerformed
        switch (opcionesComboBox.getSelectedIndex()) {
            case ValoresPredeterminados.FILTROS_PARA_BUSQUEDA_LIBROS:
                casillasEditables(true, false);
                break;
            case ValoresPredeterminados.LIBROS_AGOTADOS:
                casillasEditables(false, false);
                break;
            case ValoresPredeterminados.LIBROS_PRESTADOS_A_UN_ESTUDIANTE:
                casillasEditables(false, true);
                break;
            case ValoresPredeterminados.LIBROS_SIN_PRESTAR:
                casillasEditables(false, false);
                break;

        }
    }//GEN-LAST:event_opcionesComboBoxActionPerformed

    public void actualizarBusquedaObservable(List<Libro> listaLibros) {
        this.listaLibrosOb.clear();
        this.listaLibrosOb.addAll(listaLibros);
    }

    public ObservableList<Libro> getListaLibrosOb() {
        return listaLibrosOb;
    }

    public void setListaLibrosOb(ObservableList<Libro> listaLibrosObser) {
        this.listaLibrosOb = listaLibrosObser;
    }

    public Libro getLibroSeleccionado() {
        return libroSeleccionado;
    }

    public void setLibroSeleccionado(Libro libroSeleccionado) {
        if (libroSeleccionado != null) {
            this.libroSeleccionado = libroSeleccionado.clone();
            editarLibroButton.setEnabled(true);
        } else {
            editarLibroButton.setEnabled(false);
            this.libroSeleccionado = null;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autorTextField;
    private javax.swing.JButton buscarButton;
    private javax.swing.JFormattedTextField carnetFormattedTextField;
    private javax.swing.JFormattedTextField codigoLibroFormattedTextField;
    private javax.swing.JButton editarLibroButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JComboBox<String> opcionesComboBox;
    private javax.swing.JButton regresarButton;
    private javax.swing.JTextField tituloTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        codigoLibroFormattedTextField.setText("");
        tituloTextField.setText("");
        autorTextField.setText("");
    }

    public void casillasEditables(boolean editable, boolean conCarnet) {
        codigoLibroFormattedTextField.setEnabled(editable);
        tituloTextField.setEnabled(editable);
        autorTextField.setEnabled(editable);
        carnetFormattedTextField.setEnabled(conCarnet);
    }
}
