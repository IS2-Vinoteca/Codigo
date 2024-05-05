package integracion;

import java.util.List;

import negocio.TransferUsuario;

public interface DAOUsuario {

	public List<TransferUsuario> buscarUsuarios();
	public TransferUsuario buscarUsuario(int nif);
	public boolean existeUsuario(int nif);
	public int addUsuario(TransferUsuario usuario);
	public boolean eliminarUsuario(int nif);

}
