package integracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import ddbb.DBConnection;
import negocio.Vino;

public class DAOImpVino implements DAOVino{
	  
	private DBConnection dbConnection;

	public DAOImpVino() {
	        dbConnection = new DBConnection();
	}
	
	@Override
	public List<Vino> buscarVinos() {
		List<Vino> vinos = new ArrayList<>();
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM inventario";
	        consulta = conexion.prepareStatement(sql);
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {
	            Vino vino = this.fillIn_vino(resultado);
	            vinos.add(vino);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultado != null)
	                resultado.close();
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return vinos;
	}

	@Override
	public Vino buscarVino(int id) {
		//String resultados = "";
		Vino vino_buscado = null;
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM inventario WHERE id = ?";
	        consulta = conexion.prepareStatement(sql);
	        consulta.setInt(1, id); 
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {	            
	            vino_buscado = this.fillIn_vino(resultado);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultado != null)
	                resultado.close();
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return vino_buscado;
	}
	
	@SuppressWarnings("null")
	@Override
    public int addVino(Vino vino) {
		
        int idGenerado = -1; // Valor por defecto si el vino ya existe
        Connection conexion = null;
        PreparedStatement consulta = null;
        Vino vinoBuscado = buscarVino(vino.getId());

        try {
            conexion = dbConnection.getConnection();

            // Verificar si el vino ya existe en la base de datos
            if (vinoBuscado != null) {
                // Preparar la consulta SQL para insertar un nuevo vino
                String sql = "INSERT INTO vinos (winery, wine, year, rating, num_reviews, num_reviews_grp, region, price, "
                        + "type, body, acidity, acidity_level, category, alcohol_percentage, uds_vino, description) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                consulta = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                consulta.setString(1, vino.getWinery());
                consulta.setString(2, vino.getWine());
                consulta.setInt(3, vino.getYear());
                consulta.setDouble(4, vino.getRating());
                consulta.setInt(5, vino.getNum_reviews());
                consulta.setString(6, vino.getNum_reviews_grp());
                consulta.setString(7, vino.getRegion());
                consulta.setDouble(8, vino.getPrice());
                consulta.setString(9, vino.getType());
                consulta.setInt(10, vino.getBody());
                consulta.setInt(11, vino.getAcidity());
                consulta.setString(12, vino.getAcidity_level());
                consulta.setString(13, vino.getCategory());
                consulta.setDouble(14, vino.getAlcohol_percentage());
                consulta.setInt(15, vino.getUds_vino());
                consulta.setString(16, vino.getDescription());

                int filasInsertadas = consulta.executeUpdate();

                if (filasInsertadas > 0) {
                    // Obtener el ID generado para el nuevo vino
                    var generatedKeys = consulta.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        idGenerado = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (consulta != null)
                    consulta.close();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return idGenerado;
    }


	@Override
	public void actualizarVino(Vino vino) {
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;

	    try {
	        String sql = "UPDATE inventario SET winery = ?, wine = ?, year = ?, rating = ?, num_reviews = ?, "
	        		+ "num_reviews_grp = ?, price = ?, region = ?, type = ?, body = ?, acidity = ?, "
	        		+ "acidity_level = ?, taste = ?, accomp_meal = ?, category = ?, alcohol_percentage = ?, "
	        		+ "uds_vino = ?, description = ? WHERE id = ?";
	        consulta = conexion.prepareStatement(sql);
	        
	        consulta.setInt(19, vino.getId()); 
	        consulta.setString(1, vino.getWinery());
            consulta.setString(2, vino.getWine());
            consulta.setInt(3, vino.getYear());
            consulta.setDouble(4, vino.getRating());
            consulta.setInt(5, vino.getNum_reviews());
            consulta.setString(6, vino.getNum_reviews_grp());
            consulta.setDouble(7, vino.getPrice());
            consulta.setString(8, vino.getRegion());
            consulta.setString(9, vino.getType());
            consulta.setInt(10, vino.getBody());
            consulta.setInt(11, vino.getAcidity());
            consulta.setString(12, vino.getAcidity_level());
            consulta.setString(13, vino.getTaste());
            consulta.setString(14, vino.getAccomp_meal());
            consulta.setString(15, vino.getCategory());
            consulta.setDouble(16, vino.getAlcohol_percentage());
            consulta.setInt(17, vino.getUds_vino());
            consulta.setString(18, vino.getDescription());
	        consulta.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void eliminarVino(Vino vino) {
		
		Connection conexion = dbConnection.getConnection();
        PreparedStatement consulta = null;

        try {
            String sql = "DELETE FROM vinos WHERE id=?";
            consulta = conexion.prepareStatement(sql);
            consulta.setInt(1, vino.getId());
            consulta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (consulta != null)
                    consulta.close();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	public String realizarConsultaVino(String nombreVino) {
	    String resultados = "";
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM inventario WHERE wine = ?";
	        consulta = conexion.prepareStatement(sql);
	        consulta.setString(1, nombreVino); 
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {
	            int id = resultado.getInt("id");
	            String wine = resultado.getString("wine");
	            int year = resultado.getInt("year");
	            double rating = resultado.getDouble("rating");
	            int num_reviews = resultado.getInt("num_reviews");
	            String num_reviews_grp = resultado.getString("num_reviews_grp");
	            String region = resultado.getString("region");
	            double price = resultado.getDouble("price");

	            resultados += "ID: " + id + ", Wine: " + wine + ", Year: " + year + ", Rating: " + rating
	                    + ", Num_reviews: " + num_reviews + ", Num_reviews_grp: " + num_reviews_grp + ", Region: "
	                    + region + ", Price: " + price + "\n";
	        }
	        
	        // Si no se encontraron resultados, asigna el mensaje adecuado
	        if (resultados.isEmpty()) {
	            resultados = "No se ha encontrado ningún vino con ese nombre";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        resultados = "Error al realizar la consulta: " + e.getMessage();
	    } finally {
	        try {
	            if (resultado != null)
	                resultado.close();
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return resultados;
	}

	@Override
	public String realizarConsultaBodega(String winery) {
		String resultados = "";
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM inventario WHERE winery = ?";
	        consulta = conexion.prepareStatement(sql);
	        consulta.setString(1, winery); 
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {
	            resultados += this.fillIn_ResultadoConsulta(resultado);
	        }
	        
	        // Si no se encontraron resultados, asigna el mensaje adecuado
	        if (resultados.isEmpty()) {
	            resultados = "No se ha encontrado ninguna bodega con ese nombre";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        resultados = "Error al realizar la consulta: " + e.getMessage();
	    } finally {
	        try {
	            if (resultado != null)
	                resultado.close();
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return resultados;
	}

	@Override
	public String realizarConsultaYear(int year) {
		String resultados = "";
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM inventario WHERE year = ?";
	        consulta = conexion.prepareStatement(sql);
	        consulta.setInt(1, year); 
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {
	            resultados += this.fillIn_ResultadoConsulta(resultado);
	        }
	        
	        // Si no se encontraron resultados, asigna el mensaje adecuado
	        if (resultados.isEmpty()) {
	            resultados = "No se ha encontrado vinos de ese annio en la base de datos";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        resultados = "Error al realizar la consulta: " + e.getMessage();
	    } finally {
	        try {
	            if (resultado != null)
	                resultado.close();
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return resultados;
	}

	@Override
	public String realizarConsultaPrecio(double price_min, double price_max) {
		String resultados = "";
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM inventario WHERE price >= ? AND price <= ?";
            consulta = conexion.prepareStatement(sql);
            consulta.setDouble(1, price_min);
            consulta.setDouble(2, price_max);
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {
	            resultados += this.fillIn_ResultadoConsulta(resultado);
	        }
	        
	        // Si no se encontraron resultados, asigna el mensaje adecuado
	        if (resultados.isEmpty()) {
	            resultados = "No se han encontrado vinos en ese rango de precios";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        resultados = "Error al realizar la consulta: " + e.getMessage();
	    } finally {
	        try {
	            if (resultado != null)
	                resultado.close();
	            if (consulta != null)
	                consulta.close();
	            if (conexion != null)
	                conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return resultados;
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
	
	private Vino fillIn_vino(ResultSet resultado) throws SQLException {
		int id = resultado.getInt("id");
        String winery = resultado.getString("winery");
        String wine = resultado.getString("wine");
        int year = resultado.getInt("year");
        double rating = resultado.getDouble("rating");
        int num_reviews = resultado.getInt("num_reviews");
        String num_reviews_grp = resultado.getString("num_reviews_grp");
        String region = resultado.getString("region");
        double price = resultado.getDouble("price");
        String type = resultado.getString("type");
        int body = resultado.getInt("body");
        int acidity = resultado.getInt("acidity");
        String acidity_level = resultado.getString("acidity_level");
        String taste = resultado.getString("taste");
        String accomp_meal = resultado.getString("accomp_meal");
        String category = resultado.getString("category");
        double alcohol_percentage = resultado.getDouble("alcohol_percentage");
        int uds_vino = resultado.getInt("uds_vino");
        String description = resultado.getString("description");
        
        return new Vino(id, winery, wine, year, rating, num_reviews, num_reviews_grp, price, region,
                type, body, acidity, acidity_level, taste, accomp_meal, category, alcohol_percentage, uds_vino, description);
	}
	
	private String fillIn_ResultadoConsulta(ResultSet resultado) throws SQLException {
		int id = resultado.getInt("id");
        String winery = resultado.getString("winery");
        String wine = resultado.getString("wine");
        int year = resultado.getInt("year");
        double rating = resultado.getDouble("rating");
        int num_reviews = resultado.getInt("num_reviews");
        String num_reviews_grp = resultado.getString("num_reviews_grp");
        String region = resultado.getString("region");
        double price = resultado.getDouble("price");
        String type = resultado.getString("type");
        int body = resultado.getInt("body");
        int acidity = resultado.getInt("acidity");
        String acidity_level = resultado.getString("acidity_level");
        String taste = resultado.getString("taste");
        String accomp_meal = resultado.getString("accomp_meal");
        String category = resultado.getString("category");
        double alcohol_percentage = resultado.getDouble("alcohol_percentage");
        int uds_vino = resultado.getInt("uds_vino");
        String description = resultado.getString("description");
        
        return "ID: " + id + ", Winery: " + winery + ", Wine: " + wine + ", Year: " + year + ", Rating: " + rating
                + ", Num_reviews: " + num_reviews + ", Num_reviews_grp: " + num_reviews_grp + ", Region: "
                + region + ", Price: " + price +", Type: " + type +", Body: " + body + ", Acidity: " + acidity + ", Acidity level: "
                + acidity_level + ", Taste: " + taste + ", Accompanied meals: " + accomp_meal + ", Category: " + category + 
                ", Alcohol Percentage: " + alcohol_percentage + ", Uds vino: " + uds_vino + ", Description: " + description + "\n";
	}
	
}
