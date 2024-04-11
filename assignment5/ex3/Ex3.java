class Furniture {
      String name;
      String style;
      String material;
      float price;

      public Furniture(String name, String style, String material, float price) {
            this.name = name;
            this.style = style;
            this.material = material;
            this.price = price;
      }
}

interface FurnitureFactory {
      Chair createChair();
      Table createTable();
      Sofa createSofa();
}

class ModernWoodFactory implements FurnitureFactory {
      @Override
      public Chair createChair() {
            return new Chair("Modern Wood Chair", 150.0f);
      }

      @Override
      public Table createTable() {
            return new Table("Modern Wood Table", 300.0f);
      }

      @Override
      public Sofa createSofa() {
            return new Sofa("Modern Wood Sofa", 500.0f);
      }
}

class TraditionalMetalFactory implements FurnitureFactory {
      @Override
      public Chair createChair() {
            return new Chair("Traditional Metal Chair", 120.0f);
      }

      @Override
      public Table createTable() {
            return new Table("Traditional Metal Table", 250.0f);
      }

      @Override
      public Sofa createSofa() {
            return new Sofa("Traditional Metal Sofa", 450.0f);
      }
}

class Chair {
      String name;
      float price;

      public Chair(String name, float price) {
            this.name = name;
            this.price = price;
      }
}

class Table {
      String name;
      float price;

      public Table(String name, float price) {
            this.name = name;
            this.price = price;
      }
}

class Sofa {
      String name;
      float price;

      public Sofa(String name, float price) {
            this.name = name;
            this.price = price;
      }
}

class FurnitureCreator {
      private FurnitureFactory factory;

      public void setFactory(FurnitureFactory factory) {
            this.factory = factory;
      }

      public Chair createChair() {
            return factory.createChair();
      }

      public Table createTable() {
            return factory.createTable();
      }

      public Sofa createSofa() {
            return factory.createSofa();
      }
}

public class Ex3 {
      public static void main(String[] args) {
            FurnitureCreator creator = new FurnitureCreator();
            creator.setFactory(new ModernWoodFactory());

            Chair chair = creator.createChair();
            Table table = creator.createTable();
            Sofa sofa = creator.createSofa();

            System.out.println("Chair: " + chair.name + " - Price: $" + chair.price);
            System.out.println("Table: " + table.name + " - Price: $" + table.price);
            System.out.println("Sofa: " + sofa.name + " - Price: $" + sofa.price);
      }
}
