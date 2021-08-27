package study1_1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Solution {
//	static int[][] board;
//	static int st_r, st_c;
//	static int cnt;
//	static boolean[] isused;
//	static xy_info[][] infos;
//	static int min_ans = Integer.MAX_VALUE;
//	static int[] dy = {-1, 0, 1, 0};
//	static int[] dx = {0, -1, 0, 1};
//	
//    public int solution(int[][] boards, int r, int c) {
//    	
//    	board = new int[4][4];
//		
//		infos = new xy_info[10][2];
//		
//		for(int a=0; a<4; a++)
//		{
//			for(int b=0; b<4; b++)
//			{
//				board[a][b] = boards[a][b];
//				if(board[a][b] !=0 ) 
//				{
//					cnt++;
//					if(infos[board[a][b]-1][0] == null) infos[board[a][b]-1][0] = new xy_info(a, b);
//					else infos[board[a][b]-1][1] = new xy_info(a,b);
//				}
//			}
//		}
//		
//		cnt/=2;
//		
//		isused = new boolean[6];
//		for(int a=0; a<6; a++)
//		{
//			if(infos[a][0] == null) isused[a]=true;
//		}
//	
//    	func(0, r, c, 0);
//        int answer = min_ans;
//        return answer;
//    }
//    
//    static void func(int now, int now_r, int now_c, int ans)
//	{
//		if(now == cnt)
//		{
//			if(min_ans > ans) 
//				{min_ans = ans;
//				}
//			return;
//		}
//		
//		for(int a=0; a<6; a++)
//		{
//			if(isused[a]) continue;
//			isused[a] = true;
//			
//			int temp = BFS(now_r, now_c , infos[a][0].y, infos[a][0].x) +
//					BFS(infos[a][0].y, infos[a][0].x, infos[a][1].y, infos[a][1].x);
//			//제거해주기
//			board[infos[a][0].y][infos[a][0].x] = 0;
//			board[infos[a][1].y][infos[a][1].x] = 0;
//			
//			func(now+1, infos[a][1].y, infos[a][1].x, ans + temp);
//			
//			board[infos[a][0].y][infos[a][0].x] = a+1;
//			board[infos[a][1].y][infos[a][1].x] = a+1;
//			
//			temp = BFS(now_r, now_c , infos[a][1].y, infos[a][1].x) +
//					BFS(infos[a][1].y, infos[a][1].x, infos[a][0].y, infos[a][0].x);
//			
//			board[infos[a][0].y][infos[a][0].x] = 0;
//			board[infos[a][1].y][infos[a][1].x] = 0;
//			
//			func(now+1, infos[a][0].y, infos[a][0].x, ans + temp);
//			
//			
//			//복구해주기
//			board[infos[a][0].y][infos[a][0].x] = a+1;
//			board[infos[a][1].y][infos[a][1].x] = a+1;
//			isused[a] = false;
//		}
//		
//	}
//	
//	static int BFS(int st_y, int st_x, int ed_y, int ed_x)
//	{
//		Queue<xy_info> q1 = new LinkedList<xy_info>();
//		
//		q1.offer(new xy_info(st_y, st_x, -1));
//		
//		int[][] vis = new int[4][4];
//		
//		vis[st_y][st_x] = 1;
//		
//		while(!q1.isEmpty())
//		{
//			xy_info now_yx = q1.poll();
//			for(int dr=0; dr<4; dr++)
//			{
//				int yy = now_yx.y + dy[dr];
//				int xx = now_yx.x + dx[dr];
//				
//				while(!(yy<0 || xx<0 || yy>=4 || xx>=4))
//				{
//					if(vis[yy][xx] != 0 && (vis[yy][xx]< vis[now_yx.y][now_yx.x] + 1 ))
//					{
//						break;
//					}
//					
//					if(board[yy][xx] >0)
//					{
//						vis[yy][xx] = vis[now_yx.y][now_yx.x] + 1;
//					}
//					else
//					{
//						if(now_yx.prev_dr != dr) vis[yy][xx] = vis[now_yx.y][now_yx.x] +1;
//						else vis[yy][xx] = vis[now_yx.y][now_yx.x];
//					}
//					q1.offer(new xy_info(yy,xx, dr));
//					
//					yy += dy[dr];
//					xx += dx[dr];
//				}
//			}
//			
//		}
//		
////		for(int a=0; a<4; a++)
////		{
////			for(int b=0; b<4; b++)
////			{
////				System.out.print(vis[a][b]);
////			}
////			System.out.println();
////		}
//		
//		
//		return vis[ed_y][ed_x];
//	}
//}

class xy_info
{
	int y,x;
	int prev_dr;
	
	xy_info(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
	
	xy_info(int y, int x, int prev_dr)
	{
		this.y = y;
		this.x = x;
		this.prev_dr = prev_dr;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return y + " , " +x; 
	}
}


public class kakaotest5 {
	static int[][] board;
	static int st_r, st_c;
	static int cnt;
	static boolean[] isused;
	static xy_info[][] infos;
	static int min_ans = Integer.MAX_VALUE;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		board = new int[4][4];
		
		infos = new xy_info[10][2];
		
		for(int a=0; a<4; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			for(int b=0; b<4; b++)
			{
				board[a][b] = Integer.parseInt(st1.nextToken());
				if(board[a][b] !=0 ) 
				{
					cnt++;
					if(infos[board[a][b]-1][0] == null) infos[board[a][b]-1][0] = new xy_info(a, b);
					else infos[board[a][b]-1][1] = new xy_info(a,b);
				}
			}
		}
		
		cnt/=2;
		
		isused = new boolean[6];
		for(int a=0; a<6; a++)
		{
			if(infos[a][0] == null) isused[a]=true;
		}
		
		st1 = new StringTokenizer(br1.readLine());
		st_r = Integer.parseInt(st1.nextToken());
		st_c = Integer.parseInt(st1.nextToken());
		
		
//		for(int a=1; a<=cnt; a++)
//		{
//			if(infos[a][0] == null) continue;
//			for(int b=0; b<2; b++)
//			{
//				System.out.println(infos[a][b].toString());
//			}
//		}
//		
		
//		Solution s = new Solution();
//		s.solution(board, st_r, st_c);
//		
		func(0, st_r, st_c, 0);
		
//		BFS(1,0, 3, 3);
//		BFS(1,0, 0, 0);
		
		System.out.println(min_ans);
		
	}
	static ArrayList<xy_info> arr1 = new ArrayList<xy_info>(); 
			
	static void func(int now, int now_r, int now_c, int ans)
	{
		if(now == cnt)
		{
			if(min_ans > ans) 
				{min_ans = ans;
				//System.out.println(arr1.toString());
				//System.out.println(min_ans);
				}
			return;
		}
		
		for(int a=0; a<6; a++)
		{
			if(isused[a]) continue;
			isused[a] = true;
			
			int temp = BFS(now_r, now_c , infos[a][0].y, infos[a][0].x) +
					BFS(infos[a][0].y, infos[a][0].x, infos[a][1].y, infos[a][1].x);
			//제거해주기
			board[infos[a][0].y][infos[a][0].x] = 0;
			board[infos[a][1].y][infos[a][1].x] = 0;
			
			arr1.add(new xy_info(a+1, temp));
			func(now+1, infos[a][1].y, infos[a][1].x, ans + temp);
			arr1.remove(arr1.size()-1);

			board[infos[a][0].y][infos[a][0].x] = a+1;
			board[infos[a][1].y][infos[a][1].x] = a+1;
			
			
			temp = BFS(now_r, now_c , infos[a][1].y, infos[a][1].x) +
					BFS(infos[a][1].y, infos[a][1].x, infos[a][0].y, infos[a][0].x);
			
			
			
			board[infos[a][0].y][infos[a][0].x] = 0;
			board[infos[a][1].y][infos[a][1].x] = 0;
			
			arr1.add(new xy_info(a+1, temp));
			func(now+1, infos[a][0].y, infos[a][0].x, ans + temp);
			arr1.remove(arr1.size()-1);
			
			//복구해주기
			board[infos[a][0].y][infos[a][0].x] = a+1;
			board[infos[a][1].y][infos[a][1].x] = a+1;
			isused[a] = false;
		}
		
	}
	
	static int BFS(int st_y, int st_x, int ed_y, int ed_x)
	{
		Queue<xy_info> q1 = new LinkedList<xy_info>();
		
		q1.offer(new xy_info(st_y, st_x));
		
		int[][] vis = new int[4][4];
		
		vis[st_y][st_x] = 1;
		
		while(!q1.isEmpty())
		{
			xy_info now = q1.poll();
			
			for(int dr=0; dr<4; dr++)
			{
				int yy = now.y + dy[dr];
				int xx = now.x + dx[dr];
				
				if(yy<0 || xx<0 || yy>=4 || xx>=4) continue;
				
				if(vis[yy][xx] >0) continue;
				
				vis[yy][xx] = vis[now.y][now.x]+ 1; 
				q1.offer(new xy_info(yy,xx));
			}
			
			for(int dr=0; dr<4; dr++)
			{
				int yy = now.y + dy[dr];
				int xx = now.x + dx[dr];
				
				while(true)
				{
					if(yy<0 || xx<0 || yy>=4 || xx>=4)
					{
						yy-=dy[dr];
						xx-=dx[dr];
						break;
					}
					if(board[yy][xx] !=0) break;
					
					yy+=dy[dr];
					xx+=dx[dr];
				}
				
				if(vis[yy][xx] >0) continue;
				
				vis[yy][xx] = vis[now.y][now.x]+ 1; 
				q1.offer(new xy_info(yy,xx));
			}
			
		}
		
		System.out.println(vis[ed_y][ed_x]);
		return vis[ed_y][ed_x];
	}
	
	
	
	static int BFS2(int st_y, int st_x, int ed_y, int ed_x)
	{
		//System.out.println(st_y + " , " + st_x + "에서 " + ed_y + " , " + ed_x);
		Queue<xy_info> q1 = new LinkedList<xy_info>();
		
		q1.offer(new xy_info(st_y, st_x, -1));
		
		int[][] vis = new int[4][4];
		
		vis[st_y][st_x] = 1;
		
		while(!q1.isEmpty())
		{
			xy_info now_yx = q1.poll();
			for(int dr=0; dr<4; dr++)
			{
				int yy = now_yx.y + dy[dr];
				int xx = now_yx.x + dx[dr];
				
				while(!(yy<0 || xx<0 || yy>=4 || xx>=4))
				{
					if(vis[yy][xx] != 0 && (vis[yy][xx]< vis[now_yx.y][now_yx.x] + 1 ))
					{
						break;
					}
					
					if(board[yy][xx] >0)
					{
						vis[yy][xx] = vis[now_yx.y][now_yx.x] + 1;
						q1.offer(new xy_info(yy,xx, dr));
						break;
					}
					else
					{
						if(now_yx.prev_dr != dr) 
						{vis[yy][xx] = vis[now_yx.y][now_yx.x] +1;
						q1.offer(new xy_info(yy,xx, dr));
							break;
						}
						else vis[yy][xx] = vis[now_yx.y][now_yx.x];
					}
					q1.offer(new xy_info(yy,xx, dr));
					
					yy += dy[dr];
					xx += dx[dr];
				}
			}
			
		}
		
		
//		for(int a=0; a<4; a++)
//		{
//			for(int b=0; b<4; b++)
//			{
//				System.out.print(board[a][b]);
//			}
//			System.out.println();
//		}
//		System.out.println("---------");
//		for(int a=0; a<4; a++)
//		{
//			for(int b=0; b<4; b++)
//			{
//				System.out.print(vis[a][b]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		//System.out.println(vis[ed_y][ed_x]);
		
		return vis[ed_y][ed_x];
	}
	
	
}
