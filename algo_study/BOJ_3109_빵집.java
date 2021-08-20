package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R, C;
	static char[][] board;
	static int[] dy = {-1, 0, 1};
	static int[] dx = { 1, 1, 1};
	static int ans;
	static boolean ans_tag;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		R = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		
		board = new char[R][C]; 
		
		for(int a=0; a<R; a++)
		{
			String temp = br1.readLine();
			for(int b=0; b<C; b++)
			{
				board[a][b] = temp.charAt(b);
			}
		}

		for(int a1=0; a1< R; a1++)
		{
			ans_tag = false;
			if(board[a1][1] != '.') continue;
			board[a1][1]='O';
			func2(a1 , 1);
			if(ans_tag) ans++;
		}
		
		System.out.println(ans);
		
	}
  
	
	static void func2(int now_y, int now_x)
	{
		//if(board[now_y][now_x]== 'x' || board[now_y][now_x]=='O') return;
		if(ans_tag) return;
		
		if(now_x == C-2)
		{
			ans_tag=true;
			return;
		}
		
		for(int dr=0; dr<3; dr++)
		{
			int yy = now_y + dy[dr];
			int xx = now_x + dx[dr];

			if(yy<0 || xx<0 || yy>=R || xx>=C) continue;
			if(board[yy][xx]== 'x' || board[yy][xx]=='O') continue;
			
			board[yy][xx] = 'O';
			func2(yy, xx);
			if(ans_tag) return;
			//board[yy][xx] = '.';
		}
		
	}
	
	
//	static void func()
//	{
//		for(int a=0; a<R; a++)
//		{
//			int now_y = a;
//			int now_x = 0;
//			
//			while(true)
//			{
//				int tag=0; 
//				
//				for(int dr=0; dr<3; dr++)
//				{
//					int yy = now_y + dy[dr];
//					int xx = now_x + dx[dr];
//					
//					if(yy<0 || xx<0 || yy>=R || xx>=C) continue;
//					if(board[yy][xx] =='x' || board[yy][xx] == 'O') continue;
//					
//					board[yy][xx] = 'O';
//					now_y = yy;
//					now_x = xx;
//					
//					tag=1;
//					break;
//				}
//				
//				if(tag==0 ) break;
//				
//				if(now_x == C-1)
//				{
//					ans++;
//					break;
//				}
//			}
//			
//			for(int a1=0; a1<R; a1++)
//			{
//				for(int b1=0; b1<C; b1++)
//				{
//					System.out.print(board[a1][b1]);
//				}
//				System.out.println();
//			}
//			System.out.println("-------");
//		}
//		
//	}
}
