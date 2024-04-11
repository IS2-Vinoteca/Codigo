package integracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ddbb.DBConnection;
import negocio.TUsuario;

public class DAOImpUsuario implements DAOUsuario{
    
	private DBConnection dbConnection;

    public DAOImpUsuario() {
        dbConnection = new DBConnection();
    }
    
    @Override
    public boolean existeUsuario(int nif) {
        Connection conexion = dbConnection.getConnection();
        boolean existe = false;
        
        if (conexion != null) {
            String query = "SELECT nif FROM usuarios WHERE nif = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                pstmt.setInt(1, nif);
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

	
    public List<TUsuario> buscarUsuarios() {
        List<TUsuario> usuarios = new ArrayList<>();
        Connection conexion = dbConnection.getConnection();
        
        if (conexion != null) {
            String query = "SELECT * FROM usuarios";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    TUsuario usuario = new TUsuario();
                    usuario.setNif(rs.getInt("nif"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));

                    usuarios.add(usuario);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.desconectar();
            }
        }
        
        return usuarios;
    }


    @Override
    public TUsuario buscarUsuario(int nif) { //ver por qué falla
        Connection conexion = dbConnection.getConnection();
        TUsuario usuario = null;
        
        if (conexion != null) {
            String query = "SELECT * FROM usuarios WHERE nif = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                pstmt.setInt(1, nif);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new TUsuario(rs.getInt("nif"), rs.getString("nombre"), rs.getString("email"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();            
            } finally {
                // Mover el cierre de la conexión fuera del bloque finally
                if (conexion != null) {
                    dbConnection.desconectar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return usuario;
    }



	@Override
	public void actualizarUsuario(TUsuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(TUsuario usuario) {
	    Connection conexion = dbConnection.getConnection();
	    if (conexion != null) {
	        String query = "DELETE FROM usuarios WHERE nif = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setInt(1, usuario.getNif()); // Suponiendo que getNif() devuelve el NIF del usuario como un int
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
	public int addUsuario(TUsuario usuario) {
		int filasAfectadas = -1; //devuelve -1 si no se ha añadido = ha fallado
        Connection conexion = dbConnection.getConnection();
        
        if (conexion != null) {
            String query = "INSERT INTO usuarios (nif, nombre, email) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                pstmt.setInt(1, usuario.getNif());
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