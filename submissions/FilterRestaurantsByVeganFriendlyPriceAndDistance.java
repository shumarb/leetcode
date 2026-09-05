// Question: https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/description/

class FilterRestaurantsByVeganFriendlyPrice {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int index = 0;
        int n = restaurants.length;
        int[][] valid = new int[n][5];

        for (int[] e: restaurants) {
            if (veganFriendly == 1 && e[2] == 0) {
                continue;
            }

            if (e[3] > maxPrice || e[4] > maxDistance) {
                continue;
            }

            valid[index++] = e;
        }

        Arrays.sort(valid,
                (a, b) -> Integer.compare(b[1], a[1]) == 0
                        ? Integer.compare(b[0], a[0])
                        : Integer.compare(b[1], a[1])
        );
        for (int i = 0; i < index; i++) {
            result.add(valid[i][0]);
        }
        if (isTest) {
            System.out.println("[vegan, maxPrice, Distance]: [" + veganFriendly + ", " + maxPrice + ", " + maxDistance + "]");
            print("\nrestaurants:", restaurants, n - 1);
            print("valid:", valid, index - 1);
            System.out.println("result: " + result);
        }

        return result;
    }

    private void print(String s, int[][] grid, int lastIndex) {
        System.out.println(s);
        for (int i = 0; i <= lastIndex; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("-----------------------------------------------------");
    }
}
