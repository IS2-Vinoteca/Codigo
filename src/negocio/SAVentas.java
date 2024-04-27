package negocio;

import java.util.Date;
import java.util.List;

public interface SAVentas {

	public List<Ventas> listadoVentas();
	public List<Ventas> listadoIncidencias();
	public boolean eliminarVenta(int idVenta);
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles);
	boolean registrarVenta(Date fecha, String producto, int cantidad, double precio);
	
}
