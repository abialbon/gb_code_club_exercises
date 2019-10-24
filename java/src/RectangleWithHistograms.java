/*
Code by Dr Abi Paul
Referred YouTube for the solution but they were quite confusing
So got the idea and tried the solution on my own
 */

public class RectangleWithHistograms {
    public static int findMaxAreaRect(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int largestArea = 0;
        for (int i = 0; i < arr.length; i++) {
            // If the stack is empty or if the stack top has an item which is smaller
            // simply push to the stack
            if (stack.isEmpty() || arr[stack.peek()] < arr[i]) stack.push(i);
            else {
                // if the stack top is larger, then calculate two areas
                while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    int popped = stack.pop();
                    // The area of the stack top till the current index
                    int area1 = (i - popped) * arr[popped];
                    // the area of the current index till the stack top
                    int area2 = (i - popped + 1) * arr[i];
                    // Find the largest area and update largestArea
                    int area = area1 > area2 ? area1 : area2;
                    if (area > largestArea) largestArea = area;
                }
                // Once all larger elements are popped, push the current element
                stack.push(i);
            }
        }
        // Once the loop is over, pop back all elements and calculate only one area
        // as the area of the current index is 0 (Current index out of array)
        while (!stack.isEmpty()) {
            int area;
            int popped = stack.pop();
            if (stack.isEmpty()) {
                area = (arr.length) * arr[popped];
            } else {
                area = (arr.length - stack.peek() - 1) * arr[popped];
            }
            if (largestArea < area) largestArea = area;
        }
        return largestArea;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 3, 2, 2};
        int area = findMaxAreaRect(a);
        System.out.println(area);
    }
}
