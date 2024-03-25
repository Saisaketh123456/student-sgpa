package com.batch.web;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.batch.model.GetMember;
import com.batch.model.PostMember;

public class PostDao {
	public static Connection getDBConn() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa", "root", "saketh");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int post(PostMember me) {
		int i = 0;
		try (Connection conn = getDBConn(); 
				PreparedStatement pst = conn.prepareStatement("insert into student(name, sem, usn, sgpa) values(?,?,?,?) ")){
			pst.setString(1, me.getName());
			pst.setString(2, me.getSem());
			pst.setString(3, me.getUsn());
			pst.setFloat(4, me.getSgpa());
			i = pst.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public PostMember get(GetMember gm) {
		try (Connection conn = getDBConn(); 
				PreparedStatement pst = conn.prepareStatement("select * from student where usn = ? and sem = ?")){
			pst.setString(1, gm.getUsn());
			pst.setString(2, gm.getSem());
			ResultSet rs = pst.executeQuery();
			System.out.println("name\t\tsem\t\tusn\t\tsgpa");

			while (rs.next()) { // Move the cursor to the first row
	            String sem = rs.getString("sem");
	            String name = rs.getString("name");
	            String usn = rs.getString("usn");
	            float sgpa = rs.getFloat("sgpa");
	            System.out.println(name + "\t\t" + sem + "\t\t" + usn + "\t\t" + sgpa);
	            PostMember member = new PostMember(name, usn, sem, sgpa);
	            return member;
	        }            
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
