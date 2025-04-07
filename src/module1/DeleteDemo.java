package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
		System.out.println("Connection is successful ....");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee number which you want to delete: ");
		int empno = sc.nextInt();
		
		String str = "delete from emp where empno = ?";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, empno);
		
		int result = ps.executeUpdate();
		if (result > 0) {
			System.out.println("Record Deleted");
		}
		else {
			System.out.println("Some Error Occured");
		}

	}

}
