package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static int n;
	static int[][] board;
	static int real_ans;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		
		board = new int[n][2];
		
		for(int a=0; a<n; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			board[a][0] = Integer.parseInt(st1.nextToken());
			board[a][1] = Integer.parseInt(st1.nextToken());
		}
		
		
		dfs(0, 0);
		
		System.out.println(real_ans);
	}

	static void dfs(int now, int sum)
	{
		if(now>=n)
		{
			if(real_ans < sum) real_ans = sum;
			return;
		}
		
		if(now+board[now][0]<=n)
		{
			dfs(now+board[now][0], sum + board[now][1]);			
		}
		
		dfs(now+1, sum);
		
	}
	
}
