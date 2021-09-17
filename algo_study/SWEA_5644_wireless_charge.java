package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class charge_info
{
	int y, x;
	int c1;
	int power;
};

public class SWEA_5644_wireless_charge {
	
	static int[] board1;
	static int[] board2;
	
	static int[] dy = {0,-1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	static int y1, x1;
	static int y2=9, x2=9;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1 = new StringBuilder();
		
		int test = Integer.parseInt(br1.readLine());
		
		
		for(int t=1; t<=test; t++)
		{
		
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			
			int M = Integer.parseInt(st1.nextToken());
			int A = Integer.parseInt(st1.nextToken());
			
			st1 = new StringTokenizer(br1.readLine());
			
			board1 = new int[M];
			board2 = new int[M];
			
			y1=0; x1=0;
			y2=9; x2=9;
			
			for(int a=0; a<M; a++)
			{
				board1[a] = Integer.parseInt(st1.nextToken());
			}
			
			st1 = new StringTokenizer(br1.readLine());
			for(int a=0; a<M; a++)
			{
				board2[a] = Integer.parseInt(st1.nextToken());
			}
			
			charge_info[] infos = new charge_info[A];
			
			for(int a=0; a<A; a++)
			{
				infos[a] = new charge_info();
				st1 = new StringTokenizer(br1.readLine());
				infos[a].x = Integer.parseInt(st1.nextToken()) -1;
				infos[a].y = Integer.parseInt(st1.nextToken()) -1;
				infos[a].c1 = Integer.parseInt(st1.nextToken());
				infos[a].power = Integer.parseInt(st1.nextToken());
				
			}
			
			int ans=0;
			
			for(int a=0; a<=M; a++)
			{
				ArrayList<Integer> list1 = new ArrayList<Integer>();
				ArrayList<Integer> list2 = new ArrayList<Integer>();
				
				
				for(int b=0; b<A; b++)
				{
					int spot_y = infos[b].y;
					int spot_x = infos[b].x;
					int cover = infos[b].c1;
					//1번 애
					
					int d1 = Math.abs(spot_y - y1) + Math.abs(spot_x - x1);
					
					//충전 안에 있는것.
					if(d1 <=cover)list1.add(b);
					
					//2번애
					int d2 = Math.abs(spot_y - y2) + Math.abs(spot_x - x2);
					
					//충전 안에 있는것.
					if(d2 <=cover) list2.add(b);
					
				}
				
	//			System.out.println(list1.toString());
	//			System.out.println(list2.toString());
	//			System.out.println();
				
				int temp1 =0;
				
				if(list1.size() ==0)
				{
					for(int b=0; b< list2.size(); b++)
					{
						int idx = list2.get(b);
						if(temp1 < infos[idx].power)
							temp1 = infos[idx].power;
					}
				}
				else if(list2.size() ==0)
				{
					for(int b=0; b< list1.size(); b++)
					{
						int idx = list1.get(b);
						if(temp1 < infos[idx].power)
							temp1 = infos[idx].power;
					}
				}
				else
				{
					for(int d=0; d<list1.size(); d++)
					{
						int idx1 = list1.get(d);
						for(int b=0; b< list2.size(); b++)
						{
							int idx2 = list2.get(b);
							if(idx1 == idx2)
							{
								if(temp1 < infos[idx1].power)
									temp1 = infos[idx1].power;
							}
							else
							{
								int temp2 = infos[idx1].power;
								temp2+=infos[idx2].power;
								if(temp1 < temp2)
									temp1 = temp2;
							}
						}
					}
				}
				
				ans += temp1;
				
				
				if(a==M) break;
				
				y1+=dy[board1[a]]; x1+=dx[board1[a]];
				y2+=dy[board2[a]]; x2+=dx[board2[a]];
				
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

}

