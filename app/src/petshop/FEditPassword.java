/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author AcePC
 */
public class FEditPassword extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    String data[]=new String[4];
        
    /**
     * Creates new form FEditPassword
     */
    public FEditPassword() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPasssword");
        BGantiNama.setEnabled(false);
        BGantiPass.setEnabled(false);
        BGantiUser.setEnabled(false);
        BLogout.setEnabled(false);
        TFUsername.setDocument(new SaringKarakter().getToUpperCase());
        TFUsername.requestFocus();
        
    }
    
    private void login(){
        String stat = "";
        String nama = TFUsername.getText();
        String pas = TFPassword.getText();
            
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "SELECT nama,username,password,akses FROM `tblogin` WHERE "
                            + "`USERNAME` = '"+nama+"'";
            ResultSet res = stt.executeQuery(SQL);
            if (res.next()){
                data[0]=res.getString(1);
                data[1]=res.getString(2);
                data[2]=res.getString(3);
                data[3]=res.getString(4);
                if(pas.equals(res.getString("password"))){
                    LNama.setText(data[0]);
                    LUsername.setText(data[1]);
                    LPassword.setText("* * * * * * * *");
                    LAkses.setText(data[3]);
                    
                    BGantiNama.setEnabled(true);
                    BGantiPass.setEnabled(true);
                    BGantiUser.setEnabled(true);
                    BLogout.setEnabled(true);
                    BLogin.setEnabled(false);
                    TFUsername.setEnabled(false);
                    TFPassword.setEnabled(false);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Password Salah, Silahkan Ulangi");
                    TFPassword.setText("");
                    TFPassword.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "User tidak ditemukan");
                TFUsername.setText("");
                TFPassword.setText("");
                TFUsername.requestFocus();
            }
            
            res.close();
            stt.close();
            kon.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "GAGAL! Database Tidak Ditemukan!");
            
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
        TFUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BLogin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LabelNama = new javax.swing.JLabel();
        LNama = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LabelUser = new javax.swing.JLabel();
        LUsername = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        LabelPass = new javax.swing.JLabel();
        LPassword = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        LabelAkses = new javax.swing.JLabel();
        LAkses = new javax.swing.JLabel();
        BGantiNama = new javax.swing.JButton();
        BGantiUser = new javax.swing.JButton();
        BGantiPass = new javax.swing.JButton();
        BLogout = new javax.swing.JButton();
        TFPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(461, 104));

        jLabel12.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jLabel12.setText("Edit Pengguna");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap())
        );

        TFUsername.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N
        TFUsername.setNextFocusableComponent(TFPassword);

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel2.setText("Masukan Pasword");

        BLogin.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        BLogin.setText("IN");
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelNama.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelNama.setForeground(new java.awt.Color(153, 153, 153));
        LabelNama.setText("Nama");

        LNama.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LNama, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelNama)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        jLabel3.setText("Masukan Username");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelUser.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(153, 153, 153));
        LabelUser.setText("Username");

        LUsername.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(LabelUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelPass.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelPass.setForeground(new java.awt.Color(153, 153, 153));
        LabelPass.setText("Pasword");

        LPassword.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelPass, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(LabelPass)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        LabelAkses.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        LabelAkses.setForeground(new java.awt.Color(153, 153, 153));
        LabelAkses.setText("Akses");

        LAkses.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelAkses, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LAkses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(LabelAkses)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(LAkses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        BGantiNama.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BGantiNama.setText("Ganti Nama");
        BGantiNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGantiNamaActionPerformed(evt);
            }
        });

        BGantiUser.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BGantiUser.setText("Ganti Username");
        BGantiUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGantiUserActionPerformed(evt);
            }
        });

        BGantiPass.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BGantiPass.setText("Ganti Pasword");
        BGantiPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGantiPassActionPerformed(evt);
            }
        });

        BLogout.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        BLogout.setText("OUT");
        BLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLogoutActionPerformed(evt);
            }
        });

        TFPassword.setFont(new java.awt.Font("Baskerville Old Face", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFUsername)
                            .addComponent(TFPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BLogout))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BGantiNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BGantiUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BGantiPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFPassword)
                            .addComponent(jLabel2)))
                    .addComponent(BLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BGantiNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BGantiUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BGantiPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel3, jPanel4, jPanel5});

        setSize(new java.awt.Dimension(459, 423));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_BLoginActionPerformed

    private void BLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLogoutActionPerformed
        // TODO add your handling code here:
        BGantiNama.setEnabled(false);
        BGantiPass.setEnabled(false);
        BGantiUser.setEnabled(false);
        BLogout.setEnabled(false);
        TFPassword.setText("");
        TFPassword.setEnabled(true);
        TFUsername.setText("");
        TFUsername.setEnabled(true);
        BLogin.setEnabled(true);
        LNama.setText("");
        LUsername.setText("");
        LPassword.setText("");
        LAkses.setText("");
        TFUsername.requestFocus();
    }//GEN-LAST:event_BLogoutActionPerformed

    private void BGantiNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGantiNamaActionPerformed
        // TODO add your handling code here:
        //String input = JOptionPane.showInputDialog(null, "Masukan Password", "Ganti Nama", JOptionPane.DEFAULT_OPTION);
        
        JPasswordField pf = new JPasswordField();
            int ok= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Password Anda", pf}, "Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        

          //  int ok = JOptionPane.showConfirmDialog(null, pf, "Enter Password",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(ok==JOptionPane.OK_OPTION){
            String input = new String(pf.getPassword());
            String pss   = TFPassword.getText();
        
        if(input.equals(pss)){
            JTextField tx = new JTextField();
            tx.setDocument(new SaringKarakter().getToUpperCase());
            int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Nama Baru",tx}, "Ganti Nama", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
            if(gnt==JOptionPane.OK_OPTION){
                String ganti = new String(tx.getText());
                try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
               
                String SQL = "UPDATE tblogin SET nama = "
                            + "'"+ganti+"' WHERE "
                            + " username = '"+TFUsername.getText()+"' ;";
                stt.executeUpdate(SQL);
                JOptionPane.showMessageDialog(rootPane, "Nama Berhasil Diganti");
                    
                LNama.setText(ganti);
                
                new FMenu().dispose();
                stt.close();
                kon.close();
                }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
          //  TFNamaBrg.requestFocus();
            }
            }
       
        }else{
            JOptionPane.showMessageDialog(rootPane, "Password Salah!!");
                
            }
            }
        
    }//GEN-LAST:event_BGantiNamaActionPerformed

    private void BGantiUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGantiUserActionPerformed
        // TODO add your handling code here:
        JPasswordField pf = new JPasswordField();
            int ok= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Password Anda", pf}, "Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        

          //  int ok = JOptionPane.showConfirmDialog(null, pf, "Enter Password",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(ok==JOptionPane.OK_OPTION){
            String input = new String(pf.getPassword());
            String pss   = TFPassword.getText();
        
        if(input.equals(pss)){
            JTextField tx = new JTextField();
            tx.setDocument(new SaringKarakter().getToUpperCase());
            int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Username Baru",tx}, "Ganti Username", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
            if(gnt==JOptionPane.OK_OPTION){
                String ganti = new String(tx.getText());
                try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
               
                String SQL = "UPDATE tblogin SET username = "
                            + "'"+ganti+"' WHERE "
                            + " username = '"+TFUsername.getText()+"' ;";
                stt.executeUpdate(SQL);
                JOptionPane.showMessageDialog(rootPane, "Username Berhasil Diganti");
                    
                LUsername.setText(ganti);
                
                stt.close();
                kon.close();
                }catch(Exception ex){JOptionPane.showMessageDialog(null, "Username Sudah Ada!", "Error", JOptionPane.INFORMATION_MESSAGE);
                    
            }
            }
       
        }else{
            JOptionPane.showMessageDialog(rootPane, "Password Salah!!");
                
            }
            }
    }//GEN-LAST:event_BGantiUserActionPerformed

    private void BGantiPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGantiPassActionPerformed
        // TODO add your handling code here:
        JPasswordField pf = new JPasswordField();
            int ok= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Password Lama", pf}, "Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        

          //  int ok = JOptionPane.showConfirmDialog(null, pf, "Enter Password",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(ok==JOptionPane.OK_OPTION){
            String input = new String(pf.getPassword());
            String pss   = TFPassword.getText();
        
        if(input.equals(pss)){
            JPasswordField tx = new JPasswordField();
            int gnt= JOptionPane.showOptionDialog(this, new Object[] {"Masukan Password Baru",tx}, "Ganti Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
            if(gnt==JOptionPane.OK_OPTION){
                String ganti = new String(tx.getPassword());
                
                JPasswordField ty = new JPasswordField();
                int conf= JOptionPane.showOptionDialog(this, new Object[] {"Konfirmasi Password",ty}, "Ganti Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"OK", "CANCEL"}, null);        
                if(conf==JOptionPane.OK_OPTION){
                    String confirm = new String(ty.getPassword());
                    if(confirm.equals(ganti)){
                        try{
                        Class.forName(driver);
                        Connection kon = DriverManager.getConnection(database,user,pass);
                        Statement stt = kon.createStatement();

                        String SQL = "UPDATE tblogin SET password = "
                                    + "'"+ganti+"' WHERE "
                                    + " username = '"+TFUsername.getText()+"' ;";
                        stt.executeUpdate(SQL);
                        JOptionPane.showMessageDialog(rootPane, "Username Berhasil Diganti");
                        TFPassword.setText(ganti);
                        stt.close();
                        kon.close();
                        }catch(Exception ex){JOptionPane.showMessageDialog(null, "Username Sudah Ada!", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Password Tidak Cocok");

                    }
                }
            }
       
        }else{
            JOptionPane.showMessageDialog(rootPane, "Password Salah!!");
                
            }
            }
    }//GEN-LAST:event_BGantiPassActionPerformed

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
            java.util.logging.Logger.getLogger(FEditPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FEditPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FEditPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FEditPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FEditPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGantiNama;
    private javax.swing.JButton BGantiPass;
    private javax.swing.JButton BGantiUser;
    private javax.swing.JButton BLogin;
    private javax.swing.JButton BLogout;
    private javax.swing.JLabel LAkses;
    private javax.swing.JLabel LNama;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel LUsername;
    private javax.swing.JLabel LabelAkses;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelPass;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JPasswordField TFPassword;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
