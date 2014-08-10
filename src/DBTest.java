
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.io.*;
public class DBTest {
	Connection conn;
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String url = "jdbc:derby:";
	String dbName = "E://Program Files//db-derby-10.10.2.0-bin//bin//tongXLDB"; 
	static void loadDriver() {
		try {
			Class.forName(driver).newInstance();
			System.out.println("Loaded the appropriate driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doIt() {
		Connection conn = null;
		Statement s = null,z = null,x = null;
		ResultSet rs = null;
		System.out.println("starting");
		try {
			conn = DriverManager.getConnection(url+dbName+";create=true");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connected to and created database");
		try {
		s=conn.createStatement();
		rs=s.executeQuery("select * from tonghua");
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			conn.close();
			conn = null;
			s.close();
			s = null;
			rs.close();
			rs = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBTest t = new DBTest();
		t.loadDriver();
		t.doIt();
	}
}