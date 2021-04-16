package Views;
import javax.swing.JOptionPane;
import consorcio.AuxiliaryFunctions;
import consorcio.sentencesSql;

/**
 *
 * @author leoasson
 */
public final class NewPayment extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    Ingress ingress;
    SimpleEgressOrIngress egress;
    OtherEgressOrIngress otherEgressOrIngress;
    int typeOperacion;//si es un ingreso es 1 si es egreso 2;
    int idPayment;
    boolean itsModification;
    String total, type, fullDetail, detail, date, number, bank;
    
    public NewPayment() 
    {
        initComponents();
        init();
    }

    NewPayment(SimpleEgressOrIngress egress, String [] operation) 
    {
        this.egress = egress;
        initComponents();
        init();
        this.setTitle("Modificar pago");
        typeOperacion = 2;
        itsModification = true;
        buttonGenerate.setText("Guardar");
        
        type = operation[0];
        fullDetail = operation[1];
        total = operation [2];
        //getValuesofTheDB();
        setValuesInView();
    }
    
    NewPayment(SimpleEgressOrIngress egress) 
    {
        this.egress = egress;
        initComponents();
        init();
        typeOperacion = 2;
        itsModification = false;
        buttonGenerate.setText("Añadir");
    }
    
    
    NewPayment(Ingress ingress, String [] operation) 
    {
        this.ingress = ingress;
        initComponents();
        init();
        typeOperacion = 1;
        itsModification = true;
        buttonGenerate.setText("Guardar");
        type = operation[0];
        fullDetail = operation[1];
        total = operation [2];
        //getValuesofTheDB();
        setValuesInView();
    }
    
    NewPayment(Ingress ingress) 
    {
        this.ingress = ingress;
        initComponents();
        init();
        typeOperacion = 1;
        itsModification = false;
        buttonGenerate.setText("Añadir");
    }
    
    
    NewPayment(OtherEgressOrIngress otherEgress) 
    {
        otherEgressOrIngress = otherEgress;
        initComponents();
        init();
        typeOperacion = 3;
        itsModification = false;
        buttonGenerate.setText("Añadir");
    }
    
    NewPayment(OtherEgressOrIngress otherEgress, String [] operation) 
    {
        otherEgressOrIngress = otherEgress;
        initComponents();
        init();
        this.setTitle("Modificar pago");
        typeOperacion = 3;
        itsModification = true;
        buttonGenerate.setText("Guardar");
        
        type = operation[0];
        fullDetail = operation[1];
        total = operation [2];

        setValuesInView();
    }
    
    private void init()
    {
        enabledAll();
        completeComboMode();
        clean();
    }
    public void completeComboMode()
    {
        Object [] pay = af.combox("modalidad", "modalidad");
        comboType.removeAllItems();
        for (Object pay1 : pay) 
        {
            comboType.addItem(pay1.toString());
        }   
        comboType.requestFocus();  
        comboType.setSelectedItem("EFECTIVO");
    }
    private void clean()
    {
        fieldTotal.setText("");
        fieldNumber.setText("");
        fieldBank.setText("");
        fieldDate.setDate(af.getActualDate());
        fieldDetail.setText("");
        comboType.setSelectedItem("EFECTIVO");
    }
    private void enabledAll()
    {
        fieldTotal.setEnabled(true);
        fieldNumber.setEnabled(true);
        fieldBank.setEnabled(true);
        fieldDate.setEnabled(true);
        fieldDetail.setEnabled(true);
    
    }
    private void generateDetail() 
    {
        switch(type)
        {
            case "EFECTIVO":
                if(fieldDetail.getText().equals(""))
                    fullDetail = " ";
                else
                    fullDetail = fieldDetail.getText();
                break;
                
            case "TRANSFERENCIA":
                    fullDetail = "Banco: "+fieldBank.getText()+" ~ N°transf: "+fieldNumber.getText()+ " ~ Acreditación: "+af.getDateToString(fieldDate.getDate()) + " ~ Detalle: "+ fieldDetail.getText();    
                break; 
                
            case "BANCO":
                if(fieldDetail.getText().equals(""))
                    fullDetail = " ";
                else
                    fullDetail = fieldDetail.getText();
                break;
                
            default:
                    fullDetail = "Banco: "+fieldBank.getText()+" ~ N°cheque: "+fieldNumber.getText()+ " ~ Acreditación: "+af.getDateToString(fieldDate.getDate()) + " ~ Detalle: "+ fieldDetail.getText();    
                break;
        }   
    } 
    private boolean getValuesOfView()
    {
        //Verifico que el numero de importe ingresado sea correcto, si es asi le asigno a total el importe.
        if(af.isValidNumber(fieldTotal.getText()))
        {
            //corto a dos decimales
            total = af.CutDecimal_String(fieldTotal.getText());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El valor del campo total debe ser un número válido.");
            return false; 
        }
        
        // Asigno el tipo de pago y Verifico que los campos esten completos
        type = (String) comboType.getSelectedItem();
        
        if(type.equals("CHEQUE PROPIO") || type.equals("CHEQUE DE TERCERO"))
        {
            if(fieldBank.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del banco.");
                return false;}
            else if(fieldNumber.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar un numero de cheque.");
                return false;}
            else if(fieldDate.getDate() == null){
                JOptionPane.showMessageDialog(null,"Debe ingresar una fecha valida.");
                return false;}
            else{
                generateDetail();
                return true;}
        }   
        
        else if(type.equals("TRANSFERENCIA"))
        {
            if(fieldBank.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar el nombre del banco.");
                return false;}
            else if(fieldNumber.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar un número asociado con la transferencia."); 
                return false;}
            else{
            generateDetail();
            return true;
            }
        }
        else 
        {
            if(type.equals("")){detail= " ";}
            generateDetail();
            return true;
        }
    }
//    private void getValuesofTheDB()
//    {
//       String [] values;
//       values = af.getPayments(String.valueOf(idPayment));
//       type = af.parcePayment1(values[0]);
//       fullDetail = values[1];
//       total = values[2];
//    }
    private void setValuesInView()
    {
        cutFullDetail();
        comboType.setSelectedItem(type);
        fieldTotal.setText(total);
        fieldDetail.setText(detail);
    }
    private void cutFullDetail()
    {
    System.out.println(fullDetail);
    String detail_[] = fullDetail.split(" ~ ");
    switch(type)
        {
            case "EFECTIVO":
                detail = fullDetail;
                break;
            case "BANCO":
                detail = fullDetail;
                break;
            default:
                bank = detail_[0].substring(7);
                number = detail_[1].substring(10);
                date = detail_[2].substring(13);
                detail = detail_[3].substring(9);
                fieldBank.setText(bank);
                fieldNumber.setText(number);
                fieldDate.setDate(af.getDate(date));
                break;
        }   
    }
    
    private void modifyValuesTest()
    {
        
        if(getValuesOfView())
        {
            String [] operation = {type, fullDetail, total};
            switch(typeOperacion)
            {
                case 1:
                    ingress.modifiedPaymentInView(operation);
                    break;
                case 2:
                    egress.modifiedPaymentInView(operation);
                    break;
                case 3:
                    otherEgressOrIngress.modifiedPaymentInView(operation);
                    break;
            }
            af.disconect();
            this.dispose();
        }
    }

    private void ingressNewPayments()
    {
        if(getValuesOfView())
        {
                switch(typeOperacion)
                {
                    case 1:
                        ingress.insertNewPaymentInView(type, total, fullDetail);
                        break;
                    case 2:
                        egress.insertNewPaymentInView(type, total, fullDetail);
                        break;
                    case 3:
                        otherEgressOrIngress.insertNewPaymentInView(type, total, fullDetail);
                        break;
                    default:
                        break;
                } 
            af.disconect();    
            this.dispose();
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGenerate = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        labelMedia = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JTextField();
        labelDetail = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox<>();
        fieldDate = new com.toedter.calendar.JDateChooser();
        labelDate = new javax.swing.JLabel();
        fieldBank = new javax.swing.JTextField();
        fieldNumber = new javax.swing.JTextField();
        labelBank = new javax.swing.JLabel();
        labelNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldDetail = new javax.swing.JTextArea();

        setTitle("Nuevo pago");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outMoney16.png"))); // NOI18N

        buttonGenerate.setText("Añadir/Guardar");
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

        labelMedia.setText("Medio de pago");

        labelTotal.setText("Importe");

        fieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalActionPerformed(evt);
            }
        });

        labelDetail.setText("Detalle");

        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeActionPerformed(evt);
            }
        });

        labelDate.setText("Acreditacion");

        labelBank.setText("Banco");

        labelNumber.setText("Numero");

        fieldDetail.setColumns(20);
        fieldDetail.setRows(5);
        jScrollPane1.setViewportView(fieldDetail);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fieldDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboType, javax.swing.GroupLayout.Alignment.LEADING, 0, 162, Short.MAX_VALUE)
                                    .addComponent(labelMedia, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDetail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDate, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelTotal)
                                            .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelNumber)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBank)
                            .addComponent(fieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonGenerate)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMedia)
                    .addComponent(labelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBank)
                    .addComponent(labelNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(labelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerate)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        //verifico si es una modificacion o un nuevo ingreso
        if(itsModification)
            modifyValuesTest();
        else
            ingressNewPayments();     
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void comboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeActionPerformed
       
       if(comboType.getSelectedItem() != null)
       {
            type = (String) comboType.getSelectedItem();
            enabledAll();
             switch(type)
             {
                 case "EFECTIVO":
                     fieldBank.setEnabled(false);
                     fieldNumber.setEnabled(false);
                     fieldDate.setEnabled(false);
                     break;
                 case "BANCO":
                     fieldBank.setEnabled(false);
                     fieldNumber.setEnabled(false);
                     fieldDate.setEnabled(false);    
                     break;
                 default:
                     break;

             }
       }
    }//GEN-LAST:event_comboTypeActionPerformed

    private void fieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalActionPerformed
        buttonGenerate.requestFocus(); 
    }//GEN-LAST:event_fieldTotalActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JTextField fieldBank;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JTextArea fieldDetail;
    private javax.swing.JTextField fieldNumber;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBank;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDetail;
    private javax.swing.JLabel labelMedia;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelTotal;
    // End of variables declaration//GEN-END:variables


}
