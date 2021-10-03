package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19236_young_shark {

	static int[][] num;
	static int[][] dir;
	
	//↑, ↖, ←, ↙, ↓, ↘, →, ↗ 
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	static int[][] arr1; // 번호, 좌표+ 방향 + 살아있는지
	
	static int real_ans;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1;
		
		num = new int[4][4];
		dir = new int[4][4];
		arr1 = new int[17][4];
		
		for(int a=0; a<4; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			
			for(int b=0; b<4; b++)
			{
				num[a][b] = Integer.parseInt(st1.nextToken());
				dir[a][b] = Integer.parseInt(st1.nextToken());
				arr1[num[a][b]][0] = a;
				arr1[num[a][b]][1] = b;
				arr1[num[a][b]][2] = dir[a][b];
				arr1[num[a][b]][3] = 0;
			}
		}
		
		func(0, 0, num[0][0], dir[0][0]);
		
		System.out.println(real_ans);
	}

	
	static void func(int y, int x, int ans, int now_dr)
	{
		//System.out.println(y + " , " + x);
		if(real_ans < ans) real_ans = ans;
		
		int[][] temp_num = new int[4][4];
		int[][] temp_dir = new int[4][4];
		
		int[][] temp_arr1 = new int[17][4];
		
		for(int a=0; a<4; a++)
		{
			for(int b=0; b<4; b++)
			{
				temp_num[a][b] = num[a][b];
				temp_dir[a][b] = dir[a][b];
			}
		}
		
		for(int a=1; a<=16; a++)
		{
			for(int b=0; b<4; b++)
			{
				temp_arr1[a][b] = arr1[a][b];
			}
		}
		
		
		moving(y, x, num[y][x]);
		
		int yy = y;
		int xx = x;
		
		while(true)
		{
			yy+=dy[now_dr];
			xx+=dx[now_dr];
			
			if(yy<0 || xx<0 || yy>=4 || xx>=4) break;
			if(num[yy][xx] == 0) continue;
			
			func(yy, xx, ans+num[yy][xx], dir[yy][xx]);
			
		}
		
		for(int a=0; a<4; a++)
		{
			for(int b=0; b<4; b++)
			{
				num[a][b] = temp_num[a][b];
				dir[a][b]= temp_dir[a][b];
			}
		}
		
		for(int a=1; a<=16; a++)
		{
			for(int b=0; b<4; b++)
			{
				arr1[a][b] = temp_arr1[a][b];
			}
		}
		
		
	}
	
	static void moving(int shark_y, int shark_x, int eat_num)
	{
		//그 위치에 있는 상어를 먹어야해.
		for(int a=0; a<4; a++)
		{
			if(a!=3)arr1[eat_num][a] = 0;	
			else arr1[eat_num][a] = 1;
		}
		
		num[shark_y][shark_x] = 0;
		dir[shark_y][shark_x] = 0;
		
		
		for(int a=1; a<=16; a++)
		{
			if(arr1[a][3] == 1) continue;
			
			int now_y = arr1[a][0];
			int now_x = arr1[a][1];
			int now_dr = arr1[a][2];
			
			//if(a==13) System.out.println(now_dr+"!");
			
			int cnt=0;
			int tag=0;
			while(cnt<8)
			{
				cnt++;
				int next_y = now_y + dy[now_dr];
				int next_x = now_x + dx[now_dr];
				
				//돌려야해
				if(next_y <0 || next_x <0 || next_y>=4 || next_x >=4)
				{
					now_dr++;
					if(now_dr !=8) now_dr %= 8;
					continue;
				}
				
				//돌려야해
				if(next_y == shark_y && next_x == shark_x)
				{
					now_dr++;
					if(now_dr !=8) now_dr %= 8;
					continue;
				}
				
				
				tag=1;
				break;
			}
			
			//움직일 수 있다. 서로 바꿔주기.
			if(tag==1)
			{
				int next_y = now_y + dy[now_dr];
				int next_x = now_x + dx[now_dr];
				int next_num = num[next_y][next_x];
				int next_dir = dir[next_y][next_x];
				
				//System.out.println(a + "가 " + next_y + " ,  " + next_x + "로 간다.");
				
//				int[] temp = new int[4];
//				for(int a1=0; a1<4; a1++) temp[a1] = arr1[num[next_y][next_x]][a1];
//				for(int a1=0; a1<4; a1++) arr1[num[next_y][next_x]][a1] = arr1[a][a1];
//				for(int a1=0; a1<4; a1++) arr1[a][a1] = temp[a1];
				
				if(next_num==0)
				{
					
				}
				else
				{
					arr1[next_num][0] = now_y;
					arr1[next_num][1] = now_x;
					arr1[next_num][2] = next_dir;
					arr1[next_num][3] = 0;
				}
				
				arr1[a][0] = next_y;
				arr1[a][1] = next_x;
				arr1[a][2] = now_dr;
				arr1[a][3] = 0;
						
				num[next_y][next_x] = a;
				num[now_y][now_x] = next_num;
				dir[next_y][next_x] = now_dr;
				dir[now_y][now_x] = next_dir;
				
			}
			
//			for(int a1=0; a1<4; a1++)
//			{
//				for(int b=0; b<4; b++)
//				{
//					System.out.print(num[a1][b] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println("------");
//			for(int a1=0; a1<4; a1++)
//			{
//				for(int b=0; b<4; b++)
//				{
//					System.out.print(dir[a1][b] + " ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
			
		}
		
//		for(int a =1; a<=16; a++)
//		{
//			int now_y = arr1[a][0];
//			int now_x = arr1[a][1];
//			int now_dr = arr1[a][2];
//			int now_live = arr1[a][3];
//			
//			if(now_live == 1) 
//			{
//				num[now_y][now_x] = 0;
//				dir[now_y][now_x] = 0;
//			}
//			else
//			{
//				num[now_y][now_x] = a;
//				dir[now_y][now_x] = now_dr;
//			}
//			
//		}
		
		
		//System.out.println();
	}
	
}
