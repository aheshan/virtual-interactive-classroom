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
public interface ChatConnectionIntf extends Remote{
	/**
	  * Invoked by client to say something to everyone in chat room
	  * @param msg Message to be said
	  */
        public void say(String msg) throws RemoteException;
	/**
	  * Invoked by client to say something to one person in chat room
	  * @param who Name of person to say it to
	  * @param msg Message to be said
	  */
        public void say(String who, String msg) throws RemoteException;
	/**
	  * Returns list of everyone in room
	  */
        public String [] who() throws RemoteException;
	/**
	  * Invoked by client to terminate connection
	  */
	public void logoff() throws RemoteException;

        public void updateList()throws  RemoteException;
}
