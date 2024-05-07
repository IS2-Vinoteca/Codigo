package negocio;

public class StateResuelta implements StateVenta{
	
	@Override
    public void procesarIncidencia(TransferVentas venta) {
        venta.setIncidencia("Resuelta");
    }
}
