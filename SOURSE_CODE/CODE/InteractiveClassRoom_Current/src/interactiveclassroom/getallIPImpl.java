/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Jesus
 */
public class getallIPImpl extends UnicastRemoteObject implements getallIPIntf {

    public getallIPImpl() throws RemoteException
    {
        super();
    }

    public void storeIP(String ip) throws RemoteException
    {
            //mainHome ref = new mainHome(ip);
            mainHome.ll.add(ip);
            mainHome.cip++;
    }

    public void removeIP(String ip) throws RemoteException
    {
            mainHome.ll.remove(ip);
            mainHome.cip--;
    }
}
