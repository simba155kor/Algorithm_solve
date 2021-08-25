package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아_알파벳 {

	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String inp = br1.readLine();
		
		int len = inp.length();
		inp += "kk";
		
		int ans=0;
		for(int a=0; a<len; a++)
		{
			if(inp.charAt(a) == 'c')
			{
				//경계 조심
				if( inp.charAt(a+1) =='=' || inp.charAt(a+1) == '-')
				{
					a++;
				}
			}
			else if(inp.charAt(a) == 'd')
			{
				if(inp.charAt(a+1) == 'z' && inp.charAt(a+2) == '=') a+=2;
				
				if(inp.charAt(a+1)=='-') a++;
			}
			else if(inp.charAt(a) == 'l' && inp.charAt(a+1) == 'j') a++;
			else if(inp.charAt(a) == 'n' && inp.charAt(a+1) == 'j') a++;
			else if(inp.charAt(a) == 's' && inp.charAt(a+1) == '=') a++;
			else if(inp.charAt(a) == 'z' && inp.charAt(a+1) == '=') a++;
			
			ans++;
		}
		
		System.out.println(ans);
	}
	
}
