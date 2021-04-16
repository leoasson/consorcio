package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;

/**
 *
 * @author leoasson
 */
public class GenerateCedulon extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    int barComplete = 0;
    
    public GenerateCedulon() 
    {
        initComponents();
        completeComboPeriod();
        configProgressBar(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        comboPeriod = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        fieldCuantia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dateChosser = new com.toedter.calendar.JDateChooser();
        buttonGenerate = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setClosable(true);
        setTitle("Generar Cedulones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newCedulon16.png"))); // NOI18N

        jLabel13.setText("Monto por Hectarea");

        comboPeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPeriodActionPerformed(evt);
            }
        });

        jLabel16.setText("Fecha de vencimiento");

        fieldCuantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCuantiaActionPerformed(evt);
            }
        });

        jLabel15.setText("Periodo");

        buttonGenerate.setText("Generar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(fieldCuantia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateChosser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(195, 195, 195)))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGenerate)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCuantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChosser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonGenerate)
                        .addComponent(buttonExit))
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void configProgressBar()
    {
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(af.getTotalPadron());       
    }
    
    private void clean()
    {
        fieldCuantia.setText("");
        comboPeriod.setSelectedItem(null);
        dateChosser.setDate(null);
        barComplete = 0;
        progress();
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

    public void progress()
    {
        progressBar.setValue(barComplete);
        barComplete = barComplete +1;
        progressBar.update(progressBar.getGraphics());    
    }
    
    private void fieldCuantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCuantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCuantiaActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        /*
        *Comprobamos que todos los campos ingresados en la vista sean validos
        */
        if(!af.isValidNumber(fieldCuantia.getText()))
        { 
            JOptionPane.showMessageDialog(null,"Ingrese un valor de hectarea correcto.", " ",JOptionPane.WARNING_MESSAGE);
            return;
        }

        double valueCuantia = af.CutDecimales_Double(Double.valueOf(fieldCuantia.getText()));
        String date = af.getDateToString(dateChosser.getDate());
        String period = comboPeriod.getSelectedItem().toString();
        
        if(period.equals("Ingresar periodo"))
        {
            JOptionPane.showMessageDialog(null,"Ingrese un período de facturación."," ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(date.equals("empty"))
        {
            JOptionPane.showMessageDialog(null,"Ingrese una fecha correcta."," ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        /*
        * Verificamos que para el periodo seleccionado no existan cedulones con el
        * mismo periodo.
        */
        if(af.existPeriod(period))
        {
            JOptionPane.showMessageDialog(null,"Ya se han generado los cedulones del período "+ period +"."," ",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        /*
        * Recorremos todos los filas del campo padron generando un cedulon para cada fila.
        * asociando cada cedulon creado con el correspondiente padron.
        */
        if (JOptionPane.showConfirmDialog(null, "Está seguro que desea generar los cedulones del período "+ period +" a un valor de $ "+ valueCuantia +" por hectarea?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        {
            Object [][] padron = af.getPadron();
            String codPadron, state = "PENDIENTE",recargo = "0";
            double cuantia, total;

            for (Object[] padron1 : padron) 
            {
                codPadron = padron1[0].toString();
                cuantia = af.CutDecimales_Double(Double.valueOf(padron1[3].toString()));
                total = af.CutDecimales_Double(cuantia * valueCuantia);
                progress();               
                
                if(!af.insertCedulon(codPadron, String.valueOf(valueCuantia), String.valueOf(total), date, period, recargo, state))
                {
                    JOptionPane.showMessageDialog(null,"Se ha producido un error al momento de generar los cedulones.");
                }           
            }   
            JOptionPane.showMessageDialog(null,"Se generaron "+ padron.length +" cedulones correspondiente al período "+ period +".");
            clean();
        }               
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void comboPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPeriodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPeriodActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JComboBox<String> comboPeriod;
    private com.toedter.calendar.JDateChooser dateChosser;
    private javax.swing.JTextField fieldCuantia;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
