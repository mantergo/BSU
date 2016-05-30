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


ifstream in("input.txt");
ofstream out("output.txt");
#define cin in
#define cout out
/**/

int a[12][12];
bool used[12][12];
bool byte[12][12][12][12];
vector<pair<int, int> > whoKill[12][12];
int n, m, p;
int dx[8] = { 0, 1, 1, 1, 0, -1, -1, -1 };
int dy[8] = { 1, 1, 0, -1, -1, -1, 0, 1 };

bool isInRect(int x, int y)
{
	return (x >= 0 && y >= 0 && x < n && y < m);
}

void isByte(int x, int y, int px, int py)
{
	if (x == px && y == py)
	{
		byte[x][y][px][py] = true;
		return;
	}
	for (int i = 0; i < 8; ++i)
	{
		int curx = x + dx[i];
		int cury = y + dy[i];
		while (!(curx == px && cury == py) && isInRect(curx, cury))
		{
			curx += dx[i];
			cury += dy[i];
		}
		if (curx == px && cury == py)
		{
			byte[x][y][px][py] = true;
			return;
		}
	}
	byte[x][y][px][py] = false;

}

vector<vector<pair<int, int> > > ans;

void addFerz(int i, int j)
{
	for (int k = 0; k < 8; ++k)
	{
		int curx = i;
		int cury = j;
		while (isInRect(curx + dx[k], cury + dy[k]))
		{
			curx += dx[k];
			cury += dy[k];
			if (!used[curx][cury])
				++a[curx][cury];
			else
				break;
		}
	}
	a[i][j] = 1;
}

void removeFerz(int i, int j)
{
	for (int k = 0; k < 8; ++k)
	{
		int curx = i;
		int cury = j;
		while (isInRect(curx + dx[k], cury + dy[k]))
		{
			curx += dx[k];
			cury += dy[k];
			if (!used[curx][cury])
				--a[curx][cury];
			else
				break;
		}
	}
	a[i][j] = 0;
}

void dfs1(int xx, int yy, vector<pair<int, int> > & curFerz)
{
	int x = xx;
	int y = yy;
	for (int x = xx; x < n; ++x)
	{
		for (int y = (x == xx ? yy : 0); y < m; ++y)
		{
			if (!used[x][y] && !a[x][y])
			{
				curFerz.push_back(make_pair(x, y));
				addFerz(x, y);
				dfs1(x, y, curFerz);
				if (curFerz.size() > ans.back().size())
				{
					ans.clear();
					ans.push_back(curFerz);
				}
				else
					if (curFerz.size() == ans.back().size())
						ans.push_back(curFerz);
				removeFerz(x, y);
				curFerz.pop_back();
			}
		}
	}
}

void dfs(int xx, int yy, vector<pair<int, int> > & curFerz)
{
	int x = xx;
	int y = yy;
	for (int x = xx; x < n; ++x)
	{
		for (int y = (x == xx ? yy : 0); y < m; ++y)
		{
			if (!used[x][y] && !a[x][y])
			{
				bool isFind = 0;
				vector<pair<int, int> > possible;
				for (int i = 0; i < whoKill[x][y].size(); ++i)
				{
					const pair<int, int> & curPair = whoKill[x][y][i];
					if (!used[curPair.first][curPair.second] && !a[curPair.first][curPair.second] && (curFerz.size() == 0 || curPair >= curFerz.back()))
					{
						possible.push_back(curPair);
						isFind = 1;
					}
				}
				for (int i = 0; i < possible.size(); ++i)
				{
					curFerz.push_back(possible[i]);
					addFerz(possible[i].first, possible[i].second);
					dfs(x, y, curFerz);
					if (curFerz.size() > ans.back().size())
					{
						ans.clear();
						ans.push_back(curFerz);
					}
					else
						if (curFerz.size() == ans.back().size())
							ans.push_back(curFerz);
					removeFerz(possible[i].first, possible[i].second);
					curFerz.pop_back();
				}
				return;
			}
		}
	}
}

void make() {

	for (int i = 0; i < p; ++i)
	{
		int x, y;
		cin >> x >> y;
		used[x][y] = true;
	}
	ans.push_back(vector<pair<int, int> >(0));
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			if (!used[i][j])
			{
				vector<pair<int, int> > curFerz(1, make_pair(i, j));
				addFerz(i, j);
				dfs1(i, j, curFerz);
				removeFerz(i, j);
			}
		}
	}
	cout << ans[0].size() << "\n";
	cout << ans.size() << "\n";
	for (int i = 0; i < ans.size(); ++i)
	{
		for (int j = 0; j < ans[i].size(); ++j)
		{
			cout << ans[i][j].first << " " << ans[i][j].second;
			if (j + 1 != ans[i].size())
				cout << " ";
		}
		if (i + 1 != ans.size())
			cout << endl;
	}
	//cout << end - start;




}

void make2() {

	//n = m = 10;
	/*vector<pair<int, int> > black;
	for(int i = 0; i < n; ++i)
	for(int j = 0; j < m; ++j)
	if(rand() % 4 == 0)
	black.push_back(make_pair(i,j));*/
	//p = black.size();
	//p = 0;
	for (int i = 0; i < p; ++i)
	{
		int x, y;
		cin >> x >> y;
		//x = black[i].first;
		//y = black[i].second;
		used[x][y] = true;
	}
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			for (int i1 = 0; i1 < n; ++i1)
			{
				for (int j1 = 0; j1 < m; ++j1)
				{
					isByte(i, j, i1, j1);
					if (byte[i][j][i1][j1])
						whoKill[i1][j1].push_back(make_pair(i, j));
				}
			}
		}
	}
	ans.push_back(vector<pair<int, int> >(0));
	vector<pair<int, int> > curFerz(0);
	dfs(0, 0, curFerz);
	cout << ans[0].size() << "\n";
	cout << ans.size() << "\n";
	for (int i = 0; i < ans.size(); ++i, cout << endl)
		for (int j = 0; j < ans[i].size(); ++j)
			cout << ans[i][j].first << " " << ans[i][j].second << " ";
	//cout << "\n\n" << (clock() - curtime) / 1000;

}

int main()
{
	ios_base::sync_with_stdio(0);
	srand(time(0));
	//double curtime = clock();
	cin >> n >> m >> p;
	if ((n > 7) || (m > 7)) {
		make2();
	}
	else { make(); }
	return 0;
}