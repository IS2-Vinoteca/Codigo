package negocio;

import java.util.List;

public interface SAUsuario {
	
	public List<TUsuario> buscarUsuarios();
	public TUsuario buscarUsuario(int nif);
	public int addUsuario(TUsuario usuario);
	public void actualizarUsuario(TUsuario usuario);
	public boolean eliminarUsuario(int nif);
	
}
