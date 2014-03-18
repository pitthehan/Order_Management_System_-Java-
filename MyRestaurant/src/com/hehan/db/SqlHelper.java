/**
 * operate the database
 * CRUD
 */

package com.hehan.db;
import java.util.*;
import java.sql.*;
import java.sql.Driver;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class SqlHelper {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection ct = null;
	String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=RestaurantDB";
	String user = "hehan";
	String passwd = "hehan";
	//Constructor, initialize ct
	public SqlHelper() {
		try {
			//load driver
			Class.forName(driverName);
			ct = DriverManager.getConnection(url,user,passwd);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//add, delete, update
	public boolean exeUpdate(String sql, String[] paras) {
		boolean b = true;
		try {
			ps = ct.prepareStatement(sql);
			//give values to arguments
			for(int i=0; i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			b = false;
			e.printStackTrace();
		}
		
		return b;
	}
	
	public ResultSet query(String sql, String []paras) {
		try {
			ps = ct.prepareStatement(sql);
			//give values to arguments
			for(int i=0; i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	//close the resource
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}



