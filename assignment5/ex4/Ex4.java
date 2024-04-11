class Character {
      String name;
      String characterClass;
      Weapon weapon;
      int health;
      int mana;

      public Character(String name, String characterClass, Weapon weapon, int health, int mana) {
            this.name = name;
            this.characterClass = characterClass;
            this.weapon = weapon;
            this.health = health;
            this.mana = mana;
      }
}

class Weapon {
      String type;
      int damage;
      int speed;
      int range;

      public Weapon(String type, int damage, int speed, int range) {
            this.type = type;
            this.damage = damage;
            this.speed = speed;
            this.range = range;
      }
}

interface CharacterFactory {
      Character createCharacter();
      Weapon createWeapon();
}

class WarriorSwordFactory implements CharacterFactory {
      @Override
      public Character createCharacter() {
            return new Character("Warrior", "Sword", new Weapon("Sword", 20, 10, 2), 100, 50);
      }

      @Override
      public Weapon createWeapon() {
            return new Weapon("Sword", 20, 10, 2);
      }
}

class MageStaffFactory implements CharacterFactory {
      @Override
      public Character createCharacter() {
            return new Character("Mage", "Staff", new Weapon("Staff", 15, 15, 5), 80, 100);
      }

      @Override
      public Weapon createWeapon() {
            return new Weapon("Staff", 15, 15, 5);
      }
}

class ArcherBowFactory implements CharacterFactory {
      @Override
      public Character createCharacter() {
            return new Character("Archer", "Bow", new Weapon("Bow", 25, 8, 10), 90, 70);
      }

      @Override
      public Weapon createWeapon() {
            return new Weapon("Bow", 25, 8, 10);
      }
}

class CharacterCreator {
      private CharacterFactory factory;

      public void setFactory(CharacterFactory factory) {
            this.factory = factory;
      }

      public Character createCharacter() {
            return factory.createCharacter();
      }
}




public class Ex4 {
      public static void main(String[] args) {
            CharacterCreator creator = new CharacterCreator();

            creator.setFactory(new WarriorSwordFactory());
            Character warrior = creator.createCharacter();
            Weapon warriorWeapon = warrior.weapon;

            System.out.println("Warrior:");
            System.out.println("Name: " + warrior.name);
            System.out.println("Class: " + warrior.characterClass);
            System.out.println("Health: " + warrior.health);
            System.out.println("Mana: " + warrior.mana);
            System.out.println("Weapon: " + warriorWeapon.type);
            System.out.println("Damage: " + warriorWeapon.damage);
            System.out.println("Speed: " + warriorWeapon.speed);
            System.out.println("Range: " + warriorWeapon.range);
            System.out.println();

            creator.setFactory(new MageStaffFactory());
            Character mage = creator.createCharacter();
            Weapon mageWeapon = mage.weapon;

            System.out.println("Mage:");
            System.out.println("Name: " + mage.name);
            System.out.println("Class: " + mage.characterClass);
            System.out.println("Health: " + mage.health);
            System.out.println("Mana: " + mage.mana);
            System.out.println("Weapon: " + mageWeapon.type);
            System.out.println("Damage: " + mageWeapon.damage);
            System.out.println("Speed: " + mageWeapon.speed);
            System.out.println("Range: " + mageWeapon.range);
            System.out.println();

            creator.setFactory(new ArcherBowFactory());
            Character archer = creator.createCharacter();
            Weapon archerWeapon = archer.weapon;

            System.out.println("Archer:");
            System.out.println("Name: " + archer.name);
            System.out.println("Class: " + archer.characterClass);
            System.out.println("Health: " + archer.health);
            System.out.println("Mana: " + archer.mana);
            System.out.println("Weapon: " + archerWeapon.type);
            System.out.println("Damage: " + archerWeapon.damage);
            System.out.println("Speed: " + archerWeapon.speed);
            System.out.println("Range: " + archerWeapon.range);
            System.out.println();
      }
}

