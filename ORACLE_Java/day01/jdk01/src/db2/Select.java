package db2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		// 1. JDBC Driver Loading...
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Error");
		}
		// 2. Connection 1521
		String id="db";
		String password="db";
		String url=
				"jdbc:oracle:thin:@70.12.50.245:1521:xe";
//		String ip="70.12.50.220";
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		
		// 3. SQL Àü¼Û
		String sql="SELECT * FROM T_PRODUCT WHERE ID=?";
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "P01");
			rset = pstmt.executeQuery();
			rset.next();
			String uid=rset.getString("ID");
			String uname = rset.getString("NAME");
			Integer price = rset.getInt("PRICE");
			Date date = rset.getDate("REGDATE");
			System.out.println(uid+" "+uname+" "+price+" "+date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rset.close();
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}


	}

}
