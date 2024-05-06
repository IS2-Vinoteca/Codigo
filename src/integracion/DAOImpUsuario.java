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
import negocio.TransferUsuario;

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
                    if (rs.next()) {
                        existe = true; // Si hay al menos una fila, el usuario existe
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Aquí no es necesario cerrar la conexión, ya que lo haces en el DAOImpUsuario
            }
        }
        return existe;
    }


	
    public List<TransferUsuario> buscarUsuarios() {
        List<TransferUsuario> usuarios = new ArrayList<>();
        Connection conexion = dbConnection.getConnection();
        
        if (conexion != null) {
            String query = "SELECT * FROM usuarios";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    TransferUsuario usuario = new TransferUsuario();
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
    public TransferUsuario buscarUsuario(int nif) { //ver por qué falla
        Connection conexion = dbConnection.getConnection();
        TransferUsuario usuario = null;
        
        if (conexion != null) {
            String query = "SELECT * FROM usuarios WHERE nif = ?";
            try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
                pstmt.setInt(1, nif);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        usuario = new TransferUsuario(rs.getInt("nif"), rs.getString("nombre"), rs.getString("email"));
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
	public boolean eliminarUsuario(int nif) {
	    boolean eliminado = false;
	    Connection conexion = dbConnection.getConnection();
	    if (conexion != null) {
	        String query = "DELETE FROM usuarios WHERE nif = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setInt(1, nif);
	            pstmt.executeUpdate();
	            eliminado = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }
	    return eliminado;
	}


	@Override
	public int addUsuario(TransferUsuario usuario) {
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