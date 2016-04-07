

#include <iostream>
#include <fstream>

using namespace std;
void main()
{
	ifstream in("input.txt");
	ofstream out("output.txt");
	char nextChar;
	while (in>>nextChar)
	{
		if (nextChar < '0'||nextChar > '9')
			out << nextChar;
	}
	in.close();
	out.close();
}

