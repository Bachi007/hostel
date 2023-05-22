package service;

import exception.globalException;

public interface admindashboard {

	public void dashboard()throws globalException;
	
	public void createRoom()throws globalException;
	
	public void viewUsers();
	
	public void viewRooms();
	
	public void allotRoom();
	
	public void deleteUser();
	
	public void deleteRoom();
	
	public void addDueAmount();
	
	public void addpaidDueAmount();
	
	public void viewUser();
}

