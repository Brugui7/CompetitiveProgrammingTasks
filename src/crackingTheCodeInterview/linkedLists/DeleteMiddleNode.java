/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked lis, given only access to that node..
 */
public class DeleteMiddleNode {

    private static boolean deleteNode(Node node) {
        if (node == null || node.next == null) return false;

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;

        return true;
    }

    public static void main(String[] args) {
        
    }
}
