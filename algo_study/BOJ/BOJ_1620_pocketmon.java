package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_pocketmon {

	static int n,m;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n= Integer.parseInt(st1.nextToken());
		m= Integer.parseInt(st1.nextToken());
		
		Map<String, String> m1 = new HashMap<String, String>();
		
		for(int a=0; a<n; a++)
		{
			String inp = br1.readLine();
			String temp = Integer.toString(a+1);
			m1.put(temp, inp);
			m1.put(inp, temp);
		}
		
		
		for(int a=0; a<m; a++)
		{
			String inp = br1.readLine();
			
			System.out.println(m1.get(inp));
		}
		
	}

}
