#include "stdafx.h"
#include <iostream>
using namespace std;

struct node {
	node *next;
	int num;
	int ind;
} *first = 0, *last = 0;

void create_list(), show_list(), del(), min(), inversion();

int main()
{
	create_list();
	show_list();

	del();
	show_list();

	min();

	inversion();
	show_list();

	system("pause");

	return 0;
}

void create_list()
{
	int newnum;
	int newind = 0;
	cout << "Enter elements to create a list(enter '-1' to finish): ";
	cin >> newnum;

	while(newnum!=-1) {
		node *ptr = new node;
		ptr->next = 0;
		ptr->num = newnum;
		ptr->ind = ++newind;

		if(first==0) {
			first = last = ptr;
		}
		else {
			last->next = ptr;
			last = ptr;
		}
		cin >> newnum;
	}
}

void show_list() {
	cout << "List:\n";
	for(node *ptr=first; ptr!=0; ptr=ptr->next)
		cout << ptr->ind << ' ' << ptr->num << '\n';
}

void del()
{
	node *saveprev = first, *savelast = last;
	for(node *ptr=first->next; ptr!=savelast->next; )
	{
		if(!(ptr->ind%2)) {
			saveprev->next = ptr ->next;
			node *savedel = ptr;
			ptr = ptr->next;
			last->next = savedel;
			savedel->next = 0;
			last = savedel;
		}
		else {
			saveprev = ptr;
			ptr = ptr->next;
		}
	}

	int i = 1;
	for(node *ptr=first; ptr!=0; ptr= ptr->next)
		ptr->ind = i++;
}

void min()
{
	int min = first->num;
	for(node *ptr=first; ptr!=0; ptr= ptr->next) {
		if(ptr->num > 0 && ptr->num < min) {
			min = ptr->num;
		}
	}
	cout << min << '\n';
}

void inversion()
{
	node *savep = first, *saven = 0;
	for(node *ptr=first; ptr!=0; ptr=saven) {
		if(ptr==first) {
			saven = first->next;
			first->next = 0;
		}
		else {
			saven = ptr->next;
			ptr->next = savep;
			savep = ptr;
		}
	}
	last = first;
	first = savep;
}

void inv()
{
	node *savep = first, *saven = 0;
	int u = (last->ind/2);
	for(node *ptr=first; ptr->ind!=u; ptr=saven) {
		if(ptr==first) {
			saven = first->next;
			first->next = 0;
		}
		else {
			saven = ptr->next;
			ptr->next = savep;
			savep = ptr;
		}
	}
	last = first;
	first = savep;
}
