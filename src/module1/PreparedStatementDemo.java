package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
		System.out.println("Connection is successful ....");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee number: ");
		int empno = sc.nextInt();
		
		System.out.println("Enter employee name: ");
		String empname = sc.next();
		
		System.out.println("Enter employee Salary: ");
		int empSal = sc.nextInt();
		
		String str = "insert into emp values(?, ?, ?)"; // ? -> placeholder
		PreparedStatement ps = con.prepareStatement(str);
		
		// To set values
		ps.setInt(1, empno);
		ps.setString(2, empname);
		ps.setInt(3, empSal);
		
		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Record Inserted");
		}
		else {
			System.out.println("Some Error Occured");
		}
		
	}

}
	