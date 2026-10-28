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
public class FrmExpositores extends javax.swing.JFrame {//⁠​‌​​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​​‌​​​​​​‌​‌‌​‌​​‌‌‌​‌​‌​‌‌​‌‌​​​‌‌​​‌​‌​‌‌‌​‌​​​‌‌​​​​‌​​‌​​​​​​​‌​‌​​​​‌‌​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌‌‌​‌​​​‌​‌​​‌​​‌​​​​​​‌‌‌‌‌​​​​‌​​​​​​‌​‌​​‌‌​‌‌​​​​‌​‌‌‌​​‌​​‌‌​​​​‌​​‌​​​​​​‌​‌​​​​​‌‌​​‌​‌​‌‌‌​​‌​​‌‌​​‌​‌​‌‌‌‌​‌​​​‌​​​​​​​‌​‌​​​​‌‌​​​​‌​‌‌​​​‌​​‌‌‌‌​​‌​​‌​‌‌​‌​​‌‌​​​​​​‌‌​‌‌​​‌‌​‌‌​‌​​‌​‌​​‌⁠
    
    ArrayList<expositor> lista = new ArrayList<expositor>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmExpositores.class.getName());

    public FrmExpositores() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Expositores");
        cargarExpositores();
        mostrarEnTexto();
    }
        //-------------------------------------------------
        public void cargarExpositores() {
            lista.clear();
            File archivo = new File("expositores.csv");

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                expositor nuevo = new expositor(id, partes[1], partes[2]);
                lista.add(nuevo);
            }
        } catch (java.io.FileNotFoundException ex) { 
        }  
        }
        //-------------------------------------------------
        public void guardarExpositores() {
            try (FileWriter fw = new FileWriter("expositores.csv", false)) {
                for (int i = 0; i < lista.size(); i++) {
                    expositor e = lista.get(i);
                    fw.write(e.getIdExpositor() + "," + e.getNombre() + "," + e.getEspecialidad() + "\n");
                }
            } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, "Error al guardar el archivo");
            }
        }
        //-------------------------------------------------
        public void mostrarEnTexto() {
            taExpositores.setText("");

            for (int i = 0; i < lista.size(); i++) {
                expositor e = lista.get(i);
                taExpositores.append("ID: " + e.getIdExpositor() + " | " + e.getNombre() + " | " + e.getEspecialidad() + "\n");
            }
        }
       //-------------------------------------------------
    public void limpiar() {
        txtnombreexpositor.setText("");
        txtespecialidad.setText("");
        txtnombreexpositor.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnregresare = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtnombreexpositor = new javax.swing.JTextField();
        txtespecialidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnexportarexpositor = new javax.swing.JButton();
        btnregresarexpositores = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taExpositores = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnregresare.setText("Regresar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Especialidad");

        btnexportarexpositor.setText("Registrar");
        btnexportarexpositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportarexpositorActionPerformed(evt);
            }
        });

        btnregresarexpositores.setText("<-");
        btnregresarexpositores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarexpositoresActionPerformed(evt);
            }
        });

        taExpositores.setColumns(20);
        taExpositores.setRows(5);
        jScrollPane3.setViewportView(taExpositores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnexportarexpositor)
                        .addGap(42, 42, 42))))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombreexpositor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnregresarexpositores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnregresarexpositores)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreexpositor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addComponent(btnexportarexpositor)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarexpositoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarexpositoresActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnregresarexpositoresActionPerformed

    private void btnexportarexpositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportarexpositorActionPerformed
    cargarExpositores();

        String nombre = txtnombreexpositor.getText().trim();
        String especialidad = txtespecialidad.getText().trim();

        if (nombre.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        } else if (nombre.contains(",") || especialidad.contains(",")) {
            JOptionPane.showMessageDialog(this, "No use comas en los datos");
        } else {
            int id = lista.size() + 1;
            expositor nuevo = new expositor(id, nombre, especialidad);
            lista.add(nuevo);
            guardarExpositores();
            mostrarEnTexto();
            limpiar();
            JOptionPane.showMessageDialog(this, "Expositor registrado");
        }
    }//GEN-LAST:event_btnexportarexpositorActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmExpositores().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexportarexpositor;
    private javax.swing.JButton btnregresare;
    private javax.swing.JButton btnregresarexpositores;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea taExpositores;
    private javax.swing.JTextField txtespecialidad;
    private javax.swing.JTextField txtnombreexpositor;
    // End of variables declaration//GEN-END:variables
}
