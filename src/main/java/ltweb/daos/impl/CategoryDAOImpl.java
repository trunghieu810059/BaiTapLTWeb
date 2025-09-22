package ltweb.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ltweb.models.Category;



import ltweb.daos.CategoryDAO;
import ltweb.jdbc.DBConnection;

public class CategoryDAOImpl extends DBConnection implements CategoryDAO   {
	@Override
	public void insert(Category category) {
	String sql = "INSERT INTO category(cate_name,icons) VALUES (?,?)";
	try {
	Connection con = super.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, category.getName());
	ps.setString(2, category.getIcon());
	ps.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	@Override
	public void edit(Category category) {
	    String sql = "UPDATE Category SET cate_name = ?, icons = ? WHERE cate_id = ?";
	    try {
	        Connection con = super.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, category.getName());
	        ps.setString(2, category.getIcon());
	        ps.setInt(3, category.getId());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public List<Category> search(String keyword) {
	    List<Category> list = new ArrayList<>();
	    String sql = "SELECT * FROM Category WHERE cate_name LIKE ?";
	    try {
	        Connection con = super.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, "%" + keyword + "%");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Category c = new Category();
	            c.setId(rs.getInt("cate_id"));
	            c.setName(rs.getString("cate_name"));
	            c.setIcon(rs.getString("icons"));
	            list.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	
	@Override
	public void delete(int id) {
	String sql = "DELETE FROM category WHERE cate_id = ?";
	try {
	Connection con = super.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	ps.executeUpdate();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	@Override
	public Category get(int id) {
	String sql = "SELECT * FROM category WHERE cate_id = ? ";
	try {
	Connection con = super.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	Category category = new Category();
	category.setId(rs.getInt("cate_id"));
	category.setName(rs.getString("cate_name"));
	category.setIcon(rs.getString("icons"));
	return category;
	}} catch (Exception e) {
	e.printStackTrace();}
	return null;
	}
	@Override
	public List<Category> getAll() {
	List<Category> categories = new ArrayList<Category>();
	String sql = "SELECT * FROM Category";
	try {
	Connection conn = super.getConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
	Category category = new Category();
	category.setId(rs.getInt("cate_id"));
	category.setName(rs.getString("cate_name"));
	category.setIcon(rs.getString("icons"));
	categories.add(category);
	}} catch (Exception e) {
	e.printStackTrace();}
	return categories;
	}
	@Override
	public Category get(String name) {
	    Category category = null;
	    String sql = "SELECT * FROM Category WHERE cate_name = ?";
	    try {
	        Connection con = super.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, name);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            category = new Category();
	            category.setId(rs.getInt("cate_id"));
	            category.setName(rs.getString("cate_name"));
	            category.setIcon(rs.getString("icons"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return category;
	}



}
