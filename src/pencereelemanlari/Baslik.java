package pencereelemanlari;

import javax.swing.JLabel;

public class Baslik extends JLabel{

    public Baslik(int x,int y,int w,int h,String n){
	this.setText(n);
	this.setSize(w,h);
	this.setLocation(x,y);
	this.setHorizontalAlignment(0);
    }
}
