package monprojet.musique;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChefOrchestre {
	
	public void beforeJouer() {
		Logger logger = LogManager.getLogger();
		logger.info("Chef");
		
		System.out.println("-----Chef: Before--------");
	}
	
	public void afterJouer() {
		System.out.println("-----Chef: After--------");
	}
}
