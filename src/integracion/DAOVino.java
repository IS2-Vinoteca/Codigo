package integracion;

import java.util.List;

import negocio.TransferVino;

public interface DAOVino {

	public List<TransferVino> buscarVinos();
	public TransferVino buscarVino(int id);
	public int addVino(TransferVino vino);
	public void actualizarVino(TransferVino vino);
	public void eliminarVino(TransferVino vino);
	public List<TransferVino> realizarConsultaCatalogo();
	public String realizarConsultaVino(String nombreVino);
	public String realizarConsultaBodega(String winery);
	public String realizarConsultaYear(int year); //e
	public String realizarConsultaPrecio(double price_min, double price_max); //e consulta de maximo y minimo del precio 
	public String realizarConsultaAlcohol(double alcohol_percentaje); // (Jspinner)
	public String realizarConsultaTaste(String taste); // (comboBox)	
}

