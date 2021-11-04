package solve;

import java.util.Scanner;

public class BOJ_16171_나는친구가적다 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc1 = new Scanner(System.in);
		
		String S1 = sc1.nextLine();
		String S2 = sc1.nextLine();
		String S3 ="";
		
		for(int a=0, end=S1.length(); a<end; a++)
		{
			char now = S1.charAt(a);
			if(now >='0' && now<='9') continue;
			S3 += now;
		}
		if(S3.contains(S2)) System.out.println(1);
		else System.out.println(0);
	}

}
