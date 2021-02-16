package petshop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AcePC
 */
public class FMenu extends javax.swing.JFrame {

    /**
     * Creates new form FMenu
     */
    koneksi dbsetting;
    String driver,database,user,pass;
    
    public FMenu() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPasssword");
        
        gettanggal();gettimer();tampilnama();
        
        
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                int konf = JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(konf==JOptionPane.YES_OPTION){
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL2 = "SELECT * FROM `tbabsen` WHERE tanggal IN ( SELECT MAX(tanggal) FROM `tbabsen`) ORDER BY 3 DESC";
                ResultSet res = stt.executeQuery(SQL2);
                res.next();
                String data=res.getString(1);
              
                
                String SQL1 = "INSERT INTO tbabsen(username,nama,jam,tanggal,ket) VALUES "
                             +"('"+data+"','"+LNamaKasir.getText()+"','"+LJam.getText()+"','"+LTanggal.getText()+"','Keluar' )";

                stt.executeUpdate(SQL1);

                       
                        stt.close();
                        kon.close();
                        
            
                    }
                    catch(Exception ex){
                       JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            
                    }
            new FLogin().show();
            System.exit(0);
        }
                super.windowClosing(evt); //To change body of generated methods, choose Tools | Templates.
            }
            
});
        
    }
    
    public void tampilnama(){
         try{
            gettanggal();gettimer();
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL1 = "SELECT * FROM `tbabsen` WHERE tanggal IN ( SELECT MAX(tanggal) FROM `tbabsen`) ORDER BY 3 DESC";
                ResultSet res = stt.executeQuery(SQL1);
            res.next();
               LNamaKasir.setText(res.getString(2));
               String data=res.getString(1);
               jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, data, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baskerville Old Face", 0, 14)));
               
               String SQL2 = "SELECT akses FROM tblogin WHERE username='"+data+"'";
                ResultSet ress = stt.executeQuery(SQL2);
                ress.next();String akses= ress.getString(1);
                if(akses.equals("STAFF")){
                    MTambahBarang.setVisible(false);
                    MHistoryStok.setVisible(false);
                    
                    MLaporan.setVisible(false);
                    TambahPengguna.setVisible(false);
                    DataAbsen.setVisible(false);
                }
            ress.close();
            res.close();
            stt.close();
            kon.close();    
        }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
    
    public void gettanggal(){
            Date ys = new Date();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           // SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
           // SimpleDateFormat timeFormat = new SimpleDateFormat("HH : mm : ss");
            LTanggal.setText(dateFormat.format(ys));
           //TFJam.setText(timeFormat.format(ys));
           //TFTanggal1.setText(timeFormat.format(ys));
           //gettimer();
        }
      //  public class gettimer{
    public void gettimer(){
          
            ActionListener task = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nol_jam = "";
                    String nol_menit = "";
                    String nol_detik = "";
                    //Date dt = new Date();
                    java.util.Date dateTime = new java.util.Date();
                    
                    int nilai_jam = dateTime.getHours();
                    int nilai_menit = dateTime.getMinutes();
                    int nilai_detik = dateTime.getSeconds();
                    
                    if (nilai_jam<=9) nol_jam ="0";
                    if (nilai_menit<=9) nol_menit ="0";
                    if (nilai_detik<=9)nol_detik ="0";
                    
                    String jam = nol_jam + Integer.toString(nilai_jam);
                    String menit = nol_menit + Integer.toString(nilai_menit);
                    String detik = nol_detik + Integer.toString(nilai_detik);
                    
                   LJam.setText(jam+":"+ menit+":"+ detik);
                    //new Timer (1000,ta)
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
         //   new Timer(1000,task).start();
      //   new Ti*/
        new javax.swing.Timer(1000, task).start();

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
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        LNamaKasir = new javax.swing.JLabel();
        LTanggal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        LJam = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        LNamaKasir1 = new javax.swing.JLabel();
        LTanggal1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        LJam1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MTransaksi = new javax.swing.JMenu();
        MBarang = new javax.swing.JMenu();
        MTambahBarang = new javax.swing.JMenuItem();
        MStokBarang = new javax.swing.JMenuItem();
        MHistoryStok = new javax.swing.JMenuItem();
        MLaporan = new javax.swing.JMenu();
        MTambahBarang1 = new javax.swing.JMenuItem();
        MTambahBarang2 = new javax.swing.JMenuItem();
        MPengguna = new javax.swing.JMenu();
        TambahPengguna = new javax.swing.JMenuItem();
        EditPass = new javax.swing.JMenuItem();
        DataAbsen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pengguna", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baskerville Old Face", 0, 14))); // NOI18N

        LNamaKasir.setFont(new java.awt.Font("Broadway", 0, 12)); // NOI18N
        LNamaKasir.setText("NAMA KASIR");

        LTanggal.setFont(new java.awt.Font("Broadway", 0, 12)); // NOI18N
        LTanggal.setText("yyyy-MM-dd");

        LJam.setFont(new java.awt.Font("Broadway", 0, 12)); // NOI18N
        LJam.setText("00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator4)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNamaKasir, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(LTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LJam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(LNamaKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LJam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Snap ITC", 0, 36)); // NOI18N
        jLabel1.setText("PETSHOP~");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROLAN - 3\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Baskerville Old Face", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(153, 153, 153));
        jPanel4.setFocusTraversalPolicyProvider(true);

        LNamaKasir1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        LNamaKasir1.setForeground(new java.awt.Color(153, 153, 153));
        LNamaKasir1.setText("10115562 - Hani Alfiyyah Nurulhuda");

        LTanggal1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        LTanggal1.setForeground(new java.awt.Color(153, 153, 153));
        LTanggal1.setText("10115322 - Sinta Septining");

        LJam1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        LJam1.setForeground(new java.awt.Color(153, 153, 153));
        LJam1.setText("10115568 - Siska Rizki Amalia");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator5)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNamaKasir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LTanggal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LJam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(LNamaKasir1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LTanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LJam1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 36)); // NOI18N
        jLabel2.setText("Aplikasi Penjualan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        MTransaksi.setText("Transaksi");
        MTransaksi.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        MTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MTransaksiMouseClicked(evt);
            }
        });
        jMenuBar1.add(MTransaksi);

        MBarang.setText("Barang");
        MBarang.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        MTambahBarang.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        MTambahBarang.setText("Tambah Barang");
        MTambahBarang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MTambahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTambahBarangActionPerformed(evt);
            }
        });
        MBarang.add(MTambahBarang);

        MStokBarang.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        MStokBarang.setText("Stok Barang");
        MStokBarang.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MStokBarangActionPerformed(evt);
            }
        });
        MBarang.add(MStokBarang);

        MHistoryStok.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        MHistoryStok.setText("History Stok");
        MHistoryStok.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MHistoryStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MHistoryStokActionPerformed(evt);
            }
        });
        MBarang.add(MHistoryStok);

        jMenuBar1.add(MBarang);

        MLaporan.setText("Laporan Transaksi");
        MLaporan.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        MLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MLaporanActionPerformed(evt);
            }
        });

        MTambahBarang1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        MTambahBarang1.setText("Data Transaksi");
        MTambahBarang1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MTambahBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTambahBarang1ActionPerformed(evt);
            }
        });
        MLaporan.add(MTambahBarang1);

        MTambahBarang2.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        MTambahBarang2.setText("Detail Transaksi");
        MTambahBarang2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MTambahBarang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTambahBarang2ActionPerformed(evt);
            }
        });
        MLaporan.add(MTambahBarang2);

        jMenuBar1.add(MLaporan);

        MPengguna.setText("Pengguna");
        MPengguna.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N

        TambahPengguna.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        TambahPengguna.setText("Tambah Pengguna");
        TambahPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPenggunaActionPerformed(evt);
            }
        });
        MPengguna.add(TambahPengguna);

        EditPass.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        EditPass.setText("Edit Pengguna");
        EditPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPassActionPerformed(evt);
            }
        });
        MPengguna.add(EditPass);

        DataAbsen.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        DataAbsen.setText("Data Absensi");
        DataAbsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataAbsenActionPerformed(evt);
            }
        });
        MPengguna.add(DataAbsen);

        jMenuBar1.add(MPengguna);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(783, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MTransaksiMouseClicked
        // TODO add your handling code here:
        FTransaksi frm = new FTransaksi();
        frm.setVisible(true);
    }//GEN-LAST:event_MTransaksiMouseClicked

    private void MTambahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTambahBarangActionPerformed
        // TODO add your handling code here:
        FTambahBarang frm = new FTambahBarang();
        frm.setVisible(true);
    }//GEN-LAST:event_MTambahBarangActionPerformed

    private void TambahPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPenggunaActionPerformed
        // TODO add your handling code here:
        FTambahPengguna frm = new FTambahPengguna();
        frm.setVisible(true);
    }//GEN-LAST:event_TambahPenggunaActionPerformed

    private void MStokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MStokBarangActionPerformed
        // TODO add your handling code here:
        FTambahStok frm = new FTambahStok();
        frm.setVisible(true);
    }//GEN-LAST:event_MStokBarangActionPerformed

    private void EditPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPassActionPerformed
        // TODO add your handling code here:
        FEditPassword frm = new FEditPassword();
        frm.setVisible(true);
    }//GEN-LAST:event_EditPassActionPerformed

    private void MHistoryStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MHistoryStokActionPerformed
        // TODO add your handling code here:
        FHistoryStok frm = new FHistoryStok();
        frm.setVisible(true);
    }//GEN-LAST:event_MHistoryStokActionPerformed

    private void DataAbsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataAbsenActionPerformed
        // TODO add your handling code here:
        FAbsensi frm = new FAbsensi();
        frm.setVisible(true);

    }//GEN-LAST:event_DataAbsenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int konf = JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(konf==JOptionPane.YES_OPTION){
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL2 = "SELECT username FROM `tbabsen` WHERE tanggal IN ( SELECT MAX(tanggal) FROM `tbabsen`) ORDER BY jam DESC";
                ResultSet res = stt.executeQuery(SQL2);
                res.next();
                String data=res.getString(1);
              
                
                String SQL1 = "INSERT INTO tbabsen(username,nama,jam,tanggal,ket) VALUES "
                             +"('"+data+"','"+LNamaKasir.getText()+"','"+LJam.getText()+"','"+LTanggal.getText()+"','Keluar' )";

                stt.executeUpdate(SQL1);

                       
                        stt.close();
                        kon.close();
                        
            
                    }
                    catch(Exception ex){
                       JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            
                    }
            new FLogin().show(); this.dispose();
        }else{
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MLaporanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_MLaporanActionPerformed

    private void MTambahBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTambahBarang1ActionPerformed
        // TODO add your handling code here:
                new FLaporanTransaksi().show(); 
    }//GEN-LAST:event_MTambahBarang1ActionPerformed

    private void MTambahBarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTambahBarang2ActionPerformed
        // TODO add your handling code here:
                new FItemTransaksi().show(); 
    }//GEN-LAST:event_MTambahBarang2ActionPerformed

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
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DataAbsen;
    private javax.swing.JMenuItem EditPass;
    private javax.swing.JLabel LJam;
    private javax.swing.JLabel LJam1;
    private javax.swing.JLabel LNamaKasir;
    private javax.swing.JLabel LNamaKasir1;
    private javax.swing.JLabel LTanggal;
    private javax.swing.JLabel LTanggal1;
    private javax.swing.JMenu MBarang;
    private javax.swing.JMenuItem MHistoryStok;
    private javax.swing.JMenu MLaporan;
    private javax.swing.JMenu MPengguna;
    private javax.swing.JMenuItem MStokBarang;
    private javax.swing.JMenuItem MTambahBarang;
    private javax.swing.JMenuItem MTambahBarang1;
    private javax.swing.JMenuItem MTambahBarang2;
    private javax.swing.JMenu MTransaksi;
    private javax.swing.JMenuItem TambahPengguna;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
