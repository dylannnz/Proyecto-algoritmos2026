/*⁠​‌​​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​​‌​​​​​​‌​‌‌​‌​​‌‌‌​‌​‌​‌‌​‌‌​​​‌‌​​‌​‌​‌‌‌​‌​​​‌‌​​​​‌​​‌​​​​​​​‌​‌​​​​‌‌​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌‌‌​‌​​​‌​‌​​‌​​‌​​​​​​‌‌‌‌‌​​​​‌​​​​​​‌​‌​​‌‌​‌‌​​​​‌​‌‌‌​​‌​​‌‌​​​​‌​​‌​​​​​​‌​‌​​​​​‌‌​​‌​‌​‌‌‌​​‌​​‌‌​​‌​‌​‌‌‌‌​‌​​​‌​​​​​​​‌​‌​​​​‌‌​​​​‌​‌‌​​​‌​​‌‌‌‌​​‌​​‌​‌‌​‌​​‌‌​​​​​​‌‌​‌‌​​‌‌​‌‌​‌​​‌​‌​​‌⁠
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package umg.proyecto2026;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FrmEstudiantes extends javax.swing.JFrame {
    ArrayList<estudiante> lista = new ArrayList<estudiante>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName());

    /**
     * Creates new form FrmEstudiantes
     */
    public FrmEstudiantes() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Estudiantes");
    }
    //-----------------------
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
    //-----------------------
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
    //-----------------------
    public void limpiar() {
        txtCarnetEst.setText("");
        txtNombreEst.setText("");
        txtCorreoEst.setText("");
        txtCarnetEst.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnregresare = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Correo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreEst = new javax.swing.JTextField();
        txtCarnetEst = new javax.swing.JTextField();
        txtCorreoEst = new javax.swing.JTextField();
        btnRegistrarest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        btnregresare.setText("<-");
        btnregresare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresareActionPerformed(evt);
            }
        });

        jLabel2.setText("Carnet:");

        Correo.setText("Correo:");

        btnRegistrarest.setText("Registrar");
        btnRegistrarest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistrarest)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Correo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCarnetEst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(57, 57, 57)
                                .addComponent(txtNombreEst, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnregresare, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnregresare)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCarnetEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Correo)
                    .addComponent(txtCorreoEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(btnRegistrarest)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarestActionPerformed
    cargarEstudiantes();

        String carne = txtCarnetEst.getText().trim();
        String nombre = txtNombreEst.getText().trim();
        String correo = txtCorreoEst.getText().trim();

        boolean repetido = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCarne().equals(carne)) {
                repetido = true;
            }
        }

        if (carne.isEmpty() || nombre.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        } else if (carne.contains(",") || nombre.contains(",") || correo.contains(",")) {
            JOptionPane.showMessageDialog(this, "No use comas en los datos");
        } else if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(this, "El correo no es valido");
        } else if (repetido==true) {
            JOptionPane.showMessageDialog(this, "Ese carne ya esta inscrito");
        } else {
            estudiante nuevo = new estudiante(carne, nombre, correo);
            lista.add(nuevo);
            guardarEstudiantes();
            limpiar();
            JOptionPane.showMessageDialog(this, "Estudiante inscrito. Total: " + lista.size());
        }
    }//GEN-LAST:event_btnRegistrarestActionPerformed

    private void btnregresareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresareActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnregresareActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmEstudiantes().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Correo;
    private javax.swing.JButton btnRegistrarest;
    private javax.swing.JButton btnregresare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCarnetEst;
    private javax.swing.JTextField txtCorreoEst;
    private javax.swing.JTextField txtNombreEst;
    // End of variables declaration//GEN-END:variables
}
