// Question: https://leetcode.com/problems/design-a-food-rating-system/description/

class FoodRatings {
    private Map<String, TreeSet<String>> cuisineFood;
    private Map<String, String> foodCuisine;
    private Map<String, Integer> foodRating;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFood = new HashMap<>();
        foodCuisine = new HashMap<>();
        foodRating = new HashMap<>();
        int n = foods.length;

        for (int i = 0; i < n; i++) {
            String cuisine = cuisines[i];
            String food = foods[i];
            int rating = ratings[i];

            foodCuisine.put(food, cuisine);
            foodRating.put(food, rating);
            if (!cuisineFood.containsKey(cuisine)) {
                TreeSet<String> foodTree = new TreeSet<>(
                        (a, b) -> Integer.compare(foodRating.get(b), foodRating.get(a)) == 0
                                ? a.compareTo(b)
                                : Integer.compare(foodRating.get(b), foodRating.get(a))
                );
                foodTree.add(food);
                cuisineFood.put(cuisine, foodTree);
            } else {
                TreeSet<String> foodTree = cuisineFood.get(cuisine);
                foodTree.add(food);
                cuisineFood.put(cuisine, foodTree);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        if (foodCuisine.containsKey(food)) {
            String cuisine = foodCuisine.get(food);
            Set<String> foodTree = cuisineFood.get(cuisine);
            foodTree.remove(food);
            foodRating.put(food, newRating);
            foodTree.add(food);
        }
    }

    public String highestRated(String cuisine) {
        return cuisineFood.containsKey(cuisine) ? cuisineFood.get(cuisine).first() : null;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */