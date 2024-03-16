package negocio;
import java.sql.*;
import ddbb.DBConnection; //ruta completa?
import java.io.Serializable;


public class TUsuario implements Serializable{
	private String nif; 
	private String nombre;
	private String email;
	public TUsuario () {
	}
	public TUsuario (String nif, String nombre, String email) {
	this.nif = nif; 
	this.nombre = nombre;
	this.email = email;
	}

	public TUsuario buscarUsuario(String id){
		DBConnection conex = new DBConnection();
		TUsuario usuario = new TUsuario();
		
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuario where nif = ? ");
			consulta.setString(1, id);
			ResultSet res = consulta.executeQuery();
			
			if(res.next()){
				usuario.setNif (res.getString("nif"));
				usuario.setNombre (res.getString("nombre")); 
				usuario.setEmail (res.getString("email"));
				}else {
					usuario.setNif("-1");
				}
			res.close();
			consulta.close();
			conex.desconectar();
				
			} catch (Exception e) {
			System.out.println("no se pudo realizar la consultar para encontrar al usuario"+id+" \n"+e);
			// No aqui. En una vista.
			}
		
		return usuario;
		
		}

		public String getNif () {
			return nif;
		}
	
		public void setNif (String nif) {
		this.nif = nif;
		}
		
		public String getNombre () {
		return nombre;
		}
	
		public void setNombre (String nombre) {
		this.nombre = nombre;
		}
		
		public String getEmail () {
		return email;
		}
		
		public void setEmail (String email) {
		this.email = email;
		}
		
		@Override
		public String toString() {
		return "Usuario [nif=" + nif + ", nombre=" + nombre + ", email=" + email + "]";
		}
	
	
	
}
