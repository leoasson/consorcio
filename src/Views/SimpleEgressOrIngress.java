package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leoasson
 */
public final class SimpleEgressOrIngress extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    SearchIngress temporalSearchIngress;
    SearchEgress temporalSearchEgress;
    main main;
    String [] operation = new String [3];
    double totalPayment, finalTotalPayment = 0;
    String cod_egressOrIngress;
    String id_ingressOrEgress;//se asigna el id del ingreso/egreso en caso de modificacion
    String concept;//se asigna el concepto del ingreso/egreso en caso de modificacion
    String rubro;//se asigna el rubro del ingreso/egreso en caso de modificacion
    int type; //si es 1 es un ingreso si es 2 es un egreso.
    Object [][] payments;
    ArrayList<String> arrayIdsOps = new ArrayList<>();
    DefaultTableModel modelPayment;
    //boolean isRowClicked = false;
    int rowClicked;
    boolean isModified;
    
public SimpleEgressOrIngress(main main, int type) 
{
    this.main = main;
    this.type = type;
    isModified = false;
    initComponents();
    init();
    if(type==1){this.setTitle("Registrar ingreso simple");}
    else{this.setTitle("Registrar egreso simple");}   
}

public SimpleEgressOrIngress(main main, String id, SearchIngress temporalSearchIngress) 
{
    this.main = main;
    type = 1;
    this.id_ingressOrEgress = id;
    this.temporalSearchIngress = temporalSearchIngress;
    initComponents();
    init();
    isModified = true;
    this.setTitle("Modificar ingreso simple");
    payments = af.getPaymentForModifyIngressOrEgress("LEFT JOIN `modalidad` ON `id_modalidad` = `cod_modalidad` LEFT JOIN `ingmod` ON `id_operacion` = `cod_operacion` WHERE `cod_ingreso`= '"+id_ingressOrEgress+"'");
    DateOfPay.setDate(af.getDateFromIngressOrEgress(id_ingressOrEgress, "pruebaingreso", "id_ingreso"));
    concept= af.getConceptForIngressOrEgress(id_ingressOrEgress, "pruebaingreso", "id_ingreso");
    rubro = af.getRubroForIngressOrEgress(id_ingressOrEgress, "pruebaingreso", "id_ingreso");
    fieldConcept.setText(concept);
    comboRubro.setSelectedItem(rubro);
    completeTablePaymentForModified();

}

public SimpleEgressOrIngress(main main, String id, SearchEgress temporalSearchEgress) 
{
    this.main = main;
    type = 2;
    id_ingressOrEgress = id;
    this.temporalSearchEgress = temporalSearchEgress;
    initComponents();
    init();
    isModified = true;
    this.setTitle("Modificar egreso simple");
    payments = af.getPaymentForModifyIngressOrEgress("LEFT JOIN `modalidad` ON `id_modalidad` = `cod_modalidad` LEFT JOIN `egrmod` ON `id_operacion` = `cod_operacion` WHERE `cod_egreso`= '"+id_ingressOrEgress+"'");
    DateOfPay.setDate(af.getDateFromIngressOrEgress(id_ingressOrEgress, "pruebaegreso", "id_egreso"));
    concept= af.getConceptForIngressOrEgress(id_ingressOrEgress, "pruebaegreso", "id_egreso");
    rubro = af.getRubroForIngressOrEgress(id_ingressOrEgress, "pruebaegreso", "id_egreso");
    fieldConcept.setText(concept);
    comboRubro.setSelectedItem(rubro);
    completeTablePaymentForModified();
}
    
private void init()
{
    fieldTotalPayment.setEditable(false);
    DateOfPay.setDate(af.getActualDate());
    modelPayment = (DefaultTableModel) tablePayment.getModel();
    completeComboRubro();
    tablePayment.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    JTable table =(JTable) mouseEvent.getSource();
    Point point = mouseEvent.getPoint();
    rowClicked = table.rowAtPoint(point);
    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
    {
        operation [0] = (String) modelPayment.getValueAt(rowClicked, 1);
        operation [1] = (String) modelPayment.getValueAt(rowClicked, 2);
        operation [2] = (String) modelPayment.getValueAt(rowClicked, 3);
        CallViewForModifyPayments();
        //isRowClicked = true;
    }
}
});
    if (type == 1)
    {
    this.setTitle("Registrar ingreso");
    comboRubro.setEnabled(false);
    }
}

public void completeComboRubro()
    {
        Object [] rubros = af.combox("rubro", "rubro");
        comboRubro.removeAllItems();
        for (Object rubro : rubros) 
        {
            comboRubro.addItem(rubro.toString());
        }   
        comboRubro.setSelectedItem(null);
    }

public void insertNewPaymentInView(String type, String total, String detail)
{
    finalTotalPayment = finalTotalPayment + Double.valueOf(total);
    modelPayment.addRow(new Object[]{"", type, detail, total});
    tablePayment.repaint();
    fieldTotalPayment.setText(String.valueOf(af.CutDecimales_Double(finalTotalPayment)));
    clean();   
}

public void modifiedPaymentInView(String operation[])
{
    String oldTotal = (String) modelPayment.getValueAt(rowClicked, 3);
    finalTotalPayment = finalTotalPayment - af.CutDecimales_Double(Double.valueOf(oldTotal));

    tablePayment.setValueAt(operation[0], rowClicked,1);
    tablePayment.setValueAt(operation[1], rowClicked,2);
    tablePayment.setValueAt(operation[2], rowClicked,3);

    String newTotal = (String) modelPayment.getValueAt(rowClicked, 3);
    finalTotalPayment = finalTotalPayment + af.CutDecimales_Double(Double.valueOf(newTotal));
    fieldTotalPayment.setText(String.valueOf(af.CutDecimales_Double(finalTotalPayment)));
}

private void completeTablePaymentForModified()
{
    for (Object[] payments_ : payments)
    {
        insertNewPaymentInView((String) payments_[1],(String) payments_[3],(String) payments_[2]);
    }
}

private void CallViewForModifyPayments()
{
    main.addNewPayment(this, operation);
}

private void clean()
{
    rowClicked = -1;
    //isRowClicked = false; 
}

private void VerifyExitAndClean()
{
    if(tablePayment.getRowCount()>0)
    {
        if (JOptionPane.showConfirmDialog(null, "Hay valores sin registrar, esta seguro que desea salir?", "Atención",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        {
            af.disconect();
            this.dispose();
        }
    }
    else
    {
        af.disconect();
        this.dispose();
    }   
}    

public void removeSelectedRowsOfPayment()
{
    int[] rows = tablePayment.getSelectedRows();

    for(int i=0;i<rows.length;i++)
    {            
        finalTotalPayment = finalTotalPayment - Double.valueOf((String)modelPayment.getValueAt(rows[i]-i, 3));
        modelPayment.removeRow(rows[i]-i);
    }
fieldTotalPayment.setText(String.valueOf(finalTotalPayment));
}  

private boolean registerEgressInBD() 
{
    if(isModified)
    {
        if(af.temporalInsertEgress(id_ingressOrEgress, af.getDateToString(DateOfPay.getDate()), fieldConcept.getText(), af.parseRubro(comboRubro.getSelectedItem().toString())))
        {
            cod_egressOrIngress = id_ingressOrEgress;
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Se produjo un error al cargar el egreso.", "Atención",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    else
    {
        int id_ = af.temporalInsertEgress(af.getDateToString(DateOfPay.getDate()), fieldConcept.getText(), af.parseRubro(comboRubro.getSelectedItem().toString()));
        if(id_<0)
        {
            JOptionPane.showMessageDialog(null,"Se produjo un error al cargar el egreso.", "Atención",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            cod_egressOrIngress = String.valueOf(id_);
            return true;  
        }
    }
}

private boolean registerIngressInBD() 
{
    if(isModified)
    {
        if(af.temporalInsertIngress(id_ingressOrEgress, af.getDateToString(DateOfPay.getDate()), fieldConcept.getText()))
        {
            cod_egressOrIngress = id_ingressOrEgress;
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Se produjo un error al cargar el ingreso.", "Atención",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    else
    {
        int id_ = af.temporalInsertIngress(af.getDateToString(DateOfPay.getDate()), fieldConcept.getText());
        if(id_<0)
        {
            JOptionPane.showMessageDialog(null,"Se produjo un error al cargar el ingreso.", "Atención",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            cod_egressOrIngress = String.valueOf(id_);
            return true;  
        }
    }  
}

private void registerOperationsInBD() 
{
    for (int i = 0; i < tablePayment.getRowCount(); i++)
    {
        String cod_operation = String.valueOf(af.inserPayment1(af.parcePayment((String) tablePayment.getValueAt(i, 1)), (String) tablePayment.getValueAt(i, 2),(String) tablePayment.getValueAt(i, 3)));
        switch(type)
        {
            case 1:
                //Asocio el ingreso con las operaciones
                af.insertIngMod(cod_egressOrIngress, cod_operation);
                break;
            case 2:
                //Asocio el egreso con las operaciones
                af.insertEgrMod(cod_egressOrIngress, cod_operation);
                break;
        }   
    }
}
    
private void registerIngress()
{
    if(registerIngressInBD())
    {
        registerOperationsInBD();//Registro los tipos de pago en la tabla operaciones
        JOptionPane.showMessageDialog(null,"El ingreso se guardo correctamente", "",JOptionPane.INFORMATION_MESSAGE);
        if(isModified){temporalSearchIngress.filterTable();}
        af.disconect();
        this.dispose();
        
    }     
}

private void registerEgress()
{
    if(registerEgressInBD())
    {
        registerOperationsInBD();//Registro los tipos de pago en la tabla operaciones
        JOptionPane.showMessageDialog(null,"El egreso se guardo correctamente", "",JOptionPane.INFORMATION_MESSAGE);
        if(isModified){temporalSearchEgress.filterTable();}
        af.disconect();
        this.dispose();
    } 
}
    
private void unlinkIngressOrEgressAndOperation()
{
    //borro las operaciones
    for (Object[] payments_ : payments)
    {
        af.deleteTemporalOperation((String)payments_[0]);
    }
    
    //es un ingreso entonces Desvinculo las asociaciones de operaciones e ingreso
    if(type == 1)
    {
        for (Object[] payments_ : payments)
        {
            af.deleteIngModTrhowsCodOperation((String)payments_[0]);
        }   
        //borro el ingreso
        af.deleteTemporalIngress(id_ingressOrEgress);
    }
    else //es un egreso entonces Desvinculo las asociaciones de operaciones y egreso
    {
        for (Object[] payments_ : payments)
        {
            af.deleteEgrModTrhowsCodOperation((String)payments_[0]);
        }
        //borro el egreso
        af.deleteTemporalEgress(id_ingressOrEgress);
    }
    

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DateOfPay = new com.toedter.calendar.JDateChooser();
        buttonRegister = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        fieldTotalPayment = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        labelConcepto = new javax.swing.JLabel();
        labelDateOfPayment = new javax.swing.JLabel();
        labelPayments = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePayment = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldConcept = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        comboRubro = new javax.swing.JComboBox<>();
        labelRubro = new javax.swing.JLabel();
        buttonRemovePayment = new javax.swing.JButton();
        buttonAddPayment1 = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();

        setResizable(true);
        setTitle("Registrar egreso");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outMoney16.png"))); // NOI18N

        buttonRegister.setText("Guardar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        fieldTotalPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalPaymentActionPerformed(evt);
            }
        });

        labelTotal.setText("Total pagos");

        labelConcepto.setText("Concepto");

        labelDateOfPayment.setText("Fecha de pago");

        labelPayments.setText("Pagos");

        tablePayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° ingreso", "Tipo", "Observaciones", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePayment);
        if (tablePayment.getColumnModel().getColumnCount() > 0) {
            tablePayment.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablePayment.getColumnModel().getColumn(0).setMaxWidth(90);
            tablePayment.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablePayment.getColumnModel().getColumn(1).setMaxWidth(150);
            tablePayment.getColumnModel().getColumn(2).setPreferredWidth(400);
            tablePayment.getColumnModel().getColumn(2).setMaxWidth(600);
            tablePayment.getColumnModel().getColumn(3).setPreferredWidth(80);
            tablePayment.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        fieldConcept.setColumns(20);
        fieldConcept.setRows(5);
        jScrollPane1.setViewportView(fieldConcept);

        comboRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelRubro.setText("Rubro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buttonRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonExit))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPayments)
                            .addComponent(labelConcepto)
                            .addComponent(DateOfPay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDateOfPayment))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelRubro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator4)
                            .addComponent(comboRubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelDateOfPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateOfPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConcepto)
                    .addComponent(labelRubro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelPayments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(fieldTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegister)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        buttonRemovePayment.setText("Borrar");
        buttonRemovePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemovePaymentActionPerformed(evt);
            }
        });

        buttonAddPayment1.setText("Añadir");
        buttonAddPayment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddPayment1ActionPerformed(evt);
            }
        });

        buttonEdit.setText("Editar");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonRemovePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(buttonAddPayment1))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAddPayment1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRemovePayment)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldTotalPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTotalPaymentActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        if(isModified){af.disconect();this.dispose();return;}
        VerifyExitAndClean();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        if(fieldConcept.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Ingrese un concepto.", "Faltan datos",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(tablePayment.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de pago.", "Faltan datos",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(type == 2 && comboRubro.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null,"Seleccione el rubro.", "Faltan datos",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Registro el egreso o el ingreso de acuerdo a que corresponda
        switch(type)
        {
            case 1:
                if(isModified)
                {
                    unlinkIngressOrEgressAndOperation();
                    registerIngress();
                }
                else
                {
                    registerIngress();
                }
                break;
                
            case 2:
                if(isModified)
                {
                    unlinkIngressOrEgressAndOperation();
                    registerEgress();
                }
                else
                {
                    registerEgress();
                }
                break;
        }
    }//GEN-LAST:event_buttonRegisterActionPerformed
 
    private void buttonRemovePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemovePaymentActionPerformed
        if(tablePayment.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
        else
            removeSelectedRowsOfPayment();
    }//GEN-LAST:event_buttonRemovePaymentActionPerformed

    private void buttonAddPayment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddPayment1ActionPerformed
        //cuando es un ingreso nuevo solo le paso this
        main.addNewPayment(this);
    }//GEN-LAST:event_buttonAddPayment1ActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        if(tablePayment.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
        else
        {
            operation [0] = (String) modelPayment.getValueAt(rowClicked, 1);
            operation [1] = (String) modelPayment.getValueAt(rowClicked, 2);
            operation [2] = (String) modelPayment.getValueAt(rowClicked, 3);
            CallViewForModifyPayments();
        }
    }//GEN-LAST:event_buttonEditActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateOfPay;
    private javax.swing.JButton buttonAddPayment1;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JButton buttonRemovePayment;
    private javax.swing.JComboBox<String> comboRubro;
    private javax.swing.JTextArea fieldConcept;
    private javax.swing.JTextField fieldTotalPayment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelConcepto;
    private javax.swing.JLabel labelDateOfPayment;
    private javax.swing.JLabel labelPayments;
    private javax.swing.JLabel labelRubro;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tablePayment;
    // End of variables declaration//GEN-END:variables


}
