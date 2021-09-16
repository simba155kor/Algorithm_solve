package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class info implements Comparable<info>
{
	int weight;
	int value;
	
	info(int weight, int value)
	{
		this.weight = weight;
		this.value = value;
	}

	@Override
	public int compareTo(info o) {
		// TODO Auto-generated method stub
		if(o.weight < weight) return 1; 
		else if(o.weight == weight) {
			if(o.value < value) return 1; }
		
		return -1;
	}
	
	@Override
	public String toString() {
		return (weight + " , " + value);
	}
}

public class BOJ_12865_bag {
	
	static int[][] D;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n= Integer.parseInt(st1.nextToken());
		int k= Integer.parseInt(st1.nextToken());
		
		D = new int[n+1][k+1];
		
		info[] arr = new info[n+1];
		
		for(int a=1; a<=n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int temp_w = Integer.parseInt(st1.nextToken());
			int temp_v = Integer.parseInt(st1.nextToken());
			
			info info1 = new info(temp_w, temp_v);
			arr[a] = info1;
		}
		
		
		for(int a=1; a<=n; a++)
		{
			for(int b=0; b<=k; b++)
			{
				D[a][b] = D[a-1][b];
				if( arr[a].weight > b) continue;
				
				//b무게에서 a번째를 넣는경우 ,   안 넣는 경우. a-1번째 까지 고려한거
				D[a][b] = Math.max(D[a-1][b-arr[a].weight]+ arr[a].value, D[a-1][b]);
				
			}
		}
		
		
//		for(int a=0; a<=n; a++)
//		{
//			for(int b=0; b<=k; b++)
//			{
//				System.out.print(D[a][b]);
//			}
//			System.out.println();
//		}
		System.out.println(D[n][k]);
		
	}

}
