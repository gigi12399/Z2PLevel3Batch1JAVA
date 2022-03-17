package Day17;

import java.sql.*;

public class Testing_1 {
	public static void main(String[] args) {
		
		// way1
		try(Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testing", "root", "")) {
			System.out.println("Create Connection Object!");
			
			/*
			// create statement
			Statement stm = con.createStatement(); 
			
			// query define
			String insert = "INSERT INTO users(username,email,password)VALUES('Hla Hla','hla@gmail.com', 'hla')";
			
			// execute query
			int result = stm.executeUpdate(insert);
			
			System.out.println("No of rows: " + result);*/
			
			/*
			String insert = "INSERT INTO users(username,email,password)VALUE(?,?,?)";
			
			// prepare statement
			PreparedStatement pstm = con.prepareStatement(insert);
			
			pstm.setString(1, "Yuki");
			pstm.setString(2, "yuki@gmail.com");
			pstm.setString(3, "yuki");
			
			// execute query
			int result = pstm.executeUpdate();
			System.out.println("No of affected rows: " + result);*/
			
			// using callableStatement
			String query = "{call saveUsers(?,?,?)}";
			
			// CallableStatement
			CallableStatement cstm = con.prepareCall(query);
			cstm.setString(1, "Cherry");
			cstm.setString(2, "cherry@gmail.com");
			cstm.setString(3, "cherry");
			
			// execute statement
			int result = cstm.executeUpdate();
			System.out.println("No of rows: " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		// way2
//		try(Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testing?user=root")){
//			System.out.println("Connection is created!"); 
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
