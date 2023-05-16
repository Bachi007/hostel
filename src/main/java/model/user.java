package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class user {

	@Id
	private int userId;
	private String userName;
	private String userPhone;
	private String userPassword;
	private String userAddress;
	private int userFee;
	private String  userRole;
	
	@ManyToOne
	private room userRoom;
	
}
