package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class GetEmployee {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// forName() ---> loads the driver in the memory
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
		System.out.println("Connection is Succesful..");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from emp");
		while(rs.next()) {
			System.out.println("Employee no is: " + rs.getInt(1));
			System.out.println("Employee name is: " + rs.getString(2));
			System.out.println("Employee salary is: " + rs.getInt(3));
			System.out.println("============================");
		}

	}

}
