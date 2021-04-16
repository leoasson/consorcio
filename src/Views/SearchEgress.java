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
 * @author leoas
 */
public final class SearchEgress extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    main main;
    private Object[][] tableDate; 
    String[] column = {"Id egreso", "Fecha","Concepto", "Importe"};
    Object[] channel;
    Object[] name;
    int state = 0;
    PropertyChangeListener ActListener;
    int rowClicked;
    int count = 2;
    
    public SearchEgress(main main)
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
        filterTable();
//        this.ActListener = new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent pce) {
//                if(count < 0)
//                {
//                filterTable();
//                }
//                count --;
//            }     
//    };
//        
//        comboMonth.addPropertyChangeListener(ActListener);
//        comboYear.addPropertyChangeListener(ActListener);
        
        tableEgress.addMouseListener(new MouseAdapter() 
    {
        @Override
        public void mousePressed(MouseEvent mouseEvent) 
        {
            JTable table =(JTable) mouseEvent.getSource();
            Point point = mouseEvent.getPoint();
            rowClicked = table.rowAtPoint(point);
            if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
            {
                //le paso los parametros correspondientes.
                String id =(String) table.getValueAt(rowClicked, 0);
                addNewModifySimpleEgressOrIngress(id);
            }
        }
    });  
        
}
    

    private void addNewModifySimpleEgressOrIngress(String id)
    {
        main.addNewModifySimpleEgressOrIngress(id,this);
    }
    
    public void filterTable()
    {
        boolean[] filter = {boxMonth.isSelected(), boxYear.isSelected()};
        String fieldYear, fieldMonth;
        setTitletable(filter);
        fieldMonth = String.valueOf(comboMonth.getMonth()+1);
        fieldYear = String.valueOf(comboYear.getYear());
        tableDate = af.TemporalFilterEgress(fieldMonth, fieldYear, filter);
        generateTableData(tableDate);
    }
    private void generateTableData(Object [][] datostabla)
    {    
        DefaultTableModel datos = new DefaultTableModel(datostabla,column);
        tableEgress.setModel(datos);
        tableEgress.getColumnModel().getColumn(0).setPreferredWidth(70);
        tableEgress.getColumnModel().getColumn(0).setMaxWidth(80);
        tableEgress.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableEgress.getColumnModel().getColumn(1).setMaxWidth(150);
        tableEgress.getColumnModel().getColumn(2).setPreferredWidth(500);
        tableEgress.getColumnModel().getColumn(2).setMaxWidth(600);
        tableEgress.getColumnModel().getColumn(3).setPreferredWidth(120);
        tableEgress.getColumnModel().getColumn(3).setMaxWidth(130);

    }
    
    private void setTitletable(boolean[] filter)
    {
        int month = comboMonth.getMonth()+1;
        int year = comboYear.getYear();
        switch(Arrays.toString(filter))
            { 
                case "[false, false]":
                title = "Detalle de todos los egresos"; 
                break;        
                case "[false, true]":
                title = "Detalle de egresos para el año "+year+"."; 
                break;                               
                case "[true, true]":
                title = "Detalle de egresos para el mes "+ month+" del año "+year+".";  
                break;  
                default:
                title = "Detalle de todos los egresos"; 
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
        tableEgress = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonModify = new javax.swing.JButton();
        comboMonth = new com.toedter.calendar.JMonthChooser();
        buttonGenerateExcel = new javax.swing.JButton();
        comboYear = new com.toedter.calendar.JYearChooser();
        buttonDelete = new javax.swing.JButton();

        setTitle("Listar Egresos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/listOut16.png"))); // NOI18N

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

        tableEgress.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableEgress);

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
                                .addComponent(boxMonth)
                                .addGap(79, 79, 79)
                                .addComponent(boxYear))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(boxYear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonFilter)
                            .addComponent(comboMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
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
            
        }
        else
        {
            comboMonth.setEnabled(false);
            boxYear.setEnabled(false);
            boxYear.setSelected(false);
            boxYear.setEnabled(true);
            comboYear.setEnabled(false);
        }
    }//GEN-LAST:event_boxMonthActionPerformed

    private void boxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxYearActionPerformed
        if(boxYear.isSelected())
        { 
            comboYear.setEnabled(true);
        }
        else
        {
            comboYear.setEnabled(false);
        }
    }//GEN-LAST:event_boxYearActionPerformed

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        filterTable();
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        //count = 2;
        af.disconect();
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
    int row = tableEgress.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            //le paso los parametros correspondientes.
            String id =(String) tableEgress.getValueAt(rowClicked, 0);
            addNewModifySimpleEgressOrIngress(id);
        }        
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void buttonGenerateExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateExcelActionPerformed
        Object[][] data;
        int month = comboMonth.getMonth()+1;
        int year = comboYear.getYear();

        if(boxMonth.isSelected())
            data = af.getTemporalDetailedEgress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"'");
        else if(boxYear.isSelected() && !boxMonth.isSelected()) 
            data = af.getTemporalDetailedEgress(" where YEAR(fecha) = '"+ year +"'");
        else
            data = af.getTemporalDetailedEgress("");

        String [] columns = {"Id egresso", "Fecha","Concepto", "Modalidad", "Detalle", "Importe"};
        SaveExcelFile file = new SaveExcelFile(title+"-"+af.getActualDateInString());
        GenerateXls xls = new GenerateXls(data, columns, title, 2);
        String route = file.getRoute();
        if(route != null)
        {
                xls.generate(route);
        }       
    }//GEN-LAST:event_buttonGenerateExcelActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        int row = tableEgress.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada.","Atención",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            //le paso los parametros correspondientes.
            String id =(String) tableEgress.getValueAt(rowClicked, 0);
            Object[][] payments = af.getPaymentForModifyIngressOrEgress("LEFT JOIN `modalidad` ON `id_modalidad` = `cod_modalidad` LEFT JOIN `ingmod` ON `id_operacion` = `cod_operacion` WHERE `cod_ingreso`= '"+id+"'");

            for (Object[] payments_ : payments)
            {
                af.deleteEgrModTrhowsCodOperation((String)payments_[0]);
            }
            //borro el egreso
            af.deleteTemporalEgress(id);
        }  
    }//GEN-LAST:event_buttonDeleteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
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
    private javax.swing.JTable tableEgress;
    // End of variables declaration//GEN-END:variables
}
