
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pabon
 */
public class Showtime extends javax.swing.JFrame {

    /**
     * Creates new form Showtime
     */
    public Showtime() {
        initComponents();
    }
    
    
     public Showtime(String info[][],int itr) {
        initComponents();
   
  DefaultTableModel model = (DefaultTableModel)Showtime_Table.getModel();
            String data[] = new String[8];

            for (int i = 0; i < itr; i++) {

                for (int j = 0; j < 6; j++) {
                    data[j] = info[i][j];
                }

                model.addRow(data);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Showtime_Table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ExStaff = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Showtime_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "MovieName", "HallName", "StartingTime", "EndingTime", "TicketPrice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Showtime_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Showtime_Table);
        if (Showtime_Table.getColumnModel().getColumnCount() > 0) {
            Showtime_Table.getColumnModel().getColumn(0).setResizable(false);
            Showtime_Table.getColumnModel().getColumn(1).setResizable(false);
            Showtime_Table.getColumnModel().getColumn(2).setResizable(false);
            Showtime_Table.getColumnModel().getColumn(3).setResizable(false);
            Showtime_Table.getColumnModel().getColumn(4).setResizable(false);
            Showtime_Table.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Staff");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Join With");

        ExStaff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ExStaff.setText("ExStaff");
        ExStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExStaffActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Tradings");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Hall");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(ExStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query = "SELECT * from Showtime INNER JOIN Staff ON Showtime.HallName = Staff.HallName";
      
            int itr = 0;
            
            String [][]info = new String [1000][12]; 
            
          try {
            Connection con;
         PreparedStatement ps;
         ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
           ps = con.prepareStatement(query);
           
    
                   
            rs = ps.executeQuery();  
            
           
          
          
         while(rs.next()){
               
         String []data = new String [12];
               
              
        info[itr][0]= rs.getString("Code");
        info[itr][1]= rs.getString("MovieName");
        info[itr][2]= rs.getString("Hallname");           
        info[itr][3]= rs.getString("StartingTime");
        info[itr][4]= rs.getString("EndingTime");
        info[itr][5]= rs.getString("TicketPrice");
        info[itr][6]= rs.getString("StaffID");
        info[itr][7]= rs.getString("FirstName");
        info[itr][8]= rs.getString("LastName");
        info[itr][9]= rs.getString("StartingTime");
        info[itr][10]= rs.getString("EndingTime");
        info[itr][11]= rs.getString("Salary");
      
      
                 
        itr++;
        
      
//JOptionPane.showMessageDialog(null,"Yes");
           
           }
           
      
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
       
   
        new Showtime_Join_Staff(info,itr).setVisible(true);
        setVisible(false);
          System.out.println(itr);

   

        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExStaffActionPerformed
        String query = "SELECT * from Showtime INNER JOIN ExStaff ON Showtime.HallName = ExStaff.HallName";
      
            int itr = 0;
            
            String [][]info = new String [1000][13]; 
            
          try {
            Connection con;
         PreparedStatement ps;
         ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
           ps = con.prepareStatement(query);
           
    
                   
            rs = ps.executeQuery();  
            
           
          
          
         while(rs.next()){
               
         String []data = new String [13];
               
         
        info[itr][1]= rs.getString("Code");
        info[itr][2]= rs.getString("MovieName");
        info[itr][3]= rs.getString("HallName");
        info[itr][4]= rs.getString("StartingTime");
        info[itr][5]= rs.getString("EndingTime");
        info[itr][6]= rs.getString("TicketPrice");
         
        info[itr][7]= rs.getString("StaffID");
        info[itr][8]= rs.getString("FirstName");
        info[itr][9]= rs.getString("LastName");           
        info[itr][10]= rs.getString("StatingTime");
        info[itr][11]= rs.getString("EndingTime");
        info[itr][12]= rs.getString("Salary");
        
        
        
      
      
                 
        itr++;
        
      
//JOptionPane.showMessageDialog(null,"Yes");
           
           }
           
      
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
       
   
        new Showtime_Join_Staff(info,itr).setVisible(true);
        setVisible(false);
          System.out.println(itr);// TODO add your handling code here:
    }//GEN-LAST:event_ExStaffActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String query = "SELECT * from Showtime INNER JOIN Tradings ON Showtime.Code = Tradings.Code";
      
            int itr = 0;
            
            String [][]info = new String [1000][13]; 
            
          try {
            Connection con;
         PreparedStatement ps;
         ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
           ps = con.prepareStatement(query);
           
    
                   
            rs = ps.executeQuery();  
            
           
          
          
         while(rs.next()){
               
         String []data = new String [10];
               
         
        info[itr][0]= rs.getString("Code");
        info[itr][1]= rs.getString("MovieName");
        info[itr][2]= rs.getString("HallName");
        info[itr][3]= rs.getString("StartingTime");
        info[itr][4]= rs.getString("EndingTime");
        info[itr][5]= rs.getString("TicketPrice");
         
        info[itr][6]= rs.getString("ID");
        info[itr][7]= rs.getString("Cost");
        info[itr][8]= rs.getString("CustomerName");           
        info[itr][9]= rs.getString("Phone");
        
        
        
      
      
                 
        itr++;
        
      
//JOptionPane.showMessageDialog(null,"Yes");
           
           }
           
      
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
       
   
        new Showtime_Join_Tradings(info,itr).setVisible(true);
        setVisible(false);
          System.out.println(itr);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        
        String query = "SELECT * from Showtime INNER JOIN Hall ON Showtime.HallName = Hall.Hallname";
      
            int itr = 0;
            
            String [][]info = new String [1000][13]; 
            
          try {
            Connection con;
         PreparedStatement ps;
         ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
           con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Register_Login;user=root;password=root");
           ps = con.prepareStatement(query);
           
    
                   
            rs = ps.executeQuery();  
            
           
          
          
         while(rs.next()){
               
         String []data = new String [10];
               
         
        info[itr][0]= rs.getString("Code");
        info[itr][1]= rs.getString("MovieName");
        info[itr][2]= rs.getString("HallName");
        info[itr][3]= rs.getString("StartingTime");
        info[itr][4]= rs.getString("EndingTime");
        info[itr][5]= rs.getString("TicketPrice");
         
        info[itr][6]= rs.getString("HallType");
        info[itr][7]= rs.getString("TotalSeat");
        
        
        
        
      
      
                 
        itr++;
        
      
//JOptionPane.showMessageDialog(null,"Yes");
           
           }
           
      
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
        
       
   
        new Showtime_Join_Hall(info,itr).setVisible(true);
        setVisible(false);
          System.out.println(itr);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimb
        us look and feel */
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
            java.util.logging.Logger.getLogger(Showtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Showtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Showtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Showtime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Showtime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExStaff;
    private javax.swing.JTable Showtime_Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}