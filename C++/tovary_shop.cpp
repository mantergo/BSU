#include <iostream>
#include <fstream>

using namespace std;
struct good
{
	int category;
	char name[30];
	int price;
	int quantity;
};

void main()
{
	ifstream in("goods.txt");
	good goods[100];
	int i = 0;
	int maxPrice;
	while (in >> goods[i].category)
	{
		in >> goods[i].name >> goods[i].price >> goods[i].quantity;
		i++;
	}
	 
	cout << "Enter maxprice: " << endl;
	cin>>maxPrice;
	for (int j = 0; j < i; j++)
	{
		if (goods[j].price <= maxPrice)
		{
			cout << goods[j].category << goods[j].name << goods[j].price << goods[j].quantity << endl;
		}
	}
    ofstream out("output.txt");

	in.close();
	out.close();
	system ("pause");
}