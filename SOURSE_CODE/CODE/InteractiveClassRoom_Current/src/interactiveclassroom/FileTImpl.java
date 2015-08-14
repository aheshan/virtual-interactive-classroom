/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interactiveclassroom;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFileChooser;
/**
 *
 * @author Jesus
 */
public class FileTImpl extends UnicastRemoteObject implements FileTIntf{

    public FileTImpl() throws RemoteException{
        super();
    }

    public boolean transferFile(String fileName,byte[] filedata)
    {
        try
        {
            File file = new File(fileName);

            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
         
            System.out.println("Hello");
            output.write(filedata,0,filedata.length);
            output.flush();
            output.close();

            return true;
        }
        catch(Exception e)
        {
            //System.out.println("FileImplement: " + e.getMessage());
            //e.printStackTrace();

            return false;
        }
    }

    public String openFileChoser()
    {
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.showOpenDialog(null);
        String sfile = jf.getSelectedFile().toString();
        return sfile;
    }
}
