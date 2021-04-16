package Views;

import Views.SearchCedulones.StatusColumnCellRenderer;
import consorcio.AuxiliaryFunctions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class SearchDue extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    Object[] lessee;
    Object[] name;
    int state = 0;
    AssociateLesse lessee1;
    DialogAssociateLessee lessee2;
    ModifyCensus modCensus;
    ActionListener ActListener;
    
public SearchDue() 
{
    initComponents();
    init();
    fieldProperties.setEnabled(false);
    fieldLesse.setEnabled(false);
}
      
private void init()
{
    //this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/debt16.png")));
    //this.setLocationRelativeTo(null);
    showTable();
    completeComboName();
    completeComboLessee();
    this.ActListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            filterTable();
        }
    };
    fieldProperties.addActionListener(ActListener);
    fieldLesse.addActionListener(ActListener);

}

public void completeComboName()
{
    name = af.combox("padron", "propietario");
    fieldProperties.removeAllItems();
    for (Object period1 : name) 
    {
        fieldProperties.addItem(period1.toString());
    }
    fieldProperties.setEditable(true);
    fieldProperties.setSelectedItem(null);
    AutoCompleteDecorator.decorate(fieldProperties);      
}

public void completeComboLessee()
{
    lessee = af.combox("inquilino", "nombreApellido");
    fieldLesse.removeAllItems();
    for (Object channel1 : lessee) 
    {
        fieldLesse.addItem(channel1.toString());
    }
    fieldLesse.setEditable(true);
    fieldLesse.setSelectedItem(null);
    AutoCompleteDecorator.decorate(fieldLesse);
}

//private boolean[] generateFilter()
//{
//    boolean properties = false, lessee = false;
//    if(fieldProperties.getSelectedItem() != null)
//    {
//        if(!fieldProperties.getSelectedItem().toString().equals(""))
//        properties = true;
//    }
//    if(fieldLesse.getSelectedItem()!= null )
//    {
//        if(!fieldLesse.getSelectedItem().toString().equals(""))
//        lessee = true;
//    }
//    boolean[] filter = {properties, lessee};
//    return filter;     
//}

private void filterTable()
{
    fieldTotal.setText("0");
    String Slesse, Sproperties;
    boolean properties = false, lessee = false;
    
    if(boxPropertie.isSelected() && fieldProperties.getSelectedItem() != null && !fieldProperties.getSelectedItem().toString().equals(""))
    {
        properties = true;
        Sproperties = fieldProperties.getSelectedItem().toString();
    }
    else
        Sproperties = "";
    
    if(boxLesse.isSelected()&& fieldLesse.getSelectedItem()!= null && !fieldLesse.getSelectedItem().toString().equals(""))
    {
            lessee = true;
            Slesse = fieldLesse.getSelectedItem().toString();
    }
    else
        Slesse = "";
    
    boolean[] filter = {properties, lessee};
    tableDate = af.filterDue(Sproperties, Slesse, filter);
    generateTableData(tableDate);
    calculateDue();
        
}

//private void filterTable()
//{
//    String lessee, properties;
//    boolean[] filter = generateFilter();
//    if(fieldProperties.getSelectedItem() != null && !fieldProperties.getSelectedItem().toString().equals(""))
//        properties = fieldProperties.getSelectedItem().toString();
//    else
//        properties = "";
//    if(fieldLesse.getSelectedItem()!= null && !fieldLesse.getSelectedItem().toString().equals(""))
//        lessee = fieldLesse.getSelectedItem().toString();
//    else
//        lessee = "";
//    tableDate = af.filterDue(properties, lessee, filter);
//    generateTableData(tableDate);
//    calculateDue();
//}
    
public void showTable()
    {
        tableDate = af.getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `estado` = 'PENDIENTE' order by id_cedulon");
        generateTableData(tableDate);
        calculateDue();
    }

private void calculateDue()
{
    String value;
    double total = 0;
    
    for (int i = 0; i < jTable1.getRowCount(); i++) 
        {
            value = (String) jTable1.getValueAt(i, 8);
            try
            {
                double value_d = Double.valueOf(value);
                total = af.CutDecimales_Double(total + value_d);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    fieldTotal.setText(Long.toString(Double.valueOf(total).longValue()));
}

public void generateTableData(Object [][] datostabla)
    {    
        String[] columnas = {"N° cedulon", "Canal", "Hectareas", "Propietario", "Arrendatario", "Periodo", "Vencimiento","Recargo", "Total", "Estado"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(65);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(8).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(9).setCellRenderer(new StatusColumnCellRenderer());
    }

public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
 @Override
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) 
 {  
    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

      //Get the status for the current row.
      switch (value.toString()) {
          case "PENDIENTE":
              l.setBackground(Color.RED);
              break;
          case "PAGADO":
              l.setBackground(Color.GREEN);
              break;
          default:
              l.setBackground(Color.WHITE);
              break;
      }
  return l;
}}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        fieldProperties = new javax.swing.JComboBox<>();
        fieldLesse = new javax.swing.JComboBox<>();
        fieldTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        boxPropertie = new javax.swing.JCheckBox();
        boxLesse = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Consultar deuda");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/debt16.png"))); // NOI18N

        jLabel1.setText("Consultar deuda");

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

        fieldProperties.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        fieldLesse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldLesse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldLesseActionPerformed(evt);
            }
        });

        jLabel4.setText("Total deuda");

        boxPropertie.setText("Propietario");
        boxPropertie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPropertieActionPerformed(evt);
            }
        });

        boxLesse.setText("Arrendatario");
        boxLesse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxLesseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxPropertie))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldLesse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxLesse))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonExit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boxPropertie)
                    .addComponent(boxLesse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldLesse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ButtonExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void fieldLesseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldLesseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldLesseActionPerformed

    private void boxLesseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxLesseActionPerformed
        if (boxLesse.isSelected()){
            fieldLesse.setEnabled(true);
            filterTable();}
        else{
            fieldLesse.setEnabled(false); 
            fieldLesse.setSelectedItem(null);
            filterTable();}
    }//GEN-LAST:event_boxLesseActionPerformed

    private void boxPropertieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPropertieActionPerformed
        if (boxPropertie.isSelected()){
            fieldProperties.setEnabled(true);
            filterTable();}
        else{
            fieldProperties.setEnabled(false);
            fieldProperties.setSelectedItem(null);
            filterTable();}

    }//GEN-LAST:event_boxPropertieActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxLesse;
    private javax.swing.JCheckBox boxPropertie;
    private javax.swing.JComboBox<String> fieldLesse;
    private javax.swing.JComboBox<String> fieldProperties;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
