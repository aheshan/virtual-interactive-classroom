package interactiveclassroom;

import java.rmi.*;
import java.rmi.server.*;


public class MessageImpl extends UnicastRemoteObject implements MessageIntf
{
	String message="";
	public MessageImpl()throws RemoteException
	{
		super();
	}
	public void setMessage(String d_msg) throws RemoteException
	{
		message=d_msg;
                
                System.out.println("Server: "+message);
                MessageDisplay msgd = new MessageDisplay();
                msgd.WriteMessage(d_msg,msgd);
	}
        public void setMessage(String d_msg,String ClientIP) throws RemoteException
        {
		message=d_msg;

                System.out.println("Server: "+message);
                MessageDisplay msgd = new MessageDisplay(ClientIP);
                msgd.WriteMessage(d_msg,msgd);

        }
        public void StopedServerSession()
        {
            RemoteAgent_Client.SSS = false;
        }
        public void StartedServerSession()
        {
            RemoteAgent_Client.SSS = true;
        }

}
