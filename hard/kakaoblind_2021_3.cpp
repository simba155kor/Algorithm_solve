

#include <string>
#include <vector>
#include<iostream>
#include<algorithm>

using namespace std;

// 코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
// 지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
// 지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
// 선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.

bool cmp1(int a1, int a2)
{
    if(a1> a2 ) return true;
    else return false;
}

vector<int> V1[4][3][3][3];

vector<int> func(vector<string> info, vector<string> query)
{
    vector<int> ans;

    for(int a=0; a<info.size(); a++)
    {
        string now_s = info[a];

        vector<pair<int, string>> TEMP_V;
        int idx1=0;
        int cnt1=0;

        for(int b=0; b<now_s.size(); b++)
        {
            if(now_s[b]==' ')
            {
                string temp = now_s.substr(idx1, b -idx1);
                
                TEMP_V.push_back({cnt1, temp});
                idx1 = b+1;

                cnt1++;
            }
        }

        int tar1 =-1;
        int tar2 =-1;
        int tar3 =-1;
        int tar4 =-1;

        for(int b=0; b<TEMP_V.size(); b++)
        {
            int now_i = TEMP_V[b].first;
            string now_s2 = TEMP_V[b].second;

            if(now_i == 0)
            {
                if(now_s2 == "cpp") tar1 =0;
                if(now_s2 == "java") tar1 =1;
                if(now_s2 == "python") tar1 =2;
            }
            if(now_i == 1)
            {
                if(now_s2 == "backend") tar2 =0;
                if(now_s2 == "frontend") tar2 =1;
            }
            if(now_i == 2)
            {
                if(now_s2 == "junior") tar3 =0;
                if(now_s2 == "senior") tar3 =1;
            }
            if(now_i == 3)
            {
                if(now_s2 == "chicken") tar4 =0;
                if(now_s2 == "pizza") tar4 =1;
            }

        }
        

        string temp = now_s.substr(idx1, now_s.size()-idx1);
        int temp_int = stoi(temp);

        V1[tar1][tar2][tar3][tar4].push_back(temp_int);

        V1[3][tar2][tar3][tar4].push_back(temp_int);
        V1[tar1][2][tar3][tar4].push_back(temp_int);
        V1[tar1][tar2][2][tar4].push_back(temp_int);
        V1[tar1][tar2][tar3][2].push_back(temp_int);
        
        V1[3][2][tar3][tar4].push_back(temp_int);
        V1[3][tar2][2][tar4].push_back(temp_int);
        V1[3][tar2][tar3][2].push_back(temp_int);
        V1[tar1][2][2][tar4].push_back(temp_int);
        V1[tar1][2][tar3][2].push_back(temp_int);
        V1[tar1][tar2][2][2].push_back(temp_int);

        V1[3][2][2][tar4].push_back(temp_int);
        V1[3][2][tar3][2].push_back(temp_int);
        V1[3][tar2][2][2].push_back(temp_int);
        V1[tar1][2][2][2].push_back(temp_int);
        
        V1[3][2][2][2].push_back(temp_int);
    }

    for(int a=0; a<4; a++)
    {
        for(int b=0; b<3; b++)
        {
            for(int c=0; c<3; c++)
            {
                for(int d=0; d<3; d++)
                {
                    sort(V1[a][b][c][d].begin(), V1[a][b][c][d].end(), cmp1);
                }
            }
        }
    }

    
    for(int a=0; a<query.size(); a++)
    {
        string now_s = query[a];

        int tar1 = 3;
        int tar2 = 2;
        int tar3 = 2;
        int tar4 = 2;
        
        int idx1=0;
        int tag=0;
        int now_i=0;
        for(int b=0; b<now_s.size(); b++)
        {
            if(tag==1)
            {
                if(now_s[b] == ' ') tag=0;
                
                continue;
            }
            if(now_s[b] == ' ' && tag==0)
            {
                string now_s2 = now_s.substr(idx1, b - idx1);

                if(now_i == 0)
                {
                    if(now_s2 == "cpp") tar1 =0;
                    if(now_s2 == "java") tar1 =1;
                    if(now_s2 == "python") tar1 =2;
                }
                if(now_i == 1)
                {
                    if(now_s2 == "backend") tar2 =0;
                    if(now_s2 == "frontend") tar2 =1;
                }
                if(now_i == 2)
                {
                    if(now_s2 == "junior") tar3 =0;
                    if(now_s2 == "senior") tar3 =1;
                }
                if(now_i == 3)
                {
                    if(now_s2 == "chicken") tar4 =0;
                    if(now_s2 == "pizza") tar4 =1;
                }

                idx1 = b + 5;
                now_i++;
                tag=1;
            }

        }

        idx1-=4;
        string temp = now_s.substr(idx1, now_s.size()-idx1);
        int temp_int = stoi(temp);

        int ans_cnt=0;

        for(int b=0; b<V1[tar1][tar2][tar3][tar4].size(); b++)
        {
            if(V1[tar1][tar2][tar3][tar4][b] < temp_int) break;
            ans_cnt++;
        }

        ans.push_back(ans_cnt);
    }

    return ans;
}


vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer = func(info, query);
    return answer;
}



