/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FileTransfer.java
 *
 * Created on Mar 20, 2010, 10:14:53 AM
 */

package interactiveclassroom;

import java.io.*;
import java.rmi.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Jesus
 */
public class FileTransfer extends javax.swing.JFrame {

    /** Creates new form FileTransfer */

     String clientIP;
     String clientPORT;
     String clientURL;
     String fileName;
     FileTIntf fileTIntf;

    public FileTransfer()
    {
        initComponents();

        /*int i=0;
        while(i<mainHome.cip)
        {
            jcmbFT.insertItemAt(mainHome.ll.get(i),i);
            System.out.println("MC "+i+": "+mainHome.ll.get(i));
            i++;
        }*/
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbStart = new javax.swing.JButton();
        jbDisconnect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfPort = new javax.swing.JTextField();
        jbConnect = new javax.swing.JButton();
        jlStatus = new javax.swing.JLabel();
        jtfDestination = new javax.swing.JTextField();
        jtfSource = new javax.swing.JTextField();
        jbBrows = new javax.swing.JButton();
        jcmbFT = new javax.swing.JComboBox();
        jbBrows1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Transfer");
        setResizable(false);

        jLabel4.setText("Select File to Transfer");

        jLabel5.setText("Select Path Where to Transfer");

        jbStart.setText("Start");
        jbStart.setEnabled(false);
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });

        jbDisconnect.setText("Disconnect");
        jbDisconnect.setEnabled(false);
        jbDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDisconnectActionPerformed(evt);
            }
        });

        jLabel1.setText("Client IP");

        jLabel2.setText("Port No");

        jtfPort.setEditable(false);
        jtfPort.setText("3232");

        jbConnect.setText("Connect");
        jbConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConnectActionPerformed(evt);
            }
        });

        jlStatus.setText("Status: ");

        jtfDestination.setEnabled(false);

        jtfSource.setEnabled(false);

        jbBrows.setText("Brows...");
        jbBrows.setEnabled(false);
        jbBrows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBrowsActionPerformed(evt);
            }
        });

        jcmbFT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcmbFTFocusGained(evt);
            }
        });

        jbBrows1.setText("Brows...");
        jbBrows1.setEnabled(false);
        jbBrows1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBrows1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(jbDisconnect))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcmbFT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfPort, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jbConnect))))
                    .addComponent(jlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(jtfDestination, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(jtfSource, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBrows)
                    .addComponent(jbBrows1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConnect)
                    .addComponent(jcmbFT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBrows))
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBrows1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbDisconnect)
                    .addComponent(jbStart))
                .addGap(23, 23, 23)
                .addComponent(jlStatus)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        // TODO add your handling code here:
        boolean status_file=false; //check weather the file is transfered or not...

        String serverPath = jtfSource.getText();
        String clientPath = jtfDestination.getText();
        System.out.println("Server Path " + serverPath);
        System.out.println("Client Path " + clientPath);

        if(serverPath.length() == 0 || clientPath.length()==0)
        {
            jlStatus.setText("Status : File Not Selected or Transfer Path not Selected.");
            return;
        }

        try
        {
            int index = serverPath.lastIndexOf('\\');
            System.out.println("File Name - Index " + index);
            String fileName = serverPath.substring(index);
            clientPath = clientPath+"\\"+fileName;
            System.out.println("ClientPath: " + clientPath);

        
            File file = new File(serverPath);
            byte buffer[] = new byte[(int)file.length()];
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(serverPath));
            input.read(buffer,0,buffer.length);
            input.close();

            //jlStatus.setText("Status : File Transfering...");
            //Call the transferFile method at client side...
            status_file = fileTIntf.transferFile(clientPath, buffer);
            if(status_file)
                jlStatus.setText("Status : File Transfered...");
            else
                jlStatus.setText("Status : Transfer Path not found");
        }
        catch(StringIndexOutOfBoundsException se)
        {
            jlStatus.setText("Status : Error Opening File...");
        }
        catch(Exception e)
        {
            jlStatus.setText("Status : Error Opening File."+ e);
            JOptionPane.showMessageDialog(this,"Error Opening File");
        }
    }//GEN-LAST:event_jbStartActionPerformed

    private void jbDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDisconnectActionPerformed
        // TODO add your handling code here:

        jcmbFT.setEnabled(true);
        jtfPort.setEnabled(true);
        jbConnect.setEnabled(true);
        jtfPort.setText("");
        jtfSource.setText("");
        jtfDestination.setText("");
        jlStatus.setText("Status:  Disconnected...");

        jtfSource.setEnabled(false);
        jtfDestination.setEnabled(false);
        jbStart.setEnabled(false);
        jbDisconnect.setEnabled(false);
        jbBrows.setEnabled(false);
        jbBrows1.setEnabled(false);
    }//GEN-LAST:event_jbDisconnectActionPerformed

    private void jbConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConnectActionPerformed
        // TODO add your handling code here:
        jtfPort.setText("3232");
   
        clientIP = jcmbFT.getSelectedItem().toString();
        clientPORT = jtfPort.getText();

        clientURL = "rmi://" + clientIP + ":" + clientPORT + "/fileTransfer";

        try
        {

            fileTIntf = (FileTIntf)Naming.lookup(clientURL);
            jlStatus.setText("Status : Connected to Client...");

            jcmbFT.setEnabled(false);
            jtfPort.setEnabled(false);
            jbConnect.setEnabled(false);

            jtfSource.setEnabled(true);
            jtfDestination.setEnabled(true);
            jbStart.setEnabled(true);
            jbDisconnect.setEnabled(true);
            jbBrows.setEnabled(true);
            jbBrows1.setEnabled(true);
        }
        catch(Exception e)
        {
            System.out.println("Exception : " + e);
            jlStatus.setText("Status : Remote Agent Not Ready...");
        }
    }//GEN-LAST:event_jbConnectActionPerformed

    private void jbBrowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBrowsActionPerformed
        // TODO add your handling code here:

        String despath="";
        JFileChooser jf = new JFileChooser();

        try
        {
            jf.showOpenDialog(this);
            despath = jf.getSelectedFile().toString();
            System.out.println("Selected File: "+despath);

            if(despath==null)
                despath="";
            else
                jtfSource.setText(despath);
        }
        catch(Exception e)
        {
            System.out.println("DestinationPath Error::: "+e);
        }
    }//GEN-LAST:event_jbBrowsActionPerformed

    private void jbBrows1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBrows1ActionPerformed
        // TODO add your handling code here:

        try
        {
            String sfile;
            sfile = fileTIntf.openFileChoser();
            jtfDestination.setText(sfile);
            System.out.println("Selected File Client: "+sfile);
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);
        }
    }//GEN-LAST:event_jbBrows1ActionPerformed

    private void jcmbFTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcmbFTFocusGained
        // TODO add your handling code here:

        jcmbFT.removeAllItems();
        int i=0;
        while(i<mainHome.cip)
        {
            jcmbFT.insertItemAt(mainHome.ll.get(i),i);
            System.out.println("MC "+i+": "+mainHome.ll.get(i));
            i++;
        }
    }//GEN-LAST:event_jcmbFTFocusGained

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileTransfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBrows;
    private javax.swing.JButton jbBrows1;
    private javax.swing.JButton jbConnect;
    private javax.swing.JButton jbDisconnect;
    private javax.swing.JButton jbStart;
    private javax.swing.JComboBox jcmbFT;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JTextField jtfDestination;
    private javax.swing.JTextField jtfPort;
    private javax.swing.JTextField jtfSource;
    // End of variables declaration//GEN-END:variables

}