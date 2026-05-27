import java.sql.*;

public class StudentJDBC {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "root"
            );

            System.out.println("Connected Successfully");

            String query =
            "insert into students values(104,'Dharsh','ECE')";

            Statement st = con.createStatement();

            st.executeUpdate(query);

            System.out.println("Data Inserted Successfully");

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}