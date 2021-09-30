//중복이 없기 때문에 Top-down으로 해야됨.

package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class infod1
{
	int weight;
	int value;
	
	infod1(int weight, int value)
	{
		this.weight = weight;
		this.value = value;
	}
}

public class BOJ_12865_bag2 {
	
	static int[] D2;
	//
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int n= Integer.parseInt(st1.nextToken());
		int k= Integer.parseInt(st1.nextToken());
		
		D2 = new int[k+1];
		
		infod1[] arr = new infod1[n+1];
		
		for(int a=1; a<=n; a++)
		{
			st1 = new StringTokenizer(br1.readLine());
			int temp_w = Integer.parseInt(st1.nextToken());
			int temp_v = Integer.parseInt(st1.nextToken());
			
			infod1 info1 = new infod1(temp_w, temp_v);
			arr[a] = info1;
		}
		
	
		
		for(int a=1; a<=n; a++)
		{
			for(int b=k; b>=arr[a].weight; b--)
			{
				int temp = D2[b -arr[a].weight] + arr[a].value;
				if(temp > D2[b]) D2[b] = temp;
			}
		}
		
		
		System.out.println(D2[k]);
		
	}

}
