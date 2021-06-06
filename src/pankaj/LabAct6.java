package pankaj;

import java.sql.*;
import java.util.Scanner;

public class LabAct6 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        Statement st = con.createStatement();

        //create a student database

           //st.executeUpdate("CREATE DATABASE STUDENT;");


        //create a student_details table

            st.executeUpdate("CREATE TABLE STUDENT_DETAILS(STUDENT_REG_NO CHAR(9) PRIMARY KEY ,NAME VARCHAR(20) NOT NULL, AGE TINYINT NOT NULL, ADDRESS VARCHAR(100) NOT NULL, EMAIL VARCHAR(50) NOT NULL UNIQUE , PHONE_DETAILS BIGINT NOT NULL UNIQUE);");


        //insert at least 10 values in Student_details table

            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BCE0572','Pankaj Sharma', 20, 'JAIPUR', 'pankaj.sharma2019@vitstudent.ac.in', 6350021339);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0179','Saksham Arora', 20, 'MUZAFFARNAGAR', 'saksham.arora2019@vitstudent.ac.in', 7310866300);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0164','Swetank Kaushik', 21, 'DELHI', 'swetank.kaushik2019@vitstudent.ac.in', 7310866399);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0156','Akshat Mishra', 20, 'CHANDIGARH', 'akshat.mishra2019@vitstudent.ac.in', 7310866388);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0181','Pranav Gupta', 20, 'NOIDA', 'pranav.gupta2019@vitstudent.ac.in', 7310866377);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0177','Rohin Srivastava', 20, 'AHMEDABAD', 'rohin.srivastava2019@vitsudent.ac.in', 7310866366);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0153','Devansh Chauhan', 22, 'SURAT', 'devansh.chauhan2019@vitstudent.ac.in', 7310866355);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0176','Shashvat Adhaduk', 20, 'PUNE', 'shashvat.adhaduk2019@vitstudent.ac.in', 7310866344);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0183','Yash Patel', 21, 'JODHPUR', 'yash.patel2019@vitstudent.ac.in', 7310866333);");
            st.executeUpdate("INSERT INTO STUDENT.STUDENT_DETAILS VALUES('19BIT0185','Sahil Saxena', 21, 'MUMBAI', 'sahil.saxena2019@vitstudent.ac.in', 7310866222);");


        // get the student_reg_no or student name to display student details
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Choose an option:\n" +
                    "1. Get student details on the basis of Student_reg_no or Student name\n" +
                    "2. Delete student details based on phone number or email\n" +
                    "3. Exit"
            );
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.println("Enter the Student's Reg No or Student's Name:");
                String entered = sc.nextLine();
                ResultSet resultSet = st.executeQuery("SELECT * FROM STUDENT.STUDENT_DETAILS WHERE NAME='"+entered+"' OR STUDENT_REG_NO='" + entered + "';");
                if(!resultSet.next()) System.out.println("No results found\n");
                else
                    System.out.println(
                            "Student_reg_no: "+ resultSet.getString(1)+"\n" +
                                    "Name: "+ resultSet.getString(2)+"\n" +
                                    "Age: "+ resultSet.getString(3)+"\n" +
                                    "Address: "+ resultSet.getString(4)+"\n" +
                                    "Email: "+ resultSet.getString(5)+"\n" +
                                    "Phone_Details: "+ resultSet.getString(6)+"\n"
                    );
            }
            else if(choice == 2){
                System.out.println("Enter phone number or email:");
                String entered = sc.nextLine();
                    try {
                        st.executeUpdate("DELETE FROM STUDENT.STUDENT_DETAILS WHERE PHONE_DETAILS = " + entered + " OR EMAIL = '" + entered + "';");
                        System.out.println("Record deleted successfully\n");
                    } catch (Exception e) {
                        System.out.println("Error executing the statement. Check details entered and try again");
                    }
            }
            else if(choice == 3) break;
            else System.out.println("Invalid choice");
        }
    }
}