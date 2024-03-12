package ddbb;
import java.sql.*;

public class DBConnection {
	/**Parametros de conexion**/
	static String bd = "IS2-bbdd-vinoteca";
	static String login = "root"; 
	static String password = "rootmysqlis2";
	static String url = "jdbc:mysql://localhost/"+bd;
	Connection connection = null;
	public DBConnection() { 
	try {
	// String url = " jdbc : mysql :// hostname / database - name ";
	connection = DriverManager.getConnection (url,login,password);
	} 
	catch ( SQLException ex) {
	connection = null ;
	ex. printStackTrace ();
	System.out.println (" SQLException : " + ex. getMessage ());
	System.out.println (" SQLState : " + ex. getSQLState ());
	System.out.println (" VendorError : " + ex. getErrorCode ());
	}
	}
	public Connection getConnection(){
	return connection;
	}
	public void desconectar(){
	connection = null;
	}
}


//diapositiva 9 3-JDBC
