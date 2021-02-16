/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;


import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author AcePC
 */
public class FTransaksi extends javax.swing.JFrame {
     koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    int row = 0;
    private TableRowSorter rowSorter = new TableRowSorter();
    public FMenu frm = null; 
    
    
    /**
     * Creates new form frm_mata_kuliah
     */
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel(){
        return new javax.swing.table.DefaultTableModel(
                new Object[][][][]{},
                new String[] {"Kode","Nama","Harga","Stok"}
        ){
            boolean[] canEdit = new boolean[]{
                false,false,false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }
    
    private javax.swing.table.DefaultTableModel tableModel1=getDefaultTableModel1();
    private javax.swing.table.DefaultTableModel getDefaultTableModel1(){
        return new javax.swing.table.DefaultTableModel(
                new Object[][][][][]{},
                new String[] {"Kode Barang","Nama Barang","Harga","Jumlah","Total"}
        ){
            boolean[] canEdit = new boolean[]{
                false,false,false,false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }
    /**
     * Creates new form FTransaksi
     */
    
    
    public FTransaksi() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPasssword");
        
        TBelanja.setModel(tableModel1);
        settableload();
        tampilan();
        
    }
    
    private void tampilan(){
        TBarang.setModel(tableModel);
        TFCari.setDocument(new SaringKarakter().getToUpperCase());
        TFCari.requestFocus();
        nofaktur();
        gettanggal();
        BEdit.setEnabled(false);
        BHapus.setEnabled(false);
        TFDiskon.setHorizontalAlignment(JTextField.RIGHT);
        TFDiskon.setText("0");TFBayar.setText("");
        LTotal.setText("Rp. 0,00-");
        LTotalBayar.setText("Rp. 0,00-");
        LKembali.setText("Rp. 0,00-");
        LItem.setText("0");
    //    EnableFalse();
        sistemcari();
    }
    
    public String filter(String text){
            String res;
            int len=0, i =0;
            boolean isDigit;
            
            char[] data = text.toCharArray();
            while (i<data.length){
                isDigit = Character.isDigit(data[i]);
                if (isDigit==true){
                    data[len]=data[i];
                    len++;
                }
                i++;
            }
            
            StringBuffer strBuf = new StringBuffer();
            strBuf.append(data, 0, len);
            
            return strBuf.toString();
        }
    public String format2(double nilai){
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getNumberInstance();
      //  DecimalFormat kurs = new DecimalFormat("###");
        DecimalFormatSymbols formatRP = new DecimalFormatSymbols();
        formatRP.setCurrencySymbol("Rp. ");
        
        formatRP.setGroupingSeparator(',');
        kurs.setDecimalFormatSymbols(formatRP);
        return kurs.format(nilai);
        }
        
    
    private void settableload(){
        String stat = "";
        String data[] = new String[4];
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select kode,nama,harga_jual,jumlah from tbbarang";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                data[0]= res.getString(1);
                data[1]= res.getString(2);
                data[2]= res.getString(3);
                data[3]= res.getString(4);
                
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TFCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBarang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LTotal = new javax.swing.JLabel();
        TFDiskon = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        LTotalBayar = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TFBayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        LKembali = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBelanja = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LNoFaktur = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LDate = new javax.swing.JLabel();
        LItem = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BHapus = new javax.swing.JButton();
        BEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jLabel12.setText("TRANSAKSI PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel1.setText("Cari Kode/Nama Barang");

        TFCari.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N

        TBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBarang);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baskerville Old Face", 1, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel10.setText("Total              :");

        LTotal.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        LTotal.setForeground(new java.awt.Color(255, 0, 51));
        LTotal.setText("0");

        TFDiskon.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        TFDiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFDiskonActionPerformed(evt);
            }
        });
        TFDiskon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFDiskonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFDiskonKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel13.setText("Total Bayar    :");

        LTotalBayar.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        LTotalBayar.setForeground(new java.awt.Color(255, 0, 51));
        LTotalBayar.setText("0");

        jLabel15.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel15.setText("Dibayar          :");

        TFBayar.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        TFBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFBayarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFBayarKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel16.setText("Diskon           :");

        jButton1.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jButton1.setText("Bayar Sekarang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel17.setText("Kembalian     :");

        LKembali.setFont(new java.awt.Font("Calisto MT", 0, 36)); // NOI18N
        LKembali.setForeground(new java.awt.Color(204, 204, 204));
        LKembali.setText("0");

        jButton2.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jButton2.setText("Batalkan Transaksi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LTotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(TFDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LTotalBayar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TFBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LKembali))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(LTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(TFBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Keranjang Belanja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baskerville Old Face", 1, 14))); // NOI18N

        TBelanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBelanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBelanjaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBelanja);

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jLabel2.setText("No Transaksi");

        LNoFaktur.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        LNoFaktur.setForeground(new java.awt.Color(255, 0, 51));
        LNoFaktur.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal Pembelian");

        LDate.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        LDate.setForeground(new java.awt.Color(255, 0, 51));
        LDate.setText("-");

        LItem.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        LItem.setForeground(new java.awt.Color(255, 0, 51));
        LItem.setText("0");

        jLabel7.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jLabel7.setText("Item");

        BHapus.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        BHapus.setText("Hapus");
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        BEdit.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        BEdit.setText("Kurang / Tambah Jumlah Item");
        BEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(BEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LNoFaktur)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(LItem)
                        .addGap(22, 22, 22))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BEdit, BHapus});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LNoFaktur)
                    .addComponent(jLabel4)
                    .addComponent(LDate)
                    .addComponent(jLabel7)
                    .addComponent(LItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BEdit, BHapus});

        jLabel5.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jLabel5.setText("*) Klik 2x Untuk Memasukan Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFCari, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(TFCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(999, 563));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBarangMouseClicked
        // TODO add your handling code here:
        BEdit.setEnabled(false);BHapus.setEnabled(false);
        
        String data[] = new String[5];
//        int row = TBelanja.getRowCount();
        int row = TBarang.getSelectedRow();
        String a = (String) TBarang.getValueAt(row, 2);
        String b = (String) TBarang.getValueAt(row, 3);
        if (evt.getClickCount()==2){
            
               JTextField tx = new JTextField();
         tx.setDocument(new SaringKarakter().getsNumber());
         int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Jumlah Pembelian",tx}, "Jumlah Beli", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
         if(gnt==JOptionPane.OK_OPTION){
             String input = new String(tx.getText());
         
            int aa = Integer.parseInt(input);
            int bb = Integer.parseInt(b);
            if(!(aa>bb)){
                int jml = Integer.parseInt(input);
                int hrg = Integer.parseInt(a);
                int tot = jml*hrg;

                data[0]= (String) TBarang.getValueAt(row,0);
                data[1]= (String) TBarang.getValueAt(row,1);
                data[2]= (String) TBarang.getValueAt(row,2);
                data[3]= input;
                data[4]= String.valueOf(tot);
                tableModel1.insertRow(0, data);
                int kurang  = bb-aa;
               
                tableModel.setValueAt(String.valueOf(kurang), row, 3);
            }
            else{
                JOptionPane.showMessageDialog(null, "STOK KURANG", "WARNING!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            hitung();
            
        }
        }
            
        
    }//GEN-LAST:event_TBarangMouseClicked

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        // TODO add your handling code here:
        String data[] = new String[4];
        int row = TBelanja.getSelectedRow();
        String nil = (String) TBelanja.getValueAt(row,0);
        String jml = (String) TBelanja.getValueAt(row, 3);
        int jumBelanja = Integer.parseInt(jml);
        for(int a = 0;a<TBarang.getRowCount();a++){
            String val = (String) TBarang.getValueAt(a, 0);
            String jum = (String) TBarang.getValueAt(a, 3);
            int jumBrng= Integer.parseInt(jum);
            if(nil.equals(val)){
                int jumlah = jumBelanja+jumBrng;
                data[0]=(String) TBelanja.getValueAt(row, 0);
                data[1]=(String) TBelanja.getValueAt(row, 1);
                data[2]=(String) TBelanja.getValueAt(row, 2);
                data[3]=String.valueOf(jumlah);
                tableModel.removeRow(a);
                tableModel.insertRow(a, data);
                tableModel1.removeRow(row);
                
                hitung();
            }
            
        }
        
    }//GEN-LAST:event_BHapusActionPerformed

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        // TODO add your handling code here:
        String data[] = new String[4];
        int row = TBelanja.getSelectedRow();
        String nil = (String) TBelanja.getValueAt(row, 0);
         String jml = (String) TBelanja.getValueAt(row, 3);
         int jumBelanja = Integer.parseInt(jml);
            JTextField tx = new JTextField();
         tx.setDocument(new SaringKarakter().getsNumber());
         int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Jumlah Seharusanya",tx}, "Ubah Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
         if(gnt==JOptionPane.OK_OPTION){
             String input = new String(tx.getText());
         
         int jumInput = Integer.parseInt(input);
        for(int a = 0;a<TBarang.getRowCount();a++){
            String val = (String) TBarang.getValueAt(a, 0);
            String jum = (String) TBarang.getValueAt(a, 3);
            int jumBrng= Integer.parseInt(jum);
            if(nil.equals(val)){
                int jumlah = jumBelanja-jumInput+jumBrng;
                if(!(jumlah<0)){
                data[0]=(String) TBelanja.getValueAt(row, 0);
                data[1]=(String) TBelanja.getValueAt(row, 1);
                data[2]=(String) TBelanja.getValueAt(row, 2);
                data[3]=String.valueOf(jumlah);
                tableModel.removeRow(a);
                tableModel.insertRow(a, data);
                tableModel1.setValueAt(input, row, 3);
                
                String harga = (String) TBelanja.getValueAt(row, 2);
                int inharga = Integer.parseInt(harga);
                int tot = inharga* jumInput;
                tableModel1.setValueAt(tot, row, 4);
                hitung();
                }else{
                JOptionPane.showMessageDialog(null, "STOK KURANG", "WARNING!", JOptionPane.INFORMATION_MESSAGE);
            }
            
                
            }
        }
        }
        
        
    }//GEN-LAST:event_BEditActionPerformed

    private void TBelanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBelanjaMouseClicked
        // TODO add your handling code here:
        BHapus.setEnabled(true);
        BEdit.setEnabled(true);
        if (evt.getClickCount()==2){
            String data[] = new String[4];
        int row = TBelanja.getSelectedRow();
        String nil = (String) TBelanja.getValueAt(row, 0);
         String jml = (String) TBelanja.getValueAt(row, 3);
         int jumBelanja = Integer.parseInt(jml);
         
         JTextField tx = new JTextField();
         tx.setDocument(new SaringKarakter().getsNumber());
         int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Jumlah Seharusanya",tx}, "Ubah Data", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
         if(gnt==JOptionPane.OK_OPTION){
         String input = new String(tx.getText());
            int jumInput = Integer.parseInt(input);
        for(int a = 0;a<TBarang.getRowCount();a++){
            String val = (String) TBarang.getValueAt(a, 0);
            String jum = (String) TBarang.getValueAt(a, 3);
            int jumBrng= Integer.parseInt(jum);
            if(nil.equals(val)){
                int jumlah = jumBelanja-jumInput+jumBrng;
                if(!(jumlah<0)){
                data[0]=(String) TBelanja.getValueAt(row, 0);
                data[1]=(String) TBelanja.getValueAt(row, 1);
                data[2]=(String) TBelanja.getValueAt(row, 2);
                data[3]=String.valueOf(jumlah);
                tableModel.removeRow(a);
                tableModel.insertRow(a, data);
                tableModel1.setValueAt(input, row, 3);
                
                String harga = (String) TBelanja.getValueAt(row, 2);
                int inharga = Integer.parseInt(harga);
                int tot = inharga* jumInput;
                tableModel1.setValueAt(tot, row, 4);
                hitung();
                }else{
                JOptionPane.showMessageDialog(null, "STOK KURANG", "WARNING!", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        }
         }
        }
        
    }//GEN-LAST:event_TBelanjaMouseClicked

    private void TFDiskonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDiskonKeyReleased
        // TODO add your handling code here:
        String b;
        TFDiskon.setHorizontalAlignment(JTextField.RIGHT);
        b = TFDiskon.getText();
        if (b.isEmpty()){
            b="0";
        }
        else
        {
            b=b.replace(".", "");
            b=NumberFormat.getNumberInstance(Locale.UK).format(Double.parseDouble(b));
            b=b.replace(",", ".");
        }
        TFDiskon.setText(b);
        double diskon = Double.valueOf(filter(TFDiskon.getText()));
        double total  = Double.valueOf(filter(LTotal.getText()));
        double subtot = total-diskon;
        LTotalBayar.setText("Rp. "+format2(subtot));
        
    }//GEN-LAST:event_TFDiskonKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if((TFBayar.getText().isEmpty())|| TBelanja.getRowCount()==0 ){
            JOptionPane.showMessageDialog(null, "Silahkan Bayar Terlebih Dahulu");
            TFBayar.requestFocus();
        }
        else if(Integer.parseInt(filter(TFBayar.getText()))<Integer.parseInt(filter(LTotalBayar.getText()))){
            JOptionPane.showMessageDialog(null, "Pembayaran Anda Kurang");
            TFBayar.requestFocus();
        }
        else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL1 = "SELECT * FROM `tbabsen` WHERE tanggal IN ( SELECT MAX(tanggal) FROM `tbabsen`) ORDER BY 2 DESC";
                ResultSet res = stt.executeQuery(SQL1);
                res.next();
                String data= res.getString(1);
                
                String SQL = "INSERT INTO tbtransaksi(nofaktur,tanggal,item,total,diskon,total_bayar,dibayar,kembali,kasir) "
                             + "VALUES "
                            + "('"+LNoFaktur.getText()+"',"
                            + "'"+LDate.getText()+"',"
                            + "'"+LItem.getText()+"',"
                            + "'"+filter(LTotal.getText())+"',"
                            + "'"+filter(TFDiskon.getText())+"',"
                            + "'"+filter(LTotalBayar.getText())+"',"
                            + "'"+filter(TFBayar.getText())+"',"
                            + "'"+filter(LKembali.getText())+"',"
                            + "'"+data+"')";
                stt.executeUpdate(SQL);
                
                stt.close();
                kon.close();
                tambahitem();
                
                int konfirmasi=JOptionPane.showConfirmDialog(null, "Transaksi Berhasil \n Ttransaksi Lagi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                
                if(konfirmasi==JOptionPane.YES_OPTION){
                   tampilan();
                   int row = TBelanja.getRowCount();
                   for(int a = 0; a<row;a++){
                       tableModel1.removeRow(0);
                   }
                   
                }
                else{
                    this.dispose();
                }
                
                
            }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
          //  TFNamaBrg.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBayarKeyReleased
        // TODO add your handling code here:t
        String b;
        TFBayar.setHorizontalAlignment(JTextField.RIGHT);
        b = TFBayar.getText();
        if (b.isEmpty()){
            b="0";
        }
        else
        {
            b=b.replace(".", "");
            b=NumberFormat.getNumberInstance(Locale.UK).format(Double.parseDouble(b));
            b=b.replace(",", ".");
        }
        TFBayar.setText(b);
        double bayar = Double.valueOf(filter(TFBayar.getText()));
        double total  = Double.valueOf(filter(LTotalBayar.getText()));
        double subtot = bayar-total;
        LKembali.setText("Rp. "+format2(subtot));
        
    }//GEN-LAST:event_TFBayarKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String data[] = new String[4];
        int ro = TBelanja.getRowCount();
        while(ro!=0){
        for (int row=0;row<ro;row++){
        String nil = (String) TBelanja.getValueAt(row,0);
        String jml = (String) TBelanja.getValueAt(row,3);
        int jumBelanja = Integer.parseInt(jml);
        for(int a = 0;a<TBarang.getRowCount();a++){
            String val = (String) TBarang.getValueAt(a, 0);
            String jum = (String) TBarang.getValueAt(a, 3);
            int jumBrng= Integer.parseInt(jum);
            
            if(nil.equals(val)){
                int jumlah = jumBelanja+jumBrng;
                data[0]=(String) TBelanja.getValueAt(row, 0);
                data[1]=(String) TBelanja.getValueAt(row, 1);
                data[2]=(String) TBelanja.getValueAt(row, 2);
                data[3]=String.valueOf(jumlah);
                tableModel.removeRow(a);
                tableModel.insertRow(a, data);
                tableModel1.removeRow(row);
                
                hitung();
            }
            
        }
        }
        }
        tampilan();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TFDiskonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDiskonKeyTyped
        // TODO add your handling code here:
                char karakter = evt.getKeyChar();
        if(!(((karakter>='0') && (karakter <= '9') || karakter == KeyEvent.VK_BACK_SPACE || (karakter == KeyEvent.VK_DELETE)|| karakter==KeyEvent.VK_ENTER))){
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_TFDiskonKeyTyped

    private void TFBayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFBayarKeyTyped
        // TODO add your handling code here:
                char karakter = evt.getKeyChar();
               
        if(!(((karakter>='0') && (karakter <= '9') || karakter == KeyEvent.VK_BACK_SPACE || (karakter == KeyEvent.VK_DELETE)|| karakter==KeyEvent.VK_ENTER))){
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_TFBayarKeyTyped

    private void TFDiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFDiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFDiskonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEdit;
    private javax.swing.JButton BHapus;
    private javax.swing.JLabel LDate;
    private javax.swing.JLabel LItem;
    private javax.swing.JLabel LKembali;
    private javax.swing.JLabel LNoFaktur;
    private javax.swing.JLabel LTotal;
    private javax.swing.JLabel LTotalBayar;
    private javax.swing.JTable TBarang;
    private javax.swing.JTable TBelanja;
    private javax.swing.JTextField TFBayar;
    private javax.swing.JTextField TFCari;
    private javax.swing.JTextField TFDiskon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables

 public double subtotal(int kolom){
      //   int row = 0;
         double total = 0;
        int row = TBelanja.getRowCount();
       
        if (row!=0){
        for (int rows=0; rows < row;rows++){
            Object value = TBelanja.getValueAt(rows, (int) kolom);
            // String val = String.valueOf(value);
            
            String n = String.valueOf(value);
            double nilai = Double.valueOf(n);
            total = nilai+total; 
            
           }
        
        }return total;
}
 
 private void nofaktur(){
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "SELECT MAX(RIGHT(nofaktur,7)) AS NO FROM tbtransaksi";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                if(res.first()==false){
                    LNoFaktur.setText("NF0000001");
                }
                else{
                    res.last();
                    int auto = res.getInt(1)+1;
                    String no = String.valueOf(auto);
                    int noLong = no.length();
                    for(int a=0;a<7-noLong;a++){
                        no = "0"+no;
                    }
                    LNoFaktur.setText("NF"+no);
                }
            
            }
            res.close();
            stt.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
 public void gettanggal(){
            Date ys = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LDate.setText(dateFormat.format(ys));
            
           }
 
 public void hitung(){
       
        Double a = subtotal(4);
        LTotal.setText("Rp.  "+format2(a));
        LTotalBayar.setText("Rp.  "+format2(a));
        LItem.setText(String.valueOf(TBelanja.getRowCount()));
        
 }
 
 public void updatestok(){
    try{
    Class.forName(driver);
    Connection kon = DriverManager.getConnection(database,user,pass);
    Statement stt = kon.createStatement();
    int i=0;
    while(i<TBelanja.getRowCount()){
    
    i++;
    }
    }
    catch(Exception e){
        
    }
 }
 
   public void tambahitem(){
        try{
                int row =0;
                while(row<TBelanja.getRowCount()){
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO tbitemtransaksi(nofaktur,kode,nama,harga,jumlah,total) "
                             + "VALUES "
                            + "('"+LNoFaktur.getText()+"',"
                            + "'"+TBelanja.getValueAt(row, 0)+"',"
                            + "'"+TBelanja.getValueAt(row, 1)+"',"
                            + "'"+TBelanja.getValueAt(row, 2)+"',"
                            + "'"+TBelanja.getValueAt(row, 3)+"',"
                            + "'"+TBelanja.getValueAt(row, 4)+"') ;";
                        
                stt.executeUpdate(SQL);
                String SQL1 = "UPDATE tbbarang SET jumlah = jumlah-"
                            + ""+Integer.parseInt((String) TBelanja.getValueAt(row, 3))+" WHERE "
                            + " kode = '"+TBelanja.getValueAt(row, 0)+"' ;";
                stt.executeUpdate(SQL1);
                
                row++;
                stt.close();
                kon.close();
                
                }
            }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
           // TFNamaBrg.requestFocus();
            }
    }
  
  public void sistemcari(){
      rowSorter = new TableRowSorter(tableModel);
        TBarang.setRowSorter(rowSorter);
 
        TFCari.getDocument().addDocumentListener(new DocumentListener() {
 
         
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String filter = TFCari.getText();
                if (filter == null) {
                    rowSorter.setRowFilter(RowFilter.regexFilter(null));
                } else {
                    char[] charArray = filter.toCharArray();
                    String[] stringArray = new String[charArray.length];
 
                    for (int i = 0; i < stringArray.length; i++) {
                        stringArray[i] = "[" + Character.toUpperCase(charArray[i])
                                + Character.toLowerCase(charArray[i]) + "]";
                    }
 
                    String regex = "";
                    for (String string : stringArray) {
                        regex += string;
                    }
 
                    try {
                        rowSorter.setRowFilter(RowFilter.regexFilter(regex));
                    } catch (PatternSyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
}
 }

