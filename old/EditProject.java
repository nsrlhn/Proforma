package pencereler;
import background.main;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import veri.*;
import pencereelemanlari.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditProject extends JFrame implements ActionListener{
    int[] button_widths = {100,200,200,200,90,90,200,200};
    int button_height = 30;
    int[] button_x = {20,950,950,950,950,1060,950,950};
    int[] button_y = {20,100,150,200,300,300,400,500};
    String[] button_names = {"Add Client","Add","Edit","Revision","Approved","Rejected","Create PDF","Save"};
    List<JButton> button_list = new ArrayList<>();
    JPanel anapanel;
    JList liste;
    JComboBox clientBox;
    GirdiKutusu projectnameinput;
    JPanel listePaneli;
    Project project;
    
    public EditProject(Project project){
        this.project = project;
    	this.setTitle("Edit Project : "+project.name);
	this.setLocation(200, 100);
	this.setSize(1200,650);
	this.setResizable(true);
	
	this.anapanel = new Panel(0,0,this.getWidth(),this.getHeight());
	this.setContentPane(anapanel);
        
        clients();
        buttons();
        liste();
	this.anapanel.add(new Baslik(400,20,200,30,"Project Name :"));
        projectnameinput = new GirdiKutusu(550,20,370,30);
        projectnameinput.setText(project.name);
        this.anapanel.add(projectnameinput);
        this.setVisible(true);
    }
    public void clientsRefresh(){
        anapanel.remove(this.clientBox);
        clients();
    }
    private void clients() {
        final File folder = new File("Clients");
        List<String> result = new ArrayList<>();
        search(".*\\.clt", folder, result);
        String[] clients = new String[result.size()];
        for(int i = 0 ; i < result.size() ; i++) {
            int start = result.get(i).lastIndexOf('\\')+1;
            int end = result.get(i).length()-4;
            clients[i] = result.get(i).substring(start,end);
        }
        clientBox = new JComboBox(clients);
        clientBox.setLocation(150, 20);
        clientBox.setSize(200, 30);
        anapanel.add(clientBox);
    }
    public static void search(final String pattern, final File folder, List<String> result) {
        for (final File f : folder.listFiles()) {
            if (f.isDirectory()) {
                search(pattern, f, result);
            }
            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                }
            }
        }
    }
    private void buttons(){
        for( int i = 0 ; i < button_widths.length ; i++) {
            Buton a = new Buton(button_x[i],button_y[i],button_widths[i],button_height,button_names[i]);
            a.addActionListener(this);
            if (i != 2 & i != 4& i != 5){
            this.anapanel.add(a);
            button_list.add(a);}
        }
    }
    
    private void liste(){        
        this.listePaneli = new Panel(20,20+button_height+20,900,530);
        this.listePaneli.setLayout(new BorderLayout());
        this.anapanel.add(this.listePaneli);
        
        this.liste = new JList();
        this.liste.setFont(new Font("Arial",Font.BOLD,14));
        this.liste.setListData(project.getList());
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(this.liste);
        this.liste.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    main.rco = project.getRCO(index);
                    new Edit_RCO();
                }
            }
        });
	this.listePaneli.add(sp);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(button_list.get(0)==e.getSource())new AddClientWindow();
        if(button_list.get(1)==e.getSource())new Add_RCO(project);
        //if(button_list.get(2)==e.getSource())new Edit_RCO(project.getRCO(this.liste.getSelectedIndex()));
        if(button_list.get(2)==e.getSource()){
            main.rco = project.getMainRCO(this.liste.getSelectedIndex());
            new Revise_RCO();
        }
        if(button_list.get(3)==e.getSource())try {
            project.name = this.projectnameinput.getText();
            project.clientName = clientBox.getSelectedItem().toString();
            new Pdf_RCO(project.getRCO(this.liste.getSelectedIndex()));
        } catch (IOException ex) {
            Logger.getLogger(Anapencere.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Anapencere.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(button_list.get(4)==e.getSource()) {
            System.out.println("pencereler.EditProject.actionPerformed()");
            project.name = this.projectnameinput.getText();
            project.clientName = clientBox.getSelectedItem().toString();
            //project.date = 
            //project.amount = 
            Project.save(project);
            //System.out.println("pencereler.Anapencere.actionPerformed() : "+main.storage.projectlist);
            //main.projectWindow.refreshTable();
            this.dispose();
        }
    }
    public void refreshlist(){
        this.liste.setListData(project.getList());
    }
}