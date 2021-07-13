package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;

/**
 *
 * @author leoasson
 */
public class PrintView extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    main main;
    
    public PrintView(main main) 
    {
        this.main=main;
        initComponents();
        comboPeriod.setEnabled(false);
        buttonPrint.setEnabled(false);
        fieldCedulon.setEnabled(false);
        completeComboPeriod();
    }

    private void completeComboPeriod()
    {
        String [] period = af.getPeriod();
        comboPeriod.removeAllItems();
        for (String period1 : period) 
        {
            comboPeriod.addItem(period1);
        }
    }
    
    public void setFields(String idCed)
    {
    try
        {
            RadioButtonNCedulon.setSelected(true);
            fieldCedulon.setText(idCed);
            validateRadioButtonCedulon();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se ha podido cargar el cedulón seleccionado."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void validateRadioButtonCedulon()
    {
          if(RadioButtonNCedulon.isSelected())
      { 
          fieldCedulon.setEnabled(true);
          RadioButtonPeriod.setSelected(false);
          comboPeriod.setEnabled(false);
          buttonPrint.setEnabled(true);
      }
        else
        {
            fieldCedulon.setEnabled(false);
            buttonPrint.setEnabled(false);
        }
    }
    
    public void validateRadioButtonPeriod()
    {
          if(RadioButtonPeriod.isSelected())
      { 
          fieldCedulon.setEnabled(false);
          RadioButtonNCedulon.setSelected(false);
          fieldCedulon.setText("");
          comboPeriod.setEnabled(true);
          buttonPrint.setEnabled(true);
      }
        else
      {
          comboPeriod.setEnabled(false);
          buttonPrint.setEnabled(false);
      }  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboPeriod = new javax.swing.JComboBox<>();
        fieldCedulon = new javax.swing.JTextField();
        buttonPrint = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        RadioButtonNCedulon = new javax.swing.JRadioButton();
        RadioButtonPeriod = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Impresion de cedulones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print16.png"))); // NOI18N

        comboPeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPeriodActionPerformed(evt);
            }
        });

        fieldCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCedulonActionPerformed(evt);
            }
        });

        buttonPrint.setText("Imprimir");
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        RadioButtonNCedulon.setText("Por número de cedulón");
        RadioButtonNCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonNCedulonActionPerformed(evt);
            }
        });

        RadioButtonPeriod.setText("Por Período");
        RadioButtonPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonPeriodActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCedulon26.png"))); // NOI18N
        jButton6.setToolTipText("Buscar Arrendatarios");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonPrint)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RadioButtonPeriod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RadioButtonNCedulon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RadioButtonNCedulon)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadioButtonPeriod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrint)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void fieldCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCedulonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCedulonActionPerformed

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
         
        if(RadioButtonPeriod.isSelected())
        {    
            String period = comboPeriod.getSelectedItem().toString();
            if(af.existPeriod(period))
            {
             PrintAllCedulones print = new PrintAllCedulones(period);  
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No se encuentran cedulones para el periodo seleccionado."," ",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(RadioButtonNCedulon.isSelected())
        {
            String number = fieldCedulon.getText();
            if(af.existCedulon(number))
            {
             PrintCedulon print = new PrintCedulon(number);  
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No existe ningún cedulón con el numero ingresado."," ",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void RadioButtonPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonPeriodActionPerformed
        validateRadioButtonPeriod();
    }//GEN-LAST:event_RadioButtonPeriodActionPerformed

    private void RadioButtonNCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonNCedulonActionPerformed
       validateRadioButtonCedulon();
    }//GEN-LAST:event_RadioButtonNCedulonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        main.addSearchCedulon(this);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void comboPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPeriodActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioButtonNCedulon;
    private javax.swing.JRadioButton RadioButtonPeriod;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JComboBox<String> comboPeriod;
    private javax.swing.JTextField fieldCedulon;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
