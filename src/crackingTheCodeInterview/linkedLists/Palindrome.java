package crackingTheCodeInterview.linkedLists;

/**
 * Implement a function to check if a linked lis is a palindrome
 */
public class Palindrome {
    public static boolean isPalindrome(Node head) {
        return isEqual(head, reverseAndClone(head));
    }

    private static Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node prev = new Node(node.data);
            prev.next = head;
            head = prev;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(Node a, Node b) {
        while(a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }
            a = a.next;
            b = b.next;
        }
        return  a == null && b == null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(3);
        Node n6 = new Node(2);
        Node n7 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        Node.print(n1);
        System.out.println(isPalindrome(n1) ? "IT'S A PALINDROME" : "IT'S NOT A PALINDROME");
    }
}
