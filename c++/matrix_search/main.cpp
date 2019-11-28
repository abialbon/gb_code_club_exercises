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



bool search(int arr[m][n], int row, int column, int lo, int hi, int x)
{
    if (lo == hi && arr[lo / column][lo % column] != x) return false;
    int mid = lo + ((hi - lo) / 2);
    int r = mid / column, c = mid % column;
    if (arr[r][c] == x) return true;
    else if (arr[r][c] > x) return search(arr, row, column, lo, mid - 1, x);
    else return search(arr, row, column, mid + 1, hi, x);
}

int main() {
    int arr[m][n] = {
            {2, 4, 7, 9, 11, 13},
            {22, 24, 27, 29, 31, 33},
            {42, 44, 47, 49, 51, 53},
            {62, 64, 67, 69, 71, 73},
            {82, 84, 87, 89, 91, 93},
    };

    cout << search(arr, m, n,0, m*n, 9) << endl;
    return 0;
}