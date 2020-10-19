# Meta

In addition to highlighting the must-have methods when implementing the `Iterable<E>` and `Iterator<E>` interfaces, this problem highlights how the _iterator_ 
object is customized for the specific _iterable_ object. `FruitBasketIterator` is customized to iterate over the `FruitBasket` iterable object by only returning
the non-spoiled fruit. 

## Introducing the Problem
Before diving into the problem, it's helpful to remind students of the `Iterable<E>` and `Iterator<E>` interfaces, and noting that the keyword `implements` is used
for interface inheritance, while the keyword `extends` is used for class inheritance. 

```
interface Iterator<T> {
	boolean hasNext(); // return true if there is a next element
	T next(); // return the next element
}
```

```
interface Iterable<T> {
  Iterator<T>	iterator(); // return the iterable object
}
```
It could be helpful for students to remember the sentence: "An _iterable_ must have a function that returns an _iterator_, which allows us to iterate through 
the iterable object." It is also helpful to note the common pattern of the _iterator_ class being declared as a private nested class inside the _iterable_. 
This is because only the _iterable_ is going to use this specific _iterator_. In other words, only `FruitBasket` is going to use `FruitBasketIterator` to iterate
through its contents.

## Tackling the Problem
WARNING: There are many correct solutions to the problem. Some alternative implementations are discussed, but they are by no means comprehensive. 

### Constructor
```
int index;
FruitBasketIterator() {
    this.index = 0;
}
```
Setting `index` to 0 is a common pattern for _iterators_ to keep track of where in the array to return next. However, in this case, the 0th fruit may not be 
returned, because it could be spoiled. This means more work will be done in `hasNext` and `next` to make sure that the fruit at the specified index is not spoiled. 

An alternative could be to immediately set `index` to the first unspoiled fruit. This would likely involve calling `hasNext()` after setting `index` to 0 or 
copying code from `hasNext` into the constructor to set `index` directly. 

### hasNext
```
public boolean hasNext() {
  if (index >= fruits.length) {
    return false;
  }
  Fruit currFruit = fruits[index];
  while(currFruit.isSpoiled() && index < fruits.length) {
    index++;
    currFruit = fruits[index];
  }
  return index < fruits.length;
}
```
The first `if` statement checks that index is still in range so that `Fruit currFruit = fruits[index];` doesn't error. Then the `while` loop increments `index` 
until it is the index of the next unspoiled fruit. Note that in addition to checking whether `currFruit` is spoiled, we must also check that index is still in range.
Finally, because it is possible for the while loop to terminate due to `index` no longer being in range (rather than successfully finding an unspoiled fruit),
we return true if `index` is still valid. 

### next
```
public Fruit next() {
  if (hasNext()) {
    int currIndex = index;
    index++;
    return fruits[currIndex];
  }
  throw new NoSuchElementException("No unspoiled fruit left");
}
```
Although it is good convention for the user to call `hasNext` before `next`, we can't guarantee that it will happen, so we must make sure our code doesn't crash 
regardless. There is an extra check for `if (hasNext())`, which would properly update `index` to the next unspoiled fruit. If `hasNext` returns `false`, a 
`NoSuchElementException` is thrown to indicate that there are no more unspoiled fruit to return. 

Here, it's helpful to note the common three line pattern of saving `index`, incrementing it, and then returning the desired element. Even though `index + 1` may 
not be a valid fruit to return, it's still important that we increment by 1, because `hasNext` only increments `index` in search for the existance of the next 
unspoiled fruit if the fruit at the current `index` is spoiled. 

### Closing Thoughts
This problem is likely to take a lot of time, especially since it has very little starter code. Be prepared to talk through various implementation ideas students 
have and discuss the edge cases covered in `next` and `hasNext`. 
