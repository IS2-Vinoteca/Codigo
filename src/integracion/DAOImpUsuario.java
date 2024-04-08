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
    
    public int crearUsuario(TUsuario usuario) {
        int filasAfectadas = 0;

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
	
	public TUsuario buscarUsuario(String id){ //ver si el código de este metodo tiene que ir aqui o en TUsuario
		return null;
	}

	public List<TUsuario> buscarUsuarios() {
		return null;
	}

	@Override
	public TUsuario buscarUsuarios(String id) {
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

	
}