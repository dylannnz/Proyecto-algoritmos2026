/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package umg.proyecto2026;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class FrmReporte extends javax.swing.JFrame {
    ArrayList<estudiante> lista = new ArrayList<estudiante>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmReporte.class.getName());

    /**
     * Creates new form FrmReporte
     */
    public FrmReporte() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Reporte");
    }
    //------------------------------------------------
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresarconf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnGenerarreporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegresarconf.setText("Regresar");
        btnRegresarconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarconfActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnGenerarreporte.setText("Generar Reporte");
        btnGenerarreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarreporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegresarconf))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnGenerarreporte)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnRegresarconf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnGenerarreporte)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarconfActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnRegresarconfActionPerformed

    private void btnGenerarreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarreporteActionPerformed
    cargarEstudiantes();

        int total = lista.size();
        int asistieron = 0;
        int ausentes = 0;
        String listaAusentes = "";

        for (int i = 0; i < lista.size(); i++) {
            estudiante e = lista.get(i);

            if (e.isAsistio()==true) {
                asistieron++;
            } else {
                ausentes++;
                listaAusentes = listaAusentes + e.getCarne() + " - " + e.getNombre() + "\n";
            }
        }

        jTextArea1.setText("");
        jTextArea1.append("REPORTE FINAL DEL CONGRESO\n");
        jTextArea1.append("---------------------------\n");
        jTextArea1.append("Total de estudiantes inscritos: " + total + "\n");
        jTextArea1.append("Total de estudiantes que si asistieron: " + asistieron + "\n");
        jTextArea1.append("Total de estudiantes ausentes: " + ausentes + "\n");
        jTextArea1.append("\nListado de ausentes:\n");

        if (ausentes == 0) {
            jTextArea1.append("Ninguno\n");
        } else {
            jTextArea1.append(listaAusentes);
        }
    }//GEN-LAST:event_btnGenerarreporteActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmReporte().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarreporte;
    private javax.swing.JButton btnRegresarconf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
