#define PI       atan(1)*4

#include <iostream>
#include <math.h>
#include <iomanip>

using namespace std;

double razd_raznosti[30][30];
double a = -3;
double b = 3;



double chebyshev(double k, double n)
{
	return ((a + b) / 2 + 0.5*(b - a)*cos(((2 * k + 1)*PI) / (2 * (n + 1))));
}

double function(double t)
{

	return t*t*atan((7 * t )/ 13);
}

void Newton(int n)
{
	for (int k = 0; k <= n; ++k)
	{
		razd_raznosti[2 * k][0] = chebyshev(k, n);
		razd_raznosti[2 * k][1] = function(razd_raznosti[2 * k][0]);
	}
	int i_first = 1;
	int j_first = 2;
	int jumps;
	int diff = 1;
	while (j_first <= n + 2)
	{
		jumps = n + 1 - j_first;
		int i = i_first;
		while (jumps >= 0) {
			razd_raznosti[i][j_first] = (razd_raznosti[i + 1][j_first - 1] - razd_raznosti[i - 1][j_first - 1]) / (razd_raznosti[i + diff][0] - razd_raznosti[i - diff][0]);
			i += 2;
			jumps -= 1;
		}
		diff += 1;
		i_first += 1;
		j_first += 1;
	}
	for (int i = 0; i < n + 4; ++i) {
		for (int j = 0; j < n + 2; ++j) {
			cout << razd_raznosti[i][j] << fixed<< " ";
		}
		cout << endl;
	}


	


	double newt = 1;
	for (int i = 0; i < n; i++){
		
		cout << endl;
		newt*= razd_raznosti[i][i + 1];
		

	}
	//cout << newt;

}

//double S = razd_raznosti[0][1], p = 1;

double newtonPol (int argx,int n){
	double S = razd_raznosti[0][1], p = 1;

	cout<<endl << S;
	//cout << endl << razd_raznosti[0][1];
	for (int i = 0; i<n; i++)
	{
		p = p*(argx - razd_raznosti[2*i][0]);
		S += razd_raznosti[i+1][i+2] * p;
		cout<<endl<<"l" << razd_raznosti[i + 1][i + 2];
		cout<<endl << S;
		cout << endl << p;
	}

	return S;

}


int main()
{
	Newton(2);
	Newton(3);
	Newton(4);
	Newton(5);
	Newton(6);
	Newton(7);
	Newton(8);
	Newton(9);
	
	double S = newtonPol(razd_raznosti[0][0], 3);
	cout << endl;
	cout << S;


	system("pause");
	
	return 0;
}