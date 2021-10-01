package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class fireball
{
	// ri, ci, mi, si, di
	int y, x, mass, speed, dir;
	
	public fireball( int y, int x, int mass, int speed, int dir) 
	{
		this.y = y;
		this.x = x;
		this.mass = mass;
		this.speed = speed;
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return y + " , " + x + " , " + mass + " , " + speed + " , " + dir; 
	}
	
}

public class BOJ_20056_magician_shark_and_fireball {
		
	static int n,m,k;
	static ArrayList<fireball> balls;
	
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException{
		
		System.setIn( new FileInputStream("res/input.txt"));
		
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		k = Integer.parseInt(st1.nextToken());
		
		balls = new ArrayList<fireball>();
		
		for(int a=0; a<m; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			int a1 = Integer.parseInt(st1.nextToken())-1;
			int a2 = Integer.parseInt(st1.nextToken())-1;
			int a3 = Integer.parseInt(st1.nextToken());
			int a4 = Integer.parseInt(st1.nextToken());
			int a5 = Integer.parseInt(st1.nextToken());
			
			fireball temp = new fireball(a1, a2, a3, a4, a5);
			
			balls.add(temp);
		}
		
//		for(int b=0; b<m; b++)
//		{
//			System.out.println(balls.get(b));
//		}
		
		//System.out.println(balls.get(0));
		
		//k번 반복
		for(int a=0; a<k; a++)
		{
			
			func();
			
			//System.out.println(balls.get(0));
		}
		
		int ans=0;
		for(int a=0; a<balls.size(); a++)
		{
			ans += balls.get(a).mass;
		}
		
		System.out.println(ans);
	}
	
	
	static void func()
	{
		//질량합 속력합 개수합
		int[][][] board= new int[n][n][5];
		
//		모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
//		이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
		for(int a=0; a<balls.size(); a++)
		{
			fireball now = balls.get(a);
			
			int low_speed = now.speed % n;
			int now_y = now.y + dy[now.dir]*low_speed;
			int now_x = now.x + dx[now.dir]*low_speed;
			
			now_y += n; now_y %=n;
			now_x += n; now_x %=n;
			
			board[now_y][now_x][0] += now.mass;
			board[now_y][now_x][1] += now.speed;
			board[now_y][now_x][2] ++;
			board[now_y][now_x][4] = now.dir;
			if(board[now_y][now_x][3] == 0)
			{
				if(now.dir %2 ==0) board[now_y][now_x][3] = 1;
				if(now.dir %2 ==1) board[now_y][now_x][3] = 2;
			}
			else
			{
				if(now.dir %2 ==0 && board[now_y][now_x][3] == 2) board[now_y][now_x][3] = 3;
				if(now.dir %2 ==1 && board[now_y][now_x][3] == 1) board[now_y][now_x][3] = 3;
			}
		}
		
		balls.clear();
		
		for(int a=0; a<n; a++)
		{
			for(int b=0; b<n; b++)
			{
				if(board[a][b][2]==0) continue;
				if(board[a][b][2]==1)
				{
					balls.add(new fireball(a,b,board[a][b][0],board[a][b][1], board[a][b][4]));
				}
				else
				{
					int temp_mass = board[a][b][0]/5;
					if(temp_mass ==0)continue;
					
					int temp_speed = board[a][b][1]/board[a][b][2];
					
					if(board[a][b][3] == 3)
					{
						//1 3 5 7
						balls.add(new fireball(a,b,temp_mass,temp_speed,1));
						balls.add(new fireball(a,b,temp_mass,temp_speed,3));
						balls.add(new fireball(a,b,temp_mass,temp_speed,5));
						balls.add(new fireball(a,b,temp_mass,temp_speed,7));
					}
					else
					{
						//0 2 4 6
						balls.add(new fireball(a,b,temp_mass,temp_speed,0));
						balls.add(new fireball(a,b,temp_mass,temp_speed,2));
						balls.add(new fireball(a,b,temp_mass,temp_speed,4));
						balls.add(new fireball(a,b,temp_mass,temp_speed,6));
					}
				}
			}
		}
		


	}

}
