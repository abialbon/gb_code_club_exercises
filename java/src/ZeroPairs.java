/*
Written by Dr Abi Paul
Question: From a given array of numbers, find pairs that sum to zero
This implementation has a time complexity of O(n)
However, the space complexity depends on the input. (range of values)
 */

public class ZeroPairs {
    public static void findPairs(int[] arr) {
        // Find the min and max values in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int numNeeded = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
            numNeeded = Math.max(Math.abs(min), Math.abs(max));
        }

        // Arrays for storing element-indexed array
        int[] positives = new int[numNeeded+1];
        int[] negatives = new int[numNeeded+1];

        for (int i = 0; i < arr.length; ++i) {
            int n = arr[i]; // The number we are searching a pair for
            if (n > 0) { // If positive number

                // Check if there is a counterpart in negatives,
                // if not, register itself in the positives
                if ((negatives[n]) == 0) positives[n]++;
                else {
                    // Else reduce the occurrence in the negatives and print the pair
                    System.out.println(n + " " + -n);
                    negatives[n]--;
                }
            } else if (n < 0) { // If negative number
                if (positives[-n] == 0) negatives[-n]++;
                else {
                    System.out.println(n + " " + -n);
                    positives[-n]--;
                }
            } else { // Else it's got to be zero
                if (positives[0] == 0) positives[0]++;
                else {
                    System.out.println("0 0");
                    positives[0]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, -1, 0, 1, 2, -2, -4, 0};
        findPairs(a);
    }
}
