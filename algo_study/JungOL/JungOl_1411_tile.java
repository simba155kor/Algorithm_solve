package solve;

import java.util.Scanner;

public class JungOl_1411_tile {

	static int[] ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ans = new int[100001];
		ans[1] = 1;
		ans[2] = 3;
		
		Scanner sc1 = new Scanner(System.in);
		
		int inp = sc1.nextInt();
		
		if(inp>=3)
		{
			for(int a=3; a<=inp; a++) ans[a] = (ans[a-1] + 2 * ans[a-2]) % 20100529;
		}
		
		System.out.println(ans[inp]);
	}

}
