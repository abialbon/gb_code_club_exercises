/*
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  1. Integers in each row are sorted from left to right.
 *  2. The first integer of each row is greater than the last integer of the previous row.
 *
 *  Written by dr Abi Paul
 */

#include <iostream>
#define m 5
#define n 6

using namespace std;

enum class STATUS {
    STARTING,
    GOING_UP,
    GOING_DOWN,
    GOING_LEFT,
    GOING_RIGHT,
    COMPLETED
};

bool search(int arr[m][n], int row, int column, int x)
{
    STATUS status = STATUS::STARTING;
    int r = row / 2;
    while (status != STATUS::COMPLETED) {
        if (arr[r][0] == x) return true;
        else if (arr[r][0] > x) {
            if (r == 0) break;
            if (status == STATUS::STARTING) status = STATUS::GOING_DOWN;
            if (status == STATUS::GOING_UP) break;
            r = r / 2;
        } else {
            if (r == row - 1) break;
            if (status == STATUS::STARTING) status = STATUS::GOING_UP;
            if (status == STATUS::GOING_DOWN) break;
            r += r / 2;
        }
    }

    status = STATUS::STARTING;
    int c = column / 2;
    while (status != STATUS::COMPLETED) {
        if (arr[r][c] == x) return true;
        else if (arr[r][c] > x) {
            if (c == 0) break;
            if (status == STATUS::STARTING) status = STATUS::GOING_LEFT;
            if (status == STATUS::GOING_RIGHT) break;
            c = c / 2;
        } else {
            if (c == column - 1) break;
            if (status == STATUS::STARTING) status = STATUS::GOING_RIGHT;
            if (status == STATUS::GOING_LEFT) break;
            c += c / 2;
        }
    }
    return false;
}

int main() {
    int arr[m][n] = {
            {2, 4, 7, 9, 11, 13},
            {22, 24, 27, 29, 31, 33},
            {42, 44, 47, 49, 51, 53},
            {62, 64, 67, 69, 71, 73},
            {82, 84, 87, 89, 91, 93},
    };

    cout << search(arr, 5, 6, 2) << endl;
    return 0;
}