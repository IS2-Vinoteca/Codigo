package integracion;

import java.util.List;

import negocio.TUsuario;

public interface DAOUsuario {

	public List<TUsuario> buscarUsuarios(); //SI funciona 
	public TUsuario buscarUsuario(int nif); //SI funciona
	public boolean existeUsuario(int nif); //SI funciona
	public int addUsuario(TUsuario usuario); //SI funciona
	public void actualizarUsuario(TUsuario usuario); //falta
	public boolean eliminarUsuario(int nif); //SI funciona

}
