package negocio;

import java.util.List;

public interface SAUsuario {
	
	public List<TransferUsuario> buscarUsuarios();
	public TransferUsuario buscarUsuario(int nif);
	public int addUsuario(TransferUsuario usuario);
	public boolean eliminarUsuario(int nif);
	
}
