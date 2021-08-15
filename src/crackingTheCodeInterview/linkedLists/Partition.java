package crackingTheCodeInterview.linkedLists;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes
 * greater than or equal to x. (IMPORTANT: The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 */
public class Partition {
    private static Node partition(Node list, int pivot) {
        Node newListHead = list;
        Node newListTail = list;
        while (list != null) {
            Node next = list.next;
            if (list.data > pivot) {
                newListTail.next = list;
                newListTail = list;
            } else {
                list.next = newListHead;
                newListHead = list;
            }
            list = next;
        }
        newListTail.next = null;
        return newListHead;
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
        System.out.println("Before: ");
        Node.print(n1);
        n1 = partition(n1, 4);
        System.out.println("\nAfter: ");
        Node.print(n1);

    }
}
