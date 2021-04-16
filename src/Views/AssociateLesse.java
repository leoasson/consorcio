package Views;

import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class AssociateLesse extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql senSql = new sentencesSql();
    main main;

    public AssociateLesse(main main)
    {
        this.main = main;
        initComponents();
        completeComboName();
        comboName.requestFocus();
    }

    public void completeComboName()
    {
        Object [] name = af.combox("inquilino", "nombreApellido");
        comboName.removeAllItems();
        for (Object name1 : name) 
        {
            comboName.addItem(name1.toString());
        }   
        comboName.setSelectedItem(null);
        comboName.setEditable(true);
        comboName.requestFocus();
        AutoCompleteDecorator.decorate(comboName);
        
    }
    
    public void setComboName(String DNI)
    {
        try
        {
            comboName.setSelectedItem(DNI);
            fieldPadron.requestFocus();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el arrendatario seleccionado."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void setFieldPadron(String padron)
    {
        try
        {
            fieldPadron.setText(padron);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el padrón seleccionado."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void clean()
    {
        fieldPadron.setText("");
        comboName.setSelectedItem(null);
    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldPadron = new javax.swing.JTextField();
        buttonRegister = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        comboName = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search20.png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asociar Arrendatario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/changeUser16.png"))); // NOI18N

        Nombre.setText("Arrendatario");

        jLabel3.setText("Numero de padrón:");

        fieldPadron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPadronActionPerformed(evt);
            }
        });

        buttonRegister.setText("Registrar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        comboName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCensus26.png"))); // NOI18N
        jButton4.setToolTipText("Buscar número de padrón");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchLessee26.png"))); // NOI18N
        jButton5.setToolTipText("Buscar arrendatario");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setDefaultCapable(false);
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(fieldPadron, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboName, javax.swing.GroupLayout.Alignment.LEADING, 0, 167, Short.MAX_VALUE))
                                    .addComponent(Nombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldPadron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExit)
                    .addComponent(buttonRegister))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPadronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPadronActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPadronActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        //senSql.modifiedRow("padron", "cod_inquilino" , "37855179", "id_padron = 7");
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed

        String id_padron = fieldPadron.getText();
        String DNI = af.parseLessee(comboName.getSelectedItem().toString());
        
        if(!af.existPadron(fieldPadron.getText()))
        {
            JOptionPane.showMessageDialog(null,"El número de padrón ingresado no es correcto."," ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(!af.existLessee(DNI))
        {
            JOptionPane.showMessageDialog(null,"El arrendatario ingresado no es correcto."," ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(af.modifyLesseeCensus (DNI, id_padron))
        {
            clean();
            JOptionPane.showMessageDialog(null,"El arrendatario se asoció correctamente."," ",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        main.addSearchPadron(this);
        fieldPadron.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    main.addSearchLessee(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JComboBox<String> comboName;
    private javax.swing.JTextField fieldPadron;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
