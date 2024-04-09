package integracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ddbb.DBConnection;
import negocio.TUsuario;

public class DAOImpUsuario implements DAOUsuario{
    
	private DBConnection dbConnection;

    public DAOImpUsuario() {
        dbConnection = new DBConnection();
    }
    

	public List<TUsuario> buscarUsuarios() {
		return null;
	}

	@Override
	public TUsuario buscarUsuario(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarUsuario(TUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(TUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeUsuario(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addUsuario(TUsuario usuario) {
		int filasAfectadas = -1; //devuelve -1 si no se ha añadido = ha fallado

        Connection conexion = dbConnection.getConnection();
        if (conexion != null) {
            String query = "INSERT INTO usuarios (nif, nombre, email) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                pstmt.setString(1, usuario.getNif());
                pstmt.setString(2, usuario.getNombre());
                pstmt.setString(3, usuario.getEmail());

                filasAfectadas = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.desconectar();
            }
        }

        return filasAfectadas;
	}

	
}