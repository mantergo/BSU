#define _CRT_SECURE_NO_WARNINGS
#pragma comment(linker, "/STACK:16777216")

#include <iostream>
#include <fstream>
#include <vector>
#include <ctime>


using namespace std;


vector<pair<int, int> > g[123456];
int parent[123456];
int minAnsForV[123456];

int count(int v)
{
    if (g[v].size() == 0)
    return 0;
    int mn = count(g[v][0].first) + g[v][0].second;
    int mnInd = g[v][0].first;
    for (int i = 1; i < g[v].size(); ++i)
    {
        int nextSon = count(g[v][i].first) + g[v][i].second;
        if (mn > nextSon)
        mn = nextSon, mnInd = g[v][i].first;
    }
    minAnsForV[v] = mnInd;
    return mn;
}

int main(void)
{
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
    int start = clock();
    int n;
    cin >> n;
    for (int i = 1; i <= n; ++i)
    {
        int ind;
        cin >> ind;
        int k;
        cin >> k;
        for (int j = 0; j < k; ++j)
        {
            int slave, cost;
            cin >> slave >> cost;
            parent[slave] = ind;
            g[ind].push_back(make_pair(slave, cost));
        }
    }
    vector<int> ans;
    int cur = 1;
    cout << count(1) << "\n";
    while (cur)
    {
        ans.push_back(cur);
        cur = minAnsForV[cur];
    }
    
    for (int i = 0; i < ans.size(); ++i)
    if (i + 1 != ans.size())
    cout << ans[i] << " ";
    else
    cout << ans[i];
    
    int end = clock();
    //cout << endl;
    //cout << end - start;
}