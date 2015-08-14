/*
 * FileImpl.java
 *
 * Created on March 11, 2010, 4:14 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package interactiveclassroom;
import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFileChooser;


public class FileImpl extends UnicastRemoteObject implements FileIntf {
    
    /** Creates a new instance of FileImpl */
    public FileImpl() throws RemoteException {
        super();
    }
    
    public byte[] downloadFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            byte buffer[] = new byte[(int)file.length()];
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
            input.read(buffer,0,buffer.length);
            input.close();
            return(buffer);
        }
        catch(Exception e)
        {
            //System.out.println("FileImplement: " + e.getMessage());
            //e.printStackTrace();
            return(null);
        }
    }

    public String openFileChoser()
    {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        String sfile = jf.getSelectedFile().toString();
        return sfile;
    }
   
}
