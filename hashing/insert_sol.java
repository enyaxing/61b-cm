// A node of the external chains
class HashNode<String, V> { 
    String key; 
    V value; 
    HashNode<String, V> next; 
  
    public HashNode(String key, V value) { 
        this.key = key; 
        this.value = value; 
    } 
} 

// class for the actual table
class HashTable<String, V> {
    private HashNode<String,V>[] hashtable;
    private int numBuckets;
    private int numElements;
    private int maxLoad = 0.75;

    public HashTable() { 
        numBuckets = 10; 
        numElements = 0;
        hashtable = new HashNode<String,V>[numBuckets]; 
  
        // Create empty chains 
        for (int i = 0; i < numBuckets; i++) 
            hashtable[i] = null; 
    } 

    // Given a key, returns the hashcode for that key
    private int hashfunc(String key) {
        return key.length();
    }

    public void insert(String key, V value) {
        int index = hashfunc(key);
        HashNode<String, V> head = hashtable[index];

        //check if key is already in table
        while (head != null) {
            if (head.key.equals(key)) { 
                head.value = value; 
                return; 
            } 
            head = head.next;
        }

        // resize
        if ((numElements+1)/numBuckets > maxLoad) {
            numBuckets = numBuckets * 2;
            HashNode<String,V>[] temp = hashtable;
            hashtable = new HashNode<String,V>[numBuckets];
            numElements = 0;

            for (int i = 0; i < numBuckets; i++) {
                hashtable.add(null);
            }

            for (HashNode<K, V> headNode : temp) { 
                while (headNode != null) { 
                    insert(headNode.key, headNode.value); 
                    headNode = headNode.next;
                } 
            }
        }

        numElements++;
        HashNode<String, V> newNode = new HashNode<String, V>(key, value);
        newNode.next = head;
        hashtable[index] = newNode;
    }
}
