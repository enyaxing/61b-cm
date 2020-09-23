package FruitBasket;

import java.util.Iterator;

public class FruitBasket_Tests {

    public static void testBasic() {
        Fruit fruits[] = new Fruit[]{
            new Fruit(true),
            new Fruit(false),
            new Fruit(false),
            new Fruit(true)
        };
        FruitBasket basket = new FruitBasket(fruits);

        Iterator<Fruit> iter = basket.iterator();
        assert iter.hasNext() == true : "at the beginning, there is a next not spoiled fruit";
        iter.next();
        assert iter.hasNext() == true : "after returning one non spoiled fruit, there is a next not spoiled fruit";
        iter.next();
        assert iter.hasNext() == false : "there is one fruit left, but it is spoiled";
    }
    
    public static void testAllSpoiled() {
        Fruit fruits[] = new Fruit[]{
            new Fruit(true),
            new Fruit(true),
            new Fruit(true),
            new Fruit(true),
            new Fruit(true),
            new Fruit(true)
        };
        FruitBasket basket = new FruitBasket(fruits);

        assert basket.iterator().hasNext() == false : "all fruit should be spoiled";
    }

    public static void testAllUnspoiled() {
        Fruit fruits[] = new Fruit[]{
            new Fruit(false),
            new Fruit(false),
            new Fruit(false),
        };
        FruitBasket basket = new FruitBasket(fruits);

        Iterator<Fruit> iter = basket.iterator();
        int totalUnpoiledFruit = 0;
        while(iter.hasNext()) {
            iter.next();
            totalUnpoiledFruit++;
        }

        assert totalUnpoiledFruit == 3 : "all fruit should be unspoiled";
    }

    public static void testEmpty() {
        Fruit fruits[] = new Fruit[0];
        FruitBasket basket = new FruitBasket(fruits);

        assert basket.iterator().hasNext() == false : "empty iterator should return no fruit";
    }

    public static void main(String[] args) {
        testBasic();
        testAllSpoiled();
        testAllUnspoiled();
        testEmpty();

        System.out.println("All tests passed.");
    }
}
