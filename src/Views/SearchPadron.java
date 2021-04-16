package Views;

import consorcio.AuxiliaryFunctions;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class SearchPadron extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    Object[] channel;
    Object[] name;
    int state = 0;
    AssociateLesse lessee1;
    DialogAssociateLessee lessee2;
    ModifyCensus modCensus;
    ActionListener ActListener;
    
    public SearchPadron() {
        initComponents();
        init();
        state = 0;
        buttonAcept.setEnabled(false);
    }
    
    public SearchPadron(AssociateLesse lessee1) {
        initComponents();
        init();
        this.lessee1 = lessee1;
        buttonAcept.setEnabled(true);
        state = 1;
    }
    
    public SearchPadron(ModifyCensus modCensus)
    {
        initComponents();
        init();
        this.modCensus = modCensus;
        buttonAcept.setEnabled(true);
        state = 2;
    }
    
    public SearchPadron(DialogAssociateLessee lessee2)
    {
        initComponents();
        init();
        this.lessee2 = lessee2;
        buttonAcept.setEnabled(true);
        state = 3;
    }
    
    
    private void init()
    {
//        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/searchCensus16.png")));
//        this.setLocationRelativeTo(null);
//        comboName.setEnabled(false);
//        comboLessee.setEnabled(false);
//        completeComboLessee();
//        completeComboName();
        completeComboChannel();
        comboChannel.setEnabled(false);
        showTable();
        this.ActListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                filterTable();
            }
        };
        fieldProperties.addActionListener(ActListener);
        fieldLessee.addActionListener(ActListener);
        comboChannel.addActionListener(ActListener);
    }
    
    private boolean[] generateFilter()
    {
        boolean channel = false, properties = false, lessee = false;
        if(!fieldProperties.getText().equals(""))
        {
            
            properties = true;
        }
        if(!fieldLessee.getText().equals(""))
        {
            lessee = true;
        }
        if(boxChannel.isSelected() == true)
        {
            channel = true;
        }
        boolean[] filter = {channel, properties, lessee};
        return filter;     
    }
    
    private void filterTable()
    {
        String channel, lessee, properties;
        
        boolean[] filter = generateFilter();
        //boolean[] filter = {boxPeriod.isSelected(), boxLessee.isSelected(), boxName.isSelected()};
        //lessee = comboLessee.getSelectedItem().toString();
        //properties = comboName.getSelectedItem().toString();
        
        channel = comboChannel.getSelectedItem().toString();
        properties = fieldProperties.getText();
        lessee = fieldLessee.getText();
        tableDate = af.filterPadron(channel, properties, lessee, filter);
        generateTableData(tableDate);
    }
    
    public void showTable()
    {
        tableDate = af.getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino order by id_padron");
        generateTableData(tableDate);
    }
    /*
    public void completeComboName()
    {
        name = af.combox("padron", "propietario");
        comboName.removeAllItems();
        for (Object period1 : name) 
        {
            comboName.addItem(period1.toString());
        }
        comboName.setEditable(true);
        AutoCompleteDecorator.decorate(comboName);      
    }
    
    public void completeComboLessee()
    {
        Object [] lessee = af.combox("inquilino", "nombreApellido");
        comboLessee.removeAllItems();
        for (Object lesse : lessee) 
        {
            comboLessee.addItem(lesse.toString());
        }
        comboLessee.setEditable(true);
        AutoCompleteDecorator.decorate(comboLessee);
    }
    */
    
        public void completeComboChannel()
    {
        channel = af.combox("padron", "canal");
        comboChannel.removeAllItems();
        for (Object channel1 : channel) 
        {
            comboChannel.addItem(channel1.toString());
        }
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
        String[] columnas = {"N° Padron", "Usuario", "Canal", "Hectareas", "Propietario", "Arrendatario"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        comboChannel = new javax.swing.JComboBox<>();
        buttonFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonAcept = new javax.swing.JButton();
        fieldProperties = new javax.swing.JTextField();
        fieldLessee = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxChannel = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Buscar Padrón");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCensus16.png"))); // NOI18N

        jLabel1.setText("Filtrar por:");

        comboChannel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonFilter.setText("Filtrar");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        buttonAcept.setText("Aceptar");
        buttonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptActionPerformed(evt);
            }
        });

        jLabel2.setText("Propietario");

        jLabel3.setText("Arrendatario");

        boxChannel.setText("Canal");
        boxChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxChannelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAcept)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxChannel)
                            .addComponent(comboChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(fieldProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldLessee, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonFilter))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonFilter)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(boxChannel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldLessee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(buttonAcept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        filterTable();
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0)
        {
        JOptionPane.showMessageDialog(null,"Seleccione la fila deseada."," ",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            switch(state)
            {
                case 1:
                        lessee1.setFieldPadron(tableDate[row][0].toString());
                        af.disconect();
                        this.dispose();
                        break;
                case 2:
                        modCensus.setFieldPadron(tableDate[row][0].toString());
                        af.disconect();
                        this.dispose();
                        break;
                case 3:
                        lessee2.setFieldPadron(tableDate[row][0].toString());
                        af.disconect();
                        this.dispose();
                        break;
                    
            }
        }
    }//GEN-LAST:event_buttonAceptActionPerformed

    private void boxChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxChannelActionPerformed
        if(boxChannel.isSelected() == true)
        {
            comboChannel.setEnabled(true);
            filterTable();
        }
        else
        {
            comboChannel.setEnabled(false);
            filterTable();
        }
    }//GEN-LAST:event_boxChannelActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxChannel;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JComboBox<String> comboChannel;
    private javax.swing.JTextField fieldLessee;
    private javax.swing.JTextField fieldProperties;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
