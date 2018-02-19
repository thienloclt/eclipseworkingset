package monprojet.personne;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context1 = new ClassPathXmlApplicationContext("META-INF/Spring/personal.xml");
		Personne beanThomas = (Personne) context1.getBean("thomas");
		beanThomas.partSePromener();
		
		((ClassPathXmlApplicationContext)context1).close();
	}
}
