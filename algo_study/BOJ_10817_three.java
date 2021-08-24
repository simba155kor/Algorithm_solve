package zany1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10817_three {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br1.readLine());
		
		int[] arr = new int[3];
		
		for(int a=0; a<3; a++)
		{
			arr[a] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[1]);
		
	}

}
