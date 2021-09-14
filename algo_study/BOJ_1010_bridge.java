package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_bridge {
	static int[][] board; // n r
	static int MAX_N = 31;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		board = new int[MAX_N][MAX_N];
		
		for(int a=0; a<MAX_N; a++)
		{
			board[a][0] =1;
		}
		
		for(int a=1; a<MAX_N; a++)
		{
			for(int b=1; b<MAX_N; b++)
			{
				if(a<b)break;
				board[a][b] = board[a-1][b-1] + board[a-1][b];
			}
		}
		
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br1.readLine());
		StringTokenizer st1;
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int r = Integer.parseInt(st1.nextToken());
			int n = Integer.parseInt(st1.nextToken());
			
			System.out.println(board[n][r]);
		}
	}

}
