/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author AcePC
 */
public class FLogin extends javax.swing.JFrame {
    koneksi dbsetting;
    String driver,database,user,pass;
    /**
     * Creates new form FLogin
     */
    SaringKarakter saring = new SaringKarakter();
    
    public FMenu frm = null; 
    public FLogin() {
        initComponents();
        this.setEnabled(true);
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPasssword");
        
        gettimer();gettanggal();
        TFUsername.setDocument(new SaringKarakter().getToUpperCase());
    }
    
    private void savedata(){
        try{
            gettanggal();gettimer();
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            
            String SQL = "INSERT INTO tbabsen (username,nama,jam,tanggal,ket) values "
                         +"('"+TFUsername.getText()+"',(SELECT nama FROM tblogin WHERE username = '"+TFUsername.getText()+"'),'"+LJam.getText()+"','"+LTanggal.getText()+"','Masuk');";
            stt.executeUpdate(SQL);
                stt.close();
                kon.close();
                
        }catch(Exception ex){JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            
        }
        }
    
    
    
    
    
    private void login(){
        String stat = "";
        String nama = TFUsername.getText();
        String pas = TFPassword.getText();
            
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM `tblogin` WHERE "
                            + "`USERNAME` = '"+nama+"'";
            ResultSet res = stt.executeQuery(SQL);
            if (res.next()){
                if(pas.equals(res.getString("password"))){
                    JOptionPane.showMessageDialog(null, "Login "+nama+" Berhasil..", "Informasi",
                    JOptionPane.INFORMATION_MESSAGE);
                    savedata();
                    new FMenu().show(); this.dispose();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFUsername = new javax.swing.JTextField();
        BLogin = new javax.swing.JButton();
        BBatal = new javax.swing.JButton();
        TFPassword = new javax.swing.JPasswordField();
        LTanggal = new javax.swing.JLabel();
        LJam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Aplikasi");
        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 0, 36)); // NOI18N
        jLabel1.setText("LOGIN APLIKASI");

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel3.setText("Password");

        TFUsername.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N

        BLogin.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BLogin.setText("LOGIN");
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });

        BBatal.setFont(new java.awt.Font("Baskerville Old Face", 0, 14)); // NOI18N
        BBatal.setText("BATAL");
        BBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBatalActionPerformed(evt);
            }
        });

        TFPassword.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N

        LTanggal.setFont(new java.awt.Font("Calisto MT", 0, 10)); // NOI18N
        LTanggal.setText("yyyy-MM-dd");

        LJam.setFont(new java.awt.Font("Calisto MT", 0, 10)); // NOI18N
        LJam.setText("00:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LTanggal)
                    .addComponent(LJam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFUsername)
                            .addComponent(TFPassword))))
                .addGap(55, 55, 55))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BBatal, BLogin});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LJam)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BBatal, BLogin});

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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BBatalActionPerformed

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
        // TODO add your handling code here:
        login();
        
    }//GEN-LAST:event_BLoginActionPerformed

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
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBatal;
    private javax.swing.JButton BLogin;
    private javax.swing.JLabel LJam;
    private javax.swing.JLabel LTanggal;
    private javax.swing.JPasswordField TFPassword;
    private javax.swing.JTextField TFUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
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
