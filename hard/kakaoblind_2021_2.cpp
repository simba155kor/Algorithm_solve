#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
#include<stack>
#include<map>

using namespace std;

bool cmp1(pair<int, string> a1, pair<int, string> a2)
{
    if(a1.first >= a2.first)
    {
        if(a1.first == a2.first)
        {
            if(a1.second < a2.second) return true;
        }
        else
        {
            return true;
        }
    }

    return false;
}

vector<string> func(vector<string> orders, vector<int> course)
{
    vector<string> ans;

    vector<char> temp;

    int check[30] = {0,};

    for(int a=0; a<orders.size(); a++)
    {
        string now_order = orders[a];

        for(int b=0; b<now_order.size(); b++)
        {
            char now_c = now_order[b];
            int idx = now_c - 'A';

            if(check[idx]==0)
            {
                check[idx] = 1;
                temp.push_back(now_c);
            } 
        }

    }


    for(int a=0; a<course.size(); a++)
    {
        vector<string> set1;

        int now_count = course[a];

        //몇개로 할지. 조합갯수.
        //조합 갯수마다 나올 수 있는 경우의 수 구하고

        vector<int> temp_idx;
        for(int b=0; b<temp.size(); b++) temp_idx.push_back(0);
        for(int b=0; b<now_count; b++)
        {
            temp_idx[b] = 1;
        }

        do
        {
            string tempp;
            for(int a=0; a<temp_idx.size(); a++)
            {
                if(temp_idx[a] == 1) tempp.push_back(temp[a]);
            }

            sort(tempp.begin(), tempp.end());
            set1.push_back(tempp);

        } while (prev_permutation(temp_idx.begin(), temp_idx.end()));
        
        //각 order가 가능한지 확인.
        
        int total_cnt=0;
        vector<pair<int, string>> M1;
        for(int a=0; a<set1.size(); a++)
        {
            int checking[30] = {0,};

            for(int b=0; b<set1[a].size(); b++)
            {
                int idx = set1[a][b] - 'A';
                checking[idx] = 1;
            }


            for(int b=0; b<orders.size(); b++)
            {
                int cnt1=0;

                string course1 = orders[b];
                for(int c=0; c<course1.size(); c++)
                {
                    int xx = course1[c] -'A';
                    if(checking[xx]== 1) cnt1++;
                }

                if(cnt1 == now_count)
                {
                    total_cnt++;
                }
            }

            M1.push_back({total_cnt ,set1[a]});
            total_cnt=0;
        }

        sort(M1.begin(), M1.end(), cmp1);

        int idxxx =0;
        int nowz = M1[0].first;
        if(nowz <= 1 ) continue;
        while (1)
        {
            ans.push_back(M1[idxxx].second);
            idxxx++;
            if(nowz != M1[idxxx].first) break;
            nowz=  M1[idxxx].first;
        }
        
    }


    sort(ans.begin(), ans.end());


    return ans;
}



vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer = func(orders, course);
    return answer;
}
