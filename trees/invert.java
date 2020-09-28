private void invert(Node node) {
    if (node == null) {
        return;
    }
    invert(node.left);
    invert(node.right);
    Node temp = node.left;
    node.left = node.right;
    node.right = temp;
    }
}