package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JungOl_2577_roll_sushi {

	//전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c가 
	static int n, d, k ,c;
	static int[] board;
	static int[] vis;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		n= Integer.parseInt(st1.nextToken());
		d= Integer.parseInt(st1.nextToken());
		k= Integer.parseInt(st1.nextToken());
		c= Integer.parseInt(st1.nextToken());
		
		board = new int[n];
		vis = new int[d+1];
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			board[a] = Integer.parseInt(st1.nextToken());
		}
		
		int vis_cnt=0;
		
		int real_ans=0;
		
		for(int a=0; a<k; a++)
		{
			if(vis[board[a]]==0)
			{
				vis_cnt++;
			}
			
			vis[board[a]]++;
		}
		
		if(vis[c] == 0) vis_cnt++;
		if(real_ans < vis_cnt) real_ans = vis_cnt;
		if(vis[c] == 0) vis_cnt--;
		
		
		
		int now_idx1 = k-1;
		int now_idx2 = 0;
		
		while(true) 
		{
			vis[board[now_idx2]]--;
			if(vis[board[now_idx2]]==0) vis_cnt--;
			
			now_idx2++;
			now_idx2%=n;
			now_idx1++;
			now_idx1%=n;
			
			if(now_idx2==0) break;
			
			if(vis[board[now_idx1]]==0)
			{
				vis_cnt++;
			}
			
			vis[board[now_idx1]]++;
			
			if(vis[c] == 0) vis_cnt++;
			if(real_ans < vis_cnt) real_ans = vis_cnt;
			if(vis[c] == 0) vis_cnt--;
			
		}
		
		System.out.println(real_ans);
	}

}
