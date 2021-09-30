package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_3307_LIS2 {
	
	static int[] D;
	static int[] board;
	static ArrayList<Integer> list;
	
	static int binary_search(int st, int ed, int target)
	{
		if(ed-st<=1)
		{
			if(list.get(st) > target) return st;
			return ed;
		}
		int mid = (st+ed)/2;
		
		if(list.get(mid) <= target)
		{
			return binary_search(mid, ed, target);
		}
		if(list.get(mid) > target)
		{
			return binary_search(st, mid, target);
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1 = new StringBuilder();
		
		int test = Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			int n = Integer.parseInt(br1.readLine());
			
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			
			board = new int[n];
			D = new int[n];
			
			list = new ArrayList<Integer>();
			
			for(int a=0; a<n; a++)
			{
				board[a] = Integer.parseInt(st1.nextToken());
			}
			
			
			list.add(board[0]);
			for(int a=1; a<n; a++)
			{
				if(list.get(list.size()-1) <=board[a]) list.add(board[a]);
				else
				{
					int spot = binary_search(0, list.size(), board[a]);
					list.set(spot, board[a]);
				}
			}
			
			sb1.append("#" + t + " " + list.size()+"\n");
		}
		
		System.out.println(sb1.toString());
	}

}
