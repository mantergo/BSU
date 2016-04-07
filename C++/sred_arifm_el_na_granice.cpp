#include <iostream>
#include <ctime>
#include <iomanip>
using namespace std;

int** read(int n, int m);
double sred_arifm(int** M, int n, int m);
int kolichestvo(int**M, int n, int m, double s_a);
void write(int n);
void writeMatrix(int** M, int n, int m);



int main()
{
	int n, m;
	int** M;
	double s_a;
	int kolvo;
	cout << "Enter n: ";
	cin >> n;
	cout << "Enter m: ";
	cin >> m;
	M=read( n,  m);
  s_a =  sred_arifm(M, n, m);
 kolvo = kolichestvo(M, n, m, s_a);
 writeMatrix(M, n, m);
	 write (kolvo);

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

double sred_arifm(int** M, int n, int m)
{
	int SUM = 0;
	for (int i = 0; i < n; i++)
	for (int j = 0; j < m; j++)
		SUM += M[i][j];

	int s_a = SUM / (n*m);
		return s_a;
}
 
int kolichestvo(int**M, int n, int m, double s_a)
{
	int kolvo = 0;
	for (int i = 0; i < n; i++)
	for (int j = 0; j < m; j++)
	{
		if (s_a < M[i][j])
			kolvo += 1;
	}
	return kolvo;
}
void writeMatrix(int** M, int n, int m)
{
	for (int i = 0; i < n; i++)
	for (int j = 0; j < m; j++)
		cout << M[i][j]<<' ';
}

void write(int n)
{
	
	cout << "Kolichestvo = " << n;
}
