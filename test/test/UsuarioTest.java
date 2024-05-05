package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import integracion.DAOImpUsuario;
import negocio.SAImpUsuario;
import negocio.TransferUsuario;

class UsuarioTest {

	@Test
    public void testDAOImpUsuario() {
        DAOImpUsuario daoUsuario = new DAOImpUsuario();

        // Prueba el método addUsuario
        TransferUsuario usuario = new TransferUsuario(123456, "Usuario Prueba", "usuario@example.com");
        int idUsuario = daoUsuario.addUsuario(usuario);
        assertTrue(idUsuario > 0);

        // Prueba el método buscarUsuario
        TransferUsuario usuarioRecuperado = daoUsuario.buscarUsuario(idUsuario);
        assertNotNull(usuarioRecuperado);
        assertEquals(usuario.getNif(), usuarioRecuperado.getNif());

        // Prueba el método buscarUsuarios
        List<TransferUsuario> usuarios = daoUsuario.buscarUsuarios();
        assertNotNull(usuarios);
        assertTrue(usuarios.size() > 0);

        // Prueba el método eliminarUsuario
        boolean eliminado = daoUsuario.eliminarUsuario(idUsuario);
        assertTrue(eliminado);
    }

    @Test
    public void testSAImpUsuario() {
        SAImpUsuario saUsuario = new SAImpUsuario();

        // Prueba el método addUsuario
        TransferUsuario usuario = new TransferUsuario(11111, "Usuario Prueba2", "usuario@example.com");
        int idUsuario = saUsuario.addUsuario(usuario);
        assertTrue(idUsuario >= 0);

        // Prueba el método buscarUsuario
        TransferUsuario usuarioRecuperado = saUsuario.buscarUsuario(idUsuario);
        assertNotNull(usuarioRecuperado);
        assertEquals(usuario.getNif(), usuarioRecuperado.getNif());

        // Prueba el método buscarUsuarios
        List<TransferUsuario> usuarios = saUsuario.buscarUsuarios();
        assertNotNull(usuarios);
        assertTrue(usuarios.size() > 0);

        // Prueba el método eliminarUsuario
        boolean eliminado = saUsuario.eliminarUsuario(idUsuario);
        assertTrue(eliminado);
    }

}
