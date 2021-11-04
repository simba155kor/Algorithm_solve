package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n= Integer.parseInt(st1.nextToken());
		int m= Integer.parseInt(st1.nextToken());
		
		Set<String> S1 = new HashSet<String>();
		
		for(int a=0; a<n; a++)
		{
			String temp = br1.readLine();
			S1.add(temp);
		}
		
		int cnt=0;
		
		ArrayList<String> arr1 = new ArrayList<String>();
		
		for(int a=0; a<m; a++)
		{
			String temp = br1.readLine();
			if(S1.contains(temp))
			{
				arr1.add(temp);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		Collections.sort(arr1, new Comparator<String>() {
			public int compare(String s1, String s2)
			{
				return s1.compareTo(s2);
			}
		});
		
		for(int a=0; a<arr1.size(); a++)
		{
			System.out.println(arr1.get(a));
		}
		
	}

}
