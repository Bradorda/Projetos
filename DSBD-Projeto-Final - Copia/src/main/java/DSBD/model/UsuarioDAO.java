package DSBD.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private BCrypt bCrypt = new BCrypt();

	@SuppressWarnings("static-access")
	public boolean create(Usuario usuario) {

		String sql = "INSERT INTO USUARIOS(USERNAME,PASSWORD) VALUES(?,?)";
		try {
			String passwordBcrypt = bCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			int rowsAffected = jdbcTemplate.update(sql, usuario.getUsername(), passwordBcrypt);
			return rowsAffected > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("deprecation")
	public Usuario search(String username) {
		String sql = "SELECT * FROM USUARIOS WHERE USERNAME = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UsuarioRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Método auxiliar para manipular objetos no ResultSet
	private static class UsuarioRowMapper implements RowMapper<Usuario> {
		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setPk_username(rs.getInt("pk_username"));
			usuario.setUsername(rs.getString("username"));
			usuario.setPassword(rs.getString("password"));
			return usuario;
		}
	}
}
