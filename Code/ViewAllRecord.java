
package jFrame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ViewAllRecord extends javax.swing.JFrame {

    DefaultTableModel model;
    boolean isFound = false;
    public ViewAllRecord() {
        initComponents();
        setDate();
        setIssueBookDetailsToTable();
    }
    //to set date in fromdate and todate variable
    public void setDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String fromDate = "01-01-2022 00:00:00";
        String toDate = "01-01-2025 00:00:00";
        try 
        {  
          Date fromDateChange = formatter.parse(fromDate);
          Date toDateChange = formatter.parse(toDate);
          date_fromDate.setDate(fromDateChange);
          date_toDate.setDate(toDateChange);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }    
    }
    //to set the book details into the table
    public void setIssueBookDetailsToTable()
    {
        Date ufromDate = date_fromDate.getDate();
        Date utoDate = date_toDate.getDate();
        long d1 = ufromDate.getTime();
        long d2 = utoDate.getTime();
        java.sql.Date fromDate = new java.sql.Date(d1);
        java.sql.Date toDate = new java.sql.Date(d2);
        try
          {
              Connection con =  DBConnection.getConnection();
              String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
              PreparedStatement pst = con.prepareStatement(sql);              
              pst.setDate(1, fromDate);
              pst.setDate(2, toDate);
              ResultSet rs = pst.executeQuery();
              while(rs.next())
              {
                  String id = rs.getString("id");
                  String bookName = rs.getString("book_name");
                  String studentName = rs.getString("student_name");
                  String issueDate = rs.getString("issue_date");
                  String dueDate = rs.getString("due_date");
                  String status = rs.getString("status");
                  
                  Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                  model =(DefaultTableModel)tbl_issueDetails.getModel();
                  model.addRow(obj);
                  isFound = true;
              }
          }   
          catch(Exception e)
          {
              e.printStackTrace();
          }
    }
    //to set the book details into the table which status is pending
    public void setIssueBookDetailsToTableStatusPending()
    {
        Date ufromDate = date_fromDate.getDate();
        Date utoDate = date_toDate.getDate();
        long d1 = ufromDate.getTime();
        long d2 = utoDate.getTime();
        java.sql.Date fromDate = new java.sql.Date(d1);
        java.sql.Date toDate = new java.sql.Date(d2);
        try
          {
              Connection con =  DBConnection.getConnection();
              String sql = "select * from issue_book_details where issue_date BETWEEN ? and ? and status = ?";
              PreparedStatement pst = con.prepareStatement(sql);              
              pst.setDate(1, fromDate);
              pst.setDate(2, toDate);
              pst.setString(3,"pending");
              ResultSet rs = pst.executeQuery();
              while(rs.next())
              {
                  String id = rs.getString("id");
                  String bookName = rs.getString("book_name");
                  String studentName = rs.getString("student_name");
                  String issueDate = rs.getString("issue_date");
                  String dueDate = rs.getString("due_date");
                  String status = rs.getString("status");
                  
                  Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                  model =(DefaultTableModel)tbl_issueDetails.getModel();
                  model.addRow(obj);
                  isFound = true;
              }
          }   
          catch(Exception e)
          {
              e.printStackTrace();
          }
    }
    //to set the book details into the table which status is returned
    public void setIssueBookDetailsToTableStatusReturned()
    {
        Date ufromDate = date_fromDate.getDate();
        Date utoDate = date_toDate.getDate();
        long d1 = ufromDate.getTime();
        long d2 = utoDate.getTime();
        java.sql.Date fromDate = new java.sql.Date(d1);
        java.sql.Date toDate = new java.sql.Date(d2);
        try
          {
              Connection con =  DBConnection.getConnection();
              String sql = "select * from issue_book_details where issue_date BETWEEN ? and ? and status = ?";
              PreparedStatement pst = con.prepareStatement(sql);              
              pst.setDate(1, fromDate);
              pst.setDate(2, toDate);
              pst.setString(3,"returned");
              ResultSet rs = pst.executeQuery();
              while(rs.next())
              {
                  String id = rs.getString("id");
                  String bookName = rs.getString("book_name");
                  String studentName = rs.getString("student_name");
                  String issueDate = rs.getString("issue_date");
                  String dueDate = rs.getString("due_date");
                  String status = rs.getString("status");
                  
                  Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                  model =(DefaultTableModel)tbl_issueDetails.getModel();
                  model.addRow(obj);
                  isFound = true;
              }
          }   
          catch(Exception e)
          {
              e.printStackTrace();
          }
    }
    //method to clear table
      public void clearTable()
      {
           DefaultTableModel model = (DefaultTableModel) tbl_issueDetails.getModel();
           model.setRowCount(0);
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Main = new javax.swing.JPanel();
        panel_top = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        date_fromDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        date_toDate = new com.toedter.calendar.JDateChooser();
        button_search = new necesario.RSMaterialButtonCircle();
        panel_tabel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_issueDetails = new rojeru_san.complementos.RSTableMetro();
        button_returnedStatus = new necesario.RSMaterialButtonCircle();
        button_pendingStatus = new necesario.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        panel_Main.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_top.setBackground(new java.awt.Color(102, 102, 255));
        panel_top.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_top.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 35));

        jPanel20.setBackground(new java.awt.Color(102, 102, 255));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel20MouseExited(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("X");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel26)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_top.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Issued Book Details");
        panel_top.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 280, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        panel_top.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 360, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("From Date :");
        panel_top.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 20));

        date_fromDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));
        date_fromDate.setForeground(new java.awt.Color(255, 51, 51));
        date_fromDate.setDateFormatString("dd-MM-yyyy");
        date_fromDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        date_fromDate.setMaxSelectableDate(new java.util.Date(253370748681905L));
        date_fromDate.setMinSelectableDate(new java.util.Date(-62135785718095L));
        panel_top.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 220, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("    To Date :");
        panel_top.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, 20));

        date_toDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));
        date_toDate.setForeground(new java.awt.Color(255, 51, 51));
        date_toDate.setDateFormatString("dd-MM-yyyy");
        date_toDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panel_top.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 220, 40));

        button_search.setBackground(new java.awt.Color(255, 51, 51));
        button_search.setText("Search");
        button_search.setToolTipText("");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });
        panel_top.add(button_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(906, 140, 220, 50));

        panel_Main.add(panel_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 1246, 225));

        panel_tabel.setBackground(new java.awt.Color(255, 255, 255));
        panel_tabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issueDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_issueDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_issueDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issueDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        tbl_issueDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tbl_issueDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tbl_issueDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_issueDetails.setRowHeight(25);
        jScrollPane3.setViewportView(tbl_issueDetails);

        panel_tabel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 1010, 320));

        button_returnedStatus.setBackground(new java.awt.Color(255, 102, 102));
        button_returnedStatus.setText("RETURNED STATUS");
        button_returnedStatus.setToolTipText("");
        button_returnedStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_returnedStatusActionPerformed(evt);
            }
        });
        panel_tabel.add(button_returnedStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 220, 50));

        button_pendingStatus.setBackground(new java.awt.Color(255, 102, 102));
        button_pendingStatus.setText("PENDING STATUS");
        button_pendingStatus.setToolTipText("");
        button_pendingStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pendingStatusActionPerformed(evt);
            }
        });
        panel_tabel.add(button_pendingStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 220, 50));

        panel_Main.add(panel_tabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 227, 1246, 421));

        getContentPane().add(panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        Color mouseEnterColor = new Color(255,51,51);
        jPanel3.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        Color mouseExitColor = new Color(102,102,255);
        jPanel3.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        Color mouseEnterColor = new Color(255,51,51);
        jPanel20.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseExited
        Color mouseExitColor = new Color(102,102,255);
        jPanel20.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel20MouseExited

    private void button_pendingStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pendingStatusActionPerformed
          clearTable();
          setIssueBookDetailsToTableStatusPending();
          if(isFound == false)
              JOptionPane.showMessageDialog(this,"No Record Found");
              isFound = false;
    }//GEN-LAST:event_button_pendingStatusActionPerformed

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
          clearTable();
          setIssueBookDetailsToTable();  
          if(isFound == false)
              JOptionPane.showMessageDialog(this,"No Record Found");
              isFound = false;
    }//GEN-LAST:event_button_searchActionPerformed

    private void button_returnedStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_returnedStatusActionPerformed
          clearTable();
          setIssueBookDetailsToTableStatusReturned();  
          if(isFound == false)
              JOptionPane.showMessageDialog(this,"No Record Found");
              isFound = false;
    }//GEN-LAST:event_button_returnedStatusActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private necesario.RSMaterialButtonCircle button_pendingStatus;
    private necesario.RSMaterialButtonCircle button_returnedStatus;
    private necesario.RSMaterialButtonCircle button_search;
    private com.toedter.calendar.JDateChooser date_fromDate;
    private com.toedter.calendar.JDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_Main;
    private javax.swing.JPanel panel_tabel;
    private javax.swing.JPanel panel_top;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails1;
    private rojeru_san.complementos.RSTableMetro tbl_issueDetails;
    // End of variables declaration//GEN-END:variables
}
