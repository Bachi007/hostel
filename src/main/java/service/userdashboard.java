package service;

import exception.globalException;

public interface userdashboard {

	public void userdashboard(int userId)throws globalException ;
	
	public void viewRoom();
	
	public void viewDueAmount();
	
	public void changePhoneNum();
	
	public void changePassword()throws globalException;
	
	public void viewProfile();
}
