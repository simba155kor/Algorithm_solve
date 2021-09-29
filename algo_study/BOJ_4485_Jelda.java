package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_Jelda {

	static int n;
	static int[][] board;
	static int[][] vis;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1;
		
		int t=0;
		
		while(true)
		{
			st1 = new StringTokenizer(br1.readLine());
			n = Integer.parseInt(st1.nextToken());
			
			if(n==0) break;
			int ans =0;
			
			board = new int[n][n];
			
			for(int a=0; a<n; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				for(int b=0; b<n; b++)
				{
					board[a][b] = Integer.parseInt(st1.nextToken());
				}
			}
			
			
			BFS();
			
			ans = vis[n-1][n-1]-1;
			t++;
			System.out.println("Problem " + t + ": " + ans);
		}
		
	}
	
	static void BFS()
	{
		vis = new int[n][n];
		Queue<int[]> Q1 = new LinkedList<>();
		
		Q1.offer(new int[] {0,0});
		vis[0][0] = board[0][0]+1;
		
		while(!Q1.isEmpty())
		{
			int[] cur = Q1.poll();
			
			for(int dr=0; dr<4; dr++)
			{
				int yy= cur[0] + dy[dr];
				int xx= cur[1] + dx[dr];
				
				if(yy<0 || xx<0 || yy>=n || xx>=n) continue;
				
				if(vis[yy][xx] !=0 && vis[yy][xx] <= vis[cur[0]][cur[1]] + board[yy][xx]) continue;
					
				vis[yy][xx] = vis[cur[0]][cur[1]] + board[yy][xx];
				Q1.offer(new int[] {yy, xx});
			}
		}
		
	}

}
