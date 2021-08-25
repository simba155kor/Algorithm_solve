package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>
{
	int len;
	int ed;

	Edge(int len, int ed)
	{
		this.len = len;
		this.ed = ed;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.len - o.len;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return len + " , " + ed ;
	}
	
}

public class BOJ_1753_shortest_path {

	static int n,m;
	static int[] dis;
	static ArrayList<Edge>[] arr; 
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		
		int k = Integer.parseInt(br1.readLine())-1;
		
		arr = new ArrayList[n];
		dis = new int[n];
		for(int a=0; a<n; a++)
		{
			arr[a] = new ArrayList<Edge>();
			dis[a] = Integer.MAX_VALUE;
		}
		
		for(int a=0; a<m; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int start = Integer.parseInt(st1.nextToken())-1;
			int end = Integer.parseInt(st1.nextToken())-1;
			int val = Integer.parseInt(st1.nextToken());
			
			arr[start].add(new Edge(val, end));
		}
		
//		for(int a=0; a<n; a++)
//		{
//			System.out.println(arr[a].toString());
//			
//		}
		
		
		dis[k] = 0;
		Dijkstra(k);
		
		for(int a=0; a<n; a++) 
		{
			if(dis[a] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dis[a]);
		}
	}
	
	
	static void Dijkstra(int now)
	{
		PriorityQueue<Edge> pq1 = new PriorityQueue<Edge>();
		
		for(int a=0; a<arr[now].size(); a++)
		{
			int next_node = arr[now].get(a).ed;
			int next_len = arr[now].get(a).len;
			
			if(dis[next_node] > next_len + dis[now])
			{
				dis[next_node] = next_len + dis[now];
				pq1.offer(new Edge(next_len + dis[now], next_node ));
			}
		}
		
		
		while(!pq1.isEmpty())
		{
			Edge now_edge = pq1.poll();
			
			for(int a=0; a<arr[now_edge.ed].size(); a++)
			{
				int next_node = arr[now_edge.ed].get(a).ed;
				int next_len = arr[now_edge.ed].get(a).len;
				
				if(dis[next_node] > next_len + dis[now_edge.ed])
				{
					dis[next_node] = next_len + dis[now_edge.ed];
					pq1.offer(new Edge(next_len + dis[now_edge.ed], next_node));
				}
				
			}
			
			
			
		}
		
		
	}

	
	
}
