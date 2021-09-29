package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_height {
	static int n,m;
	static ArrayList<Integer>[][] arr1;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1=  new StringTokenizer(br1.readLine());
		
		int test= Integer.parseInt(st1.nextToken());
		
		for(int t=1; t<=test; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			n = Integer.parseInt(st1.nextToken());
			st1 = new StringTokenizer(br1.readLine());
			m = Integer.parseInt(st1.nextToken());
			
			arr1 = new ArrayList[n][2];
			
			for(int a=0; a<n; a++)
			{
				arr1[a][0] = new ArrayList<Integer>();
				arr1[a][1] = new ArrayList<Integer>();
			}
				
			
			for(int a=0; a<m; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				int st_node = Integer.parseInt(st1.nextToken());
				int ed_node = Integer.parseInt(st1.nextToken());
				
				arr1[st_node-1][0].add(ed_node-1);
				arr1[ed_node-1][1].add(st_node-1);
			}
			
			for(int a=0; a<n; a++)
			{
				int down_cnt = BFS(a, 0)-1;
				int up_cnt = BFS(a, 1)-1;
				System.out.println(a+1 + "번 노드는 " + down_cnt + " , " + up_cnt);
			}
		}
	}
	
	static int BFS(int st_node, int mode)
	{
		int cnt=0;
		Queue<Integer> Q1 = new LinkedList<Integer>();
		
		int[] vis = new int[n];
		
		Q1.offer(st_node);
		vis[st_node] = 1;
		
		while(!Q1.isEmpty())
		{
			int cur = Q1.poll();
			cnt++;
			
			for(int a=0; a<arr1[cur][mode].size(); a++)
			{
				int next_node = arr1[cur][mode].get(a);
				
				if(vis[next_node]>0) continue;
				Q1.offer(next_node);
				vis[next_node] = 1;
			}
		}
			
		
		return cnt;
	}

}
