#include <string>
#include <vector>
#include<iostream>


using namespace std;

int board[5][5];
vector<vector<string>> places2;


void func(int x)
{
    vector<string> now_V = places2[x];

    for (int a = 0; a < 5; a++)
    {
        for (int b = 0; b < 5; b++)
        {
            board[a][b] = now_V[a][b];
        }
    }


    for (int a = 0; a < 5; a++)
    {
        for (int b = 0; b < 5; b++)
        {
            cout << board[a][b] << " ";
        }
        cout << "\n";
    }

}


vector<int> solution(vector<vector<string>> places) {
    places2 = places;
    func(0);
    vector<int> answer;
    return answer;
}


int main()
{
    vector<vector<string>> V = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
    {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
     {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
      {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
       {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

    vector<int> ans = solution(V);

    for (int a = 0; a < ans.size(); a++)
    {
        cout << ans[a] << " ";
    }
}