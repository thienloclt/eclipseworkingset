package monprojet.jdbcsupport;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class EmployeeDaoJdbc extends JdbcDaoSupport{
	
	public EmployeeDaoJdbc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void saveEmployee() {
		String s = "insert into employee(id, lastname, firstname) values (?,?,?)";
		getJdbcTemplate().update(s, new Object[] {1L, "aaaaa", "bbbbb"});
	}
}
