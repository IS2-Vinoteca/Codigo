package negocio;

import java.util.Date;
import java.util.List;

public interface SAVentas {

	public List<TransferVentas> listadoVentas();
	public List<TransferVentas> listadoIncidencias();
	public boolean eliminarVenta(int idVenta);
	public boolean actualizarIncidencia(int idVenta, String incidencia, String detalles);
	boolean registrarVenta(Date fecha, String producto, int cantidad, double precio);
	
}
