#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <cmath>
#include <vector>
#include <fstream>

using namespace std;


vector < vector<int> > g;
vector<int> mt;
vector<char> used;
int cFITe = 0;


struct rect {
    
    double a;
    double b;
    
    rect(double _a, double _b){
        
        a = _a;
        b = _b;
        
    }
};


bool try_kuhn(int v) {
    if (used[v])  return false;
    used[v] = true;
    for (size_t i = 0; i<g[v].size(); ++i) {
        int to = g[v][i];
        if (mt[to] == -1 || try_kuhn(mt[to])) {
            mt[to] = v;
            return true;
        }
    }
    return false;
}


bool fits(double a, double b, double A, double B) {
    if (a <= A && b <= B) return true;
    if (a <= B && b <= A) return true;
    
    if (a > b) { double t = a; a = b; b = t; }
    if (A < B) { double t = A; A = B; B = t; }
    
    double left = 0, right = 1;
    for (int k = 0; k < 80; k++) {
        double t = (left + right) / 2;
        double s = sqrt(1 - t * t);
        
        double W = a * t + b * s;
        double H = a * s + b * t;
        const double EPS = 1e-9;
        
        if (W < A + EPS && H < B + EPS) {
            // rotate rectangle clockwise by angle asin(t)
            return true;
        }
        
        if (H < B)
        // angle is too small
        left = t;
        else
        // angle is too big
        right = t;
    }
    
    return false;
}



int main() {
    
    freopen("input.in", "r",stdin);
    freopen("output.out", "w", stdout);
    
    int n, k;
    
    cin >> n;
    
    k = n;
    
    
    
    vector<rect> cards, envs;
    
    for (int p = 0; p<n; p++){
        double temp_a, temp_b;
        cin >> temp_a >> temp_b;
        rect temp(temp_a, temp_b);
        cards.push_back(temp);
    }
    
    for (int p = 0; p<n; p++){
        double temp_a, temp_b;
        cin >> temp_a >> temp_b;
        //cout << temp_a;
        rect temp(temp_a, temp_b);
        envs.push_back(temp);
    }
    
    //    rect t1(2,2);
    //    rect t2(1,1);
    //    rect t3(1,2);
    //    rect t4(8,9);
    //
    //    cards.push_back(t1);
    //    cards.push_back(t2);
    //    cards.push_back(t4);
    //    envs.push_back(t1);
    //    envs.push_back(t2);
    //    envs.push_back(t3);
    
    
    
    for (int i = 0; i < n; i++){
        vector<int> temp;
        for (int j = 0; j < n; j++) {
            if (fits(cards[i].a, cards[i].b, envs[j].a, envs[j].b)){
                temp.push_back(j);
            }
        }
        g.push_back(temp);
    }
    
    
    /*for (int l = 0; l<n; l++) {
     cout << g[l].size() << endl;
     }
     */
    
    
    
    mt.assign(k, -1);
    for (int v = 0; v<n; ++v) {
        used.assign(n, false);
        bool countTR = try_kuhn(v);
        if (countTR){ cFITe++; }
    }
    
    /*for (int i = 0; i<k; ++i)
     if (mt[i] != -1)
     printf("%d %d\n", mt[i] + 1, i + 1);*/
    
    
    if (cFITe == n){ cout << "YES"; }
    else { cout << "NO" << endl << cFITe; }
    
    
    
    return 0;
}