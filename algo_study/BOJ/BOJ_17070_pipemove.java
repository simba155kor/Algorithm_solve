package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_17070_pipemove {
	
	static int n; 
	static int[][] board;
	static int[][][] D;
	
	static int[] dy = {0, 1, 1};
	static int[] dx = {1, 0, 1};
	
	static int real_ans=0;
	
	static void func(int y, int x, int prev_dr)
	{
		if(y==n-1 && x==n-1)
		{
			real_ans++;
			return;
		}
		
		for(int dr=0; dr<3; dr++)
		{
			if(dr==0 && prev_dr == 1) continue;
			if(dr==1 && prev_dr == 0) continue;
			
			int yy= y + dy[dr];
			int xx= x + dx[dr];
			
			if(yy>=n || xx>=n) continue;
			
			if(board[yy][xx] == 1) continue;
			if(dr==2 && (board[yy-1][xx]==1 || board[yy][xx-1] == 1)) continue;
			
			func(yy, xx, dr);
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br1.readLine());
		board = new int[n][n];
		D = new int[n][n][3];
		
		StringTokenizer st1;
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<n; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
			}
		}
		
		func(0,1, 0);
		
		
//		D[0][1][0] = 1;
//		
//		for(int a=0; a<=n; a++)
//		{
//			for(int b=1; b<=n; b++)
//			{
//				D[a][b][0] = 
//						
//				
//				D[a][b][1] = 
//				
//				D[a][b][2] = 
//			}
//		}
//		

		System.out.println(real_ans);
	}
	
	

}
