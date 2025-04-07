package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
		System.out.println("Connection is successful ....");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the increment: ");
		int incr = sc.nextInt();
		
		System.out.println("Enter the employee name: ");
		String name = sc.next();
		
		String str = "update emp set sal = sal + ? where ename = ?";
		
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, incr);
		ps.setString(2, name);
		
		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Update Successful");
		}
		else {
			System.out.println("Some Error Occured");
		}
	}

}
	