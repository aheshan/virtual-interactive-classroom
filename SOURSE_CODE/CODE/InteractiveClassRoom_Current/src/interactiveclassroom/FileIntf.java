/*
 * FileIntf.java
 *
 * Created on March 11, 2010, 4:12 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileIntf extends Remote {
    public byte[] downloadFile(String fileName) throws RemoteException;
    public String openFileChoser() throws RemoteException;
}
