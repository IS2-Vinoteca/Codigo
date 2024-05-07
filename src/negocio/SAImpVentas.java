package negocio;

import java.util.Date;
import java.util.List;

import integracion.DAOImpVentas;

public class SAImpVentas implements SAVentas{
    
	private static SAImpVentas instance;
	private TransferVentas TVentas;

	private SAImpVentas() {}

	public SAImpVentas(TransferVentas TVentas) {
		this.TVentas = TVentas;
	}
	
	public static SAImpVentas getInstance() {
		if (instance == null) {
			instance = new SAImpVentas();
		}
		return instance;
	}

	@Override
	public List<TransferVentas> listadoVentas() {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.listadoVentas();
	}

	@Override
	public List<TransferVentas> listadoIncidencias() {
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.listadoIncidencias();
	}
	@Override
	public boolean eliminarVenta(int idVenta) {
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.eliminarVenta(idVenta);
	}
	
	@Override
	public TransferVentas obtenerVentaPorId(int idVenta) {
	    DAOImpVentas daoventas = new DAOImpVentas();
	    return daoventas.obtenerVentaPorId(idVenta);
	}
	
	@Override
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles) {
        DAOImpVentas daoventas = new DAOImpVentas();
        boolean success = daoventas.actualizarIncidencia(idVenta, estado, detalles);
        if (success) {
            TransferVentas venta = obtenerVentaPorId(idVenta); 
            if (venta != null) {
                switch (estado) {
                    case "Abierta":
                        venta.setEstado(new StateAbierta());
                        break;
                    case "En proceso":
                        venta.setEstado(new StateEnProceso());
                        break;
                    case "Resuelta":
                        venta.setEstado(new StateResuelta());
                        break;
                }
            }
        }
        return success;
    }
	
	public boolean registrarVenta(Date fecha, String producto, int cantidad, double precio) {
        
		DAOImpVentas daoventas = new DAOImpVentas();
        
		boolean success = daoventas.registrarVenta(fecha, producto, cantidad, precio);
        if (success) {
            TransferVentas venta = new TransferVentas();
            venta.setEstado(new StateAbierta());
            venta.procesarIncidencia();
        }
        return success;
    }
	
}
