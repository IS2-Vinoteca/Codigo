package negocio;

import java.util.List;

public interface SAVentas {

	public List<Ventas> listadoVentas();
	public List<Ventas> listadoIncidencias();
	public boolean eliminarVenta(int idVenta);
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles);
	
}
