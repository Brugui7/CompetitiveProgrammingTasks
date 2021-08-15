package crackingTheCodeInterview.linkedLists;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {

    public static void removeDups(Node n) {
        HashSet<Integer> values = new HashSet<>();
        Node previous = null;

        while (n != null) {
            if (values.contains(n.data)) {
                previous.next = n.next;
            } else {
                values.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public static void removeDupsWithoutBuffer(Node n) {
        Node current = n;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(3);
        Node n6 = new Node(3);
        Node n7 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println("*** With buffer ***");
        System.out.println("Before: ");
        Node.print(n1);
        removeDups(n1);
        System.out.println("\nAfter: ");
        Node.print(n1);

        System.out.println("\n*** Without buffer ***");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println("Before: ");
        Node.print(n1);
        removeDupsWithoutBuffer(n1);
        System.out.println("\nAfter: ");
        Node.print(n1);
    }

}
