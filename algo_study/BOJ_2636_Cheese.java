package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_Cheese {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int[][] board = new int[n][m];
		int[][] vis; 
		
		int zz=0;
		
		int ans2 =0;
		
		for(int a=0; a< n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<m; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] == 1)
				{
					zz=1;
					ans2++;
				}
			}
		}
		
		int ans1 =0; 
		
		
		Queue<Integer[]> Q1 = new LinkedList<Integer[]>();
		
		while(true)
		{
			vis = new int[n][m];
			
			Q1.offer(new Integer[]{0,0}); 
			vis[0][0] =1;
			
			while(!Q1.isEmpty())
			{
				Integer[] now = Q1.poll();
				
				for(int dr=0; dr<4; dr++)
				{
					int yy = now[0] + dy[dr];
					int xx = now[1] + dx[dr];
					
					if(yy<0 || xx<0 || yy>=n || xx>=m) continue;
					
					if(vis[yy][xx] == 1) continue;
					if(board[yy][xx] == 1)
					{
						vis[yy][xx] = 2;
						continue;
					}
					
					Q1.offer(new Integer[] {yy, xx});
					vis[yy][xx] =1;
				}
			}
			
			
			int temp_ans=0;
			int tag=0;
			
			for(int a=0; a<n; a++)
			{
				for(int b=0; b<m; b++)
				{
					if(vis[a][b] == 2) board[a][b] = 0;
					
					if(board[a][b] == 1) temp_ans++;
				}
			}

			ans1++;
			if(temp_ans ==0) break;
			ans2 = temp_ans;
		}
		
		if(zz==0) System.out.println(0);
		else System.out.println(ans1);
		System.out.println(ans2);
	}

}
