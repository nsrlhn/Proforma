package pencereelemanlari;

import javax.swing.JButton;

public class Buton extends JButton{
	
    public Buton(int x,int y,int w,int h,String n){
	this.setText(n);
	this.setSize(w,h);
	this.setLocation(x, y);
	}
}
