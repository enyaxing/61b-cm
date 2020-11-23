/**
 * CONVERTING BINARY TREE TO DOUBLY LINKED LIST IN PLACE
 * Input :
          1
        /   \
       2     5
      /  \     \
     3    4     6
 * Output: 
 * -> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-
 *
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.utils.*;

public Node treeToDoubleLL(Node s) {
    if (s == null) {
        return;
    }

    // Obtain traversal in order
    ArrayList<Node> traversal = new ArrayList<Node>();
    inorder(s, traversal);

    // Set everyone except for first and last node
    for (int i = 1; i < traversal.length - 1; i++) {
        Node cur = traversal.get(i);
        Node prev = traversal.get(i - 1);
        Node next = traversal.get(i + 1);
        cur.left = prev;
        cur.right = next;
    }

    Node first = traversal.get(0);
    // Set the first and last node
    if (traversal.length > 1) {
        Node last = traversal.get(traversal.length - 1);

        first.left = traversal.get(1);
        first.right = last;
        last.left = traversal.get(traversal.length - 2);
        last.right = first;
    } else {
        first.left = first;
        first.right = first;
    }
}

void inorder(Node s, ArrayList<Node> traversal) {
    if (s == null) {
        return;
    }
    inorder(s.left, traversal);
    traversal.add(s);
    inorder(s.right, traversal);
}
