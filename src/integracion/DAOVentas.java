package integracion;

import java.util.Date;
import java.util.List;

import negocio.TransferVentas;

public interface DAOVentas {


	public List<TransferVentas> listadoVentas();
	public List<TransferVentas> listadoIncidencias();
	public boolean eliminarVenta(int idVenta);
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles);
	public boolean registrarVenta(Date fecha, String producto, int cantidad, double precio);
	public TransferVentas obtenerVentaPorId(int idVenta);

}
