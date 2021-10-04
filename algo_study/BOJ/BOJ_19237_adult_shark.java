package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19237_adult_shark {

	//��, �Ʒ�, ����, ������
	static int[] dy=  {0, -1, 1, 0, 0};
	static int[] dx=  {0, 0, 0, -1, 1};
	
	static int n, m, k;
	//ù �ٿ��� N, M, k�� �־�����. (2 �� N �� 20, 2 �� M �� N2, 1 �� k �� 1,000)
	
	static int[][] board;
//	�� ���� �ٺ��� N���� �ٿ� ���� ������ ����� �־�����. 0�� ��ĭ�̰�, 0�� �ƴ� �� x�� x�� �� ����ִ� ĭ�� �ǹ��Ѵ�.
	
	//static int[] shark_now_dir;
//	�� ���� �ٿ��� �� ����� ������ ���ʴ�� �־�����. 1, 2, 3, 4�� ���� ��, �Ʒ�, ����, �������� �ǹ��Ѵ�.
	
	static int[][][] shark_want_dir;
	//�� ���� �ٺ��� �� ����� ���� �켱������ ��� �� 4�پ� ���ʴ�� �־�����. �� ���� 4���� ���� �̷���� �ִ�. �ϳ��� �� ��Ÿ���� �� �� �� ù ��° ���� �ش� �� ���� ���� ���� ���� �켱����, �� ��° ���� �Ʒ��� ���� ���� �켱����, �� ��° ���� ������ ���� ���� �켱����, �� ��° ���� �������� ���� ���� �켱�����̴�. �� �켱�������� 1���� 4������ �ڿ����� �� ���� ��Ÿ����. ���� ���� ������ ������ �ֿ켱�̴�. ���� ���, �켱������ 1 3 2 4���, ������ ������ ��, ����, �Ʒ�, �������̴�.
	
	static int[][][] vis;
	//���� ���� ��
	//��ȣ, �����ð�
	
	static int[][] shark;
	//��ȣ -> ��ǥ
	//���� ����
	//����
	
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
		//�ڱ� ��ġ ����
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
		//�̵�
		for(int a=1; a<=m; a++)
		{
			if(shark[a][3] == 0 ) continue;
			int now_y = shark[a][0];
			int now_x = shark[a][1];
			int now_dr = shark[a][2];
			
			//Ȯ��
			
			int tag=0;
			for(int dr=0; dr<4; dr++)
			{
				int next_dr = shark_want_dir[a][now_dr][dr];
				int next_y = now_y + dy[next_dr];
				int next_x = now_x + dx[next_dr];
				
				if(next_y <0 || next_x <0 || next_y>=n || next_x >=n) continue;
				
				if(vis[next_y][next_x][0] ==0)
				{
					//���� ���� ĭ�� �ֳ�
					now_y = next_y;
					now_x = next_x;
					now_dr = next_dr;
					
					tag=1;
					break;
				}
			}
			
			if(tag==0) // �� ���� ĭ����
			{
				for(int dr=0; dr<4; dr++)
				{
					int next_dr = shark_want_dir[a][now_dr][dr];
					int next_y = now_y + dy[next_dr];
					int next_x = now_x + dx[next_dr];
					
					if(next_y <0 || next_x <0 || next_y>=n || next_x >=n) continue;
					
					if(vis[next_y][next_x][0] ==a)
					{
						//�� ���� ĭ����
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
				//�� �� �ִٸ�
				shark[a][0] = now_y;
				shark[a][1] = now_x;
				shark[a][2] = now_dr;
				
//				vis[now_y][now_x][0] = a;
//				vis[now_y][now_x][1] = k;
			}
			
		}
		
		//�ڱ� ��ġ ����
		for(int a=1; a<=m; a++)
		{
			if(shark[a][3] == 0 ) continue;
			
			int now_y = shark[a][0];
			int now_x = shark[a][1];
			
			//����̾��� ���� �����
			if(vis[now_y][now_x][0] == 0) 
			{
				vis[now_y][now_x][0] = a;
				vis[now_y][now_x][1] = k;
			}
			else if(vis[now_y][now_x][0] == a) //�� ��������
			{
				vis[now_y][now_x][0] = a;
				vis[now_y][now_x][1] = k;				
			}
			else //�ٸ� ������ �ֳ�. �ٵ� �̹� ���� ��ȣ�� �����ų�
			{
				shark[a][3] = 0; // �׾�ߵ�.
			}
		}
		
		
		//���� -1 ���ֱ�
		
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
		
		//shark�� board�� ���� �����.
		return true;
	}

}
