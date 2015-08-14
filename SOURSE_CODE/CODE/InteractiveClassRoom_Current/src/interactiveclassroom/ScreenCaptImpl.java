/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;


import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
/**
 *
 * @author Ahesan_for_S
 */
public class ScreenCaptImpl extends UnicastRemoteObject implements ScreenCaptIntf {

    BufferedImage img = null;
    Robot r = null;
    Toolkit ct = null;
   
    byte buffer[]=null;
    

    public ScreenCaptImpl()throws RemoteException
    {
        super();
    }
    public byte [] captureScreen() throws RemoteException
    {
        try
	{
      	r = new Robot();
        	ct = Toolkit.getDefaultToolkit();
    	}
	catch (AWTException ex)
	{
    		System.out.println(ex);
	}

        img = r.createScreenCapture(new Rectangle(0,0,(int)ct.getScreenSize().getWidth(),(int)ct.getScreenSize().getHeight()));
        try
        {
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            ImageIO.write(img, "png", out);
             buffer=out.toByteArray();
            if(buffer!=null)
            {
                System.out.println("Buffer Not Null");
                return buffer;
            }
        }
        catch(Exception e)
        {
            System.out.print("exc"+e);
        }
        return null;
    }
}
