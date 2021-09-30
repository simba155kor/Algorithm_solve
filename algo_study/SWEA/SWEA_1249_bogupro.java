package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1249_bogupro {

	static int n;
	static int[][] board;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int test = Integer.parseInt(st1.nextToken());
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			n= Integer.parseInt(st1.nextToken());
			
			board = new int[n][n];
			
			for(int a=0; a<n; a++)
			{
				String s = br1.readLine();
				for(int b=0; b<n; b++)
				{
					board[a][b] = s.charAt(b) - '0';
				}
			}
			
			
			int ans = Dijkstra();
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static int Dijkstra()
	{
		PriorityQueue<int[]> PQ1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2)
			{
				if(o1[0] < o2[0]) return -1;
				else return 1;
			}
		});
		
		
		int[][] vis = new int[n][n];
		
		PQ1.offer(new int[] {board[0][0],0,0});
		vis[0][0]=1;
		
		
		while(!PQ1.isEmpty())
		{
			int[] cur = PQ1.poll();
			
			for(int dr=0; dr<4; dr++)
			{
				int yy= cur[1] + dy[dr];
				int xx= cur[2] + dx[dr];
				
				if(yy<0 || xx<0 || yy>=n || xx>=n) continue;
				
				if(vis[yy][xx] >0) continue;
				
				if(yy == n-1 && xx == n-1) return cur[0] + board[yy][xx];
			
				PQ1.offer(new int[]{cur[0] + board[yy][xx], yy, xx});
				vis[yy][xx] = 1;
			}
			
			
		}
		
		
		return -1;
	}

}
