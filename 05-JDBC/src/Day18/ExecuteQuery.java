package Day18;

import java.sql.*;
import java.time.LocalDate;

public class ExecuteQuery {

	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/testing";
		String username = "root";
		String password = "";
		
		try(Connection com = DriverManager.getConnection(url,username,password)) {
			String insert = """
					INSERT INTO employees(empNo,name,salary,birthday)VALUES(?,?,?,?)
					""";
			
			// prepareStatement
			PreparedStatement pstm = com.prepareStatement(insert);
			pstm.setInt(1, 1001);
			pstm.setString(2, "Htet Htet");
			pstm.setDouble(3, 500000);
			
			LocalDate dob = LocalDate.of(1995, 9, 1);
			pstm.setDate(4, Date.valueOf(dob));
			
			int result = pstm.executeUpdate();
			System.out.println((result > 0) ? "Insert Success" : "Insert Fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
