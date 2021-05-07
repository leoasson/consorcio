package Views;

import consorcio.AuxiliaryFunctions;
import consorcio.BackUpDataBase;
import consorcio.convertEgress;
import consorcio.convertIngress;
import consorcio.sentencesSql;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
/**
 *
 * @author leoas
 */
public class main extends javax.swing.JFrame {
    /**
     * Creates new form pruebaa
     */
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    BackUpDataBase bkp = new  BackUpDataBase();
    sentencesSql sensql = new  sentencesSql();
    
    public main() 
    {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/creek48m.png")));
        this.setLocationRelativeTo(null);
        jToolBar2.setFloatable(false);
    }
    
    public void addNewPayment(Ingress ingress, String [] operation)
    {
        NewPayment payments;
        payments = new NewPayment(ingress, operation);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = payments.getSize();
        payments.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(payments);
        payments.show();
    }
    
    public void addNewPayment(Ingress ingress)
    {
        NewPayment payments;
        payments = new NewPayment(ingress);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = payments.getSize();
        payments.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(payments);
        payments.show();
    }
    
    public void addNewPayment(SimpleEgressOrIngress egress, String [] operation)
    {
        NewPayment payments;
        payments = new NewPayment(egress, operation);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = payments.getSize();
        payments.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(payments);
        payments.show();
    }
    
    public void addNewPayment(SimpleEgressOrIngress egress)
    {
        NewPayment payments;
        payments = new NewPayment(egress);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = payments.getSize();
        payments.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(payments);
        payments.show();
    }
    
    
    
        public void addNewPayment(OtherEgressOrIngress ingressOregress, String [] operation)
    {
        NewPayment payments;
        payments = new NewPayment(ingressOregress, operation);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = payments.getSize();
        payments.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(payments);
        payments.show();
    }
    
    public void addNewPayment(OtherEgressOrIngress egress)
    {
        NewPayment payments;
        payments = new NewPayment(egress);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = payments.getSize();
        payments.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(payments);
        payments.show();
    }
    
    
    
    public void addNewModifyIngress(String idIngress, SearchIngress searchIngress)
    {
        Ingress ingress = new Ingress(this, idIngress, searchIngress);
        jDesktopPane1.add(ingress);
        ingress.show();
    }
    
    public void addNewModifySimpleEgressOrIngress(String id, SearchIngress tsi)
    {
        SimpleEgressOrIngress ingress = new SimpleEgressOrIngress(this, id,tsi);
        jDesktopPane1.add(ingress);
        ingress.show();
    }
    
    public void addNewModifySimpleEgressOrIngress(String id, SearchEgress tse)
    {
        SimpleEgressOrIngress egress = new SimpleEgressOrIngress(this, id,tse);
        jDesktopPane1.add(egress);
        egress.show();
    }
    
    public void addNewModifyOtherEgressOrIngress(String id, SearchOtherIngress soi)
    {
        OtherEgressOrIngress egress = new OtherEgressOrIngress(this, id, soi);
        jDesktopPane1.add(egress);
        egress.show();
    }
    
    public void addNewModifyOtherEgress(String id, SearchOtherEgress soe)
    {
        OtherEgressOrIngress egress = new OtherEgressOrIngress(this, id, soe);
        jDesktopPane1.add(egress);
        egress.show();
    }
    
    public void addSearchCedulon()
    {
        SearchCedulones cedulon= new SearchCedulones();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }  
    
    public void addSearchCedulon(GenerateCedulonWithSurcharge gc)
    {
        SearchCedulones cedulon= new SearchCedulones(gc);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }    
        
        
//    public void addSearchCedulon(Ingress pay)
//    {
//        SearchCedulones cedulon= new SearchCedulones(pay);
//        Dimension desktopSize = jDesktopPane1.getSize();
//        Dimension jInternalFrameSize = cedulon.getSize();
//        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
//        jDesktopPane1.add(cedulon);
//        cedulon.show(); 
//    }
    
    public void addSearchCedulon(DivideCedulon divide)
    {
        SearchCedulones cedulon= new SearchCedulones(divide);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }
    
    public void addSearchCedulon(PrintView print)
    {
        SearchCedulones cedulon= new SearchCedulones(print);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }
    
    public void addSearchCedulon(ModifyCedulon modifiedCedulon)
    {
        SearchCedulones cedulon= new SearchCedulones(modifiedCedulon);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }
    
    public void addSearchCedulon(Ingress Ingress)
    {
        SearchCedulones cedulon= new SearchCedulones(Ingress);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }
    
    public void addSearchLessee()
    {
        SearchLessee lessee= new SearchLessee();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = lessee.getSize();
        lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(lessee);
        lessee.show(); 
    }
    
    public void addSearchLessee(AssociateLesse al)
    {
        SearchLessee lessee= new SearchLessee(al);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = lessee.getSize();
        lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(lessee);
        lessee.show(); 
    }
        
    public void addSearchLessee(NewCensus census)
    {
        SearchLessee lessee= new SearchLessee(census);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = lessee.getSize();
        lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(lessee);
        lessee.show(); 
    }
            
    public void addSearchLessee(ModifyCensus modCensus)
    {
        SearchLessee lessee= new SearchLessee(modCensus);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = lessee.getSize();
        lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(lessee);
        lessee.show(); 
    }         
                
    public void addSearchLessee(ModifyLessee modLessee)
    {
        SearchLessee lessee= new SearchLessee(modLessee);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = lessee.getSize();
        lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(lessee);
        lessee.show(); 
    }
    
    public void addSearchPadron()
    {
        SearchPadron census = new SearchPadron();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = census.getSize();
        census.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(census);
        census.show(); 
    }

    public void addSearchPadron(AssociateLesse lessee)
    {
        SearchPadron census = new SearchPadron(lessee);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = census.getSize();
        census.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(census);
        census.show(); 
    }

    public void addSearchPadron(ModifyCensus modCensus)
    {
        SearchPadron census = new SearchPadron(modCensus);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = census.getSize();
        census.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(census);
        census.show(); 
    }

    public void addSearchPadron(DialogAssociateLessee lessee)
    {
        SearchPadron census = new SearchPadron(lessee);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = census.getSize();
        census.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(census);
        census.show(); 
    }

    public void addDialogAssociateLessee(String DNI)
    {
        DialogAssociateLessee dialog = new DialogAssociateLessee(this, DNI);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = dialog.getSize();
        dialog.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(dialog);
        dialog.show(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        searchCensus = new javax.swing.JButton();
        searchCensus1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        buttonGenerateCedulones = new javax.swing.JButton();
        searchCedulon = new javax.swing.JButton();
        buttonPrint = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        searchLessee = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        ButtonNewIngress = new javax.swing.JButton();
        ButtonNewEgress = new javax.swing.JButton();
        buttonDebt = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        censusMenu = new javax.swing.JMenu();
        registerNewCensus = new javax.swing.JMenuItem();
        modifyCensus1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ListCensus = new javax.swing.JMenuItem();
        cedulonMenu = new javax.swing.JMenu();
        generateCedulon = new javax.swing.JMenuItem();
        reprintCedulon = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        generateCedulonWithSurcharge = new javax.swing.JMenuItem();
        partitionCedulon = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        modifyCedulon1 = new javax.swing.JMenuItem();
        listCedulones = new javax.swing.JMenuItem();
        LesseeMenu = new javax.swing.JMenu();
        registerLessee = new javax.swing.JMenuItem();
        modifyLessee1 = new javax.swing.JMenuItem();
        associateLesseeCensus = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        listLessee = new javax.swing.JMenuItem();
        menuActivity1 = new javax.swing.JMenu();
        registerIncome2 = new javax.swing.JMenuItem();
        registerIncome3 = new javax.swing.JMenuItem();
        listIncome1 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        registerEgress1 = new javax.swing.JMenuItem();
        listEgress1 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        menuDebt1 = new javax.swing.JMenuItem();
        configMenu = new javax.swing.JMenu();
        generateBackup = new javax.swing.JMenuItem();
        menuActivity2 = new javax.swing.JMenu();
        registerIncome5 = new javax.swing.JMenuItem();
        listIncome2 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        registerEgress2 = new javax.swing.JMenuItem();
        listEgress2 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        add_rubro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CoriSur");
        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        searchCensus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addFile26.png"))); // NOI18N
        searchCensus.setToolTipText("Nuevo padrón");
        searchCensus.setFocusable(false);
        searchCensus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchCensus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchCensus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCensusActionPerformed(evt);
            }
        });
        jToolBar2.add(searchCensus);

        searchCensus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCensus26.png"))); // NOI18N
        searchCensus1.setToolTipText("Buscar padrón");
        searchCensus1.setFocusable(false);
        searchCensus1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchCensus1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchCensus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCensus1ActionPerformed(evt);
            }
        });
        jToolBar2.add(searchCensus1);
        jToolBar2.add(jSeparator4);

        buttonGenerateCedulones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newCedulon32.png"))); // NOI18N
        buttonGenerateCedulones.setToolTipText("Generar cedulones");
        buttonGenerateCedulones.setFocusable(false);
        buttonGenerateCedulones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonGenerateCedulones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonGenerateCedulones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateCedulonesActionPerformed(evt);
            }
        });
        jToolBar2.add(buttonGenerateCedulones);

        searchCedulon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCedulon26.png"))); // NOI18N
        searchCedulon.setToolTipText("Buscar cedulón");
        searchCedulon.setFocusable(false);
        searchCedulon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchCedulon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCedulonActionPerformed(evt);
            }
        });
        jToolBar2.add(searchCedulon);

        buttonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print26.png"))); // NOI18N
        buttonPrint.setToolTipText("Imprimir cedulones");
        buttonPrint.setAlignmentX(0.5F);
        buttonPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonPrint.setFocusable(false);
        buttonPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonPrint.setName("gfgbb"); // NOI18N
        buttonPrint.setNextFocusableComponent(ButtonNewIngress);
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });
        jToolBar2.add(buttonPrint);
        jToolBar2.add(jSeparator3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addUser26.png"))); // NOI18N
        jButton4.setToolTipText("Nuevo arrendatario");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        searchLessee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchLessee26.png"))); // NOI18N
        searchLessee.setToolTipText("Buscar arrendatario");
        searchLessee.setFocusable(false);
        searchLessee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchLessee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        searchLessee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchLesseeActionPerformed(evt);
            }
        });
        jToolBar2.add(searchLessee);
        jToolBar2.add(jSeparator5);

        ButtonNewIngress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money32.png"))); // NOI18N
        ButtonNewIngress.setToolTipText("Registrar cobro de cedulon");
        ButtonNewIngress.setAlignmentX(0.5F);
        ButtonNewIngress.setFocusable(false);
        ButtonNewIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNewIngressActionPerformed(evt);
            }
        });
        jToolBar2.add(ButtonNewIngress);

        ButtonNewEgress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outMoney32.png"))); // NOI18N
        ButtonNewEgress.setToolTipText("Registrar egreso");
        ButtonNewEgress.setAlignmentX(0.5F);
        ButtonNewEgress.setFocusable(false);
        ButtonNewEgress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonNewEgress.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonNewEgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNewEgressActionPerformed(evt);
            }
        });
        jToolBar2.add(ButtonNewEgress);

        buttonDebt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/debt26.png"))); // NOI18N
        buttonDebt.setToolTipText("Consultar deuda");
        buttonDebt.setAlignmentX(0.5F);
        buttonDebt.setFocusable(false);
        buttonDebt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDebt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDebtActionPerformed(evt);
            }
        });
        jToolBar2.add(buttonDebt);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1009, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        censusMenu.setText("Padrón");

        registerNewCensus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addFile16 .png"))); // NOI18N
        registerNewCensus.setText("Registrar nuevo padrón");
        registerNewCensus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNewCensusActionPerformed(evt);
            }
        });
        censusMenu.add(registerNewCensus);

        modifyCensus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editCensus16.png"))); // NOI18N
        modifyCensus1.setText("Modificar Padrón");
        modifyCensus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyCensus1ActionPerformed(evt);
            }
        });
        censusMenu.add(modifyCensus1);
        censusMenu.add(jSeparator2);

        ListCensus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCensus16.png"))); // NOI18N
        ListCensus.setText("Listar Padrón");
        ListCensus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListCensusActionPerformed(evt);
            }
        });
        censusMenu.add(ListCensus);

        jMenuBar1.add(censusMenu);

        cedulonMenu.setText("Cedulón");

        generateCedulon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newCedulon16.png"))); // NOI18N
        generateCedulon.setText("Generar Cedulones");
        generateCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateCedulonActionPerformed(evt);
            }
        });
        cedulonMenu.add(generateCedulon);

        reprintCedulon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/print16.png"))); // NOI18N
        reprintCedulon.setText("Reimpresión de cedulón");
        reprintCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reprintCedulonActionPerformed(evt);
            }
        });
        cedulonMenu.add(reprintCedulon);
        cedulonMenu.add(jSeparator1);

        generateCedulonWithSurcharge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/increase16.png"))); // NOI18N
        generateCedulonWithSurcharge.setText("Generar cedulón con recargo");
        generateCedulonWithSurcharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateCedulonWithSurchargeActionPerformed(evt);
            }
        });
        cedulonMenu.add(generateCedulonWithSurcharge);

        partitionCedulon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/divide16.png"))); // NOI18N
        partitionCedulon.setText("Particionar ceduón");
        partitionCedulon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partitionCedulonActionPerformed(evt);
            }
        });
        cedulonMenu.add(partitionCedulon);
        cedulonMenu.add(jSeparator7);

        modifyCedulon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editCedulon16.png"))); // NOI18N
        modifyCedulon1.setText("Modificar cedulón");
        modifyCedulon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyCedulon1ActionPerformed(evt);
            }
        });
        cedulonMenu.add(modifyCedulon1);

        listCedulones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchCedulon16.png"))); // NOI18N
        listCedulones.setText("Listar cedulones");
        listCedulones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCedulonesActionPerformed(evt);
            }
        });
        cedulonMenu.add(listCedulones);

        jMenuBar1.add(cedulonMenu);

        LesseeMenu.setText("Arrendatarios");

        registerLessee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/addUser16.png"))); // NOI18N
        registerLessee.setText("Registrar arrendatario");
        registerLessee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLesseeActionPerformed(evt);
            }
        });
        LesseeMenu.add(registerLessee);

        modifyLessee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editLessee16.png"))); // NOI18N
        modifyLessee1.setText("Modificar arrendatario");
        modifyLessee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyLessee1ActionPerformed(evt);
            }
        });
        LesseeMenu.add(modifyLessee1);

        associateLesseeCensus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/changeUser16.png"))); // NOI18N
        associateLesseeCensus.setText("Asociar arrendatario a padrón");
        associateLesseeCensus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associateLesseeCensusActionPerformed(evt);
            }
        });
        LesseeMenu.add(associateLesseeCensus);
        LesseeMenu.add(jSeparator6);

        listLessee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/searchLessee16.png"))); // NOI18N
        listLessee.setText("Listar Arrendatarios");
        listLessee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listLesseeActionPerformed(evt);
            }
        });
        LesseeMenu.add(listLessee);

        jMenuBar1.add(LesseeMenu);

        menuActivity1.setText("Movimientos");
        menuActivity1.setToolTipText("Movimientos de dinero");

        registerIncome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money16.png"))); // NOI18N
        registerIncome2.setText("Registrar cobro de cedulón");
        registerIncome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerIncome2ActionPerformed(evt);
            }
        });
        menuActivity1.add(registerIncome2);

        registerIncome3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money16.png"))); // NOI18N
        registerIncome3.setText("Registrar ingreso simple");
        registerIncome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerIncome3ActionPerformed(evt);
            }
        });
        menuActivity1.add(registerIncome3);

        listIncome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/listIncome16.png"))); // NOI18N
        listIncome1.setText("Listar Ingresos");
        listIncome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listIncome1ActionPerformed(evt);
            }
        });
        menuActivity1.add(listIncome1);
        menuActivity1.add(jSeparator10);

        registerEgress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outMoney16.png"))); // NOI18N
        registerEgress1.setText("Registrar egreso");
        registerEgress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerEgress1ActionPerformed(evt);
            }
        });
        menuActivity1.add(registerEgress1);

        listEgress1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/listOut16.png"))); // NOI18N
        listEgress1.setText("Listar egresos");
        listEgress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEgress1ActionPerformed(evt);
            }
        });
        menuActivity1.add(listEgress1);
        menuActivity1.add(jSeparator11);

        menuDebt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/debt16.png"))); // NOI18N
        menuDebt1.setText("Consultar deuda");
        menuDebt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDebt1ActionPerformed(evt);
            }
        });
        menuActivity1.add(menuDebt1);

        jMenuBar1.add(menuActivity1);

        configMenu.setText("Configuración");

        generateBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database16.png"))); // NOI18N
        generateBackup.setText("Exportar base de datos");
        generateBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBackupActionPerformed(evt);
            }
        });
        configMenu.add(generateBackup);

        jMenuBar1.add(configMenu);

        menuActivity2.setText("Otros movimientos");
        menuActivity2.setToolTipText("Movimientos de dinero");

        registerIncome5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money16.png"))); // NOI18N
        registerIncome5.setText("Registrar ingreso");
        registerIncome5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerIncome5ActionPerformed(evt);
            }
        });
        menuActivity2.add(registerIncome5);

        listIncome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/listIncome16.png"))); // NOI18N
        listIncome2.setText("Listar Ingresos");
        listIncome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listIncome2ActionPerformed(evt);
            }
        });
        menuActivity2.add(listIncome2);
        menuActivity2.add(jSeparator12);

        registerEgress2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outMoney16.png"))); // NOI18N
        registerEgress2.setText("Registrar egreso");
        registerEgress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerEgress2ActionPerformed(evt);
            }
        });
        menuActivity2.add(registerEgress2);

        listEgress2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/listOut16.png"))); // NOI18N
        listEgress2.setText("Listar egresos");
        listEgress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listEgress2ActionPerformed(evt);
            }
        });
        menuActivity2.add(listEgress2);
        menuActivity2.add(jSeparator13);

        add_rubro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/outMoney16.png"))); // NOI18N
        add_rubro.setText("Agregar rubro ");
        add_rubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_rubroActionPerformed(evt);
            }
        });
        menuActivity2.add(add_rubro);

        jMenuBar1.add(menuActivity2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonNewIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNewIngressActionPerformed
        Ingress ingress1 = new Ingress(this);
        jDesktopPane1.add(ingress1);
        ingress1.show();
    }//GEN-LAST:event_ButtonNewIngressActionPerformed

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
    PrintView cedulon= new PrintView(this);
    jDesktopPane1.add(cedulon);
    cedulon.show();
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void searchLesseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchLesseeActionPerformed
    SearchLessee lessee= new SearchLessee();
    Dimension desktopSize = jDesktopPane1.getSize();
    Dimension jInternalFrameSize = lessee.getSize();
    lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
    jDesktopPane1.add(lessee);
    lessee.show(); 
    }//GEN-LAST:event_searchLesseeActionPerformed

    private void generateCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateCedulonActionPerformed
    GenerateCedulon cedulones= new GenerateCedulon();
    jDesktopPane1.add(cedulones);
    cedulones.show();
    }//GEN-LAST:event_generateCedulonActionPerformed

    private void generateCedulonWithSurchargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateCedulonWithSurchargeActionPerformed
    GenerateCedulonWithSurcharge cedulon= new GenerateCedulonWithSurcharge(this);
    jDesktopPane1.add(cedulon);
    cedulon.show();
    }//GEN-LAST:event_generateCedulonWithSurchargeActionPerformed

    private void reprintCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reprintCedulonActionPerformed
    PrintView cedulon= new PrintView(this);
    jDesktopPane1.add(cedulon);
    cedulon.show();
    }//GEN-LAST:event_reprintCedulonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        NewLessee lessee= new NewLessee(this);
        jDesktopPane1.add(lessee);
        lessee.show();        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonGenerateCedulonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateCedulonesActionPerformed
    GenerateCedulon cedulones= new GenerateCedulon();
    jDesktopPane1.add(cedulones);
    cedulones.show();
    }//GEN-LAST:event_buttonGenerateCedulonesActionPerformed

    private void partitionCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partitionCedulonActionPerformed
        DivideCedulon divide= new DivideCedulon(this);
        jDesktopPane1.add(divide);
        divide.show();
    }//GEN-LAST:event_partitionCedulonActionPerformed

    private void registerLesseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLesseeActionPerformed
        NewLessee lessee= new NewLessee(this);
        jDesktopPane1.add(lessee);
        lessee.show(); 
    }//GEN-LAST:event_registerLesseeActionPerformed

    private void listLesseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listLesseeActionPerformed
        SearchLessee lessee= new SearchLessee();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = lessee.getSize();
        lessee.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(lessee);
        lessee.show();
    }//GEN-LAST:event_listLesseeActionPerformed

    private void associateLesseeCensusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associateLesseeCensusActionPerformed
        AssociateLesse lessee= new AssociateLesse(this);
        jDesktopPane1.add(lessee);
        lessee.show();
    }//GEN-LAST:event_associateLesseeCensusActionPerformed

    private void ListCensusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListCensusActionPerformed
        SearchPadron padron= new SearchPadron();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = padron.getSize();
        padron.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(padron);
        padron.show(); 
    }//GEN-LAST:event_ListCensusActionPerformed

    private void listCedulonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCedulonesActionPerformed
        SearchCedulones cedulon= new SearchCedulones();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show();  
    }//GEN-LAST:event_listCedulonesActionPerformed

    private void searchCensusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCensusActionPerformed
        NewCensus census = new NewCensus(this);
        jDesktopPane1.add(census);
        census.show();
    }//GEN-LAST:event_searchCensusActionPerformed

    private void searchCedulonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCedulonActionPerformed
        SearchCedulones cedulon= new SearchCedulones();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = cedulon.getSize();
        cedulon.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(cedulon);
        cedulon.show(); 
    }//GEN-LAST:event_searchCedulonActionPerformed

    private void registerNewCensusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNewCensusActionPerformed
        NewCensus census = new NewCensus(this);
        jDesktopPane1.add(census);
        census.show();
    }//GEN-LAST:event_registerNewCensusActionPerformed

    private void ButtonNewEgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNewEgressActionPerformed
        SimpleEgressOrIngress egress= new SimpleEgressOrIngress(this,2);
        jDesktopPane1.add(egress);
        egress.show();
    }//GEN-LAST:event_ButtonNewEgressActionPerformed

    private void generateBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBackupActionPerformed
        bkp.GenerarBackupMySQL();
    }//GEN-LAST:event_generateBackupActionPerformed

    private void modifyCedulon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyCedulon1ActionPerformed
        ModifyCedulon modifiedcedulon= new ModifyCedulon(this);
        jDesktopPane1.add(modifiedcedulon);
        modifiedcedulon.show();
    }//GEN-LAST:event_modifyCedulon1ActionPerformed

    private void modifyCensus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyCensus1ActionPerformed
        ModifyCensus census = new ModifyCensus(this);
        jDesktopPane1.add(census);
        census.show(); 
    }//GEN-LAST:event_modifyCensus1ActionPerformed

    private void searchCensus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCensus1ActionPerformed
        SearchPadron census = new SearchPadron();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = census.getSize();
        census.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(census);
        census.show(); 
    }//GEN-LAST:event_searchCensus1ActionPerformed

    private void modifyLessee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyLessee1ActionPerformed
        ModifyLessee modLessee = new ModifyLessee(this);
        jDesktopPane1.add(modLessee);
        modLessee.show();
    }//GEN-LAST:event_modifyLessee1ActionPerformed

    private void buttonDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDebtActionPerformed
        SearchDue due = new SearchDue();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = due.getSize();
        due.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(due);
        due.show();
    }//GEN-LAST:event_buttonDebtActionPerformed

    private void registerIncome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerIncome2ActionPerformed
        Ingress ingress1 = new Ingress(this);
        jDesktopPane1.add(ingress1);
        ingress1.show();
    }//GEN-LAST:event_registerIncome2ActionPerformed

    private void registerIncome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerIncome3ActionPerformed
        SimpleEgressOrIngress ingress= new SimpleEgressOrIngress(this,1);
        jDesktopPane1.add(ingress);
        ingress.show();
    }//GEN-LAST:event_registerIncome3ActionPerformed

    private void listIncome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listIncome1ActionPerformed
        SearchIngress ingress= new SearchIngress(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ingress.getSize();
        ingress.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ingress);
        ingress.show();
    }//GEN-LAST:event_listIncome1ActionPerformed

    private void registerEgress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerEgress1ActionPerformed
        SimpleEgressOrIngress egress= new SimpleEgressOrIngress(this,2);
        jDesktopPane1.add(egress);
        egress.show();
    }//GEN-LAST:event_registerEgress1ActionPerformed

    private void listEgress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEgress1ActionPerformed
        SearchEgress egress= new SearchEgress(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = egress.getSize();
        egress.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(egress);
        egress.show();
    }//GEN-LAST:event_listEgress1ActionPerformed

    private void menuDebt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDebt1ActionPerformed
        SearchDue due = new SearchDue();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = due.getSize();
        due.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(due);
        due.show();
    }//GEN-LAST:event_menuDebt1ActionPerformed

    private void registerIncome5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerIncome5ActionPerformed
        OtherEgressOrIngress ingress= new OtherEgressOrIngress(this,1);
        jDesktopPane1.add(ingress);
        ingress.show();
    }//GEN-LAST:event_registerIncome5ActionPerformed

    private void listIncome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listIncome2ActionPerformed
        SearchOtherIngress ingress= new SearchOtherIngress(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ingress.getSize();
        ingress.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ingress);
        ingress.show();
    }//GEN-LAST:event_listIncome2ActionPerformed

    private void registerEgress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerEgress2ActionPerformed
        OtherEgressOrIngress egress= new OtherEgressOrIngress(this,2);
        jDesktopPane1.add(egress);
        egress.show();
    }//GEN-LAST:event_registerEgress2ActionPerformed

    private void listEgress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listEgress2ActionPerformed
        SearchOtherEgress egress= new SearchOtherEgress(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = egress.getSize();
        egress.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(egress);
        egress.show();
    }//GEN-LAST:event_listEgress2ActionPerformed

    private void add_rubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_rubroActionPerformed
        AddRubro newRubro  = new AddRubro(this);
        jDesktopPane1.add(newRubro);
        newRubro.show();
    }//GEN-LAST:event_add_rubroActionPerformed
  
    /**
     * @param args the command line argum
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonNewEgress;
    private javax.swing.JButton ButtonNewIngress;
    private javax.swing.JMenu LesseeMenu;
    private javax.swing.JMenuItem ListCensus;
    private javax.swing.JMenuItem add_rubro;
    private javax.swing.JMenuItem associateLesseeCensus;
    private javax.swing.JButton buttonDebt;
    private javax.swing.JButton buttonGenerateCedulones;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JMenu cedulonMenu;
    private javax.swing.JMenu censusMenu;
    private javax.swing.JMenu configMenu;
    private javax.swing.JMenuItem generateBackup;
    private javax.swing.JMenuItem generateCedulon;
    private javax.swing.JMenuItem generateCedulonWithSurcharge;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem listCedulones;
    private javax.swing.JMenuItem listEgress1;
    private javax.swing.JMenuItem listEgress2;
    private javax.swing.JMenuItem listIncome1;
    private javax.swing.JMenuItem listIncome2;
    private javax.swing.JMenuItem listLessee;
    private javax.swing.JMenu menuActivity1;
    private javax.swing.JMenu menuActivity2;
    private javax.swing.JMenuItem menuDebt1;
    private javax.swing.JMenuItem modifyCedulon1;
    private javax.swing.JMenuItem modifyCensus1;
    private javax.swing.JMenuItem modifyLessee1;
    private javax.swing.JMenuItem partitionCedulon;
    private javax.swing.JMenuItem registerEgress1;
    private javax.swing.JMenuItem registerEgress2;
    private javax.swing.JMenuItem registerIncome2;
    private javax.swing.JMenuItem registerIncome3;
    private javax.swing.JMenuItem registerIncome5;
    private javax.swing.JMenuItem registerLessee;
    private javax.swing.JMenuItem registerNewCensus;
    private javax.swing.JMenuItem reprintCedulon;
    private javax.swing.JButton searchCedulon;
    private javax.swing.JButton searchCensus;
    private javax.swing.JButton searchCensus1;
    private javax.swing.JButton searchLessee;
    // End of variables declaration//GEN-END:variables

}
