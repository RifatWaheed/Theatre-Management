import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fahim
 */
public class BuyNow extends javax.swing.JFrame {

    /**
     * Creates new form BuyNow
     */
    
    ImageIcon theatre = new ImageIcon ("theatre");
    
    
    public int vacant = 0;
    public int booked = 0;
    public int[][] RC = new int[15][5];
    public int size;
    public int code;
    public int TotalSeat = 0;
    public int CurrentlySelected = 0;
    public int Others = 0;

    public BuyNow() {
        initComponents();
       
        
    }

    public BuyNow(int data[][], int sz, int cd) {
        initComponents();
        size = sz;
        code = cd;
        for (int i = 1; i <= sz; i++) {

            for (int j = 1; j <= 3; j++) {
                RC[i][j] = data[i][j];
                if (data[i][j] == 0) {
                    vacant++;
                    make(i, j, 0);

                } else if (data[i][j] == 1) {
                    booked++;
                    make(i, j, 1);
                } else if (data[i][j] == 2) {
                    make(i, j, 2);
                    CurrentlySelected++;
                } else if (data[i][j] == 99) {
                    make(i, j, 99);
                    Others++;
                }
            }

        }

        for (int i = sz + 1; i < 15; i++) {

            for (int j = 1; j <= 3; j++) {
                RC[i][j] = 99;
                make(i, j, 99);
            }

        }
        TotalSeat = vacant + booked + CurrentlySelected + Others;
        values();
    }

    void Selection(int row, int col) {

        // 0 --  vacant
        // 1 --  booked
        // 2 --  currently selected
        // 99 -- future reserve
        if (RC[row][col] == 0) {
            RC[row][col] = 2;
            make(row, col, 2);
            CurrentlySelected++;
            vacant--;
        } else if (RC[row][col] == 2) {
            RC[row][col] = 0;
            make(row, col, 0);
            CurrentlySelected--;
            vacant++;
        } else if (RC[row][col] == 1) {
            JOptionPane.showMessageDialog(null, "This Seat is already booked");
        } else if (RC[row][col] == 99) {
            JOptionPane.showMessageDialog(null, "This Seat can't be selected");
        }
    }

    void make(int row, int col, int choose) {

        if (row == 1 && col == 1) {

            if (choose == 0) {
                R1C1.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R1C1.setBackground(Color.RED);
            } else if (choose == 2) {
                R1C1.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R1C1.setBackground(Color.BLACK);
            }
        } else if (row == 1 && col == 2) {

            if (choose == 0) {
                R1C2.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R1C2.setBackground(Color.RED);
            } else if (choose == 2) {
                R1C2.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R1C2.setBackground(Color.BLACK);
            }
        } else if (row == 1 && col == 3) {

            if (choose == 0) {
                R1C3.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R1C3.setBackground(Color.RED);
            } else if (choose == 2) {
                R1C3.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R1C3.setBackground(Color.BLACK);
            }
        } else if (row == 2 && col == 1) {

            if (choose == 0) {
                R2C1.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R2C1.setBackground(Color.RED);
            } else if (choose == 2) {
                R2C1.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R2C1.setBackground(Color.BLACK);
            }
        } else if (row == 2 && col == 2) {

            if (choose == 0) {
                R2C2.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R2C2.setBackground(Color.RED);
            } else if (choose == 2) {
                R2C2.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R2C2.setBackground(Color.BLACK);
            }
        } else if (row == 2 && col == 3) {

            if (choose == 0) {
                R2C3.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R2C3.setBackground(Color.RED);
            } else if (choose == 2) {
                R2C3.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R2C3.setBackground(Color.BLACK);
            }
        } else if (row == 3 && col == 1) {

            if (choose == 0) {
                R3C1.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R3C1.setBackground(Color.RED);
            } else if (choose == 2) {
                R3C1.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R3C1.setBackground(Color.BLACK);
            }
        } else if (row == 3 && col == 2) {

            if (choose == 0) {
                R3C2.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R3C2.setBackground(Color.RED);
            } else if (choose == 2) {
                R3C2.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R3C2.setBackground(Color.BLACK);
            }
        } else if (row == 3 && col == 3) {

            if (choose == 0) {
                R3C3.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R3C3.setBackground(Color.RED);
            } else if (choose == 2) {
                R3C3.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R3C3.setBackground(Color.BLACK);
            }
        } else if (row == 4 && col == 1) {

            if (choose == 0) {
                R4C1.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R4C1.setBackground(Color.RED);
            } else if (choose == 2) {
                R4C1.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R4C1.setBackground(Color.BLACK);
            }
        } else if (row == 4 && col == 2) {

            if (choose == 0) {
                R4C2.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R4C2.setBackground(Color.RED);
            } else if (choose == 2) {
                R4C2.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R4C2.setBackground(Color.BLACK);
            }
        } else if (row == 4 && col == 3) {

            if (choose == 0) {
                R4C3.setBackground(Color.GREEN);
            } else if (choose == 1) {
                R4C3.setBackground(Color.RED);
            } else if (choose == 2) {
                R4C3.setBackground(Color.CYAN);
            } else if (choose == 99) {
                R4C3.setBackground(Color.BLACK);
            }
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
        R1C3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        R4C3 = new javax.swing.JButton();
        R4C2 = new javax.swing.JButton();
        R4C1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        R3C3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        R3C2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        R3C1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        R2C3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        R2C2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        R1C2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        R2C1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        R1C1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelSelected = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labelOthers = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelVacant = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelBook = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        submit_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1240, 740));
        setMinimumSize(new java.awt.Dimension(1240, 740));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(1274, 740));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        R1C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C3ActionPerformed(evt);
            }
        });
        jPanel1.add(R1C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 90, 59));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("R13");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 36, -1));

        R4C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C3ActionPerformed(evt);
            }
        });
        jPanel1.add(R4C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 650, 90, 59));

        R4C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C2ActionPerformed(evt);
            }
        });
        jPanel1.add(R4C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, 90, 59));

        R4C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R4C1ActionPerformed(evt);
            }
        });
        jPanel1.add(R4C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 90, 59));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Row - 4");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 650, 84, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 153, 0));
        jLabel16.setText("R11");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 710, 36, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("R42");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 710, 36, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 0));
        jLabel15.setText("R41");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 710, 36, -1));

        R3C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C3ActionPerformed(evt);
            }
        });
        jPanel1.add(R3C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 90, 59));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("R33");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 36, -1));

        R3C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C2ActionPerformed(evt);
            }
        });
        jPanel1.add(R3C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 90, 59));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("R32");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 36, -1));

        R3C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R3C1ActionPerformed(evt);
            }
        });
        jPanel1.add(R3C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 90, 59));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("R31");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 36, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Row - 3");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 84, 50));

        R2C3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C3ActionPerformed(evt);
            }
        });
        jPanel1.add(R2C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 440, 90, 59));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("R23");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 36, -1));

        R2C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C2ActionPerformed(evt);
            }
        });
        jPanel1.add(R2C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 90, 59));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("R22");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, 36, -1));

        R1C2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C2ActionPerformed(evt);
            }
        });
        jPanel1.add(R1C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 90, 59));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("R12");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 36, -1));

        R2C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R2C1ActionPerformed(evt);
            }
        });
        jPanel1.add(R2C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 90, 59));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("R21");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 36, -1));

        R1C1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R1C1ActionPerformed(evt);
            }
        });
        jPanel1.add(R1C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 90, 59));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("R11");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 36, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Row - 1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 84, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Row - 2");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 84, 50));

        labelSelected.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSelected.setForeground(new java.awt.Color(0, 204, 204));
        labelSelected.setText("0");
        jPanel1.add(labelSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 480, 30, 41));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 255));
        jLabel20.setText("Total");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 600, 70, 42));

        labelTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(204, 204, 255));
        labelTotal.setText("0");
        jPanel1.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 600, 94, 41));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("Others");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 540, 80, 42));

        labelOthers.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelOthers.setForeground(new java.awt.Color(240, 240, 240));
        labelOthers.setText("0");
        jPanel1.add(labelOthers, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 540, 40, 41));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 204, 204));
        jLabel26.setText("Selected");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 480, -1, 42));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 204, 0));
        jLabel18.setText("Vacant");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, 80, 42));

        labelVacant.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelVacant.setForeground(new java.awt.Color(0, 204, 0));
        labelVacant.setText("0");
        jPanel1.add(labelVacant, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 430, 20, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Booked");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 350, 90, 40));

        labelBook.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelBook.setForeground(new java.awt.Color(255, 0, 51));
        labelBook.setText("0");
        jPanel1.add(labelBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 360, 73, 20));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rifat Waheed\\Desktop\\Database images\\Test111\\18815789.jpg")); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 670, 230));

        submit_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submit_btn.setText("Submit");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(submit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 700, 80, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1500, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void values() {
        labelBook.setText(Integer.toString(booked));
        labelVacant.setText(Integer.toString(vacant));
        labelSelected.setText(Integer.toString(CurrentlySelected));
        labelOthers.setText(Integer.toString(Others));
        labelTotal.setText(Integer.toString(TotalSeat));

    }

    private void R3C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C3ActionPerformed
        // TODO add your handling code here:
        Selection(3, 3);
        values();
    }//GEN-LAST:event_R3C3ActionPerformed

    private void R1C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C1ActionPerformed
        // TODO add your handling code here:
        Selection(1, 1);
        values();
    }//GEN-LAST:event_R1C1ActionPerformed

    private void R1C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C2ActionPerformed
        // TODO add your handling code here:
        Selection(1, 2);
        values();
    }//GEN-LAST:event_R1C2ActionPerformed

    private void R2C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C1ActionPerformed
        // TODO add your handling code here:
        Selection(2, 1);
        values();
    }//GEN-LAST:event_R2C1ActionPerformed

    private void R2C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C2ActionPerformed
        // TODO add your handling code here:
        Selection(2, 2);
        values();
    }//GEN-LAST:event_R2C2ActionPerformed

    private void R1C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R1C3ActionPerformed
        // TODO add your handling code here:
        Selection(1, 3);
        values();
    }//GEN-LAST:event_R1C3ActionPerformed

    private void R2C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R2C3ActionPerformed
        // TODO add your handling code here:
        Selection(2, 3);
        values();
    }//GEN-LAST:event_R2C3ActionPerformed

    private void R3C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C1ActionPerformed
        // TODO add your handling code here:
        Selection(3, 1);
        values();
    }//GEN-LAST:event_R3C1ActionPerformed

    private void R3C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R3C2ActionPerformed
        // TODO add your handling code here:
        Selection(3, 2);
        values();
    }//GEN-LAST:event_R3C2ActionPerformed

    private void R4C1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C1ActionPerformed
        // TODO add your handling code here:
        Selection(4, 1);
        values();
    }//GEN-LAST:event_R4C1ActionPerformed

    private void R4C2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C2ActionPerformed
        // TODO add your handling code here:
        Selection(4, 2);
        values();
    }//GEN-LAST:event_R4C2ActionPerformed

    private void R4C3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R4C3ActionPerformed
        // TODO add your handling code here:
        Selection(4, 3);
        values();
    }//GEN-LAST:event_R4C3ActionPerformed


    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed

        // TODO add your handling code here:
        if (CurrentlySelected == 0) {
            JOptionPane.showMessageDialog(null, "Please select some seats");
        } else {
            FullBooking();
        }

    }//GEN-LAST:event_submit_btnActionPerformed

    void FullBooking() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 3; j++) {

                if (RC[i][j] == 2) {
                    RC[i][j] = 1;
                }
            }
        }

        new CustomerInfo(RC, code, CurrentlySelected,vacant,booked).setVisible(true);
        setVisible(false);

    }

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
            java.util.logging.Logger.getLogger(BuyNow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyNow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyNow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyNow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyNow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton R1C1;
    private javax.swing.JButton R1C2;
    private javax.swing.JButton R1C3;
    private javax.swing.JButton R2C1;
    private javax.swing.JButton R2C2;
    private javax.swing.JButton R2C3;
    private javax.swing.JButton R3C1;
    private javax.swing.JButton R3C2;
    private javax.swing.JButton R3C3;
    private javax.swing.JButton R4C1;
    private javax.swing.JButton R4C2;
    private javax.swing.JButton R4C3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBook;
    private javax.swing.JLabel labelOthers;
    private javax.swing.JLabel labelSelected;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelVacant;
    private javax.swing.JButton submit_btn;
    // End of variables declaration//GEN-END:variables
}
