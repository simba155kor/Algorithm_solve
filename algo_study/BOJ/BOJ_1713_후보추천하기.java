package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1713_후보추천하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		
		st1 = new StringTokenizer(br1.readLine());
		
		int m = Integer.parseInt(st1.nextToken());
		
		st1 = new StringTokenizer(br1.readLine());
		
		ArrayList<int[]> arr1 = new ArrayList<int[]>();
		
		for(int a=1; a<=m; a++)
		{
			int temp = Integer.parseInt(st1.nextToken());
			int tag=0;
			
			
			for(int b=0; b<arr1.size(); b++)
			{
				int[] temp2 = arr1.get(b);
				if(arr1.get(b)[2] == temp)
				{
					temp2[0]++;
					arr1.set(b, temp2);
					tag=1;
					break;
				}
			}
			
			//새로
			if(tag==0)
			{
				int[] temp2 = new int[] {1, a, temp};
				if(arr1.size()==n)
				{
					arr1.set(0, temp2);
				}
				else
				{
					arr1.add(temp2);
				}
			}
			
			
			Collections.sort(arr1 , new Comparator<int[]>() {
			    @Override 
				public int compare(int[] o1, int[] o2) 
					{ 
				 		if(o1[0] < o2[0]) return -1;
				 		else
				 		{
				 			if(o1[0]==o2[0])
				 			{
					 			if(o1[1] < o2[1]) return -1;				 				
				 			}

				 		}
				 		return 1;
					}
			});
			
		}
		
		
		Collections.sort(arr1, 
				new Comparator<int[]>() {
					
					public int compare(int[] a1, int[] a2)
					{
						if(a1[2]< a2[2]) return -1;
						
						return 1;
					}
			
		});
		
		for(int a=0; a<arr1.size(); a++)
		{
			System.out.print(arr1.get(a)[2] + " ");
		}
		
	}

}
