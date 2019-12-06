#include <iostream>
#include <array>
#include <stack>

using namespace std;

int main() {
    array<int, 8> arr = { 73, 74, 75, 71, 69, 72, 76, 73 };
    array<int, 8> output = {};
    stack<int> st;
    for (auto i = 1; i < arr.size(); ++i)
    {
        if (arr[i] > arr[i - 1])
            output[i - 1] = 1;
        else
            st.push(i - 1);
        if (!st.empty())
        {
            while (!st.empty() && arr[i] > arr[st.top()])
            {
                output[st.top()] = i - st.top();
                st.pop();
            }
        }
    }

    for (auto i = 0; i < arr.size(); ++i)
    {
        cout << output[i] << " ";
    }
    cout << endl;
    return 0;
}
