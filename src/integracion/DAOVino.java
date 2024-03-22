package integracion;


import java.util.List;

import negocio.Vino;

public interface DAOVino {

	public List<Vino> buscarVinos();
	public Vino buscarVino(String id);
	public int crearVino(Vino vino);
	public void actualizarVino(Vino vino);
	public void eliminarVino(Vino vino);
}
