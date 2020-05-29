package pencereelemanlari;
import java.awt.Font;
import javax.swing.JLabel;

public class Yazi extends JLabel{

    public Yazi(int x,int y,int w,int h,String n){
	this.setText(n);
	this.setSize(w,h);
	this.setLocation(x,y);
	this.setHorizontalAlignment(0);
	Font f = this.getFont();
	this.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
    }
}
