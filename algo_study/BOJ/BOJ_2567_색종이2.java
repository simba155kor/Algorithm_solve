import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {

	static int[][] board = new int[100][100];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		int N = Integer.parseInt(br1.readLine());
		
		for(int t=0; t<N; t++)
		{
			st1 = new StringTokenizer(br1.readLine());
			
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			
			for(int a=y; a<y+10; a++)
			{
				for(int b=x; b<x+10; b++)
				{
					board[a][b] = 1;
				}
			}
		}
		
		
		int ans=0;
		
		for(int a=0; a<100; a++)
		{
			for(int b=0; b<100; b++)
			{
				if(board[a][b]==0) continue;
				
				for(int dr=0; dr<4; dr++)
				{
					int yy = a + dy[dr];
					int xx = b + dx[dr];
					
					if(yy<0 || xx<0 || yy>=100 || xx>=100) 
					{
						ans++;
						continue;
					}
					if(board[yy][xx] == 0) ans++;
					
				}//d fd s
			} 
		}
		
		System.out.println(ans);
	}

}
