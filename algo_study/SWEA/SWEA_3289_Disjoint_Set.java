package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3289_Disjoint_Set {

	public static int[] par;
	public static int n, m;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		StringBuilder sb1 = new StringBuilder();
		int test = Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			sb1.append("#" + t + " ");
			st1 = new StringTokenizer(br1.readLine());
			n = Integer.parseInt(st1.nextToken());
			m = Integer.parseInt(st1.nextToken());
			par = new int[n];
			
			
			for(int a=0; a<n; a++) par[a] = a;
			
			for(int a=0; a<m; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				
				int cmd = Integer.parseInt(st1.nextToken());
				int node1 = Integer.parseInt(st1.nextToken())-1;
				int node2 = Integer.parseInt(st1.nextToken())-1;
				
				if(cmd == 0 ) union1(node1, node2);
				else if(cmd == 1) sb1.append(find_pairs(node1, node2));
				
				
				//System.out.println(Arrays.toString(par));
				
			}
			
			sb1.append("\n");
		}
		
		System.out.println(sb1.toString());
	}
	
	
	static int find_parent(int node)
	{
		if(par[node] == node) return node;
		else return par[node] = find_parent(par[node]);
	}
	
	static int find_pairs(int node1, int node2)
	{
		int node1_par = find_parent(node1);
		int node2_par = find_parent(node2);
		
		
		if(node1_par == node2_par) return 1;
		else return 0;
	}
	
	static void union1(int node1, int node2)
	{
		if(node1 > node2) 
		{
			int temp = node1;
			node1 = node2;
			node2 = temp;
		}
		
		int node1_par = find_parent(node1);
		int node2_par = find_parent(node2);
		
		if(node1_par == node2_par) return;
		
		
		par[node2_par] = par[node1_par];
		
	}

}
