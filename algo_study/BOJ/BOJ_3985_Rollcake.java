package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985_Rollcake {
	static int L;
	static boolean[] board;
	static int max1;
	static int idx1;
	static int max2;
	static int idx2;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		L = Integer.parseInt(br1.readLine());
		int n = Integer.parseInt(br1.readLine());
		board= new boolean[L];
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int a1 = Integer.parseInt(st1.nextToken()) -1;
			int a2 = Integer.parseInt(st1.nextToken()) -1;
			
			if(a2 - a1 > max1)
			{
				max1 = a2-a1;
				idx1 = a;
			}
			
			int real_cnt=0;
			for(int b=a1; b<=a2; b++)
			{
				if(board[b] == true) continue;
				board[b] = true;
				real_cnt++;
			}
			
			if(real_cnt > max2)
			{
				max2 = real_cnt;
				idx2 = a;
			}
		}
		
		System.out.println(idx1+1);
		System.out.println(idx2+1);
	}
	
}
