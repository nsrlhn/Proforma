package pencereelemanlari;

import javax.swing.JList;
import veri.*;

public class Liste extends JList{

    public Liste(int x, int y, int w, int h){
	this.setSize(w, h);
        this.setLocation(x, y);
    }
}
