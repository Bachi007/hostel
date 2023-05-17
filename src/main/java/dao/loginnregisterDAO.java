package dao;
import exception.globalException;
import model.user;
public interface loginnregisterDAO {

	public int registration(user u1) throws globalException ;
	
	public user login(String username,String password)throws globalException;
	
	
}
