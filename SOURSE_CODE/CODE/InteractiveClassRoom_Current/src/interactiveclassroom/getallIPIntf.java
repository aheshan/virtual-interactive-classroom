/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;


import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Jesus
 */
public interface getallIPIntf extends Remote  {


    public void storeIP(String ip) throws RemoteException;
    public void removeIP(String ip) throws RemoteException;
}
