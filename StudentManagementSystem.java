import java.sql.*;
import java.util.Scanner;

public class StudentJDBC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "root"
            );
            System.out.println("Enter ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Department:");
            String dept = sc.nextLine();

            String query = "insert into students values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);

            ps.executeUpdate();

            System.out.println("Data Inserted Successfully");

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}