package Day18;

import java.sql.*;
import java.util.Scanner;

public class ExecuteBatch {

	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/testing";
		String username = "root";
		String password = "";
		
		try(Connection con = DriverManager.getConnection(url,username,password);
				Scanner sc = new Scanner(System.in)) {
			String insert = "INSERT INTO employees(empNo,name,salary,birthday)VALUES(?,?,?,?)";
			
			PreparedStatement pstm = con.prepareStatement(insert);
			
			for(var i = 1; i <= 3; i++) {
				System.out.print("Enter employee no: ");
				pstm.setInt(1, Integer.parseInt(sc.nextLine()));
				
				System.out.print("Enter employee name: ");
				pstm.setString(2, sc.nextLine());
				
				System.out.print("Enter salary: ");
				pstm.setDouble(3, Double.parseDouble(sc.nextLine()));
				
				System.out.print("Enter birthday(yyyy-MM-dd): ");
				pstm.setDate(4, Date.valueOf(sc.nextLine()));
				
				pstm.addBatch();
			}
			int[] result = pstm.executeBatch();
			
			System.out.println("No of rows: " + result != null ? result.length : 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
