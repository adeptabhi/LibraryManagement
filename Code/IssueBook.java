/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author adept
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    //Global variable
    boolean isValidStudentId = false;
    boolean isValidBookId = false;
    public IssueBook() {
        initComponents();
        currentDate();
    }
   //to fetch currentDate to the system 
    public Date currentDate()
    {
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
         Date date = new Date();
         date_issueDate.setText(formatter.format(date));
         Date nextdate  = Date.from(Instant.now().plusSeconds(86400)); 
         date_dueDate.setDate(nextdate);
         return nextdate;
    }            
   //to fetch the book details from the database and display it to book details panel
   public void getBookDetails()
   {
       int bookId = Integer.parseInt(txt_bookId.getText());
       try
       {
           java.sql.Connection con = DBConnection.getConnection();
           java.sql.PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
           pst.setInt(1,bookId);
           java.sql.ResultSet rs = pst.executeQuery();
           if(rs.next())
           {
               lbl_bookId.setText(rs.getString("book_id"));
               lbl_bookName.setText(rs.getString("book_name"));
               lbl_author.setText(rs.getString("author"));
               lbl_quantity.setText(rs.getString("quantity"));
               lbl_bookError.setText("Fetched data");
               isValidBookId = true;
           }
           else
           {   
               lbl_bookId.setText("");
               lbl_bookName.setText("");
               lbl_author.setText("");
               lbl_quantity.setText("");
               lbl_bookError.setText("Invalid book ID");
           }   
       }catch(Exception e)
       {
           e.printStackTrace();
       }   
   }
   //to fetch the student details from the database and display it to student details panel
   public void getStudentDetails()
   {
       int studentId = Integer.parseInt(txt_studentId.getText());
       try
       {
           java.sql.Connection con = DBConnection.getConnection();
           java.sql.PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
           pst.setInt(1,studentId);
           java.sql.ResultSet rs = pst.executeQuery();
           if(rs.next())
           {
               lbl_studentId.setText(rs.getString("student_id"));
               lbl_studentName.setText(rs.getString("name"));
               lbl_course.setText(rs.getString("course"));
               lbl_branch.setText(rs.getString("branch"));
               lbl_studentError.setText("Fetched data");
               isValidStudentId = true;
           }
           else
           {
               lbl_studentId.setText("");
               lbl_studentName.setText("");
               lbl_course.setText("");
               lbl_branch.setText("");
               lbl_studentError.setText("Invalid student ID");
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }   
   }
   //insert issue book details to database 
     public boolean issueBook()
     {
       boolean isIssued = false;
       int bookId=Integer.parseInt(txt_bookId.getText());
       int studentId = Integer.parseInt(txt_studentId.getText());
       String bookName = lbl_bookName.getText();
       String studentName = lbl_studentName.getText(); 
       Date date = new Date();  
       Date uIssueDate = date;
       Date uDueDate = date_dueDate.getDate();
       long d1 = uIssueDate.getTime();
       long d2 = uDueDate.getTime();
       java.sql.Date sIssueDate = new java.sql.Date(d1);
       java.sql.Date sDueDate = new java.sql.Date(d2);
       try
       {
           java.sql.Connection con = DBConnection.getConnection();
           String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,bookId);
           pst.setString(2,bookName);
           pst.setInt(3,studentId);
           pst.setString(4,studentName);
           pst.setDate(5,sIssueDate);
           pst.setDate(6,sDueDate);
           pst.setString(7,"pending");
           
           int rowCount = pst.executeUpdate();
           if(rowCount > 0)
               isIssued = true;
           else
               isIssued = false;
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return isIssued; 
   }
   //updating book count
    public void updateBookCount()
    {      
          int bookId = Integer.parseInt(txt_bookId.getText());
          try
          {
           java.sql.Connection con = DBConnection.getConnection();
           String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,bookId);
           int rowCount = pst.executeUpdate();
           if(rowCount > 0)
           {    
               JOptionPane.showMessageDialog(this,"Book count updated");
               int initialCount = Integer.parseInt(lbl_quantity.getText());
               lbl_quantity.setText(Integer.toString(initialCount - 1)); 
           }    
           else
               JOptionPane.showMessageDialog(this,"Can't update book count");
          }catch(Exception e)
          {
              e.printStackTrace();
          }   
    }
    public boolean isAlreadyIssued()
    {
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        try
        {
           java.sql.Connection con = DBConnection.getConnection();
           String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,bookId);
           pst.setInt(2,studentId);
           pst.setString(3,"pending");
           java.sql.ResultSet rs = pst.executeQuery();
           if(rs.next())
              isAlreadyIssued = true;
           else
              isAlreadyIssued = false;
        }catch(Exception e)
        {
             e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Main = new javax.swing.JPanel();
        panel_bookDetails = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        panel_studentDetails = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        panel_issueBook = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        date_dueDate = new com.toedter.calendar.JDateChooser();
        button_issueBook = new rojerusan.RSMaterialButtonCircle();
        jPanel9 = new javax.swing.JPanel();
        date_issueDate = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        panel_Main.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 0, 0)));
        panel_Main.setForeground(new java.awt.Color(51, 51, 51));
        panel_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_bookDetails.setBackground(new java.awt.Color(102, 102, 255));
        panel_bookDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panel_bookDetails.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText(" Book Details");
        panel_bookDetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 220, 100));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        panel_bookDetails.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 320, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quantity :");
        panel_bookDetails.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 90, -1));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        panel_bookDetails.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 210, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book Name :");
        panel_bookDetails.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Author :");
        panel_bookDetails.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 90, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Book Id :");
        panel_bookDetails.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        panel_bookDetails.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 210, 40));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        panel_bookDetails.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 210, 40));

        lbl_author.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        panel_bookDetails.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 210, 40));

        lbl_bookError.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(153, 0, 0));
        panel_bookDetails.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 210, 40));

        panel_Main.add(panel_bookDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 400, 646));

        panel_studentDetails.setBackground(new java.awt.Color(153, 153, 255));
        panel_studentDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel4.setText("Student Details");
        panel_studentDetails.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 250, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        panel_studentDetails.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Branch :");
        panel_studentDetails.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 90, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Course :");
        panel_studentDetails.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 90, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Student Name :");
        panel_studentDetails.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 100, -1));

        lbl_course.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        panel_studentDetails.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 210, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student Id :");
        panel_studentDetails.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 90, -1));

        lbl_studentId.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        panel_studentDetails.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 210, 40));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        panel_studentDetails.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 210, 40));

        lbl_branch.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        panel_studentDetails.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 210, 40));

        lbl_studentError.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(153, 0, 0));
        panel_studentDetails.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 210, 40));

        panel_Main.add(panel_studentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 2, 400, 646));

        panel_issueBook.setBackground(new java.awt.Color(255, 255, 255));
        panel_issueBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("Issue Book");
        panel_issueBook.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, -1));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        panel_issueBook.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Book Id :");
        panel_issueBook.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        panel_issueBook.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 275, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Student Id :");
        panel_issueBook.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        panel_issueBook.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 275, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Issue Date :");
        panel_issueBook.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Select Due Date :");
        panel_issueBook.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        date_dueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));
        date_dueDate.setForeground(new java.awt.Color(255, 51, 51));
        date_dueDate.setDateFormatString("dd-MM-yyyy");
        date_dueDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        date_dueDate.setMinSelectableDate(currentDate());
        panel_issueBook.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 270, 40));

        button_issueBook.setBackground(new java.awt.Color(255, 51, 51));
        button_issueBook.setText("Issue Book");
        button_issueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_issueBookActionPerformed(evt);
            }
        });
        panel_issueBook.add(button_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 290, 60));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 1, new java.awt.Color(255, 0, 0)));

        date_issueDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(date_issueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        panel_issueBook.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 270, 40));

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

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(225, 51, 51));
        jLabel18.setText("X");

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

        panel_issueBook.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        panel_Main.add(panel_issueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 2, 446, 646));

        getContentPane().add(panel_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        setSize(new java.awt.Dimension(1250, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void button_issueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_issueBookActionPerformed
        getBookDetails();
        getStudentDetails();
        if(isValidBookId == true && isValidStudentId == true)  
        {
            if(lbl_quantity.getText().equals("0"))
                JOptionPane.showMessageDialog(this,"Book is not available");
            else
            {     
                 if(isAlreadyIssued() == false)
                 {   
                   if(issueBook() == true)
                   {   
                      JOptionPane.showMessageDialog(this,"Book issued successfully");
                      updateBookCount();
                    }else
                     JOptionPane.showMessageDialog(this,"Can't book issue");     
                  }else
                     JOptionPane.showMessageDialog(this,"This student already has this book");    
            }
        }else
        JOptionPane.showMessageDialog(this,"invalid student ID or book ID");
        
        isValidStudentId = false;
        isValidBookId = false;
    }//GEN-LAST:event_button_issueBookActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals(""))
         getBookDetails();
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals(""))
        getStudentDetails();
    }//GEN-LAST:event_txt_studentIdFocusLost

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle button_issueBook;
    private com.toedter.calendar.JDateChooser date_dueDate;
    private javax.swing.JLabel date_issueDate;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_Main;
    private javax.swing.JPanel panel_bookDetails;
    private javax.swing.JPanel panel_issueBook;
    private javax.swing.JPanel panel_studentDetails;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
