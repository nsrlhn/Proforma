package pencereler;
import veri.*;
import pencereelemanlari.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditRCO extends JFrame implements ActionListener{
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
    JPanel anapanel;
    RCO rco;
    JTextField tf_date;
    GirdiKutusu describtion;
    
    public EditRCO(RCO rco){
        this.rco = rco;
    	setTitle("Edit " + rco.name);
	setLocation(220, 150);
	setSize(1000,500);
	setResizable(false);
        
	anapanel = new Panel(0,0,getWidth(),getHeight());
	setContentPane(anapanel);
        
        date();
        describtion();
        material();
        labour(0);
        labour(1);
        
        Buton save = new Buton(750,350,100,30,"Save");
        save.addActionListener(this);
        anapanel.add(save);
        getRootPane().setDefaultButton(save);
        
        setVisible(true);
    }
    
        private void describtion(){	
        anapanel.add(new Baslik(40,20,100,tf_height,"Describtion  :"));
        describtion = new GirdiKutusu(x,20,740-x,tf_height);
        describtion.setText(this.rco.describtion);
        anapanel.add(describtion);
    }
    private void date(){
        this.tf_date = new GirdiKutusu(600,350,100,30);
        this.tf_date.setHorizontalAlignment(0);
        this.tf_date.setText(this.rco.date);
        anapanel.add(this.tf_date);
    }    
    private void material(){
        anapanel.add(new Baslik(40,yazi1_y+30,100,tf_height,"Material  :"));
        int x_local = this.x;
        Material m = this.rco.getMaterial();
        String[] s = {m.name,Integer.toString(m.quantity),Float.toString(m.tax),Float.toString(m.unitprice)};
        for(int i=0 ; i<tf1_widths.length;i++) {
            anapanel.add(new Baslik(x_local,yazi1_y,tf1_widths[i],tf_height,yazi1[i]));
            JTextField a = new GirdiKutusu(x_local,yazi1_y+30,tf1_widths[i],tf_height);
            a.setText(s[i]);
            anapanel.add(a);
            tf1.add(a);
            x_local+=tf1_widths[i]+column_space;
        }
    }
    
    private void labour(int i){
        int x_local = this.x;
        int y = 0;
        if(i==0)y=yazi2_y;
        if(i==1)y=yazi3_y;
        anapanel.add(new Baslik(40,y+30,100,tf_height,"Labour  :"));
        Labour l = this.rco.l.get(i);
        String[] s = {l.name,Integer.toString(l.man),Integer.toString(l.day),Float.toString(l.unitprice)};
        for(i=0 ; i<tf2_widths.length;i++) {
            anapanel.add(new Baslik(x_local,y,tf2_widths[i],tf_height,yazi2[i]));
            JTextField a = new GirdiKutusu(x_local,y+30,tf2_widths[i],tf_height);
            a.setText(s[i]);
            anapanel.add(a);
            tf2.add(a);
            anapanel.add(a);
            x_local+=tf2_widths[i]+column_space;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RCO rco  = this.rco;
        rco.date = this.tf_date.getText();
        rco.describtion = describtion.getText();
        
        Material material = new Material();
        material.name = tf1.get(0).getText();
        try{material.quantity = Integer.parseInt(tf1.get(1).getText());} catch(Exception ex){};
        try{material.tax = Float.parseFloat(tf1.get(2).getText());} catch(Exception ex){};
        try{material.unitprice = Float.parseFloat(tf1.get(3).getText());} catch(Exception ex){};
        try{material.calculateSubtotal();}catch(Exception ex){};
        
        
        rco.l.get(0).name = tf2.get(0).getText();
        try{rco.l.get(0).man = Integer.parseInt(tf2.get(1).getText());} catch(Exception ex){};
        try{rco.l.get(0).day = Integer.parseInt(tf2.get(2).getText());} catch(Exception ex){};
        try{rco.l.get(0).unitprice = Float.parseFloat(tf2.get(3).getText());} catch(Exception ex){};
        try{rco.l.get(0).calculateSubtotal();}catch(Exception ex){};  
        
        rco.l.get(1).name = tf2.get(4).getText();
        try{rco.l.get(1).man = Integer.parseInt(tf2.get(5).getText());} catch(Exception ex){};
        try{rco.l.get(1).day = Integer.parseInt(tf2.get(6).getText());} catch(Exception ex){};
        try{rco.l.get(1).unitprice = Float.parseFloat(tf2.get(7).getText());} catch(Exception ex){};
        try{rco.l.get(1).calculateSubtotal();}catch(Exception ex){};
       
        rco.changeMaterial(material);
        this.dispose();
        Anapencere.anapencere.refreshlist();
    }
}
