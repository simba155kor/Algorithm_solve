package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_е╩аж╧Э╟к╟е {

	static int n,m;
	static int r,c;
	static int l;
	static int[][] board;
	static int[][] vis;
	
	//╩С ©Л го аб
	static int[] dy= {-1, 0, 1, 0};
	static int[] dx= {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int test = Integer.parseInt(st1.nextToken());
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			
			n= Integer.parseInt(st1.nextToken());
			m= Integer.parseInt(st1.nextToken());
			r= Integer.parseInt(st1.nextToken());
			c= Integer.parseInt(st1.nextToken());
			l= Integer.parseInt(st1.nextToken());
			
			board = new int[n][m];
			vis = new int[n][m];
			
			for(int a=0; a<n; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				for(int b=0; b<m; b++)
				{
					board[a][b] = Integer.parseInt(st1.nextToken());
				}
			}
			
			
			int ans=BFS()+1;
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static int BFS()
	{
		int ans=0;
		
		Queue<int[]> Q1 = new LinkedList<int[]>();
		
		Q1.offer(new int[] {r,c});
		vis[r][c] = 1;
		
		while(!Q1.isEmpty())
		{
			int[] cur = Q1.poll();
			if(vis[cur[0]][cur[1]] == l) break;
			
			for(int dr=0; dr<4; dr++)
			{
				int yy = cur[0] + dy[dr];
				int xx = cur[1] + dx[dr];
				
				if(yy<0 || xx<0 || yy>=n || xx>=m) continue;
				
				if(vis[yy][xx] >0) continue;
				if(board[yy][xx] ==0) continue;
				
				//╩С ©Л го аб
				if(board[cur[0]][cur[1]] == 2 && (dr==1 || dr==3 )) continue;
				if(board[cur[0]][cur[1]] == 3 && (dr==0 || dr==2 )) continue;
				if(board[cur[0]][cur[1]] == 4 && (dr==2 || dr==3 )) continue;
				if(board[cur[0]][cur[1]] == 5 && (dr==0 || dr==3 )) continue;
				if(board[cur[0]][cur[1]] == 6 && (dr==0 || dr==1 )) continue;
				if(board[cur[0]][cur[1]] == 7 && (dr==1 || dr==2 )) continue;
				
				if(dr==0 && (board[yy][xx] ==3 || board[yy][xx] ==4 || board[yy][xx] ==7 )) continue;
				if(dr==1 && (board[yy][xx] ==2 || board[yy][xx] ==4 || board[yy][xx] ==5 )) continue;
				if(dr==2 && (board[yy][xx] ==3 || board[yy][xx] ==5 || board[yy][xx] ==6 )) continue;
				if(dr==3 && (board[yy][xx] ==2 || board[yy][xx] ==6 || board[yy][xx] ==7 )) continue;
				
				Q1.offer(new int[] {yy,xx});
				vis[yy][xx] = vis[cur[0]][cur[1]] + 1;
				ans++;
			}
			
		}
			
		return ans;
	}

}
