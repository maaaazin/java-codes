package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLOperations {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
		System.out.println("Connection is successful ....");
		
		Statement stmt = con.createStatement();
		//to insert a row
		String str1 = "insert into emp values(5, 'Nilesh', 60000)";
		int result = stmt.executeUpdate(str1);
		System.out.println("Result is " + result);
		
		if(result > 0) {
			System.out.println("record is inserted..");
		}
		else {
			System.out.println("record is not inserted..");
		}
		
		//to update a record/tuple
//		System.out.println("===========================");
//		String str1 = "update employee set sal =  sal + 5000 where ename = 'priti'";
//		int result = stmt.executeUpdate(str1);
//		System.out.println("Result is " + result);
//		
//		if(result > 0) {
//			System.out.println("record is updated..");
//		}
//		else {
//			System.out.println("record is not updated..");
//		}
		
		//to delete a record/tuple
//		System.out.println("===========================");
//		String str1 = "delete from employee where ename = 'Nitya'";
//		int result = stmt.executeUpdate(str1);
//		System.out.println("Result is " + result);
//		
//		if(result > 0) {
//			System.out.println("record is deleted..");
//		}
//		else {
//			System.out.println("record is not deleted..");
//		}
//		
//		stmt.close();
//		con.close();
	}
}