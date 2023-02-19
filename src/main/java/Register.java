
import static com.mycompany.test111.ConnectionSQL.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rifat Waheed
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Username_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Password_field = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cancel_btn = new javax.swing.JButton();
        Login_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Username_txtActionPerformed(evt);
            }
        });
        getContentPane().add(Username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 120, 182, -1));

        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Password :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 244, 92, 41));
        getContentPane().add(Password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 254, 182, -1));

        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Username :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 110, 92, 41));

        cancel_btn.setBackground(new java.awt.Color(0, 0, 0));
        cancel_btn.setForeground(new java.awt.Color(255, 153, 0));
        cancel_btn.setText("Cancel");
        getContentPane().add(cancel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 389, 70, 30));

        Login_btn.setBackground(new java.awt.Color(0, 0, 0));
        Login_btn.setForeground(new java.awt.Color(255, 153, 0));
        Login_btn.setText("Login");
        Login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_btnActionPerformed(evt);
            }
        });
        getContentPane().add(Login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 389, 60, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Username_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Username_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Username_txtActionPerformed

    private void Login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_btnActionPerformed
     
        String query = "Select *from Login_Table where UserName =? and Password =?";
        try {
            Connection con;
         PreparedStatement ps;
         ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
           ps = con.prepareStatement(query);
           
           String user=Username_txt.getText();
           ps.setString(1,user);
           
           String pass= String.valueOf(Password_field.getPassword());
           ps.setString(2,pass);
                   
                   if(user.equals(""))
                       
                     JOptionPane.showMessageDialog(null,"Enter a Username");
                   
                   

                 else if(pass.equals(""))
                       
                     JOptionPane.showMessageDialog(null,"Enter a Password");
                   
                   
                   
            rs = ps.executeQuery();  
            
            
                    
          if(rs.next()){
               
               
               new AdvancedAdminPanel().setVisible(true);
               setVisible(false);
               
               //JOptionPane.showMessageDialog(null,"Yes");
           
           }
           
                  else {
           
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");

           
           }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
       String Username = Username_txt.getText();
       String Password = String.valueOf(Password_field.getPassword());
   
    
  
     
     
  
       
       
       
    }//GEN-LAST:event_Login_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login_btn;
    private javax.swing.JPasswordField Password_field;
    private javax.swing.JTextField Username_txt;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}