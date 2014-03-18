/**
 * System administrator, manager
 * 
 */
package com.hehan.view;

import com.hehan.tools.*;

import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.*;

import java.io.*;

public class Windows1 extends JFrame implements ActionListener, MouseListener {
	
	Image titleIcon, timeBg;
	
	JMenuBar jmb;
	JMenu jm1, jm2, jm3, jm4, jm5, jm6;
	JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5;
	ImageIcon jmi1_icon1, jmi1_icon2, jmi1_icon3, jmi1_icon4, jmi1_icon5;
	JToolBar jtb;
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;  
	JPanel jp1, jp2, jp3, jp4, jp5;
	JLabel showTime;
	javax.swing.Timer t;//Timer can trigger Action event
	ImagePanel p1_imgPanel;
	JLabel p1_lab1, p1_lab2, p1_lab3, p1_lab4, p1_lab5, p1_lab6, p1_lab7, p1_lab8;
	//jp2 JLabel
	JLabel jp2_lab1, jp2_lab2;
	JSplitPane jsp1;
	CardLayout cardP3;
	CardLayout cardP2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Windows1 w1 = new Windows1();
	}
	public void initMenu() {
		//create ImageIcon
				jmi1_icon1 = new ImageIcon("image/jmi1_icon1.jpg");
				jmi1_icon2 = new ImageIcon("image/jmi1_icon2.jpg");
				jmi1_icon3 = new ImageIcon("image/jmi1_icon3.jpg");
				jmi1_icon4 = new ImageIcon("image/jmi1_icon4.jpg");
				jmi1_icon5 = new ImageIcon("image/jmi1_icon5.jpg");
				
				//create JMenu and JMenuItem
				jm1 = new JMenu("System Management");
				jm1.setFont(MyTools.f1);
				jmi1 = new JMenuItem("Switch User",jmi1_icon1);
				jmi1.setFont(MyTools.f2);
				jmi2 = new JMenuItem("Make Payment",jmi1_icon2);
				jmi2.setFont(MyTools.f2);
				jmi3 = new JMenuItem("Login Management",jmi1_icon3);
				jmi3.setFont(MyTools.f2);
				jmi4 = new JMenuItem("Calendar",jmi1_icon4);
				jmi4.setFont(MyTools.f2);
				jmi5 = new JMenuItem("Exit",jmi1_icon5);
				jmi5.setFont(MyTools.f2);
				jm1.add(jmi1);
				jm1.add(jmi2);
				jm1.add(jmi3);
				jm1.add(jmi4);
				jm1.add(jmi5);
				
				jm2 = new JMenu("Personnel Management");
				jm2.setFont(MyTools.f1);
				jm3 = new JMenu("Menu Management");
				jm3.setFont(MyTools.f1);
				jm4 = new JMenu("Statistics Report");
				jm4.setFont(MyTools.f1);
				jm5 = new JMenu("Cost and Warehouse");
				jm5.setFont(MyTools.f1);
				jm6 = new JMenu("Help");
				jm6.setFont(MyTools.f1);
				
				//add JMenu to JMenuBar
				jmb = new JMenuBar();
				jmb.add(jm1);
				jmb.add(jm2);
				jmb.add(jm3);
				jmb.add(jm4);
				jmb.add(jm5);
				jmb.add(jm6);
				
				//add JMenuBar to JFrame
				this.setJMenuBar(jmb);
	}
	
	public void initToolBar() {
		//ToolBar Component
				jtb = new JToolBar();
				jtb.setFloatable(false);
				jb1 = new JButton(new ImageIcon("image/toolBar/jb1.jpg"));
				jb2 = new JButton(new ImageIcon("image/toolBar/jb2.jpg"));
				jb3 = new JButton(new ImageIcon("image/toolBar/jb3.jpg"));
				jb4 = new JButton(new ImageIcon("image/toolBar/jb4.jpg"));
				jb5 = new JButton(new ImageIcon("image/toolBar/jb5.jpg"));
				jb6 = new JButton(new ImageIcon("image/toolBar/jb6.jpg"));
				jb7 = new JButton(new ImageIcon("image/toolBar/jb7.jpg"));
				jb8 = new JButton(new ImageIcon("image/toolBar/jb8.jpg"));
				jb9 = new JButton(new ImageIcon("image/toolBar/jb9.jpg"));
				
				jtb.add(jb1);
				jtb.add(jb2);
				jtb.add(jb3);
				jtb.add(jb4);
				jtb.add(jb5);
				jtb.add(jb6);
				jtb.add(jb7);
				jtb.add(jb8);
				jtb.add(jb9);
	}
	
	public void initAllPanels() {
		jp1 = new JPanel(new BorderLayout());
		
		Image p1_bg = null;
		try {
			p1_bg = ImageIO.read(new File("image/p1_bg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Cursor myCursor = new Cursor(Cursor.HAND_CURSOR);
		
		this.p1_imgPanel = new ImagePanel(p1_bg);
		this.p1_imgPanel.setLayout(new GridLayout(8,1)); 
		
		p1_lab1 = new JLabel(new ImageIcon("image/label_1.jpg"));
		p1_lab1.setFont(MyTools.f3);
		p1_imgPanel.add(p1_lab1);
		p1_lab2 = new JLabel("Personnel Management",new ImageIcon("image/label_2.jpg"),0);
		p1_lab2.setFont(MyTools.f3);
		p1_lab2.setCursor(myCursor);
		p1_lab2.setEnabled(false);
		p1_lab2.addMouseListener(this);
		p1_imgPanel.add(p1_lab2);
		p1_lab3 = new JLabel("Login Management",new ImageIcon("image/label_3.jpg"),0);
		p1_lab3.setFont(MyTools.f3);
		p1_lab3.setCursor(myCursor);
		p1_lab3.setEnabled(false);
		p1_lab3.addMouseListener(this);
		p1_imgPanel.add(p1_lab3);
		p1_lab4 = new JLabel("Menu Management",new ImageIcon("image/label_4.jpg"),0);
		p1_lab4.setFont(MyTools.f3);
		p1_lab4.setCursor(myCursor);
		p1_lab4.setEnabled(false);
		p1_lab4.addMouseListener(this);
		p1_imgPanel.add(p1_lab4);
		p1_lab5 = new JLabel("Statistic Report",new ImageIcon("image/label_5.jpg"),0);
		p1_lab5.setFont(MyTools.f3);
		p1_lab5.setCursor(myCursor);
		p1_lab5.setEnabled(false);
		p1_lab5.addMouseListener(this);
		p1_imgPanel.add(p1_lab5);
		p1_lab6 = new JLabel("Cost and Warehouse",new ImageIcon("image/label_6.jpg"),0);
		p1_lab6.setFont(MyTools.f3);
		p1_lab6.setCursor(myCursor);
		p1_lab6.setEnabled(false);
		p1_lab6.addMouseListener(this);
		p1_imgPanel.add(p1_lab6);
		p1_lab7 = new JLabel("System Management",new ImageIcon("image/label_7.jpg"),0);
		p1_lab7.setFont(MyTools.f3);
		p1_lab7.setCursor(myCursor);
		p1_lab7.setEnabled(false);
		p1_lab7.addMouseListener(this);
		p1_imgPanel.add(p1_lab7);
		p1_lab8 = new JLabel("Help",new ImageIcon("image/label_8.jpg"),0);
		p1_lab8.setFont(MyTools.f3);
		p1_lab8.setCursor(myCursor);
		p1_lab8.setEnabled(false);
		p1_lab8.addMouseListener(this);
		p1_imgPanel.add(p1_lab8);
		
		jp1.add(this.p1_imgPanel);
		
		//jp2,jp3,jp4
		jp4 = new JPanel(new BorderLayout());
		jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
		//left panel
		jsp1.setDividerLocation(220);
		//set border 0
		jsp1.setDividerSize(0);
		
		cardP2 = new CardLayout();
		jp2 = new JPanel(this.cardP2);  
		jp2_lab1 = new JLabel(new ImageIcon("image/jp2_left.jpg"));
		jp2_lab1.addMouseListener(this);
		jp2_lab2 = new JLabel(new ImageIcon("image/jp2_right.jpg"));
		jp2_lab2.addMouseListener(this);
		jp2.add(jp2_lab1,"0");
		jp2.add(jp2_lab2,"1");
		
		this.cardP3 = new CardLayout();
		jp3 = new JPanel(this.cardP3);
		Image index_image = null;
		try {
			index_image = ImageIO.read(new File("image/index_image.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ImagePanel ip = new ImagePanel(index_image);
		jp3.add(ip,"0");
		//EmpInfo(JPanel
		EmpInfo eInfo = new EmpInfo();
		jp3.add(eInfo,"1");
		JLabel loginMgt = new JLabel(new ImageIcon("image/loginTest.jpg"));
		jp3.add(loginMgt,"2");
		jp4.add(jp2,"West");
		jp4.add(jp3,"Center");
	}
	
	public Windows1() {
		
		try {
			titleIcon = ImageIO.read(new File("image/title.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.initMenu();
		this.initToolBar();
		this.initAllPanels();
		
		
		
		//split the window, save jp1 and jp4
		
		//jp5 show time
		jp5 = new JPanel(new BorderLayout());
		t = new Timer(1000,this); //trigger actionEvent every 1 second
		t.start();
		
		showTime = new JLabel(Calendar.getInstance().getTime().toString());
		showTime.setFont(MyTools.f2);
		try {
			timeBg = ImageIO.read(new File("image/time_bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		ImagePanel ip1 = new ImagePanel(timeBg);
		ip1.setLayout(new BorderLayout());
		ip1.add(showTime,"East");
		jp5.add(ip1);
		
		
		Container ct = this.getContentPane();
		
		ct.add(jtb,"North");
		ct.add(jp5,"South");
		ct.add(jsp1,"Center");
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setIconImage(titleIcon);
		this.setTitle("Restaurant Management System (He Han)");
		this.setSize(w,h-35);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.showTime.setText("Time: " + Calendar.getInstance().getTime().toString() + "   ");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.p1_lab2) {
			this.cardP3.show(jp3, "1");
		} else if(e.getSource()==this.p1_lab3) {
			this.cardP3.show(jp3, "2");
		} else if(e.getSource()==this.p1_lab5) {
			this.cardP3.show(jp3, "4");
		} else if(e.getSource()==this.jp2_lab1) {
			//show right arrow
			this.cardP2.show(jp2, "1");
			this.jsp1.setDividerLocation(0);
		} else if(e.getSource()==this.jp2_lab2) {
			//show left arrow
			this.cardP2.show(jp2, "0");
			this.jsp1.setDividerLocation(220);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.p1_lab2) {
			this.p1_lab2.setEnabled(true);
		} else if(e.getSource()==this.p1_lab3) {
			this.p1_lab3.setEnabled(true);
		} else if(e.getSource()==this.p1_lab4) {
			this.p1_lab4.setEnabled(true);
		} else if(e.getSource()==this.p1_lab5) {
			this.p1_lab5.setEnabled(true);
		} else if(e.getSource()==this.p1_lab6) {
			this.p1_lab6.setEnabled(true);
		} else if(e.getSource()==this.p1_lab7) {
			this.p1_lab7.setEnabled(true);
		} else if(e.getSource()==this.p1_lab8) {
			this.p1_lab8.setEnabled(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.p1_lab2) {
			this.p1_lab2.setEnabled(false);
		} else if(e.getSource()==this.p1_lab3) {
			this.p1_lab3.setEnabled(false);
		} else if(e.getSource()==this.p1_lab4) {
			this.p1_lab4.setEnabled(false);
		} else if(e.getSource()==this.p1_lab5) {
			this.p1_lab5.setEnabled(false);
		} else if(e.getSource()==this.p1_lab6) {
			this.p1_lab6.setEnabled(false);
		} else if(e.getSource()==this.p1_lab7) {
			this.p1_lab7.setEnabled(false);
		} else if(e.getSource()==this.p1_lab8) {
			this.p1_lab8.setEnabled(false);
		}
	}
}
