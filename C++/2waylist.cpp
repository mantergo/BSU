

#include <iostream>
using namespace std;

struct Node {
	int number;
	Node *next, *prev;
};

Node *first = NULL, *last = first;


void addNewNode(int new_number);
void createList();
void showList();
void deletePushBack();
void inversion();
void find(); //find min element betwen negative ints

int main()
{
	createList();
	cout << "Created list: " << endl;
	showList();
	cout << "List after delete: " << endl;
	deletePushBack();
	showList();
	inversion();
	cout << "List after inversion: "<< endl;
	showList();
	find();

	system("pause");
	return 0;
}

void addNewNode(int new_number) {
	if (first == NULL) {
		first = new Node;
		first->next = NULL;
		first->prev = NULL;
		first->number = new_number;
		last = first;
	}
	else {
		Node *temp = new Node;
		temp->number = new_number;
		temp->next = NULL;
		temp->prev = last;
		last->next = temp;
		last = temp;
	}
}

void createList() {
	int i = 0;
	int num;
	int N;     
	cout << "The number of elements: ";
	cin >> N;
	cout << "Pass the elements: " << endl;
	while (i < N)  {
		cin >> num;
		addNewNode(num);
		i++;
	}
}

void showList() {           
	Node *temp = first;
	while (temp->next != NULL) {
		cout << temp->number << " ";
		temp = temp->next;
	}
	cout << last->number << endl;
}

void deletePushBack() {   
	Node *cur = first, *old_last = last;
	int count = 0;
	if (first == NULL)
		return;
	else
	while (cur != old_last) {
		count++;
		Node *temp = cur->prev, *temp1 = cur->next;
		if (count % 2 == 0) {
			addNewNode(cur->number);
			temp->next = temp1;
			temp1->prev = temp;
			cur = temp1;
		}
		else
			cur = cur->next;
	}
	if ((++count) % 2 == 0){
		Node *temp = cur->prev, *temp1 = cur->next;
		addNewNode(cur->number);
		temp->next = temp1;
		temp1->prev = temp;
		cur = temp1;
	}
}

void inversion() {
	Node *temp, *cur = first;
	while (cur->next != NULL) {
		temp = cur->next;
		cur->next = cur->prev;
		cur->prev = temp;
		cur = temp;
	}
	cur->next = cur->prev;
	cur->prev = NULL;
	last = first;
	first = cur;
}

void find() {
	Node *cur = first;
	int Min = 0;
	if (cur == NULL)
		return;
	else {
		while (cur->next != NULL) {
			if (cur->number<Min) {
				Min = cur->number;

			}
			cur = cur->next;
		}
		if (cur->number<Min)	{
			Min = cur->number;
		}
	}
	if (Min < 0)
		cout << "Minimum number = " << Min << endl;
	else
		cout << "There is no negative numbers." << endl;


}