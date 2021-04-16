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
public class PrintVoucher extends javax.swing.JFrame implements Printable {

String id;
int type;// si es 1 es un ingreso, 2 es un egreso
public boolean top;
PrinterJob gap = PrinterJob.getPrinterJob();
AuxiliaryFunctions af = new AuxiliaryFunctions();

    public PrintVoucher(String id, String date, String concept, String total, int type)
    {
        initComponents();
        this.id = id;
        this.type = type;
        gap.setPrintable(this);
        top = gap.printDialog();
        if(top)
        {
            insertValuesInVoucher(generateCompleteId(),date, concept, total);
            print_();
            clean();
        } 
    }   
    
private String generateCompleteId() 
{
    if(type == 1)
    {
        return "I"+id;
    }
    else 
    {
        return "E"+id;
    }
}
    
    
private void insertValuesInVoucher(String id, String date, String concept, String total)
{
    fieldIdentifier.setText(id);
    fieldDate.setText(date);
    fieldTotal.setText(total);
    fieldConcept.setText(remodelConcept(concept));
}
private void clean()
{
    fieldIdentifier.setText("");
    fieldDate.setText("");
    fieldTotal.setText("");
    fieldConcept.setText("");
}

private String remodelConcept(String concept)
{
    int counter = 0;
    int begin = 0;
    String newConcept = "";
    concept = concept.replaceAll("\n", " ");
    
    for (int i=0;i<concept.length();i++)
    {
        counter ++;
        if(counter>55)
        {
            if(concept.charAt(i)== ' ')
            {
                newConcept = newConcept + concept.substring(begin, i).concat("\n");
                begin = i+1;
                counter = 0;
            }
        }
    }
    newConcept = newConcept + concept.substring(begin);
    return newConcept;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        cedulones = new javax.swing.JPanel();
        cedulon1 = new javax.swing.JPanel();
        LabelConcept = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        fieldIdentifier = new javax.swing.JTextField();
        labelIdentifier = new javax.swing.JLabel();
        fieldDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldConcept = new javax.swing.JTextArea();
        labelTotal = new javax.swing.JLabel();
        fieldTotal = new javax.swing.JTextField();
        buttonPrint = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cedulones.setBackground(new java.awt.Color(255, 255, 255));
        cedulones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cedulon1.setBackground(new java.awt.Color(255, 255, 255));
        cedulon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LabelConcept.setText("CONCEPTO:");

        jLabel30.setText("Canon por uso de agua  ");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("CONSORCIO DE RIEGO ZONA SUR");

        fieldIdentifier.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelIdentifier.setText("IDENTIFICADOR:");

        fieldDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldConcept.setEditable(false);
        fieldConcept.setColumns(20);
        fieldConcept.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        fieldConcept.setRows(5);
        fieldConcept.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldConcept.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(fieldConcept);

        labelTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTotal.setText("TOTAL:");
        labelTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fieldTotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldTotal.setPreferredSize(new java.awt.Dimension(2, 20));

        javax.swing.GroupLayout cedulon1Layout = new javax.swing.GroupLayout(cedulon1);
        cedulon1.setLayout(cedulon1Layout);
        cedulon1Layout.setHorizontalGroup(
            cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelConcept, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(labelIdentifier)
                                .addGap(18, 18, 18)
                                .addComponent(fieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        cedulon1Layout.setVerticalGroup(
            cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addComponent(LabelConcept, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdentifier)
                            .addComponent(fieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cedulon1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(fieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout cedulonesLayout = new javax.swing.GroupLayout(cedulones);
        cedulones.setLayout(cedulonesLayout);
        cedulonesLayout.setHorizontalGroup(
            cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulonesLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(cedulon1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        cedulonesLayout.setVerticalGroup(
            cedulonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulonesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(cedulon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(653, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
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
    
 private void print_(){                                            
    try
        {
            gap.print();
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el archivo. Asegurese que no este abierto.", "Error\n" + e, JOptionPane.INFORMATION_MESSAGE);
        }        // TODO add your handling code here:
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelConcept;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JPanel cedulon1;
    private javax.swing.JPanel cedulones;
    private javax.swing.JTextArea fieldConcept;
    private javax.swing.JTextField fieldDate;
    private javax.swing.JTextField fieldIdentifier;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelIdentifier;
    private javax.swing.JLabel labelTotal;
    // End of variables declaration//GEN-END:variables
}
