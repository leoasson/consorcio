package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leoasson
 */
public final class Ingress extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    main main;
    String [] operation = new String [3];
    Object [][] cedulones;
    Object [][] payments;
    boolean isValid = false;
    sentencesSql sen = new sentencesSql();
    SearchIngress temporalSearchIngress;
    String id_cedulon, name, cod_padron, period, lessee, oldDate, mode;
    String cod_ingress;//se asigna cuando se agrega el ingreso al final de la lista.
    String id_ingress;//se asigna cuando la clase es creada con el objetivo de una modificacion
    double totalCedulon, finalTotalCedulon = 0;
    double totalPayment, finalTotalPayment = 0;
    
    DefaultTableModel modelCedulon;
    DefaultTableModel modelPayment;
    boolean isRowClicked = false;
    boolean isModified;
    int rowClicked;
    String fecha;
    
    
public Ingress(main main) 
{
    this.main = main;
    initComponents();
    fieldCedulon.setEnabled(true);
    init();
    isModified = false;
}

public Ingress(main main, String id_ingress, SearchIngress temporalSearchIngress) 
{
    this.main = main;
    this.id_ingress=id_ingress;
    this.temporalSearchIngress = temporalSearchIngress;
    initComponents();
    fieldCedulon.setEnabled(false);
    init();
    isModified = true;
    DateOfPay.setDate(af.getDateFromIngressOrEgress(id_ingress, "pruebaingreso", "id_ingreso"));
    cedulones = af.getCedulonForModifyIngress("LEFT JOIN `padron` ON `id_padron`= `cod_padron` LEFT JOIN `inquilino` ON`id_inquilino` = `cod_inquilino` WHERE `cod_ingreso` = '"+id_ingress+"'");
    payments = af.getPaymentForModifyIngressOrEgress("LEFT JOIN `modalidad` ON `id_modalidad` = `cod_modalidad` LEFT JOIN `ingmod` ON `id_operacion` = `cod_operacion` WHERE `cod_ingreso`= '"+id_ingress+"'");
    completeTableCedulonForModified();
    completeTablePaymentForModified();
    this.setTitle("Modificar cobro de cedulón");
}


@SuppressWarnings("empty-statement")   

private void init()
{
    fieldTotalPayment.setEditable(false);
    fieldTotalCedulon.setEditable(false);
    DateOfPay.setDate(af.getActualDate());
    modelCedulon = (DefaultTableModel) tableCedulon.getModel();
    modelPayment = (DefaultTableModel) tablePayment.getModel();
    tablePayment.addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    JTable table =(JTable) mouseEvent.getSource();
    Point point = mouseEvent.getPoint();
    rowClicked = table.rowAtPoint(point);
    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
    {
        System.out.println(rowClicked);
        operation [0] = (String) modelPayment.getValueAt(rowClicked, 1);
        operation [1] = (String) modelPayment.getValueAt(rowClicked, 2);
        operation [2] = (String) modelPayment.getValueAt(rowClicked, 3);
        CallViewForModifyPayments();
        isRowClicked = true;
    }
}
});
}

public void setSelectedCedulones(String [] cedulones)
{
    for (String cedulon : cedulones) 
    {
        fieldCedulon.setText(cedulon);
        if(isValidIdCedulon(fieldCedulon.getText()))
            insertRowInCedulon();   
        else
            fieldCedulon.requestFocus();
        //searchCedulones.show();
    }
    clean();
}

private void completeTableCedulonForModified()
{
        for (Object[] cedulone : cedulones)
        {
            fieldCedulon.setText((String) cedulone[0]);
            getValues();
            //System.out.print((String) cedulone[0]);
            insertRowInCedulon();
        }
}

private void completeTablePaymentForModified()
{
        for (Object[] payments_ : payments)
        {
            insertNewPaymentInView((String) payments_[1],(String) payments_[3],(String) payments_[2]);
        }
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
    fieldTotalPayment.setText(String.valueOf(finalTotalPayment));
}

private void CallViewForModifyPayments()
{
    main.addNewPayment(this, operation);
}

private void clean()
{
    fieldCedulon.setText("");
    fieldCedulon.setEnabled(true);
    buttonSearch.setEnabled(true);
    isValid = false; 
    //isRowClicked = false;


}

//private void fullClean()
//{
//    fieldCedulon.setText("");
//    fieldCedulon.setEnabled(true);
//    buttonSearch.setEnabled(true);
//    isValid = false;
//    //isRowClicked = false;
//    finalTotalCedulon = 0;
//    fieldTotalPayment.setText("");
//    fieldCedulon.requestFocus();
//    modelCedulon.setRowCount(0);
//    tableCedulon.revalidate();
//}

private void getValues()
{
    id_cedulon = fieldCedulon.getText();
    cod_padron = sen.datos_string("cod_padron", "select cod_padron from cedulon where id_cedulon='"+id_cedulon+"';");
    period =  sen.datos_string("periodo", "select periodo from cedulon where id_cedulon='"+fieldCedulon.getText()+"';");
    name = sen.datos_string("propietario", "select propietario from cedulon,padron where cod_padron = id_padron and id_cedulon='"+id_cedulon+"';");
    oldDate = sen.datos_string("fechaVencimiento", "select fechaVencimiento from cedulon where id_cedulon='"+id_cedulon+"';");
    totalCedulon = af.CutDecimales_Double(Double.valueOf(sen.datos_string("total", "select total from cedulon where id_cedulon='"+id_cedulon+"';")));
    lessee = sen.datos_string("nombreApellido", "select nombreApellido from cedulon,padron,inquilino where cod_inquilino = id_inquilino and cod_padron = id_padron and id_cedulon='"+id_cedulon+"';");
}

private void insertRowInCedulon()
{
        finalTotalCedulon = finalTotalCedulon + totalCedulon;
        modelCedulon.addRow(new Object[]{id_cedulon, period, name, lessee, totalCedulon});
        tableCedulon.repaint();
        fieldTotalCedulon.setText(String.valueOf(finalTotalCedulon));
        clean();
        //buttonSearch.setEnabled(false);     
}

public void insertNewPaymentInView(String type, String total, String detail)
{
    finalTotalPayment = finalTotalPayment + Double.valueOf(total);
    modelPayment.addRow(new Object[]{"", type, detail, total});
    tablePayment.repaint();
    fieldTotalPayment.setText(String.valueOf(af.CutDecimales_Double(finalTotalPayment)));
    clean();   
}

private void VerifyExitAndClean()
{
            if(tableCedulon.getRowCount()>0 || tablePayment.getRowCount()>0)
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


private void associateIngressWithCedulon()
{
    for (int i = 0; i < tableCedulon.getRowCount(); i++) 
    {
        String id = tableCedulon.getValueAt(i, 0).toString();
        af.modifyStatePay (id);
        af.modifyCedulon(id, "cod_ingreso", cod_ingress);
    }
}

private void registerInDB()
{
    //Registro el ingreso en la tabla pruebaIngreso
    if(registerIngressInBD())
    {
        //Registro el id_ingreso en la tabla cedulones y lo cambia a pagado.
        associateIngressWithCedulon();
        //Registro los tipos de pago en la tabla operaciones
        registerOperationsInBD();
        JOptionPane.showMessageDialog(null,"El ingreso se cargo correctamente", "",JOptionPane.INFORMATION_MESSAGE);
        if(isModified){temporalSearchIngress.filterTable();}
        af.disconect();
        this.dispose();
    }
}

private boolean registerIngressInBD() 
{ 
    if(isModified)
    {
            if(af.temporalInsertIngress(id_ingress, af.getDateToString(DateOfPay.getDate()), "Canon por uso de agua."))
            {
                cod_ingress = id_ingress;
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
            int id = af.temporalInsertIngress(af.getDateToString(DateOfPay.getDate()), "Canon por uso de agua.");
            if(id<0)
            {
                JOptionPane.showMessageDialog(null,"Se produjo un error al cargar el ingreso.", "Atención",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else
            {
                cod_ingress = String.valueOf(id);
                return true;  
            }
    }
}    

private void registerOperationsInBD() 
{
    for (int i = 0; i < tablePayment.getRowCount(); i++)
    {
        String cod_operation = String.valueOf(af.inserPayment1(af.parcePayment((String) tablePayment.getValueAt(i, 1)), (String) tablePayment.getValueAt(i, 2),(String) tablePayment.getValueAt(i, 3)));
        //Asocio el egreso con las operaciones
        af.insertIngMod(cod_ingress, cod_operation);
    }
}

private boolean isValidIdCedulon(String id_cedulon)
{
    for (int i = 0; i < tableCedulon.getRowCount(); i++) 
    {
        if(tableCedulon.getValueAt(i, 0).equals(id_cedulon))
        {
            JOptionPane.showMessageDialog(null,"El cedulón "+ id_cedulon +" no se añadió porque ya existe en la lista.", "Atención",JOptionPane.WARNING_MESSAGE);
            clean();
            return false;
        }  
    }

    if(fieldCedulon.getText().equals("") || !af.existCedulon(fieldCedulon.getText()))
    {
        JOptionPane.showMessageDialog(null,"El número de cedulón ingresado no existe.", "Atención",JOptionPane.WARNING_MESSAGE);
        clean();
        fieldCedulon.requestFocus();
        return false;
    }
    if(af.isPaidOut(id_cedulon))
    {
        JOptionPane.showMessageDialog(null,"El cedulón "+ id_cedulon +" no se añadió porque ya se encuentra pago.", "Atención",JOptionPane.WARNING_MESSAGE);
        clean();
        fieldCedulon.requestFocus();
        return false;
    }
    getValues();
    return true;
}

public void removeSelectedRowsOfCedulon()
{
    int[] rows = tableCedulon.getSelectedRows();
    for(int i=0;i<rows.length;i++)
    {
       finalTotalCedulon = finalTotalCedulon - (double) modelCedulon.getValueAt(rows[i]-i, 4);
       modelCedulon.removeRow(rows[i]-i);
    }
    fieldTotalCedulon.setText(String.valueOf(finalTotalCedulon));
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

private void unlinkIngressAndOperation()
{
    //desvinculo con los ceduloes
    for (Object[] cedulone : cedulones)
    {
        af.modifyState((String)cedulone[0], "PENDIENTE");//lo cambio a pendiente
        af.modifyCedulon((String)cedulone[0], "cod_ingreso", "");//le desvinculo el cod de ingreso
    }
    //borro las operaciones
    for (Object[] payments_ : payments)
    {
        af.deleteTemporalOperation((String)payments_[0]);
    }
    //Desvinculo las asociaciones de operaciones e ingreso
    for (Object[] payments_ : payments)
    {
        af.deleteIngModTrhowsCodOperation((String)payments_[0]);
    }
    //borro el ingreso
    af.deleteTemporalIngress(id_ingress);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DateOfPay = new com.toedter.calendar.JDateChooser();
        buttonRegister = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        fieldCedulon = new javax.swing.JTextField();
        fieldTotalPayment = new javax.swing.JTextField();
        labelNumberOfCedulon = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelCedulon = new javax.swing.JLabel();
        labelDateOfPayment = new javax.swing.JLabel();
        labelPayments = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCedulon = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePayment = new javax.swing.JTable();
        fieldTotalCedulon = new javax.swing.JTextField();
        labelTotal1 = new javax.swing.JLabel();
        buttonAddCedulon = new javax.swing.JButton();
        buttonRemoveCedulon = new javax.swing.JButton();
        buttonRemovePayment = new javax.swing.JButton();
        buttonAddPayment1 = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();

        setResizable(true);
        setTitle("Registar cobro de cedulón");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money16.png"))); // NOI18N

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

        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCedulon26.png"))); // NOI18N
        buttonSearch.setToolTipText("Buscar cedulón");
        buttonSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonSearch.setBorderPainted(false);
        buttonSearch.setContentAreaFilled(false);
        buttonSearch.setDefaultCapable(false);
        buttonSearch.setFocusable(false);
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        fieldCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCedulonActionPerformed(evt);
            }
        });

        fieldTotalPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalPaymentActionPerformed(evt);
            }
        });

        labelNumberOfCedulon.setText("N° de cedulón");

        labelTotal.setText("Total pagos");

        labelCedulon.setText("Cedulones");

        labelDateOfPayment.setText("Fecha de cobro");

        labelPayments.setText("Pagos");

        tableCedulon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Cedulon", "Periodo", "Nombre del campo", "Arrendatario", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCedulon);
        if (tableCedulon.getColumnModel().getColumnCount() > 0) {
            tableCedulon.getColumnModel().getColumn(0).setPreferredWidth(70);
            tableCedulon.getColumnModel().getColumn(0).setMaxWidth(80);
            tableCedulon.getColumnModel().getColumn(1).setPreferredWidth(70);
            tableCedulon.getColumnModel().getColumn(1).setMaxWidth(80);
            tableCedulon.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableCedulon.getColumnModel().getColumn(2).setMaxWidth(200);
            tableCedulon.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableCedulon.getColumnModel().getColumn(3).setMaxWidth(200);
            tableCedulon.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableCedulon.getColumnModel().getColumn(4).setMaxWidth(80);
        }

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

        fieldTotalCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalCedulonActionPerformed(evt);
            }
        });

        labelTotal1.setText("Total cedulones ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelTotal1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldTotalCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelPayments, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCedulon, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelNumberOfCedulon))
                                            .addComponent(fieldCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(16, 16, 16)
                                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelDateOfPayment)
                                            .addComponent(DateOfPay, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelDateOfPayment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateOfPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNumberOfCedulon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addComponent(labelCedulon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal1)
                    .addComponent(fieldTotalCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(labelPayments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(fieldTotalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegister)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        buttonAddCedulon.setText("Añadir");
        buttonAddCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCedulonActionPerformed(evt);
            }
        });

        buttonRemoveCedulon.setText("Borrar");
        buttonRemoveCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveCedulonActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonAddCedulon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRemoveCedulon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRemovePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAddPayment1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(buttonAddCedulon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRemoveCedulon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAddPayment1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRemovePayment)
                .addGap(89, 89, 89))
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
        if(tableCedulon.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null,"No hay cedulones seleccionados.", "Atención",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(tablePayment.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null,"No hay pagos seleccionados.", "Atención",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!fieldTotalCedulon.getText().equals(fieldTotalPayment.getText()))
        {
            if (JOptionPane.showConfirmDialog(null, "El valor total de cedulones es diferente al valor total de los pagos cargados.\nDesea registrarlo de todas formas?", "Atención",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                    {
                        if(isModified)
                        {
                            unlinkIngressAndOperation();
                            registerInDB();   
                        }
                        else
                            registerInDB();
                    }
        }
        else
        {
            if(isModified)
            {
                unlinkIngressAndOperation();
                registerInDB();   
            }
            else
                registerInDB();
        }    
    
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void buttonRemovePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemovePaymentActionPerformed
        if(tablePayment.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
        else
            removeSelectedRowsOfPayment();
    }//GEN-LAST:event_buttonRemovePaymentActionPerformed

    private void buttonAddCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCedulonActionPerformed
        main.addSearchCedulon(this);
    }//GEN-LAST:event_buttonAddCedulonActionPerformed

    private void fieldTotalCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalCedulonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTotalCedulonActionPerformed

    private void buttonRemoveCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveCedulonActionPerformed
        removeSelectedRowsOfCedulon();
    }//GEN-LAST:event_buttonRemoveCedulonActionPerformed

    private void buttonAddPayment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddPayment1ActionPerformed
        main.addNewPayment(this);
    }//GEN-LAST:event_buttonAddPayment1ActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        main.addSearchCedulon(this);
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void fieldCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCedulonActionPerformed
        
            if(isValidIdCedulon(fieldCedulon.getText()))
            {
                insertRowInCedulon();
                fieldCedulon.requestFocus();            
            }
            else
            {
                fieldCedulon.requestFocus();
            }
 
    }//GEN-LAST:event_fieldCedulonActionPerformed

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
    private javax.swing.JButton buttonAddCedulon;
    private javax.swing.JButton buttonAddPayment1;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JButton buttonRemoveCedulon;
    private javax.swing.JButton buttonRemovePayment;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JTextField fieldCedulon;
    private javax.swing.JTextField fieldTotalCedulon;
    private javax.swing.JTextField fieldTotalPayment;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCedulon;
    private javax.swing.JLabel labelDateOfPayment;
    private javax.swing.JLabel labelNumberOfCedulon;
    private javax.swing.JLabel labelPayments;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotal1;
    private javax.swing.JTable tableCedulon;
    private javax.swing.JTable tablePayment;
    // End of variables declaration//GEN-END:variables
}
