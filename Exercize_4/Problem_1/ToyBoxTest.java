import java.util.ArrayList;

/**
 * ToyBox Example.
 */


class ToyBox<T> {

    private ArrayList<T> v  = new ArrayList<>(); // Complete here to assign ArrayList object         

    public void add(T item) {
        this.v.add(item);
    }

    public T get(int index) {
        return this.v.get(index);
    }

    public int getSize() {
        return this.v.size();
    }
}

class Toy {
        private String name;
        private int price;
    
        public Toy(String name, int price) {
            this.name = name;
            this.price = price;
        }
        @Override
        public String toString() {
            return ""+this.name+"/"+this.price;
        }
  // Complete Toy Class
}

class Car extends Toy {
    public Car(String name, int price) {
        super(name, price);
    }
}

class Bear extends Toy {
    public Bear(String name, int price) {
        super(name, price);
    }
}

public class ToyBoxTest {
    public static void showToysinBox(ToyBox<? extends Toy> toyBox) {
        for (int i = 0; i < toyBox.getSize(); i++) {
            System.out.println(toyBox.get(i));
        }
    }

    public static void main(String[] args) {

     // Create a "carBox" with proper sentence
       ToyBox<Car> carBox = new ToyBox<>();

       Car t1 = new Car("Yaris", 1500);
       Car t2 = new Car("Corolla", 2500);
      carBox.add(t1);
      carBox.add(t2);
      showToysinBox(carBox);

     // Create a "bearBox" with proper sentence
        ToyBox<Bear> bearBox = new ToyBox<>();
       Bear b1 = new Bear("Bear1", 1000);
       Bear b2 = new Bear("Bear2", 2000);
      bearBox.add(b1);
      bearBox.add(b2);
      showToysinBox(bearBox);


      /* It is OK till now */

      // Next, create Box<Toy>

     // Create a "toyBox" with proper sentence
       ToyBox<Toy> toyBox = new ToyBox<>();

       Car t3 = new Car("Tacoma", 3300);
       Bear b3 = new Bear("Bear3", 1200);

      toyBox.add(t3);
      toyBox.add(b3);

      showToysinBox(toyBox);
      /* It is still OK till now */

      // How about the next? Is it subtype?
      ToyBox<? extends Toy> sometoyBox = carBox;
      System.out.println("After assigning the carBox into the \"sometoyBox\"...");
      showToysinBox(sometoyBox);
    }
}



// Car class and Bear class to extend the Toy class


