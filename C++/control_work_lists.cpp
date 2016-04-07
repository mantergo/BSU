// control_work_lists.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

struct Node {
	int number;
	Node *next, *prev;
};

Node *first=NULL, *last=first;


void addNewNode(int new_number) {
	if(first==NULL) {
		first=new Node;
		first->next=NULL;
		first->prev=NULL;
		first->number=new_number;
		last=first;
	}
	else {
		Node *temp=new Node;
		temp->number=new_number;
		temp->next=NULL;
		temp->prev=last;
		last->next=temp;
		last=temp;
	}
}

void showList() {
	Node *temp=first;
	while(temp->next!=NULL) {
		cout << temp->number << " ";
		temp=temp->next;
	}
	cout << last->number << endl;
}

void delete_and_addToEnd() {
	Node *cur=first, *old_last=last;
	int count=0;
	if(first==NULL) 
		return;
	else 
		while (cur!=old_last) {
			count++;
			Node *temp=cur->prev, *temp1=cur->next;
			if (count%2==0) {
				addNewNode(cur->number);
				temp->next=temp1;
				temp1->prev=temp;
				cur=temp1;
			}
			else
				cur=cur->next;
		}
		if ((++count)%2==0){
			Node *temp=cur->prev, *temp1=cur->next;
			addNewNode(cur->number);
			temp->next=temp1;
			temp1->prev=temp;
			cur=temp1;
		}
}

void find() {
	Node *cur=first;
	int count=0, Max=-100, index;
	if (cur==NULL)
		return;
	else {
		while (cur->next!=NULL ) {
			count++;
			if (count%3==0) 
				if(cur->number>Max) {
					Max=cur->number;
					index=count;
				}
				cur=cur->next;
		}
		if(cur->number>Max)	{
			Max=cur->number;
			index=count;
		}
	}
	cout << "MAX = " << Max << " INDEX = " << index << endl; 
}

void Swap(int i, int j) {
	Node *p1=first, *p2=first;
	int count=0;
	while(i > 0) {
		if(p1->next!=NULL) {
			p1 = p1->next;
			i--;
		}
	}
	while(j > 0) {
		if(p2->next!=NULL) {
			p2 = p2->next;
			j--;
		}
	}
	swap(p1->number, p2->number);
}

int _tmain(int argc, _TCHAR* argv[])
{
	int i=0;
	int num;
	int N;
	cout << "The number of elements: ";
	cin >> N;
	cout << "Pass the elements: " << endl;
	while (i<N)  {
		cin >> num;
		addNewNode(num);
		i++;
	}
	cout << "Created list: " << endl;
	showList();
	cout << "List after delete: " << endl; // элементы с четными номерами удалены и помещены в конец
	delete_and_addToEnd();
	showList();
	find();
	//инвертировать подпоследовательность элементов с номерами, кратными трем
	int x=2;
	int n=N;
	while(n>=3) {
		while(n%3!=0) 
			n--;
		if (x<n)
			Swap(x,n-1);
		x+=3;
		n-=3;
	}
	cout << "List after reversed subsequence:" << endl;
	showList();
	system("pause");
	return 0;
}

