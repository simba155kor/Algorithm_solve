package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int a=1; a<=n; a++)
		{
			arr1.add(a);
		}
		
		int now = -1;
		while(arr1.size()>0)
		{
			int temp = k % arr1.size();
			now+=temp;
			
			if(now == -1)
			{
				now = arr1.size()-1;
			}
			else now %= arr1.size();
			
			ans.add(arr1.get(now));
			arr1.remove(now);
			now--;
		}
		
		System.out.print("<");
		for(int a=0; a<ans.size(); a++) 
		{
			if(a==ans.size()-1) System.out.print(ans.get(a) + ">");
			else System.out.print(ans.get(a) + ", ");
		}
	}

}
