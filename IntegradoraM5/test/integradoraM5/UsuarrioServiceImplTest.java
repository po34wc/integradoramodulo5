package integradoraM5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.integradoram5.usuario.model.dao.UsuarioDao;
import cl.integradoram5.usuario.model.entidad.Usuario;
import cl.integradoram5.usuario.model.service.impl.UsuarioServiceImpl;

public class UsuarrioServiceImplTest {
	Usuario usuario;
	UsuarioServiceImpl usuarioserviceimp;
	UsuarioDao usuarioDao;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario(1, "jose", 15000);
	}
	
	@Test
	@DisplayName("Prueba crear usuario si ya existe")
	void testCrearUsuarioYaExistente() {
		Usuario resultado = usuarioserviceimp.crearUsuario(usuario);
		String salida = resultado.getNombre();
		assertEquals("jose", salida);
	}
}
