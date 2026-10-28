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
public class FrmConferencias extends javax.swing.JFrame {//⁠​‌​​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​​‌​​​​​​‌​‌‌​‌​​‌‌‌​‌​‌​‌‌​‌‌​​​‌‌​​‌​‌​‌‌‌​‌​​​‌‌​​​​‌​​‌​​​​​​​‌​‌​​​​‌‌​​‌​​​‌‌‌‌​​‌​‌‌​‌‌​​​‌‌​​​​‌​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌​‌‌‌​​‌‌‌‌​‌​​​‌​‌​​‌​​‌​​​​​​‌‌‌‌‌​​​​‌​​​​​​‌​‌​​‌‌​‌‌​​​​‌​‌‌‌​​‌​​‌‌​​​​‌​​‌​​​​​​‌​‌​​​​​‌‌​​‌​‌​‌‌‌​​‌​​‌‌​​‌​‌​‌‌‌‌​‌​​​‌​​​​​​​‌​‌​​​​‌‌​​​​‌​‌‌​​​‌​​‌‌‌‌​​‌​​‌​‌‌​‌​​‌‌​​​​​​‌‌​‌‌​​‌‌​‌‌​‌​​‌​‌​​‌⁠
    ArrayList<conferencia> lista = new ArrayList<conferencia>();
    ArrayList<expositor> expositores = new ArrayList<expositor>();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmConferencias.class.getName());

    /**
     * Creates new form FrmConferencias
     */
    public FrmConferencias() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Conferencias");
        actualizar();
    }
//---------------------------------------    
    public void actualizar() {
        cargarExpositores();
        llenarCombo();
        cargarConferencias();
        mostrarAgenda();
    }
//---------------------------------------
    public void cargarExpositores() {
        expositores.clear();
        File archivo = new File("expositores.csv");

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                expositor nuevo = new expositor(id, partes[1], partes[2]);
                expositores.add(nuevo);
            }
        } catch (java.io.FileNotFoundException ex) {
        }
    }
//---------------------------------------
    public void llenarCombo() {
        cbExpositor.removeAllItems();

        for (int i = 0; i < expositores.size(); i++) {
            cbExpositor.addItem(expositores.get(i).getNombre());
        }
    }
//---------------------------------------
    public void cargarConferencias() {
        lista.clear();
        File archivo = new File("conferencias.csv");

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0]);
                conferencia nueva = new conferencia(id, partes[1], partes[2], partes[3]);
                lista.add(nueva);
            }
        } catch (java.io.FileNotFoundException ex) {
        }
    }
//---------------------------------------
    public void guardarConferencias() {
        try (FileWriter fw = new FileWriter("conferencias.csv", false)) {
            for (int i = 0; i < lista.size(); i++) {
                conferencia c = lista.get(i);
                fw.write(c.getIdConferencia() + "," + c.getTitulo() + "," + c.getExpositorAsignado() + "," + c.getSalon() + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo");
        }
    }
//---------------------------------------
    public void mostrarAgenda() {
        taConferencias.setText("");

        for (int i = 0; i < lista.size(); i++) {
            conferencia c = lista.get(i);
            taConferencias.append(c.getIdConferencia() + " | " + c.getTitulo() + " | " + c.getExpositorAsignado() + " | Salon: " + c.getSalon() + "\n");
        }
    }
//---------------------------------------
    public void limpiar() {
        txtTituloconf.setText("");
        txtsalonconf.setText("");
        txtTituloconf.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegresarconf = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtsalonconf = new javax.swing.JTextField();
        txtTituloconf = new javax.swing.JTextField();
        btnRegistarconf = new javax.swing.JButton();
        cbExpositor = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        taConferencias = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegresarconf.setText("Regresar");
        btnRegresarconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarconfActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo:");

        jLabel3.setText("Expositor Asignado:");

        jLabel4.setText("Salon:");

        btnRegistarconf.setText("Registrar");
        btnRegistarconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarconfActionPerformed(evt);
            }
        });

        cbExpositor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbExpositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExpositorActionPerformed(evt);
            }
        });

        taConferencias.setColumns(20);
        taConferencias.setRows(5);
        jScrollPane1.setViewportView(taConferencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresarconf))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtsalonconf, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTituloconf, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(cbExpositor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistarconf)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresarconf)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cbExpositor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTituloconf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsalonconf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistarconf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarconfActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnRegresarconfActionPerformed

    private void btnRegistarconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarconfActionPerformed
    cargarConferencias();

        String titulo = txtTituloconf.getText().trim();
        String salon = txtsalonconf.getText().trim();
        int indice = cbExpositor.getSelectedIndex();

        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Primero debe registrar un expositor");
        } else if (titulo.isEmpty() || salon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
        } else if (titulo.contains(",") || salon.contains(",")) {
            JOptionPane.showMessageDialog(this, "No use comas en los datos");
        } else {
            String expositorElegido = expositores.get(indice).getNombre();
            int id = lista.size() + 1;
            conferencia nueva = new conferencia(id, titulo, expositorElegido, salon);
            lista.add(nueva);
            guardarConferencias();
            mostrarAgenda();
            limpiar();
            JOptionPane.showMessageDialog(this, "Conferencia registrada");
        }
    }//GEN-LAST:event_btnRegistarconfActionPerformed

    private void cbExpositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExpositorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbExpositorActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FrmConferencias().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistarconf;
    private javax.swing.JButton btnRegresarconf;
    private javax.swing.JComboBox<String> cbExpositor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taConferencias;
    private javax.swing.JTextField txtTituloconf;
    private javax.swing.JTextField txtsalonconf;
    // End of variables declaration//GEN-END:variables
}
