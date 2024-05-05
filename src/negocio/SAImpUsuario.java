package negocio;

import java.util.List;
import integracion.DAOImpUsuario;


public class SAImpUsuario implements SAUsuario{
	
	private TransferUsuario TUsuario;
	
	public SAImpUsuario() {}

	public SAImpUsuario(TransferUsuario TUsuario) {
		this.TUsuario = TUsuario;	
	}
	
	@Override
	public List<TransferUsuario> buscarUsuarios() {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		List<TransferUsuario> lista_usuarios = daoimpusuario.buscarUsuarios();
		return lista_usuarios;
	}
	
	@Override
	public TransferUsuario buscarUsuario(int nif) {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		TransferUsuario usuario = daoimpusuario.buscarUsuario(nif);
		if (usuario == null)				
			return null;
		else return usuario;
	}
	
	//referencia
	@Override
	public int addUsuario(TransferUsuario usuario) {
		DAOImpUsuario daoimpusuario = new DAOImpUsuario();
		int result;
		if (!daoimpusuario.existeUsuario(usuario.getNif()))
			result = daoimpusuario.addUsuario(usuario);
		else 
			result = -1;
		
		return result;
	}
	
	@Override
	public boolean eliminarUsuario(int nif) {
	    boolean eliminado = false;
	    DAOImpUsuario daoImpUsuario = new DAOImpUsuario();
	    eliminado = daoImpUsuario.eliminarUsuario(nif);
	    return eliminado;
	}

	
	

	
}
