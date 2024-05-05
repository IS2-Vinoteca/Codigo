package negocio;

public class VidrioDecorator extends EmbotelladoDecorator{
	
	private double precioVidrio;
	
	public VidrioDecorator(EmbotelladoEnhanced embotellado) {
		
		super(embotellado);
		this.precioVidrio = 2.5;
	}

	@Override
	public double getPrecio() {
		
		return embotellado.getPrecio() + precioVidrio;
	}

	@Override
	public String getDescription() {
		
		return embotellado.getDescription() + " en botella de vidrio";
	}
}
