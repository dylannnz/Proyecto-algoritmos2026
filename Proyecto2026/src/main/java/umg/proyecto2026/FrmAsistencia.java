/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package umg.proyecto2026;//⁠​‌​​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​​‌​​​​​​‌​‌‌​‌​​‌‌‌​‌​‌​‌‌​‌‌​​​‌‌​​‌​‌​‌‌‌​‌​​​‌‌​​​​‌​​‌​​​​​​​‌​‌​​​​‌‌​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌‌‌​‌​​​‌​‌​​‌​​‌​​​​​​‌‌‌‌‌​​​​‌​​​​​​‌​‌​​‌‌​‌‌​​​​‌​‌‌‌​​‌​​‌‌​​​​‌​​‌​​​​​​‌​‌​​​​​‌‌​​‌​‌​‌‌‌​​‌​​‌‌​​‌​‌​‌‌‌‌​‌​​​‌​​​​​​​‌​‌​​​​‌‌​​​​‌​‌‌​​​‌​​‌‌‌‌​​‌​​‌​‌‌​‌​​‌‌​​​​​​‌‌​‌‌​​‌‌​‌‌​‌​​‌​‌​​‌⁠
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Proyecto Final - Algoritmos (Java / Swing)
 * @author Dylan Zuleta (dylannnz) y Sara Perez (aby-06m), octubre 2026
 */
public class FrmAsistencia extends javax.swing.JFrame {//⁠​‌​​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​​‌​​​​​​‌​‌‌​‌​​‌‌‌​‌​‌​‌‌​‌‌​​​‌‌​​‌​‌​‌‌‌​‌​​​‌‌​​​​‌​​‌​​​​​​​‌​‌​​​​‌‌​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌‌‌​‌​​​‌​‌​​‌​​‌​​​​​​‌‌‌‌‌​​​​‌​​​​​​‌​‌​​‌‌​‌‌​​​​‌​‌‌‌​​‌​​‌‌​​​​‌​​‌​​​​​​‌​‌​​​​​‌‌​​‌​‌​‌‌‌​​‌​​‌‌​​‌​‌​‌‌‌‌​‌​​​‌​​​​​​​‌​‌​​​​‌‌​​​​‌​‌‌​​​‌​​‌‌‌‌​​‌​​‌​‌‌​‌​​‌‌​​​​​​‌‌​‌‌​​‌‌​‌‌​‌​​‌​‌​​‌⁠
    ArrayList<estudiante> lista = new ArrayList<estudiante>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmAsistencia.class.getName());

    /**
     * Creates new form FrmAsistencia
     */
    public FrmAsistencia() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Asistencia");
    }

    public void cargarEstudiantes() {
        lista.clear();
        File archivo = new File("estudiantes.csv");

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");

                estudiante nuevo = new estudiante(partes[0], partes[1], partes[2]);
                nuevo.setAsistio(Boolean.parseBoolean(partes[3]));
                lista.add(nuevo);
            }
        } catch (java.io.FileNotFoundException ex) {
        } 
    }

    public void guardarEstudiantes() {
        try (FileWriter fw = new FileWriter("estudiantes.csv", false)) {
            for (int i = 0; i < lista.size(); i++) {
                estudiante e = lista.get(i);
                fw.write(e.getCarne() + "," + e.getNombre() + "," + e.getCorreo() + "," + e.isAsistio() + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresarasistencia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAsistencia = new javax.swing.JButton();
        txtAsistencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegresarasistencia.setText("Regresar");
        btnRegresarasistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarasistenciaActionPerformed(evt);
            }
        });

        jLabel1.setText("Carnet del estudiante:");

        btnAsistencia.setText("Registrar Asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarasistencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAsistencia)))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarasistencia)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAsistencia)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarasistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarasistenciaActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnRegresarasistenciaActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
    cargarEstudiantes();

        String carne = txtAsistencia.getText().trim();

        int posicion = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCarne().equals(carne)) {
                posicion = i;
            }
        }

        if (carne.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el carnet del estudiante");
        } else if (posicion == -1) {
            JOptionPane.showMessageDialog(this, "Carnet no encontrado. El estudiante no esta inscrito");
        } else {
            estudiante e = lista.get(posicion);

            if (e.isAsistio()==true) {
                JOptionPane.showMessageDialog(this, e.getNombre() + " ya registro su asistencia");
            } else {
                e.setAsistio(true);
                guardarEstudiantes();
                JOptionPane.showMessageDialog(this, "Bienvenido(a) al congreso, " + e.getNombre());
            }

            txtAsistencia.setText("");
            txtAsistencia.requestFocus();
        }
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmAsistencia().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnRegresarasistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAsistencia;
    // End of variables declaration//GEN-END:variables
}
