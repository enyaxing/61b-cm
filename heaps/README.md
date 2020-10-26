# Meta
This question introduces priority queues by walking through a cool use case.

## Algorithm
Since Java priority queues have the smallest element on the top, to merge two sorted lists, all that is needed is to add each element from both lists to a priority queue and then iterate through each element, adding each element to an answer list in the order they show up in the priority queue. The runtime of this appears O(N) but remember that insertion into a priority queue takes on average O(logN) time, so the overall runtime ends up being O(NlogN).
