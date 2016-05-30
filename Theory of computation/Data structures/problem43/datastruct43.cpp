#define _CRT_SECURE_NO_WARNINGS
#pragma comment(linker, "/STACK:16777216")

#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <stack>
#include <fstream>
#include <time.h>
#include <string>
#include <algorithm>
#include <sstream>
#include <cmath>
#include <queue>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <queue>
using namespace std;


class Tree {
    public:
    unsigned long long data;
    Tree* left;
    Tree* right;
    
    Tree(unsigned long long _data) {
        data = _data;
        left = NULL;
        right = NULL;
    }
    
    Tree() {
        data = NULL;
        left = NULL;
        right = NULL;
    }
    
    Tree &operator = (Tree const & tree) {
        data = tree.data;
        left = tree.left;
        right = tree.right;
        return *this;
    }
    friend bool operator > (Tree const &a, Tree const &b) {
        return a.data<b.data;
    }
    friend bool operator < (Tree const &a, Tree const &b) {
        return a.data>b.data;
    }
    friend bool operator == (Tree const &a, Tree const &b) {
        return a.data==b.data;
    }
    
};

//struct cmp
//{
//	bool operator() (Tree const &a, Tree const &b) {
//		return a.data > b.data;
//	}
//};
//typedef std::priority_queue<Tree, vector<Tree>, cmp> my_queue;

unsigned long long countLeaf(const Tree* t, unsigned long long count, int k) {
    if (t != NULL) {
        k++;
        count = countLeaf(t->left, count, k);
        count = countLeaf(t->right, count, k);
        if (t->left == NULL && t->right == NULL) {
            k--;
            count += t->data * k;
        }
    }
    return count;
}

void main() {
    
    long time = clock();
    freopen("huffman.in", "r", stdin);
    freopen("huffman.out", "w", stdout);
    unsigned long long n;
    cin >> n;
    //my_queue q;
    priority_queue<Tree> q;
    for (unsigned long long i = 0; i < n; ++i) {
        unsigned long long temp;
        cin >> temp;
        q.push(Tree(temp));
    }
    
    unsigned long long answer = 0;
    Tree *z = new Tree();
    while (q.size() > 1) {
        
        z->left = new Tree(q.top());
        q.pop();
        z->right = new Tree(q.top());
        q.pop();
        z->data = z->left->data + z->right->data;
        q.push(*z);
    }
    
    answer = countLeaf(&q.top(), answer, 0);
    long timeend = clock();
    cout << answer;
    //cout << endl;
    //cout << timeend - time;
    
    
    
}