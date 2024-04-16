package negocio;

public abstract class EmbotelladoDecorator implements EmbotelladoEnhanced{

	protected EmbotelladoEnhanced embotellado;
	
	public EmbotelladoDecorator(EmbotelladoEnhanced embotellado) {
		this.embotellado = embotellado;
	}
}
