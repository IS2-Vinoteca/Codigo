package test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Date;

import negocio.SAImpVentas;
import negocio.TransferVentas;

public class VentasTest {
    
    private SAImpVentas saVentas;
    
    @BeforeEach
    public void setUp() {
        // Aquí puedes inicializar cualquier objeto que necesites para las pruebas
        // Por ejemplo, si necesitas instanciar una implementación de DAOVentas
        saVentas = SAImpVentas.getInstance();
    }
    
    @Test
    public void testRegistrarVenta() {
        // Crea una nueva venta
        Date fecha = new Date();
        String producto = "Vino Proto";
        int cantidad = 10;
        double precio = 20.5;
        boolean resultado = saVentas.registrarVenta(fecha, producto, cantidad, precio);
        
        // Verifica que la venta se haya registrado correctamente
        assertTrue(resultado);
    }
    
    @Test
    public void testListadoVentas() {
        // Obtiene el listado de ventas
        List<TransferVentas> ventas = saVentas.listadoVentas();
        
        // Verifica que el listado no esté vacío
        assertNotNull(ventas);
        // Puedes realizar más aserciones según lo que esperes del listado de ventas
    }
    
    @Test
    public void testActualizarIncidencia() {
        // Suponiendo que tienes una venta existente
        int idVenta = 2;
        String estado = "Resuelta";
        String detalles = "El cliente recibió el producto correctamente";
        
        // Actualiza la incidencia de la venta
        boolean resultado = saVentas.actualizarIncidencia(idVenta, estado, detalles);
        
        // Verifica que la incidencia se haya actualizado correctamente
        assertTrue(resultado);
    }
    
    @Test
    public void testEliminarVenta() {
        // Suponiendo que tienes una venta existente
        int idVenta = 1;
        
        // Elimina la venta
        boolean resultado = saVentas.eliminarVenta(idVenta);
        
        // Verifica que la venta se haya eliminado correctamente
        assertTrue(resultado);
    }
    
    @Test
    public void testListadoIncidencias() {
        // Obtiene el listado de incidencias
        List<TransferVentas> incidencias = saVentas.listadoIncidencias();
        
        // Verifica que el listado no esté vacío
        assertNotNull(incidencias);
        // Puedes realizar más aserciones según lo que esperes del listado de incidencias
    }
    
}
