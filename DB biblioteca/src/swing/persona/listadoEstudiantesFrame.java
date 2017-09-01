package swing.persona;

import backend.ManejadorDB.estudiantesManejadorDB;
import backend.personas.Estudiante;
import java.sql.SQLException;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class listadoEstudiantesFrame extends javax.swing.JInternalFrame {

    private estudiantesManejadorDB manejador;
    private List<Estudiante> listaEstudiantes;
    private ObservableList<Estudiante> listaEstObservable;
    private Estudiante estudianteSeleccionado;
    private editarEstudiante editarEst;

    /**
     * Creates new form listadoEstudiantes
     */
    public listadoEstudiantesFrame(estudiantesManejadorDB manejador) {
        this.manejador = manejador;
        listaEstudiantes = new LinkedList<>();
        listaEstObservable = ObservableCollections.observableList(listaEstudiantes);
        editarEst = new editarEstudiante(true, manejador);
        estudianteSeleccionado = new Estudiante();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        buscarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        carnetFormattedTextField = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        codigoCarreraFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LimpiarButton = new javax.swing.JButton();
        editarEstudianteButton = new javax.swing.JButton();

        setTitle("Listado de Estudiantes");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("Listado Estudiantes");

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

        jLabel2.setText("Carnet: ");

        try {
            carnetFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        carnetFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetFormattedTextFieldActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEstObservable}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${carnet}"));
        columnBinding.setColumnName("Carnet");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoCarreraNombre}"));
        columnBinding.setColumnName("Codigo Carrera Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaDeNacimiento}"));
        columnBinding.setColumnName("Fecha De Nacimiento");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${estudianteSeleccionado}"), jTable2, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(jTable2);

        jLabel3.setText("Codigo de la Carrera**:");

        try {
            codigoCarreraFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        codigoCarreraFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoCarreraFormattedTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre");

        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("**Codigos de las Carreras: 1->Ingenieria, 2->Medicina, 3->Derecho, 4->Arquitectura, 5->Administracion");

        jLabel6.setText("*Ej: 201631547");

        LimpiarButton.setText("Limpiar");
        LimpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarButtonActionPerformed(evt);
            }
        });

        editarEstudianteButton.setText("Editar Estudiante");
        editarEstudianteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEstudianteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(carnetFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 7, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codigoCarreraFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nombreTextField)
                                        .addGap(18, 18, 18)
                                        .addComponent(buscarButton))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LimpiarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editarEstudianteButton)
                        .addGap(18, 18, 18)
                        .addComponent(regresarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(jLabel2)
                    .addComponent(carnetFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(codigoCarreraFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarButton)
                    .addComponent(LimpiarButton)
                    .addComponent(editarEstudianteButton))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        try {
            actualizarBusquedaObservable(manejador.consultaEstudiantesFiltros(carnetFormattedTextField.getText(), codigoCarreraFormattedTextField.getText(), nombreTextField.getText()));
            limpiar();
        } catch (SQLException e) {

        }
        limpiar();
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void carnetFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnetFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carnetFormattedTextFieldActionPerformed

    private void codigoCarreraFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoCarreraFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoCarreraFormattedTextFieldActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void LimpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LimpiarButtonActionPerformed

    private void editarEstudianteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEstudianteButtonActionPerformed
        editarEst.editar(estudianteSeleccionado);
    }//GEN-LAST:event_editarEstudianteButtonActionPerformed

    public void actualizarBusquedaObservable(List<Estudiante> listaEstudiantes) {
        this.listaEstObservable.clear();
        this.listaEstObservable.addAll(listaEstudiantes);
    }

    public ObservableList<Estudiante> getListaEstObservable() {
        return listaEstObservable;
    }

    public void setListaEstObservable(ObservableList<Estudiante> listaEstutiantesObservable) {
        this.listaEstObservable = listaEstutiantesObservable;
    }

    public Estudiante getEstudianteSeleccionado() {
        return estudianteSeleccionado;
    }

    public void setEstudianteSeleccionado(Estudiante estudianteSeleccionado) {
        if (estudianteSeleccionado != null) {
            this.estudianteSeleccionado = estudianteSeleccionado.clone();
            editarEstudianteButton.setEnabled(true);
        } else {
            editarEstudianteButton.setEnabled(false);
            this.estudianteSeleccionado = null;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.JFormattedTextField carnetFormattedTextField;
    private javax.swing.JFormattedTextField codigoCarreraFormattedTextField;
    private javax.swing.JButton editarEstudianteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JButton regresarButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
private void limpiar() {
        carnetFormattedTextField.setText("");
        codigoCarreraFormattedTextField.setText("");
        nombreTextField.setText("");
    }

}
