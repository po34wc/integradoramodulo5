package cl.integradoram5.usuario.model.dao;

import java.util.List;

import cl.integradoram5.usuario.model.entidad.Usuario;

public interface UsuarioDao {
	Usuario guardar(Usuario usuario);
	boolean editar(Usuario usuario);
	Usuario obtenerPorId(int id);
	Usuario obtenerPorNombre(String usuario);
	List<Usuario> getListado();
}
