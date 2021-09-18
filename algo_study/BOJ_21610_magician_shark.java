package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class yxo
{
	int y, x;
	
	yxo(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
};

public class BOJ_21610_magician_shark {
	static int N,M;
	static int[][] board;
	static int[] dy= {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dx= {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static Queue<yxo> Q1;
	static int ans;
	
	static void func(int di, int si)
	{
		Queue<yxo> temp_Q1 = new LinkedList<yxo>(); 
		
		si%=N;
		
		int[][] vis = new int[N][N];
		
		while(!Q1.isEmpty())
		{
			yxo now_info = Q1.poll();
			
			int yy = now_info.y + dy[di]*si;
			int xx = now_info.x + dx[di]*si;
			
			if(yy<0 || xx<0 || yy>=N || xx>=N)
			{
				yy+=N;
				xx+=N;
				yy%=N;
				xx%=N;
			}
			
			board[yy][xx]++;
			vis[yy][xx] =1;
			temp_Q1.offer(new yxo(yy,xx));
		}
		
		
		while(!temp_Q1.isEmpty())
		{
			yxo now_info = temp_Q1.poll();
			
			int cnt =0;
			for(int dr=2; dr<=8; dr+=2)
			{
				int yy = now_info.y + dy[dr];
				int xx = now_info.x + dx[dr];
				
				if(yy<0 || xx<0 || yy>=N || xx>=N)
				{
					continue;
				}
				if(board[yy][xx]>=1) cnt++;
			}
			
			board[now_info.y][now_info.x] += cnt;
		}
		
		ans =0;
		
		for(int a=0; a<N; a++)
		{
			for(int b=0; b<N; b++)
			{
				if(vis[a][b]==1) {ans += board[a][b]; continue;}
				
				if(board[a][b]<2) {ans += board[a][b]; continue;}
				
				board[a][b]-=2;
				Q1.offer(new yxo(a,b));
				ans += board[a][b];
			}
		}
		
//		for(int a=0; a<N; a++)
//		{
//			for(int b=0; b<N; b++)
//			{
//				System.out.print(board[a][b] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("-----------");
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		board = new int[N][N];
		
		for(int a=0; a<N; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<N; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
			}
		}
		
		Q1 = new LinkedList<yxo>(); 
		
		Q1.offer(new yxo(N-1, 0));
		Q1.offer(new yxo(N-1, 1));
		Q1.offer(new yxo(N-2, 0));
		Q1.offer(new yxo(N-2, 1));
		
		for(int a=0; a<M; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			int di = Integer.parseInt(st1.nextToken());
			int si = Integer.parseInt(st1.nextToken());
			
			func(di, si);
		}
		
		System.out.println(ans);
	}

}
