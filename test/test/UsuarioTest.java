package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.SAImpUsuario;
import negocio.TransferUsuario;

class UsuarioTest {

    private SAImpUsuario saUsuario;
    private int idUsuario; // Necesitas este campo para la prueba de eliminación

    @BeforeEach
    public void setUp() {
        // Aquí puedes inicializar cualquier objeto que necesites para las pruebas
        saUsuario = new SAImpUsuario();
    }

    @Test
    public void testAddUsuario() {
        TransferUsuario usuario = new TransferUsuario(123, "administrador", "admin@");
        idUsuario = saUsuario.addUsuario(usuario);
        assertTrue(idUsuario < 0); // Debe ser -1 porque este usuario ya existe en la base de datos
    }

    @Test
    public void testBuscarUsuario() {
        TransferUsuario usuarioRecuperado = saUsuario.buscarUsuario(123);
        assertNotNull(usuarioRecuperado);
    }

    @Test
    public void testBuscarUsuarios() {
        List<TransferUsuario> usuarios = saUsuario.buscarUsuarios();
        assertNotNull(usuarios);
        assertTrue(usuarios.size() > 0);
    }

    @Test
    public void testEliminarUsuario() {
        boolean eliminado = saUsuario.eliminarUsuario(idUsuario);
        assertTrue(eliminado);
    }

}
