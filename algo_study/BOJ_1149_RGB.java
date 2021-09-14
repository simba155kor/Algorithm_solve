package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1149_RGB {

	static int[][] board;
	static int[][] D;
	
	public static void main(String[] args) throws IOException{
       
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br1.readLine());
		
		board = new int[n][3];
		D = new int[n][3];
		
		StringTokenizer st1;
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<3; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
			}
		}
		
		D[0][0] = board[0][0];
		D[0][1] = board[0][1];
		D[0][2] = board[0][2];
		
		for(int a=1; a<n; a++)
		{
			for(int b=0; b<3; b++)
			{
				D[a][0] = Integer.min(D[a-1][1], D[a-1][2]) + board[a][0];
				D[a][1] = Integer.min(D[a-1][0], D[a-1][2]) + board[a][1];
				D[a][2] = Integer.min(D[a-1][0], D[a-1][1]) + board[a][2];
			}
		}
		
		int ans = Integer.min(D[n-1][0], D[n-1][1]);
		ans = Integer.min(D[n-1][2], ans);
		
		System.out.println(ans);
		
	}

}