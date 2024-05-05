package negocio;

public interface EmbotelladoEnhanced {
	//vamos a crear una tabla de venta donde vamos a añadir el precio, descripcion, tambien podemos añadir un rating
	//del tipo de cliente: 1 cliente casual a 5 cliente muy comprometido
	double getPrecio();
	String getDescription();
	//int getStatusValue(); 
}
