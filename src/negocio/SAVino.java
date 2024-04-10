package negocio;

import java.util.List;

public interface SAVino {
	public List<Vino> buscarVinos();
	public Vino buscarVino(int id);
	public int addVino(Vino vino);
	public void actualizarVino(Vino vino);
	public void eliminarVino(Vino vino);
	public String realizarConsultaVino(String nombreVino); 
	public String realizarConsultaBodega(String winery);
}
