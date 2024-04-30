package negocio;

import java.util.List;

public interface SAVino {
	public List<TransferVino> buscarVinos(); //hecho
	public TransferVino buscarVino(int id); //e hecho 
	public int addVino(TransferVino vino); //k 
	public void actualizarVino(TransferVino vino); //e hecho
	public void eliminarVino(TransferVino vino); //k hecho
	public String realizarConsultaCatalogo();
	public String realizarConsultaVino(String nombreVino); //hecho
	public String realizarConsultaBodega(String winery);//e hecho
	public String realizarConsultaYear(int year); //e hecho
	public String realizarConsultaPrecio(double price_min, double price_max); //e hecho consulta de maximo y minimo del precio 
	public String realizarConsultaAlcohol(double alcohol_percentaje); //k consulta del porcentaje de alcohol (Jspinner)
	public String realizarConsultaTaste(String taste); //k consulta del sabor (comboBox)
	
	//TODO Preguntas profe: tenemos que inhabilitar el vino que queremos eliminar en vez de eliminarlo de la bbdd?
}
