public class Main {
    public static LinkList partiton(LinkList l, int k) {
        int partitionIndex = 0;
        int len = l.size;
        LinkList first = new LinkList();
        LinkList second = new LinkList();
        Node curr = l.head;
        while (curr != null) {
            if (curr.getData() == k) break;
            else {
                partitionIndex++;
                curr = curr.getNext();
            }
        }
        Node l1 = l.head;
        for (int i = 0; i < partitionIndex; i++) {
            if (l1.getData() < k) {
                if (first.head == null) {
                    first.head = new Node(l1.getData());
                    first.size++;
                } else {
                    first.add(new Node(l1.getData()));
                }
            } else {
                if (second.head == null) {
                    second.head = new Node(l1.getData());
                    second.size++;
                } else {
                    second.add(new Node(l1.getData()));
                }
            }
            l1 = l1.getNext();
        }

        Node l2 = curr;
        for(int i = partitionIndex; i < len; i++) {
            if (l2.getData() < k) {
                if (first.head == null) {
                    first.head = new Node(l2.getData());
                    first.size++;
                } else {
                    first.add(new Node(l2.getData()));
                }
            } else {
                if (second.head == null) {
                    second.head = new Node(l2.getData());
                    second.size++;
                } else {
                    second.add(new Node(l2.getData()));
                }
            }
            l2 = l2.getNext();
        }

        first.tail.setNext(second.head);
        return first;
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 5, 10, 2, 1};
        LinkList l = new LinkList(3);
        for (int i = 1; i < arr.length; ++i) {
            l.add(new Node(arr[i]));
        }
        l.print();


        LinkList l2 = partiton(l, 5);
        l2.print();
    }
}
