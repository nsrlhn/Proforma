package veri;

import java.io.Serializable;
import java.util.ArrayList;

public class Labour implements Serializable{
    public String name;
    public int man,day;
    public float unitprice,subtotal;
    
    public Labour(){
    }
    
    public Labour copy(){
        Labour newlabour = new Labour();
        newlabour.name = String.valueOf(this.name);
        newlabour.man = this.man;
        newlabour.day = this.day;
        newlabour.unitprice = this.unitprice;
        newlabour.subtotal = this.subtotal;
        return newlabour;
    }
    
    public static ArrayList<Labour> copyArrayList(ArrayList<Labour> list){
        ArrayList<Labour> newl = new ArrayList<Labour>();
        for(Labour l : list) newl.add(l.copy());
        return newl;
    }
    
    public void calculateSubtotal(){
        this.subtotal = this.man*this.day*this.unitprice;
    }
}
