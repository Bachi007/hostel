package serviceImpl;

import org.apache.log4j.Logger;
import model.user;
import daoImpl.loginnregisterDAOIMPL;
import exception.globalException;
import service.loginnregister;
import java.util.*;
	
public class loginnregisterImpl implements loginnregister {

	static Logger log=Logger.getLogger(loginnregisterImpl.class);
	static Scanner sc=new Scanner(System.in);
	static loginnregisterDAOIMPL dao=new loginnregisterDAOIMPL();
	static userdashboardImpl userda=new userdashboardImpl();
	static admindashboardImpl adminda=new admindashboardImpl();
	@Override
	
	//registration method
	public void registration()throws globalException  {
		log.info("Welcome to registration");
		//reading all the values
		log.info("Enter Username");
		String uname=sc.next();
		log.info("Enter Password");
		String upass=sc.next();
		log.info("Enter Phone number");
		String uphone=sc.next();
		log.info("Enter Address");
		String uadr=sc.next();
		//creating user object to store in db
		user u1=new user();
		
		u1.setUserName(uname);
		u1.setUserPassword(upass);
		u1.setUserPhone(uphone);
		u1.setUserAddress(uadr);
		u1.setUserRole("student");
		u1.setUserRoom(null);
		u1.setUserFee(0);
	
		//sending user for registration
		int res=dao.registration(u1);
		//validating the response
		if(res==1) {
			log.info("Registration success");
		}
		else {
			log.info("something went wrong");
		}
	
	
	}

	@Override
	//login method
	public void login() throws globalException{
		log.info("welcome to login");
		log.info("Enter Username");
		String uname=sc.next();
		log.info("Enter Password");
		String pass=sc.next();
		//calling login method with username and password
	user u2=dao.login(uname, pass);
	
	//validating response from login
	if(u2!=null) {
		log.info("login success");
		
		//validating user role 
		if(u2.getUserRole().equals("admin")) {
			adminda.dashboard();
		}
		else {
			userda.userdashboard();
		}
		
	}
	else {
		log.info("login failed");
	}
		
		
		
	}

}
