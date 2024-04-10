package negocio;

import java.util.List;

import integracion.DAOImpVino;

public class Vino implements SAVino{

	//ATRIBUTOS-----------------------------------------------------------------------------------------------------------------
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
	//CONSTRUCTORA-------------------------------------------------------------------------------------------------------------
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
	//METODOS-------------------------------------------------------------------------------------------------------------------
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
		
		@Override
		public List<Vino> buscarVinos(){ //para la DAO
			/*List<PersonaConPoder> lista = new ArrayList<>();
	    	for (int i = 0; i < personas.size(); i++) {
	    		if (personas.get(i) instanceof SuperHeroe) 
	    			lista.add(personas.get(i));
	    	
	    	}
			return lista;*/
			return null;
		}
		
		@Override
		public Vino buscarVino(int id) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int addVino(Vino vino) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void actualizarVino(Vino vino) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void eliminarVino(Vino vino) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String realizarConsultaVino(String nombreVino) { 
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String realizarConsultaBodega(String winery) { //devuelve una lista de los vinos de esa bodega
			// TODO Auto-generated method stub
			return null;
		}
		
}
