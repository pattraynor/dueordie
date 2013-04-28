//Should save to a file, and then load the file from a previous session.
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.*;
public class SaveLoad
{
	public SaveLoad()
	{



	}

	 public void save() throws IOException
	 {
		 try
			{
				File userDB = new File( "C:\\userDatabase.dat" );
				FileOutputStream out = new FileOutputStream(userDB);
			}
			catch (Exception IOException)
			{System.out.println("Error, problem saving file");}
     }

	    //-------------------------------------------------
	    // loads LoginList and all user information from file
	    // -------------------------------------------------
	    public void load() throws IOException
	    {

	    }

}
