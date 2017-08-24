/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.FrontIn.Biblioteca;

import biblioteca.BackEnd.ImportarArchivo.ManejadorArchivo;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author angel
 */
public class ImportarArchivo extends javax.swing.JInternalFrame {
    
    private ManejadorArchivo manejadorArchivo;
    public ImportarArchivo(ManejadorArchivo manejadorArchivo) {
        this.manejadorArchivo = manejadorArchivo;
        initComponents();
        archivoCompletoTextArea.setEnabled(false);
        erroresArchivoTextArea.setEnabled(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        abrirButton = new javax.swing.JButton();
        pathTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        archivoCompletoTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        erroresArchivoTextArea = new javax.swing.JTextArea();
        salirButton = new javax.swing.JButton();

        setTitle("Cargar Archivo");

        jLabel1.setText("Lectura Completa del Archivo");

        jLabel2.setText("Errores el la Lectura del Archivo");

        abrirButton.setText("Seleccionar y cargar Archivo");
        abrirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirButtonActionPerformed(evt);
            }
        });

        archivoCompletoTextArea.setColumns(20);
        archivoCompletoTextArea.setRows(5);
        jScrollPane1.setViewportView(archivoCompletoTextArea);

        erroresArchivoTextArea.setColumns(20);
        erroresArchivoTextArea.setRows(5);
        jScrollPane2.setViewportView(erroresArchivoTextArea);

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(87, 87, 87))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(abrirButton)
                                .addGap(18, 18, 18)
                                .addComponent(pathTextField)
                                .addGap(18, 18, 18)))
                        .addComponent(salirButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirButton)
                    .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirButtonActionPerformed
        JFileChooser dialogo = new JFileChooser();
        dialogo.setDialogTitle("Abrir");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("EntradaProyecto","txt");
        dialogo.setFileFilter(filtro);
        if (dialogo.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            String path =dialogo.getSelectedFile().getPath();
            pathTextField.setText(path);
            archivoCompletoTextArea.setText(manejadorArchivo.lecturaDelArchivo(path));
            
        }
    }//GEN-LAST:event_abrirButtonActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_salirButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirButton;
    private javax.swing.JTextArea archivoCompletoTextArea;
    private javax.swing.JTextArea erroresArchivoTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
