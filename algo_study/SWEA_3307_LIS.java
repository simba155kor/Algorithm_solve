package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_LIS {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br1.readLine());
		
		for(int t=1; t<=test; t++)
		{
			int n = Integer.parseInt(br1.readLine());
			
			StringTokenizer st1 = new StringTokenizer(br1.readLine());
			
			int[] board = new int[n];
			int[] D = new int[n];	
			
			for(int a=0; a<n; a++)
			{
				board[a] = Integer.parseInt(st1.nextToken());
			}
			
			int ans =0;
			for(int a=0; a<n; a++)
			{
				D[a] = 1;
				for(int b=0; b<a; b++)
				{
					if(board[a]> board[b] && D[a]<D[b]+1)
					{
						D[a] = D[b]+1;
					}
				}
				
				if(ans < D[a]) ans = D[a];
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
