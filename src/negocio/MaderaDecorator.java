package negocio;

public class MaderaDecorator extends EmbotelladoDecorator{

	private double precioMadera;
	
	public MaderaDecorator(EmbotelladoEnhanced embotellado) {
		
		super(embotellado);
		this.precioMadera = 5.0;
	}

	@Override
	public double getPrecio() {
		
		return embotellado.getPrecio() + precioMadera;
	}

	@Override
	public String getDescription() {
		
		return embotellado.getDescription() + " en botella de madera";
	}
}
