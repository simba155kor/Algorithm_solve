package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288_주사위_굴리기_2 {

	//위로, 왼쪽으로, 아래로, 오른쪽으로
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int now_dr = 3;
	
	static int n,m,k;
	static int[][] board;
	
	//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
	static int[] dice;
	
	static int now_y, now_x;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		k = Integer.parseInt(st1.nextToken());
		
		board = new int[n][m];
		
		for(int a=0; a<n; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			for(int b=0; b<m; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
			}
		}
		
		//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
		dice = new int[6];
		dice[0] = 1;
		dice[1] = 6;
		dice[2] = 5;
		dice[3] = 2;
		dice[4] = 4;
		dice[5] = 3;
		
		int ans= 0;
		
		for(int a=0; a<k; a++)
		{
			//1. 이동한다.
			//만약 칸이 없다면 이동방향 반대로 한다음에 굴러간다.
			int yy = now_y + dy[now_dr];
			int xx = now_x + dx[now_dr];
			if(yy<0 || xx<0 || yy>=n || xx>=m)
			{
				now_dr +=2;
				now_dr%=4;
				yy = now_y + dy[now_dr];
				xx = now_x + dx[now_dr];
			}
			
			now_y = yy;
			now_x = xx;
			//주사위 위치 변경
			//위로, 왼쪽으로, 아래로, 오른쪽으로
			
			int[] temp_dice = new int[6];
			//주사위
			//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
			if(now_dr ==0)
			{
				//위->뒷면
				//정면-> 위
				//아래 -> 정면
				//뒷면 -> 아래
				temp_dice[3] = dice[0];
				temp_dice[0] = dice[2];
				temp_dice[2] = dice[1];
				temp_dice[1] = dice[3];
				
				temp_dice[4] = dice[4];
				temp_dice[5] = dice[5];
			}
			//왼쪽으로
			else if(now_dr ==1)
			{
				//위->왼쪽
				//왼쪽-> 아래
				//아래 -> 오른쪽
				//오른쪽 -> 위쪽
				//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
				temp_dice[4] = dice[0];
				temp_dice[1] = dice[4];
				temp_dice[5] = dice[1];
				temp_dice[0] = dice[5];
				
				temp_dice[2] = dice[2];
				temp_dice[3] = dice[3];
			}
			//아래로
			else if(now_dr ==2)
			{
				//위->정면
				//정면-> 아래
				//아래 -> 뒤쪽
				//뒤쪽 -> 위쪽
				//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
				temp_dice[2] = dice[0];
				temp_dice[1] = dice[2];
				temp_dice[3] = dice[1];
				temp_dice[0] = dice[3];
				
				temp_dice[4] = dice[4];
				temp_dice[5] = dice[5];
			}
			//오른쪽으로
			else if(now_dr ==3)
			{
				//위->오른쪽
				//오른쪽-> 아래
				//아래 -> 왼쪽
				//왼쪽 -> 위
				
				//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
				temp_dice[5] = dice[0];
				temp_dice[1] = dice[5];
				temp_dice[4] = dice[1];
				temp_dice[0] = dice[4];
				
				temp_dice[2] = dice[2];
				temp_dice[3] = dice[3];
			}
			
			
			for(int b=0; b<6; b++) dice[b] = temp_dice[b];
			
			
			
			//2.주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
			
			
			int temp_cnt = bfs(now_y, now_x);
			temp_cnt *= board[now_y][now_x];
			
			ans+= temp_cnt;
			
			
			//3.주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다.
			//A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
			//A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
			//A = B인 경우 이동 방향에 변화는 없다.
			
			if(board[now_y][now_x] < dice[1]) now_dr--;
			else if(board[now_y][now_x] > dice[1]) now_dr++;
				
			if(now_dr<0) now_dr+=4;
			now_dr%=4;
			
			
			//위, 아래, 정면, 뒷면, 왼쪽면, 오른쪽면
//			for(int b=0; b<6; b++) System.out.print(dice[b] + " ");
//			System.out.println();
//			System.out.println(now_y + " , " + now_x + " , " + now_dr);
//			System.out.println("------\n");
			
		}
		
		System.out.println(ans);
	}

	
	static int bfs(int y, int x)
	{
		int val = board[y][x];
		int cnt =0;
		
		int[][] vis = new int[n][m];
		
		Queue<int[]> Q1 = new LinkedList<int[]>();
		
		Q1.offer(new int[] {y, x});
		vis[y][x] = 1;
		
		while(!Q1.isEmpty())
		{
			int[] cur = Q1.poll();
			cnt++;
			
			for(int dr=0; dr<4; dr++)
			{
				int yy = cur[0] + dy[dr];
				int xx = cur[1] + dx[dr];
				
				if(yy<0 || xx<0 || yy>=n || xx>=m) continue;
				
				if(vis[yy][xx]>0) continue;
				
				if(board[yy][xx] != val) continue;
				
				Q1.offer(new int[] {yy,xx});
				vis[yy][xx] = 1;
			}
		}
		
		
		return cnt;
	}
	
}
