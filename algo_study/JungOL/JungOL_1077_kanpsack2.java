package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JungOL_1077_kanpsack2 {
	
	static int[] weights;
	static int[] values;
	static int[][] D;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int w = Integer.parseInt(st1.nextToken());
		
		weights = new int[n+1];
		values = new int[n+1];
		D = new int[n+1][w+1];
		
		for(int a=1; a<=n; a++)
		{
			st1= new StringTokenizer(br1.readLine());
			
			weights[a]= Integer.parseInt(st1.nextToken());
			values[a] = Integer.parseInt(st1.nextToken());
		}
		
		
		for(int a=1; a<=n; a++)
		{
			for(int b=0; b<=w; b++)
			{
				D[a][b] = D[a-1][b];
				
				if(weights[a] > b) continue;
				
				D[a][b] = Math.max(D[a][b-weights[a]] + values[a], D[a][b]);
			}
		}
		
		System.out.println(D[n][w]);
	}

}
