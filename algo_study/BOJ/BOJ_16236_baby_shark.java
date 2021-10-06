package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_baby_shark {

	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	static int n;
	
	static int[][] board;
	
	static int[] baby_shark_yx;
	static int baby_shark_size;
	static int eat_cnt;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
	
		n = Integer.parseInt(st1.nextToken());
		
		board = new int[n][n];
		
		for(int a=0; a<n; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			for(int b=0; b<n; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] == 9)
				{
					baby_shark_yx = new int[2];
					baby_shark_yx[0] = a;
					baby_shark_yx[1] = b; 
				}
			}
		}
		
		baby_shark_size = 2;
		int ans=0;
		while(true)
		{
			int temp = func();
			if(temp==-1) break;
			
			ans += temp;
			
		}
	
		System.out.println(ans);
	}
	
	
	static int func() 
	{
		Queue<int[]> Q1 = new LinkedList<int[]>();
		
		int[][] vis = new int[n][n];
		
		Q1.offer(new int[] {baby_shark_yx[0], baby_shark_yx[1]});
		vis[baby_shark_yx[0]][baby_shark_yx[1]] = 1;
		
		
		int check_val=-1;
		
		int spot_y = 100, spot_x = 100;
		
		while(!Q1.isEmpty())
		{
			int[] cur = Q1.poll();
			if(vis[cur[0]][cur[1]] > check_val && check_val !=-1) continue;
			
			if(vis[cur[0]][cur[1]] == check_val && board[cur[0]][cur[1]] < baby_shark_size)
			{
				if(board[cur[0]][cur[1]] == 0 || board[cur[0]][cur[1]] == 9) continue;
				if(spot_y > cur[0])
				{
					spot_y = cur[0];
					spot_x = cur[1];
				}
				else if(spot_y == cur[0])
				{
					if(spot_x > cur[1])
					{
						spot_y = cur[0];
						spot_x = cur[1];
					}
				}
				
				continue;
			}
			
			
			for(int dr=0; dr<4; dr++)
			{
				int yy = cur[0] + dy[dr];
				int xx = cur[1] + dx[dr];
				
				if(yy<0 || xx<0 || yy>=n || xx>=n) continue;
				
				if(vis[yy][xx]>0) continue;
				
				if(board[yy][xx] > baby_shark_size) continue;
				
				if(board[yy][xx] == baby_shark_size || board[yy][xx] ==0 || board[yy][xx] == 9)
				{
					Q1.offer(new int[] {yy,xx});
					vis[yy][xx] = vis[cur[0]][cur[1]] + 1;
				}
				else if(board[yy][xx] < baby_shark_size)
				{
					Q1.offer(new int[] {yy,xx});
					vis[yy][xx] = vis[cur[0]][cur[1]] + 1;
					
					if(check_val == -1) check_val = vis[yy][xx];
					else if(check_val > vis[yy][xx]) check_val = vis[yy][xx];
				}
			}
		}
		
		if(spot_y == 100) return -1;
		
	
		board[baby_shark_yx[0]][baby_shark_yx[1]] = 0;
		baby_shark_yx[0]= spot_y; baby_shark_yx[1] = spot_x;
		eat_cnt++;
		if(eat_cnt == baby_shark_size)
		{
			eat_cnt=0;
			baby_shark_size++;
		}
		board[spot_y][spot_x] = 9;
		return vis[spot_y][spot_x] -1;
		
	}

}
