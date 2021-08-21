package crackingTheCodeInterview.linkedLists;

import java.util.HashSet;

/**
 * You hace two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's dignit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * (You are not allowed to "cheat" and just convert the linked list to an integer)
 */
public class SumLists {

    public static Node sumLists(Node a, Node b) {
        return addList(a, b, 0);
    }

    private static Node addList(Node a, Node b, int carry) {
        if(a == null && b == null && carry == 0) {
            return null;
        }

        int value = carry;

        if (a != null) {
            value += a.data;
        }

        if (b != null) {
            value += b.data;
        }

        Node result = new Node(value % 10);
        if (a != null || b != null) {
            result.next = addList(
                    a != null ? a.next : null,
                    b != null ? b.next : null,
                    value > 10 ? 1 : 0
            );
        }

        return result;
    }



    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(1);
        Node n3 = new Node(6);
        n1.next = n2;
        n2.next = n3;

        Node m1 = new Node(5);
        Node m2 = new Node(9);
        Node m3 = new Node(2);
        m1.next = m2;
        m2.next = m3;

        System.out.println("*** With buffer ***");
        System.out.println("Before: ");
        Node.print(n1);
        System.out.println("\n+");
        Node.print(m1);
        System.out.println("\nResult: ");
        Node.print(sumLists(n1, m1));

        System.out.println("\n*** In forward order ***");

    }

}
