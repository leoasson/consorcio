package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leoasson
 */
public class ModifyCedulon extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql sen = new sentencesSql();
    main main;
    boolean isValid = false;
    String id_cedulon, valueCuantia, cod_padron, value, period, surcharge, state, date, total;
    
    public ModifyCedulon(main main) 
    {
        this.main = main;
        initComponents();
        completeComboPeriod();
        completeComboState();
        fieldState.setEnabled(false);

    }
    
    public void setFields(String idCed)
    {
        fieldCedulon.setText(idCed);
        getValues();
        setValues();
    }
    
    
    private void completeComboPeriod()
    {
        String [] periods = af.getPeriod();
        fieldPeriod.removeAllItems();
        for (String period1 : periods) 
        {
            fieldPeriod.addItem(period1);
        }
    }
    
    private void completeComboState()
    {
        String [] states = af.getState();
        fieldState.removeAllItems();
        for (String state1 : states) 
        {
            fieldState.addItem(state1);
        }
    }
    
    
    public boolean VerifyDouble()
    {
        double temp;
        try
        {
            temp = Double.valueOf(fieldSurcharge.getText());
        }
        catch(NumberFormatException e)
        {
        return false;
        }
        
        return temp > -1 && temp<500;
    
    }
    
    @SuppressWarnings("empty-statement")
    private void clean()
    {
        fieldDate.setDate(null);
        fieldPeriod.setSelectedItem("Ingresar periodo");
        fieldIdPadron.setText("");
        fieldValue.setText("");;
        fieldSurcharge.setText("");
        fieldCedulon.setText("");
        fieldTotal.setText("");
        fieldState.setSelectedItem("PENDIENTE");
        fieldCedulon.setEnabled(true);
        fieldIdPadron.setEnabled(true);
        isValid = false; 
    }
    
    private void getValues()
    {
        id_cedulon = fieldCedulon.getText();
        valueCuantia =  sen.datos_string("montoPorCuantia", "select montoPorCuantia from cedulon where id_cedulon='"+id_cedulon+"';");
        cod_padron = sen.datos_string("cod_padron", "select cod_padron from cedulon where id_cedulon='"+id_cedulon+"';");
        period =  sen.datos_string("periodo", "select periodo from cedulon where id_cedulon='"+fieldCedulon.getText()+"';");
        date = sen.datos_string("fechaVencimiento", "select fechaVencimiento from cedulon where id_cedulon='"+id_cedulon+"';");
        total = sen.datos_string("total", "select total from cedulon where id_cedulon='"+id_cedulon+"';");
        surcharge = sen.datos_string("recargo", "select recargo from cedulon where id_cedulon='"+id_cedulon+"';");
        state = sen.datos_string("estado", "select estado from cedulon where id_cedulon='"+id_cedulon+"';");
    }
    
    private void setValues()
    {
        try
        {
            fieldDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
            fieldPeriod.setSelectedItem(period);
            fieldState.setSelectedItem(state);
            fieldIdPadron.setText(cod_padron);
            fieldValue.setText(valueCuantia);
            fieldSurcharge.setText(surcharge);
            fieldTotal.setText(total);
            fieldCedulon.setEnabled(false);
            fieldIdPadron.setEnabled(false);
            isValid = true;
        } 
        catch (ParseException ex)
        {
            Logger.getLogger(ModifyCedulon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void validateId()
    {
        if(fieldCedulon.getText().equals("") || !af.existCedulon(fieldCedulon.getText()))
        {
            JOptionPane.showMessageDialog(null,"El número de cedulón ingresado no existe.");
            return;
        }
        getValues();
        setValues();
    }
    
    public void modify()
    {
        boolean ver1,ver2,ver3,ver4,ver5,ver6;
                
                
        ver1 = af.modifyCedulon(id_cedulon, "fechaVencimiento", af.getDateToString(fieldDate.getDate()));
        ver2 = af.modifyCedulon(id_cedulon, "periodo", fieldPeriod.getSelectedItem().toString());
        ver3 = af.modifyCedulon(id_cedulon, "estado", fieldState.getSelectedItem().toString());
        ver4 = af.modifyCedulon(id_cedulon, "montoPorCuantia", af.CutDecimal_String(fieldValue.getText()));
        ver5 = af.modifyCedulon(id_cedulon, "recargo", af.CutDecimal_String(fieldSurcharge.getText()));
        ver6 = af.modifyCedulon(id_cedulon, "total", af.CutDecimal_String(fieldTotal.getText()));
        
        if(ver1 && ver2 && ver3 && ver4 && ver5 && ver6)
        {
            JOptionPane.showMessageDialog(null,"El cedulón se modificó correctamente.");
            clean();
        }
        else
        { 
            JOptionPane.showMessageDialog(null,"Se ha producido un error al momento de modificar el cedulón.", " ",JOptionPane.WARNING_MESSAGE); 
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fieldCedulon = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();
        buttonGenerate = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        labelSurcharge = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JTextField();
        buttonValidate = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldIdPadron = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldSurcharge = new javax.swing.JTextField();
        newCedulon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fieldState = new javax.swing.JComboBox<>();
        fieldPeriod = new javax.swing.JComboBox<>();

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
        setTitle("Modificar cedulón");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editCedulon16.png"))); // NOI18N

        jLabel13.setText("N° de cedulón");

        jLabel16.setText("Fecha de vencimiento");

        fieldCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCedulonActionPerformed(evt);
            }
        });

        jLabel15.setText("Período");

        buttonGenerate.setText("Modificar");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        labelSurcharge.setText("Total");

        buttonValidate.setText("Validar");
        buttonValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidateActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCedulon26.png"))); // NOI18N
        jButton6.setToolTipText("Buscar cedulón");
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

        jLabel1.setText("Monto por Hectárea");

        jLabel2.setText("N° de padrón");

        jLabel3.setText("Recargo");

        newCedulon.setText("Limpiar");
        newCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCedulonActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado");
        jLabel5.setToolTipText("El estado solo se cambia se se abona o elimina el pago del mismo");

        fieldState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldState.setToolTipText("El estado solo se cambia se se abona o elimina el pago del mismo");

        fieldPeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonGenerate)
                        .addGap(18, 18, 18)
                        .addComponent(newCedulon)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel16)
                                    .addComponent(fieldIdPadron)
                                    .addComponent(fieldCedulon)
                                    .addComponent(fieldPeriod, 0, 165, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(fieldSurcharge)
                                            .addComponent(fieldState, 0, 162, Short.MAX_VALUE)))
                                    .addComponent(fieldValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jLabel3))
                            .addComponent(labelSurcharge))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(fieldTotal))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonValidate))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(13, 13, 13)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldIdPadron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldSurcharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelSurcharge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerate)
                    .addComponent(newCedulon)
                    .addComponent(buttonExit))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        
        if(!isValid)
        {
            JOptionPane.showMessageDialog(null,"Es necesario validar el número de cedulón.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!af.isValidNumber(fieldValue.getText()) || !VerifyDouble() || !af.isValidNumber(fieldTotal.getText()))
        {
            JOptionPane.showMessageDialog(null,"Verifique los campos ingresados.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        modify();
        
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void fieldCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCedulonActionPerformed
        validateId();
        buttonExit.requestFocus();
    }//GEN-LAST:event_fieldCedulonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SearchLessee lessee = new SearchLessee();
        lessee.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        main.addSearchCedulon(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    @SuppressWarnings("empty-statement")
    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        validateId();
        buttonExit.requestFocus();
    }//GEN-LAST:event_buttonValidateActionPerformed

    private void newCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCedulonActionPerformed
        clean();
    }//GEN-LAST:event_newCedulonActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JButton buttonValidate;
    private javax.swing.JTextField fieldCedulon;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JTextField fieldIdPadron;
    private javax.swing.JComboBox<String> fieldPeriod;
    private javax.swing.JComboBox<String> fieldState;
    private javax.swing.JTextField fieldSurcharge;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JTextField fieldValue;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelSurcharge;
    private javax.swing.JButton newCedulon;
    // End of variables declaration//GEN-END:variables
}
