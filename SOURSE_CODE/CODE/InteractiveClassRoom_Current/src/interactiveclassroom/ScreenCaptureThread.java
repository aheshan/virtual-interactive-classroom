/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.rmi.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */

class Buffer
{

    ImageIcon ico;
    volatile int flag=0;

    synchronized void put(ImageIcon dicon) throws InterruptedException
    {
        if(flag==1)
            wait();

	flag=1;
	ico=dicon;
	System.out.println("Items is produced.. by Producer.. Image");
	notify();
    }

    synchronized ImageIcon get() throws InterruptedException
    {
	if(flag==0)
            wait();

	flag=0;
	System.out.println("Items is consume by..Consumer .... image");
	notify();
	return ico;
    }
}

class Producer extends Thread
{
    String name;
    Buffer b_ref;

    String ClientAddress = "";
    String Port = "3232";
    String remoteURL;
    mainHome main_ref=null;

    Image photo=null;
    byte byteImage[];
    ScreenCaptIntf scrintf;

    Thread th;
    ImageIcon images;

    Producer(String s,Buffer b,String d_ClientAddress)
    {
	super(s);
        ClientAddress = d_ClientAddress;
        name=s;
	b_ref=b;
	start();
    }

    public void run()
    {
	for(int i=0;;i++)
	{
            if(mainHome.CSCapt)
            {
                try
                {
                    System.out.println("CLient IP: "+ClientAddress);
                    remoteURL = "rmi://" + ClientAddress + ":" + Port + "/screen";
                    scrintf=(ScreenCaptIntf)Naming.lookup(remoteURL);
                    System.out.println("cath stst");

                    byteImage  =scrintf.captureScreen();

                    if(byteImage!=null)
                    {
                        System.out.println("Buffer byte image not null");
                        ByteArrayInputStream in=new ByteArrayInputStream(byteImage);

                        photo=ImageIO.read(in);
                    }

                    if(photo!=null )
                    {
                        images=new ImageIcon(photo);
                    }

                    b_ref.put(images);
                    //Thread.sleep(300);
                }
                catch(InterruptedException ie)
                {
                    System.out.println("Exc:" +ie);
                }
                catch(RemoteException re)
                {
                    System.out.println("Exc:" +re);
                    JOptionPane.showMessageDialog(main_ref,"RemoteAgent("+ClientAddress+") is not Ready or Disconnected !!!");
                    break;
                }
                catch(NotBoundException ne)
                {
                    System.out.println("Exc:" +ne);
                    break;
                }
                catch(Exception e)
                {
                    System.out.println("Exc:" +e);
                }
            }
            else
            {
                break;
            }
        }
    }
}

class Consumer extends Thread
{
    String name;
    Buffer b_ref;
    CaptureScreenFrame chang;
    ImageIcon imgprod;

    Consumer(String s, Buffer b,CaptureScreenFrame dchnk)
    {
        super(s);
        name=s;
	b_ref=b;
        chang=dchnk;
        start();
    }

    public void run()
    {
        int no;
        for(int i=0;;i++)
        {
            if(mainHome.CSCapt)
            {
                try
                {
                        imgprod=b_ref.get();
                        if(i==0)
                            chang.setVisible(true);
                        chang.jLabel1.setIcon(imgprod);
                        //Thread.sleep(0);
                }
                catch(InterruptedException ie)
                {
                        System.out.println("Exc:" +ie);
                }
            }
            else
            {
                break;
            }
        }
    }
}

public class ScreenCaptureThread {

    public static void main(String s[]) throws InterruptedException
    {
        Buffer b_ref=new Buffer();
	Producer p_ref=new Producer("Producer",b_ref,s[0]);

        CaptureScreenFrame chn=new CaptureScreenFrame(s[0]);
	Consumer c_ref=new Consumer("Consumer",b_ref,chn);


        p_ref.join();
        c_ref.join();
    }
}
