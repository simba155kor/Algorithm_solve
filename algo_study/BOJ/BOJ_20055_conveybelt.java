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
			//1��Ʈ�� �� ĭ ���� �ִ� �κ��� �Բ� �� ĭ ȸ���Ѵ�.
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
			
			
			//2. ���� ���� ��Ʈ�� �ö� �κ�����, ��Ʈ�� ȸ���ϴ� �������� �� ĭ �̵��� �� �ִٸ� �̵��Ѵ�. ���� �̵��� �� ���ٸ� ������ �ִ´�.
			//�κ��� �̵��ϱ� ���ؼ��� �̵��Ϸ��� ĭ�� �κ��� ������, �� ĭ�� �������� 1 �̻� ���� �־�� �Ѵ�.
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
			
			
			//3.�ø��� ��ġ�� �ִ� ĭ�� �������� 0�� �ƴϸ� �ø��� ��ġ�� �κ��� �ø���.
			if(board[0][0]!=0)
			{
				robot[0] = 1;
				board[0][0]--;
			}
			
			//4. �������� 0�� ĭ�� ������ K�� �̻��̶�� ������ �����Ѵ�. �׷��� �ʴٸ� 1������ ���ư���.
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
