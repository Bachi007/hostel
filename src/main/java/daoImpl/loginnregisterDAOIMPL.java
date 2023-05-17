package daoImpl;

import org.hibernate.Session;

import config.hibernateUtil;
import dao.loginnregisterDAO;
import exception.globalException;
import model.user;

public class loginnregisterDAOIMPL implements loginnregisterDAO {

	@Override
	public int registration(user u1) throws globalException {
		
		//creating auto closable session object
		try(Session ses=hibernateUtil.getSession()){
			
			//reading username
			String username=u1.getUserName();
			user u2=null;
			//getting user details based on user name
			u2=(user)ses.createQuery("from user where userName=:uname").setParameter("uname", username).uniqueResult();
			
			//if username not existed then save the user
			if(u2==null) {
				ses.beginTransaction();
				ses.save(u1);
				ses.getTransaction().commit();
				return 1;
			}
			else {
				throw new globalException("user already existed");
			}
			
		}
	}

	@Override
	public user login(String username,String password) throws globalException {
		
			//creating auto closable session object
			try(Session ses=hibernateUtil.getSession()){
			user u2=null;
			//getting userdetails based on username
			u2=(user)ses.createQuery("from user where userName=:uname").setParameter("uname", username).uniqueResult();
			
			if(u2!=null) {
				//validating password
				if(password.equals(u2.getUserPassword())) {
					return u2;
				}
				else {
					return null;
				}
			}
			else {
				throw new globalException("user not found");
			}
			}
	}

}
