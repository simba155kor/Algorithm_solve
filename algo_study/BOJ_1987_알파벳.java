package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳{
	static int N,M;
	static char[][] board;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int max_ans;
	static boolean[] check = new boolean[30];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		board = new char[N][M];
		
		for(int a=0; a<N; a++)
		{
			String temp = br1.readLine();
			for(int b=0; b<M; b++)
			{
				board[a][b] = temp.charAt(b);
			}
		}
		
		check[board[0][0] -'A'] = true;
		dfs(0,0,0);
		
		
		System.out.println(max_ans+1);
		
	}

	static void dfs(int now_y, int now_x, int cnt)
	{
		if(max_ans < cnt) max_ans = cnt;
		
		for(int dr=0; dr<4; dr++)
		{
			int yy= now_y + dy[dr];
			int xx= now_x + dx[dr];
			
			if(yy<0 || xx<0 || yy>=N || xx>=M) continue;
			
			int temp_c = board[yy][xx] -'A';
			if( check[temp_c] ) continue;
			
			check[temp_c] = true;
			dfs(yy,xx, cnt+1);
			check[temp_c] = false;
		}
		
	}
	
}
