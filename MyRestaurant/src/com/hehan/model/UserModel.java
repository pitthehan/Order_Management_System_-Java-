/**
 * User Table Model, control the users, mainly write business logic operation
 * 
 */
package com.hehan.model;
import com.hehan.db.*;
import java.sql.*;
public class UserModel {
	/**
	 * 
	 * @param uid userid
	 * @param p userpassword
	 * @return userposition, if not exist, return ""
	 */
	public String checkUser(String uid, String p) {
		String position = "";
		SqlHelper sh = null;
		
		try {
			//sql and parameter list
			String sql = "select personnelinfo.position from checkuser, personnelinfo where checkuser.userid=personnelinfo.userid and checkuser.userid=? and checkuser.passwd=?";
			String paras[] = {uid,p};
		    sh = new SqlHelper();
			ResultSet rs = sh.query(sql, paras);
			if(rs.next()) {
				//get position
				position = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sh.close();
		}
		
		return position;
	}
}
