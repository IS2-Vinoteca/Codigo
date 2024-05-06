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
        saVino = SAImpVino.getInstance(); // Suponiendo que SAImpVino implementa la interfaz SAVino
    }

    @Test
    public void testBuscarVinos() {
        // Prueba la función buscarVinos
        List<TransferVino> vinos = saVino.buscarVinos();
        assertNotNull(vinos); // Asegúrate de que la lista de vinos no sea nula
        assertFalse(vinos.isEmpty()); // Asegúrate de que la lista de vinos no esté vacía
        // Puedes hacer más aserciones sobre la lista de vinos si es necesario
    }

}
