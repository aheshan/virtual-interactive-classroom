/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

/**
 *
 * @author Ahesan_for_S
 */

import java.rmi.server.*;

public class ShutDownImpl extends UnicastRemoteObject implements ShutDownIntf
{
    Runtime r=Runtime.getRuntime();
    Process p=null;
    String s=System.getProperty("os.name");


    public ShutDownImpl()throws Exception
    {
        super();
    }
    //shutDown Method

    public void shutDown()throws Exception
    {
        if(s.equals("Windows XP"))
        {
            p = r.exec("shutdown -s -f -t 00");
        }
        else if(s.equals("Windows Vista"))
        {
            p = r.exec("shutdown -s -f -t 00");
        }
    }

    //Restart

    public void restart()throws Exception
    {
        if(s.equals("Windows XP"))
        {
            p = r.exec("shutdown -r -f -t 00");
        }
        else if(s.equals("Windows Vista"))
        {
            p = r.exec("shutdown -r -f -t 00");
        }
    }
    //Lof off Method

    public void logOff()throws Exception
    {
        if(s.equals("Windows XP"))
        {
            p = r.exec("shutdown -l");
        }
        else if(s.equals("Windows Vista"))
        {
            p = r.exec("shutdown -l");
        }
    }

}
