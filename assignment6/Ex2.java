class Pizza {
      protected double price;

      public Pizza(double price) {
            this.price = price;
      }

      public double getPrice() {
            return price;
      }
}

abstract class PizzaDecorator extends Pizza {
      protected Pizza pizza;

      public PizzaDecorator(Pizza pizza) {
            super(pizza.getPrice());
            this.pizza = pizza;
      }

      public abstract double getPrice();
}

class PepperoniTopping extends PizzaDecorator {
      private static final double PEPPERONI_PRICE = 1.5;

      public PepperoniTopping(Pizza pizza) {
            super(pizza);
      }

      @Override
      public double getPrice() {
            return pizza.getPrice() + PEPPERONI_PRICE;
      }
}

class MushroomTopping extends PizzaDecorator {
      private static final double MUSHROOM_PRICE = 2.0;

      public MushroomTopping(Pizza pizza) {
            super(pizza);
      }

      @Override
      public double getPrice() {
            return pizza.getPrice() + MUSHROOM_PRICE;
      }
}

public class Ex2 {
      public static void main(String[] args) {
            Pizza pizza = new Pizza(9.0);
            pizza = new PepperoniTopping(pizza);
            pizza = new MushroomTopping(pizza);

            System.out.println("Total Price: " + pizza.getPrice() + "$");
      }
}
