# Linked List Folding Meta

This problem should make students more comfortable at interacting with Linked Lists by introducing Floyd's tortoise and hare algorithm and having them apply it to another problem.

## Introducing the problem
Make sure students are clear on the fact that returning an IntList variable only returns the reference in Java. They should be familiar with the Deque interface as well.

## Solution
The solution for finding the center of a linked list is Floyd's tortoise and hare algorithm.

The solution for folding a linked list utilizes the solution from the first part to find the "hinge", which is the return value. It then uses a Deque to pop out the left and right ends of the linked list simultaneously while mutating the right node.
