public class OddEvenSeparator {
    public static int[] separate(int[] arr) {
        int noEvens = 0;
        int noOdds = 0;
        int length = arr.length;
        for (int i = noEvens; i < length - noOdds - 1; ) {
            if (arr[i] % 2 == 0) i = ++noEvens;
            else {
                int temp = arr[length - noOdds - 1];
                arr[length - noOdds - 1] = arr[i];
                arr[i] = temp;
                noOdds++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int N = 40960000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        StopClock timer = new StopClock();
        int[] b = separate(a);
        System.out.println("Time in millis: " + timer.getElapsedTime());
    }
}
