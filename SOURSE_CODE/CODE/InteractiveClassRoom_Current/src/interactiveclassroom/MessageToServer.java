/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MessageToServer.java
 *
 * Created on Jun 22, 2010, 12:37:29 AM
 */

package interactiveclassroom;

import java.rmi.registry.*;
import java.rmi.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Jesus
 */
public class MessageToServer extends javax.swing.JFrame {

    /** Creates new form MessageToServer */
    public MessageToServer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jbSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Message To Server");
        setResizable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jbSend.setText("Send");
        jbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jbSend)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSend)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSendActionPerformed
        // TODO add your handling code here:
        //Registry registry;
        String Port = "3434";
        String remoteURL;
        String ServerAdd = RemoteAgent_Client.serverAddress;

        try
        {
            remoteURL = "rmi://" + ServerAdd + ":" + Port + "/messageClient";
            MessageIntf msgInt;
            System.out.println("Remote URL: "+remoteURL);
            msgInt=(MessageIntf)Naming.lookup(remoteURL);

            msgInt.setMessage(jTextArea1.getText(),RemoteAgent_Client.thisAddress);

        }
        catch(RemoteException re)
        {
            JOptionPane.showMessageDialog(this,"Server("+ServerAdd+") is not Ready !!!");
        }
        catch(NotBoundException ne)
        {
            JOptionPane.showMessageDialog(this,"Server("+ServerAdd+") is not Ready !!!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Server("+ServerAdd+") is not Ready !!!");
        }
    }//GEN-LAST:event_jbSendActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageToServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbSend;
    // End of variables declaration//GEN-END:variables

}
