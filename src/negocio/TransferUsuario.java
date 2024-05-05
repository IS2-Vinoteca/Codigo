package negocio;

import java.io.Serializable;


public class TransferUsuario implements Serializable {
	
	private int nif; 
	private String nombre;
	private String email;
	
	public TransferUsuario () {
	}
	
	public TransferUsuario (int nif, String nombre, String email) {
		if(nif != 0) {
			this.nif = nif; 
		}
		
		this.nombre = nombre;
		this.email = email;
	}
	
	
	public int getNif() {
		return nif;
	}
	
	public String getNombre () {
		return nombre;
	}

	public void setNif (int nif) {
		if(nif == 0) {
			
		} else {this.nif = nif; }
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
	
}
