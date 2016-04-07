#include <iostream>
#include <string.h>

using namespace std;

void main() 
{
	char str[81];
	cout << "Enter string: " << endl;
	cin.getline(str, 80);
	int i = 0;
	char temp;
	while (str[i])
	{
		if (str[i] == str[i + 1])
		{
			cout << str[i];
			temp = str[i];
			while (str[i] == temp)
				i++;
		}
		else
		{
			cout << str[i];
			i++;
		}
	}

	system("pause");

}