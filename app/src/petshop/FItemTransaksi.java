/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author isn
 */
public class FItemTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form FItemTransaksi
     */
     koneksi dbsetting;
    String driver,database,user,pass;
    Object tabel;
    int row=0;
    Vector list = new Vector();
    
    private TableRowSorter rowSorter = new TableRowSorter();
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel(){
        return new javax.swing.table.DefaultTableModel(
                new Object[][][][][][]{},
                new String[] {"Kode","Nama","Harga","Jumlah","Total"}
        ){
            boolean[] canEdit = new boolean[]{
                false,false,false,false,false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }
    String data[] = new String[4];
    public FItemTransaksi() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPasssword");
        
        TabelData.setModel(tableModel);
        getMenu();
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
                
        CBKode.setEnabled(false);
        BCari.setEnabled(false);
            }
           // super.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
        }
   
    }
        public void getMenu(){
        setM();
                 CBKode.setEnabled(true);
                 BCari.setEnabled(true);
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
        String data[] = new String[6];
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            
            Statement stt = kon.createStatement();
            String SQL = "select nofaktur from tbtransaksi";
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
            String SQL = "SELECT kode,nama,harga,jumlah,total FROM tbitemtransaksi where nofaktur='"+item+"'";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0]= res.getString(1);
                data[1]= res.getString(2);
                data[2]= res.getString(3);
                data[3]= res.getString(4);
                data[4]= res.getString(5);
                    tableModel.addRow(data);
                   }
            kon.close();
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
        BCari = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelData = new javax.swing.JTable();
        BHapusSemua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(461, 104));

        jLabel12.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jLabel12.setText("Detail Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jLabel2.setText("Cari Berdasarkan No Transaksi");

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

        BCari.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BCari.setText("OK");
        BCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Barang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calisto MT", 1, 12))); // NOI18N

        TabelData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TabelData.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelData);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        BHapusSemua.setBackground(new java.awt.Color(204, 204, 204));
        BHapusSemua.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        BHapusSemua.setText("CLEAR");
        BHapusSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusSemuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CBKode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BHapusSemua)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BHapusSemua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CBKode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        setSize(new java.awt.Dimension(630, 422));
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
        CBKode.setEnabled(false);
        BCari.setEnabled(false);
    }//GEN-LAST:event_BCariActionPerformed

    private void TabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDataMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TabelDataMouseClicked

    private void BHapusSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusSemuaActionPerformed
        // TODO add your handling code here:
                   int row = TabelData.getRowCount();
                for(int i=0;i<row;i++){
                    tableModel.removeRow(0);
                }
                CBKode.setEnabled(true);
                BCari.setEnabled(true);
                CBKode.requestFocus();
    }//GEN-LAST:event_BHapusSemuaActionPerformed

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
            java.util.logging.Logger.getLogger(FItemTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FItemTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FItemTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FItemTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FItemTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCari;
    private javax.swing.JButton BHapusSemua;
    private javax.swing.JComboBox<String> CBKode;
    private javax.swing.JTable TabelData;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
