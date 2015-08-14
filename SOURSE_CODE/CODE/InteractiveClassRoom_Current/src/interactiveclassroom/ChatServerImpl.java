/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.util.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Jesus
 */
public class ChatServerImpl extends UnicastRemoteObject implements ChatServerIntf{

Hashtable connections = new Hashtable();
String name;

	public ChatServerImpl() throws RemoteException {


		}

        public void notifyWhoChanged() {
		// OK. We had to fix a little problem here.
		// We need to tell all connections that a new user has logged on
		// However, the user logging on might not be fully established,
		// and be unable to accept the message that whoChanged until
		// such time as the log-on is complete.
		// We can fix this either Server side or Client Side.
		// The Server side fix is to run this in a seperate thread,
		// so that if it blocks, we won't delay the return from logon
		// (which could create deadlock)
		(new Thread() {
		  public void run() {
                    Hashtable sendTo;
                    synchronized (connections) {
                      sendTo = (Hashtable)connections.clone();
                    }
                for (Enumeration e = sendTo.keys(); e.hasMoreElements(); )  {
                  String who = (String)e.nextElement();
                  ChatClientIntf c = (ChatClientIntf)sendTo.get(who);
                  try { c.whoChanged(); }
		  catch (RemoteException err) {
                        System.out.println("Dropping " + who + " due to remote error");
                        connections.remove(who);
                        }
                     }
                   }
	        }).start();
		}


	public ChatConnectionIntf logon(String name, ChatClientIntf c) throws java.rmi.RemoteException {
		ChatConnectionIntf conn;
		synchronized (connections) {
		  if (name.equals("Server") || connections.get(name) != null) {
			c.speak("Server","Sorry, but that name is already in use");
			return null;
			}
		  conn = new ChatConnectionImpl(name, c, this, connections);
		  connections.put(name,c);
		  }
		c.speak("Server","Welcome");
		notifyWhoChanged();

                conn.updateList();
		return conn;
		}


}
