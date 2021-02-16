/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package petshop;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author isn
 */
public class SaringKarakter {
    
 
/** method ini dipakai untuk mengeset dan mendapatkan filter
*  serta merubah semua case menjadi lowercase
*  @return mengembalikan filter bertype PlainDocument
*  Merubah semua HURUF menjadi HURUF KECIL (LOWER CASE)
*/
    
public PlainDocument getsNumber(){
    PlainDocument filterNumb = new PlainDocument(){
        private  static  final long serialVersionUID = 1L;
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if(str.matches("[0-9]*")){
            super.insertString(offs, str, a); //To change body of generated methods, choose Tools | Templates.
            }else{
            }
        }
    };
    return filterNumb;
    
}


    
    
public PlainDocument getToLowerCase() {
PlainDocument filterLower = new PlainDocument() {
public void insertString(int offs, String str, AttributeSet a) throws
            BadLocationException {
char[] lower = str.toCharArray();
for (int i = 0; i < lower.length; i++) {
// Menjadi lower case
lower[i] = Character.toLowerCase(lower[i]);
}
super.insertString(offs, new String(lower), a);
}
};
return filterLower;
}
 
/** method ini dipakai untuk mengeset dan mendapatkan filter
*  serta merubah semua case menjadi uppercase
*  @return mengembalikan filter bertype PlainDocument
*  Merubah semua HURUF menjadi HURUF BESAR (UPPER CASE)
*/
public PlainDocument getToUpperCase() {
PlainDocument filterUpper = new PlainDocument() {
public void insertString(int offs, String str, AttributeSet a) throws
BadLocationException {
char[] upper = str.toCharArray();
for (int i = 0; i < upper.length; i++) {
// Menjadi upper case
upper[i] = Character.toUpperCase(upper[i]);
}
super.insertString(offs, new String(upper), a);
}
};
return filterUpper;
}
} // Akhir Kelas changeCase

    

