package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

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
						"jdbc:oracle:thin:@70.12.50.220:1521:xe";
//				String ip="70.12.50.220";
				
				Connection con = null;
				try {
					con = DriverManager.getConnection(url, id, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Connection Error");
					e.printStackTrace();
				}
				
				// 3. SQL 전송
				String sql="UPDATE T_USER SET PWD=?, NAME=?, WHERE ID=?";
				PreparedStatement pstmt=null;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "0000");
					pstmt.setString(2,  "독수리");
					pstmt.setString(3, "id300");
					int result = pstmt.executeUpdate();
					System.out.println(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					pstmt.close();
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}

	}

}
