package monprojet.language;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Spring/language.xml");
		Langague english = (Langague) context.getBean("english");
		System.out.println(english.getGreeting());
		
		Langague french = (Langague) context.getBean("french");
		System.out.println(french.getGreeting());
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
