package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import jdk.internal.util.xml.impl.Pair;

public class BOJ_9205_beer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test= Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			int n = Integer.parseInt(br1.readLine());
			
			StringTokenizer st1;
			
			int[] y_info = new int[n+2];
			int[] x_info = new int[n+2];
			
			for(int a=0; a<n+2; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				y_info[a] = Integer.parseInt(st1.nextToken());
				x_info[a] = Integer.parseInt(st1.nextToken());
			}
			
			
			LinkedList<Integer[]>[] list = new LinkedList[n+2];
			
			for(int a=0; a<n+2; a++)
			{
				for(int b=0; b<n+2; b++)
				{
					if(a==b)continue;
					int len = Math.abs(y_info[a] - y_info[b]) + Math.abs(x_info[a] - x_info[b]);
					if(len <= 1000)
					{
						if(list[a] == null) list[a] = new LinkedList<Integer[]>();
						list[a].add( new Integer[]{b, 1});
					}
				}
			}

			int[] vis = new int[n+2];
			
			Queue<Integer[]> Q1 = new LinkedList<Integer[]>();
			Q1.offer(new Integer[]{0,1});
			vis[0] =1;
			
			while(!Q1.isEmpty())
			{
				Integer[] temp = Q1.poll();
				
				int now_node = temp[0];
				
				if(list[now_node] == null) continue;
				
				for(int a=0; a<list[now_node].size(); a++)
				{
					Integer[] next = list[now_node].get(a);
					if(vis[next[0]] == 1) continue;
					
					Q1.offer(next);
					vis[next[0]] = 1;
				}
				
			}
			
			if(vis[n+1] == 1) System.out.println("happy");
			if(vis[n+1] == 0) System.out.println("sad");
			
			
		}
		
		
	}

}
