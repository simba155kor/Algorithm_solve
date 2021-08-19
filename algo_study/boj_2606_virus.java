package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2606_virus {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> Edge;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1;
		
		N = Integer.parseInt(br1.readLine());
		M = Integer.parseInt(br1.readLine());
		vis = new boolean[N];
		
		Edge = new ArrayList<ArrayList<Integer>>();
		for(int a=0; a<N; a++)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			Edge.add(temp);
		}
		
		for(int a=0; a<M; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int start = Integer.parseInt(st1.nextToken()) -1;
			int end = Integer.parseInt(st1.nextToken()) -1;
			Edge.get(start).add(end);
			Edge.get(end).add(start);

		}
		
//		for(int a=0; a<Edge.size(); a++)
//		{
//			System.out.print( a+1 + " : ");
//			for(int b=0; b<Edge.get(a).size(); b++)
//			{
//				System.out.print(Edge.get(a).get(b)+1 + " ");
//			}
//			System.out.println();
//		}
//		
		System.out.println(bfs(0)-1);
		
	}

	static int bfs(int start)
	{
		int ans=0;
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.offer(start);
		vis[start] = true;
		
		while(!Q.isEmpty())
		{
			int now = Q.poll();
			ans++;
			
			for(int a=0; a<Edge.get(now).size(); a++)
			{
				int next_node = Edge.get(now).get(a);
				if(vis[next_node]) continue;
				Q.offer(next_node);
				vis[next_node] = true;
			}
		}
		
		return ans;
	}
}
