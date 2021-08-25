package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class info2 implements Comparable<info2>
{
	int len;
	int st1, ed1;
	
	info2(int st1, int ed1, int len)
	{
		this.len = len;
		this.st1 = st1;
		this.ed1 = ed1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return len + " : " + st1 + " , " + ed1 +"\n";
	}

	
	@Override
	public int compareTo(info2 o) {
		// TODO Auto-generated method stub
		
		return this.len - o.len;
	}
	
	
	
}

public class BOJ_14621_no_love {
	static int n,m;
	static char[] sex;
	static boolean[] check;
	static int[] par;
	static int[] level;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		sex = new char[n];
		check = new boolean[n];
		par = new int[n];
		level = new int[n];
		
		st1 = new StringTokenizer(br1.readLine());
		
		for(int a=0; a<n; a++)
		{
			par[a] = a;
			sex[a] = st1.nextToken().charAt(0);
		}
		
		PriorityQueue<info2> pq = new PriorityQueue<info2>();
		
		for(int a=0; a<m; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			pq.offer(new info2( Integer.parseInt(st1.nextToken()) -1, Integer.parseInt(st1.nextToken())-1,Integer.parseInt(st1.nextToken())));
		}
		
//		for(int a=0; a<m; a++)
//		{
//			info2 temp = pq.poll();
//			System.out.println(temp.toString());
//		}
		
		int ans=0;
		int cnt =0;
		
		while(cnt< n-1 && !pq.isEmpty())
		{
			info2 temp = pq.poll();
			
			if(sex[temp.st1] == sex[temp.ed1]) continue; 
			
			if(find(temp.st1, temp.ed1))
			{
				cnt++;
				ans+=temp.len;
			}
		}
		
		for(int a=0; a<n; a++)
		{
			if(check[a] == false)
			{
				ans=-1;
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	static int find_par(int now)
	{
		if(par[now] == now) return now;
		else return par[now] = find_par(par[now]);
	}
	
	static boolean find(int st, int ed)
	{
		int st_par = find_par(st);
		int ed_par = find_par(ed);
		
		if(st_par == ed_par) return false;
		
		if(level[st_par] > level[ed_par])
		{
			par[ed_par] = st_par;
			level[st_par]++;
		}
		else
		{
			level[ed_par]++;
			par[st_par] = ed_par;
		}
		
		check[st]=true;
		check[ed]=true;
		
		return true;
	}

	
}
