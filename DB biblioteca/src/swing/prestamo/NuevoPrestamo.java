package swing.prestamo;

import backend.ManejadorDB.estudiantesManejadorDB;
import backend.ManejadorDB.libroManejadorDB;
import backend.ManejadorDB.prestamosManejadorDB;
import backend.prestamos.Prestamo;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class NuevoPrestamo extends javax.swing.JFrame {

    private prestamosManejadorDB manejadorPrestamo;
    private libroManejadorDB manejadorLibros;
    private estudiantesManejadorDB manejadorEst;
    private Prestamo prestamo;

    public NuevoPrestamo(boolean modal, prestamosManejadorDB manejador, libroManejadorDB manejadorLibro, estudiantesManejadorDB manejadorEstud) {
        this.manejadorPrestamo = manejador;
        this.manejadorLibros = manejadorLibro;
        this.manejadorEst = manejadorEstud;
        initComponents();
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoL1FormattedTextField = new javax.swing.JFormattedTextField();
        carnetEstFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaPrestamoFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        regresarButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel9.setText("Ej: 123-ASD");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prestar Libro");

        jLabel2.setText("Codigo del Libro:");

        try {
            codigoL1FormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-AAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        codigoL1FormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoL1FormattedTextFieldFocusLost(evt);
            }
        });
        codigoL1FormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoL1FormattedTextFieldActionPerformed(evt);
            }
        });

        try {
            carnetEstFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        carnetEstFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                carnetEstFormattedTextFieldFocusLost(evt);
            }
        });

        jLabel5.setText("Carnet Estudiante:");

        try {
            fechaPrestamoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Fecha del prestamo:");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel8.setText("Ej: 123-ASD");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel7.setText("Ej: 201112121");

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 8)); // NOI18N
        jLabel13.setText("yyyy/mm/dd");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel12.setText("Ej: 2014/04/02 ");

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        guardarButton.setText("Guardar prestamo");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        limpiarButton.setText("Limpiar Campos");
        limpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoL1FormattedTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(carnetEstFormattedTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(fechaPrestamoFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel13))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(regresarButton)
                                .addGap(18, 18, 18)
                                .addComponent(limpiarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guardarButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigoL1FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carnetEstFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaPrestamoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarButton)
                    .addComponent(guardarButton)
                    .addComponent(limpiarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoL1FormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoL1FormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoL1FormattedTextFieldActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        try {
            if (manejadorLibros.aunExistenLibros(codigoL1FormattedTextField.getText()) == false) {
                JOptionPane.showMessageDialog(this, "No quedan libros con el codigo: " + codigoL1FormattedTextField.getText(), "Error", JOptionPane.ERROR_MESSAGE);
                guardarButton.setEnabled(false);
            } else if (manejadorPrestamo.limiteDePrestamosAbiertos(carnetEstFormattedTextField.getText())) {
                JOptionPane.showMessageDialog(this, "El estudiante: " + carnetEstFormattedTextField.getText() + " ha llegado al limite de perstamos", "Error", JOptionPane.ERROR_MESSAGE);
                guardarButton.setEnabled(false);
            } else if (codigoL1FormattedTextField.getText().replace(" ", "").replace("-", "").isEmpty()
                    || carnetEstFormattedTextField.getText().replace(" ", "").isEmpty()
                    || fechaPrestamoFormattedTextField.getText().replace(" ", "").replace("-", "").isEmpty()) {
                JOptionPane.showMessageDialog(this, "Aun quedan campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                guardarButton.setEnabled(false);
            }else{
                manejadorPrestamo.nuevoPrestamo(carnetEstFormattedTextField.getText(), codigoL1FormattedTextField.getText(), fechaPrestamoFormattedTextField.getText());
            limpiar();
            setVisible(false);
            JOptionPane.showMessageDialog(this, "Prestamo Exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
            guardarButton.setEnabled(true);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se enlazo a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputsVaciosException ex) {
            Logger.getLogger(NuevoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void limpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarButtonActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarButtonActionPerformed

    private void codigoL1FormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoL1FormattedTextFieldFocusLost
        try {
            if (manejadorLibros.aunExistenLibros(codigoL1FormattedTextField.getText()) == false) {
                JOptionPane.showMessageDialog(this, "No quedan libros con el codigo: " + codigoL1FormattedTextField.getText(), "Error", JOptionPane.ERROR_MESSAGE);
                codigoL1FormattedTextField.setText("");
                guardarButton.setEnabled(false);
            } else if(manejadorLibros.existeLibro(codigoL1FormattedTextField.getText())== false){
                JOptionPane.showMessageDialog(this, "No exite el libro con el codigo: " + codigoL1FormattedTextField.getText(), "Error", JOptionPane.ERROR_MESSAGE);
                codigoL1FormattedTextField.setText("");
                guardarButton.setEnabled(false);
            }else if(codigoL1FormattedTextField.getText().replace(" ","").replace("-","").isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe colocar el codigo del libro", "Error", JOptionPane.ERROR_MESSAGE);
                codigoL1FormattedTextField.setText("");
                guardarButton.setEnabled(false);
            }else{
                guardarButton.setEnabled(true);
            }
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_codigoL1FormattedTextFieldFocusLost

    private void carnetEstFormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_carnetEstFormattedTextFieldFocusLost
        try {
            if (manejadorPrestamo.limiteDePrestamosAbiertos(carnetEstFormattedTextField.getText())) {
                JOptionPane.showMessageDialog(this, "El estudiante: " + carnetEstFormattedTextField.getText() + " ha llegado al limite de perstamos", "Error", JOptionPane.ERROR_MESSAGE);
                carnetEstFormattedTextField.setText("");
                guardarButton.setEnabled(false);
            } else if(manejadorEst.existeEst(carnetEstFormattedTextField.getText())==false){
                JOptionPane.showMessageDialog(this, "El estudiante: " + carnetEstFormattedTextField.getText() + " no existe", "Error", JOptionPane.ERROR_MESSAGE);
                carnetEstFormattedTextField.setText("");
                guardarButton.setEnabled(false);
            }else if(carnetEstFormattedTextField.getText().replace(" ","").isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe colocar el nombre carnet", "Error", JOptionPane.ERROR_MESSAGE);
                carnetEstFormattedTextField.setText("");
                guardarButton.setEnabled(false);
            }else{
                guardarButton.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_carnetEstFormattedTextFieldFocusLost

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        limpiar();
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField carnetEstFormattedTextField;
    private javax.swing.JFormattedTextField codigoL1FormattedTextField;
    private javax.swing.JFormattedTextField fechaPrestamoFormattedTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JButton regresarButton;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        carnetEstFormattedTextField.setText("");
        codigoL1FormattedTextField.setText("");
        fechaPrestamoFormattedTextField.setText("");
    }
}
