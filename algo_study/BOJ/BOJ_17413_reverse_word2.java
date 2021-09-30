package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_17413_reverse_word2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StringBuilder sb1 = new StringBuilder();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		String inp = br1.readLine();
		
		Queue<Character> q1 = new LinkedList<Character>();
		Stack<Character> S1 = new Stack<Character>();
		
		int tag=0;
		for(int a=0, end = inp.length(); a<end; a++)
		{
			char now = inp.charAt(a);
			
			
			if(now == '<' || now == ' ' || now=='>')//출력
			{
				if(tag==0)
				{
					while(!S1.empty())
					{
						//System.out.print(S1.pop());
						sb1.append(S1.pop());
					}
				}
				if(tag==1)
				{
					while(!q1.isEmpty())
					{
//						System.out.print(q1.poll());
						sb1.append(q1.poll());
					}
				}
				
				
				if(now=='>') tag=0;
				if(now=='<') tag=1;
				
//				System.out.print(now);
				sb1.append(now);
				continue;
			}
			

			if(tag==0) S1.push(now);
			if(tag==1) q1.offer(now);
			
		}
		
		if(tag==0)
		{
			while(!S1.empty())
			{
				//System.out.print(S1.pop());
				sb1.append(S1.pop());
			}
		}
		if(tag==1)
		{
			while(!q1.isEmpty())
			{
				//System.out.print(q1.poll());
				sb1.append(q1.poll());
			}
		}
		
		
		System.out.println(sb1.toString());
	}

}
