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
public class DivideCedulon extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql sen = new sentencesSql();
    main main;
    boolean isValid = false;
    String id_cedulon, valueCuantia, name, cod_padron, value, actualDate, period, actualSurcharge, state, oldDate, oldState;
    Double oldTotal, newTotal1, newTotal2, oldSurcharge ;
    
    public DivideCedulon(main main) 
    {
        this.main = main;
        initComponents();
        fieldCedulon.setEnabled(true);
        fieldPeriod.setEnabled(false);
        fieldName.setEnabled(false);
        valuePerHectare.setEnabled(false);
        fieldValue.setEnabled(false);
    }
    
    public void setFields(String idCed)
    {
        fieldCedulon.setText(idCed);
        getValues();
        setValues();
    }
    
    public boolean VerifyInt()
    {
        int temp;
        try
        {
            temp = Integer.valueOf(fieldDivide.getText());
        }
        catch(NumberFormatException e)
        {
        return false;
        }
        
        return temp>0 && temp<100;
    
    }
    
    @SuppressWarnings("empty-statement")
    private void clean()
    {
        dateChosser.setDate(null);
        fieldPeriod.setText("");
        fieldName.setText("");
        valuePerHectare.setText("");;
        fieldValue.setText("");
        fieldCedulon.setText("");
        fieldDivide.setText("");
        fieldCedulon.setEnabled(true);
        isValid = false; 
    }
    
    private void getValues()
    {
        id_cedulon = fieldCedulon.getText();
        valueCuantia =  sen.datos_string("montoPorCuantia", "select montoPorCuantia from cedulon where id_cedulon='"+id_cedulon+"';");
        cod_padron = sen.datos_string("cod_padron", "select cod_padron from cedulon where id_cedulon='"+id_cedulon+"';");
        period =  sen.datos_string("periodo", "select periodo from cedulon where id_cedulon='"+fieldCedulon.getText()+"';");
        name = sen.datos_string("propietario", "select propietario from cedulon,padron where cod_padron = id_padron and id_cedulon='"+id_cedulon+"';");
        oldDate = sen.datos_string("fechaVencimiento", "select fechaVencimiento from cedulon where id_cedulon='"+id_cedulon+"';");
        value = sen.datos_string("cuantia", "select cuantia from cedulon,padron where cod_padron = id_padron and id_cedulon='"+id_cedulon+"';");
        oldTotal = af.CutDecimales_Double(Double.valueOf(sen.datos_string("total", "select total from cedulon where id_cedulon='"+id_cedulon+"';")));
        oldSurcharge = af.CutDecimales_Double(Double.valueOf(sen.datos_string("recargo", "select recargo from cedulon where id_cedulon='"+id_cedulon+"';")));
        oldState = sen.datos_string("estado", "select estado from cedulon where id_cedulon='"+id_cedulon+"';");
    }
    
    private void setValues()
    {
        try
        {
            dateChosser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(oldDate));
            fieldPeriod.setText(period);
            fieldName.setText(name);
            valuePerHectare.setText(valueCuantia);;
            fieldValue.setText(value);
            fieldCedulon.setEnabled(false);
            isValid = true;
        } 
        catch (ParseException ex)
        {
            Logger.getLogger(DivideCedulon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generate()
    {
        actualSurcharge =fieldDivide.getText();
        actualDate = af.getDateToString(dateChosser.getDate());
        state = "PENDIENTE";
       
        try
        {
            newTotal1 = af.CutDecimales_Double((oldTotal * Double.valueOf(actualSurcharge))/100);
            newTotal2 = af.CutDecimales_Double(oldTotal - newTotal1);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Hubo un error al momento de calcular el total del cedulón"," ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(actualDate.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Ingrese una fecha correcta"," ",JOptionPane.WARNING_MESSAGE);
            return;
        }   
        
        if(!af.deleteCedulon(id_cedulon))
        {
            JOptionPane.showMessageDialog(null,"Se ha producido un error al momento de borrar el cedulón.");
        }
        else
        {
            if(!af.insertCedulon(cod_padron, valueCuantia, String.valueOf(newTotal1), actualDate, period, String.valueOf(oldSurcharge), state) || !af.insertCedulon(cod_padron, valueCuantia, String.valueOf(newTotal2), actualDate, period, String.valueOf(oldSurcharge), state))
            {
                JOptionPane.showMessageDialog(null,"Se ha producido un error al momento de cargar el cedulón.");
                af.insertCedulonWithId(id_cedulon, cod_padron, valueCuantia, String.valueOf(oldTotal), oldDate, period, String.valueOf(oldSurcharge), state);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Se ha eliminado el cedulón N° "+ id_cedulon +" y se han creados dos nuevos cedulones");
                clean();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fieldCedulon = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dateChosser = new com.toedter.calendar.JDateChooser();
        buttonGenerate = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        labelSurcharge = new javax.swing.JLabel();
        fieldDivide = new javax.swing.JTextField();
        buttonValidate = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        fieldPeriod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        valuePerHectare = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldValue = new javax.swing.JTextField();
        newCedulon = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Particionar cedulón");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/divide16.png"))); // NOI18N

        jLabel13.setText("N° de cedulón");

        jLabel16.setText("Fecha de vencimiento");

        fieldCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCedulonActionPerformed(evt);
            }
        });

        jLabel15.setText("Período");

        buttonGenerate.setText("Dividir");
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

        labelSurcharge.setText("Porcentaje de división");

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

        jLabel2.setText("Nombre del campo");

        jLabel3.setText("Cantidad de hectáreas");

        newCedulon.setText("Limpiar");
        newCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCedulonActionPerformed(evt);
            }
        });

        jLabel4.setText("%");

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
                                    .addComponent(fieldCedulon, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel16)
                                    .addComponent(fieldName)
                                    .addComponent(fieldValue))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(valuePerHectare, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(buttonValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(fieldDivide)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addGap(3, 3, 3))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelSurcharge)
                                            .addComponent(fieldPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChosser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonValidate))
                        .addGap(18, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valuePerHectare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(10, 10, 10)
                        .addComponent(dateChosser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelSurcharge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldDivide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerate)
                    .addComponent(buttonExit)
                    .addComponent(newCedulon))
                .addGap(22, 22, 22))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        
        if(!isValid)
        {
            JOptionPane.showMessageDialog(null,"Es necesario validar el número de cedulón.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!af.isValidNumber(fieldDivide.getText()))
        {
            JOptionPane.showMessageDialog(null,"Asegurese que el porcentaje este entre 0-100%.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(oldState.equals("PAGADO"))
        {
            JOptionPane.showMessageDialog(null,"El cedulón ya se encuentra pago. No se pudo dividir.", " ",JOptionPane.WARNING_MESSAGE);
            newCedulon.requestFocus();
            return;
        }
        generate();
        
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void fieldCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCedulonActionPerformed

    }//GEN-LAST:event_fieldCedulonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        main.addSearchCedulon(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    @SuppressWarnings("empty-statement")
    private void buttonValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidateActionPerformed
        if(fieldCedulon.getText().equals("") || !af.existCedulon(fieldCedulon.getText()))
        {
            JOptionPane.showMessageDialog(null,"El número de cedulón ingresado no existe.");
            return;
        }
        getValues();
        setValues();
        
    }//GEN-LAST:event_buttonValidateActionPerformed

    private void newCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCedulonActionPerformed
        clean();
    }//GEN-LAST:event_newCedulonActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JButton buttonValidate;
    private com.toedter.calendar.JDateChooser dateChosser;
    private javax.swing.JTextField fieldCedulon;
    private javax.swing.JTextField fieldDivide;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPeriod;
    private javax.swing.JTextField fieldValue;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelSurcharge;
    private javax.swing.JButton newCedulon;
    private javax.swing.JTextField valuePerHectare;
    // End of variables declaration//GEN-END:variables
}
