package ltweb.daos;

import ltweb.models.UserModel;

public interface UserDao {
	
	//Dinh Nghia ca phuong Thuc
	UserModel findByUserName(String username);
	int getRoleid();
	boolean checkExistUsername(String username);
	boolean checkExistEmail(String email);
	UserModel Insert(String email,String username,String fullname, String password,String avatar,int roleid,String phone );
	
}
