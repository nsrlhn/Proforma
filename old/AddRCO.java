package pencereler;
import veri.*;
import pencereelemanlari.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddRCO extends JFrame implements ActionListener{
    int[] tf1_widths = {300,50,50,100};
    int[] tf2_widths = {300,50,50,100};
    int tf_height = 30;
    int column_space = 20;
    int x = 180;
    int yazi1_y = 70;
    int yazi2_y = yazi1_y+80;
    int yazi3_y = yazi2_y+80;  
    String[] yazi1 = {"Name","Quantity","Tax","$/Unit"};
    String[] yazi2 = {"Name","Man","Day","$/Unit"};
    ArrayList<JTextField> tf1 = new ArrayList<>();
    ArrayList<JTextField> tf2 = new ArrayList<>();
    JTextField tf_date;
    JPanel anapanel;
    GirdiKutusu describtion;
    
 
    AddRCO(){
    	setTitle("Add New RCO");
	setLocation(220, 150);
	setSize(1000,500);
	setResizable(false);
        
	anapanel = new Panel(0,0,getWidth(),getHeight());
	setContentPane(anapanel);

        
        date();
        describtion();
        material();
        labour(yazi2_y);
        labour(yazi3_y);
        
        Buton save = new Buton(750,350,100,30,"Save");
        save.addActionListener(this);
        anapanel.add(save);
        getRootPane().setDefaultButton(save);

        setVisible(true);
    }
    
    private void describtion(){	
        anapanel.add(new Baslik(40,20,100,tf_height,"Describtion  :"));
        describtion = new GirdiKutusu(x,20,740-x,tf_height);
        anapanel.add(describtion);
    }
    
    private void date(){
        this.tf_date = new GirdiKutusu(600,350,100,30);
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.tf_date.setHorizontalAlignment(0);
        this.tf_date.setText(df.format(simdikiZaman));
        anapanel.add(this.tf_date);
    }
    private void material(){
        anapanel.add(new Baslik(40,yazi1_y+30,100,tf_height,"Material  :"));
        int x_local = this.x;
        for(int i=0 ; i<tf1_widths.length;i++) {
            anapanel.add(new Baslik(x_local,yazi1_y,tf1_widths[i],tf_height,yazi1[i]));
            JTextField a = new GirdiKutusu(x_local,yazi1_y+30,tf1_widths[i],tf_height);
            anapanel.add(a);
            tf1.add(a);
            x_local+=tf1_widths[i]+column_space;
        }
    }
    
    private void labour(int y){
        anapanel.add(new Baslik(40,y+30,100,tf_height,"Labour  :"));
        int x_local = this.x;
        for(int i=0 ; i<tf2_widths.length;i++) {
            anapanel.add(new Baslik(x_local,y,tf2_widths[i],tf_height,yazi2[i]));
            JTextField a = new GirdiKutusu(x_local,y+30,tf2_widths[i],tf_height);
            anapanel.add(a);
            tf2.add(a);
            anapanel.add(a);
            x_local+=tf2_widths[i]+column_space;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RCO rco  = new RCO();
        rco.date = this.tf_date.getText();
        rco.describtion = describtion.getText();
        
        Material material = new Material();
        material.name = tf1.get(0).getText();
        try{material.quantity = Integer.parseInt(tf1.get(1).getText());} catch(Exception ex){};
        try{material.tax = Float.parseFloat(tf1.get(2).getText());} catch(Exception ex){};
        try{material.unitprice = Float.parseFloat(tf1.get(3).getText());} catch(Exception ex){};
        try{material.calculateSubtotal();}catch(Exception ex){};
        
        Labour labour = new Labour();
        labour.name = tf2.get(0).getText();
        try{labour.man = Integer.parseInt(tf2.get(1).getText());} catch(Exception ex){};
        try{labour.day = Integer.parseInt(tf2.get(2).getText());} catch(Exception ex){};
        try{labour.unitprice = Float.parseFloat(tf2.get(3).getText());} catch(Exception ex){};
        try{labour.calculateSubtotal();}catch(Exception ex){};
        
        Labour labour2 = new Labour();
        labour2.name = tf2.get(4).getText();
        try{labour2.man = Integer.parseInt(tf2.get(5).getText());} catch(Exception ex){};
        try{labour2.day = Integer.parseInt(tf2.get(6).getText());} catch(Exception ex){};
        try{labour2.unitprice = Float.parseFloat(tf2.get(7).getText());} catch(Exception ex){};
        try{labour2.calculateSubtotal();}catch(Exception ex){};
        
        rco.addMaterial(material);
        rco.addLabour(labour);
        rco.addLabour(labour2);
        RCO.list.add(rco);
        this.dispose();
        Anapencere.anapencere.refreshlist();
    }
}