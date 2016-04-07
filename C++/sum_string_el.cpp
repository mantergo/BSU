
#include <iostream>
#include <ctime>
#include <iomanip>
using namespace std;

int** read(int n, int m);
void writeMatrix(int** M, int n, int m);
void summa(int** M, int n, int m);

int main()
{
	int n, m;
	int **M;
	cout << "Enter n: ";
	cin >> n;
	cout << "Enter m: ";
	cin >> m;
	M = read(n, m);
	read(n, m);
	writeMatrix(M, n, m);
	summa(M, n, m);
	system("pause");
}

int** read(int n, int m)
{

	int **M;
	M = new int*[n];
	for (int i = 0; i<n; i++)
		M[i] = new int[m];
	srand(time(0));

	for (int i = 0; i < n; i++)
	for (int j = 0; j < m; j++)
		M[i][j] = rand() % 10;
	return M;
}

void writeMatrix(int** M, int n, int m)
{
	cout << "Matrix: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cout << setw(2) << M[i][j] << "   ";
		cout << endl;
	}
}

void summa(int** M, int n, int m)
{
	for (int i = 0; i < n; i++)
	{
		int SUM = 0;
		cout << "Row " << (i + 1) << ": ";
		for (int j = 0; j < m; j++)
			SUM += M[i][j];
	

		cout << SUM << endl;
	}
}