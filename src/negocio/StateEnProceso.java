package negocio;

public class StateEnProceso implements StateVenta{
	
	@Override
    public void procesarIncidencia(TransferVentas venta) {
        venta.setIncidencia("En proceso");
    }
}
