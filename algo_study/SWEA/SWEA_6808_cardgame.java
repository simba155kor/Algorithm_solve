package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_cardgame {
	public static int N = 9;
	public static int[] my_card;
	public static int[] your_card;
	public static int[] isused;
	public static int my_win_cnt;
	public static int my_lose_cnt;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb1 = new StringBuilder(); 
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			my_card = new int[N];
			your_card = new int[N];
			isused = new int[N];
			
			int[] temp_arr1 = new int[ (N*2)+1];
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			for(int a=0; a<N; a++)
			{
				my_card[a] = Integer.parseInt(st1.nextToken());
				temp_arr1[my_card[a]] =1;
			}
			int temp_idx=0;
			for(int a=1; a<=2*N; a++)
			{
				if(temp_arr1[a] == 1) continue;
				your_card[temp_idx] = a;
				temp_idx++;
			}
			
			func(0, 0, 0);
			
			sb1.append("#" + t + " " + my_win_cnt + " " + my_lose_cnt + "\n");
//			System.out.println("#" + t + " " + my_win_cnt + " " + my_lose_cnt);
			my_win_cnt =0;
			my_lose_cnt =0;
		}
		
		System.out.println(sb1.toString());
	}
	
	static void func(int now, int my_sum, int your_sum)
	{
		if(now == N)
		{
			if(my_sum > your_sum) my_win_cnt++;
			if(my_sum < your_sum) my_lose_cnt++;
			return; 
		}
		
		for(int a=0; a<N; a++)
		{
			if(isused[a] == 1) continue;
			isused[a] = 1;
			
			if(my_card[now] > your_card[a]) func(now+1, my_sum + my_card[now] + your_card[a], your_sum);
			if(my_card[now] < your_card[a]) func(now+1, my_sum, your_sum + my_card[now] + your_card[a]);
			
			isused[a] = 0;
		}
		
	}

}
