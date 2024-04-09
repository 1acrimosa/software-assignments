import java.util.List;

// NutritionPlan class
class NutritionPlan {
      private int caloricIntake;
      private int carbohydrateRatio;
      private int proteinRatio;
      private int fatRatio;
      private List<String> mealPlans;
      private String fitnessGoal;
      private List<String> dietaryRestrictions;

      public NutritionPlan(int caloricIntake, int carbohydrateRatio, int proteinRatio, int fatRatio, List<String> mealPlans, String fitnessGoal, List<String> dietaryRestrictions) {
            this.caloricIntake = caloricIntake;
            this.carbohydrateRatio = carbohydrateRatio;
            this.proteinRatio = proteinRatio;
            this.fatRatio = fatRatio;
            this.mealPlans = mealPlans;
            this.fitnessGoal = fitnessGoal;
            this.dietaryRestrictions = dietaryRestrictions;
      }

      public int getCaloricIntake() {
            return caloricIntake;
      }

      public void setCaloricIntake(int caloricIntake) {
            this.caloricIntake = caloricIntake;
      }
}

interface NutritionPlanBuilder {
      NutritionPlanBuilder setCaloricIntake(int caloricIntake);
      NutritionPlanBuilder setMacronutrientRatios(int carbohydrateRatio, int proteinRatio, int fatRatio);
      NutritionPlanBuilder setMealPlans(List<String> mealPlans);
      NutritionPlanBuilder setFitnessGoal(String fitnessGoal);
      NutritionPlanBuilder setDietaryRestrictions(List<String> dietaryRestrictions);
      NutritionPlan build();
}

class WeightLossNutritionPlanBuilder implements NutritionPlanBuilder {
      private int caloricIntake;
      private int carbohydrateRatio;
      private int proteinRatio;
      private int fatRatio;
      private List<String> mealPlans;
      private String fitnessGoal;
      private List<String> dietaryRestrictions;

      @Override
      public NutritionPlanBuilder setCaloricIntake(int caloricIntake) {
            this.caloricIntake = caloricIntake;
            return this;
      }

      @Override
      public NutritionPlanBuilder setMacronutrientRatios(int carbohydrateRatio, int proteinRatio, int fatRatio) {
            this.carbohydrateRatio = carbohydrateRatio;
            this.proteinRatio = proteinRatio;
            this.fatRatio = fatRatio;
            return this;
      }

      @Override
      public NutritionPlanBuilder setMealPlans(List<String> mealPlans) {
            this.mealPlans = mealPlans;
            return this;
      }

      @Override
      public NutritionPlanBuilder setFitnessGoal(String fitnessGoal) {
            this.fitnessGoal = fitnessGoal;
            return this;
      }

      @Override
      public NutritionPlanBuilder setDietaryRestrictions(List<String> dietaryRestrictions) {
            this.dietaryRestrictions = dietaryRestrictions;
            return this;
      }

      @Override
      public NutritionPlan build() {
            return new NutritionPlan(caloricIntake, carbohydrateRatio, proteinRatio, fatRatio, mealPlans, fitnessGoal, dietaryRestrictions);
      }
}

class NutritionPlanDirector {
      private NutritionPlanBuilder builder;

      public void setBuilder(NutritionPlanBuilder builder) {
            this.builder = builder;
      }

      public NutritionPlan createNutritionPlan() {
            return builder.build();
      }
}

// For testcases
public class Product {
      public static void main(String[] args) {
            NutritionPlanDirector director = new NutritionPlanDirector();
            WeightLossNutritionPlanBuilder builder = new WeightLossNutritionPlanBuilder();

            // Set builder for Weight Loss nutrition plan
            director.setBuilder(builder);

            // Build Nutrition Plan
            NutritionPlan nutritionPlan = director.createNutritionPlan();

            // Use the constructed Nutrition Plan
            System.out.println("Nutrition Plan created: " + nutritionPlan);
      }
}
