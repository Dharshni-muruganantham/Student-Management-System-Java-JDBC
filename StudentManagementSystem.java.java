import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "root"
            );

            // 3. Take Input
            System.out.println("Enter ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Department:");
            String dept = sc.nextLine();

            // 4. SQL Query
            String query = "insert into students values(?,?,?)";

            // 5. Prepare Statement
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);

            // 6. Execute Query
            ps.executeUpdate();

            System.out.println("Data Inserted Successfully");

            // 7. Close Connection
            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}