public class Stack<T> {
    private Node head = null;
    private Node tail = null;
    private int length = 0;

    private class Node<T> {
        T item;
        Node next;
    }

    public void push(T item) {
        Node newNode = new Node();
        newNode.item = item;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public T pop() {
        T item = (T) head.item;
        Node temp = head.next;
        head = temp;
        --length;
        return item;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T peek() {
        return (T)  head.item;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
