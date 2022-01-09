package crackingTheCodeInterview.linkedLists;

/**
 * Given two (singly) linked lists, determine if the two list intersect. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node
 * of the second list, then they are intersecting.
 */
public class Intersection {

    static Node getIntersection(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;

        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) return null;

        Node shorter = result1.size < result2.size ? list1 : list2;
        Node longer = result1.size > result2.size ? list1 : list2;


        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    static class Result {
        public Node tail;
        public int size;
        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    static Result getTailAndSize(Node list) {
        if(list == null) return null;

        int size = 1;
        Node current = list;
        while(current.next !=  null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    static Node getKthNode(Node head, int k) {
        Node current = head;
        while (k-- > 0 && current != null) {
            current = current.next;
        }
        return current;
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
        n6.next = n5;

        Node.print(getIntersection(n1, n6));
    }

}
