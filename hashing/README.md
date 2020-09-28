# Hashtable Insert Problem Meta
*NOTE: This problem is likely gonna be a mock midterm problem instead of a section problem, but in case this becomes a section problem here's a Meta.*


The idea of this problem is to get students familiar with writing code that inserts a new element into a hash table. They would walk through the process of getting a hashcode,
resizing if necessary, and inserting. 

## Introducing the problem
Make sure they're conceptually clear on how inserting into a hash table works. Go over how to implement a hashcode, what it's used for, how resizing works, how external chaining
works, etc. Students would have a much better time writing code when they have a good conceptual grasp on the what's supposed to happen.

## Solution
### Hashfunc
```
private int hashfunc(K key) {
  returnkey.length();
}
```

### Resize
To resize, first double `numBuckets`. We have to keep track of every element that's already in the hashtable, and we can use a temp variable for that. We then initialize `null` chains for each bucket, and re-insert every elemnt that was in the original hashtable.
```
// resize
if ((numElements+1)/numBuckets > maxLoad) {
    numBuckets *= 2;
    HashNode<K,V>[] temp = hashtable;
    hashtable = new HashNode<K,V>[numBuckets];
    numElements = 0;

    for (int i = 0; i < numBuckets; i++) 
        hashtable.add(null);

    for (HashNode<K, V> headNode : temp) { 
        while (headNode != null) { 
            insert(headNode.key, headNode.value); 
            headNode = headNode.next; 
        } 
    }
}
```
