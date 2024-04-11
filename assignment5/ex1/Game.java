public class Game {
      public static void main(String[] args) {
            CharacterCreator creator = new CharacterCreator();
            creator.setFactory(new WarriorFactory());
            Character warrior = creator.createCharacter("Warrior1");

            creator.setFactory(new MageFactory());
            Character mage = creator.createCharacter("Mage1");

            creator.setFactory(new ArcherFactory());
            Character archer = creator.createCharacter("Archer1");
      }
}
