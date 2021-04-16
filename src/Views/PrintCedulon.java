package Views;

import consorcio.AuxiliaryFunctions;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;


/**
 *
 * @author leoasson
 */
public class PrintCedulon extends javax.swing.JFrame implements Printable {

String number;
public boolean top;
PrinterJob gap = PrinterJob.getPrinterJob();
AuxiliaryFunctions af = new AuxiliaryFunctions();

    public PrintCedulon(String number)
    {
       initComponents();
       this.number = number; 
       gap.setPrintable(this);
       top = gap.printDialog();
        if(top)
        {
            generateCedulones();
        } 
    }
    private void generateCedulones()
    {
            String id_cedulon,user,channel,amount,owner,total,dateOfExpired,surcharge, amountPerUnit, period, cup;
            
            Object [][] cedulon = af.getCedulonForPrint("id_cedulon = '"+number+"';");
            
            for (Object[] cedulon2 : cedulon) 
            {
            id_cedulon = cedulon2[0].toString();
            user = cedulon2[1].toString();
            channel = cedulon2[2].toString();
            amount = cedulon2[3].toString(); 
            owner = cedulon2[4].toString();
            total = "$ " + cedulon2[5].toString();
            dateOfExpired = cedulon2[6].toString();
            period = cedulon2[7].toString();
            surcharge = cedulon2[8].toString();
            amountPerUnit = cedulon2[9].toString();
            cup = String.valueOf(Double.valueOf(amount) * Double.valueOf(amountPerUnit));
            insertValuesInCedulon(id_cedulon, user, channel, amount, owner, total, dateOfExpired, surcharge, amountPerUnit, period, cup);
            imprimir();
            clean();
            }           
    }   
    
    public void insertValuesInCedulon(String id_cedulon, String user, String channel, String amount, String owner, String total, String dateOfExpired, String surcharge, String amountPerUnit, String period, String cup)
    {
        fieldChannel1.setText(channel);
        jTextField1.setText(owner);
        fieldDateOfExpired1.setText(dateOfExpired);
        fieldBarCode1.setText("*"+id_cedulon+"*");
        fieldCode1.setText(id_cedulon);
        fieldUser1.setText(user);
        fieldTotal1.setText(total);
        fieldAmount1.setText(amount);
        fieldPeriod1.setText("periodo " + period);
        fieldTasa1.setText(cup);
        fieldSurcharge1.setText("%"+ surcharge);
        fieldAmountPerUnit1.setText(amountPerUnit);         
    }
private void clean()
{
    fieldChannel1.setText("");
    jTextField1.setText("");
    fieldDateOfExpired1.setText("");
    fieldBarCode1.setText("");
    fieldUser1.setText("");
    fieldTotal1.setText("");
    fieldAmount1.setText("");
    fieldPeriod1.setText("");
    fieldTasa1.setText("");
    fieldSurcharge1.setText("");
    fieldAmountPerUnit1.setText("");
    fieldBarCode1.setText("");
    fieldCode1.setText("");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        cedulones = new javax.swing.JPanel();
        cedulon1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        fieldDateOfExpired1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        fieldBarCode1 = new javax.swing.JTextField();
        fieldChannel1 = new javax.swing.JTextField();
        fieldUser1 = new javax.swing.JTextField();
        fieldAmount1 = new javax.swing.JTextField();
        fieldTasa1 = new javax.swing.JTextField();
        fieldSurcharge1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        fieldPeriod1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        fieldCode1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        fieldTotal1 = new javax.swing.JTextField();
        LabelamountPerUnit = new javax.swing.JLabel();
        fieldAmountPerUnit1 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        buttonPrint = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cedulones.setBackground(new java.awt.Color(255, 255, 255));
        cedulones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cedulon1.setBackground(new java.awt.Color(255, 255, 255));
        cedulon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("NOMBRE:");

        jLabel14.setText("CANAL:");

        jLabel21.setText("USUARIO:");

        jLabel23.setText("CUANTIA:");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("VENCIMIENTO: ");
        jLabel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldDateOfExpired1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldDateOfExpired1.setPreferredSize(new java.awt.Dimension(0, 20));
        fieldDateOfExpired1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDateOfExpired1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldDateOfExpired1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addComponent(fieldDateOfExpired1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel25.setText("TASA:");

        jLabel27.setText("RECARGO: ");

        fieldBarCode1.setFont(new java.awt.Font("Code 39", 0, 24)); // NOI18N
        fieldBarCode1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldBarCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBarCode1ActionPerformed(evt);
            }
        });

        fieldChannel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldUser1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldAmount1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldTasa1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldSurcharge1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldSurcharge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSurcharge1ActionPerformed(evt);
            }
        });

        jLabel30.setText("Canon por uso de agua  ");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("CONSORCIO DE RIEGO ZONA SUR");

        fieldPeriod1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldPeriod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPeriod1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel32.setText("Cedulon Informativo -  No válido como comprobante de pago");

        fieldCode1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCode1ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("TOTAL:");
        jLabel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldTotal1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldTotal1.setPreferredSize(new java.awt.Dimension(2, 20));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(fieldTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        LabelamountPerUnit.setText("MONTO P/UNIDAD:");

        fieldAmountPerUnit1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldAmountPerUnit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAmountPerUnit1ActionPerformed(evt);
            }
        });

        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout cedulon1Layout = new javax.swing.GroupLayout(cedulon1);
        cedulon1.setLayout(cedulon1Layout);
        cedulon1Layout.setHorizontalGroup(
            cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56)
                        .addComponent(fieldPeriod1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelamountPerUnit))
                                .addGap(12, 12, 12)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldAmount1)
                                    .addComponent(fieldAmountPerUnit1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                            .addComponent(fieldBarCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldSurcharge1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTasa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        cedulon1Layout.setVerticalGroup(
            cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel31))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fieldPeriod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25))
                            .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addComponent(jLabel21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(fieldChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelamountPerUnit)
                            .addComponent(fieldAmountPerUnit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addComponent(fieldTasa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(fieldSurcharge1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addComponent(fieldBarCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(fieldCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cedulonesLayout = new javax.swing.GroupLayout(cedulones);
        cedulones.setLayout(cedulonesLayout);
        cedulonesLayout.setHorizontalGroup(
            cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulonesLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(cedulon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        cedulonesLayout.setVerticalGroup(
            cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulonesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cedulon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(630, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(cedulones);

        buttonPrint.setText("Imprimir");
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrint)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
 try
        {
            PrinterJob _gap = PrinterJob.getPrinterJob();
            gap.setPrintable(this);
            boolean _top = gap.printDialog();
            if(_top)
            {
            gap.print();
            }
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,"ERROR DE PROGRAMA", "Error\n" + e, JOptionPane.INFORMATION_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void fieldCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCode1ActionPerformed

    private void fieldPeriod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPeriod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPeriod1ActionPerformed

    private void fieldSurcharge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSurcharge1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSurcharge1ActionPerformed

    private void fieldBarCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBarCode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBarCode1ActionPerformed

    private void fieldAmountPerUnit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAmountPerUnit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAmountPerUnit1ActionPerformed

    private void fieldDateOfExpired1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDateOfExpired1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDateOfExpired1ActionPerformed

    @Override
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException
    {
        if(index>0)
        {
        return NO_SUCH_PAGE;
        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pagfor.getImageableX()-10, pagfor.getImageableY() + 30);
        hub.scale(0.8,0.8);
        
        cedulones.printAll(graf);
        return PAGE_EXISTS;
    }
    
 public void imprimir(){                                            
    try
        {
            gap.print();
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,"ERROR DE PROGRAMA", "Error\n" + e, JOptionPane.INFORMATION_MESSAGE);
        }        // TODO add your handling code here:
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelamountPerUnit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JPanel cedulon1;
    private javax.swing.JPanel cedulones;
    private javax.swing.JTextField fieldAmount1;
    private javax.swing.JTextField fieldAmountPerUnit1;
    private javax.swing.JTextField fieldBarCode1;
    private javax.swing.JTextField fieldChannel1;
    private javax.swing.JTextField fieldCode1;
    private javax.swing.JTextField fieldDateOfExpired1;
    private javax.swing.JTextField fieldPeriod1;
    private javax.swing.JTextField fieldSurcharge1;
    private javax.swing.JTextField fieldTasa1;
    private javax.swing.JTextField fieldTotal1;
    private javax.swing.JTextField fieldUser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
