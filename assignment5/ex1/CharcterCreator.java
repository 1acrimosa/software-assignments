public class CharacterCreator {
      private CharacterFactory factory;

      public void setFactory(CharacterFactory factory) {
            this.factory = factory;
      }

      public Character createCharacter(String name) {
            if (factory == null) {
                  throw new IllegalStateException("Factory not set");
            }
            return factory.createCharacter(name);
      }
}
