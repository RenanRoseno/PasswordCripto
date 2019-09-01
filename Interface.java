
package pB.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/*
 * @author Renan Roseno
 */

public class Interface extends JFrame {
    private JLabel lbTitulo;
    private JPasswordField pfSenha;
    private JButton btCodificar;
    private JLabel foto;
    private JLabel lbNome;
    private Font letra;
   
    public Interface(){
        inicializarComponentes();
        definirEventos();   
    }
    
    public void inicializarComponentes(){
        lbTitulo = new JLabel("SENHA");
        pfSenha = new JPasswordField();
        btCodificar = new JButton("CODIFICAR");
        lbNome = new JLabel("<> PASSWORD CRIPTO");
        letra = new Font("Courier New",Font.BOLD,20);
        
        lbNome.setFont(letra);
        lbNome.setBounds(20, 5, 280, 30);
        lbTitulo.setBounds(120,50,50,80);
        pfSenha.setBounds(50,120,180,30);
        btCodificar.setBounds(90,170,100,30);
        
       
        add(lbTitulo);
        add(pfSenha);
        add(lbNome);
        add(btCodificar);
       
    }
    public void definirEventos(){
         btCodificar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              String a[] ={"X","a" , "b", "c", "d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
              "0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
              "R","S","T","U","V","X","Y","Z","X"};
                      
                String teste = new String(pfSenha.getPassword());
                int i =0;
                int p = 0;
                String r = teste;
                String c[] = null;
                
                  dispose();
               try{
                   MessageDigest md = MessageDigest.getInstance("SHA-256");
                   byte messageDigest[] = md.digest(r.getBytes("UTF-8"));
                   
                   StringBuilder sb = new StringBuilder();
                   
                   for(byte b: messageDigest){
                       sb.append(String.format("%02X", 0xFF & b));                 
                   }

                   String senhaHex = sb.toString();
                   JOptionPane.showMessageDialog(null," \nSua senha codificada é : " + senhaHex + "\nSua senha é: "+ teste );
                   dispose();

                }catch(Exception e){
                   
                } 
            }
                        
         });
  }
    
}
