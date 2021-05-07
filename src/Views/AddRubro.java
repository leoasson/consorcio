package Views;

import consorcio.AuxiliaryFunctions;
import javax.swing.JOptionPane;

/**
 *
 * @author leoasson
 */
public class AddRubro extends javax.swing.JInternalFrame {
    
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    main main;
    
    public AddRubro(main main)
    {
        this.main = main;
        initComponents();
        fieldRubro.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonAddRubro = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fieldRubro = new javax.swing.JTextField();

        setTitle("Agregar rubro");

        jLabel1.setText("Rubro");

        buttonAddRubro.setText("Agregar");
        buttonAddRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRubroActionPerformed(evt);
            }
        });

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/question40.png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);

        fieldRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRubroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(buttonAddRubro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(fieldRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(fieldRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddRubro)
                    .addComponent(exitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
    this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void buttonAddRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddRubroActionPerformed
        String  rubro = fieldRubro.getText().toUpperCase();
        if(rubro.isEmpty() || rubro.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Debe escribir el rubro", "Atencion", JOptionPane.WARNING_MESSAGE);
            fieldRubro.requestFocus();
        }
        else
        {
            if (af.insertRubro(rubro))
            {
                JOptionPane.showMessageDialog(null,"El rubro se agrego correctamente.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                fieldRubro.setText("");
                fieldRubro.requestFocus();
            }
        }
    }//GEN-LAST:event_buttonAddRubroActionPerformed

    private void fieldRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRubroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddRubro;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField fieldRubro;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
