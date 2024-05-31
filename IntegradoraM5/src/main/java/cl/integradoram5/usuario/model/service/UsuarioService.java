package cl.integradoram5.usuario.model.service;

import java.util.List;

import cl.integradoram5.usuario.model.entidad.Usuario;

public interface UsuarioService {
	Usuario crearUsuario(Usuario usuario);
	boolean editarUsuario(Usuario usuario);
	Usuario getById(int id);
	Usuario getByNombre(String usuarioNombre);
	List<Usuario> obtenerUsuarios();
}
