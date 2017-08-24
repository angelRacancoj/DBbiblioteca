package swing.libro;

import backend.ManejadorDB.libroManejadorDB;
import backend.libros.Libro;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author angel
 */
public class ListadoLibrosFrame extends javax.swing.JInternalFrame {

    libroManejadorDB manejador;
    List<Libro> listalibros;
    ObservableList<Libro> listaLibrosObser;

    public ListadoLibrosFrame(libroManejadorDB manejador) {
        this.manejador = manejador;
        listalibros = new LinkedList<>();
        listaLibrosObser = ObservableCollections.observableList(listalibros);
        initComponents();
        this.codigoLibroFormattedTextField.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buscarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        codigoLibroFormattedTextField = new javax.swing.JFormattedTextField();
        filtrosComboBox = new javax.swing.JComboBox<>();

        setTitle("Listado de Libros");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaLibrosObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoLibro}"));
        columnBinding.setColumnName("Codigo Libro");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${titulo}"));
        columnBinding.setColumnName("Titulo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${autor}"));
        columnBinding.setColumnName("Autor");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaPublicacion}"));
        columnBinding.setColumnName("Fecha Publicacion");
        columnBinding.setColumnClass(java.time.LocalDate.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${editorial}"));
        columnBinding.setColumnName("Editorial");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadLibro}"));
        columnBinding.setColumnName("Cantidad Libro");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadLibrosInventario}"));
        columnBinding.setColumnName("Cantidad Libros Inventario");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.red);
        jLabel1.setText("Listado libros");

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

        filtrosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los Libros", "Busqueda por Codigo", "Libros Agotasdos", "Libros Sin Prestar", "Libros mas Prestados" }));
        filtrosComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                filtrosComboBoxFocusLost(evt);
            }
        });
        filtrosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrosComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(476, 476, 476))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filtrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(codigoLibroFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresarButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(codigoLibroFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresarButton)
                    .addComponent(filtrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed
    private void filtrosComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtrosComboBoxFocusLost
//        if (filtrosComboBox.getSelectedIndex()==1) {
//            this.codigoLibroFormattedTextField.setEnabled(true);
//        }else{
//            this.codigoLibroFormattedTextField.setEnabled(false);
//        }
    }//GEN-LAST:event_filtrosComboBoxFocusLost

    private void filtrosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrosComboBoxActionPerformed
        if (filtrosComboBox.getSelectedIndex()==1) {
            codigoLibroFormattedTextField.setEnabled(true);
        }else{
            codigoLibroFormattedTextField.setEnabled(false);
        }
    }//GEN-LAST:event_filtrosComboBoxActionPerformed

    public void actualizarBusquedaObservable(List<Libro> listaLibros) {
        this.listaLibrosObser.clear();
        this.listaLibrosObser.addAll(listaLibros);
    }

    public ObservableList<Libro> getListaLibrosObser() {
        return listaLibrosObser;
    }

    public void setListaLibrosObser(ObservableList<Libro> listaLibrosObser) {
        this.listaLibrosObser = listaLibrosObser;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JFormattedTextField codigoLibroFormattedTextField;
    private javax.swing.JComboBox<String> filtrosComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton regresarButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
