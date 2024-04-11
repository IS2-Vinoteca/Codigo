package integracion;

import java.util.List;

import negocio.TUsuario;

public interface DAOUsuario {

	public List<TUsuario> buscarUsuarios();
	public TUsuario buscarUsuario(String id);
	public boolean existeUsuario(String id);
	public int addUsuario(TUsuario usuario);
	public void actualizarUsuario(TUsuario usuario);
	public void eliminarUsuario(TUsuario usuario);
	
	
}
