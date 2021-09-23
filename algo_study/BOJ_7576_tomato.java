package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class yx1
{
	int y, x;

	yx1(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
};

public class BOJ_7576_tomato {
	 
	static int n,m;
	static int[][] board;
	static int[][] vis;
	static Queue<yx1> Q1;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int cnt1 =0;
	static int cnt2 =0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		m = Integer.parseInt(st1.nextToken());
		n = Integer.parseInt(st1.nextToken());
		
		board = new int[n][m];
		vis = new int[n][m];
		Q1 = new LinkedList<yx1>();
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<m; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] != -1) cnt1++;
				if(board[a][b] == 1)
				{
					Q1.offer(new yx1(a,b));
					vis[a][b] = 1;
				}
			}
		}
		
		int ans = 1;
		
		while(!Q1.isEmpty())
		{
			yx1 cur = Q1.poll();
			cnt2++;
			
			for(int dr=0; dr<4; dr++)
			{
				int yy = cur.y + dy[dr];
				int xx = cur.x + dx[dr];
				if(yy<0 || xx<0 || yy>=n || xx>=m) continue;
				
				if(board[yy][xx] == -1) continue;
				
				if(vis[yy][xx]>0) continue;
				
				vis[yy][xx] = vis[cur.y][cur.x] + 1; 
				if(ans < vis[yy][xx]) ans = vis[yy][xx];
				
				Q1.offer(new yx1(yy,xx));
				
			}
			
			
		}
		
		
		if(cnt1 != cnt2)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(ans-1);
		}
		
	}

}
