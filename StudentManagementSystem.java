import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "root"
            );

            System.out.println("Connected Successfully");

            System.out.println("Enter Student ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student Name:");
            String name = sc.nextLine();

            System.out.println("Enter Department:");
            String dept = sc.nextLine();

            String insertQuery =
            "insert into students values(?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(insertQuery);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

System.out.println("\nEnter Student ID to Update:");
int updateId = sc.nextInt();
sc.nextLine();

System.out.println("Enter New Department:");
String newDept = sc.nextLine();

String updateQuery =
"update students set department=? where id=?";

PreparedStatement ups =
con.prepareStatement(updateQuery);

ups.setString(1, newDept);
ups.setInt(2, updateId);

int rows = ups.executeUpdate();

if(rows > 0) {

    System.out.println("Student Updated Successfully");

} else {

    System.out.println("Student ID Not Found");
}

System.out.println("\nEnter Student ID to Delete:");
int deleteId = sc.nextInt();

String deleteQuery =
"delete from students where id=?";

PreparedStatement dps =
con.prepareStatement(deleteQuery);

dps.setInt(1, deleteId);

int deletedRows = dps.executeUpdate();

if(deletedRows > 0) {

    System.out.println("Student Deleted Successfully");

} else {

    System.out.println("Student ID Not Found");
}

            String selectQuery =
"select * from students";

Statement st = con.createStatement();

ResultSet rs = st.executeQuery(selectQuery);

System.out.println("\nSTUDENT RECORDS");
System.out.println("------------------------");

while(rs.next()) {

    System.out.println(
        rs.getInt("id") + "  " +
        rs.getString("name") + "  " +
        rs.getString("department")
    );
}

            con.close();

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}