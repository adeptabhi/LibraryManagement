package jFrame;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageStudents extends javax.swing.JFrame {
    String studentName,course,branch;
    int studentId;
    DefaultTableModel model;
    public ManageStudents(){
        initComponents();
        setStudentDetailsToTable();
    }
   //to set the book details into the table
    public void setStudentDetailsToTable()
    {
          try
          {
              Connection con =  DBConnection.getConnection();
              Statement st = con.createStatement();
              st.executeQuery("select * from student_details");
              ResultSet rs = st.executeQuery("select * from student_details");
              while(rs.next())
              {
                  int studentId = rs.getInt("student_id");
                  String studentName = rs.getString("name");
                  String course = rs.getString("course");
                  String branch= rs.getString("branch");
                  
                  Object[] obj = {studentId,studentName,course,branch};
                  model =(DefaultTableModel)tbl_studentDetails.getModel();
                  model.addRow(obj);
              }
          }   
          catch(Exception e)
          {
              e.printStackTrace();
          }
    }
      //to add book to student deatails table
        public boolean addStudent()
       {
          boolean isAdded = false;
          studentId = Integer.parseInt(txt_studentId.getText());
          studentName = txt_studentName.getText();
          course = combo_courseName.getSelectedItem().toString();
          branch = combo_branch.getSelectedItem().toString();
          try
          {
              Connection con =  DBConnection.getConnection();
              String sql="insert into student_details values(?,?,?,?)";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1,studentId);
              pst.setString(2, studentName);
              pst.setString(3,course);
              pst.setString(4,branch);
              int rowCount = pst.executeUpdate();
              if(rowCount > 0)
                  isAdded = true;
              else
                  isAdded = false;
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          return isAdded;
       }
        //to update book details 
        public boolean updateStudent()
        {
          boolean isUpdated = false;
          studentId = Integer.parseInt(txt_studentId.getText());
          studentName = txt_studentName.getText();
          course = combo_courseName.getSelectedItem().toString();
          branch = combo_branch.getSelectedItem().toString();
          try
          {
              Connection con = DBConnection.getConnection();
              String sql = "update student_details set name = ?,course = ?,branch = ? where student_id = ?";
              PreparedStatement  pst = con.prepareStatement(sql);
              pst.setString(1, studentName);
              pst.setString(2,course);
              pst.setString(3,branch);
              pst.setInt(4, studentId);
               
              int rowCount = pst.executeUpdate();
              if(rowCount > 0)
                  isUpdated = true;
              else
                  isUpdated = false;
          }catch(Exception e)
          {
              e.printStackTrace();
          }
          return isUpdated;
        }
        //method to delete book detail
        public boolean deleteStudent()
        {
            boolean isDeleted = false;
            studentId = Integer.parseInt(txt_studentId.getText());
            try
            {
                Connection con = DBConnection.getConnection();
                String sql = "delete from student_details where student_id = ?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, studentId);
                int rowCount = pst.executeUpdate();
                if(rowCount > 0)
                    isDeleted = true;
                else
                    isDeleted = false;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return isDeleted;
        }
        //method to clear table
        public void clearTable()
        {
            DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
            model.setRowCount(0);
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Main = new javax.swing.JPanel();
        panel_manageStudents = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        combo_courseName = new javax.swing.JComboBox<>();
        combo_branch = new javax.swing.JComboBox<>();
        panel_studentDetails = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Main.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_manageStudents.setBackground(new java.awt.Color(102, 102, 255));
        panel_manageStudents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel_manageStudents.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 35));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Id :");
        panel_manageStudents.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 174, -1, -1));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        panel_manageStudents.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 200, 275, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        panel_manageStudents.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 190, -1, 42));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Student Name :");
        panel_manageStudents.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 258, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        panel_manageStudents.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 274, -1, 42));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name...");
        panel_manageStudents.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 284, 275, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        panel_manageStudents.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 361, -1, 42));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select Course :");
        panel_manageStudents.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 345, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("DELETE");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_manageStudents.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 131, 62));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("ADD");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        panel_manageStudents.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 521, 131, 62));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 0));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        panel_manageStudents.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 445, -1, 42));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Select Branch :");
        panel_manageStudents.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 429, -1, -1));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("UPDATE");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        panel_manageStudents.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 521, 131, 62));

        combo_courseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MCA", "BCA", "M.tech", "B.tech ", " ", " " }));
        combo_courseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseNameActionPerformed(evt);
            }
        });
        panel_manageStudents.add(combo_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 371, 262, 32));

        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Application" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });
        panel_manageStudents.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 455, 262, 32));

        panel_Main.add(panel_manageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 450, 646));

        panel_studentDetails.setBackground(new java.awt.Color(255, 255, 255));
        panel_studentDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("X");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_studentDetails.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentDetails.setRowHeight(22);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);
        if (tbl_studentDetails.getColumnModel().getColumnCount() > 0) {
            tbl_studentDetails.getColumnModel().getColumn(0).setResizable(false);
            tbl_studentDetails.getColumnModel().getColumn(2).setResizable(false);
        }

        panel_studentDetails.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 220, 745, 386));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel1.setText("Manage Students");
        panel_studentDetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 56, 265, 88));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        panel_studentDetails.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 156, -1, -1));

        panel_Main.add(panel_studentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 2, 796, 646));

        getContentPane().add(panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        setSize(new java.awt.Dimension(1250, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        txt_studentId.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo,1).toString());
        combo_courseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
       if(addStudent() == true)
       {
           JOptionPane.showMessageDialog(this,"Student Added");   
           clearTable();
           setStudentDetailsToTable();
       }   
       else
           JOptionPane.showMessageDialog(this,"Student Addition Failure");
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
       if(updateStudent() == true)
       {
           JOptionPane.showMessageDialog(this,"Student Updated");   
           clearTable();
           setStudentDetailsToTable();
       }   
       else
           JOptionPane.showMessageDialog(this,"Student Updation Failure");
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(deleteStudent() == true)
       {
           JOptionPane.showMessageDialog(this,"Student Deleted");   
           clearTable();
           setStudentDetailsToTable();
       }   
       else
           JOptionPane.showMessageDialog(this,"Student Deletion Failure");
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void combo_courseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseNameActionPerformed
        if(combo_courseName.getSelectedItem().equals("BCA")||combo_courseName.getSelectedItem().equals("MCA"))
        {    
            combo_branch.removeAllItems();
            combo_branch.addItem("Application");
        }else
        {    
            combo_branch.removeAllItems();
            combo_branch.addItem("CS");
            combo_branch.addItem("IT");
            combo_branch.addItem("ME");
            combo_branch.addItem("ECE");
            combo_branch.addItem("EE");
            combo_branch.addItem("CE");
            combo_branch.addItem("AI");
        }
    }//GEN-LAST:event_combo_courseNameActionPerformed

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
         Color mouseEnterColor1 = new Color(255,51,51);
        jPanel4.setBackground(mouseEnterColor1);
        Color mouseEnterColor2 = new Color(255,255,255);
        jLabel18.setForeground(mouseEnterColor2);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        Color mouseExitColor1 = new Color(255,255,255);
        jPanel4.setBackground(mouseExitColor1);
        Color mouseExitColor2 = new Color(255,51,51);
        jLabel18.setForeground(mouseExitColor2);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
      HomePage home = new HomePage();
      home.setVisible(true);
      this.dispose();  
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        Color mouseEnterColor = new Color(255,51,51);
        jPanel2.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        Color mouseExitColor = new Color(102,102,255);
        jPanel2.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel2MouseExited

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_courseName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_Main;
    private javax.swing.JPanel panel_manageStudents;
    private javax.swing.JPanel panel_studentDetails;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
