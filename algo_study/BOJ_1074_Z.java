package zany1;

import java.util.Scanner;

public class BOJ_1074_Z {
	
	static int N,r,c;
	static int cnt=0;
	static int[][] board;
	static int[] dy = {0, 0, 1, 1};
	static int[] dx = {0, 1, 0, 1};
	static int tag=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc1 = new Scanner(System.in);
		
		N = sc1.nextInt();
		r = sc1.nextInt();
		c = sc1.nextInt();
		
		int len1 = 1<<N;
		
		func(0,0, len1, 0);
		
//		for(int a=0; a<len1; a++)
//		{
//			for(int b=0; b<len1; b++)
//			{
//				System.out.print(board[a][b] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	static void func(int y,int x, int len, int cnt)
	{
		if(len==1)
		{
//			board[y][x] = cnt;
			if(y == r && x == c) 
			{
				System.out.println(cnt);
			}
			return;
		}
		
		for(int dr=0; dr<4; dr++)
		{
			int temp = len/2;
			
			if(dr==0 && ((r >= y + temp) || (c >= x + temp) )) continue;
			if(dr==1 && ((r >= y + temp) || (c < x + temp) )) continue;
			if(dr==2 && ((r < y + temp) || (c >= x + temp) )) continue;
			if(dr==3 && ((r < y + temp) || (c < x + temp) )) continue;
			int tag = dr*(len>>1)*(len>>1);
			func(y + (temp * dy[dr]) , x + (temp * dx[dr]) , temp, cnt+  tag );
		}
		
		
	}

}
