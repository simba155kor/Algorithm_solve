package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19237_adult_shark {

	//위, 아래, 왼쪽, 오른쪽
	static int[] dy=  {0, -1, 1, 0, 0};
	static int[] dx=  {0, 0, 0, -1, 1};
	
	static int n, m, k;
	//첫 줄에는 N, M, k가 주어진다. (2 ≤ N ≤ 20, 2 ≤ M ≤ N2, 1 ≤ k ≤ 1,000)
	
	static int[][] board;
//	그 다음 줄부터 N개의 줄에 걸쳐 격자의 모습이 주어진다. 0은 빈칸이고, 0이 아닌 수 x는 x번 상어가 들어있는 칸을 의미한다.
	
	//static int[] shark_now_dir;
//	그 다음 줄에는 각 상어의 방향이 차례대로 주어진다. 1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
	
	static int[][][] shark_want_dir;
	//그 다음 줄부터 각 상어의 방향 우선순위가 상어 당 4줄씩 차례대로 주어진다. 각 줄은 4개의 수로 이루어져 있다. 하나의 상어를 나타내는 네 줄 중 첫 번째 줄은 해당 상어가 위를 향할 때의 방향 우선순위, 두 번째 줄은 아래를 향할 때의 우선순위, 세 번째 줄은 왼쪽을 향할 때의 우선순위, 네 번째 줄은 오른쪽을 향할 때의 우선순위이다. 각 우선순위에는 1부터 4까지의 자연수가 한 번씩 나타난다. 가장 먼저 나오는 방향이 최우선이다. 예를 들어, 우선순위가 1 3 2 4라면, 방향의 순서는 위, 왼쪽, 아래, 오른쪽이다.
	
	static int[][][] vis;
	//냄새 위한 거
	//번호, 남은시간
	
	static int[][] shark;
	//번호 -> 좌표
	//지금 방향
	//생존
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		k = Integer.parseInt(st1.nextToken());

		board = new int[n][n];
		//shark_now_dir = new int[m+1];
		shark_want_dir = new int[m+1][5][4];
		shark = new int[m+1][4];
		vis = new int[n][n][2];

		for(int a=0; a<n;a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<n; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] ==0) continue;
				shark[board[a][b]][0] = a;
				shark[board[a][b]][1] = b;
			}
		}
		
		st1 = new StringTokenizer(br1.readLine());
		for(int a=1; a<=m; a++)
		{
			shark[a][2] = Integer.parseInt(st1.nextToken());
			shark[a][3] = 1;
		}
		
		for(int a=1; a<=m; a++)
		{
			for(int b=1; b<=4; b++)
			{
				st1 = new StringTokenizer(br1.readLine());
				for(int c=0; c<4; c++)
				{
					shark_want_dir[a][b][c] = Integer.parseInt(st1.nextToken());					
				}
			}
		}
		
		int ans=0;
		while(ans <=1000)
		{
			if(!func()) break;
			ans++;
		}
		
		if(ans==1001) ans = -1;
		System.out.println(ans);
	}
	
	
	static boolean func()
	{
		int check1=0;
		//자기 위치 냄새
		for(int a=1; a<=m; a++)
		{
			if(shark[a][3] == 0 ) continue;
			int now_y = shark[a][0];
			int now_x = shark[a][1];
			
			vis[now_y][now_x][0] = a;
			vis[now_y][now_x][1] = k;
			
			check1++;
		}
		
		if(check1==1) return false;
		//이동
		for(int a=1; a<=m; a++)
		{
			if(shark[a][3] == 0 ) continue;
			int now_y = shark[a][0];
			int now_x = shark[a][1];
			int now_dr = shark[a][2];
			
			//확인
			
			int tag=0;
			for(int dr=0; dr<4; dr++)
			{
				int next_dr = shark_want_dir[a][now_dr][dr];
				int next_y = now_y + dy[next_dr];
				int next_x = now_x + dx[next_dr];
				
				if(next_y <0 || next_x <0 || next_y>=n || next_x >=n) continue;
				
				if(vis[next_y][next_x][0] ==0)
				{
					//냄새 없는 칸이 있네
					now_y = next_y;
					now_x = next_x;
					now_dr = next_dr;
					
					tag=1;
					break;
				}
			}
			
			if(tag==0) // 내 냄새 칸으로
			{
				for(int dr=0; dr<4; dr++)
				{
					int next_dr = shark_want_dir[a][now_dr][dr];
					int next_y = now_y + dy[next_dr];
					int next_x = now_x + dx[next_dr];
					
					if(next_y <0 || next_x <0 || next_y>=n || next_x >=n) continue;
					
					if(vis[next_y][next_x][0] ==a)
					{
						//내 냄새 칸으로
						now_y = next_y;
						now_x = next_x;
						now_dr = next_dr;
						
						tag=1;
						break;
					}
				}
				
			}
			
			if(tag==1)
			{
				//갈 수 있다면
				shark[a][0] = now_y;
				shark[a][1] = now_x;
				shark[a][2] = now_dr;
				
//				vis[now_y][now_x][0] = a;
//				vis[now_y][now_x][1] = k;
			}
			
		}
		
		//자기 위치 냄새
		for(int a=1; a<=m; a++)
		{
			if(shark[a][3] == 0 ) continue;
			
			int now_y = shark[a][0];
			int now_x = shark[a][1];
			
			//빈곳이었네 냄새 남기기
			if(vis[now_y][now_x][0] == 0) 
			{
				vis[now_y][now_x][0] = a;
				vis[now_y][now_x][1] = k;
			}
			else if(vis[now_y][now_x][0] == a) //내 냄새였네
			{
				vis[now_y][now_x][0] = a;
				vis[now_y][now_x][1] = k;				
			}
			else //다른 냄새가 있네. 근데 이미 작은 번호가 먹은거네
			{
				shark[a][3] = 0; // 죽어야돼.
			}
		}
		
		
		//냄새 -1 해주기
		
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<n; b++)
			{
				if(vis[a][b][0]>0)
				{
					vis[a][b][1]--;
					if(vis[a][b][1]==0)
					{
						vis[a][b][0] = 0;
						vis[a][b][1] = 0;
					}
				}
			}
		}
		
		//shark랑 board랑 같게 만들기.
		return true;
	}

}
