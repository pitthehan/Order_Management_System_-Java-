package com.hehan.view;

import com.hehan.tools.*;
import com.hehan.model.*;
import javax.swing.*;

import java.awt.*; //button
import java.awt.event.*;

import javax.imageio.*;

import java.io.*;

public class UserLogin extends JDialog implements ActionListener {
	
	JLabel jl1,jl2;
	JTextField jName;
	JPasswordField jPasswd;
	JButton jCon,jCancel;
	
	public static void main(String []args) {
		UserLogin ul = new UserLogin();
	}
	
	public UserLogin() {
		Container ct = this.getContentPane();
		this.setLayout(null);
		
		jl1 = new JLabel("User Name:");
		jl1.setFont(MyTools.f1);
		jl1.setBounds(80,200,150,30);
		ct.add(jl1);
		
		jName = new JTextField(20);
		jName.setBounds(180,190,120,30);
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jName);
		
		jl2 = new JLabel("Password");
		jl2.setFont(MyTools.f1);
		jl2.setBounds(80,240,150,30);
		ct.add(jl2);
		
		jPasswd = new JPasswordField(20);
		jPasswd.setBounds(180,240,120,30);
		jPasswd.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jPasswd);
		
		jCon = new JButton("Confirm");
		jCon.addActionListener(this);
		jCon.setFont(MyTools.f1);
		jCon.setBounds(110,300,90,30);
		ct.add(jCon);
		
		jCancel = new JButton("Cancel");
		jCancel.addActionListener(this);
		jCancel.setFont(MyTools.f1);
		jCancel.setBounds(220,300,90,30);
		ct.add(jCancel);
		
		BackImage bi = new BackImage();
		bi.setBounds(0,0,360,360);
		ct.add(bi);
		
		this.setUndecorated(true);
		this.setSize(360,360);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
		
	}
	
	//internal class
	class BackImage extends JPanel {
		
		Image im;
		
		public BackImage() {
			try {
				im = ImageIO.read(new File("image/login.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(im,0,0,360,360,this);
		}
	}
	
	//response to login request
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jCon) { //if not in the same class, we need to create use command
			//get uid and passwd
			String u = this.jName.getText().trim();
			String p = new String(this.jPasswd.getPassword());
			//System.out.println("ok"+u+p);
			UserModel um = new UserModel();
			String res = um.checkUser(u, p);
			System.out.println(u+p+res);
			if(res.equals("manager")||res.equals("supervisor")||res.equals("administrator")) {
				new Windows1();
				this.dispose();
			} 
		 } else if(e.getSource()==jCancel) {
				this.dispose();
		 }
	}
}
