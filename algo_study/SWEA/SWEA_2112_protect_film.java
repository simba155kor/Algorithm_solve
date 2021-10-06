package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_protect_film {

	static int d, w, k;
	
	static int[][] board;
	
	static int ans;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int test = Integer.parseInt(st1.nextToken());
		
		StringBuilder sb1 = new StringBuilder();
		
		for(int t=1; t<=test; t++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			d= Integer.parseInt(st1.nextToken());
			w= Integer.parseInt(st1.nextToken());
			k= Integer.parseInt(st1.nextToken());
			
			board = new int[d][w];
			
			ans = k+1;
			
			for(int a=0; a<d; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				for(int b=0; b<w; b++)
				{
					board[a][b] = Integer.parseInt(st1.nextToken());
				}
			}
			
			
//			for(int a=0; a<=k; a++)
//			{
//				if(ans <= a) break;
//				func2(0, 0, a, -1);
//			}
			func(0, 0, -1, new int[3]);
			
			sb1.append("#" + t + " " + ans + "\n");
		}
		
		
		System.out.println(sb1.toString());
	}
	
	static void func2(int now, int cnt, int k_, int prev_a)
	{
		if(ans<=cnt)
		{
			return;
		}
		if(now == k_)
		{
			if(checking())
			{
				if(ans > cnt) ans = cnt;
			}
			return;
		}
		
		for(int a=prev_a+1; a<d; a++)
		{
			int[] temp_board = new int[w];
			for(int b=0; b< w; b++) temp_board[b] = board[a][b];
			
			for(int b=0; b< w; b++) board[a][b] = 0;
			func2(now+1, cnt+1, k_, a);
			
			for(int b=0; b< w; b++) board[a][b] = 1;
			func2(now+1, cnt+1, k_, a);
			
			for(int b=0; b< w; b++) board[a][b] = temp_board[b];
			
		}
		
	}
	
	//부분집합
	static void func(int now, int cnt, int prev_a, int[] arr)
	{
		for(int a=0; a<3; a++)
		{
			System.out.print(arr[a] + " ");
		}
		System.out.println();
		
//		if(ans <=cnt)
//		{
//			return;
//		}
//			
//		if(checking())
//		{
//			if(ans > cnt ) ans = cnt;
//			return;
//		}
		
		if(now==d)
		{
			System.out.println();
			return;
		}
		
		for(int a=prev_a+1; a<d; a++)
		{
			int[] temp_board = new int[w];
			
			for(int a1=0; a1<w; a1++)
			{
				temp_board[a1] = board[a][a1];
			}
			
			for(int a1=0; a1<w; a1++)
			{
				board[a][a1] = 0;
			}
			
			arr[a] = 1;
			func(now+1, cnt+1, a, arr);
			
			for(int a1=0; a1<w; a1++)
			{
				board[a][a1] = 1;
			}
			
			arr[a] = 2;
			func(now+1, cnt+1, a, arr);
			
			for(int a1=0; a1<w; a1++)
			{
				board[a][a1] = temp_board[a1];
			}
			arr[a] = 0;
			//func(now+1, cnt, a);
			
		}
		
	}
	
	
	static boolean checking()
	{
		for(int b=0; b<w; b++)
		{
			int tag=0;
			int prev = board[0][b];
			int cnt=1;
			if(cnt>=k) 
			{
				tag=1;
				break;
			}
			for(int a=1; a<d; a++)
			{
				int now = board[a][b];
				if(prev==now)
				{
					cnt++;
					if(cnt>=k) 
					{
						tag=1;
						break;
					}
				}
				else
				{
					cnt=1;
				}
				prev = board[a][b];
			}
			
			if(tag==0) return false;
		}
		
		return true;
	}

}
