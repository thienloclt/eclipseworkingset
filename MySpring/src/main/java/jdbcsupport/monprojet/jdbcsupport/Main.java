package monprojet.jdbcsupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context1 = new ClassPathXmlApplicationContext("META-INF/Spring/jdbcsupport.xml");
		EmployeeDaoJdbc employeeDaoJdbc = (EmployeeDaoJdbc) context1.getBean("employeeDaoJdbc");
		employeeDaoJdbc.saveEmployee();
		((ClassPathXmlApplicationContext)context1).close();
	}
}