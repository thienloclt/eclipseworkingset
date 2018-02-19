package monprojet.jpa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import monprojet.jpa.dao.EntityyDao;
import monprojet.jpa.model.Entityy;



public class Main {
	public static void main(String[] args) {
		
		Entityy entityy = new Entityy("....");
		
		ApplicationContext context1 = new ClassPathXmlApplicationContext("META-INF/Spring/jpa.xml");
		EntityyDao entityyDao = (EntityyDao) context1.getBean("entityyDao");
		
		entityyDao.create(entityy);
		
		((ClassPathXmlApplicationContext)context1).close();
	}
}