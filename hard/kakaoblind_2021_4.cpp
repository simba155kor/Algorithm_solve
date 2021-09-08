#include <string>
#include <vector>
#include <iostream>
#define INF 20000001

using namespace std;

int func(int n, int s, int a1, int b1, vector<vector<int>> fares)
{
    int dis1[201][201] = {0,};
    for(int a=1; a<=n; a++)
    {
        for(int b=1; b<=n; b++)
        {
            if(a==b)continue;
            dis1[a][b] = INF;
        }
    }

    for(int a=0; a<fares.size(); a++)
    {
        int x1 = fares[a][0];
        int y1 = fares[a][1];
        int val = fares[a][2];

        dis1[x1][y1] = val;
        dis1[y1][x1] = val;
    }

    // for(int a=1; a<=n; a++)
    // {
    //     for(int b=1; b<=n; b++)
    //     {
    //         cout << dis1[a][b] << " ";
    //     }
    //     cout <<"\n";
    // }

    int dis2[201][201]={0,};

    for(int a=1;a<=n; a++)
    {
        for(int b=1; b<=n; b++)
        {
            dis2[a][b] = dis1[a][b];
        }
    }

    for(int k=1; k<=n; k++)
    {
        for(int a=1; a<=n; a++)
        {
            for(int b=1; b<=n; b++)
            {
                if(dis2[a][b] > dis2[a][k] + dis2[k][b])
                {
                    dis2[a][b] = dis2[a][k] + dis2[k][b];
                }
            }
        }
    }

    int ans1 = dis2[s][a1] + dis2[s][b1];

    for(int a=1; a<=n; a++)
    {
        int temp_ans = dis2[s][a] + dis2[a][a1] + dis2[a][b1];
        if(temp_ans < ans1) ans1 = temp_ans;
    }

    // for(int a=1; a<=n; a++)
    // {
    //     for(int b=1; b<=n; b++)
    //     {
    //         cout << dis2[a][b] << " ";
    //     }
    //     cout <<"\n";
    // }

    return ans1;
}

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = func(n, s, a, b, fares);
    return answer;
}
