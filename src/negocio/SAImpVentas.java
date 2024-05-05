package negocio;

import java.util.Date;
import java.util.List;

import integracion.DAOImpVentas;

public class SAImpVentas implements SAVentas{
    
	private TransferVentas TVentas;
	
    // Constructor
	public SAImpVentas() {
		
	}
	
	public SAImpVentas(TransferVentas TVentas) {
	
		this.TVentas = TVentas;
	}


	@Override
	public List<TransferVentas> listadoVentas() {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.listadoVentas();
	}

	@Override
	public List<TransferVentas> listadoIncidencias() {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.listadoIncidencias();
	}
	@Override
	public boolean eliminarVenta(int idVenta) {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.eliminarVenta(idVenta);
	}
	public boolean actualizarIncidencia(int idVenta, String incidencia, String detalles) {
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.actualizarIncidencia(idVenta,incidencia, detalles);
	}
	
	public boolean registrarVenta(Date fecha, String producto, int cantidad, double precio) {
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.registrarVenta(fecha, producto, cantidad, precio);
	}
	
}
