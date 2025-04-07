package module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoCustomer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/symbiosys", "root", "8i9njd9fvr");
		System.out.println("Connection is successful ....");
		
		Statement stmt = con.createStatement();
		
		String str1 = "insert into customer values(1, 'Kamlesh', 'kamlesh@gmail.com', 1122334455, 'HC09PB008')";
		String str2 = "insert into customer values(2, 'Ramlesh', 'ramlesh@gmail.com', 1122334454, 'HC09PB007')";
		String str3 = "insert into customer values(3, 'Samlesh', 'samlesh@gmail.com', 1122334453, 'HC09PB006')";
		String str4 = "insert into customer values(4, 'Mamlesh', 'mamlesh@gmail.com', 1122334452, 'HC09PB005')";
		String str5 = "insert into customer values(5, 'Aamlesh', 'aamlesh@gmail.com', 1122334451, 'HC09PB004')";
		
		
		int result1 = stmt.executeUpdate(str1);
		int result2 = stmt.executeUpdate(str2);
		int result3 = stmt.executeUpdate(str3);
		int result4 = stmt.executeUpdate(str4);
		int result5 = stmt.executeUpdate(str5);
		
		stmt.close();
		con.close();
	

	}

}