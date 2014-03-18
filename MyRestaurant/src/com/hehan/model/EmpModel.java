/**
 * employee info, CRUD
 * 
 */
package com.hehan.model;

import com.hehan.db.*;

import javax.swing.table.*;

import java.sql.*;
import java.util.*;//Vector
public class EmpModel extends AbstractTableModel{
	Vector<String> columns;
	Vector<Vector> rows;
	
	//delete by userid
	public boolean delEmpById(String empId) {
		boolean b = true;
		String sql = "delete from personnelinfo where userid=?";
		String []paras = {empId};
		SqlHelper sh = new SqlHelper();
		try {
			b = sh.exeUpdate(sql, paras);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sh.close();
		}
		
		return b;
	}
	
	//method to search employee info
	//query commonality
	public void query(String sql, String paras[]) {
		//init columns
		this.columns = new Vector<String>();
		this.columns.add("userid");
		this.columns.add("name");
		this.columns.add("sex");
		this.columns.add("position");
		
		this.rows = new Vector<Vector>();
		//create a sqlhelper
		SqlHelper sh = new SqlHelper();
		ResultSet rs = sh.query(sql, paras);
		
		try {
			
			//we can get ResultSetMetadata from rs, we can get columncount and columnname
			ResultSetMetaData rsmt = rs.getMetaData();
			for(int i=0; i<rsmt.getColumnCount(); i++) {
				this.columns.add(rsmt.getColumnName(i+1));
			}
			while(rs.next()) {
				Vector<String> temp = new Vector<String>();
				for(int i=0;i<rsmt.getColumnCount();i++) {
					temp.add(rs.getString(i+1));
				}
				
//				temp.add(rs.getString(1));
//				temp.add(rs.getString(2));
//				temp.add(rs.getString(3));
//				temp.add(rs.getString(4));
				rows.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sh.close();
		}
		//rs to rows
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.columns.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.columns.get(column).toString();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)rows.get(rowIndex)).get(columnIndex);
	}
	
}
