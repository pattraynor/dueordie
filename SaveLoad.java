//Should save to a file, and then load the file from a previous session.
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.*;
public class SaveLoad
{
	protected int counter;
	public SaveLoad()
	{
		int counter = 0;

	}

	 public void save() throws IOException //Will save the file of userDatabase.dat to C. Saving the object of Globals.userDatabase.
	 {
		 try
			{
				File userDB = new File( "C:\\userDatabase.dat" );	//Creates file of userDatabase.dat
				FileOutputStream DBout = new FileOutputStream(userDB);  //Sets the output stream to write into userDatabase dat file
			    ObjectOutputStream DBObjOut = new ObjectOutputStream(DBout); //Sets the output stream to write objects to userDatabase dat file


			    while (counter < Globals.userDatabase.getListSize())  //While counter is less than 0, it will iterate until the list size is the same as counter.
			    {  //HELP: Need to know how to iterate through userDatabase.

			    	DBObjOut.writeObject(Globals.userDatabase); //Writes Global.userDatabase to file.
					counter++;

				}
			    DBObjOut.flush();
			    DBObjOut.close();

			    FileInputStream DBIn = new FileInputStream("C:\\userDatabase.dat");
			    ObjectInputStream DBObjIn = new ObjectInputStream(DBIn);


			}
			catch (Exception IOException)
			{System.out.println("Error, problem saving file");}
     }

	    //-------------------------------------------------
	    // loads LoginList and all user information from file
	    // -------------------------------------------------
	    public void load() throws IOException
	    {
	    	try
			{

			}
			catch (Exception IOException)
			{System.out.println("Error, problem loading file");}

	    }


}
