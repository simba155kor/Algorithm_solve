package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5656_brick_break {

	static int n, w, h;
	static int[][] board;
	static int real_ans;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int test= Integer.parseInt(st1.nextToken());
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			n = Integer.parseInt(st1.nextToken());
			w = Integer.parseInt(st1.nextToken());
			h = Integer.parseInt(st1.nextToken());
			
			board = new int[h][w];
			
			real_ans =0;
			
			for(int a=0; a<h; a++)
			{
				st1= new StringTokenizer(br1.readLine());
				for(int b=0; b<w; b++)
				{
					board[a][b] = Integer.parseInt(st1.nextToken());
					if(board[a][b]>0) real_ans++;
				}
			}
			
			
			func(0);
			
			
			System.out.println("#" + t + " " + real_ans);
		}
		
		
	}
	
	static void func(int now)
	{
		if(now==n)
		{
			int ans =0;
			for(int a=0; a<h; a++)
			{
				for(int b=0; b<w; b++)
				{
					if(board[a][b] >0) ans++;
				}
			}
			
			if(real_ans > ans ) real_ans = ans;
			
			return;
		}
		
		
		
		for(int a=0; a<w; a++)
		{
			int[][] temp_board = new int[h][w];
			
			for(int a1=0; a1<h; a1++)
				for(int b1=0; b1<w; b1++)
					temp_board[a1][b1] = board[a1][b1];
			
			breaking(a);
			func(now+1);
			
			for(int a1=0; a1<h; a1++)
				for(int b1=0; b1<w; b1++)
					board[a1][b1] = temp_board[a1][b1];
			
		}
	}
	
	static void breaking2(int y, int x)
	{
		int power1 = board[y][x];
		
		board[y][x] = 0;
		
		for(int dr=0; dr<4; dr++)
		{
			int temp = power1-1;
			int yy = y;
			int xx = x;
			while(temp>0)
			{
				yy += dy[dr];
				xx += dx[dr];
				if(yy<0 || xx<0 || yy>=h || xx>=w) break;
				
				if(board[yy][xx]>0)
				{
					breaking2(yy, xx);
				}
				
				board[yy][xx] = 0;
				temp--;
			}
		}
		
	}
	
	static void breaking(int where)
	{
		for(int a=0; a<h; a++)
		{
			if(board[a][where] ==0) continue;
			
			breaking2(a, where);
			
			break;
		}
		
		
		//내려주기
		for(int b=0; b<w; b++)
		{
			int tag=-1;
			int prev=-1;
			for(int a=h-1; a>=0; a--)
			{
				if(board[a][b]==0 && tag==-1)
				{
					tag=1;
					prev = a;
				}
				else if(board[a][b]>0 && tag==1)
				{
					board[prev][b] = board[a][b];
					board[a][b] = 0;
					prev--;
				}
			}
		}
		
	}

}
