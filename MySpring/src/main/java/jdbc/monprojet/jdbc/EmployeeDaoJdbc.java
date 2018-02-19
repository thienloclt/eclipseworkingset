package monprojet.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoJdbc {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoJdbc() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void saveEmployee() {
		String s = "insert into employee(id, lastname, firstname) values (?,?,?)";
		this.jdbcTemplate.update(s, new Object[] { 1L, "aaaaa123", "bbbbb123" });
	}
}