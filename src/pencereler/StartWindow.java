package pencereler;

import static background.main.storage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import veri.Client;
import veri.Project;
import veri.Storage;

/**
 *
 * @author ensar
 */
public class StartWindow extends javax.swing.JFrame {
    
    public StartWindow() {
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nt_newProject = new javax.swing.JButton();
        bt_newClient = new javax.swing.JButton();
        bt_openProject = new javax.swing.JButton();
        bt_openClient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 300));

        nt_newProject.setText("New Project");
        nt_newProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nt_newProjectActionPerformed(evt);
            }
        });

        bt_newClient.setText("New Client");
        bt_newClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newClientActionPerformed(evt);
            }
        });

        bt_openProject.setText("Projects");
        bt_openProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_openProjectActionPerformed(evt);
            }
        });

        bt_openClient.setText("Clients");
        bt_openClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_openClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nt_newProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_openProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_openClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_newClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_newClient)
                    .addComponent(nt_newProject))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_openClient)
                    .addComponent(bt_openProject))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nt_newProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nt_newProjectActionPerformed
        new NewProjectWindow();
        this.dispose();
    }//GEN-LAST:event_nt_newProjectActionPerformed

    private void bt_newClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newClientActionPerformed
        Client c = new Client();
        new AddClientWindow(c);
    }//GEN-LAST:event_bt_newClientActionPerformed

    private void bt_openProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_openProjectActionPerformed
        JFileChooser jfc = new JFileChooser("Projects");
	int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();                  
            Project p = Project.open(selectedFile.getAbsolutePath());
            new ProjectWindow(p);
            this.dispose();
        }
    }//GEN-LAST:event_bt_openProjectActionPerformed

    private void bt_openClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_openClientActionPerformed
        JFileChooser jfc = new JFileChooser("Clients");
	int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            Client c = Client.open(selectedFile.getAbsolutePath());
            new EditClientWindow(c);
        }
    }//GEN-LAST:event_bt_openClientActionPerformed

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        storage = new Storage();
        try{storage = Storage.read();}
        catch(FileNotFoundException e){System.out.println("File could not read");Storage.write(storage);}
        File directory = new File("PDF Files");
        if (! directory.exists()) directory.mkdir();
        
        if (args.length == 0){
            new File("Projects").mkdirs();
            new File("Clients").mkdirs();
            new StartWindow();
        }
        else {
            String path = args[0];
            String extension;
            int i = path.lastIndexOf('.');
            extension = path.substring(i+1);
            if("pjt".equals(extension)) {
                Project p = Project.open(path);
                new ProjectWindow(p);
            }
            else if("clt".equals(extension) ) {Client c = Client.open(path);new EditClientWindow(c);}          
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_newClient;
    private javax.swing.JButton bt_openClient;
    private javax.swing.JButton bt_openProject;
    private javax.swing.JButton nt_newProject;
    // End of variables declaration//GEN-END:variables
}
