package vn.viettuts.autowiring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vn.viettuts.autowiring.byname.Application;
import vn.viettuts.autowiring.bytype.Employee;
import vn.viettuts.autowiring.constructor.Employee1;
import vn.viettuts.autowiring.no.Student;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext context;
		
		//autowire="no"
		context = new ClassPathXmlApplicationContext("student-bean.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student);	
		
		//autowire="byName"
		context = new ClassPathXmlApplicationContext("application-bean.xml");
		Application application = (Application) context.getBean("application");
		System.out.println(application);
		
		//autowire="byType"
		context = new ClassPathXmlApplicationContext("employee-bean.xml");
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee);
		
		//autowire="constructor"
		context = new ClassPathXmlApplicationContext("employee-1-bean.xml");
		Employee1 employee1 = (Employee1) context.getBean("employee");
		System.out.println(employee1);	
	}
}
