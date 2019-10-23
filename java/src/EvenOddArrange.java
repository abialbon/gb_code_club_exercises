/*
Written by: Dr Abialbon Paul
Probably not the best version, but this is the first version
 */

import java.util.Arrays;
import java.util.Collections; // to reverse sort the odds array

public class EvenOddArrange {
    public static int[] arrange(int[] arr) {
        int noOdds = 0;
        for (int i = 0; i < arr.length - noOdds; ) {
            if (arr[i] % 2 == 0) ++i;
            else {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - noOdds];
                arr[arr.length - 1 - noOdds] = temp;
                ++noOdds;
            }
        }
        // Since reverse order sort doesn't work on primitives
        Integer[] odds = new Integer[noOdds];
        // Loops to copy from int[] to Integer[]
        for (int i = 0; i < noOdds; i++) {
            odds[i] = arr[arr.length - noOdds + i];
        }
        // The actual sorting: even (ascending) and odds (descending)
        Arrays.sort(arr, 0, arr.length - noOdds);
        Arrays.sort(odds, Collections.reverseOrder());
        // Loops to copy from Integer[] to int[]
        for (int i = 0; i < noOdds; i++) {
             arr[arr.length - noOdds + i] = odds[i];
         }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7, 16, 121, 9, 3, 10};
        int[] b = arrange(a);

        for (int i: b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
