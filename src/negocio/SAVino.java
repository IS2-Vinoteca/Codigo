package negocio;

import java.util.List;

public interface SAVino {
	public List<Vino> buscarVinos(); //hecho
	public Vino buscarVino(int id); //e hecho: tengo dudas de porqué no devolveria un string 
	public int addVino(Vino vino); //k
	public void actualizarVino(Vino vino); //e hecho
	public void eliminarVino(Vino vino); //k
	public String realizarConsultaVino(String nombreVino); //hecho
	public String realizarConsultaBodega(String winery);//e hecho
	public String realizarConsultaYear(int year); //e hecho
	public String realizarConsultaPrecio(double price_min, double price_max); //e consulta de maximo y minimo del precio 
	public String realizarConsultaAlcohol(double alcohol_percentaje); //k consulta del porcentaje de alcohol (Jspinner)
	public String realizarConsultaTaste(String taste); //k consulta del sabor (comboBox)
	
	//Comentario Elena: deberiamos hacer un metodo de validacion de datos, antes de añadir el vino a la base de datos TODO
}
