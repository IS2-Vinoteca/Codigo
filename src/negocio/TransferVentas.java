package negocio;

import java.io.Serializable;
import java.util.Date;

public class TransferVentas implements Serializable{
    
	private int id;
    private Date fecha;
    private String producto;
    private int cantidad;
    private double precio;
    private String incidencia;
    private String detalles;
    private StateVenta estado;
	
    // Constructor
	
	public TransferVentas() {
        this.incidencia = "0";

	}
    public TransferVentas(int id, Date fecha, String producto, int cantidad, double precio, String incidencia, String detalles) {
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.incidencia = incidencia;
        this.detalles = detalles;
 
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
    
    public void setEstado(StateVenta estado) {
        this.estado = estado;
    }

    public void procesarIncidencia() {
        estado.procesarIncidencia(this);
    }
    
    // Método toString para representación de cadena
   
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
    
}
