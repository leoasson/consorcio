package Views;

import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import javax.swing.JOptionPane;

/**
 *
 * @author leoasson
 */
public final class NewLessee extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql senSql = new sentencesSql();
    main main;


    public NewLessee(main main) {
        this.main = main;
        initComponents();
        completeComboCity();
    }

    public void completeComboCity()
    {
        Object [] city = af.combox("ciudad", "nombreCiudad");
        comboCity.removeAllItems();
        for (Object city1 : city) 
        {
            comboCity.addItem(city1.toString());
        }   
        comboCity.setSelectedItem(null);
    }
    
    public void clean()
    {
        fieldAddress.setText("");
        fieldName.setText("");
        fieldPhone.setText("");
        field_id.setText("");
        comboCity.setSelectedItem(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        field_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldAddress = new javax.swing.JTextField();
        fieldPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboCity = new javax.swing.JComboBox<>();
        buttonRegister = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Arrendatario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addUser16.png"))); // NOI18N

        jLabel1.setText("DNI:*");

        field_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_idActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre y Apellido:*");

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefono:");

        jLabel5.setText("Domicilio:");

        fieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPhoneActionPerformed(evt);
            }
        });

        jLabel6.setText("Ciudad:*");

        comboCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCityActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCity, javax.swing.GroupLayout.Alignment.LEADING, 0, 119, Short.MAX_VALUE)
                                    .addComponent(field_id, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldPhone, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(fieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(fieldAddress))
                                .addGap(8, 8, 8)))))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegister)
                    .addComponent(buttonExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNameActionPerformed

    private void fieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPhoneActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed

        if(af.existLessee(field_id.getText()))
        {
            JOptionPane.showMessageDialog(null,"El DNI ingresado ya se encuentra registrado.","",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(field_id.getText().equals("") || fieldName.getText().equals("") || comboCity.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null,"Por favor rellene los campo obligatorios.","",JOptionPane.WARNING_MESSAGE);
        }
        else if (!af.insertLesse(field_id.getText(), fieldName.getText().toUpperCase(), fieldAddress.getText().toUpperCase(), fieldPhone.getText(),af.parseCity(comboCity.getSelectedItem().toString())))
        {
            JOptionPane.showMessageDialog(null,"Error al ingresar el arrendatario.","",JOptionPane.ERROR_MESSAGE);
        } 
        else
        {   
            if(JOptionPane.showConfirmDialog(null, "El arrendatario se agrego con éxito. Desea vincularlo a algun padron?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {   
                  main.addDialogAssociateLessee(field_id.getText());
//                DialogAssociateLessee lessee = new DialogAssociateLessee(main, field_id.getText());
//                lessee.show(); 
                  clean();
            }
            else{clean();}
        }
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void field_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_idActionPerformed

    private void comboCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JComboBox<String> comboCity;
    private javax.swing.JTextField fieldAddress;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JTextField field_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
