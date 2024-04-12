package negocio;

import java.util.Calendar;
import java.util.List;

import integracion.DAOImpVino;

public class Vino implements SAVino{

	//ATRIBUTOS

	private int id;
	private String winery;
	private String wine;
	private int year;
	private double rating;
	private int num_reviews;
	private String num_reviews_grp;
	private double price;
	private String region;
	private String type;
	private int body;
	private int acidity;
	private String acidity_level;
	private String taste;
	private String accomp_meal;
	private String category;
	private double alcohol_percentage;
	private int uds_vino;
	private String description;
	private DAOImpVino daoVino;

	public Vino(int id, String winery, String wine, int year, double rating, int num_reviews, String num_reviews_grp, double price, 
			String region, String type, int body, int acidity, String acidity_level, String taste, String accomp_meal, String category, 
			double alcohol_percentage, int uds_vino, String description) {		
		this.id = id;
		this.winery = winery;
		this.wine = wine;
		this.year = year;
		this.rating = rating;
		this.num_reviews = num_reviews;
		this.num_reviews_grp = num_reviews_grp;
		this.price = price;
		this.region = region;
		this.type = type;
		this.body = body;
		this.acidity = acidity;
        this.acidity_level = acidity_level;
        this.category = category;
        this.alcohol_percentage = alcohol_percentage;
        this.uds_vino = uds_vino;
        this.description = description;
        
        this.daoVino = new DAOImpVino();
	}
	
	
	// Getters y Setters
	public int getId() {
		return id;  
	}

	public void setId(int id) {
	    this.id = id;
	    }

	public String getWinery() {
	    return winery;
	}

	public void setWinery(String winery) {
	    this.winery = winery;
	}

	public String getWine() {
	    return wine;
	}

	public void setWine(String wine) {
	    this.wine = wine;
	}

	public int getYear() {
	    return year;
	}

	public void setYear(int year) {
	    this.year = year;
	}

	public double getRating() {
	    return rating;
	}

	public void setRating(double rating) {
	    this.rating = rating;
	}

	public int getNum_reviews() {
	    return num_reviews;
	}

	public void setNum_reviews(int num_reviews) {
	    this.num_reviews = num_reviews;
	}

	public String getNum_reviews_grp() {
	    return num_reviews_grp;
	}

	public void setNum_reviews_grp(String num_reviews_grp) {
	    this.num_reviews_grp = num_reviews_grp;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getAcidity() {
		return acidity;
	}

	public void setAcidity(int acidity) {
		this.acidity = acidity;
	}

	public String getAcidity_level() {
		return acidity_level;
	}

	public void setAcidity_level(String acidity_level) {
		this.acidity_level = acidity_level;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAlcohol_percentage() {
		return alcohol_percentage;
	}

	public void setAlcohol_percentage(double alcohol_percentage) {
		this.alcohol_percentage = alcohol_percentage;
	}

	public int getUds_vino() {
		return uds_vino;
	}

	public void setUds_vino(int uds_vino) {
		this.uds_vino = uds_vino;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTaste() {
		return this.taste;
	}
	
	public String getAccomp_meal() {
		return this.accomp_meal;
	}	
	
	//METODOS SOBREESCRITOS
	
	@Override
	public List<Vino> buscarVinos(){ //para la DAO
		return this.daoVino.buscarVinos();
	}
		
	@Override
	public Vino buscarVino(int id) {
		return this.daoVino.buscarVino(id);
	}
	
	@Override
	public int addVino(Vino vino) {
		if(this.buscarVino(vino.getId()) == null && this.datos_validos_init(vino)) {
			return this.daoVino.addVino(vino);
		}
		return -1;
	}
	
	@Override
	public void actualizarVino(Vino vino) {
		if(this.buscarVino(vino.getId()) != null) { //actualizo el vino solo si el vino existe
			this.daoVino.actualizarVino(vino);
		}			
	}
	
	@Override
	public void eliminarVino(Vino vino) {
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String realizarConsultaTaste(String taste) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean datos_validos_init(Vino vino){
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
}
