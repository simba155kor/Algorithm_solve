package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj_1786_search_rabinkarp {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		char[] target = br1.readLine().toCharArray();
		char[] pattern = br1.readLine().toCharArray();
		
		int tsize = target.length;
		int psize = pattern.length;
		
		if(tsize< psize) System.out.println(0);
		else
		{
			int base = 26;
			long mod = (int)1e9 + 7;
			long thash = 0;
			long phash = 0;
			long power = 1;
			
			for(int a=0; a<psize; a++)
			{
				phash = (base*phash + pattern[a]) % mod;
				thash = (base*thash + target[a]) % mod;
				if(a!=0) power = (base*power) % mod;
			}
			
			LinkedList<Integer> list1 = new LinkedList<>();
			
			for(int a=0, end= tsize-psize; a<=end; a++)
			{
				if(phash == thash) list1.add(a);
				
				if(a+psize == tsize) break;
				
				//¾Õ¿¡²¨ »©°í , µÚ¿¡²¨ ´õÇØÁÖ±â
				thash =  (base * ( thash - target[a] * power ) + target[a+psize]) % mod;
				
				if(thash <0) thash +=mod;
				
			}
			
			System.out.println(list1.size());
			
			for(Integer a : list1)
			{
				System.out.print(a+1 + " ");
			}
		}
		
		
	}

}
