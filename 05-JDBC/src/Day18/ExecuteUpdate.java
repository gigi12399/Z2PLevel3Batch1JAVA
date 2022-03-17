package Day18;

import java.sql.*;
import java.time.LocalDate;

public class ExecuteUpdate {

	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/testing";
		String username = "root";
		String password = "";
		
		try(Connection com = DriverManager.getConnection(url,username,password)) {
			/*String query1 = "SELECT * FROM employees";
			PreparedStatement pstm = com.prepareStatement(query1);
			
			ResultSet res = pstm.executeQuery();
			while(res.next()) {
				System.out.println("EmpNo: " + res.getInt(1)); // index
				System.out.println("Name: " + res.getString(2));
				System.out.println("Birthday: " + res.getDate("birthday")); // column name
				System.out.println("Salary: " + res.getDouble("salary"));
				System.out.println("----------------------------------------");
			}*/
			
			// retrieve specific rows
			/*String query = "SELECT * FROM employees WHERE salary BETWEEN ? AND ?";
			PreparedStatement pstm = com.prepareStatement(query);
			pstm.setDouble(1, 500000);
			pstm.setDouble(2, 800000);
			
			ResultSet res = pstm.executeQuery();
			while(res.next()) {
				System.out.println("EmpNo: " + res.getInt(1)); // index
				System.out.println("Name: " + res.getString(2));
				System.out.println("Birthday: " + res.getDate("birthday")); // column name
				System.out.println("Salary: " + res.getDouble("salary"));
				System.out.println("----------------------------------------");
			}*/
			
			/*String query = "SELECT empNo,name FROM employees WHERE empNo IN(?,?,?)";
			PreparedStatement pstm = com.prepareStatement(query);
			pstm.setInt(1, 1001);
			pstm.setInt(2, 1004);
			pstm.setInt(3, 1002);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				System.out.println("EmpNo: " + rs.getInt("empNo"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("----------------------------------------");
			}*/
			
			String query = "SELECT * FROM employees WHERE empNo = 1006";
			PreparedStatement pstm = com.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
				System.out.println("This user is in the database.");
			else
				System.out.println("There is no user with this id.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
