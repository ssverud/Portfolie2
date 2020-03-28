
import java.sql.*; //from jdbc
import java.util.Scanner;

import static java.sql.DriverManager.*;

public class TrainJDBC {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Path of database
            String url = "jdbc:sqlite:/Users/nybruger/Desktop/portfolie2.db";
            // This path is provided to get connection
            conn = getConnection(url);

                // Contains a statement for connection conn
                Statement stmt = conn.createStatement();


                /*// A string containing the SQL syntax
                String sql;
                sql = "SELECT * FROM Students";
                // Execute the statement and return the selected to ResultSet rs
                ResultSet rs = stmt.executeQuery(sql);
                //Provide the PresentDepartures function with the result set rs to print to screen
                 PresentStudents(rs);

                // same recipie as above
                String gradeAVG;
                gradeAVG = "SELECT * FROM Grade";
                ResultSet rs2 = stmt.executeQuery(gradeAVG);
                PresentGrades(rs2);*/

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

                ResultSet rs1 = stmt.executeQuery("SELECT avg(Grade) from Grade WHERE StudentID='"+studentID+"'");
                if(rs1.next())
                    System.out.println("Average grade for student nr. " + studentID + " = " + rs1.getFloat(1));

                ResultSet rs2 = stmt.executeQuery("SELECT avg(Grade) from Grade WHERE CourseID='"+courseID+"'");
                if(rs2.next())
                    System.out.println("Average grade for course " + courseID + " = " + rs2.getFloat(1));


/*
                // The same with a prepared statement
                String psql= "SELECT * FROM Departure WHERE stationname= ?";
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(psql);
                pstmt.setString(1, "København H");
                rs = pstmt.executeQuery();
                PresentDepartures(rs);
/*
                // Do the join from the yesterdays exercise
                String ptripsql= "SELECT D1.stationname as startstation,D1.time as starttime, " +
                        "D2.stationname as endstation, D2.time as endtime" +
                        "  FROM Departure as D1 " +
                        "join Departure as D2 on D1.trainid =D2.trainid " +
                        "WHERE D1.stationname= ? and D2.stationname= ? and D1.time<D2.time and D1.time >= ?";
                PreparedStatement pTripStmt = conn.prepareStatement(ptripsql);
                System.out.println("Which station do you wish to find departures for?");
                departureStation = scanner.nextLine();
                System.out.println("Which station do you want to go to?");
                String endStation = scanner.nextLine();
                System.out.println("Which time do you depart (as float)?");
                float  ftime = scanner.nextFloat();
                pTripStmt.setString(1,departureStation);
                pTripStmt.setString(2,endStation);
                pTripStmt.setFloat(3, ftime);
                rs = pTripStmt.executeQuery();
                PresentTrips(rs);

                // Insert and Update
                String sqlInsert = "INSERT INTO departure (stationname, trainid, time) " +
                        " VALUES ('København H',2,5.00),('Høje Tåstrup',2,5.15)," +
                        "('Roskilde',2,5.22),('Ringsted',2,5.38),('Odense',2,6.36)";
                PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert);
                int rowsaffected=pstmtInsert.executeUpdate();
                System.out.println("Number of rows affected "+ rowsaffected);

*/

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

    // Print function from ResultSet
    static public void PresentStudents(ResultSet res)
            throws SQLException {
        if (res == null)
            System.out.println("No records for customer");
        while (res != null & res.next()) {
            String fname = res.getString("FirstName");
            String lname = res.getString("LastName");
            System.out.println(lname + " " + fname);
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


