package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class info
{
	int y,x;
	
	info(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
	
}

public class SWEA_1251_hanaro {

	static int N;
	static double E;
	static long[][] board;
	static info[] infos;
	static long[] min_dis;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test=Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			N = Integer.parseInt(br1.readLine());
			infos = new info[N];
			
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			
			for(int a=0; a<N; a++)
			{
				infos[a] = new info(0, Integer.parseInt(st1.nextToken()));
			}
			st1 = new StringTokenizer(br1.readLine());
			for(int a=0; a<N; a++)
			{
				infos[a].y= Integer.parseInt(st1.nextToken());
			}
			
			E = Double.parseDouble(br1.readLine());

			board = new long[N][N];
			
			for(int a=0; a<N; a++)
			{
				for(int b=0; b<N; b++)
				{
					long y1 = infos[a].y; long x1 = infos[a].x;
					long y2 = infos[b].y; long x2 = infos[b].x;
					
					long y_d = (y1 - y2)*(y1-y2);
					long x_d = (x1 - x2)*(x1-x2);
					
					board[a][b] = y_d + x_d;
					
				}
			}

			min_dis = new long[N];
			check = new boolean[N];
			
			for(int a=0; a<N; a++) min_dis[a] = Long.MAX_VALUE;
			
			
			min_dis[0] = 0;
			check[0] = true;
			int now = 0;
			
			int cnt=0;
			while(cnt<N-1)
			{
				long min1 = Long.MAX_VALUE;
				int min1_idx = -1;
				
				for(int a=0; a<N; a++)
				{
					if(check[a]) continue;//작은거 부터 올라가니까 dp가 되서 false 인거만 보면 되는듯.
					
					if(min_dis[a] > board[now][a])
					{
						min_dis[a] = board[now][a];
					}
					if( min1 > min_dis[a])
					{
						min1 = min_dis[a];
						min1_idx = a;
					}
				}
				
				now = min1_idx;
				check[now] = true;
				cnt++;
			}
			
			long ans=0;
			for(int a=0; a<N; a++)
			{
				ans+= min_dis[a];
			}
			
			System.out.println("#" + t + " " + Math.round(ans*E));
			//System.out.println(Arrays.toString(check));
			
			//PriorityQueue<info> pq = new PriorityQueue<info>();
			
			
		}
		
	}

}
