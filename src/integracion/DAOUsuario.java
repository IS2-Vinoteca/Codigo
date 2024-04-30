package integracion;

import java.util.List;

import negocio.TransferUsuario;

public interface DAOUsuario {

	public List<TransferUsuario> buscarUsuarios(); //SI funciona 
	public TransferUsuario buscarUsuario(int nif); //SI funciona
	public boolean existeUsuario(int nif); //SI funciona
	public int addUsuario(TransferUsuario usuario); //SI funciona
	public void actualizarUsuario(TransferUsuario usuario); //falta
	public boolean eliminarUsuario(int nif); //SI funciona

}
