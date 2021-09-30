package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JungOl_1681_hamilton {
	
	static int n;
	static int[][] board;
	static int real_ans = 1201;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		n = Integer.parseInt(br1.readLine());
		
		board = new int[n][n];
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<n; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] ==0 && a!=b) board[a][b] = 1201;
			}
		}

		
		dfs(0, 0, 0, 0);
		
		System.out.println(real_ans);
	}
	
	static void dfs(int now, int ans, int val, int prev_a)
	{
		if(ans> real_ans ) return;
		
		if(now == n-1)
		{
			ans+= board[prev_a][0];
			if(ans < real_ans) real_ans = ans;
			return;
		}
		
		
		for(int a=1; a<n; a++)
		{
			if((val & 1<<a) != 0) continue; //이미 방문했다는 것.
			if(board[prev_a][a] == 0 ) continue; // 그 길이 없는애야.
			
			dfs(now+1, ans+ board[prev_a][a], val | 1<<a , a);
		}
		
	}

}



