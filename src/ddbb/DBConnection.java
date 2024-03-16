package ddbb;
import java.sql.*;

public class DBConnection {
	/**Parametros de conexion**/
	static String bd = "IS2-bbdd-vinoteca";
	static String login = "root"; 
	static String password = "rootmysqlis2";
	static String url = "jdbc:mysql://localhost/"+bd;
	
	Connection connection = null; //representa el contexto de una conexión con la BBDD
	
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
	
	public void executeQuery() { //y devuelve un objeto de tipo ResultSet, que dará acceso a los resultados de la consulta que se haya ejecutado
		String query = " SELECT nombre, poblacion FROM prueba";
		try ( Statement stmt = connection.createStatement ()) {
			ResultSet rs = stmt.executeQuery ( query );
			while (rs.next ()) {
				String name = rs.getString ("nombre");
				long population = rs.getLong ("poblacion");
				System.out.println ( name + " " + population + ")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeUpdate() { // insertar, eliminar o modificar datos
		String query = "UPDATE Provincias SET poblacion=45000 WHERE id=1";
		try ( Statement stmt = connection.createStatement ()) {
		int rowCount = stmt.executeUpdate ( query );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void PreparedStatement() { //útil cuando se repite muchas veces una consulta similar, cambiano sólo algún parámetro
		
		String query = "UPDATE Ventas SET compras=? WHERE nombre=?";
		try ( PreparedStatement st = connection.prepareStatement ( query )) {
		// Se insertan los valores en la consulta :
		st. setInt (1, 750) ;
		st. setString (2, " Naranjas ");
		// Se invoca a executeUpdate sin parametro :
		st. executeUpdate ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


