package A07Static_Banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static String bd="banco";
	public static String login="root";
	public static String pass="";
	public static String host="localhost";
	public static String url="";
	
	public static Connection con=null;

	
	public static void open() {
		
		try {
			if ((con==null) || (con.isClosed())) {
				url="jdbc:mysql://"+host+"/"+bd+"?useSSL=false";
				Class.forName("org.mariadb.jdbc.Driver");
				con=DriverManager.getConnection(url, login, pass);
			}
		} catch (Exception e) {
			System.out.println("No se puede conectar!!!");
		}
		
	}
	
	public static void close() {
		try {
			if (!con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			
		}
	}
	
	
}
