package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import negocio.SAImpVino;
import negocio.SAVino;
import negocio.TransferVino;

import java.util.List;

public class VinoTest {

    private SAImpVino saVino;

    @Before
    public void setUp() {
        // Aquí puedes inicializar tus objetos necesarios para las pruebas, como un objeto SAVino
        saVino = SAImpVino.getInstance(); // Suponiendo que SAImpVino implementa la interfaz SAVino
    }

    @Test
    public void testAddVino() {
        // Prueba la función addVino
        TransferVino nuevoVino = new TransferVino(200, "Winery", "Protos", 2022, 3.0, 15, " ", 30, 
    			"Madrid", "tinto", 3, 4, "3", "amargo", "carne", "", 15, 20, "bueno", 0);
        assertNotNull(nuevoVino);
        
        int id = saVino.addVino(nuevoVino);
        assertNotEquals(-1, id); // Asegúrate de que el ID retornado no sea cero, indicando que se ha agregado correctamente
    }
    
    @Test
    public void testBuscarVino() {
        // Prueba la función buscarVino con un ID válido
        TransferVino vino = saVino.buscarVino(200);
        assertNotNull(vino); // Asegúrate de que el vino encontrado no sea nulo
        assertEquals("Protos", vino.getWine());
    }

    @Test
    public void testActualizarVino() {
        // Prueba la función actualizarVino
        TransferVino vinoExistente = saVino.buscarVino(200); // Suponiendo que 28 es un ID válido
        assertNotNull(vinoExistente); // Asegúrate de que el vino exista

        // Guarda los valores originales del vino
        double ratingOriginal = vinoExistente.getRating();
        double nuevoRating = 4.0; // Nuevo valor para el rating

        // Actualiza el rating del vino
        vinoExistente.setRating(nuevoRating);
        saVino.actualizarVino(vinoExistente);

        // Ahora busca el mismo vino y comprueba si el rating se ha actualizado correctamente
        TransferVino vinoActualizado = saVino.buscarVino(200);
        assertEquals(nuevoRating, vinoActualizado.getRating(), 0.01); // Compara el rating con un margen de error de 0.01
    }

    @Test
    public void testBuscarVinos() {
        // Prueba la función buscarVinos
        List<TransferVino> vinos = saVino.buscarVinos();
        assertNotNull(vinos); // Asegúrate de que la lista de vinos no sea nula
        assertFalse(vinos.isEmpty()); // Asegúrate de que la lista de vinos no esté vacía
        // Puedes hacer más aserciones sobre la lista de vinos si es necesario
    }

    @Test
    public void testEliminarVino() {
        // Prueba la función eliminarVino
        TransferVino vinoAEliminar = saVino.buscarVino(200); // Suponiendo que 1 es un ID válido
        assertNotNull(vinoAEliminar); // Asegúrate de que el vino exista
        saVino.eliminarVino(vinoAEliminar);
        // Intenta buscar el vino eliminado y asegúrate de que ya no exista
        TransferVino vinoEliminado = saVino.buscarVino(200);
        assertNull(vinoEliminado); // Asegúrate de que el vino eliminado sea nulo
    }

}
