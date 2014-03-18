
package com.hehan.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Index extends JWindow implements Runnable{

	JProgressBar jpb;
	JLabel jl1;
	int width,height;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index index = new Index();
		Thread t=new Thread(index);
		t.start();
	}
	
	public Index() {
		
		//create label and add image
		jl1=new JLabel(new ImageIcon("image/index.gif"));
				
		//create process bar
		jpb=new JProgressBar();
		//set process bar
		jpb.setStringPainted(true);
		jpb.setIndeterminate(false);
		jpb.setBorderPainted(false);
		jpb.setBackground(Color.green);
				
		this.add(jl1,BorderLayout.NORTH);
		this.add(jpb,BorderLayout.SOUTH);
		this.setSize(400,240);
		//set location of JWindow
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
	}
	
	public void run() {

		//progress bar
		int []progressValue={0,5,8,17,26,35,43,56,65,75,86,94,98,99,100};
		for(int i=0;i<progressValue.length;i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jpb.setValue(progressValue[i]);
		}
		
		//go to login
		new UserLogin();
		//close progress bar
		this.dispose();
	}
}

//
