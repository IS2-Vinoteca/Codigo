package negocio;

import java.util.List;

public interface SAUsuario {
	
	public List<TUsuario> buscarUsuarios();
	public TUsuario buscarUsuario(String id);
	public int addUsuario(TUsuario usuario);
	public void actualizarUsuario(TUsuario usuario);
	public void eliminarUsuario(TUsuario usuario);
	
}
