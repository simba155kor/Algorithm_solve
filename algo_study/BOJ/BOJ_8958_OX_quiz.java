package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX_quiz {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br1.readLine());
		for(int t=1; t<=test; t++)
		{
			int ans=0;
			String inp = br1.readLine();
			
			int adding=0;
			
			for(int a=0, end = inp.length(); a<end; a++)
			{
				if(inp.charAt(a) == 'X') adding=0;
				else
				{
					adding++;
					ans+=adding;
				}
			}
			
			System.out.println(ans);
		}

	}

}
