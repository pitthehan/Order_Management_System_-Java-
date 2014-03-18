/**
 * show personnel management
 * 
 */
package com.hehan.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.hehan.tools.MyTools;
import com.hehan.model.*;

public class EmpInfo extends JPanel implements ActionListener {
	
	//components
	JPanel p1, p2, p3, p4, p5;
	JLabel p1_lab1, p3_lab1;
	JTextField p1_jtf1;
	JButton p1_jb1, p4_jb1, p4_jb2, p4_jb3, p4_jb4;
	JTable jtable;
	JScrollPane jsp;
	EmpModel em;
	//constructor
	public EmpInfo() {
		//create components
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1 = new JLabel("Enter name or id or position");
		p1_lab1.setFont(MyTools.f2);
		p1_jtf1 = new JTextField(20);
		p1_jb1 = new JButton("Search");
		p1_jb1.setFont(MyTools.f2);
		
		p1.add(p1_lab1);
		p1.add(p1_jtf1);
		p1.add(p1_jb1);
		
		//p2 connect to database
		em = new EmpModel();
		String []paras = {"1"};
		em.query("select userid,name,sex,position from personnelinfo where 1=?", paras);
		jtable = new JTable(em);
		p2 = new JPanel(new BorderLayout());
		jsp = new JScrollPane(jtable);
		p2.add(jsp);
		
		p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_lab1 = new JLabel("The number of records");
        p3_lab1.setFont(MyTools.f3);
		p3.add(p3_lab1);
		
		p4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p4_jb1 = new JButton("Detailed Info");
		p4_jb1.setFont(MyTools.f3);
		p4_jb2 = new JButton("Add");
		p4_jb2.setFont(MyTools.f3);
		p4_jb3 = new JButton("Update");
		p4_jb3.setFont(MyTools.f3);
		p4_jb4 = new JButton("Delete");
		p4_jb4.addActionListener(this);
		p4_jb4.setFont(MyTools.f3);
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		
		p5 = new JPanel(new BorderLayout());
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p2,"Center");
		this.add(p5,"South");
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//delete one employee
		if(this.p4_jb4==e.getSource()) {
			int selRowNum = jtable.getSelectedRow();
			String empNo = (String)em.getValueAt(selRowNum, 0);
			if(em.delEmpById(empNo)){
				JOptionPane.showMessageDialog(null, "delete successfully"); //JFrame->null
			} else {
				JOptionPane.showMessageDialog(null, "failed to delete");
			}
			String []paras = {"1"};
			//update data model
			em = new EmpModel();//!!!!
			em.query("select userid,name,sex,position from personnelinfo where 1=?", paras);
			jtable.setModel(em);
		}
	}
}
