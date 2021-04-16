package Views;

import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import javax.swing.JOptionPane;

/**
 *
 * @author leoas
 */
public final class ModifyLessee extends javax.swing.JInternalFrame
{

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql senSql = new sentencesSql();
    main main;
    String name, address, phone, city, id_lessee;
    boolean isValid = false;


    public ModifyLessee(main main)
    {
        this.main = main;
        initComponents();
        completeComboCity();
    }

    public void completeComboCity()
    {
        Object [] citys = af.combox("ciudad", "nombreCiudad");
        comboCity.removeAllItems();
        for (Object city1 : citys) 
        {
            comboCity.addItem(city1.toString());
        }   
        comboCity.setSelectedItem(null);
    }
    
    public void clean()
    {
        field_id.setEnabled(true);
        fieldAddress.setText("");
        fieldName.setText("");
        fieldPhone.setText("");
        field_id.setText("");
        comboCity.setSelectedItem("CORDOBA");
    }
    
        public void modify()
    {
        boolean ver1,ver2,ver3,ver4;
        ver1 = af.modifyLessee(id_lessee, "nombreApellido", fieldName.getText().toUpperCase());
        ver2 = af.modifyLessee(id_lessee, "direccion", fieldAddress.getText().toUpperCase());
        ver3 = af.modifyLessee(id_lessee, "telefono", fieldPhone.getText());
        ver4 = af.modifyLessee(id_lessee, "cod_ciudad", af.parseCity(comboCity.getSelectedItem().toString()));
        
        if(ver1 && ver2 && ver3 && ver4)
        {
            JOptionPane.showMessageDialog(null,"El arrendatario se modificó correctamente.");
            isValid = false;
            clean();
        }
        else
        { 
            JOptionPane.showMessageDialog(null,"Se ha producido un error al momento de modificar el arrendatario.", " ",JOptionPane.WARNING_MESSAGE); 
            af.modifyLessee(id_lessee, "nombreApellido", name);
            af.modifyLessee(id_lessee, "direccion", address);
            af.modifyLessee(id_lessee, "telefono", phone);
            af.modifyLessee(id_lessee, "cod_ciudad", af.parseCity(city));
        } 
    }
    
    public void setIdLessee(String idLessee)
    {
        try
        {
            field_id.setText(idLessee);
            getValues();
            setValues();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el arrendatario seleccionado."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void getValues()
    {
        id_lessee = field_id.getText();
        name =  senSql.datos_string("nombreApellido", "select nombreApellido from inquilino where id_inquilino='"+id_lessee+"';");
        address = senSql.datos_string("direccion", "select direccion from inquilino where id_inquilino='"+id_lessee+"';");
        phone =  senSql.datos_string("telefono", "select telefono from inquilino where id_inquilino='"+id_lessee+"';");
        city = senSql.datos_string("nombreCiudad", "select nombreCiudad from inquilino,ciudad where id_inquilino='"+id_lessee+"' and cod_ciudad = id_ciudad;");
    }
    
    private void setValues()
    {
        comboCity.setSelectedItem(city);
        fieldName.setText(name);
        fieldPhone.setText(phone);
        fieldAddress.setText(address);
        field_id.setEnabled(false);
        isValid = true;
    }
    
    private void validateId()
    {
            if(field_id.getText().equals("") || !af.existLessee(field_id.getText()))
        {
            JOptionPane.showMessageDialog(null,"El DNI ingresado no existe.");
            return;
        }
        getValues();
        setValues();
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
        buttonModify = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        buttonClean = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar arrendatario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editLessee16.png"))); // NOI18N

        jLabel1.setText("DNI: *");

        field_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_idActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre y Apellido: *");

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

        jLabel6.setText("Ciudad: *");

        comboCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCityActionPerformed(evt);
            }
        });

        buttonModify.setText("Modificar");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
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

        buttonClean.setText("Limpiar");
        buttonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCleanActionPerformed(evt);
            }
        });

        jButton1.setText("Validar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonModify)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonClean)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonExit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel5))
                                            .addGap(117, 117, 117))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(fieldAddress)
                                            .addGap(44, 44, 44)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldPhone)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6))
                                        .addGap(0, 1, Short.MAX_VALUE)))))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModify)
                    .addComponent(buttonExit)
                    .addComponent(buttonClean)
                    .addComponent(jButton2))
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

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed

        if(!isValid)
        {
            JOptionPane.showMessageDialog(null,"Es necesario validar el DNI.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(field_id.getText().equals("") || fieldName.getText().equals("") || comboCity.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null,"Por favor rellene los campo obligatorios.","",JOptionPane.WARNING_MESSAGE);
        }
        else
        {   
            modify();
        }
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void field_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_idActionPerformed
        validateId();
        buttonExit.requestFocus();
    }//GEN-LAST:event_field_idActionPerformed

    private void comboCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCityActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        main.addSearchLessee(this);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void buttonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCleanActionPerformed
        clean();
    }//GEN-LAST:event_buttonCleanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validateId();
        buttonExit.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(isValid)
        {
            if(af.existLesseInPadron(field_id.getText()))
            {
                JOptionPane.showMessageDialog(null,"El arrendatario que desea borrar está en uso.");
                return;
            }
            
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea borrar a "+fieldName.getText()+" como arrendatario?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                if(af.dropLessee(field_id.getText()))
                {
                    JOptionPane.showMessageDialog(null,"El arrendatario se borró correctamente.");
                    isValid =false;
                    clean();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No se pudo borrar el arrendatario seleccionado.", " ",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Es necesario validar el DNI del arrendatario.", " ",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClean;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonModify;
    private javax.swing.JComboBox<String> comboCity;
    private javax.swing.JTextField fieldAddress;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPhone;
    private javax.swing.JTextField field_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
