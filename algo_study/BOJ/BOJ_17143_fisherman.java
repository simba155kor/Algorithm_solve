package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class shark implements Comparable<shark>
{
	int y,x;
	int speed;
	int dir;
	int z;
	
	public shark(int y, int x, int speed, int dir, int z) {
		this.y =y;
		this.x = x;
		this.speed = speed;
		this.dir = dir;
		this.z = z;
	}
	
	public int compareTo(shark o1)
	{
		if(y < o1.y) return -1;
		else if(y== o1.y)
		{
			if(x<o1.x) return -1;
			else if(x==o1.x)
			{
				if(z < o1.z) return -1;
			}
		}
		
		return 1;
	}
	
	@Override
	public String toString() {
		return z+"";
	}
}

public class BOJ_17143_fisherman {
	
	static int n,m, cnt;
	static shark[][] board;
	static ArrayList<shark> list1;
	
	
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1= new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		cnt = Integer.parseInt(st1.nextToken());
		
		
		list1 = new ArrayList<shark>();
		
		for(int a=0; a<cnt; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int a1 = Integer.parseInt(st1.nextToken());
			int a2 = Integer.parseInt(st1.nextToken());
			int a3 = Integer.parseInt(st1.nextToken());
			int a4 = Integer.parseInt(st1.nextToken());
			int a5 = Integer.parseInt(st1.nextToken());
			if(a4 ==1 || a4 == 2)
			{
				a3%= (2*n-2);
			}
			if(a4 ==3 || a4 == 4)
			{
				a3%= (2*m-2);
			}
			shark s1 = new shark(a1-1, a2-1, a3, a4, a5);
			
			list1.add(s1);
		}
		
	
		
		int ans= func();
		
		System.out.println(ans);
		
	}
	
	static int func()
	{
		int ans =0;
		
		for(int b=0; b<m; b++)
		{
			Collections.sort(list1);
			board = new shark[n][m];
			
			for(int a=0; a<list1.size(); a++)
			{
				shark now_s = list1.get(a);
				board[now_s.y][now_s.x] = now_s;
			}
			
//			for(int a=0; a<n; a++)
//			{
//				for(int b1=0; b1<m; b1++)
//				{
//					System.out.print(board[a][b1] + " ");
//				}
//				System.out.println();
//			}
			
			for(int a=0; a<n; a++)
			{
				if(board[a][b] != null)
				{
					ans+= board[a][b].z;
					board[a][b] = null;
					break;
				}
			}
			
//			for(int a=0; a<n; a++)
//			{
//				for(int b1=0; b1<m; b1++)
//				{
//					System.out.print(board[a][b1] + " ");
//				}
//				System.out.println();
//			}
			
			
			list1.clear();
			
			//이동
			
			for(int a=0; a<n; a++)
			{
				for(int b1=0; b1<m; b1++)
				{
					if(board[a][b1] != null)
					{
						shark now_s = board[a][b1];
						
						//System.out.println(now_s.y + " , " + now_s.x + "가");
						
						int temp = now_s.speed;
						int yy = now_s.y;
						int xx = now_s.x;
						int now_dr = now_s.dir;
						while(temp!=0)
						{
							yy += dy[now_dr];
							xx += dx[now_dr];
							if(yy<0 || xx<0|| yy>= n || xx>=m)
							{
								if(now_dr == 1) now_dr =2;
								else if(now_dr == 2) now_dr =1;
								else if(now_dr == 3) now_dr =4;
								else if(now_dr == 4) now_dr =3;
								
								yy+=dy[now_dr];
								xx+=dx[now_dr];
								yy+=dy[now_dr];
								xx+=dx[now_dr];
							}
							temp--;
						}
						
						//System.out.println(yy + " , " + xx +"로");
						shark s2 = new shark(yy, xx, now_s.speed, now_dr, now_s.z);
						list1.add(s2);
					}
				}
			}
			
		}
		
		
		
		return ans;
	}

}
