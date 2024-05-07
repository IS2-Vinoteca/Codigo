package negocio;

import java.util.Calendar;
import java.util.List;

import integracion.DAOImpVino;

public class SAImpVino implements SAVino {

	private static SAImpVino instance;
	private TransferVino TVino;

	private SAImpVino(TransferVino TVino) {
		this.TVino = TVino;
	}

	private SAImpVino() {}

	public static SAImpVino getInstance() {
	    if (instance == null) {
	      instance = new SAImpVino();
	    }
	    return instance;
	}

	@Override
	public List<TransferVino> buscarVinos(){
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.buscarVinos();
	}
		
	@Override
	public TransferVino buscarVino(int id) {
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.buscarVino(id);
	}
	
	@Override
	public int addVino(TransferVino vino) {
		
		DAOImpVino daoVino = new DAOImpVino();
		
		int result = -1;
		if(!daoVino.vinoExists(vino.getId()))
			result = daoVino.addVino(vino);

		return result;
	}
	
	@Override
	public void actualizarVino(TransferVino vino) {
		DAOImpVino daoVino = new DAOImpVino();
		
		if(this.buscarVino(vino.getId()) != null) { 
			daoVino.actualizarVino(vino);
		}			
	}
	
	@Override
	public void eliminarVino(TransferVino vino) {
		
		DAOImpVino daoVino = new DAOImpVino();
		
		if(this.buscarVino(vino.getId()) != null) { //elimino el vino solo si el vino existe
			daoVino.eliminarVino(vino);
		}
	}
	
	@Override
	public String realizarConsultaVino(String nombreVino) { 
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaVino(nombreVino);
	}
	
	@Override
	public String realizarConsultaBodega(String winery) { //devuelve una lista de los vinos de esa bodega
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaBodega(winery);
	}
	
	@Override
	public String realizarConsultaYear(int year) {
		
		//miramos si el año es un valor valido: ni es negativo ni es un año mayor que el actual
		if(year < 0 || year > Calendar.getInstance().get(Calendar.YEAR)) {
			return "El año consultado no es valido";
		}
		
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaYear(year);
	}
	
	@Override
	public String realizarConsultaPrecio(double price_min, double price_max) {
		
		//comprobar que ha introducido datos validos
		if(price_min > price_max || price_min < 0 || price_max < 0) {
			return "Los valores introducidos no son validos";
		}
		
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaPrecio(price_min, price_max);
	}
	
	@Override
	public String realizarConsultaAlcohol(double alcohol_percentaje) {

		if(alcohol_percentaje < 0) {
			return "Los valores introducidos no son validos";
		}
		
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaAlcohol(alcohol_percentaje);
	}
	
	@Override
	public String realizarConsultaTaste(String taste) {
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaTaste(taste);
	}

	@Override
	public List<TransferVino> realizarConsultaCatalogo() {
		DAOImpVino daoVino = new DAOImpVino();
		return daoVino.realizarConsultaCatalogo();
	}

	

	
}
