/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.rmi.*;
/**
 *
 * @author Jesus
 */
public interface ChatClientIntf extends Remote{

        public void speak(String who, String msg) throws RemoteException;


	/**
	 * Called by server when the set of people in the room changes.
	 * The client should invoke the who() method of the connect to get
	 * the new list.
	 */
	public void whoChanged() throws java.rmi.RemoteException;

        public void addName(String names[])throws RemoteException;
}
