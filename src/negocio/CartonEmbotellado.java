package negocio;

public class CartonEmbotellado extends EmbotelladoDecorator{

	public CartonEmbotellado(EmbotelladoEnhanced embotellado) {
		super(embotellado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStatusValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
