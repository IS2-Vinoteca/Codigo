package integracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	    Connection conexion = dbConnection.getConnection();
	    
	    if (conexion != null) {
	        String query = "DELETE FROM usuarios WHERE id = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setString(1, usuario.getId()); // Suponiendo que getId() devuelve el ID del usuario
	            pstmt.executeUpdate();
	            System.out.println("Usuario eliminado correctamente.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }
	}


	@Override
	public boolean existeUsuario(String id) {
	    Connection conexion = dbConnection.getConnection();
	    boolean existe = false;
	    
	    if (conexion != null) {
	        String query = "SELECT id FROM usuarios WHERE id = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setString(1, id);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                existe = rs.next(); // Si rs.next() devuelve true, significa que se encontró un usuario
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }
	    return existe;
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