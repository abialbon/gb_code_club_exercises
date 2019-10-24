public class RectangleBinaryArray {
    public static int findLargestRectangle(int[][] arr) {
        int largestArea = 0;
        int[] test = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) test[j] += arr[i][j];
                else test[j] = 0;
            }
            int area = RectangleWithHistograms.findMaxAreaRect(test);
            if (area > largestArea) largestArea = area;
        }
        return largestArea;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 1}
        };
        int largestArea = findLargestRectangle(a);
        System.out.println("The largest rectangular area is: " + largestArea);
    }
}
