package veri;

import java.io.Serializable;
import java.util.ArrayList;

public class Other implements Serializable{
    public String name;
    public int quantity;
    public float tax,unitprice,subtotal;
    
    public Other(){
    } 
    
    public Other copy(){
        Other newother = new Other();
        newother.name = String.valueOf(this.name);
        newother.quantity = this.quantity;
        newother.tax = this.tax;
        newother.unitprice = this.unitprice;
        newother.subtotal = this.subtotal;
        return newother;
    }    
    public static ArrayList<Other> copyArrayList(ArrayList<Other> list){
        ArrayList<Other> newo = new ArrayList<Other>();
        for(Other o : list) newo.add(o.copy());
        return newo;
    }    
    public void calculateSubtotal(){
        this.subtotal = this.quantity*this.unitprice;
    }
}
