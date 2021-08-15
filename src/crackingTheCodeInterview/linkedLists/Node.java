package crackingTheCodeInterview.linkedLists;

public class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public static void print(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
