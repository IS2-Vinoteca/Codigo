package integracion;

import java.util.List;

import negocio.TUsuario;

public interface DAOUsuario {

	public List<TUsuario> buscarUsuarios();
	public TUsuario buscarUsuarios(String id);
	public int crearUsuario(TUsuario usuario);
	public void actualizarUsuario(TUsuario usuario);
	public void eliminarUsuario(TUsuario usuario);
	
}
