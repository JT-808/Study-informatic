

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

public class HexDumpTool
{
    public static void main(String[] args)
	{
		try
		{
			System.out.println(dump("HexDumpTool.java"))
			;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String dump(String filename) throws IOException
	{
	    final int Breite= 16;
		String dump="";
		String hexline="";
		String txtline="";
		
		InputStream in = Files.newInputStream( Paths.get(filename ), StandardOpenOption.READ );
		
		
		int b=in.read();
	         
		int i=1;
		
		while(b!=-1)
		{
			if(b<=15)
				hexline=hexline + "0";
			hexline=hexline + Integer.toHexString(b);
			
			if((b>=32)&&(b<127))
				txtline=txtline+((char) b);
			else
				txtline=txtline + '.';
			
			if(i==Breite)
			{
				dump = dump + hexline + "  "+txtline+"\n";
				i=0;
				hexline="";
				txtline="";
			}	
				b=in.read();
				i++;
			
		} //Ende while-Schleife
		in.close();
		
		if(i<Breite)
		{
			for(int k=i;k<=Breite; k++)	
			{
				hexline = hexline + "00";
				txtline = txtline + ".";
			}
		}
		dump=dump + hexline + "  "+txtline+"\n";
		
		
		
		return dump;
	}


}
