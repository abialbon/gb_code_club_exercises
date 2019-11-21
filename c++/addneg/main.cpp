#include <iostream>

using std::cout;
using std::endl;

int add(int x, int y) {
    return x + y;
}

int neg(int x) {
    return -x;
}

int sub(int x, int y) {
    return add(x, neg(y));
}

long mul(int x, int y) {
    int a = y < 0 ? neg(y) : y;
    long accum = 0;
    for (int i = 0; i < a; ++i) {
        accum = add(accum, x);
    }
    if (y < 0) return neg(accum);
    return accum;
}

int divide(int x, int y) {
    if (y == 0) throw "Division by zero!";
    int a = x < 0 ? neg(x) : x;
    int c = y < 0 ? neg(y) : y;
    int count = 0;
    int accum = 0;
    while(add(accum, c) <= a) {
        accum = add(accum, c);
        count = add(count, 1);
    }
    if (y < 0) count = neg(count);
    if (x < 0) count = neg(count);
    return count;
}

int main() {
    srand(time(NULL));
    for (int i = 0; i < 10; ++i)
    {
        int r1 = rand() % 100 + 1;
        int r2 = rand() % 100 + 1;
        if (rand() % 100 < 50) r1 = -r1;
        if (rand() % 100 < 50) r2 = -r2;
        if (sub(r1, r2) != r1 - r2)
            cout << "Subtraction did not work for " << r1 << " " << r2 << endl;
        if (mul(r1, r2) != r1 * r2)
            cout << "Multiplication did not work for " << r1 << " " << r2 << endl;
        if (divide(r1, r2) != r1 / r2)
            cout << "Division did not work for " << r1 << " " << r2 << endl;
    }
    cout << "Successfully completed!" << endl;
    return 0;
}