package zany1;

import java.util.Scanner;

public class BOJ_3052_나머지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean[] check = new boolean[50];
		
		int cnt=0;
		for(int t=0; t<10; t++)
		{
			int temp = sc.nextInt();
			if(check[temp%42] == false) check[temp%42] = true;
			else cnt++;
		}
		
		System.out.println(10-cnt);
	}

}
