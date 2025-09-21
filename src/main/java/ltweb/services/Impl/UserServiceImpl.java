package ltweb.services.Impl;

import ltweb.daos.UserDao;
import ltweb.daos.impl.UserDaoImpl;
import ltweb.models.UserModel;
import ltweb.services.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl(); //Goij Phuong thuc tang Daos
	
	
	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	
	}
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}
	public boolean register(String email, String username,String fullname, String password,String avatar,int roleid, String phone ) {

		userDao.Insert(email,username,fullname,password,avatar,roleid,phone);
		
		return true;
        
	}
	@Override
	public void insert(UserDao user) {
		// TODO Auto-generated method stub
		
		
	}

	

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		
		return false;
		
		
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		
		return false;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean insert(UserDaoImpl newUser) {
		// TODO Auto-generated method stub
		return false;
	}


	
	@Override
	public boolean register(UserServiceImpl user) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub

		return false;
	}





	@Override
	public boolean register(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean register(UserDao user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
