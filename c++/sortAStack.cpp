#include <iostream>
#include <stack>

using namespace std;

stack<int> sortStack(stack<int> *);
void transferStackTops(stack<int> *, stack<int> *);
void printStack(stack<int>);

int main() {
    int test[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, -1};
    stack<int> s;
    for (int i = 0; i < 10; ++i) s.push(test[i]);
    printStack(s);
    printStack(sortStack(&s)); 
    return 0;
}

stack<int> sortStack(stack<int> *s) {
    stack<int> aux;
    while (!s->empty()) {
        // ---------------------------------------------
        // Continue till s is empty
        if (aux.empty() || aux.top() >= s->top()) {
            transferStackTops(s, &aux);
        } else {
            int popped = s->top();
            s->pop();
            while (!aux.empty() && aux.top() < popped) {
                transferStackTops(&aux, s);
            }
            aux.push(popped);
        }
        // ---------------------------------------------
    }
    return aux;
}

void transferStackTops(stack<int> *from, stack<int> *to) {
    to->push(from->top());
    from->pop();
}

void printStack(stack<int> s) {
    while (!s.empty()) {
        cout << s.top() << " ";
        s.pop();
    }
    cout << endl;
}