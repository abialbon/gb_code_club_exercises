#include <iostream>
#include <string>

using namespace std;

string words[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                   "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

string big_words[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

string parse_three(int n, string group) {
    string r = to_string(n);
    string h = r.substr(0, 1);
    r = r.substr(1, 2);
    if (stoi(r) <= 20) {
        r = words[stoi(r)];
    } else {
        string f = r.substr(0, 1);
        string s = r.substr(1, 1);
        r = big_words[stoi(f)] + " " + words[stoi(s)];
    }

    if (stoi(h) == 0) {
        h = "";
    } else {
        h = words[stoi(h)] + " hundred ";
    }
    return h + r + " " + group;
}

string numstr(int n) {
    return parse_three(n, "");
}

int main() {
    int n = 7;
    cout << numstr(n) << endl;
    return 0;
}