package serviceImpl;

import org.apache.log4j.Logger;

import service.loginnregister;

	
public class loginnregisterImpl implements loginnregister {

	static Logger log=Logger.getLogger(loginnregisterImpl.class);
	@Override
	public void registration() {
		log.info("Welcome to registration");
		
	}

	@Override
	public void login() {
		log.info("welcome to login");
		
	}

}
