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

int mul(int x, int y) {
    int accum = 0;
    if (y > 0) {
        for (int i = 0; i < y; ++i) {
            accum = add(accum, x);
        }
    } else {
        for (int i = y; i < 0; ++i) {
            accum = add(accum, x);
        }
        return neg(accum);
    }
    return accum;
}

int d(int x, int y) {
    if (y == 0) throw "Division by zero!";
    int a = x;
    if (x < 0) a = neg(x);
    int c = y;
    if (y < 0) c = neg(y);

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
    cout << d(-144, -144) << endl;
    return 0;
}