package FruitBasket;

import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;

class Fruit {
    boolean isSpoiled; 

    Fruit(boolean isSpoiled) {
        this.isSpoiled = isSpoiled;
    }

    public boolean isSpoiled() {
        return isSpoiled;
    }
}

class FruitBasket implements Iterable<Fruit> {
    Fruit[] fruits;

    public FruitBasket(Fruit[] fruits) {
        this.fruits = fruits;
    }
    
    private class FruitBasketIterator implements Iterator<Fruit> {
        int index;
    
    	FruitBasketIterator() {
    		this.index = 0;
        }
    
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

        public Fruit next() {
            if (hasNext()) {
                int currIndex = index;
                index++;
                return fruits[currIndex];
            }
        	throw new NoSuchElementException("No unspoiled fruit left");
        }
    }

    public Iterator<Fruit> iterator() {
    	return new FruitBasketIterator();
    }
    
    // other FruitBasket methods
}
