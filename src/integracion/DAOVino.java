package integracion;

import java.util.List;

import negocio.Vino;

public interface DAOVino {

	public List<Vino> buscarVinos();
	public Vino buscarVino(int id);
	public int addVino(Vino vino);
	public void actualizarVino(Vino vino);
	public void eliminarVino(Vino vino);
	public String realizarConsultaVino(String nombreVino);
	public String realizarConsultaBodega(String winery);
	public String realizarConsultaYear(int year); //e
	public String realizarConsultaPrecio(double price_min, double price_max); //e consulta de maximo y minimo del precio 
	public String realizarConsultaAlcohol(double alcohol_percentaje); //k consulta del porcentaje de alcohol (Jspinner)
	public String realizarConsultaTaste(String taste); //k consulta del sabor (comboBox)	
}
