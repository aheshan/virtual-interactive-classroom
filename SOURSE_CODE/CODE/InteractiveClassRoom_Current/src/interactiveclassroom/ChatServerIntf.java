/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

/**
 *
 * @author Jesus
 */
public interface ChatServerIntf extends java.rmi.Remote{

    public ChatConnectionIntf logon(String name, ChatClientIntf c) throws java.rmi.RemoteException;
}
