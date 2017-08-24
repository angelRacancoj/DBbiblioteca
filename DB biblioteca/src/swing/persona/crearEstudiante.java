package swing.persona;

import backend.ManejadorDB.estudiantesManejadorDB;
import backend.personas.Estudiante;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.awt.Dialog;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.ValidationException;

/**
 *
 * @author angelrg
 */
public class crearEstudiante extends javax.swing.JFrame {

    private estudiantesManejadorDB manejadorEst;
    private Estudiante estudiante;
    
    public crearEstudiante(boolean modal, estudiantesManejadorDB manejador) {
        this.manejadorEst = manejador;
        initComponents();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        Estudiante estAnterior = this.estudiante;
        this.estudiante = estudiante;
        firePropertyChange("estudiante", estAnterior,this.estudiante);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        noCarnetTextField = new javax.swing.JFormattedTextField();
        noCarnetLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        carreraLabel = new javax.swing.JLabel();
        carreraComboBox = new javax.swing.JComboBox<>();
        cumpleFormattedTextField = new javax.swing.JFormattedTextField();
        carreraLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        guardarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        regresarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        try {
            noCarnetTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        noCarnetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noCarnetTextFieldActionPerformed(evt);
            }
        });

        noCarnetLabel.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        noCarnetLabel.setText("Numero de Carnet:");

        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        nombreLabel.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        nombreLabel.setText("Nombre Completo:");

        carreraLabel.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        carreraLabel.setText("Carrera:");

        carreraComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingeniería", "Medicina", "Derecho", "Arquitectura", "Administración" }));
        carreraComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carreraComboBoxActionPerformed(evt);
            }
        });

        try {
            cumpleFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        carreraLabel1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        carreraLabel1.setText("Fecha Nacimiento:");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel1.setText("Ej: 201502021");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel2.setText("Jose Mario, Perez Perez");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel3.setText("Seleccione su carrera");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel4.setText("Ej: 2017/01/01");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
        jLabel5.setForeground(java.awt.Color.red);
        jLabel5.setText("Nuevo Estudiante");

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setText("Limpiar");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(233, 233, 233))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(noCarnetLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(carreraLabel)
                                .addComponent(nombreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carreraLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carreraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(nombreTextField)
                            .addComponent(noCarnetTextField)
                            .addComponent(cumpleFormattedTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(limpiarButton)
                        .addGap(18, 18, 18)
                        .addComponent(regresarButton)
                        .addGap(273, 273, 273)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(guardarButton)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noCarnetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noCarnetLabel)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carreraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carreraLabel)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cumpleFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carreraLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(limpiarButton)
                    .addComponent(regresarButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noCarnetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noCarnetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noCarnetTextFieldActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void carreraComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carreraComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carreraComboBoxActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        try {
            manejadorEst.agregarEstudiante(noCarnetTextField.getText(), String.valueOf(carreraComboBox.getSelectedIndex()+1),nombreTextField.getText(), cumpleFormattedTextField.getText());
            limpiar();
            JOptionPane.showMessageDialog(this.getParent(), "Estudiante guardado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se enlazo a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> carreraComboBox;
    private javax.swing.JLabel carreraLabel;
    private javax.swing.JLabel carreraLabel1;
    private javax.swing.JFormattedTextField cumpleFormattedTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JLabel noCarnetLabel;
    private javax.swing.JFormattedTextField noCarnetTextField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables

public void limpiar(){
    cumpleFormattedTextField.setText("");
    noCarnetTextField.setText("");
    noCarnetTextField.setText("");
}
}
