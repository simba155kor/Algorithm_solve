import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_tetromino {

	static int n,m;
	static int[][] board;
	static boolean[][] vis;
	static int ans;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		
		board = new int[n][m];
		vis = new boolean[n][m];
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<m; b++)
			{
				board[a][b] =Integer.parseInt(st1.nextToken());
			}
		}
		
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<m; b++)
			{
				vis[a][b] = true;
				dfs(0, board[a][b], a, b);
				vis[a][b] = false;
				
			}
		}
		
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<m-2; b++)
			{
				int temp1 = board[a][b]+ board[a][b+1] + board[a][b+2];
				if(a!=0)
				{
					int temp2 = temp1 + board[a-1][b+1];
					if(ans < temp2) ans = temp2;
				}
				if(a!=n-1)
				{
					int temp3 = temp1 + board[a+1][b+1];
					if(ans < temp3) ans = temp3;
				}
				
			}
		}
		
		for(int a=0; a<n-2; a++)
		{
			for(int b=0; b<m; b++)
			{
				int temp1 = board[a][b]+ board[a+1][b] + board[a+2][b];
				if(b!=0)
				{
					int temp2 = temp1 + board[a][b-1];
					if(ans < temp2) ans = temp2;
				}
				if(b!=m-1)
				{
					int temp3 = temp1 + board[a+1][b+1];
					if(ans < temp3) ans = temp3;
				}
				
			}
		}
		
		
		
		System.out.println(ans);
	}
	
	
	static void dfs(int now, int sum, int now_y, int now_x)
	{
		if(now==3)
		{
			if(ans < sum) 
			{
				for(int a=0; a<n; a++)
				{
					for(int b=0; b<m; b++)
					{
						if(vis[a][b]) System.out.print(1 + " ");
						else System.out.print(0 + " ");
					}
					System.out.println();
				}
				ans = sum;
				
			}
			return;
		}
		
		for(int dr=0; dr<4; dr++)
		{
			int yy= now_y + dy[dr];
			int xx= now_x + dx[dr];
			
			if(yy<0||xx<0 || yy>=n ||xx>=m) continue;
			
			if(vis[yy][xx]) continue;
			vis[yy][xx] = true;
			dfs(now+1, sum+ board[yy][xx], yy, xx);
			vis[yy][xx] = false;
		}
	}
	
}


