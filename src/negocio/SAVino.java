package negocio;

import java.util.List;

public interface SAVino {
	public List<TransferVino> buscarVinos(); 
	public TransferVino buscarVino(int id); 
	public int addVino(TransferVino vino); 
	public void actualizarVino(TransferVino vino); 
	public void eliminarVino(TransferVino vino); 
	public List<TransferVino> realizarConsultaCatalogo();
	public String realizarConsultaVino(String nombreVino); 
	public String realizarConsultaBodega(String winery);
	public String realizarConsultaYear(int year);
	public String realizarConsultaPrecio(double price_min, double price_max); //e hecho consulta de maximo y minimo del precio 
	public String realizarConsultaAlcohol(double alcohol_percentaje); //k consulta del porcentaje de alcohol (Jspinner)
	public String realizarConsultaTaste(String taste); //k consulta del sabor (comboBox)
	
}
