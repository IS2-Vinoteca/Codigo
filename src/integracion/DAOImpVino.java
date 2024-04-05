package integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ddbb.DBConnection;
import negocio.Vino;

public class DAOImpVino implements DAOVino{
	  
	private DBConnection dbConnection;

	public DAOImpVino() {
	        dbConnection = new DBConnection();
	}
	
	@Override
	public List<Vino> buscarVinos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vino buscarVino(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int crearVino(Vino vino) {
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
	public String realizarConsulta(String nombreVino) {
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
	
}
