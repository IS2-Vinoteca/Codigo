package integracion;

import java.sql.Connection;
import java.sql.DriverManager;
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
	        String sql = "SELECT * FROM vinos";
	        consulta = conexion.prepareStatement(sql);
	        resultado = consulta.executeQuery();

	        while (resultado.next()) {
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
	            
	            Vino vino = new Vino(id, winery, wine, year, rating, num_reviews, num_reviews_grp, price, region,
	                    type, body, acidity, acidity_level, taste, accomp_meal, category, alcohol_percentage, uds_vino, description);
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
	    String resultados = "";
	    Connection conexion = dbConnection.getConnection();
	    PreparedStatement consulta = null;
	    ResultSet resultado = null;

	    try {
	        String sql = "SELECT * FROM vinos WHERE wine = ?";
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
