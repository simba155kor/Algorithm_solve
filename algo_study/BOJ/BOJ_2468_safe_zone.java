package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_safe_zone {

	static int n;
	static int[][] board;
	static int ans;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		
		board = new int[n][n];
		
		int max_height=0;
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<n; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] > max_height) max_height = board[a][b];
			}
		}
		
		ans = 1;
			
		for(int a=1; a<max_height; a++)
		{
			int temp_ans = func(a);
			if(ans < temp_ans ) ans = temp_ans;
		}
		
		System.out.println(ans);
	}

	static int func(int now)
	{
		Queue<int[]> Q1 = new LinkedList<int[]>();
		
		int[][] vis = new int[n][n];
		
		int ans =0;
		
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<n; b++)
			{
				if(board[a][b] <= now) continue;
				if(vis[a][b] >0) continue;
				
				ans++;
				Q1.offer(new int[] {a,b});
				vis[a][b] = 1;
				
				while(!Q1.isEmpty())
				{
					int[] cur = Q1.poll();
					
					for(int dr=0; dr<4; dr++)
					{
						int yy= cur[0] + dy[dr];
						int xx = cur[1] + dx[dr];
						
						if(yy<0 || xx<0 || yy>=n || xx>=n ) continue;
						
						if(board[yy][xx] <= now) continue;
						
						if(vis[yy][xx]>0) continue;
						
						vis[yy][xx] = 1;
						Q1.offer(new int[] {yy,xx});
					}
				}
			}
		}
		
		
		
		return ans;
			
	}
	
}
