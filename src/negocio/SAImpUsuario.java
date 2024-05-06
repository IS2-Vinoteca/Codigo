package negocio;

import java.util.List;
import integracion.DAOImpUsuario;
public class SAImpUsuario implements SAUsuario {

	  private static SAImpUsuario instance;
	  private TransferUsuario TUsuario;

	  private SAImpUsuario() {}

	  public SAImpUsuario(TransferUsuario TUsuario) {
		  this.TUsuario = new TransferUsuario(TUsuario.getNif(), TUsuario.getNombre(), TUsuario.getEmail());
	  }
	  
	  public static SAImpUsuario getInstance() {
	    if (instance == null) {
	      instance = new SAImpUsuario();
	    }
	    return instance;
	  }

	  public List<TransferUsuario> buscarUsuarios() {
	    DAOImpUsuario daoImpUsuario = new DAOImpUsuario(); 
	    List<TransferUsuario> lista_usuarios = daoImpUsuario.buscarUsuarios();
	    return lista_usuarios;
	  }

	  public TransferUsuario buscarUsuario(int nif) {
	    DAOImpUsuario daoImpUsuario = new DAOImpUsuario();
	    TransferUsuario usuario = daoImpUsuario.buscarUsuario(nif);
	    if (usuario == null)
	      return null;
	    else
	      return usuario;
	  }

	  // referencia
	  public int addUsuario(TransferUsuario usuario) {
	    DAOImpUsuario daoImpUsuario = new DAOImpUsuario();
	    int result;
	    if (!daoImpUsuario.existeUsuario(usuario.getNif()))
	      result = daoImpUsuario.addUsuario(usuario);
	    else
	      result = -1;

	    return result;
	  }

	  public boolean eliminarUsuario(int nif) {
	    DAOImpUsuario daoImpUsuario = new DAOImpUsuario(); 
	    boolean eliminado = daoImpUsuario.eliminarUsuario(nif);
	    return eliminado;
	  }
	}
