package com.kodnest.employeemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeManagement {
	Scanner scan = new Scanner(System.in);
	Connection conn = null;
	String dPath = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
	String user = "username";	
	String password = "password";
	
	public EmployeeManagement() {
		try {
			Class.forName(dPath);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void getEmployeeById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM employeemanagementsystem.employee where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	void getAllEmployees() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM employeemanagementsystem.employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	void addEmployee(int id, String name, String salary, String phone, String email, String type) {
	    PreparedStatement ps = null;
	    try {
	        String sql = "INSERT INTO employeemanagementsystem.employee VALUES (?, ?, ?, ?, ?, ?)";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.setString(2, name);
	        ps.setString(3, salary);
	        ps.setString(4, phone);
	        ps.setString(5, email);
	        ps.setString(6, type);

	        int rows = ps.executeUpdate();
	        System.out.println(rows + " employee added successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	void updateEmployee(int id) {
	    PreparedStatement ps = null;
	    try {
	        System.out.println("1. Update Salary");
	        System.out.println("2. Update Phone");
	        System.out.println("3. Update Email");
	        int choice = scan.nextInt();

	        String sql = "";
	        if (choice == 1) {
	            sql = "UPDATE employeemanagementsystem.employee SET salary=? WHERE id=?";
	            System.out.print("Enter new salary: ");
	            String salary = scan.next();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, salary);
	            ps.setInt(2, id);
	        } else if (choice == 2) {
	            sql = "UPDATE employeemanagementsystem.employee SET phone=? WHERE id=?";
	            System.out.print("Enter new phone: ");
	            String phone = scan.next();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, phone);
	            ps.setInt(2, id);
	        } else if (choice == 3) {
	            sql = "UPDATE employeemanagementsystem.employee SET email=? WHERE id=?";
	            System.out.print("Enter new email: ");
	            String email = scan.next();
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, email);
	            ps.setInt(2, id);
	        } else {
	            System.out.println("Invalid choice");
	            return;
	        }

	        int rows = ps.executeUpdate();
	        System.out.println(rows + " employee updated successfully");

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	void deleteEmployee(int id) {
	    PreparedStatement ps = null;
	    try {
	        String sql = "DELETE FROM employeemanagementsystem.employee WHERE id=?";
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();
	        System.out.println(rows + " employee deleted successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
}
