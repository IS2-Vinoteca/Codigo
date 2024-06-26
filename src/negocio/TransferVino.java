package negocio;

public class TransferVino implements EmbotelladoEnhanced{

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
	private int catalogo;
	
	public TransferVino() {
		
	}

	public TransferVino(int id, String winery, String wine, int year, double rating, int num_reviews, String num_reviews_grp, double price, 
			String region, String type, int body, int acidity, String acidity_level, String taste, String accomp_meal, String category, 
			double alcohol_percentage, int uds_vino, String description, int catalogo) {		
		
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
        this.catalogo = catalogo;
        
	}
	
	//GETTERS
	
	public int getId() {
		return id;  
	}

	public String getWinery() {
	    return winery;
	}
	
	public String getWine() {
	    return wine;
	}
	
	public int getYear() {
	    return year;
	}
	
	public double getRating() {
	    return rating;
	}
	
	public int getNum_reviews() {
	    return num_reviews;
	}
	
	public String getNum_reviews_grp() {
	    return num_reviews_grp;
	}
	
	public String getRegion() {
		return region;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	public int getBody() {
		return body;
	}
	
	public int getAcidity() {
		return acidity;
	}
	
	public String getAcidity_level() {
		return acidity_level;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getUds_vino() {
		return uds_vino;
	}
	
	public double getAlcohol_percentage() {
		return alcohol_percentage;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getTaste() {
		return this.taste;
	}
	
	public String getAccomp_meal() {
		return this.accomp_meal;
	}
	
	public int getCatalogo() {
		return this.catalogo;
	}
	
	
	public double getPrecio() {		
		return price;
	}
	
	//SETTERS
	
	public void setId(int id) {
	    this.id = id;
	}

	public void setWinery(String winery) {
	    this.winery = winery;
	}

	public void setWine(String wine) {
	    this.wine = wine;
	}

	public void setYear(int year) {
	    this.year = year;
	}

	public void setRating(double rating) {
	    this.rating = rating;
	}

	public void setNum_reviews(int num_reviews) {
	    this.num_reviews = num_reviews;
	}

	public void setNum_reviews_grp(String num_reviews_grp) {
	    this.num_reviews_grp = num_reviews_grp;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public void setAcidity(int acidity) {
		this.acidity = acidity;
	}

	public void setAcidity_level(String acidity_level) {
		this.acidity_level = acidity_level;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAlcohol_percentage(double alcohol_percentage) {
		this.alcohol_percentage = alcohol_percentage;
	}

	public void setUds_vino(int uds_vino) {
		this.uds_vino = uds_vino;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	public void setCatalogo(int catalogo) {
		this.catalogo = catalogo;
	}
}
