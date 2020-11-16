# Memory Efficient Trie

Imagine a trie storing the words "bee", "beekeeper", and "zoo". In a normal trie, we would just have nodes for each character, despite character repeats.

1. How could you modify the trie such that repeating characters don't make duplicate nodes in the trie?

2. Draw out what your new memory efficient Trie would look like if we inserted the words "bee", "beekeeper", "buzz", and "brrrrrr"

3. When do you expect this Memory Efficient form of trie to use less memory than regular ones? When would it use more?


Solutions:
1. Add a field in the Trie Nodes to keep track of how many repeats of the character there are
2. Should look something like this
![Should look like this](https://github.com/EthanYeh/61b-cm-fa20/blob/master/tries/trie.jpg?raw=true)
3. If there's lots of repeated characters, it should save some space. If there's very few, it would take more space because it keeps track of a repeat count.
