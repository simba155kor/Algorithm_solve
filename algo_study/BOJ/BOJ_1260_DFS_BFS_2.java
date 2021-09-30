package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_1260_DFS_BFS_2 {
	static int n,m,v;
	static ArrayList<ArrayList<Integer>> Edge;
	
	static ArrayList<Integer>[] edge1;
	
	static boolean[] vis2;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		
		st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		v = Integer.parseInt(st1.nextToken());
			
		Edge = new ArrayList<ArrayList<Integer>>();
		edge1 = new ArrayList[n];
		
		for(int a=0; a<n; a++)
		{
			Edge.add(new ArrayList<Integer>());
			edge1[a] = new ArrayList<Integer>();
			
		}
		
		for(int a=0; a<m; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			int a1 = Integer.parseInt(st1.nextToken())-1;
			int a2 = Integer.parseInt(st1.nextToken())-1;
			Edge.get(a1).add(a2);
			Edge.get(a2).add(a1);
			
			edge1[a1].add(a2);
			edge1[a2].add(a1);
		}
		
		for(int a=0; a<n; a++)
		{
			Collections.sort(Edge.get(a));
			
			Collections.sort(edge1[a]);
		}
		
		vis2 = new boolean[n];
		
		DFS(v-1);
		System.out.println();
		BFS();
		
		
		
	}

	
	static void BFS()
	{
		Queue<Integer> q1 = new LinkedList<Integer>();
		boolean[] vis = new boolean[n];
		
		q1.offer(v-1);
		vis[v-1] = true;
		
		while(!q1.isEmpty())
		{
			int now = q1.poll();
			System.out.print(now+1 + " ");
			
			for(int a=0; a<edge1[now].size(); a++)
			{
				int next = edge1[now].get(a);
				
				if(vis[next] == false)
				{
					vis[next] = true;
					q1.offer(next);
				}
				
			}
			
			
		}
	}
	
	

	static void DFS(int now)
	{
		vis2[now] = true;
		
		System.out.print(now+1 + " ");
			
		for(int a=0; a<edge1[now].size(); a++)
		{
			int next = edge1[now].get(a);
			if(vis2[next]) continue;
			DFS(next);
		}
		
	}
}
