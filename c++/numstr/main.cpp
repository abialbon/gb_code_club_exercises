#include <iostream>
#include <string>

using std::string;
using std::to_string;
using std::cout;
using std::endl;

string words[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                   "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

string big_words[] = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
string group_words[] = { "", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion"};

string three_digit_parser(string num, const string &group)
{
    if (stoi(num) == 0) return "";
    string h;
    if (num.length() == 3) {
        h = num.substr(0, 1);
        num = num.substr(1, 2);
    }
    if (stoi(num) <= 20) {
        num = words[stoi(num)];
    } else {
        string f = num.substr(0, 1);
        string s = num.substr(1, 1);
        num = big_words[stoi(f)] + " " + words[stoi(s)];
    }

    if (!h.empty() && stoi(h) > 0) {
        h = words[stoi(h)] + " hundred";
    } else {
        h = "";
    }
    if (group.empty())
        return h + " and " + num;
    return h + " " + num + " " + group + " ";
}

string sign_specifier(long n)
{
    if (n < 0) return "minus ";
    return "";
}

string num_parser(long n)
{
    string num = n < 0 ? to_string(-n) : to_string(n);
    string output;
    unsigned short first_group = num.length() % 3;
    bool leading = (bool) first_group;
    unsigned short no_groups = num.length() / 3 + (bool) first_group;

    if (first_group)
        output += three_digit_parser(num.substr(0, first_group), group_words[no_groups - 1]);


    for (int i = 0; i < (no_groups - leading); ++i) {
        output += three_digit_parser(num.substr(first_group + (3 * i), 3), group_words[no_groups - leading - i - 1]);
    }
    return output;
}

string num_str(long n) {
    return sign_specifier(n) + num_parser(n);
}

int main() {
    long n = 7'546'742'741'956'464'598;
    cout << num_str(n) << endl;
    return 0;
}