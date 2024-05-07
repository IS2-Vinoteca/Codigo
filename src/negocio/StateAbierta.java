package negocio;

public class StateAbierta implements StateVenta {
    
	@Override
    public void procesarIncidencia(TransferVentas venta) {
        venta.setIncidencia("Abierta");
    }
}
