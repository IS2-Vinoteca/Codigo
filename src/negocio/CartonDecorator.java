package negocio;

public class CartonDecorator extends EmbotelladoDecorator {

	private double precioMadera;
	
	public CartonDecorator(EmbotelladoEnhanced embotellado) {
		
		super(embotellado);
		this.precioMadera = 1.5;
	}

	@Override
	public double getPrecio() {
		
		return embotellado.getPrecio() + precioMadera;
	}
}
