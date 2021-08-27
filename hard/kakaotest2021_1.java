package zany1;

public class kakaotest2021_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = func("abcdefghijklmn.p");
	}

	public static String func(String new_id)
    {
    	String temp_id1 = "";
    	
    	for(int a=0, end = new_id.length(); a<end; a++)
    	{
    		char now = new_id.charAt(a);
    		
    		if(now>='A' && now<='Z')
			{
    			now -= 'A';  
    			now += 'a';
			}
    		
    		temp_id1 += now;
    	}
    	
    	
    	String temp_id2 = "";
    	
    	for(int a=0, end = temp_id1.length(); a<end; a++)
    	{
    		char now = temp_id1.charAt(a);
    		
    		if((now>='a' && now<='z') || (now>='0' && now<='9') || now=='-' || now=='_' || now=='.')
			{
    			temp_id2 += now;
			}
    		
    	}
    	
    	
    	String temp_id3 = "";
    	
    	int tag=0;
    	for(int a=0, end = temp_id2.length(); a<end; a++)
    	{
    		char now = temp_id2.charAt(a);
    		
    		if(now != '.')
			{
    			tag=0;
    			temp_id3 += now;
			}
    		else
    		{
    			if(tag==0)
				{
    				temp_id3 += now;
    				tag=1;
				}
    		}
    		
    	}
    	
    	
    	String temp_id4= "";
    	int idx_st =0;
    	int idx_ed = temp_id3.length();
    	
    	if(temp_id3.charAt(0) == '.') idx_st++;
    	if(temp_id3.charAt(idx_ed-1) == '.') idx_ed--;
    	
    	for(int a=idx_st, end=idx_ed; a<end; a++)
    	{
    		temp_id4 += temp_id3.charAt(a);
    	}
    	
    	
    	if(temp_id4.equals("")) temp_id4 += 'a';
    	
    	String temp_id5="";
    	
    	if(temp_id4.length()>15)
    	{
    		int idx_eds = 15;
    		if(temp_id4.charAt(14) == '.') idx_eds--;
    		for(int a=0; a<idx_eds; a++)
    		{
    			temp_id5 += temp_id4.charAt(a);
    		}
    	}
    	else
    	{
    		for(int a=0; a<temp_id4.length(); a++)
        	{
        		temp_id5 += temp_id4.charAt(a);
        	}
    		while(temp_id5.length()<=2)
    		{
    			temp_id5 += temp_id4.charAt(temp_id4.length()-1);		
    		}
    	}
    	
    	return temp_id5;
    }
}


class Solution {
    public String solution(String new_id) {
        String answer = func(new_id);
        return answer;
    }
    
    public String func(String new_id)
    {
    	String temp_id1 = "";
    	
    	for(int a=0, end = new_id.length(); a<end; a++)
    	{
    		char now = new_id.charAt(a);
    		
    		if(now>='A' && now<='Z')
			{
    			now -= 'A';  
    			now += 'a';
			}
    		
    		temp_id1 += now;
    	}
    	
    	
    	String temp_id2 = "";
    	
    	for(int a=0, end = temp_id1.length(); a<end; a++)
    	{
    		char now = temp_id1.charAt(a);
    		
    		if((now>='a' && now<='z') || (now>='0' && now<='9') || now=='-' || now=='_' || now=='.')
			{
    			temp_id2 += now;
			}
    		
    	}
    	
    	
    	String temp_id3 = "";
    	
    	int tag=0;
    	for(int a=0, end = temp_id2.length(); a<end; a++)
    	{
    		char now = temp_id2.charAt(a);
    		
    		if(now != '.')
			{
    			tag=0;
    			temp_id3 += now;
			}
    		else
    		{
    			if(tag==0)
				{
    				temp_id3 += now;
    				tag=1;
				}
    		}
    		
    	}
    	
    	
    	String temp_id4= "";
    	int idx_st =0;
    	int idx_ed = temp_id3.length();
    	
    	if(temp_id3.charAt(0) == '.') idx_st++;
    	if(temp_id3.charAt(idx_ed-1) == '.') idx_ed--;
    	
    	for(int a=idx_st, end=idx_ed; a<end; a++)
    	{
    		temp_id4 += temp_id3.charAt(a);
    	}
    	
    	
    	if(temp_id4.equals("")) temp_id4 += 'a';
    	
    	String temp_id5="";
    	
    	if(temp_id4.length()>15)
    	{
    		int idx_eds = 15;
    		if(temp_id4.charAt(14) == '.') idx_eds--;
    		for(int a=0; a<idx_eds; a++)
    		{
    			temp_id5 += temp_id4.charAt(a);
    		}
    	}
    	else
    	{
    		for(int a=0; a<temp_id4.length(); a++)
        	{
        		temp_id5 += temp_id4.charAt(a);
        	}
    		while(temp_id5.length()<=2)
    		{
    			temp_id5 += temp_id4.charAt(temp_id4.length()-1);		
    		}
    	}
    	
    	return temp_id5;
    }
}
