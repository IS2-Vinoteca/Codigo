package integracion;

import java.util.List;

import negocio.Vino;

public interface DAOVino {

	public List<Vino> buscarVinos();
	public Vino buscarVino(int id);
	public int addVino(Vino vino);
	public void actualizarVino(Vino vino);
	public void eliminarVino(Vino vino);
	public String realizarConsultaCatalogo();
	public String realizarConsultaVino(String nombreVino);
	public String realizarConsultaBodega(String winery);
	public String realizarConsultaYear(int year); //e
	public String realizarConsultaPrecio(double price_min, double price_max); //e consulta de maximo y minimo del precio 
	public String realizarConsultaAlcohol(double alcohol_percentaje); // (Jspinner)
	public String realizarConsultaTaste(String taste); // (comboBox)	
}

