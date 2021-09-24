package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_Castle_defense {

	static int N,M,D;
	static int[][] board;
	static int real_ans;
	
	static int[] dy = {0, -1, 0};
	static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		D = Integer.parseInt(st1.nextToken());
		
		board = new int[2*N+1][M];
		
		for(int a=N; a<2*N; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			for(int b=0; b<M; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
			}
		}
		
		dfs(0,0, new int[3]);
		
		
		System.out.println(real_ans);
		
	}
	
	
	
	static int cal(int[] arr)
	{
		int ans =0;
		
		Queue<int[]> Q1 = new LinkedList<int[]>();

		//System.out.println(arr[0] + " , " + arr[1] + " , " + arr[2]);

		//최대 N번 반복
		//옮길 필요 x
		int now_y = 2*N;
		
		while(now_y != N)
		{
//			System.out.println("---------------\n");
//
//			for(int a=now_y-N; a<=now_y; a++)
//			{
//				for(int b=0; b<M; b++)
//				{
//					System.out.print(board[a][b] + " ");
//				}
//				System.out.println();
//			}
			
			Queue<int[]> Q2 =new LinkedList<int[]>();
			
			for(int a=0; a<3; a++)
			{
				int tag=0;
                
				Q1 =new LinkedList<int[]>();
				Q1.offer(new int[] {now_y, arr[a]});
				
				int[][] vis = new int[2*N+1][M];
				vis[now_y][arr[a]] = 1;
				
				while(!Q1.isEmpty())
				{
					int[] now= Q1.poll();
					
					for(int dr=0; dr<3; dr++)
					{
						int yy = now[0] + dy[dr];
						int xx = now[1] + dx[dr];
						
						if(yy<0 || xx<0 || xx>=M) continue;
						
						if(vis[yy][xx]>0) continue;
						
						if(board[yy][xx] == 1 && yy != now_y)
						{
							//ans++;
//							board[yy][xx] = 0;
							Q2.offer(new int[] {yy,xx});
							//System.out.println(yy + " ,, " + xx);
							tag=1;
							break;
						}
						
						vis[yy][xx] = vis[now[0]][now[1]] + 1;
						if(vis[yy][xx]>=D+1) continue;
						Q1.offer(new int[]{yy,xx});
					}
					
					if(tag==1) break;
					
				}
				
			}
			
			int[][] vis2 = new int[2*N+1][M];
			
			while (!Q2.isEmpty()) {
				int[] now= Q2.poll();
				
				int yy= now[0];
				int xx= now[1];
				
				if(vis2[yy][xx] == 1) continue;
				
				ans++;
				board[yy][xx] = 0;
				vis2[yy][xx] = 1;

			}
			
			
			now_y--;
		}
		
		//System.out.println(ans);
		
		return ans;
	}
	
	static int cnttt=0;
	
	static void dfs(int now, int prev_a, int[] arr)
	{
		if(now == 3)
		{
			//cnttt++;
			//if(cnttt==3) return;
			
			int[][] temp_board = new int[2*N+1][M];
			for(int a=0; a<=2*N; a++)
			{
				for(int b=0; b<M; b++)
				{
					temp_board[a][b] = board[a][b];
				}
			}
			
			
			int temp_ans = cal(arr);
			if(temp_ans > real_ans) real_ans = temp_ans;
			
			
			for(int a=0; a<=2*N; a++)
			{
				for(int b=0; b<M; b++)
				{
					board[a][b] = temp_board[a][b];
				}
			}
			
			return;
		}
		
		
		for(int a=prev_a; a<M; a++)
		{
			arr[now] = a;
			dfs(now+1, a+1, arr);
		}
	}
	
}
