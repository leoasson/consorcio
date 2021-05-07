package Views;

import consorcio.AuxiliaryFunctions;
import consorcio.SaveExcelFile;
import consorcio.GenerateXls;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leoasson
 */
public final class SearchIngress extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    String[] column = {"Id ingreso", "Fecha","Concepto", "Importe"};
    Object[] channel;
    Object[] name;
    Object [][] cedulones;
    Object [][] payments;
    String title;
    main main;
    int state = 0;
    PropertyChangeListener ActListener;
    int rowClicked;
    int count = 2;
    
    public SearchIngress(main main)
    {
        this.main = main;
        init();
        boolean filter[] = {boxMonth.isSelected(), boxYear.isSelected()};
        setTitletable(filter);
    }
    
    
public void init ()
{
    initComponents();
    comboYear.setEnabled(false);
    comboMonth.setEnabled(false);
    textCedulon.setEnabled(false);
    textIngress.setEnabled(false);
    filterTable();
        
//    this.ActListener = new PropertyChangeListener() {
//        @Override
//        public void propertyChange(PropertyChangeEvent pce) {
//            if(count < 0)
//            {
//            filterTable();
//            }
//            count --;
//        }
//    };
//        comboMonth.addPropertyChangeListener(ActListener);
//        comboYear.addPropertyChangeListener(ActListener);
        
    tableIngress.addMouseListener(new MouseAdapter() 
    {
        @Override
        public void mousePressed(MouseEvent mouseEvent) 
        {
            JTable table =(JTable) mouseEvent.getSource();
            Point point = mouseEvent.getPoint();
            rowClicked = table.rowAtPoint(point);
            if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
            {
                //segun la fila que presione creo la clase simpleIngress o SimpleEgressOrIngress,
                //le paso los parametros correspondientes.
                String id =(String) table.getValueAt(rowClicked, 0);
                String typeIngress=(String) table.getValueAt(rowClicked, 2);

                if(typeIngress.equals("Canon por uso de agua."))
                    addNewModifyIngress(id);
                else
                    addNewModifySimpleEgressOrIngress(id);
            }
        }
    });            

}
    private void addNewModifyIngress(String id)
    {
        main.addNewModifyIngress(id,this);
    }
    
    private void addNewModifySimpleEgressOrIngress(String id)
    {
        main.addNewModifySimpleEgressOrIngress(id,this);
    }
    
    public void filterTable()
    {
//        boolean[] filter = {boxMonth.isSelected(), boxYear.isSelected()};
//        String fieldYear, fieldMonth;
//        setTitletable(filter);
//        fieldMonth = String.valueOf(comboMonth.getMonth()+1);
//        fieldYear = String.valueOf(comboYear.getYear());
//        
//        tableDate = af.TemporalFilterIngress(fieldMonth, fieldYear, filter);
//        generateTableData(tableDate);
        
        boolean[] filter = {boxMonth.isSelected(), boxYear.isSelected(), boxCedulon.isSelected(), boxIngress.isSelected()};
        String fieldYear, fieldMonth, fieldCedulon, fieldIngress;
        setTitletable(filter);
        fieldMonth = String.valueOf(comboMonth.getMonth()+1);
        fieldYear = String.valueOf(comboYear.getYear());
        fieldCedulon = textCedulon.getText();
        fieldIngress = textIngress.getText();
                
        tableDate = af.TemporalFilterIngress(fieldMonth, fieldYear, fieldCedulon, fieldIngress, filter);
        generateTableData(tableDate);
        
    }
    private void generateTableData(Object [][] datostabla)
    {    
        DefaultTableModel datos = new DefaultTableModel(datostabla,column);
        tableIngress.setModel(datos);
        tableIngress.getColumnModel().getColumn(0).setPreferredWidth(70);
        tableIngress.getColumnModel().getColumn(0).setMaxWidth(80);
        tableIngress.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableIngress.getColumnModel().getColumn(1).setMaxWidth(150);
        tableIngress.getColumnModel().getColumn(2).setPreferredWidth(500);
        tableIngress.getColumnModel().getColumn(2).setMaxWidth(600);
        tableIngress.getColumnModel().getColumn(3).setPreferredWidth(120);
        tableIngress.getColumnModel().getColumn(3).setMaxWidth(130);

    }
    
    private void deleteIngressAndOperation(String id_ingress)
    {
        payments = af.getPaymentForModifyIngressOrEgress("LEFT JOIN `modalidad` ON `id_modalidad` = `cod_modalidad` LEFT JOIN `ingmod` ON `id_operacion` = `cod_operacion` WHERE `cod_ingreso`= '"+id_ingress+"'");
        cedulones = af.getCedulonForModifyIngress("LEFT JOIN `padron` ON `id_padron`= `cod_padron` LEFT JOIN `inquilino` ON`id_inquilino` = `cod_inquilino` WHERE `cod_ingreso` = '"+id_ingress+"'");
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
        JOptionPane.showMessageDialog(null,"El ingreso se borro correctamente", "Atención",JOptionPane.INFORMATION_MESSAGE);
        filterTable();
    }
    
    private void deleteSimpleIngressAndOperation(String id_ingress)
    {
        payments = af.getPaymentForModifyIngressOrEgress("LEFT JOIN `modalidad` ON `id_modalidad` = `cod_modalidad` LEFT JOIN `ingmod` ON `id_operacion` = `cod_operacion` WHERE `cod_ingreso`= '"+id_ingress+"'");
        for (Object[] payments_ : payments)
        {
            af.deleteIngModTrhowsCodOperation((String)payments_[0]);
        }
        //borro el ingreso simple
        af.deleteTemporalIngress(id_ingress);
        JOptionPane.showMessageDialog(null,"El ingreso se borro correctamente", "Atención",JOptionPane.INFORMATION_MESSAGE);
        filterTable();
    }
    
    private void setTitletable(boolean[] filter)
    {
        int month = comboMonth.getMonth()+1;
        int year = comboYear.getYear();
        switch(Arrays.toString(filter))
            { 
                case "[false, false]":
                title = "Detalle de todos los ingresos"; 
                break;        
                case "[false, true]":
                title = "Detalle de ingresos para el año "+year; 
                break;                               
                case "[true, true]":
                title = "Detalle de ingresos para el mes "+ month+" del año "+year;  
                break;  
                default:
                title = "Detalle de todos los ingresos"; 
                break;
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        boxMonth = new javax.swing.JCheckBox();
        boxYear = new javax.swing.JCheckBox();
        buttonFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableIngress = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonModify = new javax.swing.JButton();
        comboMonth = new com.toedter.calendar.JMonthChooser();
        buttonGenerateExcel = new javax.swing.JButton();
        comboYear = new com.toedter.calendar.JYearChooser();
        buttonDelete = new javax.swing.JButton();
        boxCedulon = new javax.swing.JCheckBox();
        textCedulon = new javax.swing.JTextField();
        boxIngress = new javax.swing.JCheckBox();
        textIngress = new javax.swing.JTextField();

        setTitle("Listar ingresos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/listIncome16.png"))); // NOI18N

        jLabel1.setText("Filtrar por:");

        boxMonth.setText("Mes:");
        boxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMonthActionPerformed(evt);
            }
        });

        boxYear.setText("Año");
        boxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxYearActionPerformed(evt);
            }
        });

        buttonFilter.setText("Filtrar");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        tableIngress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableIngress);

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        buttonModify.setText("Modificar");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        buttonGenerateExcel.setText("Generar excel");
        buttonGenerateExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateExcelActionPerformed(evt);
            }
        });

        buttonDelete.setText("Borrar");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        boxCedulon.setText("Nº de cedulon");
        boxCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCedulonActionPerformed(evt);
            }
        });

        textCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCedulonActionPerformed(evt);
            }
        });

        boxIngress.setText("Nº de ingreso");
        boxIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxIngressActionPerformed(evt);
            }
        });

        textIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIngressActionPerformed(evt);
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
                        .addComponent(buttonDelete)
                        .addGap(18, 18, 18)
                        .addComponent(buttonModify)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGenerateExcel)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonFilter))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boxMonth)
                                        .addGap(79, 79, 79)
                                        .addComponent(boxYear))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxCedulon))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxIngress)
                                    .addComponent(textIngress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxMonth)
                            .addComponent(boxYear)
                            .addComponent(boxCedulon)
                            .addComponent(boxIngress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonFilter)
                                .addComponent(textCedulon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textIngress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(buttonModify)
                    .addComponent(buttonGenerateExcel)
                    .addComponent(buttonDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMonthActionPerformed
        if(boxMonth.isSelected())
        { 
            comboMonth.setEnabled(true);
            boxYear.setEnabled(false);
            boxYear.setSelected(true);
            comboYear.setEnabled(true);
            boxCedulon.setSelected(false);
            textCedulon.setEnabled(false);
            textCedulon.setText("");
            boxIngress.setSelected(false);
            textIngress.setEnabled(false);
            textIngress.setText("");
            
        }
        else  
        {
            comboMonth.setEnabled(false);
            boxYear.setEnabled(false);
            boxYear.setSelected(false);
            boxYear.setEnabled(true);
            comboYear.setEnabled(false);
            boxCedulon.setSelected(false);
            textCedulon.setEnabled(false);
            boxIngress.setSelected(false);
            textIngress.setEnabled(false);
        }        
    }//GEN-LAST:event_boxMonthActionPerformed

    private void boxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxYearActionPerformed
        if(boxYear.isSelected())
        { 
            comboYear.setEnabled(true);
            boxYear.setEnabled(true);
            boxCedulon.setSelected(false);
            textCedulon.setEnabled(false);
            textCedulon.setText("");
            boxIngress.setSelected(false);
            textIngress.setEnabled(false);
            textIngress.setText("");
        }
        else
        {
            comboYear.setEnabled(false);
        }
    }//GEN-LAST:event_boxYearActionPerformed

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        filterTable();
        if(tableIngress.getRowCount() == 0)
            JOptionPane.showMessageDialog(null,"La busqueda no arrojo ningun resultado","Atención",JOptionPane.WARNING_MESSAGE); 
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        //count = 2;
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        
        int row = tableIngress.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String id =(String) tableIngress.getValueAt(rowClicked, 0);
        String typeIngress=(String) tableIngress.getValueAt(rowClicked, 2);

        if(typeIngress.equals("Canon por uso de agua."))
            addNewModifyIngress(id);
        else
            addNewModifySimpleEgressOrIngress(id);       
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void buttonGenerateExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateExcelActionPerformed
        Object[][] data;
        int month = comboMonth.getMonth()+1;
        int year = comboYear.getYear();
        
        if(boxCedulon.isSelected() || boxIngress.isSelected())
            JOptionPane.showMessageDialog(null,"Para generar excel debe filtrar por fecha \n o no debe haber filtros aplicados.","Atención",JOptionPane.WARNING_MESSAGE);
        else
        {
            if(boxMonth.isSelected())
                data = af.getTemporalDetailedIngress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"' ORDER BY fecha DESC");
            else if(boxYear.isSelected() && !boxMonth.isSelected()) 
                data = af.getTemporalDetailedIngress(" where YEAR(fecha) = '"+ year +"' ORDER BY fecha DESC");
            else
                data = af.getTemporalDetailedIngress(" ORDER BY fecha DESC");

            String [] columns = {"Id ingreso", "Fecha", "Concepto", "Modalidad", "Detalle", "Importe"};
            SaveExcelFile file = new SaveExcelFile(title+"-"+af.getActualDateInString());
            GenerateXls xls = new GenerateXls(data, columns, title, 1);
            String route = file.getRoute();
            if(route != null)
            {
                    xls.generate(route);
            }      
        }
     
    }//GEN-LAST:event_buttonGenerateExcelActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        int row = tableIngress.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id =(String) tableIngress.getValueAt(rowClicked, 0);
        String typeIngress=(String) tableIngress.getValueAt(rowClicked, 2);
        
        if(typeIngress.equals("Canon por uso de agua."))
        {
            deleteIngressAndOperation(id);
        }
        else
        {
            deleteSimpleIngressAndOperation(id);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void boxCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCedulonActionPerformed
        if(boxCedulon.isSelected())
        {
            textCedulon.setEnabled(true);
            
            comboMonth.setEnabled(false);
            boxMonth.setEnabled(true);
            boxMonth.setSelected(false);
            
            comboYear.setEnabled(false);
            boxYear.setSelected(false);      
            boxYear.setEnabled(true);
            
            textIngress.setEnabled(false);
            boxIngress.setEnabled(true);
            boxIngress.setSelected(false);
            textIngress.setText("");
        }
        else
        {
            textCedulon.setText("");
            textCedulon.setEnabled(false);
            
            comboMonth.setEnabled(false);
            boxMonth.setEnabled(true);
            boxMonth.setSelected(false);
            
            comboYear.setEnabled(false);
            boxYear.setSelected(false);         
            boxYear.setEnabled(true);
            
            textIngress.setEnabled(false);
            boxIngress.setEnabled(true);
            boxIngress.setSelected(false);
            textIngress.setText("");
        }
    }//GEN-LAST:event_boxCedulonActionPerformed

    private void textCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCedulonActionPerformed
        buttonFilter.requestFocus();
    }//GEN-LAST:event_textCedulonActionPerformed

    private void textIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIngressActionPerformed
        buttonFilter.requestFocus();
    }//GEN-LAST:event_textIngressActionPerformed

    private void boxIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxIngressActionPerformed
        if(boxIngress.isSelected())
        {
            textIngress.setEnabled(true);
            
            comboMonth.setEnabled(false);
            boxMonth.setEnabled(true);
            boxMonth.setSelected(false);
            
            comboYear.setEnabled(false);
            boxYear.setSelected(false);      
            boxYear.setEnabled(true);
            
            textCedulon.setEnabled(false);
            boxCedulon.setEnabled(true);
            boxCedulon.setSelected(false);
            textCedulon.setText("");
        }
        else
        {
            textIngress.setText("");
            textIngress.setEnabled(false);
            
            comboMonth.setEnabled(false);
            boxMonth.setEnabled(true);
            boxMonth.setSelected(false);
            
            comboYear.setEnabled(false);
            boxYear.setSelected(false);         
            boxYear.setEnabled(true);
            
            textCedulon.setEnabled(false);
            boxCedulon.setEnabled(true);
            boxCedulon.setSelected(false);
            textCedulon.setText("");
        }
        
    }//GEN-LAST:event_boxIngressActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxCedulon;
    private javax.swing.JCheckBox boxIngress;
    private javax.swing.JCheckBox boxMonth;
    private javax.swing.JCheckBox boxYear;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JButton buttonGenerateExcel;
    private javax.swing.JButton buttonModify;
    private com.toedter.calendar.JMonthChooser comboMonth;
    private com.toedter.calendar.JYearChooser comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableIngress;
    private javax.swing.JTextField textCedulon;
    private javax.swing.JTextField textIngress;
    // End of variables declaration//GEN-END:variables
}
