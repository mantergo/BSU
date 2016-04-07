
#include <iostream>
using namespace std;

void read(int *v1, int *v2, char *op);
double menu(int v1, int v2, char *op);
void write(int result);
int result;

int main()
{
	int x, y;
	char op;
	read(&x, &y, &op);
	menu(x, y, &op);
	write(result);


	return 0;
}

void read(int *v1, int *v2, char *op)
{
	cout << "Enter ints: " << endl;
	cin >> *v1 >> *v2;
	cout << "+, -, *, / ?" << endl;
	cin >> op;

}

void write(int result)
{
	cout << result;
}

double menu(int v1, int v2, char *op)
{

	switch (*op)
	{
	case '+':
	{
				result = (v1)+(v2);
				break;
	}
	case '-':
	{
				result = (v1)-(v2);
				break;
	}
	case '*':
	{
				result = (v1)*(v2);
				break;
	}
	case '/':
	{
				result = (double(v1) / (v2));
				break;
	}

	}
	return 0;
	system("pause");
}
