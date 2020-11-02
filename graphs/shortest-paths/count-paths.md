# Count Shortest Paths

### Problem

Given an undirected unweighted graph `G` with a start vertex `s` and target vertex `t`, devise an algorithm that counts the number of shortest paths from `s` to `t`.
Write the algorithm that outputs the number of distinct shortest pahts given `G` as an adjacency list. 
You may assume vertices are numbered `0` to `n - 1`, where `n` is the length of the list. 

_Hint: Consider what algorithm you can modify given that the graph is unweighted._

```
int numShortestPaths(int[][] G, int s, int t) {

}
```

### Solution

Since the edges are unweighted, we can modify BFS to count the number of paths. BFS will find the shortest paths, because when the edges of a graph are unweighted,
the shortest path is that with the least edges. 

Modification to BFS: Keep track of a count of the number of shortest paths to each vertex when that vertex is visited. 
The number of shortest paths to vertex `v` is the sum of the shortest paths to all visited neighbors of `v`. 

```
int numShortestPaths(int[][] G, int s, int t) {
  // map vertex to number of shortest paths to that vertex
  HashMap<Integer, Integer> visited = new HashMap<>();
  
  Queue<Integer> queue = new ArrayDeque<>();
  queue.addLast(s);
  
  // run modified BFS
  while (!queue.isEmpty()) {
    int curr = queue.removeFirst();
    int numPaths = 0;
    
    // explore adjacent vertices of current vertex
    for (int u : G[s]) {
      if (visited.contains(u)) {
        // add number of paths from neighbors that have been visited
        numPaths += visited.get(u);
      } else {
        queue.addLast(u);
      }
    }
    
    // case where curr is the first vertex visited (aka curr == s)
    if (numPaths == 0) {
      numPaths = 1;
    }
    
    // note that curr has been visited and 
    // keep track of the number of shortest paths to curr
    visited.put(curr, numPaths);
    
    if (curr == t) {
      return numPaths;
    }
  }
  
  // queue is empty but BFS hasn't found t
  return 0;
}
```
