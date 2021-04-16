package Views;
import javax.swing.table.DefaultTableCellRenderer;
import consorcio.AuxiliaryFunctions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class SearchCedulones extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    //Object[] lessee;
    //Object[] name;
    GenerateCedulonWithSurcharge gc;
    Ingress ingress1;
    DivideCedulon divide;
    PrintView print;
    ModifyCedulon modifiedCedulon;
    int state = 0;
    ActionListener ActListener;
    
    public SearchCedulones()
    {
        init();
        buttonAcept.setEnabled(false);
    }
    
    public SearchCedulones(GenerateCedulonWithSurcharge gc)
    {
        init();
        this.gc = gc;
        state = 1;
    }
    
    public SearchCedulones(DivideCedulon divide)
    {
        init();
        this.divide = divide;
        state = 3;
    }

    SearchCedulones(PrintView print)
    {
        init();
        this.print = print;
        state = 4;
    }
    
    SearchCedulones(ModifyCedulon modifiedCedulon)
    {
        init();
        this.modifiedCedulon = modifiedCedulon;
        state = 5;
    }
    
    SearchCedulones(Ingress ingress1)
    {
        init();
        this.ingress1 = ingress1;
        state = 6;
    }
    
public void init ()
{
        initComponents();
        showTable();
        completeComboPeriod();
        this.ActListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                filterTable();
            }
        };
        fieldProperties.addActionListener(ActListener);
        fieldLessee.addActionListener(ActListener);
        comboPeriod.addActionListener(ActListener);
}
    
public void showTable()
    {
        tableDate = af.getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino order by id_cedulon");
        generateTableData(tableDate);
    }

    public void completeComboPeriod()
    {
        String [] period = af.getPeriod();
        comboPeriod.removeAllItems();
        for (String period1 : period) 
        {
            comboPeriod.addItem(period1);
        }
    }
    
    private boolean[] generateFilter()
    {
        boolean period = false, properties = false, lessee = false;
        if(!fieldProperties.getText().equals(""))
        {
            properties = true;
        }
        if(!fieldLessee.getText().equals(""))
        {
            lessee = true;
        }
        if(!comboPeriod.getSelectedItem().toString().equals("Ingresar periodo"))
        {
            period = true;
        }
        boolean[] filter = {period, lessee, properties};
        return filter;     
    }
    
    private void filterTable()
    {
        String period, lessee, properties;       
        boolean[] filter = generateFilter();
        period = comboPeriod.getSelectedItem().toString();
        properties = fieldProperties.getText();
        lessee = fieldLessee.getText();
        tableDate = af.filterCedulones(period, lessee, properties, filter);
        generateTableData(tableDate);
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
        String[] columnas = {"N° cedulon", "Canal", "Hectareas", "Propietario", "Arrendatario", "Periodo", "Vencimiento","Recargo", "Total", "Estado", "Ingreso"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(65);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(8).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(10).setMaxWidth(50);
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
        comboPeriod = new javax.swing.JComboBox<>();
        buttonFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonAcept = new javax.swing.JButton();
        fieldProperties = new javax.swing.JTextField();
        fieldLessee = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Buscar Cedulones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCedulon16.png"))); // NOI18N

        jLabel1.setText("Filtrar por:");

        comboPeriod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel4.setText("Período");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldLessee, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonFilter))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFilter)
                    .addComponent(fieldProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldLessee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
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
            return;
        } 
            //Hay varias filas seleccionadas 
            int[] rows = jTable1.getSelectedRows(); 
            String[] cedulones = new String[rows.length];
            int count=0;
            //System.out.println("Filas seleccionadas: "+rows.length);
            for (int indice : rows) 
            { 
                cedulones[count]=tableDate[indice][0].toString();
                count++;
                //System.out.print("Numero de cedulon: "+tableDate[indice][0].toString()+ "\n"); 
            }  
        
        
        switch(state)
        {
            case 1:
                    gc.setFields(tableDate[row][0].toString());
                    af.disconect();
                    this.dispose();
            break;
            
            case 2:
                    //pay.setFields(tableDate[row][0].toString());
                    //pay.setFieldTest(cedulones);
            break;
            
            case 3:
                    divide.setFields(tableDate[row][0].toString());
                    af.disconect();
                    this.dispose(); 
            break;
            
            case 4:
                    print.setFields(tableDate[row][0].toString());
                    af.disconect();
                    this.dispose(); 
            break;
            
            case 5:
                    modifiedCedulon.setFields(tableDate[row][0].toString());
                    af.disconect();
                    this.dispose();
            break;
            case 6:        
                    ingress1.setSelectedCedulones(cedulones);
                    af.disconect();
                    this.dispose();
            break;
            
        }
    
                
    }//GEN-LAST:event_buttonAceptActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JComboBox<String> comboPeriod;
    private javax.swing.JTextField fieldLessee;
    private javax.swing.JTextField fieldProperties;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
