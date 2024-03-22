package presentacion;

import java.sql.*;

public class ModeloConsulta {
    private static final String URL = "jdbc:mysql://localhost:3306/is2_vinoteca_bbdd";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "Root-password";

    public String realizarConsulta(String nombreVino) {
        String resultados = "";
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
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


