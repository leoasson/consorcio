package Views;

import consorcio.AuxiliaryFunctions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leoasson
 */
public final class SearchLessee extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    Object[] channel;
    Object[] name;
    AssociateLesse al;
    NewCensus census;
    ModifyCensus modCensus;
    ModifyLessee modLessee;
    int state=0;
    ActionListener ActListener;

            
    public SearchLessee()
    {
        initComponents();
        init();
        buttonAcept.setEnabled(false);
    }
    
    public SearchLessee(AssociateLesse al)
    {
        initComponents();
        init();
        this.al = al;
        state = 1;
    }
    public SearchLessee(NewCensus census)
    {
        initComponents();
        init();
        this.census = census;
        state = 2;
    }
    
    public SearchLessee(ModifyCensus modCensus)
    {
        initComponents();
        init();
        this.modCensus = modCensus;
        state = 3;
    }
    
    public SearchLessee(ModifyLessee modLessee)
    {
        initComponents();
        init();
        this.modLessee = modLessee;
        state = 4;
    }
    
    public void init()
    {
        showTable();
        this.ActListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                filterTable();
            }
        };
        fieldName.addActionListener(ActListener);
        fieldDNI.addActionListener(ActListener);
    }
    
public void showTable()
    {
        tableDate = af.getLessee(" LEFT join ciudad on cod_ciudad = id_ciudad order by nombreApellido");
        generateTableData(tableDate);
    }

    private boolean[] generateFilter()
    {
    boolean dni = false, nameLastName = false;
        if(!fieldDNI.getText().equals(""))
        {
            dni = true;
        }
        if(!fieldName.getText().equals(""))
        {
            nameLastName = true;
        }
        boolean[] filter = {dni, nameLastName};
        return filter;     
    }
    
    private void filterTable()
    {
        String nameLastName, dni;       
        boolean[] filter = generateFilter();
        nameLastName = fieldName.getText();
        dni= fieldDNI.getText();
        tableDate = af.filterLessee(dni, nameLastName, filter);
        generateTableData(tableDate);
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
        String[] columnas = {"DNI", "Nombre y Apellido", "Domicilio", "Teléfono", "Ciudad"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        fieldDNI = new javax.swing.JTextField();
        buttonAcept = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Buscar Arrendatario");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchLessee16.png"))); // NOI18N

        jLabel1.setText("Filtrar por:");

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

        fieldDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDNIActionPerformed(evt);
            }
        });

        buttonAcept.setText("Aceptar");
        buttonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre y apellido");

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });

        jLabel3.setText("DNI");

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
                            .addComponent(fieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonFilter)))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonFilter)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
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
                        al.setComboName(tableDate[row][1].toString());
                        af.disconect();
                        this.dispose();
                        break;
                case 2:
                        census.setComboLessee(tableDate[row][1].toString());
                        af.disconect();
                        this.dispose();
                        break;
                case 3:
                        modCensus.setComboLessee(tableDate[row][1].toString());
                        af.disconect();
                        this.dispose();
                        break;
                case 4:
                        modLessee.setIdLessee(tableDate[row][0].toString());
                        af.disconect();
                        this.dispose();
                        break;
                        
                default:
                        al.setComboName(tableDate[row][1].toString());
                        af.disconect();
                        this.dispose();
                        break;
            }

        }      
    }//GEN-LAST:event_buttonAceptActionPerformed

    private void fieldDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDNIActionPerformed

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JTextField fieldDNI;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
