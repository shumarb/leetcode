// Question: https://leetcode.com/problems/design-a-food-rating-system/description/

class FoodRatings {
    private Map<String, TreeSet<String>> cuisineFood;
    private Map<String, String> foodCuisine;
    private Map<String, Integer> foodRating;
    private boolean isTest;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFood = new HashMap<>();
        foodCuisine = new HashMap<>();
        foodRating = new HashMap<>();
        isTest = false;
        int n = foods.length;

        for (int i = 0; i < n; i++) {
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
            if (!cuisineFood.containsKey(cuisines[i])) {
                TreeSet<String> foodTree = new TreeSet<>(
                        (a, b) -> Integer.compare(foodRating.get(b), foodRating.get(a)) == 0
                                ? a.compareTo(b)
                                : Integer.compare(foodRating.get(b), foodRating.get(a))
                );
                foodTree.add(foods[i]);
                cuisineFood.put(cuisines[i], foodTree);
            } else {
                TreeSet<String> foodTree = cuisineFood.get(cuisines[i]);
                foodTree.add(foods[i]);
                cuisineFood.put(cuisines[i], foodTree);
            }
        }

        if (isTest) {
            System.out.println("foodCuisine: " + foodCuisine + "\nfoodRating: " + foodRating);
            System.out.println("cuisineFood:");
            for (Map.Entry<String, TreeSet<String>> e: cuisineFood.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-------------------------------------------------");
        }
    }

    public void changeRating(String food, int newRating) {
        if (isTest) {
            System.out.println(" * changeRating | food: " + food + ", newRating:" + newRating);
            System.out.println("\n before, foodRating: " + foodRating);
        }
        if (foodCuisine.containsKey(food)) {
            String cuisine = foodCuisine.get(food);
            Set<String> foodTree = cuisineFood.get(cuisine);
            foodTree.remove(food);
            foodRating.put(food, newRating);
            foodTree.add(food);
        }
        if (isTest) {
            System.out.println("\n after, foodRating: " + foodRating);
            System.out.println("-------------------------------------------------");
        }
    }

    public String highestRated(String cuisine) {
        if (isTest) {
            System.out.println(" * highest rated | cuisine: " + cuisine);
            System.out.println("cuisineFood:");
            for (Map.Entry<String, TreeSet<String>> e: cuisineFood.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-------------------------------------------------");
        }

        return cuisineFood.containsKey(cuisine) ? cuisineFood.get(cuisine).first() : null;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */