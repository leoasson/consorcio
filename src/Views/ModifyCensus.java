package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class ModifyCensus extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql sen = new sentencesSql();
    main main;
    boolean isValid = false;
    String id_census,id_lessee, user, channel, owner, value, nameLessee;
    
    public ModifyCensus(main main) 
    {
        this.main=main;
        initComponents();
        completeComboName();
        clean();
    }
    
    @SuppressWarnings("empty-statement")
    private void clean()
    {
        fieldPadron.setEnabled(true);
        comboLessee.setSelectedItem(null);
        fieldOwner.setText("");
        fieldUser.setText("");
        fieldChannel.setText("");;
        fieldValue.setText("");
        fieldPadron.setText("");
        isValid = false;
        
    }
          
    public void modify()
    {
        boolean ver1,ver2,ver3,ver4,ver5;
        
        ver1 = af.modifyCensus(id_census, "usuario", user);
        ver2 = af.modifyCensus(id_census, "canal", channel);
        ver3 = af.modifyCensus(id_census, "cuantia", value);
        ver4 = af.modifyCensus(id_census, "propietario", owner);
        ver5 = af.modifyCensus(id_census, "cod_inquilino", id_lessee );
        
        if(ver1 && ver2 && ver3 && ver4 && ver5)
        {
            JOptionPane.showMessageDialog(null,"El padrón se modificó correctamente.");
            clean();
        }
        else
        { 
            JOptionPane.showMessageDialog(null,"Se ha producido un error al momento de modificar el cedulón.", " ",JOptionPane.WARNING_MESSAGE); 
        } 
    }
    public void completeComboName()
    {
        Object [] name = af.combox("inquilino", "nombreApellido");
        comboLessee.removeAllItems();
        for (Object name1 : name) 
        {
            comboLessee.addItem(name1.toString());
        }   
        comboLessee.setSelectedItem(null);
        comboLessee.setEditable(true);
        comboLessee.requestFocus();
        AutoCompleteDecorator.decorate(comboLessee);
        
    }
    
    public void setFieldPadron(String padron)
    {
        try
        {
            fieldPadron.setText(padron);
            getValues();
            setValues();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el padrón seleccionado."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void setComboLessee(String name)
    {
        try
        {
            comboLessee.setSelectedItem(name);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el arrendatario seleccionado."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
    
     private void getValues()
    {
        id_census = fieldPadron.getText();
        user =  sen.datos_string("usuario", "select usuario from padron where id_padron='"+id_census+"';");
        channel = sen.datos_string("canal", "select canal from padron where id_padron='"+id_census+"';");
        value =  sen.datos_string("cuantia", "select cuantia from padron where id_padron='"+id_census+"';");
        owner = sen.datos_string("propietario", "select propietario from padron where id_padron='"+id_census+"';");
        nameLessee = sen.datos_string("nombreApellido", "select nombreApellido from padron,inquilino where id_padron='"+id_census+"' and cod_inquilino = id_inquilino;");
    }
    
    private void setValues()
    {
        comboLessee.setSelectedItem(nameLessee);
        fieldOwner.setText(owner);
        fieldUser.setText(user);
        fieldChannel.setText(channel);
        fieldValue.setText(value);
        fieldPadron.setEnabled(false);
        isValid = true;
    }
    
    private void validateId()
    {
        if(fieldPadron.getText().equals("") || !af.existPadron(fieldPadron.getText()))
        {
            JOptionPane.showMessageDialog(null,"El número de padrón ingresado no existe.");
            return;
        }
        getValues();
        setValues();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        buttoModify = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        fieldOwner = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fieldChannel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldValue = new javax.swing.JTextField();
        buttonClean = new javax.swing.JButton();
        comboLessee = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        fieldPadron = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        buttonValidate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search20.png"))); // NOI18N
        jButton5.setToolTipText("Buscar Arrendatarios");
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

        jTextField2.setText("jTextField2");

        setClosable(true);
        setTitle("Modificar  padrón");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editCensus16.png"))); // NOI18N

        jLabel16.setText("Arrendatario");

        jLabel15.setText("Propietario*");

        buttoModify.setText("Modificar");
        buttoModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoModifyActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Canal*");

        jLabel2.setText("Usuario*");

        jLabel3.setText("Hectarias*");

        buttonClean.setText("Limpiar");
        buttonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanActionPerformed(evt);
            }
        });

        comboLessee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboLessee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLesseeActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchLessee26.png"))); // NOI18N
        jButton6.setToolTipText("Buscar Arrendatario");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setDefaultCapable(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        fieldPadron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPadronActionPerformed(evt);
            }
        });

        jLabel4.setText("N° de padrón*");

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

        buttonValidate.setText("Validar");
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldValue)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(comboLessee, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(75, 75, 75)))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(102, 102, 102))
                        .addComponent(fieldPadron))
                    .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldChannel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(buttoModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(buttonClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonValidate)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldPadron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLessee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttoModify)
                    .addComponent(buttonExit)
                    .addComponent(buttonClean)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        getAccessibleContext().setAccessibleName("Modificar padrón");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttoModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoModifyActionPerformed
        if(!isValid)
        {
            JOptionPane.showMessageDialog(null,"Es necesario validar el número de cedulón.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }
            
        if(comboLessee.getSelectedItem() == null)
        {
            id_lessee = null;
        }
        else if (af.existLesseeForName(comboLessee.getSelectedItem().toString()))
        {
            id_lessee= af.parseLessee(comboLessee.getSelectedItem().toString());
        }
        else
        {
            id_lessee = null;
        }
        owner = fieldOwner.getText().toUpperCase();
        user = fieldUser.getText();
        value = fieldValue.getText();
        channel = fieldChannel.getText();

        if(!owner.equals("") && af.isValidNumber(value) && af.isValidNumber(channel))
        {
                modify();
                clean();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Verifique los campo ingresados.");
        }
        
    }//GEN-LAST:event_buttoModifyActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SearchLessee lessee = new SearchLessee();
        lessee.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
        clean();
    }//GEN-LAST:event_buttonCleanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        main.addSearchLessee(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void comboLesseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLesseeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLesseeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        main.addSearchPadron(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        validateId();
        buttonExit.requestFocus();
    }//GEN-LAST:event_buttonValidateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(isValid)
        {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar el padrón n° "+fieldPadron.getText()+"?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                if(af.dropCensus(fieldPadron.getText()))
                {
                    JOptionPane.showMessageDialog(null,"El padrón se borró correctamente.");
                    isValid =false;
                    clean();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No se pudo borrar el padrón seleccionado.", " ",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Es necesario validar el número de padrón.", " ",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fieldPadronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPadronActionPerformed
        validateId();
        buttonExit.requestFocus();
    }//GEN-LAST:event_fieldPadronActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoModify;
    private javax.swing.JButton buttonClean;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonValidate;
    private javax.swing.JComboBox<String> comboLessee;
    private javax.swing.JTextField fieldChannel;
    private javax.swing.JTextField fieldOwner;
    private javax.swing.JTextField fieldPadron;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JTextField fieldValue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
