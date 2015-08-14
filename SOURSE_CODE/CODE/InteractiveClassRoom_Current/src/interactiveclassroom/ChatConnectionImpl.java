/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.net.URL;
import java.rmi.Remote;
/**
 *
 * @author Jesus
 */
public class ChatConnectionImpl extends UnicastRemoteObject implements ChatConnectionIntf {

	// Name of user that owns this connection
	private String name;

	// Map from use names to their connections
	private Hashtable connections;

	// The client the user is attached to
	private ChatClientIntf client;

	// The server running the show
	private ChatServerImpl server;

	public ChatConnectionImpl(String nm, ChatClientIntf c, ChatServerImpl s, Hashtable conn)
			throws RemoteException {
		name = nm;
		client = c;
		connections = conn;
		server = s;
		System.out.println(name + " logged on");
		};


        public void say(String msg) throws RemoteException {
		Hashtable sendTo;
		System.out.println(name + ": " + msg);
		// In case hashtable changes while sending out messages,
		// clone it
		synchronized (connections) {
		  sendTo = (Hashtable)connections.clone();
		  }
		for (Enumeration e = sendTo.keys(); e.hasMoreElements(); )  {
		  String who = (String)e.nextElement();
		  ChatClientIntf c = (ChatClientIntf)sendTo.get(who);
		  try { c.speak(name,msg); }
		  catch (RemoteException err) {
			System.out.println("Dropping " + who + " due to remote error");
			synchronized (connections) {
                          connections.remove(who);
			  }
			}
		  }
		}

        public void say(String who, String msg) throws RemoteException {
		ChatClientIntf c;
		synchronized (connections) {
			c = (ChatClientIntf) connections.get(who);
			};
		  msg = "[ " + msg + " ]";
		  try { c.speak(name,msg); }
		  catch (RemoteException err) {
                        System.out.println("Dropping " + who + " due to remote error");
			synchronized (connections) {
                          connections.remove(who);
			  }
                        }
		  client.speak(name, msg);
		}
		public void updateList()throws  RemoteException
                {
                    Hashtable sendTo;

		// In case hashtable changes while sending out messages,
		// clone it
		synchronized (connections) {
		  sendTo = (Hashtable)connections.clone();
		  }
		for (Enumeration e = sendTo.keys(); e.hasMoreElements(); )  {
		  String who = (String)e.nextElement();
		  ChatClientIntf c = (ChatClientIntf)sendTo.get(who);
		  try { c.addName(who());}
		  catch (RemoteException err) {
			System.out.println("Dropping " + who + " due to remote error");
			synchronized (connections) {
                          connections.remove(who);
			  }
			}
		  }
                }
        public String[] who() throws RemoteException {
		int sz;
		String[] w;
		synchronized (connections) {
 		  sz = connections.size();
		  w = new String[sz];
		  int i = 0;
		  for(Enumeration e = connections.keys(); e.hasMoreElements(); i++ )
			w[i] = (String)e.nextElement();
		  }
		return w;
		}

	public void logoff() throws RemoteException {
		synchronized (connections) {
		  connections.remove(name);
		  }
		client.speak("Server","good bye");
		server.notifyWhoChanged();
                updateList();
		System.out.println(name + " logged off");
		}


}
