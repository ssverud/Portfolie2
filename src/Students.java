
import java.sql.*; //from jdbc
import java.util.Scanner;

import static java.sql.DriverManager.*;

public class Students {

    public static void main(String[] args) {
        Connection conn = null;
        try {

            // Path of database
            String url = "jdbc:sqlite:/Users/nybruger/Desktop/portfolie2.db";

            // This path is provided to get connection
            conn = getConnection(url);

                // Contains a statement for connection conn
                Statement stmt = conn.createStatement();

                System.out.println("input student ID nr");

                // creating scanner 1 and 2
                Scanner scanner1 = new Scanner(System.in);
                Scanner scanner2 = new Scanner(System.in);

                int studentID = scanner1.nextInt();

                // presenting user with choises
                System.out.println("Input one of the following courses");
                System.out.println("1: ES2019");
                System.out.println("2: SD2019");
                System.out.println("3: SD2020");
                System.out.println("Choose 1, 2 or 3:");

                String courseID = scanner2.nextLine();

                // Calculating average grade for a given student, where studentID is given by scanner1
                ResultSet rs1 = stmt.executeQuery("SELECT avg(Grade) from Grade WHERE StudentID='"+studentID+"'");
                if(rs1.next())
                    System.out.println("Average grade for student nr. " + studentID + " = " + rs1.getFloat(1));

                // Calculating avarage grade for a given course, where courseID is given by scanner2
                ResultSet rs2 = stmt.executeQuery("SELECT avg(Grade) from Grade WHERE CourseID='"+courseID+"'");
                if(rs2.next())
                    System.out.println("Average grade for course " + courseID + " = " + rs2.getFloat(1));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static public void PresentGrades(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No records for customer");
        while (res != null & res.next()) {
            int studentID = res.getInt("StudentID");

            int grade = res.getInt("Grade");
            System.out.println(studentID + " " + grade);
        }
    }
}


