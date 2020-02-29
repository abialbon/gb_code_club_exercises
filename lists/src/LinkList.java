class Node {
    private int data;
    private Node next;
    Node(int d) {
        data = d;
    }
    public int getData() { return data; }
    public Node getNext() { return next; }
    public void setNext(Node n) { next = n; }
}

class LinkList {
    Node head;
    Node tail;
    int size;
    LinkList() {}
    LinkList(int d) {
        head = new Node(d);
        tail = null;
        size = 1;
    }

    public void add(Node n) {
        Node curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(n);
        tail = n;
        size++;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
