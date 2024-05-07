package integracion;

import java.util.List;

import negocio.TransferVino;

public interface DAOVino {

	public List<TransferVino> buscarVinos();
	public TransferVino buscarVino(int id);
	public boolean vinoExists(int id);
	public int addVino(TransferVino vino);
	public void actualizarVino(TransferVino vino);
	public void eliminarVino(TransferVino vino);
	public List<TransferVino> realizarConsultaCatalogo();
	public String realizarConsultaVino(String nombreVino);
	public String realizarConsultaBodega(String winery);
	public String realizarConsultaYear(int year); //e
	public String realizarConsultaPrecio(double price_min, double price_max);
	public String realizarConsultaAlcohol(double alcohol_percentaje); 
	public String realizarConsultaTaste(String taste); 	
}

