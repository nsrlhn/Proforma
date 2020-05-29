package pencereler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import pencereelemanlari.Document;
import veri.Client;
import veri.Project;

public class NewProjectWindow extends javax.swing.JFrame {
    String[] clients;
    public NewProjectWindow() {
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_clientName = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_projectName = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_currency = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Project");
        setLocation(new java.awt.Point(400, 250));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setText("Choose Client :   ");
        jPanel1.add(jLabel4);

        cb_clientName.setEditable(true);
        new Document(cb_clientName);
        jPanel1.add(cb_clientName);
        cb_clientName.getAccessibleContext().setAccessibleName("");

        jLabel5.setText("    or   ");
        jPanel1.add(jLabel5);

        jButton2.setText("Create New Client");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("Project Name :   ");
        jPanel2.add(jLabel6);

        tf_projectName.setPreferredSize(new java.awt.Dimension(15, 26));
        jPanel2.add(tf_projectName);

        jButton3.setText("Create New Project");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Currency :");

        tf_currency.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_currency.setText("$");
        tf_currency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_currencyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(tf_currency, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_currency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<String> clist = Arrays.asList(clients);
        String pn = tf_projectName.getText();
        String cn = cb_clientName.getSelectedItem().toString();
        if("".matches(cn) || "".matches(pn)){
            JOptionPane.showMessageDialog(this, "Define Client and Project Name", "", JOptionPane.ERROR_MESSAGE);
        }
        else if(!clist.contains(cn)){
            JOptionPane.showMessageDialog(this, "Client is not exist","",JOptionPane.ERROR_MESSAGE);
        }
        else{
        Project p = new Project(String.valueOf(pn),String.valueOf(cn),tf_currency.getText());
        
        if (pn.length() > 10)cn = pn.substring(0, 10);
        if (cn.length() > 10)pn = cn.substring(0, 10);
        p.pdfpath = "PDF Files/"+pn;
        
        new ProjectWindow(p);
        File directory = new File(p.pdfpath);
        if (! directory.exists()) directory.mkdir();
        this.dispose();}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new AddClientWindow(new Client());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new StartWindow();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        final File folder = new File("Clients");
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
    }//GEN-LAST:event_formWindowActivated

    private void tf_currencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_currencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_currencyActionPerformed
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_clientName;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tf_currency;
    private javax.swing.JTextField tf_projectName;
    // End of variables declaration//GEN-END:variables
}
