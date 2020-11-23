# Binary Tree to Doubly Linked List In Place (Preorder Traversal)
## Problem
Cnvert a binary tree to a doubly linked list in place (no new data structures created). The order of the nodes for the tree is preorder.
Hint 1: What type of traversal is the example tree?
Hint 2: it may be easier to think of how to convert a binary tree to a one way (singly) linked list.
Hint 3: What should you keep track of? 

Clarification: in place means that no new data structures should be created. Utilizing the node class, pretend node.left and node.right would be the same as a doubly linked list's node.next and node.prev and change the pointers directly. 
## Solution
There are two approaches to this question. 
The one listed in the current solution involves doing a preorder traversal of the binary tree and then keeping of the visit order by storing all of the nodes. Then, traverse all of the nodes in that order and change their left and right pointers respectively. 
The second approach involves manipulating node pointers during traversal and is more of a recursive approach (this may be a student's intuitive approach, but can be a bit difficult to implement).


