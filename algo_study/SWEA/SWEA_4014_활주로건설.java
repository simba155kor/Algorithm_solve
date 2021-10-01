package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	static int n, k;
	static int[][] board;
	static int[][] vis;

	static int[] dy = { -1, 0, 1, 0};
	static int[] dx = { 0, -1, 0, 1};
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int test = Integer.parseInt(st1.nextToken());
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			
			n = Integer.parseInt(st1.nextToken());
			k = Integer.parseInt(st1.nextToken());
			
			board = new int[n][n];
			vis = new int[n][n];
			
			for(int a=0; a<n; a++)
			{
				st1= new StringTokenizer(br1.readLine());
				for(int b=0; b<n; b++)
				{	
					board[a][b] = Integer.parseInt(st1.nextToken());
				}
			}
			
			
			int ans = func();
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	static int func()
	{
		for(int b=0; b<n; b++)
		{
			int temp = -1;
			int cnt=1;
			for(int a=n-1; a>=0; a--)
			{
				if(temp== -1)
				{
					temp = board[a][b];
					continue;
				}
				
				if(board[a][b]==temp)
				{
					cnt++;
				}
				else //층이 달라.
				{
					if(cnt >=k && board[a][b] == temp+1) // 활주로 가능
					{
						int temp_k = k;
						int tag=0;
						while(temp_k!=0)
						{
							if(vis[a+temp_k][b] !=0)
							{
								tag=1;
								break;
							}
							temp_k--;
						}
						
						if(tag==0)
						{
							temp_k = k;
							while(temp_k!=0)
							{
								vis[a+temp_k][b] = 1;
								temp_k--;
							}
						}
					}
					
					cnt=1;
				}
				
				temp = board[a][b];
			}
		}
		
		
		for(int b=0; b<n; b++)
		{
			int temp = -1;
			int cnt=1;
			for(int a=0; a<n; a++)
			{
				if(temp== -1)
				{
					temp = board[a][b];
					continue;
				}
				
				if(board[a][b]==temp)
				{
					cnt++;
				}
				else //층이 달라.
				{
					if(cnt >=k && board[a][b] == temp+1) // 활주로 가능
					{
						int temp_k = k;
						int tag=0;
						while(temp_k!=0)
						{
							if(vis[a-temp_k][b] !=0)
							{
								tag=1;
								break;
							}
							temp_k--;
						}
						
						if(tag==0)
						{
							temp_k = k;
							while(temp_k!=0)
							{
								vis[a-temp_k][b] = 2;
								temp_k--;
							}
						}
					}
					
					cnt=1;
				}
				
				temp = board[a][b];
			}
		}
		
		int ans=0;
		for(int b=0; b<n; b++)
		{
			int temp= board[0][b];
			int tag=0;
			for(int a=1; a<n; a++)
			{
				int now = board[a][b];
				if((temp-1 == now && vis[a][b]==1)
						|| (temp == now)
						|| (temp+1 == now && vis[a-1][b]==2)) 
				{
					temp = board[a][b];
					continue;
				}
				tag=1;
				break;
			}
			
			if(tag==0) ans++;
		}
		
	
		
		vis = new int[n][n];
		
		
		
		for(int a=0; a<n; a++)
		{
			int temp = -1;
			int cnt=1;
			for(int b=n-1; b>=0; b--)
			{
				if(temp== -1)
				{
					temp = board[a][b];
					continue;
				}
				
				if(board[a][b]==temp)
				{
					cnt++;
				}
				else //층이 달라.
				{
					if(cnt >=k && board[a][b] == temp+1) // 활주로 가능
					{
						int temp_k = k;
						int tag=0;
						while(temp_k!=0)
						{
							if(vis[a][b+temp_k] !=0)
							{
								tag=1;
								break;
							}
							temp_k--;
						}
						
						if(tag==0)
						{
							temp_k = k;
							while(temp_k!=0)
							{
								vis[a][b+temp_k] = 1;
								temp_k--;
							}
						}
						
					}
					
					cnt=1;
				}
				
				temp = board[a][b];
			}
		}
		
		
		for(int a=0; a<n; a++)
		{
			int temp = -1;
			int cnt=1;
			for(int b=0; b<n; b++)
			{
				if(temp== -1)
				{
					temp = board[a][b];
					continue;
				}
				
				if(board[a][b]==temp)
				{
					cnt++;
				}
				else //층이 달라.
				{
					if(cnt >=k && board[a][b] == temp+1) // 활주로 가능
					{
						int temp_k = k;
						int tag=0;
						while(temp_k!=0)
						{
							if(vis[a][b-temp_k] !=0)
							{
								tag=1;
								break;
							}
							temp_k--;
						}
						
						if(tag==0)
						{
							temp_k = k;
							while(temp_k!=0)
							{
								vis[a][b-temp_k] = 2;
								temp_k--;
							}
						}
					}
					
					cnt=1;
				}
				
				temp = board[a][b];
			}
		}
		
		
		
	
		for(int a=0; a<n; a++)
		{
			int temp= board[a][0];
			int tag=0;
			for(int b=1; b<n; b++)
			{
				int now = board[a][b];
				if((temp-1 == now && vis[a][b]==1)
						|| (temp == now)
						|| (temp+1 == now && vis[a][b-1]==2)) 
				{
					temp = board[a][b];
					continue;
				}
				
				tag=1;
				break;
			}
			
			if(tag==0) ans++;
		}
		
	
		
		
		return ans;
	}

}
