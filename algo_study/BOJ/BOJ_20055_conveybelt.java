package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_conveybelt {
	
	static int n,k;
	static int[][] board;
	
	static int[] robot;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		k = Integer.parseInt(st1.nextToken());
		
		st1 = new StringTokenizer(br1.readLine());
		
		board = new int[n][2];
		robot = new int[n];
		
		for(int a=0; a<n; a++)
		{
			board[a][0] = Integer.parseInt(st1.nextToken());
		}
		for(int a=2*n-1; a>=n; a--)
		{
			board[a-n][1] = Integer.parseInt(st1.nextToken());
		}
		
		int time=0;
		
		while(true)
		{
			//1벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			int temp1 = board[0][1];
			int temp2 = board[n-1][0];
			for(int a=n-1; a>0; a--)
			{
				board[a][0] = board[a-1][0];
				robot[a] = robot[a-1];
			}
			for(int a=0; a<n-1; a++)
			{
				board[a][1] = board[a+1][1];
			}
			board[0][0] = temp1;
			board[n-1][1] = temp2;
			robot[0] = 0;
			
			
			//2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			//로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			robot[n-1] =0;
			for(int a=n-1; a>0; a--)
			{
				if(robot[a-1]==0) continue;
				
				if(robot[a] !=0) continue;
				if(board[a][0] ==0) continue;
				
				robot[a] = robot[a-1];
				robot[a-1]=0;
				board[a][0]--;
			}
			
			
			//3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(board[0][0]!=0)
			{
				robot[0] = 1;
				board[0][0]--;
			}
			
			//4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			int cnt =0;
			for(int a=0; a<n; a++)
			{
				for(int b=0; b<2; b++)
				{
					if(board[a][b] == 0) cnt++;
				}
			}
			
			time++;
			if(cnt >=k) break;
		}
		
		System.out.println(time);
	}

}
