package monprojet.musique;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger();
		logger.error("Error");
		
		ApplicationContext context1 = new ClassPathXmlApplicationContext("META-INF/Spring/ApplicationContext.xml");
		Performeur beanThomas = (Performeur) context1.getBean("thomas");
		beanThomas.performe();
		
		((ClassPathXmlApplicationContext)context1).close();
		
//		MusicienNotImpl beanLoc = (MusicienNotImpl) context1.getBean("loc");
//		beanLoc.performe();
	}
}
