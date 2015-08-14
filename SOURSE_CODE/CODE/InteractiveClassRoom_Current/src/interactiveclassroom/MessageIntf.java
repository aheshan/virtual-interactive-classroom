package interactiveclassroom;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessageIntf extends Remote
{
	//for Setting the Value in Message produce

	public void setMessage(String d_msg) throws RemoteException;
        public void setMessage(String d_msg,String ClientIP) throws RemoteException;
        public void StopedServerSession() throws RemoteException;
        public void StartedServerSession() throws RemoteException;

}
