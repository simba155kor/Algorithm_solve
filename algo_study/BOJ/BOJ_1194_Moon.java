package solve;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

public class BOJ_1194_Moon {

	static int n,m;
	static char[][] board;
	static int[][][] vis;
	static int st_y, st_x;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
	
		board = new char[n][m];
		vis = new int[n][m][256];
		
		for(int a=0; a<n; a++)
		{
			String temp = br1.readLine();
			for(int b=0; b<m; b++)
			{
				board[a][b] = temp.charAt(b);
				if(board[a][b] == '0')
				{
					st_y = a;
					st_x = b;
				}
			}
		}
		
//		for(int a=0; a<n; a++)
//		{
//			for(int b=0; b<m; b++)
//			{
//				System.out.print(board[a][b]);
//			}
//			System.out.println();
//		}
		
		func();
		
		int ans=Integer.MAX_VALUE;
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<m; b++)
			{
				if(board[a][b] == '1')
				{
					for(int c=0; c<64; c++)
					{
						if(vis[a][b][c]==0) continue;
						if(ans>vis[a][b][c]) ans = vis[a][b][c];
					}
				}
			}
		
		}
		
		
//		for(int c=0; c<64; c++)
//		{
//			for(int a=0; a<n; a++)
//			{
//				for(int b=0; b<m; b++)
//				{
//					System.out.print(vis[a][b][c]);
//				}
//				System.out.println();
//			}
//			System.out.println("---");
//		}
		if(ans == Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);
	}

	
	static void func()
	{
		Queue<int[]> Q1 = new LinkedList<int[]>();
		
		//위치 y, x, 키 갖고있는지val, cnt
		Q1.offer(new int[]{st_y, st_x, 0, 0});
		vis[st_y][st_x][0] =1;
		
		while(!Q1.isEmpty())
		{
			int[] cur = Q1.poll();
			
			for(int dr=0; dr<4; dr++)
			{
				int yy= cur[0] + dy[dr];
				int xx= cur[1] + dx[dr];
				
				if(yy<0 || xx<0 || yy>=n ||xx>=m) continue;
				
				if(board[yy][xx] == '#') continue;
				
				//새로 키 얻었으면 추가.
				if(board[yy][xx] >= 'a' && board[yy][xx] <='f')
				{
					int temp = board[yy][xx] - 'a';
							
					//이미 있던 키면
					if((cur[2] & 1<<temp) >0)
					{
						if(vis[yy][xx][cur[2]] > cur[3]+1 || vis[yy][xx][cur[2]]==0)
						{
							Q1.offer(new int[] {yy, xx, cur[2], cur[3] + 1});
							vis[yy][xx][cur[2]] = cur[3]+1;
						}
					}
					else //새로운 키면
					{
						int temp2 = cur[2] | 1<<temp;
						Q1.offer(new int[] {yy, xx, temp2, cur[3] + 1});
						vis[yy][xx][temp2] = cur[3]+1;
					}
					
				}
				else
				{
					if(board[yy][xx] >= 'A' && board[yy][xx] <='F')
					{
						int temp = board[yy][xx] - 'A';
						if((cur[2] & 1<< temp) ==0) continue; // 키가 없다는것.
					}
					
					//새로 키 얻은게 아니고
					//아직 방문 안했으면
					if(vis[yy][xx][cur[2]] > cur[3]+1 || vis[yy][xx][cur[2]] == 0)
					{
						Q1.offer(new int[] {yy, xx, cur[2], cur[3]+1});
						vis[yy][xx][cur[2]] = cur[3]+1;
					}
				}
				
				
				
				//
				
			}
		}
		
	}
	
}
