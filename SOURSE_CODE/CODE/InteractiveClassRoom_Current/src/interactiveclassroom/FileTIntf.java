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
public interface FileTIntf extends Remote {

    public boolean transferFile(String fileName,byte[] filedata) throws RemoteException;
    public String openFileChoser() throws RemoteException;
    
}
