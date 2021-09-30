package solve;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class infoz implements Comparable<infoz>
{
	int st;
	int end;
	long len;
	
	infoz(long len, int st, int ed)
	{
		this.len = len;
		this.st = st;
		this.end = ed;
	}

	@Override
	public int compareTo(infoz o) {
		// TODO Auto-generated method stub
		
		if(o.len < len) return 1;
		else if(o.len ==len)
		{
			if(o.st < st) return 1;
			else if(o.st ==st)
			{
				if(o.end <end) return 1;
			}
		}
		return -1;
	}
	
	
};

public class SWEA_3124_MST {
	
	static int[] parents;
	
	
	static int find_par(int x)
	{
		if(x==parents[x]) return x;
		return parents[x] = find_par(parents[x]);
	}
	
	static void union(int st, int ed)
	{
		if(st> ed)
		{
			int temp = st;
			st = ed;
			ed = temp;
		}
		
		parents[ed] = parents[st];
		
	}
	
	static boolean finding(int st, int ed)
	{
		int a1 = find_par(st);
		int b1 = find_par(ed);
		
		if(a1 == b1) return true;
		
		parents[a1] = parents[b1];
		//union(st, ed);
		
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		
		int test = Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			
			int v = Integer.parseInt(st1.nextToken());
			int e = Integer.parseInt(st1.nextToken());
			
			infoz[] infos = new infoz[e];
			
			parents = new int[v+1];
			
			for(int a=1; a<=v; a++) parents[a] = a;
			
			for(int a=0; a<e; a++)
			{
				st1 = new StringTokenizer(br1.readLine());
				
				int st = Integer.parseInt(st1.nextToken());
				int ed = Integer.parseInt(st1.nextToken());
				long len = Long.parseLong(st1.nextToken());
				
				infos[a] = new infoz(len, st, ed);
				
			}
			
			Arrays.sort(infos);
			
			
			long ans =0;
			int cnt=0;
			
			for(int a=0; a<e; a++)
			{
				if(!finding(infos[a].st, infos[a].end))
				{
					ans+=infos[a].len;
					cnt++;
				}
				if(cnt == v-1) break;
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}

}
