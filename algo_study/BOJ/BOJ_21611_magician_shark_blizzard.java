package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21611_magician_shark_blizzard {

	static int n, m;
	static int[][] board;
	static int[][] magic;
	static ArrayList<Integer> list1;
	//상 하 좌 우
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	
	static int ans =0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		
		board = new int[n][n];
		
		for(int a=0; a<n; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			for(int b=0; b<n; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
			}
		}
		
		magic = new int[m][2];
		
		
		for(int a=0; a<m; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			magic[a][0] = Integer.parseInt(st1.nextToken());
			magic[a][1] = Integer.parseInt(st1.nextToken());
			
			func(a);
		}
		
		System.out.println(ans);
	}
	
	
	static void func(int idx)
	{
		//구슬 파괴
		int temp_cnt = magic[idx][1];
		int temp_dr = magic[idx][0];
		int now_y = n/2;
		int now_x = n/2;
		
		//구슬 파괴
		while(temp_cnt!=0)
		{
			now_y += dy[temp_dr];
			now_x += dx[temp_dr];
			
			if(now_y <0 || now_x <0 || now_y >=n || now_x >=n) break;
			
			board[now_y][now_x] = 0;
			temp_cnt--;
		}
		
		//파괴 완료
		
//		for(int a=0; a<n; a++)
//		{
//			for(int b=0; b<n; b++)
//			{
//				System.out.print(board[a][b] + " ");
//			}
//			System.out.println();
//		}
		
		
		//큐에 넣기.
//		Queue<Integer> Q1 = new LinkedList<Integer>();
		
		//스택에 넣고 4개인지 바로 보면 되겠다.
		//Stack<Integer> Q1 = new Stack<Integer>();
		
		//계속해야해.
		list1 = new ArrayList<Integer>();
		
		int[] dy_2 = new int[] {0, 1, 0, -1};
		int[] dx_2 = new int[] {-1, 0, 1, 0};
		
		now_y = n/2;
		now_x = n/2;
		int now_dr = 0;
		int tag=0;
		int how_cnt=1;
		int check_cnt=0;
		
		while(true)
		{
			now_y += dy_2[now_dr];
			now_x += dx_2[now_dr];
			
			//System.out.println(now_y + " , " + now_x + " : ");
			
			if(now_y <0 || now_x <0 || now_y >=n || now_x >=n) break;
			
			if(board[now_y][now_x]!=0)
			{
				list1.add(board[now_y][now_x]);
			}
			check_cnt++;
			
			if(check_cnt == how_cnt)
			{
				now_dr++;
				now_dr %=4;
				tag++;
				check_cnt=0;
			}
			
			if(tag==2)
			{
				how_cnt++;
				tag=0;
			}
		}
		

//		for(int a=0, end=list1.size(); a<end; a++){
//			System.out.print(list1.get(a) + " ");
//		}
//		
//		System.out.println();
		while(erase1())
		{
			
		}
		
//		for(int a=0, end=list1.size(); a<end; a++){
//			System.out.print(list1.get(a) + " ");
//		}
//			
//		System.out.println();
		func3();
		
	}

	static boolean erase1()
	{
		int tag=0;
		int cnt=1;
		int prev = -1;
		
		for(int a=list1.size()-1, end=0; a>=end; a--)
		{
			if(prev==-1) prev = list1.get(a);
			else
			{
				if(prev == list1.get(a))
				{
					cnt++;
				}
				else
				{
					if(cnt>=4)
					{
						tag=1;
						int temp_ans = list1.get(a+cnt) * cnt;
						ans += temp_ans;
						while(cnt>0)
						{
									
							list1.remove(a+cnt);
							cnt--;
							
							
						}
					}
					cnt=1;
					prev = list1.get(a);
				}
				
			}
		}
		
		if(cnt>=4)
		{
			tag=1;
			int temp_ans = list1.get(-1+cnt) * cnt;
			ans += temp_ans;
			while(cnt>0)
			{
				list1.remove(-1+cnt);
				cnt--;
			}
		}
		
		
		if(tag==1) return true;
		else return false;
		
	}
	
	static void func3()
	{
		if(list1.size()==0) return;
			
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		int prev=list1.get(0);
		int cnt =0;
		
		for(int a=0, end = list1.size(); a<end; a++)
		{
			int now = list1.get(a);
			
			if(now==prev)
			{
				cnt++;
			}
			else
			{
				list2.add(cnt);
				list2.add(prev);
				prev = now;
				cnt=1;
			}
			
		}
		
		list2.add(cnt);
		list2.add(prev);
		
//		for(int a=0; a<list2.size(); a++)
//		{
//			System.out.print(list2.get(a) + " ");
//		}
		
		
		board = new int[n][n];
		
		int now_y = n/2;
		int now_x = n/2;
		int now_dr = 0;
		int tag=0;
		int how_cnt=1;
		int check_cnt=0;
		
		int[] dy_2 = new int[] {0, 1, 0, -1};
		int[] dx_2 = new int[] {-1, 0, 1, 0};
		
		int total_cnt=0;
		
		while(true)
		{
			now_y += dy_2[now_dr];
			now_x += dx_2[now_dr];
			
			//System.out.println(now_y + " , " + now_x + " : ");
			
			if(now_y <0 || now_x <0 || now_y >=n || now_x >=n) break;
			
			if(total_cnt>= list2.size()) break;
			
			board[now_y][now_x] = list2.get(total_cnt);
			
			check_cnt++;
			total_cnt++;
			
			if(check_cnt == how_cnt)
			{
				now_dr++;
				now_dr %=4;
				tag++;
				check_cnt=0;
			}
			
			if(tag==2)
			{
				how_cnt++;
				tag=0;
			}
		}
		
	}
}
