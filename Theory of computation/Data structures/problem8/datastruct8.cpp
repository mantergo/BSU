#define _CRT_SECURE_NO_WARNINGS
//#pragma comment(linker, "/STACK:16777216")

#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <stack>
#include <fstream>
#include <time.h>
#include <string>
#include <algorithm>
#include <sstream>
#include <cmath>
#include <queue>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
using namespace std;

class Data  {
    public:
    int i;
    int j;
    int prior;
    
    Data(int itemp, int jtemp, int priortemp) {
        i = itemp;
        j = jtemp;
        prior = priortemp;
    }
};

int max(int arg0, int arg1) {
    if (arg0>arg1)
    return arg0;
    else return arg1;
}

struct cmp
{
    bool operator() (Data const &a, Data const &b) {
        return a.prior > b.prior;
    }
};
typedef std::priority_queue<Data, vector<Data>, cmp> my_queue;

void main(void) {
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
    
    const int NN = 100, MM = 100;
    
    int n, m;
    cin >> n;
    cin >> m;
    
    int **mA = new int*[n];
    for (int count = 0; count < n; count++)
    mA[count] = new int[m];
    int **mB = new int*[n];
    for (int count = 0; count < n; count++)
    mB[count] = new int[m];
    bool **find = new bool*[n];
    for (int count = 0; count < n; count++)
    find[count] = new bool[m];
    
    //int mA[NN][MM];
    //int mB[NN][MM];
    //bool find[NN][MM];
    
    my_queue q;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int temp;
            cin >> temp;
            mA[i][j] = temp;
            find[i][j] = false;
            if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                q.push(Data(i, j, mA[i][j]));
                mB[i][j] = mA[i][j];
            }
            else {
                mB[i][j] = 2147483647;
            }
        }
    }
    
    while (!q.empty()) {
        Data tmp = q.top();
        q.pop();
        if (!find[tmp.i][tmp.j]) {
            mB[tmp.i][tmp.j] = tmp.prior;
            find[tmp.i][tmp.j] = true;
            if (tmp.j - 1 >= 0 && mB[tmp.i][tmp.j - 1]>mB[tmp.i][tmp.j]) {
                Data forin = Data(tmp.i, tmp.j - 1, max(mB[tmp.i][tmp.j], mA[tmp.i][tmp.j - 1]));
                q.push(forin);
            }
            if (tmp.j + 1<m && mB[tmp.i][tmp.j + 1]>mB[tmp.i][tmp.j]) {
                Data forin = Data(tmp.i, tmp.j + 1, max(mB[tmp.i][tmp.j], mA[tmp.i][tmp.j + 1]));
                q.push(forin);
            }
            if (tmp.i - 1 >= 0 && mB[tmp.i - 1][tmp.j]>mB[tmp.i][tmp.j]) {
                Data forin = Data(tmp.i - 1, tmp.j, max(mB[tmp.i][tmp.j], mA[tmp.i - 1][tmp.j]));
                q.push(forin);
            }
            if (tmp.i + 1<n && mB[tmp.i + 1][tmp.j]>mB[tmp.i][tmp.j]) {
                Data forin = Data(tmp.i + 1, tmp.j, max(mB[tmp.i][tmp.j], mA[tmp.i + 1][tmp.j]));
                q.push(forin);
            }
        }
    }
    
    int res = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            res += (mB[i][j] - mA[i][j]);
        }
    }
    
    
    
    cout << res;
    
    
    
}