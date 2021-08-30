import java.util.ArrayList;

class Solution {
	static int[] orders_val;
	static boolean[] check;
	static int cnt1=0;
	static int[] trans;
	static boolean[] check2;
	static ArrayList<ArrayList<Integer>> ans;
	

	static int this_max=0;
	
    public String[] solution(String[] orders, int[] courses)
	{
		// TODO Auto-generated method stub
		
		//20 * 10 
		
		check = new boolean[26];
		orders_val = new int[orders.length];
		
		for(int a=0, end = orders.length; a<end; a++)
		{
			int temp_ans = 0; 
			String now = orders[a];
			for(int b=0, end2 = now.length(); b<end2; b++)
			{
				char now_c = now.charAt(b);
				int now_c_i = now_c -'A';
				temp_ans |= (1<<now_c_i);
				if(check[now_c_i] == false)
				{
					check[now_c_i] = true;
					cnt1++;
				}
			}
			
			orders_val[a] = temp_ans;
		}
		
		trans = new int[cnt1];
		check2 = new boolean[cnt1];
		int trans_id =0;
		
		for(int a=0; a<26; a++)
		{
			if(check[a] == false ) continue;
			trans[trans_id] = a;
			trans_id++;
		}
		
		ArrayList<String> real_ans = new ArrayList<String>();
		
		for(int a=0; a<courses.length; a++)
		{
			int now_course = courses[a];
			ArrayList<Integer> arr1 = new ArrayList<Integer>();
			ans = new ArrayList<ArrayList<Integer>>();
			comb(0, 0, now_course, arr1);
			
			for(int c=0; c<ans.size(); c++)
			{
				String temp ="";
				for(int d=0; d<ans.get(c).size(); d++)
				{
					int cc = ans.get(c).get(d) + 'A';
					char CC1 = (char)cc;
					
					temp+=CC1;
				}
				real_ans.add(temp);
			}
			
			this_max=0;
		}
		
		real_ans.sort(null);
		
        String[] real_ans2 = new String[real_ans.size()];
        for(int a=0; a<real_ans.size(); a++) real_ans2[a] = real_ans.get(a);
        
        return real_ans2;
	}
    
    
    static void comb(int now, int prev_a, int target, ArrayList<Integer> arr1)
	{
		if(now == target)
		{
			// do it
			int all_this_cnt =0;
			
			for(int a=0; a<orders_val.length; a++)
			{
				int now_order = orders_val[a];
				int this_cnt=0;
				for(int b=0; b<arr1.size(); b++)
				{
					int checkit = arr1.get(b);
					int checkit2 = (1<<checkit);
					
					if((now_order & checkit2) !=0)
					{
						this_cnt++;
					}
				}
				if(this_cnt != target) continue;
				
				all_this_cnt++;
			}
			
			//System.out.println(": " + all_this_cnt );
			if(all_this_cnt<=1) return;
            
			if(all_this_cnt > this_max)
			{
				ans = new ArrayList<ArrayList<Integer>>();
				ArrayList arr2 = new ArrayList<Integer>();
				for(int a=0; a<arr1.size(); a++)
				{
					arr2.add(arr1.get(a));
				}
				
				ans.add(arr2);
				this_max = all_this_cnt;
			}
			else if(all_this_cnt == this_max)
			{
				ArrayList arr2 = new ArrayList<Integer>();
				for(int a=0; a<arr1.size(); a++)
				{
					arr2.add(arr1.get(a));
				}
				
				ans.add(arr2);
			}
			
			return;
		}
		
		for(int a=prev_a; a<cnt1; a++)
		{
			if(check2[a]) continue;
			
			check2[a] = true;
			arr1.add(trans[a]);
			comb(now+1, a+1, target, arr1);
			arr1.remove(arr1.size()-1);
			check2[a] = false;
		}
	
	}
}