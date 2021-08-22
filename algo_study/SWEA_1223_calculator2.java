import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SWEA_1223_calculator2 {

	static String temp;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test =10;
		for(int t=1; t<=test; t++)
		{
			int ans=0;
			int n = Integer.parseInt(br1.readLine());
			temp = br1.readLine();
			
			String temp_s = "";
			Stack<Character> S1 = new Stack<Character>();
			
			//3+4+5*6+7
			for(int a=0; a<n; a++)
			{
				//피연산자
				if(a%2==0) temp_s += temp.charAt(a);
				else
				{
					char now = temp.charAt(a);
					if(S1.empty()) S1.push(now);
					else
					{
						if(now == '+')
						{
							while(!S1.empty())
							{
								temp_s += S1.pop();
							}
							S1.push('+');
						}
						else
						{
							while(!S1.empty())
							{
								
								if(S1.peek() == '*')
								{
									temp_s += S1.pop();
								}
								else break;
							}
							S1.push('*');
						}
						
					}
				}
			}
			
			while(!S1.empty())
			{
				temp_s += S1.pop();
			}
			
			Stack<Integer> S2 = new Stack<Integer>();
			
			for(int a=0; a<n; a++)
			{
				char now_c = temp_s.charAt(a);
				if(now_c >= '0' && now_c <= '9') S2.push((now_c - '0'));
				else
				{
					int a1 = S2.pop();
					int a2 = S2.pop();
					int a3 =0;
					if(now_c == '+') a3 = a1+a2;
					if(now_c == '*') a3 = a1*a2;
					
					S2.push(a3);
				}
			}
			

			System.out.println("#" + t + " " + S2.pop());
		}
		
	}
	

	
}
