package negocio;

import java.util.Calendar;
import java.util.List;

import integracion.DAOImpVino;

public class SAImpVino implements SAVino {

	private static SAImpVino instance;
	private TransferVino TVino;
	private DAOImpVino daoVino;

	private SAImpVino(TransferVino TVino) {
		this.TVino = TVino;
	    this.daoVino = new DAOImpVino();
	}

	private SAImpVino() {
		this.daoVino = new DAOImpVino();
	}

	public static SAImpVino getInstance() {
	    if (instance == null) {
	      instance = new SAImpVino();
	    }
	    return instance;
	}

	@Override
	public List<TransferVino> buscarVinos(){ //para la DAO
		return this.daoVino.buscarVinos();
	}
		
	@Override
	public TransferVino buscarVino(int id) {
		return this.daoVino.buscarVino(id);
	}
	
	@Override
	public int addVino(TransferVino vino) {
		return this.daoVino.addVino(vino);
	}
	
	@Override
	public void actualizarVino(TransferVino vino) {
		if(this.buscarVino(vino.getId()) != null) { //actualizo el vino solo si el vino existe
			this.daoVino.actualizarVino(vino);
		}			
	}
	
	@Override
	public void eliminarVino(TransferVino vino) {
		if(this.buscarVino(vino.getId()) != null) { //elimino el vino solo si el vino existe
			daoVino.eliminarVino(vino);
		}
	}
	
	@Override
	public String realizarConsultaVino(String nombreVino) { 
		return this.daoVino.realizarConsultaVino(nombreVino);
	}
	
	@Override
	public String realizarConsultaBodega(String winery) { //devuelve una lista de los vinos de esa bodega
		return this.daoVino.realizarConsultaBodega(winery);
	}
	
	@Override
	public String realizarConsultaYear(int year) {
		//miramos si el año es un valor valido: ni es negativo ni es un año mayor que el actual
		if(year < 0 || year > Calendar.getInstance().get(Calendar.YEAR)) {
			return "El annio consultado no es valido";
		}
		return this.daoVino.realizarConsultaYear(year);
	}
	
	@Override
	public String realizarConsultaPrecio(double price_min, double price_max) {
		//comprobar que ha introducido datos validos
		if(price_min > price_max || price_min < 0 || price_max < 0) {
			return "Los valores introducidos no son validos";
		}
		return this.daoVino.realizarConsultaPrecio(price_min, price_max);
	}
	
	@Override
	public String realizarConsultaAlcohol(double alcohol_percentaje) {

		if(alcohol_percentaje < 0) {
			return null; // No se si deberia devolver un mensaje de error o null y que el mensaje se haga en presentacion
		}
		return this.daoVino.realizarConsultaAlcohol(alcohol_percentaje);
	}
	
	@Override
	public String realizarConsultaTaste(String taste) {
		return this.daoVino.realizarConsultaTaste(taste);
	}
	
	private boolean datos_validos_init(TransferVino vino){
		if(vino.getYear() < 0 || vino.getYear() > Calendar.getInstance().get(Calendar.YEAR)) { 
			//el annio no puede ser negativo ni mayor que el annio actual
			return false;
		}
		if(vino.getRating() < 0 || vino.getRating() > 5) { 	//el rating no puede ser negativo ni mayor que 5
			return false;
		}
		if(vino.getBody() < 0 || vino.getBody() > 5) {
			return false;
		}
		if(vino.getAcidity() < 0 || vino.getAcidity() > 3) {
			return false;
		}
		if(vino.getAlcohol_percentage() < 0 || vino.getUds_vino() < 0 || vino.getPrice() < 0 || vino.getNum_reviews() < 0
				|| vino.getId() < 0) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<TransferVino> realizarConsultaCatalogo() {
		return this.daoVino.realizarConsultaCatalogo();
	}

	

	
}
