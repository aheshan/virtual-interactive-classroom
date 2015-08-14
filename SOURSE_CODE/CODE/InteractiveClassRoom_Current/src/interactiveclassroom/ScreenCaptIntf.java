/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

/**
 *
 * @author Ahesan_for_S
 */
import java.rmi.*;


public interface ScreenCaptIntf  extends Remote
{
    public byte[] captureScreen() throws RemoteException;  
}
