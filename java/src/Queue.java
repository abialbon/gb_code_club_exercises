public class Queue {
    private int length = 0;
    private Node head;
    private Node tail;

    public void queue(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public int deque() {
        Node temp = head;
        head = head.next;
        length--;
        if (length == 0) tail = null;
        return temp.item;
    }

    public int length() {
        return length;
    }

    public int first() {
        return head.item;
    }

    private class Node {
        int item;
        Node next;

        Node(int x) {
            item = x;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.queue(9);
        q.queue(10);
        q.queue(20);
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.deque());
    }
}
