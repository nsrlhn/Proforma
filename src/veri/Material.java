package veri;

import java.io.Serializable;
import java.util.ArrayList;

public class Material implements Serializable{
    public String name,unit;
    public int quantity;
    public float tax,unitprice,subtotal;
            
    public Material(){
    }
    public Material copy(){
        Material newmaterial = new Material();
        newmaterial.name = String.valueOf(this.name);
        newmaterial.unit = String.valueOf(this.unit);
        newmaterial.quantity = this.quantity;
        newmaterial.tax = this.tax;
        newmaterial.unitprice = this.unitprice;
        newmaterial.subtotal = this.subtotal;
        return newmaterial;
    }
    public static ArrayList<Material> copyArrayList(ArrayList<Material> list){
        ArrayList<Material> newm = new ArrayList<Material>();
        for(Material m : list) newm.add(m.copy());
        return newm;
    }
    public void calculateSubtotal(){
        this.subtotal = this.quantity*this.unitprice;
    }
}
