import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_card2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		
		Queue<Integer> Q1 = new LinkedList<Integer>();
		
		for(int a=1; a<=n; a++)
		{
			Q1.offer(a);
		}
		
		while(Q1.size()>1)
		{
			int now = Q1.poll();
			
			if(Q1.size() == 1) break;
			
			int now2 = Q1.poll();
			Q1.offer(now2);
		}
		
		System.out.println(Q1.poll());
		
	}

}
