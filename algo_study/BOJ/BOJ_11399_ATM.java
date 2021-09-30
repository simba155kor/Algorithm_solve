package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	
	static int n;
	static int[] board;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br1.readLine());
		board = new int[n];
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		for(int a=0; a<n; a++) board[a] = Integer.parseInt(st1.nextToken());
		
		Arrays.sort(board);
		
		int ans=0;
		for(int a=0; a<n; a++)
		{
			int temp = n-a;
			temp *= board[a];
			ans+=temp;
		}
		
		System.out.println(ans);
	}

}
