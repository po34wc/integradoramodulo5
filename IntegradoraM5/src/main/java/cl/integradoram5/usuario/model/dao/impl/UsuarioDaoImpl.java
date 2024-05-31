package cl.integradoram5.usuario.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.integradoram5.shared.model.dao.DAO;
import cl.integradoram5.usuario.model.dao.UsuarioDao;
import cl.integradoram5.usuario.model.entidad.Usuario;

public class UsuarioDaoImpl extends DAO implements UsuarioDao {
	@Override
	public Usuario guardar(Usuario usuario) {
		String nombre = usuario.getNombre();
		int saldoDisponible = usuario.getSaldoDisponible();
		
		String insertSql = "insert into usuario (nombre, saldoDisponible)";
		insertSql += " values ('" + nombre + "', " + saldoDisponible + ")";
		
		ejecutarSql(insertSql);
		
		usuario = this.obtenerPorNombre(nombre);
		return usuario;
	}

	@Override
	public List<Usuario> getListado() {
		try {
			List<Usuario> listado = new ArrayList<>();
			String selectAllsql = "select nombre, saldoDisponible from usuario";
			ResultSet rsl = this.consultar(selectAllsql);
			
			while(rsl.next()) {
				String nombre = rsl.getString("nombre");
				int saldoDisponible = rsl.getInt("saldoDisponible");
			
				Usuario usuario = new Usuario(nombre, saldoDisponible);
				listado.add(usuario);	
			}
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean editar(Usuario usuario) {
		String nombre = usuario.getNombre();
		int saldoDisponible = usuario.getSaldoDisponible();
		
		String insertSql = "update usuario ";
		insertSql += " set nombre='" + nombre + "'";
		insertSql += " , saldoDisponible = " + saldoDisponible;
		insertSql += " where id=" + usuario.getId();
		
		int registrosAfectados = ejecutarSql(insertSql);
		boolean resultado = (registrosAfectados > 0);
		return resultado;
	}

	@Override
	public Usuario obtenerPorId(int id) {
		try {
			Usuario usuario = null;
			String selectUsuarioSql = "select id, nombre, saldoDisponible from usuario where id=" + id;
			ResultSet rsl = this.consultar(selectUsuarioSql);
			
			while(rsl.next()) {
				int idUsuario = rsl.getInt("id");
				String nombre = rsl.getString("nombre");
				int saldoDisponible = rsl.getInt("saldoDisponible");
			
				usuario = new Usuario(idUsuario, nombre, saldoDisponible);
			}
			return usuario;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Usuario obtenerPorNombre(String usuarioNombre) {
		try {
			Usuario usuario = null;
			String selectUsuarioSql = "select id, nombre, saldoDisponible from usuario where nombre = '" + usuarioNombre + "'";
			ResultSet rsl = this.consultar(selectUsuarioSql);
			
			if (rsl == null) {
				return null;
			} else {
				while(rsl.next()) {
					int idUsuario = rsl.getInt("id");
					String nombre = rsl.getString("nombre");
					int saldoDisponible = rsl.getInt("saldoDisponible");

					usuario = new Usuario(idUsuario, nombre, saldoDisponible);
				}
				return usuario;				
			}
		} catch (SQLException e) {
			System.out.print("obtenerPorNombre" + e.getMessage());
			return null;
		}
	}	
}
