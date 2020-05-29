package pencereler;

import background.main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import pencereelemanlari.Document;
import veri.Client;
import veri.Project;

public class StartCombined extends javax.swing.JFrame {
    String[] clients,projects;
    
    public StartCombined() {
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_clientName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        b_editClient = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cb_projectName = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        b_editProject = new javax.swing.JButton();
        b_creatProject = new javax.swing.JButton();
        b_createClient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proforma");
        setLocation(new java.awt.Point(400, 250));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Client Name :      ");
        jPanel1.add(jLabel4);

        cb_clientName.setEditable(true);
        new Document(cb_clientName);
        jPanel1.add(cb_clientName);
        cb_clientName.getAccessibleContext().setAccessibleName("");

        jLabel1.setText("     ");
        jPanel1.add(jLabel1);

        b_editClient.setText("Edit Client");
        b_editClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editClientActionPerformed(evt);
            }
        });
        jPanel1.add(b_editClient);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("Project Name :   ");
        jPanel2.add(jLabel6);

        cb_projectName.setEditable(true);
        new Document(cb_projectName);
        jPanel2.add(cb_projectName);

        jLabel3.setText("     ");
        jPanel2.add(jLabel3);

        b_editProject.setText("Edit Project");
        b_editProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editProjectActionPerformed(evt);
            }
        });
        jPanel2.add(b_editProject);

        b_creatProject.setText("Create New Project");
        b_creatProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_creatProjectActionPerformed(evt);
            }
        });

        b_createClient.setText("Create New Client");
        b_createClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_createClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addComponent(b_creatProject, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_createClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(b_createClient)
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 29, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(b_creatProject)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_creatProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_creatProjectActionPerformed
        List<String> clist = Arrays.asList(clients);
        List<String> plist = Arrays.asList(projects);
        String pn = cb_projectName.getSelectedItem().toString();
        String cn = cb_clientName.getSelectedItem().toString();
        if("".matches(cn) || "".matches(pn)){
            JOptionPane.showMessageDialog(this, "Define Client and Project Name", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(!clist.contains(cn)){
            this.dispose();
            Client client = new Client();
            client.name = cn;
            Client.save(client);
            Project p = new Project();
            p.name = pn;
            p.clientName = cn;
            new ProjectWindow(p);
            JOptionPane.showMessageDialog(this, "New Client is created : "+cn);
        }
        else if (plist.contains(pn)){
            JOptionPane.showMessageDialog(this, "This Project is already exist","",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Project p = new Project();
            p.name = pn;
            p.clientName = cn;
            new ProjectWindow(p);
            this.dispose();
        }
    }//GEN-LAST:event_b_creatProjectActionPerformed

    private void b_createClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_createClientActionPerformed
        new AddClientWindow(new Client());
    }//GEN-LAST:event_b_createClientActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        File folder = new File("Clients");
        List<String> result = new ArrayList<>();
        search(".*\\.clt", folder, result);
        clients = new String[result.size()];
        cb_clientName.removeAllItems();
        for(int i = 0 ; i < result.size() ; i++) {
            int start = result.get(i).lastIndexOf('\\')+1;
            int end = result.get(i).length()-4;
            clients[i] = result.get(i).substring(start,end);
            cb_clientName.addItem(clients[i]);
        }
        String lastedited = lastfile(".*\\.clt",folder);
        cb_clientName.setSelectedItem(lastedited.substring(lastedited.lastIndexOf('\\')+1,lastedited.length()-4));
        
        File folder2 = new File("Projects");
        List<String> result2 = new ArrayList<>();
        search(".*\\.pjt", folder2, result2);
        projects = new String[result2.size()];
        cb_projectName.removeAllItems();
        for(int i = 0 ; i < result2.size() ; i++) {
            int start = result2.get(i).lastIndexOf('\\')+1;
            int end = result2.get(i).length()-4;
            projects[i] = result2.get(i).substring(start,end);
            cb_projectName.addItem(projects[i]);
        }
        String lastedited2 = lastfile(".*\\.pjt",folder2);
        cb_projectName.setSelectedItem(lastedited2.substring(lastedited2.lastIndexOf('\\')+1,lastedited2.length()-4));
    }//GEN-LAST:event_formWindowActivated

    private void b_editClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editClientActionPerformed
        String cn = cb_clientName.getSelectedItem().toString();
        Client.open("Clients/"+cn+".clt");
    }//GEN-LAST:event_b_editClientActionPerformed

    private void b_editProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editProjectActionPerformed
        String pn = cb_projectName.getSelectedItem().toString();
        Project.open("Projects/"+pn+".pjt");
        this.dispose();
    }//GEN-LAST:event_b_editProjectActionPerformed
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
    public static String lastfile(final String pattern, final File folder){
        String last = ".clt";
        long l = Long.MIN_VALUE;
        for (final File f : folder.listFiles()) {
            if (l < f.lastModified()){
                last = f.getName();
                l = f.lastModified();
            }
        }
        return last;
    }
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        main.start();
        if (args.length == 0){
            new File("Projects").mkdirs();
            new File("Clients").mkdirs();
            new StartCombined();
        }
        else {
            String path = args[0];
            String extension;
            int i = path.lastIndexOf('.');
            extension = path.substring(i+1);
            if("pjt".equals(extension)) {
                Project.open(path);
            }
            else if("clt".equals(extension) ) Client.open(path);          
        }
    }   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_creatProject;
    private javax.swing.JButton b_createClient;
    private javax.swing.JButton b_editClient;
    private javax.swing.JButton b_editProject;
    private javax.swing.JComboBox<String> cb_clientName;
    private javax.swing.JComboBox<String> cb_projectName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
