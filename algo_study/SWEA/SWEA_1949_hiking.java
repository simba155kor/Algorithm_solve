package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_hiking {
	
	static int n,k;
	static int[][] board;
	static int[][] vis;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static int real_ans;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		int test = Integer.parseInt(st1.nextToken());
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			
			n = Integer.parseInt(st1.nextToken());
			k = Integer.parseInt(st1.nextToken());
			
			board = new int[n][n];
			vis = new int[n][n];
			real_ans =1;
			
			int st_point_val=0;
			
			for(int a=0; a<n;a++)
			{
				st1= new StringTokenizer(br1.readLine());
				for(int b=0; b<n; b++)
				{
					board[a][b] = Integer.parseInt(st1.nextToken());
					if(st_point_val < board[a][b] ) st_point_val = board[a][b];
				}
			}
			
			
			for(int a=0; a<n; a++)
			{
				for(int b=0; b<n; b++)
				{
					if(board[a][b] != st_point_val) continue;
					
					vis[a][b] =1;
					DFS(a, b, 0, 1);
					vis[a][b] =0;
				}
			}
			
			System.out.println("#" + t + " " + real_ans);
		}
		
	}
	
	static void DFS(int y, int x, int cnt, int ans)
	{
		if(real_ans < ans) real_ans = ans;
		
		for(int dr=0; dr<4; dr++)
		{
			int yy = y + dy[dr];
			int xx = x + dx[dr];
			
			if(yy<0 || xx<0 || yy>=n || xx>=n) continue;
			if(vis[yy][xx]>0) continue;
			
			if(cnt==0)
			{
				//더 높거나 같은 경우, 벽 쓸 수 있다면 벽 깨는거 쓰는 경우
				if(board[yy][xx] >= board[y][x] && board[yy][xx]-k<board[y][x])
				{
					int temp = board[yy][xx];
					board[yy][xx] = board[y][x] -1;
					vis[yy][xx] = 1;
					DFS(yy,xx, cnt+1, ans+1);
					vis[yy][xx] =0;
					board[yy][xx] = temp;
				}
				
				//낮은 경우
				if(board[yy][xx] < board[y][x]) 
				{
					vis[yy][xx] =1;
					DFS(yy,xx, cnt, ans+1);
					vis[yy][xx] =0;
				}
			}
			else
			{
				if(board[yy][xx] >= board[y][x]) continue;
				
				vis[yy][xx] =1;
				DFS(yy,xx, cnt, ans+1);
				vis[yy][xx] =0;
			}
			
		}
		
		
	}

}
