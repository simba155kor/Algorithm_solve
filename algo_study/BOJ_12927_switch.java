package study1_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12927_switch {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int n = s.length();
		char[] arr = new char[n];
		
		for(int a=0; a<n; a++)
		{
			arr[a] = s.charAt(a);
		}
		
		int ans=0;
		
		for(int a=0; a<n; a++)
		{
			if(arr[a] == 'Y')
			{
				int a1 = a+1;
				
				for(int b=a; b<n; b+=a1)
				{
					if(arr[b] == 'Y') arr[b] = 'N'; 
					else if(arr[b] == 'N') arr[b] = 'Y'; 
				}
				
				ans++;
			}
		}
		
				
		System.out.println(ans);
		
	}

}
