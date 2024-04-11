package negocio;
import java.sql.*;
import java.util.List;

import ddbb.DBConnection; //ruta completa?
import integracion.DAOImpUsuario;

import java.io.Serializable;


public class TUsuario implements Serializable, SAUsuario{
	
	private int id; //ver como asignar el id de las tablas
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
	

	public int getId() {
		return id;
	}
	
	public String getNif() {
		return nif;
	}
	
	public String getNombre () {
	return nombre;
	}

	public void setNif (String nif) {
	this.nif = nif;
	}
	
	public String getEmail () {
	return email;
	}

	public void setNombre (String nombre) {
	this.nombre = nombre;
	}

	public void setEmail (String email) {
	this.email = email;
	}
	
	//serialize
	@Override 
	public String toString() {
	return "Usuario [nif=" + nif + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	@Override
	public List<TUsuario> buscarUsuarios() {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		List<TUsuario> lista_usuarios = daoimpusuario.buscarUsuarios();
		return lista_usuarios;
	}
	
	@Override
	public TUsuario buscarUsuario(String id) {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		TUsuario usuario = daoimpusuario.buscarUsuario(id);
		if (usuario == null)				
			return null;
		else return usuario;
	}
	
	//referencia
	@Override
	public int addUsuario(TUsuario usuario) {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		if (daoimpusuario.existeUsuario(usuario.getNif()))
			return -1;
		else daoimpusuario.addUsuario(usuario);
			return 0;
	}
	
	@Override
	public void actualizarUsuario(TUsuario usuario) {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		daoimpusuario.actualizarUsuario(usuario);		
	}
	@Override
	public void eliminarUsuario(TUsuario usuario) {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		daoimpusuario.eliminarUsuario(usuario);
	}

	
	//transfer, service application (SAP)
	//esto iria en la parte de integracion?
	/*public TUsuario buscarUsuario(String id){
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
		
		}*/

	
}
