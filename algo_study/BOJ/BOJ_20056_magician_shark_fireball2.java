package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20056_magician_shark_fireball2 {

	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	//ù° �ٿ� N, M, K�� �־�����.
	static int n,m,k;
	
	//��° �ٺ��� M���� �ٿ� ���̾�� ������ �� �ٿ� �ϳ��� �־�����. ���̾�� ������ �ټ� ���� ri, ci, mi, si, di�� �̷���� �ִ�.
	static ArrayList<int[]> fireballs;
	//��ȣ, y + x + mass + speed + direction
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		k = Integer.parseInt(st1.nextToken());
		
		fireballs = new ArrayList<int[]>();
		
		for(int a=0; a<m; a++)
		{
			//ri, ci, mi, si, di
			st1 = new StringTokenizer(br1.readLine());
			fireballs.add(new int[] {Integer.parseInt(st1.nextToken()) -1, Integer.parseInt(st1.nextToken()) -1, Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())});
		}
		
		for(int a=0; a<k; a++)
		{
			func();
		}
		
		int ans=0;
		for(int a=0; a<fireballs.size(); a++)
		{
			ans+= fireballs.get(a)[2];
		}
		
		System.out.println(ans);
	}

	static void func()
	{
		int[][][] temp_board = new int[n][n][5];//����, ������, �ӷ���, ����
		// 1�� ���� N���� ����Ǿ� �ְ�, 1�� ���� N�� ���� ����Ǿ� �ִ�.
		//ri, ci, mi, si, di
		for(int a=0; a<fireballs.size(); a++)
		{
			int now_y = fireballs.get(a)[0];
			int now_x = fireballs.get(a)[1];
			int now_speed = fireballs.get(a)[3];
			int now_dr = fireballs.get(a)[4];
			
			int next_y = now_y + dy[now_dr]*now_speed;
			int next_x = now_x + dx[now_dr]*now_speed;
			next_y %= n;
			next_x %= n;
			if(next_y<0) next_y +=n;
			if(next_x<0) next_x +=n;
			
			temp_board[next_y][next_x][0]++;
			temp_board[next_y][next_x][1] += fireballs.get(a)[2];
			temp_board[next_y][next_x][2] += fireballs.get(a)[3];
			temp_board[next_y][next_x][4] = now_dr;
			if(temp_board[next_y][next_x][3] == 0)
			{
				if(now_dr%2==0) temp_board[next_y][next_x][3] =1;
				if(now_dr%2==1) temp_board[next_y][next_x][3] =2;
			}
			else
			{
				if(temp_board[next_y][next_x][3] ==1 && now_dr%2==1) temp_board[next_y][next_x][3] =3;
				if(temp_board[next_y][next_x][3] ==2 && now_dr%2==0) temp_board[next_y][next_x][3] =3;
			}
		}
		
		fireballs.clear();
		//�̵� �� ����.
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<n; b++)
			{
				if(temp_board[a][b][0] ==0) continue;
				else if(temp_board[a][b][0] ==1) //ri, ci, mi, si, di
				{//����, ������, �ӷ���, ����
					fireballs.add(new int[] {a, b, temp_board[a][b][1], temp_board[a][b][2], temp_board[a][b][4]});
				}
				else // �������� ���
				{
					int temp_mass = temp_board[a][b][1]/5;
					if(temp_mass ==0 ) continue;
					
					int temp_speed = temp_board[a][b][2]/temp_board[a][b][0];
					
					if(temp_board[a][b][3] == 3) // 1 3 5 7
					{
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 1});
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 3});
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 5});
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 7});
					}
					else
					{
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 0});
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 2});
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 4});
						fireballs.add(new int[] {a, b, temp_mass, temp_speed, 6});
					}
				}
				
				
			}
		}
		
		
	}
	
}
