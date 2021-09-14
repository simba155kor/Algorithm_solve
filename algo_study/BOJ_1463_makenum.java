package solve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1463_makenum {
	
	static int[] ans;
	static int[] dx = {1, 2, 3};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		
		int inp = sc1.nextInt();
		
		ans = new int[inp +1];
		
		for(int a=1; a<=inp ; a++) ans[a] = Integer.MAX_VALUE;
		
		Queue<Integer> Q1 = new LinkedList<Integer>();
		
		Q1.offer(1);
		ans[1] = 1;
		while(!Q1.isEmpty())
		{
			int now = Q1.poll();
			if(now == inp)
			{
				System.out.println(ans[now]-1);
				break;
			}
			
			for(int dr=0; dr<3; dr++)
			{
				int xx =now;
				if(dr==0) xx +=dx[dr];
				else
				{
					xx *= dx[dr];
				}
				
				if(xx>inp) continue;
				
				if(ans[xx] != Integer.MAX_VALUE) continue;
				
				ans[xx] = ans[now] + 1;
				Q1.offer(xx);
			}
			
		}
	}

}
