public class KDistinctSubStrings {
    public static void findSubStrings(char[] c, int k) {
        int max_length = 0;
        int max_start_index = 0;
        Queue q = new Queue();
        DistinctCharContainer dq = new DistinctCharContainer();
        for (int i = 0; i < c.length; i++) {
            q.queue(i);
            dq.add(c[i]);
            while (dq.uniques() > k) {
                dq.remove(c[q.deque()]);
            }
            if (dq.uniques() == k) {
                if (q.length() > max_length) {
                    max_length = q.length();
                    max_start_index = q.first();
                }
            }
        }
        // For printing out the answer
        for (int i = max_start_index; i < max_start_index + max_length; ++i) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String s = "abcba";
        char[] test = s.toCharArray();
        findSubStrings(test, 2);
    }
}