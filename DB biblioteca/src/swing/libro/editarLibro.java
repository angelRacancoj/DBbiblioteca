package swing.libro;

import backend.ManejadorDB.libroManejadorDB;
import backend.libros.Libro;
import biblioteca.BackEnd.Excepciones.InputsVaciosException;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author angelrg
 */
public class editarLibro extends javax.swing.JDialog {

    private libroManejadorDB manejadorLibros;
    private Libro libro;

    /**
     * Creates new form editarLibro
     */
    public editarLibro(boolean modal, libroManejadorDB manejador) {
        this.manejadorLibros = manejador;
        initComponents();
        this.setModal(modal);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        Libro libroAnterior = this.libro;
        this.libro = libro;
        firePropertyChange("libro", libroAnterior, this.libro);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        codigoFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        autorTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        EditorialTextField = new javax.swing.JTextField();
        regresarButton = new javax.swing.JButton();
        cantCopiasFormattedTextField = new javax.swing.JFormattedTextField();
        guardarButton = new javax.swing.JButton();
        fechaPublicacionFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tituloTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Libro");

        jLabel4.setText("Titulo:");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel9.setText("Ej: Dennis Zill");

        jLabel5.setText("Cantidad de copias:");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel10.setText("Ej: Fisica 1");

        jLabel6.setText("Fecha de Publicacion");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel11.setText("Ej: 5");

        jLabel7.setText("Editorial:");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel12.setText("Ej: 2014/04/02 ");

        try {
            codigoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-AAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        codigoFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFormattedTextFieldFocusLost(evt);
            }
        });
        codigoFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoFormattedTextFieldActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 8)); // NOI18N
        jLabel13.setText("yyyy/mm/dd");

        jLabel14.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel14.setText("Ej: Santillana");

        regresarButton.setText("Regresar");
        regresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarButtonActionPerformed(evt);
            }
        });

        cantCopiasFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        try {
            fechaPublicacionFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Codigo:");

        jLabel3.setText("Autor:");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 10)); // NOI18N
        jLabel8.setText("Ej: 123-ASD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EditorialTextField))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(tituloTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(codigoFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                        .addComponent(autorTextField)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cantCopiasFormattedTextField)
                                .addComponent(fechaPublicacionFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))
                    .addComponent(regresarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardarButton)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantCopiasFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaPublicacionFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(EditorialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regresarButton)
                    .addComponent(guardarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFormattedTextFieldFocusLost
        if (manejadorLibros.existeLibroPorCodigo(codigoFormattedTextField.getText(), libro.getCodigo())) {
            JOptionPane.showMessageDialog(this.getParent(), "Ya existe el Codigo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_codigoFormattedTextFieldFocusLost

    private void codigoFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoFormattedTextFieldActionPerformed

    private void regresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarButtonActionPerformed
        limpiar();
        setLibro(null);
        this.setVisible(false);
    }//GEN-LAST:event_regresarButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        try {
            if (codigoFormattedTextField.getText().replace("-", "").replace(" ", "").isEmpty() || autorTextField.getText().replace(" ", "").isEmpty() || tituloTextField.getText().replace(" ", "").isEmpty() || cantCopiasFormattedTextField.getText().replace(" ", "").isEmpty()) {
                JOptionPane.showMessageDialog(this.getParent(), "Existen campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!fechaPublicacionFormattedTextField.getText().replace(" ", "").replace("-", "").isEmpty()) {
                Date fecha = Date.valueOf(LocalDate.parse(fechaPublicacionFormattedTextField.getText(), DateTimeFormatter.ISO_DATE));
            } else if (manejadorLibros.existeLibroPorCodigo(codigoFormattedTextField.getText(), libro.getCodigo())) {
                JOptionPane.showMessageDialog(this.getParent(), "Ya existe el Codigo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                manejadorLibros.modificarLibroDisponibles(libro.getCodigo(), codigoFormattedTextField.getText(), autorTextField.getText(), tituloTextField.getText(), cantCopiasFormattedTextField.getText(), fechaPublicacionFormattedTextField.getText(), EditorialTextField.getText());
                JOptionPane.showMessageDialog(this.getParent(), "Estudiante guardado exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                libro = null;
                this.setVisible(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se enlazo a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputsVaciosException ex) {
            Logger.getLogger(NuevoLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Fecha Invalida", "Error", JOptionPane.ERROR_MESSAGE);
            fechaPublicacionFormattedTextField.setText("");
        }

    }//GEN-LAST:event_guardarButtonActionPerformed

    public void editar(Libro libroParaEditar) {
        libro = libroParaEditar;
        EditorialTextField.setText(libroParaEditar.getEditorial());
        autorTextField.setText(libroParaEditar.getAutor());
        cantCopiasFormattedTextField.setText(String.valueOf(libroParaEditar.getCantidadLibros()));
        codigoFormattedTextField.setText(libroParaEditar.getCodigo());
        fechaPublicacionFormattedTextField.setText(String.valueOf(libroParaEditar.getFechaPublicacion()));
        tituloTextField.setText(libroParaEditar.getTitulo());
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EditorialTextField;
    private javax.swing.JTextField autorTextField;
    private javax.swing.JFormattedTextField cantCopiasFormattedTextField;
    private javax.swing.JFormattedTextField codigoFormattedTextField;
    private javax.swing.JFormattedTextField fechaPublicacionFormattedTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton regresarButton;
    private javax.swing.JTextField tituloTextField;
    // End of variables declaration//GEN-END:variables
private void limpiar() {
        EditorialTextField.setText("");
        autorTextField.setText("");
        cantCopiasFormattedTextField.setText("");
        codigoFormattedTextField.setText("");
        fechaPublicacionFormattedTextField.setText("");
    }
}
