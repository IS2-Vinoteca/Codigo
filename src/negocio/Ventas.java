package negocio;

import java.util.Date;
import java.util.List;

import integracion.DAOImpVentas;

public class Ventas implements SAVentas{
    private int id;
    private Date fecha;
    private String producto;
    private int cantidad;
    private double precio;
    private String incidencia;
    private String detalles;
	//private DAOImpVentas daoventas;
	
    // Constructor
	
	public Ventas() {
		
	}
    public Ventas(int id, Date fecha, String producto, int cantidad, double precio, String incidencia, String detalles) {
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.incidencia = incidencia;
        this.detalles = detalles;
        
       // this.daoventas = new DAOImpVentas();
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String info) {
        this.detalles = info;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date date) {
        this.fecha = date;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "Ventas{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", producto='" + producto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", incidencia='" + incidencia + '\'' +
                '}';
    }

	@Override
	public List<Ventas> listadoVentas() {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.listadoVentas();
	}

	@Override
	public List<Ventas> listadoIncidencias() {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.listadoIncidencias();
	}
	@Override
	public boolean eliminarVenta(int idVenta) {
		// TODO Auto-generated method stub
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.eliminarVenta(idVenta);
	}
	public boolean actualizarIncidencia(int idVenta, String estado, String detalles) {
		DAOImpVentas daoventas = new DAOImpVentas();
		return daoventas.actualizarIncidencia(idVenta,incidencia, detalles);
	}
}
