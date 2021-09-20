#include<iostream>

using namespace std;

int board[1025][1025];
int dp[1025][1025];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    for (int a = 1; a<=n; a++)
    {
        for (int b = 1; b<=m; b++)
        {
            cin >> board[a][b];
        }
    }

    dp[1][1] = board[1][1];

    for (int a = 1; a<=n; a++)
    {
        for (int b = 1; b<=m; b++)
        {
            dp[a][b] = dp[a - 1][b] + (dp[a][b - 1] - dp[a - 1][b - 1]) + board[a][b];
        }
    }

    int k;
    cin >> k;
    for (int a = 0; a < k; a++)
    {
        int y1, x1, y2, x2;
        cin >> y1 >> x1 >> y2 >> x2;
        cout << dp[y2][x2] - dp[y2][x1-1] - dp[y1-1][x2] + dp[y1-1][x1-1] << "\n";
    }
}
