package jFrame;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
public class SignupPage extends javax.swing.JFrame
{
       public SignupPage() 
       {
          initComponents();
        }
     //method to insert values in to users table  
       public void insertSingupDetails()
       {
          String name = txt_username.getText();
          String pwd = txt_password.getText();
          String email = txt_email.getText();
          String contact = txt_contact.getText();
          try
            {
              Connection con=DBConnection.getConnection();
              String sql="insert into users(name,password,email,contact) values(?,?,?,?)";
              PreparedStatement pst= con.prepareStatement(sql);
              pst.setString(1,name);
              pst.setString(2, pwd);
              pst.setString(3,email);
              pst.setString(4, contact);
              int updatedRowCount = pst.executeUpdate();
              if(updatedRowCount>0)
              {    
                  JOptionPane.showMessageDialog(this,"Recorded Inserted Successfully");
                  LoginPage page=new LoginPage();
                  page.setVisible(true);
                  this.dispose();
              } 
                  else
                  JOptionPane.showMessageDialog(this,"Recorded Insertion Failure");
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
         //validation
       public boolean validateSignup()
       {
          String name = txt_username.getText();
          String pwd = txt_password.getText();
          String email = txt_email.getText();
          String contact = txt_contact.getText();
          String adminUsername = txt_adminUsername.getText();
          String adminPassword = txt_adminPassword.getText();
          if(name.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Username");
              return false;
          }
           if(pwd.equals(""))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Password");
              return false;
          }
            if(email.equals("")|| !email.matches("^.+@.+\\..+$"))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Valid Email");
              return false;
          }
             if(contact.equals("")|| !contact.matches("^\\d{10}$"))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Valid Contact no.");
              return false;
          }
           if(contact.equals("")|| !contact.matches("^\\d{10}$"))
          {
              JOptionPane.showMessageDialog(this,"Please Enter Valid Contact no.");
              return false;
          }
          if(adminUsername.equals("Adept Abhi") && adminPassword.equals("12345"))
          return true;
          else
          {
              JOptionPane.showMessageDialog(this,"invalid admin username or password");
              return false;
          }
       }
      //check duplicate users
       public boolean checkDuplicateUser(){
           String name = txt_username.getText();
           boolean isExist = false;
           try
           {
               Connection con=DBConnection.getConnection();
               PreparedStatement pst= con.prepareStatement("select *from users where name = ?");
               pst.setString(1,name);
               ResultSet rs = pst.executeQuery();
               if(rs.next())
                   isExist=true;
                else
                   isExist=false;
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
           return isExist;
       }
       
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Main = new javax.swing.JPanel();
        panel_SignupPage = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        txt_username = new app.bolivia.swing.JCTextField();
        txt_contact = new app.bolivia.swing.JCTextField();
        txt_password = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt_adminUsername = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_adminPassword = new app.bolivia.swing.JCTextField();
        jLabel20 = new javax.swing.JLabel();
        panel_image = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        panel_Main.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_SignupPage.setBackground(new java.awt.Color(102, 102, 255));
        panel_SignupPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Signup Page");
        panel_SignupPage.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 36, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Create New Account Here");
        panel_SignupPage.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 74, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        panel_SignupPage.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 146, -1, 42));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Username :");
        panel_SignupPage.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password :");
        panel_SignupPage.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        panel_SignupPage.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 217, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email :");
        panel_SignupPage.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 267, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        panel_SignupPage.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 289, -1, 42));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact :");
        panel_SignupPage.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 337, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        panel_SignupPage.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 349, -1, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email.setPlaceholder("Enter Email...");
        panel_SignupPage.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 299, -1, -1));

        txt_username.setBackground(new java.awt.Color(102, 102, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username.setPlaceholder("Enter Username...");
        panel_SignupPage.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 156, -1, -1));

        txt_contact.setBackground(new java.awt.Color(102, 102, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact.setPlaceholder("Enter Contact No...");
        panel_SignupPage.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 367, -1, -1));

        txt_password.setBackground(new java.awt.Color(102, 102, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password.setPlaceholder("Enter Password...");
        panel_SignupPage.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 235, -1, -1));

        rSMaterialButtonCircle1.setText("LOGIN");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_SignupPage.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 267, 68));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("SIGNUP");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_SignupPage.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 267, 68));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
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

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("X");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel17)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_SignupPage.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        txt_adminUsername.setBackground(new java.awt.Color(102, 102, 255));
        txt_adminUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_adminUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_adminUsername.setPlaceholder("Enter Admin Username...");
        panel_SignupPage.add(txt_adminUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 180, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Admin Username :");
        panel_SignupPage.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        txt_adminPassword.setBackground(new java.awt.Color(102, 102, 255));
        txt_adminPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_adminPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_adminPassword.setPlaceholder("Enter Admin Password...");
        panel_SignupPage.add(txt_adminPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 170, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Admin Password :");
        panel_SignupPage.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 120, -1));

        panel_Main.add(panel_SignupPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 2, 398, 646));

        panel_image.setBackground(new java.awt.Color(255, 255, 255));
        panel_image.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("DEVELOPER");
        panel_image.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/signup-library-icon.png"))); // NOI18N
        panel_image.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 148, 850, 507));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Welcome To ");
        panel_image.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 86, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 255));
        jLabel16.setText(" AdeptAbhi Library");
        panel_image.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 117, 160, -1));

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("ADEPTABHI");
        panel_image.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        panel_Main.add(panel_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 848, 646));

        getContentPane().add(panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        setSize(new java.awt.Dimension(1250, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
         LoginPage page=new LoginPage();
         page.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(validateSignup() == true)
       {
           if(checkDuplicateUser() == false)
           insertSingupDetails();
           else
           JOptionPane.showMessageDialog(this,"username already exist");  
       }    
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        Color mouseEnterColor = new Color(255,51,51);
        jPanel4.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
       Color mouseExitColor = new Color(102,102,255);
        jPanel4.setBackground(mouseExitColor);
    }//GEN-LAST:event_jPanel4MouseExited

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panel_Main;
    private javax.swing.JPanel panel_SignupPage;
    private javax.swing.JPanel panel_image;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_adminPassword;
    private app.bolivia.swing.JCTextField txt_adminUsername;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
