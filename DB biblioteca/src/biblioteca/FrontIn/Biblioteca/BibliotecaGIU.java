package biblioteca.FrontIn.Biblioteca;

import backend.ManejadorDB.estudiantesManejadorDB;
import backend.ManejadorDB.libroManejadorDB;
import backend.ManejadorDB.prestamosManejadorDB;
import java.sql.Connection;
import swing.libro.ListadoLibrosFrame;
import swing.libro.NuevoLibro;
import swing.persona.crearEstudiante;
import swing.persona.listadoEstudiantesFrame;

/**
 *
 * @author angel
 */
public class BibliotecaGIU extends javax.swing.JFrame {

    private estudiantesManejadorDB manejadorEstudiante;
    private libroManejadorDB manejadorLibros;
    private prestamosManejadorDB manejadorPrestamos;
    //Frames
    private crearEstudiante nuevoEstudiante;
    private NuevoLibro nuevoLibro;
    private listadoEstudiantesFrame listadoEstFrame;
    private ListadoLibrosFrame listadoLibrosFrame;
    /**
     * Creates new form Biblioteca
     */
    public BibliotecaGIU(Connection conexion) {
        this.manejadorEstudiante = new estudiantesManejadorDB(conexion);
        this.manejadorLibros = new libroManejadorDB(conexion);
        
        
        nuevoEstudiante = new crearEstudiante(true, manejadorEstudiante);
        nuevoLibro = new NuevoLibro(true, manejadorLibros);
        listadoEstFrame = new listadoEstudiantesFrame(manejadorEstudiante);
        listadoLibrosFrame = new ListadoLibrosFrame(manejadorLibros);
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.DesktopPane.add(listadoEstFrame);
        this.DesktopPane.add(listadoLibrosFrame);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        DesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoEstudianteMenuItem = new javax.swing.JMenuItem();
        listaEstudiantesMenuItem = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        nuevoLibroMenuItem = new javax.swing.JMenuItem();
        listaLibrosMenuItem = new javax.swing.JMenuItem();
        prestamoMenu = new javax.swing.JMenu();
        prestarLibroMenuItem = new javax.swing.JMenuItem();
        devolverLibroMenuItem = new javax.swing.JMenuItem();
        listadoprestamosMenuItem = new javax.swing.JMenuItem();
        librosDevolverHoyMenu = new javax.swing.JMenu();
        librosPrestadosMenuItem = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuArchivoMenu = new javax.swing.JMenu();
        cargarArchivoMenuItem = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca CUNOC");

        jMenu1.setText("Estudiantes");

        nuevoEstudianteMenuItem.setText("Nuevo estudiante");
        nuevoEstudianteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEstudianteMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoEstudianteMenuItem);

        listaEstudiantesMenuItem.setText("Lista estudiantes");
        listaEstudiantesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEstudiantesMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(listaEstudiantesMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Libros");

        nuevoLibroMenuItem.setText("nuevo Libro");
        nuevoLibroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoLibroMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(nuevoLibroMenuItem);

        listaLibrosMenuItem.setText("Lista libros");
        listaLibrosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaLibrosMenuItemActionPerformed(evt);
            }
        });
        jMenu4.add(listaLibrosMenuItem);

        jMenuBar1.add(jMenu4);

        prestamoMenu.setText("Prestamo");

        prestarLibroMenuItem.setText("Prestar");
        prestarLibroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestarLibroMenuItemActionPerformed(evt);
            }
        });
        prestamoMenu.add(prestarLibroMenuItem);

        devolverLibroMenuItem.setText("Devolver");
        devolverLibroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverLibroMenuItemActionPerformed(evt);
            }
        });
        prestamoMenu.add(devolverLibroMenuItem);

        listadoprestamosMenuItem.setText("Listado Prestamos");
        listadoprestamosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoprestamosMenuItemActionPerformed(evt);
            }
        });
        prestamoMenu.add(listadoprestamosMenuItem);

        jMenuBar1.add(prestamoMenu);

        librosDevolverHoyMenu.setText("Reportes");

        librosPrestadosMenuItem.setText("Libros en prestamo");
        librosDevolverHoyMenu.add(librosPrestadosMenuItem);

        jMenuItem4.setText("Libros Prestados (Cantidad)");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        librosDevolverHoyMenu.add(jMenuItem4);

        jMenuBar1.add(librosDevolverHoyMenu);

        menuArchivoMenu.setText(" Archivo ");
        menuArchivoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArchivoMenuActionPerformed(evt);
            }
        });

        cargarArchivoMenuItem.setText("Cargar Archivo");
        cargarArchivoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoMenuItemActionPerformed(evt);
            }
        });
        menuArchivoMenu.add(cargarArchivoMenuItem);

        jMenuBar1.add(menuArchivoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devolverLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverLibroMenuItemActionPerformed
        
    }//GEN-LAST:event_devolverLibroMenuItemActionPerformed

    private void nuevoEstudianteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEstudianteMenuItemActionPerformed
        this.nuevoEstudiante.setVisible(true);
    }//GEN-LAST:event_nuevoEstudianteMenuItemActionPerformed

    private void listaEstudiantesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEstudiantesMenuItemActionPerformed
        this.listadoEstFrame.setVisible(true);
    }//GEN-LAST:event_listaEstudiantesMenuItemActionPerformed

    private void nuevoLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoLibroMenuItemActionPerformed
        this.nuevoLibro.setVisible(true);
    }//GEN-LAST:event_nuevoLibroMenuItemActionPerformed

    private void listaLibrosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaLibrosMenuItemActionPerformed
        this.listadoLibrosFrame.setVisible(true);
    }//GEN-LAST:event_listaLibrosMenuItemActionPerformed

    private void prestarLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestarLibroMenuItemActionPerformed
        
    }//GEN-LAST:event_prestarLibroMenuItemActionPerformed

    private void listadoprestamosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoprestamosMenuItemActionPerformed
        
    }//GEN-LAST:event_listadoprestamosMenuItemActionPerformed

    private void menuArchivoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoMenuActionPerformed
        
    }//GEN-LAST:event_menuArchivoMenuActionPerformed

    private void cargarArchivoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoMenuItemActionPerformed
        
    }//GEN-LAST:event_cargarArchivoMenuItemActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenuItem cargarArchivoMenuItem;
    private javax.swing.JMenuItem devolverLibroMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu librosDevolverHoyMenu;
    private javax.swing.JMenuItem librosPrestadosMenuItem;
    private javax.swing.JMenuItem listaEstudiantesMenuItem;
    private javax.swing.JMenuItem listaLibrosMenuItem;
    private javax.swing.JMenuItem listadoprestamosMenuItem;
    private javax.swing.JMenu menuArchivoMenu;
    private javax.swing.JMenuItem nuevoEstudianteMenuItem;
    private javax.swing.JMenuItem nuevoLibroMenuItem;
    private javax.swing.JMenu prestamoMenu;
    private javax.swing.JMenuItem prestarLibroMenuItem;
    // End of variables declaration//GEN-END:variables
}
