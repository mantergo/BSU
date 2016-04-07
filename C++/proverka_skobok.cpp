#include <iostream>
#include <string.h>
using namespace std;
struct Stack
{
	char data;
	Stack*next;
};

Stack*push(char x, Stack*&top)
{
	Stack*temp = new Stack;
	temp->data = x;
	temp->next = top;
	top = temp;
	return top;
}

Stack*pop(Stack*&top)
{
	if (top != NULL)
	{
		Stack*temp = top;
		top = temp->next;
		delete temp;
	}
	return top;
}

bool check(char*str, Stack*&top)
{
	int i = 0;
	bool x = true;
	while (str[i])
	{
		if (str[i] == '(')
		{
			push(str[i], top);
			x = false;
		}
		else
		{
			if ((str[i] == ')') && (top != NULL))
			{
				pop(top);
				x = true;
			}
			else
				x = false;
		}
			i++;
		
	}
	
	return x;
}

int main()
{
	Stack*top = NULL;
	char str[81];
	cout << "Enter equation " << endl;
	cin.getline(str, 80);
	check(str, top);
	bool m = check(str, top);
	if (m==true)
		cout << "Correct " << endl;
	else
		cout << "Incorrect " << endl;
	system("pause");
}