package ltweb.services;

import ltweb.daos.UserDao;
import ltweb.daos.impl.UserDaoImpl;
import ltweb.models.UserModel;
import ltweb.services.Impl.UserServiceImpl;

public interface UserService {
	
	//Dinh Nghia ca phuong Thuc
	UserModel findByUserName(String username);
	
	UserModel login(String username, String password);
	void insert(UserDao user);
	
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

	boolean insert(UserDaoImpl newUser);

	boolean register(String username);

	boolean register(UserServiceImpl user);

	boolean register(UserDao user);


	boolean register(String email, String username,String fullname, String password,String avatar,int roleid, String phone);
}
