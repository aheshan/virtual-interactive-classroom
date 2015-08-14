/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Jesus
 */
public class ChatClientImpl extends UnicastRemoteObject implements ChatClientIntf{

        ChatClientGui cgui_ref;
	public ChatClientImpl (ChatClientGui dcgui) throws RemoteException
        {
            cgui_ref=dcgui;
        }

        public void whoChanged() throws java.rmi.RemoteException {}

        public void speak(String who, String msg) throws java.rmi.RemoteException
		{
                      cgui_ref.jTextArea1.setText(cgui_ref.jTextArea1.getText()+"\n"+who + ": " + msg);
                      System.out.println(who + ": " + msg);
		}
        public void addName(String names[])throws java.rmi.RemoteException
        {
            cgui_ref.lstUsers.removeAll();
            for(int i=0;i<names.length;i++)
                cgui_ref.lstUsers.add(names[i]);
        }

}
