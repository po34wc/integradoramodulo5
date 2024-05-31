package integradoraM5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.integradoram5.usuario.model.entidad.Usuario;

public class UsuarioTest {
	Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario(1, "jose", 15000);
	}
	
	@Test
	@DisplayName("Prueba recuperar el saldo del usuario")
	void testMuestraSaldo() {
		double resultado = usuario.getSaldoDisponible();
		assertEquals(15000, resultado);
	}
	
	@Test
	@DisplayName("Prueba muestra el nombre del usuario")
	void testMuestraNombre() {
		String resultado = usuario.getNombre();
		assertEquals("jose", resultado);
	}
	
	@Test
	@DisplayName("Prueba muestra la id del usuario")
	void testMuestraId() {
		int resultado = usuario.getId();
		assertEquals(1, resultado);
	}
}
