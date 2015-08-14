/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

/**
 *
 * @author Ahesan_for_S
 */

import java.rmi.Remote;
//import java.rmi.RemoteException;
public interface ShutDownIntf extends Remote
{
    //ShutDown Method
    public void shutDown()throws Exception;

    //Restart Method

    public void restart()throws Exception;

    //Lof off Method

    public void logOff()throws Exception;




}
