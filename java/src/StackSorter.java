public class StackSorter {
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> aux = new Stack<Integer>(); // an aux stack to store our final sorted stack
        int popped; // a placeholder
        while(!s.isEmpty()) {
            if (aux.isEmpty() || aux.peek() >= s.peek()) {      // if the aux is empty or has a bigger element on top
                aux.push(s.pop());                              // transfer s's top to aux's top
            } else {
                popped = s.pop();                               // otherwise take s's top to placeholder
                while(!aux.isEmpty() && aux.peek() < popped) {  // and put back aux's top to s's top until
                    s.push(aux.pop());
                }
                aux.push(popped);                               // popped can be put in aux
            }
        }
        return aux;                                             // finally return aux
    }

    public static void p_stack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test_arr = {5, 7, 2, 4, 0, -1};
        Stack<Integer> test = new Stack<Integer>();
        for (int i : test_arr) test.push(i);
        p_stack(sort(test));
    }
}
