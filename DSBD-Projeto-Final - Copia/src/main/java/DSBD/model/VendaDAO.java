package DSBD.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Venda> buscarAllVendas() {
		String sql = "select * from venda";
		try {
			return jdbcTemplate.query(sql, new VendaRowMapper());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static class VendaRowMapper implements RowMapper<Venda> {
		@Override
		public Venda mapRow(ResultSet rs, int rowNum) throws SQLException {
			Venda venda = new Venda();
			venda.setNumeroNF(rs.getString("numeroNF"));
			venda.setCliente(rs.getString("cliente"));
			venda.setProduto(rs.getString("produto"));
			venda.setQuantidade(rs.getInt("quantidade"));
			venda.setValor(rs.getDouble("valor"));
			venda.setData(rs.getObject("data", LocalDate.class));

			return venda;
		}
	}

}
