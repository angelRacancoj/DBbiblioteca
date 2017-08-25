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

    estudiantesManejadorDB manejador;
    List<Estudiante> listaEstudiantes;
    ObservableList<Estudiante> listaEstObservable;

    /**
     * Creates new form listadoEstudiantes
     */
    public listadoEstudiantesFrame(estudiantesManejadorDB manejador) {
        this.manejador= manejador;
        listaEstudiantes = new LinkedList<>();
        listaEstObservable= ObservableCollections.observableList(listaEstudiantes);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buscarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        carnetFormattedTextField = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(carnetFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscarButton))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(368, 368, 368))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(regresarButton)
                        .addContainerGap())))
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
                    .addComponent(carnetFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(regresarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        if (carnetFormattedTextField.getText().replace(" ", "").isEmpty()) {
            try {
                actualizarBusquedaObservable(manejador.consutlaEstudiantes());
            } catch (SQLException ex) {
                Logger.getLogger(listadoEstudiantesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                actualizarBusquedaObservable(manejador.buscarEstudiantePorCarnet(carnetFormattedTextField.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(listadoEstudiantesFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        limpiar();
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed

    public void actualizarBusquedaObservable(List<Estudiante> listaEstudiantes) {
        this.listaEstObservable.clear();
        this.listaEstObservable.addAll(listaEstudiantes);
    }

    public ObservableList<Estudiante> getListaEstutiantesObservable() {
        return listaEstObservable;
    }

    public void setListaEstutiantesObservable(ObservableList<Estudiante> listaEstutiantesObservable) {
        this.listaEstObservable = listaEstutiantesObservable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JFormattedTextField carnetFormattedTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables
private void limpiar() {
        carnetFormattedTextField.setText("");
    }

}
