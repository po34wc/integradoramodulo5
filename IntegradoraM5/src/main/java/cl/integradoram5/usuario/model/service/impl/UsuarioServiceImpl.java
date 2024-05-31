package cl.integradoram5.usuario.model.service.impl;

import java.util.List;

import cl.integradoram5.usuario.model.dao.UsuarioDao;
import cl.integradoram5.usuario.model.entidad.Usuario;
import cl.integradoram5.usuario.model.service.UsuarioService;


public class UsuarioServiceImpl implements UsuarioService {
	private UsuarioDao usuarioDao;

	
	public UsuarioServiceImpl(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		Usuario buscado = new Usuario();
		if(usuario != null && usuario.getNombre() != null) 
		{
			buscado = this.getByNombre(usuario.getNombre());
			if (buscado == null) {
				return usuarioDao.guardar(usuario);
			}
		}
		return buscado;
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioDao.getListado();
	}

	@Override
	public boolean editarUsuario(Usuario usuario) {
		if(usuario.getId() > 0) {
			usuarioDao.editar(usuario);
			return true;
		}
		return false;
	}

	@Override
	public Usuario getById(int id) {
		return usuarioDao.obtenerPorId(id);
	}
	
	@Override
	public Usuario getByNombre(String usuarioNombre) {
		return usuarioDao.obtenerPorNombre(usuarioNombre);
	}
}
