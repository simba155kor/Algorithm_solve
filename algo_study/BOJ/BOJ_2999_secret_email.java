package zany1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999_secret_email {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br1.readLine();
		
		int R = S.length();
		int C = R;
		int temp_R =0;
		
		for(int a=1; a*a<=R; a++)
		{
			if(R%a == 0) 
			{
				C = R/a;
				temp_R = a;
			}
		}
		
		char[][] board = new char[temp_R][C];
		int idx=0;
		
		for(int a=0; a<C; a++)
		{
			for(int b=0; b<temp_R; b++)
			{
				board[b][a] = S.charAt(idx++);
			}
		}
		
		for(int a=0; a<temp_R; a++)
		{
			for(int b=0; b<C; b++)
			{
				System.out.print(board[a][b]);
			}
		}
		
	}

}
