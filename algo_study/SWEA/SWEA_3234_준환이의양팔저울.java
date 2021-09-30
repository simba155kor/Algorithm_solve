package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
	
	static int N;
	static int[] board;
	static int ans;
	static int[] weight;
	
	static int cntt=0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			N = Integer.parseInt(br1.readLine());
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			
			board = new int[N];
			weight = new int[N];
			
			for(int a=0; a<N; a++)
			{
				board[a] = Integer.parseInt(st1.nextToken());
			}
			
			//perm(0, 0);
			perm2(0,0,0,0);
			
			System.out.println("#" + t + " " + ans);
			ans=0;
			
			
		}

	}
	
	public static void comb(int now, int right_sum, int left_sum)
	{
		if(right_sum > left_sum) return;
		if(now == N)
		{
			//cntt++;
			ans++;
			return;
		}
		
		comb(now+1, right_sum + board[weight[now]] , left_sum);
		comb(now+1, right_sum, left_sum + board[weight[now]]);
	}

	public static void perm(int now, int val)
	{
		if(now == N)
		{
			comb(0, 0 ,0);
			return;
		}
		
		for(int a=0; a<N; a++)
		{
			if((val & 1<<a) !=0) continue;
			weight[now]= a;
			perm(now+1 , val | 1<<a);
		}
	}
	
	public static void perm2(int now, int val, int left_sum, int right_sum)
	{
		if(right_sum > left_sum) return;
		
		if(now == N)
		{
			ans++;
			//comb(0, 0 ,0);
			return;
		}
		
		for(int a=0; a<N; a++)
		{ 
			if((val & 1<<a) !=0) continue;
//			weight[now]= a;
			perm2(now+1 , val | 1<<a, left_sum + board[a], right_sum);
			perm2(now+1 , val | 1<<a, left_sum, right_sum +board[a]);
		}
	}
}
