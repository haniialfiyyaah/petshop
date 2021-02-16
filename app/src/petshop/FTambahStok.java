/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AcePC
 */
public class FTambahStok extends javax.swing.JFrame {
 koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    /**
     * Creates new form FTambahStok
     */
    Vector list = new Vector();
    public FTambahStok() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPasssword");
        
        tampilan();getMenu();
    }
    
    public void tampilan(){
        gettanggal();gettimer();
        LKode.setText("");
        LNama.setText("");
        LTanggalBeli.setText("");
        LHargaBeli.setText("");
        LHargaJual.setText("");
        LSisaStok.setText("");
        TFStok.setText("");
        TFStok.setEnabled(false);
        CBKode.setSelectedItem("");
        CBKode.requestFocus();
        BTambah.setEnabled(false);
    }
    
        public class menukode extends KeyAdapter{
        JComboBox comboBox;
        Vector list;
        
        public menukode(JComboBox comboBox, Vector list){
            this.comboBox = comboBox;
            this.list= list;
        }

        @Override
        public void keyTyped(final KeyEvent e) {
            EventQueue.invokeLater(new Runnable() {
                @SuppressWarnings("unchecked")
                @Override
                public void run() {
                    String text=((JTextField)e.getSource()).getText().toUpperCase();
                    comboBox.setModel(new DefaultComboBoxModel(getFilteredList(text)));
                    comboBox.setSelectedIndex(-1);
                    ((JTextField) comboBox.getEditor().getEditorComponent()).setText(text);
                    //comboBox.showPopup();
                    if (e.getKeyCode()==KeyEvent.VK_ENTER){
                        CBKode.hidePopup();
                        
                    }
                   // comboBox.hidePopup();
                }

                private Vector getFilteredList(String text) {
                    Vector listResult = new Vector();
                    for (int i = 0;i<list.size();i++){
                        if(list.get(i).toString().startsWith(text)){
                            listResult.add(list.get(i).toString());
                        }
                    }
                    //comboBox.hidePopup();
                return listResult;
                }
                
            });
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                comboBox.hidePopup();
                gettext();
                BTambah.setEnabled(true);
                TFStok.setEnabled(true);
                TFStok.requestFocus();
            }
           // super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
        }
   
    }
        public void getMenu(){
        setM();
      //  CBKode = new JComboBox();
        CBKode.setModel(new DefaultComboBoxModel(list));
        CBKode.setSelectedIndex(-1);
        CBKode.setEditable(true);
        JTextField textField= (JTextField) CBKode.getEditor().getEditorComponent();
        textField.setFocusable(true);
        textField.setText("");
        textField.addKeyListener(new menukode(CBKode, list));
        
    }
        public void setM(){
            String stat = "";
        String data[] = new String[4];
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select kode from tbbarang";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()){
                        data[0]= res.getString(1);
                        list.add(data[0]);
            }
            
            res.close();
            stt.close();
            kon.close();
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
            
            
     }
        
         public void gettext(){
             try{
                 String data[] = new String[6];
                  String item = (String) CBKode.getSelectedItem();
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "SELECT kode,nama,tanggal,harga_jual,harga_beli,jumlah FROM tbbarang";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0]= res.getString(1);
                data[1]= res.getString(2);
                data[2]= res.getString(3);
                data[3]= res.getString(4);
                data[4]= res.getString(5);
                data[5]= res.getString(6);
                
                    
                if(item.equals(data[0])){
                    LKode.setText(data[0]);
                    LNama.setText(data[1]);
                    LTanggalBeli.setText(data[2]);
                    LHargaBeli.setText(data[3]);
                    LHargaJual.setText(data[4]);
                    LSisaStok.setText(data[5]);
                    
                }
            
            }
            res.close();
            stt.close();
        }
        catch(Exception ex){
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
        jLabel2 = new javax.swing.JLabel();
        CBKode = new javax.swing.JComboBox<String>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LKode = new javax.swing.JLabel();
        LNama = new javax.swing.JLabel();
        LTanggalBeli = new javax.swing.JLabel();
        LHargaJual = new javax.swing.JLabel();
        LHargaBeli = new javax.swing.JLabel();
        LSisaStok = new javax.swing.JLabel();
        TFStok = new javax.swing.JTextField();
        LKode6 = new javax.swing.JLabel();
        BTambah = new javax.swing.JButton();
        BCari = new javax.swing.JButton();
        LTanggal = new javax.swing.JLabel();
        LJam = new javax.swing.JLabel();
        BClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(461, 104));

        jLabel12.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jLabel12.setText("Tambah Stok Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jLabel2.setText("Cari Berdasarkan Kode Barang");

        CBKode.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        CBKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBKodeActionPerformed(evt);
            }
        });
        CBKode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBKodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CBKodeKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calisto MT", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel1.setText("Kode Barang");

        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel3.setText("Nama Barang");

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal Beli");

        jLabel5.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel5.setText("Harga Beli");

        jLabel6.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel6.setText("Sisa Stok");

        jLabel7.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        jLabel7.setText("Harga Jual");

        LKode.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LKode.setForeground(new java.awt.Color(51, 51, 51));

        LNama.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LNama.setForeground(new java.awt.Color(51, 51, 51));

        LTanggalBeli.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LTanggalBeli.setForeground(new java.awt.Color(51, 51, 51));

        LHargaJual.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LHargaJual.setForeground(new java.awt.Color(51, 51, 51));

        LHargaBeli.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LHargaBeli.setForeground(new java.awt.Color(51, 51, 51));

        LSisaStok.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LSisaStok.setForeground(new java.awt.Color(255, 51, 51));

        TFStok.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        TFStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFStokKeyTyped(evt);
            }
        });

        LKode6.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LKode6.setText("+");

        BTambah.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BTambah.setText("TAMBAH STOK");
        BTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(LKode, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LNama, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LTanggalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LSisaStok, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LKode6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFStok))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LKode, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNama, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LTanggalBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LSisaStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(TFStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LKode6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BCari.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BCari.setText("OK");
        BCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariActionPerformed(evt);
            }
        });

        LTanggal.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LTanggal.setForeground(new java.awt.Color(153, 153, 153));
        LTanggal.setText("yyyy-MM-dd");

        LJam.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        LJam.setForeground(new java.awt.Color(153, 153, 153));
        LJam.setText("00:00:00");

        BClear.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BClear.setText("CLEAR");
        BClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LTanggal))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CBKode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LJam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBKode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LJam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(614, 381));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CBKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBKodeActionPerformed

    private void CBKodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBKodeKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_CBKodeKeyPressed

    private void CBKodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBKodeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CBKodeKeyTyped

    private void BCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariActionPerformed
        // TODO add your handling code here:
        gettext();
        BTambah.setEnabled(true);
        TFStok.setEnabled(true);
        TFStok.requestFocus();
    }//GEN-LAST:event_BCariActionPerformed

    private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
        // TODO add your handling code here:
        int sisa= Integer.parseInt(LSisaStok.getText());
        int tambah = Integer.parseInt(TFStok.getText());
        int hasil = sisa+tambah;
        String data[] = new String[1];
              JTextField tx = new JTextField();
         tx.setDocument(new SaringKarakter().getsNumber());
         int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Harga Beli",tx}, "Harga Beli", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
         if(gnt==JOptionPane.OK_OPTION){
             String input = new String(tx.getText());
         if(input.isEmpty()){
            TFStok.requestFocus();
        }
        else{
            int konfirmasi=JOptionPane.showConfirmDialog(null, "Tambah "+tambah+" Stok?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if(konfirmasi==JOptionPane.YES_OPTION)
            {
                if((TFStok.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null, "Masukan Jumlah yang Akan Ditambahkan");
                    TFStok.requestFocus();
                }
                else{
                    
                    try{
                                Class.forName(driver);
                                Connection kon = DriverManager.getConnection(database,user,pass);
                                Statement stt = kon.createStatement();
                                String SQLs = "SELECT * FROM `tbabsen` WHERE tanggal IN ( SELECT MAX(tanggal) FROM `tbabsen`) ORDER BY 2 DESC";
                ResultSet res = stt.executeQuery(SQLs);
                res.next();
                String datas= res.getString(1);
                
                                
                                String SQL1 = "INSERT INTO tbhistorystok(kode,nama,tanggal,harga_beli,jumlah,kasir) VALUES "
                                             +"('"+LKode.getText()+"','"+LNama.getText()+"','"+LTanggal.getText()+"','"+input+"','"+TFStok.getText()+"','"+datas+"' )";

                                stt.executeUpdate(SQL1);
                    
                        String SQL = "UPDATE `tbbarang` "
                                     + "SET `jumlah`='"+String.valueOf(hasil)+"'"
                                     + "WHERE "
                                     + "`kode`='"+LKode.getText()+"';";
                        stt.executeUpdate(SQL);
                        tampilan();
                        stt.close();
                        kon.close();
                    }
                    catch(Exception ex){
                        System.err.println(ex.getMessage());
                    }
                }
                JOptionPane.showMessageDialog(null, "Stok Berhasil Ditambahkan","Berhasil",JOptionPane.INFORMATION_MESSAGE);
            }
        }
         }
    }//GEN-LAST:event_BTambahActionPerformed

    private void BClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BClearActionPerformed
        // TODO add your handling code here:
        tampilan();
    }//GEN-LAST:event_BClearActionPerformed

    private void TFStokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFStokKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if(!(((karakter>='0') && (karakter <= '9') || karakter == KeyEvent.VK_BACK_SPACE || (karakter == KeyEvent.VK_DELETE)|| karakter==KeyEvent.VK_ENTER))){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TFStokKeyTyped

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
            java.util.logging.Logger.getLogger(FTambahStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTambahStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTambahStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTambahStok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTambahStok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCari;
    private javax.swing.JButton BClear;
    private javax.swing.JButton BTambah;
    private javax.swing.JComboBox<String> CBKode;
    private javax.swing.JLabel LHargaBeli;
    private javax.swing.JLabel LHargaJual;
    private javax.swing.JLabel LJam;
    private javax.swing.JLabel LKode;
    private javax.swing.JLabel LKode6;
    private javax.swing.JLabel LNama;
    private javax.swing.JLabel LSisaStok;
    private javax.swing.JLabel LTanggal;
    private javax.swing.JLabel LTanggalBeli;
    private javax.swing.JTextField TFStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables


        public void gettanggal(){
            java.util.Date ys = new java.util.Date();
            
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
      
}
