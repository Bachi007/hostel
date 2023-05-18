package serviceImpl;

import org.apache.log4j.Logger;

import exception.globalException;
import service.admindashboard;
import java.util.*;
import model.*;
import daoImpl.admindashboardDAOIMPL;
public class admindashboardImpl implements admindashboard {

	static Logger log=Logger.getLogger(admindashboardImpl.class);
	static Scanner sc=new Scanner(System.in);
	static admindashboardImpl  impl=new admindashboardImpl ();
	static admindashboardDAOIMPL dao=new admindashboardDAOIMPL();
	@Override
	public void dashboard()throws globalException {
		log.info("\t\t\t\t*****welcome to admin dashboard*****");
		int ch=5;
		while(ch!=0) {
			log.info("Press 1 for Create Room\nPress 2 for view users\nPress 3 for view Rooms\nPress 4 to allot the room\nPress 0 to exit ");
			
			log.info("Enter your choice of Operation");
			ch=sc.nextInt();
			
			switch(ch) {
			
			case 1->impl.createRoom();
			case 2->impl.viewUsers();
			case 3->impl.viewRooms();
			case 4->impl.allotRoom();
			}
				
		}
		
	}
	@Override
	
	//creating the room
	public void createRoom() throws globalException {
		log.info("Enter room id");
		int rId=sc.nextInt();
		log.info("Enter room Name");
		String rname=sc.next();
		log.info("Enter room type");
		String rtype=sc.next();
		
		room r1=new room();
		r1.setRoomId(rId);
		r1.setRoomName(rname);
		r1.setRoomType(rtype);
		//calling createroom method from dao
		int res=dao.createRoom(r1);
			if(res==1) {
				log.info("room added successfully");
			}
	}
	//view all the users
	@Override
	public void viewUsers() {
		List<user> userList=dao.viewUsers();
		
		//iterating userlist to print every user
		for(user u:userList)
			log.info(u.getUserId()+" "+u.getUserName()+" ");
		
	}
	//view all rooms
	@Override
	public void viewRooms() {
		List<room> roomList=dao.viewRooms();
		//iterating roomlist to print every room
		for(room r:roomList)
			log.info(r.toString());
	}
	//alloting room to the user
	@Override
	public void allotRoom() {
		log.info("Enter user id");
		int uid=sc.nextInt();
		log.info("Enter Room id");
		int rid=sc.nextInt();
		
		int status=dao.allotRoom(uid, rid);
		if(status==1) {
			log.info("room allotted successfully");
		}
		
	}

}
