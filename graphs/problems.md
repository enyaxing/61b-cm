# Conceptual True / False problems

## Question 1
#### If the weight of each edge is decreased by 1, then the resulting shortest path in any graph from u to v is unchanged. 

False. 
The effect of adding/subtracting a constant to/from each edge depends on the number of edges in a path. Subtracting 1 from every edge makes paths 
with more edges shorter. Subtracting from an edge can also make it negative. 

## Question 2
#### If a graph G has a unique MST, it must have unique edge weights. 

False. 
The converse, however, is True: If a graph has unique edge weights, then the graph has a unique MST.

## Question 3
#### Consider a graph G, where every edge is nonnegative, except the edges adjacent to vertex s. Dijkstra’s usually fails on graphs with negative edge weights, however if we run Dijkstra’s starting from s, we will get the correct shortest paths tree. 

True. 
Dijkstra’s fails if incorporating a negative edge not yet seen decreases the shortest path. In the case, all negative edges have been seen and added to the fringe. 
That means adding more edges to any forming path can only increase the total distance (since all other edge weights are nonnegative.
