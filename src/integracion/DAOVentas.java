package integracion;

import java.util.List;

import negocio.Ventas;

public interface DAOVentas {


	public List<Ventas> listadoVentas();
	public List<Ventas> listadoIncidencias();
	public boolean eliminarVenta(int idVenta);
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles);
}
