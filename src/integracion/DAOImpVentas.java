package integracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ddbb.DBConnection;
import negocio.TransferVentas;

public class DAOImpVentas implements DAOVentas{

	private DBConnection dbConnection;
	 
	public DAOImpVentas() {
	        dbConnection = new DBConnection();
	}

	@Override
	   public List<TransferVentas> listadoVentas() {
        List<TransferVentas> ventas = new ArrayList<>();
        Connection conexion = dbConnection.getConnection();
        
        if (conexion != null) {
            String query = "SELECT * FROM ventas";
            try (Statement stmt = conexion.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    TransferVentas venta = new TransferVentas();
                    venta.setId(rs.getInt("id"));
                    venta.setFecha(rs.getDate("fecha"));
                    venta.setProducto(rs.getString("producto"));
                    venta.setCantidad(rs.getInt("cantidad"));
                    venta.setPrecio(rs.getDouble("precio"));
                    venta.setIncidencia(rs.getString("incidencia"));

                    ventas.add(venta);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.desconectar();
            }
        }
        
        return ventas;
    }
	
	@Override
	public List<TransferVentas> listadoIncidencias() {
	    List<TransferVentas> ventasConIncidencias = new ArrayList<>();
	    Connection conexion = dbConnection.getConnection();
	    
	    if (conexion != null) {
	    	String query = "SELECT * FROM ventas WHERE incidencia IS NOT NULL";
	        try (Statement stmt = conexion.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                TransferVentas venta = new TransferVentas();
	                venta.setId(rs.getInt("id"));
	                venta.setFecha(rs.getDate("fecha"));
	                venta.setProducto(rs.getString("producto"));
	                venta.setCantidad(rs.getInt("cantidad"));
	                venta.setPrecio(rs.getDouble("precio"));
	                venta.setIncidencia(rs.getString("incidencia"));
	                venta.setDetalles(rs.getString("detalles_incidencia"));

	                ventasConIncidencias.add(venta);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }
	    
	    return ventasConIncidencias;
	}

	@Override
	public boolean eliminarVenta(int idVenta) {
	    boolean eliminado = false;
	    Connection conexion = dbConnection.getConnection();
	    if (conexion != null) {
	        String query = "DELETE FROM ventas WHERE id = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setInt(1, idVenta);
	            int filasEliminadas = pstmt.executeUpdate();
	            if (filasEliminadas > 0) {
	                eliminado = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }
	    return eliminado;
	}
	
	@Override
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles) {
	    boolean actualizado = false;
	    Connection conexion = dbConnection.getConnection();
	    if (conexion != null) {
	        String query = "UPDATE ventas SET incidencia = ?, detalles_incidencia = ? WHERE id = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setString(1, estado);
	            pstmt.setString(2, detalles);
	            pstmt.setInt(3, idVenta);
	            int filasActualizadas = pstmt.executeUpdate();
	            if (filasActualizadas > 0) {
	                actualizado = true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }
	    return actualizado;
	}
	
	@Override
	public boolean registrarVenta(Date fecha, String producto, int cantidad, double precio) {
        boolean success = false;
        Connection con = dbConnection.getConnection();
        PreparedStatement ps = null;

        if(con != null) {
	        try {
	            String query = "INSERT INTO ventas (fecha, producto, cantidad, precio) VALUES (?, ?, ?, ?)";
	            ps = con.prepareStatement(query);
	            ps.setDate(1, new java.sql.Date(fecha.getTime()));
	            ps.setString(2, producto);
	            ps.setInt(3, cantidad);
	            ps.setDouble(4, precio);
	
	            int rowsAffected = ps.executeUpdate();
	            if (rowsAffected > 0) {
	                success = true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) {
	                    ps.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
        }

        return success;
    }
	
	@Override
	public TransferVentas obtenerVentaPorId(int idVenta) {
	    TransferVentas venta = null;
	    Connection conexion = dbConnection.getConnection();

	    if (conexion != null) {
	        String query = "SELECT * FROM ventas WHERE id = ?";
	        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
	            pstmt.setInt(1, idVenta);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                venta = new TransferVentas();
	                venta.setId(rs.getInt("id"));
	                venta.setFecha(rs.getDate("fecha"));
	                venta.setProducto(rs.getString("producto"));
	                venta.setCantidad(rs.getInt("cantidad"));
	                venta.setPrecio(rs.getDouble("precio"));
	                venta.setIncidencia(rs.getString("incidencia"));
	                venta.setDetalles(rs.getString("detalles_incidencia"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            dbConnection.desconectar();
	        }
	    }

	    return venta;
	}

}
