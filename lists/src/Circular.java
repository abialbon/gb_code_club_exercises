import java.util.HashMap;

public class Circular {
    public static int getBegin(LinkList l) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        Node curr = l.head;
        int prev = 0;
        while (curr != null) {
            if (hash.containsValue(curr.getData())) return hash.get(curr.getData());
            else {
                hash.put(curr.getData(), prev);
                prev = curr.getData();
                curr = curr.getNext();
            }
        }
        return prev;
    }

    public static int getLink(LinkList)


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkList l = new LinkList(1);
        Node n1 = new Node(2);
        l.add(n1);
        Node n2 = new Node(3);
        l.add(n2);
        Node n3 = new Node(4);
        l.add(n3);
        Node n4 = new Node(5);
        l.add(n4);
        Node n5 = new Node(6);
        l.add(n5);
        Node n6 = new Node(7);
        l.add(n6);
        Node n7 = new Node(8);
        l.add(n7);
        Node n8 = new Node(9);
        l.add(n8);
        l.tail.setNext(n4);

        System.out.println(getBegin(l));
    }
}
