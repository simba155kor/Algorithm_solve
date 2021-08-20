package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_Ohsello {
	static int N,M;
	static int[][] board;
	
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1};
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1;
		
		int test = Integer.parseInt(br1.readLine());
		for(int t=1; t<=test; t++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			N = Integer.parseInt(st1.nextToken());
			M = Integer.parseInt(st1.nextToken());
			board = new int[N][N];
			
			//1이면 흑, 2면 백
			
			board[N/2 -1][N/2 -1] = 2;
			board[N/2 -1][N/2] = 1;
			board[N/2][N/2 -1] = 1;
			board[N/2][N/2] = 2;
			
			
			for(int a=0; a<M; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				int x = Integer.parseInt(st1.nextToken()) -1; 
				int y = Integer.parseInt(st1.nextToken()) -1; 
				int val = Integer.parseInt(st1.nextToken());
				
				func(y, x, val);
			}
			
			int white_cnt =0, black_cnt=0;
			
			for(int a=0; a<N; a++)
			{
				for(int b=0; b<N; b++)
				{
					if(board[a][b] == 1) black_cnt++;
					if(board[a][b] == 2) white_cnt++;
				}
			}
			
			System.out.println("#" + t + " " + black_cnt + " " + white_cnt);
			
		}
		
	}
	
	static void func(int now_y, int now_x, int val)
	{
		for(int dr=0; dr<8; dr++)
		{
			int yy = now_y;
			int xx = now_x;
			int tag=0;
			
			while(true)
			{
				yy += dy[dr];
				xx += dx[dr];
				
				if(yy<0 || xx<0 || yy>=N || xx>=N) {tag=0; break;} //뭐 안만나고 나갔으면 걍 안해도됨 아무것도.
				if(board[yy][xx] == 0) {tag=0; break;} //빈칸으로 만났다는건 무조건 안되는 상황
				if(board[yy][xx] == val) break; // 내꺼랑 같은거 만났네, 근데 tag 1이면 바꿔줘야되는상황.
				//상대편 돌이 있었다는거.
				tag=1;
			}
			
			if(tag==1)
			{
				while(yy != now_y || xx !=now_x)
				{
					yy -=dy[dr];
					xx -=dx[dr];
					
					board[yy][xx] = val;
				}
			}
		}
	}

}
