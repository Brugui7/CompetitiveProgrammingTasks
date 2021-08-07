/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
public class ReturnKthToLast {
    public static Node returnKthToLast(Node head, int k) {
        int size = 0;
        Node n = head;
        while (n != null) {
            size++;
            n = n.next;
        }

        if (k > size) return null;

        n = head;
        for (int i = 0; i < size - k; i++) {
            n = n.next;
        }
        return n;
    }

    public static Node returnKthToLastIterative(Node head, int k) {
        Node pointer1 = head;
        Node pointer2 = head;

        for (int i = 0; i < k; i++) {
            if (pointer1 == null) return null;
            pointer1 = pointer1.next;
        }

        while (pointer1 != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(3);
        Node n6 = new Node(5);
        Node n7 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println("*** With known list length ***");
        System.out.println("Before: ");
        Node.print(n1);
        System.out.println("\nAfter: ");
        Node.print(returnKthToLast(n1, 4));

        System.out.println("\n*** With an iterative solution ***");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println("Before: ");
        Node.print(n1);
        System.out.println("\nAfter: ");
        Node.print(returnKthToLastIterative(n1, 4));
    }
}
