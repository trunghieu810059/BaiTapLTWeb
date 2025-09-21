package ltweb.daos.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ltweb.daos.UserDao;
import ltweb.jdbc.DBConnection;
import ltweb.models.UserModel;

public class UserDaoImpl implements  UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public UserDaoImpl(String email, String username, String fullname, String password, Object object, int roleid,
			String phone, Date date) {
	}
	public UserDaoImpl() {
	}
	
	@Override
	public UserModel findByUserName(String username) {
		
		
		String sql = "SELECT * FROM users WHERE userName = ? ";
		try {
		//conn = DBConnection.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		Connection conn = DBConnection.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			UserModel user = new UserModel();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setFullname(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setRoleid(rs.getInt("roleid"));
			user.setAvatar(rs.getString("avatar"));
			user.setPhone(rs.getString("phone"));
		
			return user;
		}
		} catch (Exception e) {e.printStackTrace();
		
		
		}
		return null;
	}
	@Override
	public UserModel Insert(String email,String username,String fullname, String password,String avatar,int roleid,String phone) {
String query = "INSERT INTO users(email, username, fullname, password, avatar,roleid, phone, createddate) VALUES (?,?,?,?,?,?,?,?)";
		
Connection conn = DBConnection.getConnection();

		try (PreparedStatement ps = conn.prepareStatement(query)){
				//new DBConnection();
				//conn = DBConnection.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			 	
				//ps = conn.prepareStatement(sql);
				
				ps.setString(1, email);
				ps.setString(2, username);
				ps.setString(3, fullname);
				ps.setString(4, password);
				ps.setString(5, avatar);
				//ps.setInt(6, user.rol); 
				ps.setInt(6, roleid);
				ps.setString(7,phone);
				// Get the current date and time as a Timestamp
				//ps.setString(7,"10/10/1999");
				ps.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis()));
				
		        System.out.println("Executing SQL: " + query);
		        
				ps.executeUpdate();
				
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public int getRoleid() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT COUNT(*) FROM users username = ?";
		try {
			
			 	Connection conn = DBConnection.getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, username);
				rs = ps.executeQuery();
				 System.out.println("Executing SQL check username: " + ps);
				if (rs.next()) {
				duplicate = true;
				}
				ps.close();
				conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}
	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "SELECT COUNT(*) FROM users WHERE email = ?";
		try {
		
			//conn = DBConnection.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			 	Connection conn = DBConnection.getConnection();
				ps = conn.prepareStatement(query);
				ps.setString(1, email);
				rs = ps.executeQuery();
				 System.out.println("Executing SQL check email: " + ps);
				if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
	} catch (Exception ex) {}
	return duplicate;
	}

}