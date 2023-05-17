package serviceImpl;

import org.apache.log4j.Logger;

import service.admindashboard;

public class admindashboardImpl implements admindashboard {

	static Logger log=Logger.getLogger(admindashboardImpl.class);
	@Override
	public void dashboard() {
		log.info("\t\t\t\t*****welcome to admin dashboard*****");
		
	}

}
