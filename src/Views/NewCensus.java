package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class NewCensus extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    sentencesSql sen = new sentencesSql();
    main main;
    boolean isValid = false;
    
    public NewCensus(main main) 
    {
        this.main = main;
        initComponents();
        completeComboName();
        clean();
    }
    
    
    @SuppressWarnings("empty-statement")
    private void clean()
    {
        comboLessee.setSelectedItem(null);
        fieldName.setText("");
        fieldUser.setText("");
        fieldChannel.setText("");;
        fieldValue.setText("");
    }
       
    public void insert()
    {
    String id_lessee, owner, user, value,channel;  
    
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
    owner = fieldName.getText().toUpperCase();
    user = fieldUser.getText();
    value = fieldValue.getText();
    channel = fieldChannel.getText();
    
        if(!owner.equals("") && af.isValidNumber(value) && af.isValidNumber(channel))
        {
            if(!af.insertCensus(user, channel, value, owner, id_lessee))
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error al momento de agregar el padrón."," ",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"El padrón se agrego correctamente");
                clean();
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Verifique los campo ingresados.");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        buttonInsert = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        fieldName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fieldChannel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldValue = new javax.swing.JTextField();
        buttonClean = new javax.swing.JButton();
        comboLessee = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();

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
        setTitle("Registar nuevo padrón");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addFile16 .png"))); // NOI18N

        jLabel16.setText("Arrendatario");

        jLabel15.setText("Propietario*");

        buttonInsert.setText("Ingresar");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonInsert)
                        .addGap(18, 18, 18)
                        .addComponent(buttonClean)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboLessee, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(fieldValue, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldChannel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboLessee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert)
                    .addComponent(buttonExit)
                    .addComponent(buttonClean))
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
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
    insert();
        
    }//GEN-LAST:event_buttonInsertActionPerformed

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
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClean;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JComboBox<String> comboLessee;
    private javax.swing.JTextField fieldChannel;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JTextField fieldValue;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
