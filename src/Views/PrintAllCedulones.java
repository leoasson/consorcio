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
public class PrintAllCedulones extends javax.swing.JFrame implements Printable {

String period;
public boolean top;
PrinterJob gap = PrinterJob.getPrinterJob();
AuxiliaryFunctions af = new AuxiliaryFunctions();

    public PrintAllCedulones(String period)
    {
       initComponents();
       this.period = period; 
       gap.setPrintable(this);
       top = gap.printDialog();
        if(top)
        {
            generateCedulones();
        }
        
    }
    private void generateCedulones()
    {
            String id_cedulon,user,channel,amount,owner,total,dateOfExpired,surcharge, amountPerUnit, cup;
            Object [][] cedulones = af.getCedulonForPrint("periodo = '"+period+"';");
            
            int position = 0, count = 0;
            for (Object[] cedulon1 : cedulones) 
            {
                    count ++;
                    id_cedulon = cedulon1[0].toString();
                    user = cedulon1[1].toString();
                    channel = cedulon1[2].toString();
                    amount = cedulon1[3].toString(); 
                    owner = cedulon1[4].toString();
                    total = "$ " + cedulon1[5].toString();
                    dateOfExpired = cedulon1[6].toString();
                    surcharge = cedulon1[8].toString();
                    amountPerUnit = cedulon1[9].toString();
                    cup = String.valueOf(Double.valueOf(amount) * Double.valueOf(amountPerUnit));
                    insertValuesInCedulon(position,id_cedulon, user, channel, amount, owner, total, dateOfExpired, surcharge, amountPerUnit, cup);
                    position ++;
                    
                    if(position == 4 || cedulones.length == count)
                    {
                        position = 0;
                        imprimir();
                        clean();
                    }
            }   
    }   
    
    public void insertValuesInCedulon(int position,String id_cedulon, String user, String channel, String amount, String owner, String total, String dateOfExpired, String surcharge, String amountPerUnit, String cup)
    {
        switch(position)
        {
            case 0:
                //System.out.print("*"+id_cedulon+"*");
                //System.out.print(id_cedulon +" "+ user + " " + channel + " "+ amount + " "+ owner + " "+ total + " "+ dateOfExpired + " "+ surcharge+"\n");
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
                fieldSurcharge1.setText("% "+surcharge);
                fieldAmountPerUnit1.setText(amountPerUnit);
                break;
                
            case 1:
                //System.out.print("*"+id_cedulon+"*");
                //System.out.print(id_cedulon +" "+ user + " " + channel + " "+ amount + " "+ owner + " "+ total + " "+ dateOfExpired + " "+ surcharge+"\n");
                fieldChannel2.setText(channel);
                jTextField2.setText(owner);
                fieldDateOfExpired2.setText(dateOfExpired);
                fieldBarCode2.setText("*"+id_cedulon+"*");
                fieldCode2.setText(id_cedulon);
                fieldUser2.setText(user);
                fieldTotal2.setText(total);
                fieldAmount2.setText(amount);
                fieldPeriod2.setText("periodo " + period);
                fieldTasa2.setText(cup);
                fieldSurcharge2.setText("% "+surcharge);
                fieldAmountPerUnit2.setText(amountPerUnit);

                break;
                
            case 2:
                //System.out.print("*"+id_cedulon+"*");
                //System.out.print(id_cedulon +" "+ user + " " + channel + " "+ amount + " "+ owner + " "+ total + " "+ dateOfExpired + " "+ surcharge+"\n");
                fieldChannel3.setText(channel);
                jTextField3.setText(owner);
                fieldDateOfExpired3.setText(dateOfExpired);
                fieldBarCode3.setText("*"+id_cedulon+"*");
                fieldCode3.setText(id_cedulon);
                fieldUser3.setText(user);
                fieldTotal3.setText(total);
                fieldAmount3.setText(amount);
                fieldPeriod3.setText("periodo " + period);
                fieldTasa3.setText(cup);
                fieldSurcharge3.setText("% "+surcharge);
                fieldAmountPerUnit3.setText(amountPerUnit);
                break;
            case 3:
                //System.out.print("*"+id_cedulon+"*");
                //System.out.print(id_cedulon +" "+ user + " " + channel + " "+ amount + " "+ owner + " "+ total + " "+ dateOfExpired + " "+ surcharge+"\n");
                fieldChannel4.setText(channel);
                jTextField4.setText(owner);
                fieldDateOfExpired4.setText(dateOfExpired);
                fieldBarCode4.setText("*"+id_cedulon+"*");
                fieldCode4.setText(id_cedulon);
                fieldUser4.setText(user);
                fieldTotal4.setText(total);
                fieldAmount4.setText(amount);
                fieldPeriod4.setText("periodo " + period);
                fieldTasa4.setText(cup);
                fieldSurcharge4.setText("% "+surcharge);
                fieldAmountPerUnit4.setText(amountPerUnit);
                break;       
                
            default:
                break;
        }

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
        fieldChannel2.setText("");
        jTextField2.setText("");
        fieldDateOfExpired2.setText("");
        fieldBarCode2.setText("");
        fieldUser2.setText("");
        fieldTotal2.setText("");
        fieldAmount2.setText("");
        fieldPeriod2.setText("");
        fieldTasa2.setText("");
        fieldSurcharge2.setText("");
        fieldAmountPerUnit2.setText("");
        fieldBarCode2.setText("");
        fieldCode2.setText("");
        fieldChannel3.setText("");
        jTextField3.setText("");
        fieldDateOfExpired3.setText("");
        fieldBarCode3.setText("");
        fieldUser3.setText("");
        fieldTotal3.setText("");
        fieldAmount3.setText("");
        fieldPeriod3.setText("");
        fieldTasa3.setText("");
        fieldSurcharge3.setText("");
        fieldAmountPerUnit3.setText("");
        fieldBarCode1.setText("");
        fieldCode1.setText("");
        fieldChannel4.setText("");
        jTextField4.setText("");
        fieldDateOfExpired4.setText("");
        fieldBarCode4.setText("");
        fieldUser4.setText("");
        fieldTotal4.setText("");
        fieldAmount4.setText("");
        fieldPeriod4.setText("");
        fieldTasa4.setText("");
        fieldSurcharge4.setText("");
        fieldBarCode4.setText("");
        fieldCode4.setText("");
        fieldAmountPerUnit4.setText("");
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
        cedulon2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        fieldDateOfExpired2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        fieldBarCode2 = new javax.swing.JTextField();
        fieldChannel2 = new javax.swing.JTextField();
        fieldUser2 = new javax.swing.JTextField();
        fieldAmount2 = new javax.swing.JTextField();
        fieldTasa2 = new javax.swing.JTextField();
        fieldSurcharge2 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        fieldPeriod2 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        fieldCode2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        fieldTotal2 = new javax.swing.JTextField();
        LabelamountPerUnit1 = new javax.swing.JLabel();
        fieldAmountPerUnit2 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        cedulon3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        fieldDateOfExpired3 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        fieldBarCode3 = new javax.swing.JTextField();
        fieldChannel3 = new javax.swing.JTextField();
        fieldUser3 = new javax.swing.JTextField();
        fieldAmount3 = new javax.swing.JTextField();
        fieldTasa3 = new javax.swing.JTextField();
        fieldSurcharge3 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        fieldPeriod3 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        fieldCode3 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        fieldTotal3 = new javax.swing.JTextField();
        LabelamountPerUnit2 = new javax.swing.JLabel();
        fieldAmountPerUnit3 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        cedulon4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        fieldDateOfExpired4 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        fieldBarCode4 = new javax.swing.JTextField();
        fieldChannel4 = new javax.swing.JTextField();
        fieldUser4 = new javax.swing.JTextField();
        fieldAmount4 = new javax.swing.JTextField();
        fieldTasa4 = new javax.swing.JTextField();
        fieldSurcharge4 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        fieldPeriod4 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        fieldCode4 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        fieldTotal4 = new javax.swing.JTextField();
        LabelamountPerUnit3 = new javax.swing.JLabel();
        fieldAmountPerUnit4 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
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

        fieldDateOfExpired1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
                .addGap(14, 14, 14)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldDateOfExpired1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDateOfExpired1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        fieldTotal1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(fieldTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(58, 58, 58)
                        .addComponent(fieldPeriod1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldSurcharge1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTasa1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        cedulon2.setBackground(new java.awt.Color(255, 255, 255));
        cedulon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setText("NOMBRE:");

        jLabel15.setText("CANAL:");

        jLabel22.setText("USUARIO:");

        jLabel26.setText("CUANTIA:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("VENCIMIENTO: ");

        fieldDateOfExpired2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldDateOfExpired2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addComponent(fieldDateOfExpired2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel33.setText("TASA:");

        jLabel34.setText("RECARGO: ");

        fieldBarCode2.setFont(new java.awt.Font("Code 39", 0, 24)); // NOI18N
        fieldBarCode2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldBarCode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBarCode2ActionPerformed(evt);
            }
        });

        fieldChannel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldChannel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldChannel2ActionPerformed(evt);
            }
        });

        fieldUser2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldAmount2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldAmount2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAmount2ActionPerformed(evt);
            }
        });

        fieldTasa2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldSurcharge2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldSurcharge2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSurcharge2ActionPerformed(evt);
            }
        });

        jLabel35.setText("Canon por uso de agua  ");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("CONSORCIO DE RIEGO ZONA SUR");

        fieldPeriod2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldPeriod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPeriod2ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel37.setText("Cedulon Informativo -  No válido como comprobante de pago");

        fieldCode2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldCode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCode2ActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("TOTAL:");

        fieldTotal2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldTotal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotal2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(fieldTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(fieldTotal2))
                .addGap(1, 1, 1))
        );

        LabelamountPerUnit1.setText("MONTO P/UNIDAD:");

        fieldAmountPerUnit2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout cedulon2Layout = new javax.swing.GroupLayout(cedulon2);
        cedulon2.setLayout(cedulon2Layout);
        cedulon2Layout.setHorizontalGroup(
            cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(fieldPeriod2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon2Layout.createSequentialGroup()
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldUser2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldChannel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelamountPerUnit1))
                                .addGap(12, 12, 12)
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldAmount2)
                                    .addComponent(fieldAmountPerUnit2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                            .addComponent(fieldBarCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cedulon2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldSurcharge2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTasa2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        cedulon2Layout.setVerticalGroup(
            cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36))
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fieldPeriod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33))
                            .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldUser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addComponent(jLabel22)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(fieldChannel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelamountPerUnit1)
                            .addComponent(fieldAmountPerUnit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addComponent(fieldTasa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(fieldSurcharge2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cedulon2Layout.createSequentialGroup()
                        .addComponent(fieldBarCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(fieldCode2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cedulon3.setBackground(new java.awt.Color(255, 255, 255));
        cedulon3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("NOMBRE:");

        jLabel16.setText("CANAL:");

        jLabel39.setText("USUARIO:");

        jLabel40.setText("CUANTIA:");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("VENCIMIENTO: ");

        fieldDateOfExpired3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldDateOfExpired3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(fieldDateOfExpired3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel42.setText("TASA:");

        jLabel43.setText("RECARGO: ");

        fieldBarCode3.setFont(new java.awt.Font("Code 39", 0, 24)); // NOI18N
        fieldBarCode3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldBarCode3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBarCode3ActionPerformed(evt);
            }
        });

        fieldChannel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldUser3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldAmount3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldTasa3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldSurcharge3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldSurcharge3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSurcharge3ActionPerformed(evt);
            }
        });

        jLabel44.setText("Canon por uso de agua  ");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("CONSORCIO DE RIEGO ZONA SUR");

        fieldPeriod3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldPeriod3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPeriod3ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel46.setText("Cedulon Informativo -  No válido como comprobante de pago");

        fieldCode3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldCode3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCode3ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("TOTAL:");

        fieldTotal3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(fieldTotal3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(fieldTotal3))
                .addGap(1, 1, 1))
        );

        LabelamountPerUnit2.setText("MONTO P/UNIDAD:");

        fieldAmountPerUnit3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout cedulon3Layout = new javax.swing.GroupLayout(cedulon3);
        cedulon3.setLayout(cedulon3Layout);
        cedulon3Layout.setHorizontalGroup(
            cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon3Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(fieldPeriod3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(cedulon3Layout.createSequentialGroup()
                        .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon3Layout.createSequentialGroup()
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldUser3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldChannel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelamountPerUnit2))
                                .addGap(12, 12, 12)
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldAmount3)
                                    .addComponent(fieldAmountPerUnit3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                            .addComponent(fieldBarCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cedulon3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldSurcharge3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTasa3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        cedulon3Layout.setVerticalGroup(
            cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel44)
                        .addComponent(jLabel45))
                    .addGroup(cedulon3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fieldPeriod3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon3Layout.createSequentialGroup()
                        .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldAmount3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42))
                            .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldUser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40))
                                .addComponent(jLabel39)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(fieldChannel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelamountPerUnit2)
                            .addComponent(fieldAmountPerUnit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon3Layout.createSequentialGroup()
                        .addComponent(fieldTasa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(fieldSurcharge3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cedulon3Layout.createSequentialGroup()
                        .addComponent(fieldBarCode3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(fieldCode3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel46)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cedulon4.setBackground(new java.awt.Color(255, 255, 255));
        cedulon4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("NOMBRE:");

        jLabel18.setText("CANAL:");

        jLabel48.setText("USUARIO:");

        jLabel49.setText("CUANTIA:");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("VENCIMIENTO: ");

        fieldDateOfExpired4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(fieldDateOfExpired4, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(fieldDateOfExpired4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel51.setText("TASA:");

        jLabel52.setText("RECARGO: ");

        fieldBarCode4.setFont(new java.awt.Font("Code 39", 0, 24)); // NOI18N
        fieldBarCode4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldBarCode4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBarCode4ActionPerformed(evt);
            }
        });

        fieldChannel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldUser4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldAmount4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldTasa4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldSurcharge4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldSurcharge4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSurcharge4ActionPerformed(evt);
            }
        });

        jLabel53.setText("Canon por uso de agua  ");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("CONSORCIO DE RIEGO ZONA SUR");

        fieldPeriod4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldPeriod4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPeriod4ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel55.setText("Cedulon Informativo -  No válido como comprobante de pago");

        fieldCode4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldCode4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCode4ActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("TOTAL:");
        jLabel56.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldTotal4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fieldTotal4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(fieldTotal4))
                .addGap(1, 1, 1))
        );

        LabelamountPerUnit3.setText("MONTO P/UNIDAD:");

        fieldAmountPerUnit4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout cedulon4Layout = new javax.swing.GroupLayout(cedulon4);
        cedulon4.setLayout(cedulon4Layout);
        cedulon4Layout.setHorizontalGroup(
            cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon4Layout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(fieldPeriod4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(cedulon4Layout.createSequentialGroup()
                        .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon4Layout.createSequentialGroup()
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldUser4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldChannel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelamountPerUnit3))
                                .addGap(12, 12, 12)
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldAmount4)
                                    .addComponent(fieldAmountPerUnit4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                            .addComponent(fieldBarCode4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCode4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cedulon4Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cedulon4Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldSurcharge4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTasa4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cedulon4Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        cedulon4Layout.setVerticalGroup(
            cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(jLabel54))
                    .addGroup(cedulon4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(fieldPeriod4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon4Layout.createSequentialGroup()
                        .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldAmount4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel51))
                            .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldUser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49))
                                .addComponent(jLabel48)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(fieldChannel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelamountPerUnit3)
                            .addComponent(fieldAmountPerUnit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon4Layout.createSequentialGroup()
                        .addComponent(fieldTasa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(fieldSurcharge4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cedulon4Layout.createSequentialGroup()
                        .addComponent(fieldBarCode4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(fieldCode4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel55)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cedulonesLayout = new javax.swing.GroupLayout(cedulones);
        cedulones.setLayout(cedulonesLayout);
        cedulonesLayout.setHorizontalGroup(
            cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulonesLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cedulon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        cedulonesLayout.setVerticalGroup(
            cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulonesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(cedulon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedulon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedulon3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedulon4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
            PrinterJob gap = PrinterJob.getPrinterJob();
            gap.setPrintable(this);
            boolean top = gap.printDialog();
            if(top)
            {
            gap.print();
            }
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,"ERROR DE PROGRAMA", "Error\n" + e, JOptionPane.INFORMATION_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void fieldBarCode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBarCode2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBarCode2ActionPerformed

    private void fieldSurcharge2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSurcharge2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSurcharge2ActionPerformed

    private void fieldPeriod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPeriod2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPeriod2ActionPerformed

    private void fieldCode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCode2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCode2ActionPerformed

    private void fieldChannel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldChannel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldChannel2ActionPerformed

    private void fieldTotal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTotal2ActionPerformed

    private void fieldAmount2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAmount2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAmount2ActionPerformed

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

    private void fieldCode3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCode3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCode3ActionPerformed

    private void fieldPeriod3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPeriod3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPeriod3ActionPerformed

    private void fieldSurcharge3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSurcharge3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSurcharge3ActionPerformed

    private void fieldBarCode3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBarCode3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBarCode3ActionPerformed

    private void fieldCode4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCode4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCode4ActionPerformed

    private void fieldPeriod4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPeriod4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPeriod4ActionPerformed

    private void fieldSurcharge4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSurcharge4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSurcharge4ActionPerformed

    private void fieldBarCode4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBarCode4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBarCode4ActionPerformed

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
    private javax.swing.JLabel LabelamountPerUnit1;
    private javax.swing.JLabel LabelamountPerUnit2;
    private javax.swing.JLabel LabelamountPerUnit3;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JPanel cedulon1;
    private javax.swing.JPanel cedulon2;
    private javax.swing.JPanel cedulon3;
    private javax.swing.JPanel cedulon4;
    private javax.swing.JPanel cedulones;
    private javax.swing.JTextField fieldAmount1;
    private javax.swing.JTextField fieldAmount2;
    private javax.swing.JTextField fieldAmount3;
    private javax.swing.JTextField fieldAmount4;
    private javax.swing.JTextField fieldAmountPerUnit1;
    private javax.swing.JTextField fieldAmountPerUnit2;
    private javax.swing.JTextField fieldAmountPerUnit3;
    private javax.swing.JTextField fieldAmountPerUnit4;
    private javax.swing.JTextField fieldBarCode1;
    private javax.swing.JTextField fieldBarCode2;
    private javax.swing.JTextField fieldBarCode3;
    private javax.swing.JTextField fieldBarCode4;
    private javax.swing.JTextField fieldChannel1;
    private javax.swing.JTextField fieldChannel2;
    private javax.swing.JTextField fieldChannel3;
    private javax.swing.JTextField fieldChannel4;
    private javax.swing.JTextField fieldCode1;
    private javax.swing.JTextField fieldCode2;
    private javax.swing.JTextField fieldCode3;
    private javax.swing.JTextField fieldCode4;
    private javax.swing.JTextField fieldDateOfExpired1;
    private javax.swing.JTextField fieldDateOfExpired2;
    private javax.swing.JTextField fieldDateOfExpired3;
    private javax.swing.JTextField fieldDateOfExpired4;
    private javax.swing.JTextField fieldPeriod1;
    private javax.swing.JTextField fieldPeriod2;
    private javax.swing.JTextField fieldPeriod3;
    private javax.swing.JTextField fieldPeriod4;
    private javax.swing.JTextField fieldSurcharge1;
    private javax.swing.JTextField fieldSurcharge2;
    private javax.swing.JTextField fieldSurcharge3;
    private javax.swing.JTextField fieldSurcharge4;
    private javax.swing.JTextField fieldTasa1;
    private javax.swing.JTextField fieldTasa2;
    private javax.swing.JTextField fieldTasa3;
    private javax.swing.JTextField fieldTasa4;
    private javax.swing.JTextField fieldTotal1;
    private javax.swing.JTextField fieldTotal2;
    private javax.swing.JTextField fieldTotal3;
    private javax.swing.JTextField fieldTotal4;
    private javax.swing.JTextField fieldUser1;
    private javax.swing.JTextField fieldUser2;
    private javax.swing.JTextField fieldUser3;
    private javax.swing.JTextField fieldUser4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
