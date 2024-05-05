package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import negocio.SAImpVino;
import negocio.SAVino;
import negocio.TransferVino;

import java.util.List;

public class VinoTest {

    private SAVino saVino;

    @Before
    public void setUp() {
        // Aquí puedes inicializar tus objetos necesarios para las pruebas, como un objeto SAVino
        saVino = new SAImpVino(); // Suponiendo que SAImpVino implementa la interfaz SAVino
    }

    @Test
    public void testBuscarVino() {
        // Prueba la función buscarVino con un ID válido
        TransferVino vino = saVino.buscarVino(1);
        assertNotNull(vino); // Asegúrate de que el vino encontrado no sea nulo
        assertEquals("Nombre del vino buscado", vino.getWine());
    }

    @Test
    public void testAddVino() {
        // Prueba la función addVino
        TransferVino nuevoVino = new TransferVino(/* parámetros del constructor */);
        int id = saVino.addVino(nuevoVino);
        assertNotEquals(0, id); // Asegúrate de que el ID retornado no sea cero, indicando que se ha agregado correctamente
    }

    @Test
    public void testActualizarVino() {
        // Prueba la función actualizarVino
        TransferVino vinoExistente = saVino.buscarVino(1); // Suponiendo que 1 es un ID válido
        assertNotNull(vinoExistente); // Asegúrate de que el vino exista
        // Modifica algunos atributos del vino
        vinoExistente.setRating(4.5);
        saVino.actualizarVino(vinoExistente);
        // Ahora busca el mismo vino y comprueba si los atributos se han actualizado correctamente
        TransferVino vinoActualizado = saVino.buscarVino(1);
        assertEquals(4.5, vinoActualizado.getRating(), 0.01); // Compara el rating con un margen de error de 0.01
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
        TransferVino vinoAEliminar = saVino.buscarVino(1); // Suponiendo que 1 es un ID válido
        assertNotNull(vinoAEliminar); // Asegúrate de que el vino exista
        saVino.eliminarVino(vinoAEliminar);
        // Intenta buscar el vino eliminado y asegúrate de que ya no exista
        TransferVino vinoEliminado = saVino.buscarVino(1);
        assertNull(vinoEliminado); // Asegúrate de que el vino eliminado sea nulo
    }

}
