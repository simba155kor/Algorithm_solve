//중복이 가능하기 때문에 bottom-up으로 해야됨.

package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JungOL_1077_kanpsack {

	static int[] weight;
	static int[] value;
	
	static int[] D;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n = Integer.parseInt(st1.nextToken());
		int w = Integer.parseInt(st1.nextToken());
		
		weight = new int[n];
		value = new int[n];
		D = new int[w+1];
		
		for(int a=0; a<n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			weight[a] = Integer.parseInt(st1.nextToken());
			value[a] = Integer.parseInt(st1.nextToken());
		}
		
		//1차원으로
		for(int a=0; a<=w; a++)
		{
			for(int b=0; b<n; b++)
			{
				if(weight[b]>a) continue;
				
				int temp = D[a -weight[b]] + value[b];
				if(temp > D[a]) D[a] =temp;
			}
		}

		System.out.println(D[w]);
	}

}
